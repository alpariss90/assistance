/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import akka.Main;

import com.google.inject.Inject;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import models.tables.pojos.Assistance;
import models.tables.pojos.Users;
import models.tables.pojos.VAssistance;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.*;
import play.mvc.Http.Request;
import play.mvc.Http.Session;
import static play.mvc.Results.ok;
import play.data.DynamicForm;
import play.data.Form;
import services.AssistanceService;
import services.UserService;
import utils.BCryptHash;
import utils.CallJasperReport;
import utils.Secured;
import utils.ViewMode;
import views.html.*;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author anasser
 */
@Security.Authenticated(Secured.class)
public class AssistanceCtrl extends Controller {

	private final FormFactory formFactory;
	private final AssistanceService assistanceService;
	private final UserService userService;
	private Long coun;
	CallJasperReport jasper;
	 
	@Inject
	public AssistanceCtrl(FormFactory formFactory, AssistanceService assistanceService, UserService userService, CallJasperReport jasper) {
		this.assistanceService = assistanceService;
		this.userService=userService;
		this.formFactory = formFactory;
		this.jasper=jasper;
		
	}

	public Result index(Request request) {
		return redirect(routes.AssistanceCtrl.liste());
	}
	
	public Result indexPlusMaj(Request request) {
		assistanceService.setOkOnNewAlert();
		return redirect(routes.AssistanceCtrl.liste());
	}
	
	public Result enter(Long co, Request request) {
		coun=co;
		return redirect(routes.AssistanceCtrl.index());
	}
	
	public Result alert(String login, Request request) {
		return ok(views.html.alert.render(login, request));
	}
	
	public Result observations(Long id, Request request) {
		VAssistance v=assistanceService.getByid(id);
		return ok(views.html.observations.render(v, request));
	}

	
	
	public Result liste(Request request) {
		String droit=String.valueOf(request.session().get("droit").get());
		
		List<VAssistance> assistances;
		
		
		
		if(droit.equals("Admin"))
			assistances=assistanceService.getAll();
		else
			assistances=assistanceService.getByDeclarant(String.valueOf(request.session().get("login").get()));
		
		return ok(views.html.assistances.render(assistances, request));
	}
	
	
	public Result saveAlert(Request request) {
		if (isAdmin(request)) {
			return redirect(routes.AuthenticationCtrl.logout());
		}

		final String login = formFactory.form().bindFromRequest(request).get("log");
		
		if(!assistanceService.isDeclarantAllOk(login)){
			return redirect(routes.AssistanceCtrl.liste()).flashing("error", "Erreur enregistrement de la demande, veuillez d'abord validé toutes les demandes effectuées");
		}
		
		Form<Assistance> uForm = formFactory.form(Assistance.class).bindFromRequest(request);
		Assistance a = uForm.get();
		
		a.setDeclarant(login);
		a.setWhenDone((LocalDateTime.now().withSecond(0).withMinute(0).withHour(0).withNano(0)));
		a.setIsClose(false);
		a.setIsOk(false);
		a.setNewCreate(true);
		
		
		
		
			if (assistanceService.save(a).equals("ok")) {
				return redirect(routes.AssistanceCtrl.liste()).flashing("success", "votre demande d'assistance a été enregistrer, un maintainancier va prendre votre demande bientot");
			} else {
				
				return redirect(routes.AssistanceCtrl.liste()).flashing("error", "Erreur enregistrement de la demande d'assistance, veuillez contacter la DI");
			}
		
	}
	
