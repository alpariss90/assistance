/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.inject.Inject;

import models.tables.pojos.Users;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

import play.data.FormFactory;
import play.mvc.*;
import play.mvc.Http.Request;
import static play.mvc.Results.ok;
import play.data.DynamicForm;
import play.data.Form;
import services.UserService;
import utils.BCryptHash;
import utils.Secured;
import utils.ViewMode;
import views.html.*;

/**
 *
 * @author anasser
 */
@Security.Authenticated(Secured.class)
public class UserCtrl extends Controller {

	private final FormFactory formFactory;
	private final UserService userService;
	@Inject
	public UserCtrl(FormFactory formFactory, UserService userService) {
		this.userService = userService;
		this.formFactory = formFactory;
		
	}

	public Result index(Request request) {
		if (!isAdmin(request)) {
			return redirect(routes.AuthenticationCtrl.logout());
		}
		//return redirect(routes.UserCtrl.show(ViewMode.VIEW_MODE_CREATE, ""));
		return redirect(routes.UserCtrl.liste(0, ""));
	}

	public Result show(String subAction, String login, Request request) {

		if (!isAdmin(request)) {
			return redirect(routes.AuthenticationCtrl.logout());
		}
		String viewMode;
		Users a;
		List<Users> users = userService.getAllUser();
		if (null == login || login.equals("")) {
			a = new Users();
			viewMode = ViewMode.VIEW_MODE_CREATE;
		} else if (ViewMode.VIEW_MODE_EDIT.equals(subAction)) {
			a = userService.getUserByLogin(login);
			viewMode = ViewMode.VIEW_MODE_EDIT;
		} else if (ViewMode.VIEW_MODE_DELETE.equals(subAction)) {
			a = userService.getUserByLogin(login);
			viewMode = ViewMode.VIEW_MODE_DELETE;
		} else {
			viewMode = ViewMode.VIEW_MODE_VIEW;
			a = userService.getUserByLogin(login);

		}
		return ok(views.html.fusers.render(viewMode, users, a,request));

	}
	
	public Result liste(int page, String filter, Request request) {
		if (!isAdmin(request)) {
			return redirect(routes.AuthenticationCtrl.logout());
		}
		return ok(views.html.users.render(userService.page(page, 10, filter), filter, request));
	}
	
	public Result fchangepass(String login, Request request) {
		Users user = userService.getUserByLogin(login);
		return ok(views.html.changepass.render(user, request));
	}

	public Result save(Request request) {
		if (!isAdmin(request)) {
			return redirect(routes.AuthenticationCtrl.logout());
		}
		final String viewMode = formFactory.form().bindFromRequest(request).get("viewMode");
		final String login = formFactory.form().bindFromRequest(request).get("log");
		Form<Users> uForm = formFactory.form(Users.class).bindFromRequest(request);
		Users a = uForm.get();
		//Personnels p = new Personnels();
		if (userService.isUserExist(a.getLogin())) {
			
			return redirect(routes.UserCtrl.show(ViewMode.VIEW_MODE_CREATE, "")).flashing("error", "utilisateur avec login " + a.getLogin() + " existe déja ");
		}
		a.setWhenDone((LocalDateTime.now().withSecond(0).withMinute(0).withHour(0).withNano(0)));
		a.setWhoDone(String.valueOf(request.session().get("login").get()));
		if (viewMode.equals(ViewMode.VIEW_MODE_CREATE)) {
			if (userService.saveLogical(a, true).equals("ok")) {
				
				//return redirect(routes.UserCtrl.show(ViewMode.VIEW_MODE_CREATE, "")).flashing("success", "utilisateur " + a.getLogin() + " ajouter avec success");
				return redirect(routes.UserCtrl.liste(0, "")).flashing("success", "utilisateur " + a.getLogin() + " ajouter avec success");
			} else {
				
				return redirect(routes.UserCtrl.liste(0, "")).flashing("error", "utilisateur " + userService.saveLogical(a, true) + " non ajouter ");
			}
		} else if (viewMode.equals(ViewMode.VIEW_MODE_EDIT)) {
			a.setLogin(login);
			if (userService.saveLogical(a, false).equals("ok")) {
				
				return redirect(routes.UserCtrl.liste(0, "")).flashing("success", "utilisateur " + a.getLogin() + " modifier avec success");
			} else {
				
				return redirect(routes.UserCtrl.liste(0, "")).flashing("error", "utilisateur " + userService.saveLogical(a, false) + " non modifier");
			}
		}
		return redirect(routes.UserCtrl.liste(0, ""));
	}

	
	
	

	public Result changepass(Request request) {
		/*if (!isAdmin(request)) {
			return redirect(routes.AuthenticationCtrl.logout());
		}*/
		final String apass = formFactory.form().bindFromRequest(request).get("apasse");
		final String npass = formFactory.form().bindFromRequest(request).get("npasse");
		final String rnpass = formFactory.form().bindFromRequest(request).get("rnpasse");
		final String login = formFactory.form().bindFromRequest(request).get("log");
		
		Users u=userService.getUserByLogin(login);
		
		if (BCryptHash.checkPassword(apass, userService.getUserByLogin(login).getPasse())) {
			if(npass.equals(rnpass)){
				u.setPasse(npass);
				if(userService.saveLogical(u, false).equals("ok")){
					return redirect(routes.UserCtrl.index()).flashing("success",
							"Mot de passe change");
				}else{
					return redirect(routes.UserCtrl.index()).flashing("error",
							"Erreur changement mot de passe"+userService.saveLogical(u, false));
				}
			}else{
				return redirect(routes.UserCtrl.index()).flashing("error",
						"Les 2 mot de passe sont pas les meme");
			}
		}else{
			return redirect(routes.UserCtrl.index()).flashing("error",
					"Ancienne mot de passe incorrect ");
		}
		
		
	}

	public Result delete(String login, boolean etat, Request request) {
		if (!isAdmin(request)) {
			return redirect(routes.AuthenticationCtrl.logout());
		}
		if (userService.ChangeEtat(login, etat).equals("ok")) {

			return redirect(routes.UserCtrl.liste(0, "")).flashing("success",
					"état utilisateur " + login + " changé avec success");
		} else {

			return redirect(routes.UserCtrl.liste(0, "")).flashing("error",
					"état utilisateur " + userService.ChangeEtat(login, etat) + " non changé");
		}
	}
	
	public Result init(String login, Request request) {
		if (!isAdmin(request)) {
			return redirect(routes.AuthenticationCtrl.logout());
		}
		Users u=userService.getUserByLogin(login);
		u.setPasse("1234");
		if (userService.saveLogical(u, false).equals("ok")) {

			return redirect(routes.UserCtrl.liste(0, "")).flashing("success",
					"mot de passe utilisateur " + login + " reinitialisé avec success");
		} else {

			return redirect(routes.UserCtrl.liste(0, "")).flashing("error",
					"émot de passe utilisateur " + userService.saveLogical(u, false) + " non reinitialisé avec success");
		}
	}

	private boolean isAdmin(Request request) {
		return String.valueOf(request.session().get("droit").get()).equals("Admin");
	}

}
