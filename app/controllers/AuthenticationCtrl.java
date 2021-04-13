package controllers;

import com.google.inject.Inject;

import models.tables.pojos.Users;
import play.api.Configuration;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Http.Request;
import play.mvc.Result;
import static play.mvc.Results.redirect;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import services.AssistanceService;
import services.UserService;
import utils.BCryptHash;
import utils.ViewMode;
import views.html.*;

/**
 * 
 * @author nasser
 *
 */
public class AuthenticationCtrl extends Controller {

	private final UserService userService;
	private final AssistanceService assistanceService;
	private final FormFactory formFactory;

	// @Inject
	// private Helpers helpers;

	@Inject
	public AuthenticationCtrl(FormFactory formFactory, UserService userService, AssistanceService assistanceService) {
		this.userService = userService;
		this.formFactory = formFactory;
		this.assistanceService=assistanceService;

	}

	public Result login(Request request) {
		return ok(index.render(request));
	}
	
	public Result initPassForm(String login, Request request) {
				//String.valueOf(request.session().get("login").get());
		Users u=userService.getUserByLogin(login);
		return ok(iform.render(u, request));
	}
	
	
	
	
	public Result changepass(Request request) {
		/*if (!isAdmin(request)) {
			return redirect(routes.AuthenticationCtrl.logout());
		}*/
		final String npass = formFactory.form().bindFromRequest(request).get("npasse");
		final String rnpass = formFactory.form().bindFromRequest(request).get("rnpasse");
		final String porte = formFactory.form().bindFromRequest(request).get("por");
		final String bat = formFactory.form().bindFromRequest(request).get("bat");
		final String dir = formFactory.form().bindFromRequest(request).get("dir");
		final String niv = formFactory.form().bindFromRequest(request).get("niv");
		final String login = formFactory.form().bindFromRequest(request).get("log");
		
		Users u=userService.getUserByLogin(login);
		//u.setLocalisation("Batiment "+bat+", niveua "+niv+", porte "+porte);
		u.setBatiment(bat);
		u.setNiveau(niv);
		u.setPorte(porte);
		u.setDirection(dir);
		
		if (BCryptHash.checkPassword("1234", userService.getUserByLogin(login).getPasse())) {
			if(npass.equals(rnpass)){
				u.setPasse(npass);
				if(userService.saveLogical(u, false).equals("ok")){
					return redirect(routes.AuthenticationCtrl.logout()).flashing("success",
							"Mot de passe change");
				}else{
					return redirect(routes.AuthenticationCtrl.initPassForm(u.getLogin())).flashing("error",
							"Erreur changement mot de passe"+userService.saveLogical(u, false));
				}
			}else{
				return redirect(routes.AuthenticationCtrl.initPassForm(u.getLogin())).flashing("error",
						"Les 2 mot de passe sont pas les meme");
			}
		}else{
			return redirect(routes.AuthenticationCtrl.initPassForm(u.getLogin())).flashing("error",
					"Ancienne mot de passe incorrect ");
		}
		
		
	}
	
	
	

	public Result authentification(Request request) {

		LocalDateTime now = LocalDateTime.now();
		String now_string = now.format(DateTimeFormatter.ofPattern("MM"));

		Integer a = Integer.valueOf(now_string);
		// System.out.println(now_string +" + "+a);

		if (a >= 13) {
			// flash("error", "Connexion Impossible, si ce problème persiste veillez
			// contacter le service Informatique!!!");
			return redirect(controllers.routes.AuthenticationCtrl.login()).flashing("error",
					"Connexion Impossible, si ce problème persiste veillez contacter le service Informatique!!!");
			// return TODO;
		} else {
			Form<Users> form = formFactory.form(Users.class).bindFromRequest(request);

			if (form.hasErrors()) {
				// flash("error", " Erreur de saisie");
				return redirect(controllers.routes.AuthenticationCtrl.login()).flashing("error", " Erreur de saisie");
			} else {

				Users u = form.get();
				Users us = new Users();
				if(userService.isUserExist(u.getLogin())){
				if (BCryptHash.checkPassword(u.getPasse(), userService.getUserByLogin(u.getLogin()).getPasse())) {
					String password = userService.getUserByLogin(u.getLogin()).getPasse();
					us = userService.authentification(u.getLogin(), password);
				} else
					us = null;
				}else{
					us=null;
				}
				
				
				if (us == null) {
					return redirect(controllers.routes.AuthenticationCtrl.login()).flashing("error",
							" Erreur de saisie, Login ou Mot de Passe Incorrect!!!");
				} else {
					
					if (BCryptHash.checkPassword("1234", userService.getUserByLogin(u.getLogin()).getPasse())) {
						return redirect(routes.AuthenticationCtrl.initPassForm(u.getLogin()));
					}
				
					
					
					return redirect(routes.AssistanceCtrl.enter(assistanceService.count()/*us.getDroit()*/)).removingFromSession(request, "droit")
							.addingToSession(request, "droit", us.getDroit()).removingFromSession(request, "login")
							.addingToSession(request, "login", us.getLogin()).removingFromSession(request, "nomUser")
							.addingToSession(request, "nomUser", us.getNomPrenom()).removingFromSession(request, "countAssistance")
							.addingToSession(request, "countAssistance", assistanceService.count()+"");
				}
			}
		}
	}

	public Result logout(Request request) {
		// session().clear();
		// flash("success", "Vous etes déconnecté(e)");
		return redirect(controllers.routes.AuthenticationCtrl.login()).withNewSession().flashing("success",
				" Vous etes déconnecté(e)");
	}

	/*
	 * public static class AuthenticatedUser { public String login; public String
	 * password;
	 * 
	 * public String validate() { if (User.authenticate(login, password) == null) {
	 * return "oups! Essaye encore une fois"; } return null; }
	 * 
	 * }
	 * 
	 * public Result login() { return ok(login.render("form")); }
	 * 
	 * public Result authenticate() {
	 * 
	 * //Form<AuthenticatedUser> loginForm =
	 * formFactory.form(AuthenticatedUser.class).bindFromRequest(); session("login",
	 * "user"); return redirect("/compagnie/form");
	 * 
	 * if (loginForm.hasErrors()) { return badRequest(login.render(loginForm)); }
	 * else { session("email", loginForm.get().email); return
	 * redirect(routes.Application.index()); }
	 * 
	 * }
	 * 
	 * // Fermer la session public static Result logout() { session().clear();
	 * flash("success", "Vous etes déconnecté(e)"); return
	 * redirect("routes.Authentication.login()"); }
	 */
}
