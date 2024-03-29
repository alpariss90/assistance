/*
 * This file is generated by jOOQ.
*/
package models.tables;


import java.time.LocalDateTime;

import javax.annotation.Generated;

import models.Public;
import models.tables.records.VAssistanceRecord;

import org.jooq.Field;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class VAssistance extends TableImpl<VAssistanceRecord> {

    private static final long serialVersionUID = 766640475;

    /**
     * The reference instance of <code>public.v_assistance</code>
     */
    public static final VAssistance V_ASSISTANCE = new VAssistance();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<VAssistanceRecord> getRecordType() {
        return VAssistanceRecord.class;
    }

    /**
     * The column <code>public.v_assistance.id</code>.
     */
    public final TableField<VAssistanceRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.v_assistance.motif</code>.
     */
    public final TableField<VAssistanceRecord, String> MOTIF = createField("motif", org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.v_assistance.declarant</code>.
     */
    public final TableField<VAssistanceRecord, String> DECLARANT = createField("declarant", org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.v_assistance.observations</code>.
     */
    public final TableField<VAssistanceRecord, String> OBSERVATIONS = createField("observations", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.v_assistance.is_close</code>.
     */
    public final TableField<VAssistanceRecord, Boolean> IS_CLOSE = createField("is_close", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>public.v_assistance.maintenacier</code>.
     */
    public final TableField<VAssistanceRecord, String> MAINTENACIER = createField("maintenacier", org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.v_assistance.when_done</code>.
     */
    public final TableField<VAssistanceRecord, LocalDateTime> WHEN_DONE = createField("when_done", org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * The column <code>public.v_assistance.when_close</code>.
     */
    public final TableField<VAssistanceRecord, LocalDateTime> WHEN_CLOSE = createField("when_close", org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * The column <code>public.v_assistance.nom_prenom</code>.
     */
    public final TableField<VAssistanceRecord, String> NOM_PRENOM = createField("nom_prenom", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.v_assistance.batiment</code>.
     */
    public final TableField<VAssistanceRecord, String> BATIMENT = createField("batiment", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.v_assistance.niveau</code>.
     */
    public final TableField<VAssistanceRecord, String> NIVEAU = createField("niveau", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.v_assistance.porte</code>.
     */
    public final TableField<VAssistanceRecord, String> PORTE = createField("porte", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.v_assistance.is_ok</code>.
     */
    public final TableField<VAssistanceRecord, Boolean> IS_OK = createField("is_ok", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>public.v_assistance.new_create</code>.
     */
    public final TableField<VAssistanceRecord, Boolean> NEW_CREATE = createField("new_create", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>public.v_assistance.when_ok</code>.
     */
    public final TableField<VAssistanceRecord, LocalDateTime> WHEN_OK = createField("when_ok", org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * The column <code>public.v_assistance.direction</code>.
     */
    public final TableField<VAssistanceRecord, String> DIRECTION = createField("direction", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * Create a <code>public.v_assistance</code> table reference
     */
    public VAssistance() {
        this(DSL.name("v_assistance"), null);
    }

    /**
     * Create an aliased <code>public.v_assistance</code> table reference
     */
    public VAssistance(String alias) {
        this(DSL.name(alias), V_ASSISTANCE);
    }

    /**
     * Create an aliased <code>public.v_assistance</code> table reference
     */
    public VAssistance(Name alias) {
        this(alias, V_ASSISTANCE);
    }

    private VAssistance(Name alias, Table<VAssistanceRecord> aliased) {
        this(alias, aliased, null);
    }

    private VAssistance(Name alias, Table<VAssistanceRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VAssistance as(String alias) {
        return new VAssistance(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VAssistance as(Name alias) {
        return new VAssistance(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public VAssistance rename(String name) {
        return new VAssistance(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public VAssistance rename(Name name) {
        return new VAssistance(name, null);
    }
}
