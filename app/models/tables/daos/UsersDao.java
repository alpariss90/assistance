/*
 * This file is generated by jOOQ.
*/
package models.tables.daos;


import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Generated;

import models.tables.Users;
import models.tables.records.UsersRecord;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UsersDao extends DAOImpl<UsersRecord, models.tables.pojos.Users, String> {

    /**
     * Create a new UsersDao without any configuration
     */
    public UsersDao() {
        super(Users.USERS, models.tables.pojos.Users.class);
    }

    /**
     * Create a new UsersDao with an attached configuration
     */
    public UsersDao(Configuration configuration) {
        super(Users.USERS, models.tables.pojos.Users.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getId(models.tables.pojos.Users object) {
        return object.getLogin();
    }

    /**
     * Fetch records that have <code>login IN (values)</code>
     */
    public List<models.tables.pojos.Users> fetchByLogin(String... values) {
        return fetch(Users.USERS.LOGIN, values);
    }

    /**
     * Fetch a unique record that has <code>login = value</code>
     */
    public models.tables.pojos.Users fetchOneByLogin(String value) {
        return fetchOne(Users.USERS.LOGIN, value);
    }

    /**
     * Fetch records that have <code>droit IN (values)</code>
     */
    public List<models.tables.pojos.Users> fetchByDroit(String... values) {
        return fetch(Users.USERS.DROIT, values);
    }

    /**
     * Fetch records that have <code>etat IN (values)</code>
     */
    public List<models.tables.pojos.Users> fetchByEtat(Boolean... values) {
        return fetch(Users.USERS.ETAT, values);
    }

    /**
     * Fetch records that have <code>passe IN (values)</code>
     */
    public List<models.tables.pojos.Users> fetchByPasse(String... values) {
        return fetch(Users.USERS.PASSE, values);
    }

    /**
     * Fetch records that have <code>who_done IN (values)</code>
     */
    public List<models.tables.pojos.Users> fetchByWhoDone(String... values) {
        return fetch(Users.USERS.WHO_DONE, values);
    }

    /**
     * Fetch records that have <code>when_done IN (values)</code>
     */
    public List<models.tables.pojos.Users> fetchByWhenDone(LocalDateTime... values) {
        return fetch(Users.USERS.WHEN_DONE, values);
    }

    /**
     * Fetch records that have <code>nom_prenom IN (values)</code>
     */
    public List<models.tables.pojos.Users> fetchByNomPrenom(String... values) {
        return fetch(Users.USERS.NOM_PRENOM, values);
    }

    /**
     * Fetch records that have <code>photo IN (values)</code>
     */
    public List<models.tables.pojos.Users> fetchByPhoto(String... values) {
        return fetch(Users.USERS.PHOTO, values);
    }

    /**
     * Fetch records that have <code>batiment IN (values)</code>
     */
    public List<models.tables.pojos.Users> fetchByBatiment(String... values) {
        return fetch(Users.USERS.BATIMENT, values);
    }

    /**
     * Fetch records that have <code>niveau IN (values)</code>
     */
    public List<models.tables.pojos.Users> fetchByNiveau(String... values) {
        return fetch(Users.USERS.NIVEAU, values);
    }

    /**
     * Fetch records that have <code>porte IN (values)</code>
     */
    public List<models.tables.pojos.Users> fetchByPorte(String... values) {
        return fetch(Users.USERS.PORTE, values);
    }

    /**
     * Fetch records that have <code>direction IN (values)</code>
     */
    public List<models.tables.pojos.Users> fetchByDirection(String... values) {
        return fetch(Users.USERS.DIRECTION, values);
    }
}
