/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.google.inject.Inject;

import commons.Pagination;

import java.util.List;

import org.jooq.Configuration;

import models.Tables;
import models.tables.daos.UsersDao;
import models.tables.pojos.Users;
import models.tables.pojos.Users;
import utils.BCryptHash;
import utils.IConnectionHelper;

/**
 * 
 * @author nasser
 *
 */
public class UserService extends UsersDao {

	private final IConnectionHelper con;

	@Inject
	public UserService(IConnectionHelper con) {
		super();
		this.con = con;
		setConfiguration(con.connection().configuration());
	}

	public String saveLogical(Users u, boolean b) {
		
		Users user = new Users();
		user.setNomPrenom(u.getNomPrenom());
		user.setLogin(u.getLogin());
		user.setDroit(u.getDroit());
		//user.setEtat(u.getEtat());
		//user.setPasse(BCryptHash.hashPassword(u.getPasse()));
		user.setWhenDone(u.getWhenDone());
		user.setWhoDone(u.getWhoDone());
		user.setBatiment(u.getBatiment());
		user.setNiveau(u.getNiveau());
		user.setPorte(u.getPorte());
		user.setDirection(u.getDirection());
		user.setNomPrenom(u.getNomPrenom());
		
		try {
			if (b){
				user.setEtat(false);
				user.setPasse(BCryptHash.hashPassword("1234"));
				super.insert(user);
			}
			else{
				user.setEtat(u.getEtat());
				user.setPasse(BCryptHash.hashPassword(u.getPasse()));
				super.update(user);
			}
				
			return "ok";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String deleteUser(String login) {
		try {
			super.delete(getUserByLogin(login));
			return "ok";
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	public String ChangeEtat(String login, boolean etat) {
		Users u = getUserByLogin(login);
		u.setEtat(etat);
		try {
			super.update(u);
			return "ok";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public List<Users> getAllUser() {
		return super.findAll();
	}

	public Users getUserByLogin(String login) {
		if(isUserExist(login))
			return con.connection().selectFrom(Tables.USERS).where(Tables.USERS.LOGIN.eq(login)).fetchOneInto(Users.class);
		else
			return new Users();
	}

	public Users authentification(String login, String password) {

		return con.connection().selectFrom(Tables.USERS).where(Tables.USERS.LOGIN.eq(login))
				.and(Tables.USERS.PASSE.eq(password)).and(Tables.USERS.ETAT.eq(true)).fetchOneInto(Users.class);

	}

	public boolean isUserExist(String libelle) {
		List<Users> users = super.fetchByLogin(libelle);
		return users.size() > 0;
	}
	
	 public Pagination<Users> page(int page, int pageSize, String filter) {
	        // TODO Auto-generated method stub
	        if (page < 1) page = 1;
	        
	        Long total = con.connection().selectCount()
	                .from(Tables.USERS).where(Tables.USERS.LOGIN.lower().like('%' + filter.toLowerCase() + '%')
	                        		 .or(Tables.USERS.NOM_PRENOM.like('%' + filter + '%')))
	                .fetchAny(0, Long.class);
	        
	        List<Users> data = con.connection().selectFrom(Tables.USERS).
	        		where(Tables.USERS.LOGIN.lower().like('%' + filter.toLowerCase() + '%')
                   		 .or(Tables.USERS.NOM_PRENOM.like('%' + filter + '%')))
	        						.offset((page - 1) * pageSize).limit(pageSize)
	        						.fetchInto(Users.class);

	        return new Pagination<>(data, total, page, pageSize);
	    }
	
	
	
}