	public Result saveObs(Request request) {
		if (!isAdmin(request)) {
			return redirect(routes.AuthenticationCtrl.logout());
		}

		//final String login = formFactory.form().bindFromRequest(request).get("id");
		Form<Assistance> uForm = formFactory.form(Assistance.class).bindFromRequest(request);
		Assistance a = uForm.get();
		
	
		
		Assistance as=assistanceService.getParId(a.getId());
		
		as.setMaintenacier(String.valueOf(request.session().get("login").get()));
		as.setWhenClose((LocalDateTime.now().withSecond(0).withMinute(0).withHour(0).withNano(0)));
		as.setIsClose(true);
		as.setObservations(a.getObservations());
		
		
			if (assistanceService.edit(as).equals("ok")) {
				return redirect(routes.AssistanceCtrl.observations(a.getId())).flashing("success", "Observations enregistrées");
			} else {
				
				return redirect(routes.AssistanceCtrl.observations(a.getId())).flashing("error", "Observations non enregistrées");
			}
		
	}
	
	
	public Result okAgent(Long id, Request request) {
		if (isAdmin(request)) {
			return redirect(routes.AuthenticationCtrl.logout());
		}
		
		
		

		Assistance as=assistanceService.getParId(id);
		
		as.setWhenOk((LocalDateTime.now().withSecond(0).withMinute(0).withHour(0).withNano(0)));
		as.setIsOk(true);
		
		
			if (assistanceService.edit(as).equals("ok")) {
				return redirect(routes.AssistanceCtrl.liste()).flashing("success", "confirmation enregistrées");
			} else {
				
				return redirect(routes.AssistanceCtrl.liste()).flashing("error", "confirmation non enregistrées");
			}
		
	}
	
	public Result reouvrir(Long id, Request request) {
		if (isAdmin(request)) {
			return redirect(routes.AuthenticationCtrl.logout());
		}
		
		Assistance as=assistanceService.getParId(id);
		Assistance a=new Assistance();
		
		a.setDeclarant(as.getDeclarant());
		a.setWhenDone((LocalDateTime.now().withSecond(0).withMinute(0).withHour(0).withNano(0)));
		a.setIsClose(false);
		a.setIsOk(false);
		a.setNewCreate(true);
		a.setMotif(as.getMotif());
		

		if (assistanceService.save(a).equals("ok")) {
			return redirect(routes.AssistanceCtrl.liste()).flashing("success", "votre demande d'assistance a été enregistrer, un maintainancier va prendre votre demande bientot");
		} else {
			
			return redirect(routes.AssistanceCtrl.liste()).flashing("error", "Erreur enregistrement de la demande d'assistance, veuillez contacter la DI");
		}
		
	}
	
	public Result delObs(Long id, Request request) {
		
		Assistance a=assistanceService.getParId(id);
		
		
		if (!isAdmin(request) || !String.valueOf(request.session().get("login").get()).equals(a.getMaintenacier())) {
			return redirect(routes.AuthenticationCtrl.logout());
		}

		a.setObservations("");
		
			if (assistanceService.edit(a).equals("ok")) {
				return redirect(routes.AssistanceCtrl.observations(a.getId())).flashing("success", "Observations supprimer");
			} else {
				
				return redirect(routes.AssistanceCtrl.observations(a.getId())).flashing("error", "Observations non supprimer");
			}
		
	}
	
	
	
	private boolean isAdmin(Request request) {
		return String.valueOf(request.session().get("droit").get()).equals("Admin");
	}
	
	private  synchronized void playSound(final String url) {
		
		
		//new Thread(new Runnable() {
		  // The wrapper thread is unnecessary, unless it blocks on the
		  // Clip finishing; see comments.
		    //public void run() {
		/*System.out.println(url);
		      try {
		        Clip clip = AudioSystem.getClip();
		        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
		          Main.class.getResourceAsStream(url));
		        clip.open(inputStream);
		        clip.start(); 
		      } catch (Exception e) {
		        System.err.println(e.getMessage());
		      }*/
		    //}
		  //}).start();
		}
	
