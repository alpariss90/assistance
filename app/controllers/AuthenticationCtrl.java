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
	private final FormFactory formFactory;

	// @Inject
	// private Helpers helpers;

	@Inject
	public AuthenticationCtrl(FormFactory formFactory, UserService userService) {
		this.userService = userService;
		this.formFactory = formFactory;

	}

	public Result login(Request request) {
		return ok(index.render(request));
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
				// System.out.println(u);
				// System.out.println("paass saisie :" + u.getPasse() + " pass get :"+
				// userService.getUserByLogin(u.getLogin()).getPasse()+ " status :"+
				// BCryptHash.checkPassword(u.getPasse(),
				// userService.getUserByLogin(u.getLogin()).getPasse()));
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
					// flash("error", "wrong email/password");
					return redirect(controllers.routes.AuthenticationCtrl.login()).flashing("error",
							" Erreur de saisie, Login ou Mot de Passe Incorrect!!!");
				} else {
					// System.out.println("Le User connecter est: "+ us);
//					session("login", (us.getLogin()));
//					session("droit", (us.getDroit()));
//					session("nomUser", (us.getNomPrenom()));
//				
				

					return redirect(routes.UserCtrl.index(/*us.getDroit()*/)).removingFromSession(request, "droit")
							.addingToSession(request, "droit", us.getDroit()).removingFromSession(request, "login")
							.addingToSession(request, "login", us.getLogin()).removingFromSession(request, "nomUser")
							.addingToSession(request, "nomUser", us.getNomPrenom());
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
