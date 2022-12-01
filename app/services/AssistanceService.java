 package services;

import java.util.ArrayList;
import java.util.List;

import org.jooq.False;

import models.Tables;
import models.tables.daos.AssistanceDao;
import models.tables.pojos.Assistance;
import models.tables.pojos.VAssistance;
import utils.IConnectionHelper;

import com.google.inject.Inject;

import commons.Pagination;


public class AssistanceService extends AssistanceDao {

	private final IConnectionHelper con;

	@Inject
	public AssistanceService(IConnectionHelper con) {
		super();
		this.con = con;
		setConfiguration(con.connection().configuration());
	}

	/**
	 * Cette methode de persister un objet direction dans la base
	 */
	public String save(Assistance t) {
		try {
			super.insert(t);
			con.connection().close();
			return "ok";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	/**
	 * Cette methode permet de mettre à jour un objet direction dans la base
	 */
	public String edit(Assistance p) {
		try {
			
			super.update(p);
			con.connection().close();
			return "ok";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	/**
	 * Cette methode permet de recuperer la liste de tout les objets direction qui ne sont pas supprimer
	 */
	public List<VAssistance> getAll(){
		List<VAssistance> lb= con.connection().selectFrom(Tables.V_ASSISTANCE)
				.orderBy(Tables.V_ASSISTANCE.ID.desc())
				.fetchInto(VAssistance.class);
		con.connection().close();
		return lb;
	}
	
	public void setOkOnNewAlert(){
		con.connection().update(Tables.ASSISTANCE)
		.set(Tables.ASSISTANCE.NEW_CREATE, false)
		.where(Tables.ASSISTANCE.NEW_CREATE.isTrue())
		.execute();
		con.connection().close();
	}
	
	
	/**
	 * Cette methode permet de recuperer la liste de tout les objets direction qui ne sont pas supprimer
	 */
	public List<VAssistance> getByDeclarant(String login){
		List<VAssistance> lb= con.connection().selectFrom(Tables.V_ASSISTANCE)
				.where(Tables.V_ASSISTANCE.DECLARANT.equal(login))
				.orderBy(Tables.V_ASSISTANCE.ID.desc())
				.fetchInto(VAssistance.class);
		con.connection().close();
		return lb;
	}
	
	public boolean isDeclarantAllOk(String login){
		List<VAssistance> vs=getByDeclarant(login);
		boolean b=true;
		for (VAssistance vAssistance : vs) {
			if(vAssistance.getIsClose() && !vAssistance.getIsOk()){
				b=false;
			}
		}
		return b;
	}
	
	
	
	/**
	 * Cette methode permet de recuperer la liste de tout les objets direction qui ne sont pas supprimer
	 */
	public List<VAssistance> getByMaintenancier(String login){
		List<VAssistance> lb= con.connection().selectFrom(Tables.V_ASSISTANCE)
				.where(Tables.V_ASSISTANCE.MAINTENACIER.equal(login))
				.fetchInto(VAssistance.class);
		con.connection().close();
		return lb;
	}
	

	/**
	 * Cette methode permet de recuperer un objet direction avec id id s'il existe et s'il n'est pas supprimer
	 */
	public VAssistance getByid(Long id) {
		VAssistance b= con.connection().selectFrom(Tables.V_ASSISTANCE)
				//.where(Tables.ASSISTANCE.DELETED.isFalse())
				.where(Tables.V_ASSISTANCE.ID.equal(id))
				.fetchOneInto(VAssistance.class);
		con.connection().close();
		return b;
	}
	
	public Assistance getParId(Long id) {
		Assistance b= con.connection().selectFrom(Tables.ASSISTANCE)
				//.where(Tables.ASSISTANCE.DELETED.isFalse())
				.where(Tables.ASSISTANCE.ID.equal(id))
				.fetchOneInto(Assistance.class);
		con.connection().close();
		return b;
	}


	
	
	 public Long getCount(){
		 Long total = con.connection().selectCount()
	                .from(Tables.ASSISTANCE)
	                //.where(Tables.ASSISTANCE.DELETED.isFalse()
	                      //  .and(Tables.ASSISTANCE.NOM_PRENOM_ASSISTANCE.lower().like('%' + filter.toLowerCase() + '%')
	                        		 //.or(Tables.ASSISTANCE.TELEPHONE_ASSISTANCE.like('%' + filter + '%')))
	                        		 //  .or(Tables.ASSISTANCE.ID_ASSISTANCE.lower().like('%' + filter.toLowerCase() + '%')))
	                .fetchAny(0, Long.class);
		 return total;
	 }
	 
	 public Long getCountNew(){
		 Long total = con.connection().selectCount()
	                .from(Tables.ASSISTANCE)
	                .where(Tables.ASSISTANCE.NEW_CREATE.isTrue())
	                      //  .and(Tables.ASSISTANCE.NOM_PRENOM_ASSISTANCE.lower().like('%' + filter.toLowerCase() + '%')
	                        		 //.or(Tables.ASSISTANCE.TELEPHONE_ASSISTANCE.like('%' + filter + '%')))
	                        		 //  .or(Tables.ASSISTANCE.ID_ASSISTANCE.lower().like('%' + filter.toLowerCase() + '%')))
	                .fetchAny(0, Long.class);
		 return total;
	 }

	
	
}
