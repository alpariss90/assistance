/*
 * This file is generated by jOOQ.
*/
package models;


import javax.annotation.Generated;

import models.tables.Users;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling indexes of tables of the <code>public</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index USERS_PKEY = Indexes0.USERS_PKEY;
    public static final Index USERS_TELEPHONE_KEY = Indexes0.USERS_TELEPHONE_KEY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 extends AbstractKeys {
        public static Index USERS_PKEY = createIndex("users_pkey", Users.USERS, new OrderField[] { Users.USERS.LOGIN }, true);
        public static Index USERS_TELEPHONE_KEY = createIndex("users_telephone_key", Users.USERS, new OrderField[] { Users.USERS.TELEPHONE }, true);
    }
}