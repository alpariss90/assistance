/*
 * This file is generated by jOOQ.
*/
package models.tables.daos;


import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Generated;

import models.tables.Assistance;
import models.tables.records.AssistanceRecord;

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
public class AssistanceDao extends DAOImpl<AssistanceRecord, models.tables.pojos.Assistance, Long> {

    /**
     * Create a new AssistanceDao without any configuration
     */
    public AssistanceDao() {
        super(Assistance.ASSISTANCE, models.tables.pojos.Assistance.class);
    }

    /**
     * Create a new AssistanceDao with an attached configuration
     */
    public AssistanceDao(Configuration configuration) {
        super(Assistance.ASSISTANCE, models.tables.pojos.Assistance.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Long getId(models.tables.pojos.Assistance object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<models.tables.pojos.Assistance> fetchById(Long... values) {
        return fetch(Assistance.ASSISTANCE.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public models.tables.pojos.Assistance fetchOneById(Long value) {
        return fetchOne(Assistance.ASSISTANCE.ID, value);
    }

    /**
     * Fetch records that have <code>motif IN (values)</code>
     */
    public List<models.tables.pojos.Assistance> fetchByMotif(String... values) {
        return fetch(Assistance.ASSISTANCE.MOTIF, values);
    }

    /**
     * Fetch records that have <code>declarant IN (values)</code>
     */
    public List<models.tables.pojos.Assistance> fetchByDeclarant(String... values) {
        return fetch(Assistance.ASSISTANCE.DECLARANT, values);
    }

    /**
     * Fetch records that have <code>observations IN (values)</code>
     */
    public List<models.tables.pojos.Assistance> fetchByObservations(String... values) {
        return fetch(Assistance.ASSISTANCE.OBSERVATIONS, values);
    }

    /**
     * Fetch records that have <code>is_close IN (values)</code>
     */
    public List<models.tables.pojos.Assistance> fetchByIsClose(Boolean... values) {
        return fetch(Assistance.ASSISTANCE.IS_CLOSE, values);
    }

    /**
     * Fetch records that have <code>maintenacier IN (values)</code>
     */
    public List<models.tables.pojos.Assistance> fetchByMaintenacier(String... values) {
        return fetch(Assistance.ASSISTANCE.MAINTENACIER, values);
    }

    /**
     * Fetch records that have <code>when_done IN (values)</code>
     */
    public List<models.tables.pojos.Assistance> fetchByWhenDone(LocalDateTime... values) {
        return fetch(Assistance.ASSISTANCE.WHEN_DONE, values);
    }

    /**
     * Fetch records that have <code>when_close IN (values)</code>
     */
    public List<models.tables.pojos.Assistance> fetchByWhenClose(LocalDateTime... values) {
        return fetch(Assistance.ASSISTANCE.WHEN_CLOSE, values);
    }

    /**
     * Fetch records that have <code>is_ok IN (values)</code>
     */
    public List<models.tables.pojos.Assistance> fetchByIsOk(Boolean... values) {
        return fetch(Assistance.ASSISTANCE.IS_OK, values);
    }

    /**
     * Fetch records that have <code>when_ok IN (values)</code>
     */
    public List<models.tables.pojos.Assistance> fetchByWhenOk(LocalDateTime... values) {
        return fetch(Assistance.ASSISTANCE.WHEN_OK, values);
    }

    /**
     * Fetch records that have <code>new_create IN (values)</code>
     */
    public List<models.tables.pojos.Assistance> fetchByNewCreate(Boolean... values) {
        return fetch(Assistance.ASSISTANCE.NEW_CREATE, values);
    }
}
