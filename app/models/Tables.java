/*
 * This file is generated by jOOQ.
*/
package models;


import javax.annotation.Generated;

import models.tables.Assistance;
import models.tables.Users;
import models.tables.VAssistance;


/**
 * Convenience access to all tables in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>public.assistance</code>.
     */
    public static final Assistance ASSISTANCE = models.tables.Assistance.ASSISTANCE;

    /**
     * The table <code>public.users</code>.
     */
    public static final Users USERS = models.tables.Users.USERS;

    /**
     * The table <code>public.v_assistance</code>.
     */
    public static final VAssistance V_ASSISTANCE = models.tables.VAssistance.V_ASSISTANCE;
}
