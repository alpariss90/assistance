/*
 * This file is generated by jOOQ.
*/
package models.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import models.Indexes;
import models.Keys;
import models.Public;
import models.tables.records.UsersRecord;

import org.jooq.Field;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
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
public class Users extends TableImpl<UsersRecord> {

    private static final long serialVersionUID = -23067189;

    /**
     * The reference instance of <code>public.users</code>
     */
    public static final Users USERS = new Users();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UsersRecord> getRecordType() {
        return UsersRecord.class;
    }

    /**
     * The column <code>public.users.login</code>.
     */
    public final TableField<UsersRecord, String> LOGIN = createField("login", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>public.users.droit</code>.
     */
    public final TableField<UsersRecord, String> DROIT = createField("droit", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.users.etat</code>.
     */
    public final TableField<UsersRecord, Boolean> ETAT = createField("etat", org.jooq.impl.SQLDataType.BOOLEAN.defaultValue(org.jooq.impl.DSL.field("false", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>public.users.passe</code>.
     */
    public final TableField<UsersRecord, String> PASSE = createField("passe", org.jooq.impl.SQLDataType.VARCHAR(100).defaultValue(org.jooq.impl.DSL.field("'$2a$08$.EnieA7XKxY3R0oEHYoXeeSezzUcbXxJhce.nzA3PhImHO9V1Cv32'::character varying", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>public.users.who_done</code>.
     */
    public final TableField<UsersRecord, String> WHO_DONE = createField("who_done", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.users.when_done</code>.
     */
    public final TableField<UsersRecord, LocalDateTime> WHEN_DONE = createField("when_done", org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * The column <code>public.users.nom_prenom</code>.
     */
    public final TableField<UsersRecord, String> NOM_PRENOM = createField("nom_prenom", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.users.photo</code>.
     */
    public final TableField<UsersRecord, String> PHOTO = createField("photo", org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.users.telephone</code>.
     */
    public final TableField<UsersRecord, Integer> TELEPHONE = createField("telephone", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>public.users</code> table reference
     */
    public Users() {
        this(DSL.name("users"), null);
    }

    /**
     * Create an aliased <code>public.users</code> table reference
     */
    public Users(String alias) {
        this(DSL.name(alias), USERS);
    }

    /**
     * Create an aliased <code>public.users</code> table reference
     */
    public Users(Name alias) {
        this(alias, USERS);
    }

    private Users(Name alias, Table<UsersRecord> aliased) {
        this(alias, aliased, null);
    }

    private Users(Name alias, Table<UsersRecord> aliased, Field<?>[] parameters) {
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
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.USERS_PKEY, Indexes.USERS_TELEPHONE_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<UsersRecord> getPrimaryKey() {
        return Keys.USERS_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<UsersRecord>> getKeys() {
        return Arrays.<UniqueKey<UsersRecord>>asList(Keys.USERS_PKEY, Keys.USERS_TELEPHONE_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Users as(String alias) {
        return new Users(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Users as(Name alias) {
        return new Users(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Users rename(String name) {
        return new Users(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Users rename(Name name) {
        return new Users(name, null);
    }
}