	private void playAudio(String path){
		File audioFile = new File(path);
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			
			AudioFormat format = audioStream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			
			Clip audioClip = (Clip) AudioSystem.getLine(info);
			
			//audioClip.open(audioStream);
			//audioClip.start();
			
			//audioClip.close();
			//audioStream.close();
		} catch (Exception e) {
			System.out.println("Errerurr "+e.getMessage());
		}
		
		
	}
	
	
	 public Result getCount(Request request) {
	     
		 
		 Long v=0L;
		 
		   Long count=assistanceService.getCountNew();
	        HashMap<String, Long> response = new HashMap<>();
	        
	      
	        
	        if(request.session().get("droit").get().equals("Admin")){
	        	  System.out.println(count+"++");
	        	//System.out.println(coun+" "+count);
	        	 if(count > 0){
	 	        	v=1L;
	 	        	playAudio(new File("").getAbsolutePath() + "/reports/spool/ff.wav");
	 	        	//coun=count;
	 	        }
	        }
	       
	        
	        //List<Object> lb=new ArrayList();
	        //lb.add(c);
	        //lb.add(tc);
	        response.put("options", v);
	        return ok(Json.toJson(response));
			
		
					
	    }
	
	 
	 
	 public Result mpFileForm(Request request) {
			return ok(views.html.mpFileForm.render(request));
		}
	 
	 public Result fsituation(Request request) {
			return ok(views.html.situation.render(request));
		}
	 
	 public Result downloadSituation(Request request) {
			
			if (!isAdmin(request)) {
				return redirect(routes.AuthenticationCtrl.logout());
			}
				
				final String dds=formFactory.form().bindFromRequest(request).get("date_db");
				final String dfs=formFactory.form().bindFromRequest(request).get("date_fn");

				
				
				if(stringToLocalDAte(dds).isAfter(stringToLocalDAte(dfs))){
					return redirect(routes.AssistanceCtrl.fsituation()).
							flashing("error", "date début "+dds+" doit être superieur date fin "+dfs);
				}
				
				
				LocalDateTime now = LocalDateTime.now();
				String now_string = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm"));
				String templateDir = new File("").getAbsolutePath() + "/reports/spool/";
				
				try {
					jasper.generateReportSituation("assis", Timestamp.valueOf(stringToLocalDAte(dds)), Timestamp.valueOf(stringToLocalDAte(dfs)));
					return ok(new java.io.File(templateDir + "assis" + "_" + now_string + "_.pdf"))
							.flashing("success", "impression ok");

				} catch (Exception e) {
					// flash("error", "erreur impression");
					System.out.println(e.getMessage() + "+++++++--**///////++++++++");
					return redirect(routes.AssistanceCtrl.fsituation())
							.flashing("error",  "Erreur impression");
				}
				
				
				
				
	
			}
			
	 
	 
	 public Result downloadFiche(Long id, Request request) {
			
			if (!isAdmin(request)) {
				return redirect(routes.AuthenticationCtrl.logout());
			}
				
			
				
				
				LocalDateTime now = LocalDateTime.now();
				String now_string = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm"));
				String templateDir = new File("").getAbsolutePath() + "/reports/spool/";
				
				try {
					jasper.generateReportFiche("fiche", id);
					return ok(new java.io.File(templateDir + "fiche" + "_" + now_string + "_.pdf"))
							.flashing("success", "impression ok");

				} catch (Exception e) {
					// flash("error", "erreur impression");
					System.out.println(e.getMessage() + "+++++++--**///////++++++++");
					return redirect(routes.AssistanceCtrl.fsituation())
							.flashing("error",  "Erreur impression");
				}
				
				
				
				
	
			}
			
	 
	 private LocalDateTime stringToLocalDAte(String dt){
			System.out.println("date++++++++++++++"+dt);
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy H:mm");
			//String date = "16/08/2016 0:00";

			//convert String to LocalDate
			LocalDateTime localDate = LocalDateTime.parse(dt+" 0:00", formatter);

			return localDate;
		}
	 
	 
	 public static Timestamp convertStringToTimestamp(String strDate) {
		    try {
		      DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		       // you can change format of date
		      Date date = formatter.parse(strDate);
		      Timestamp timeStampDate = new Timestamp(date.getTime());

		      return timeStampDate;
		    } catch (ParseException e) {
		      System.out.println("Exception :" + e);
		      return null;
		    }
		  }
	

}
