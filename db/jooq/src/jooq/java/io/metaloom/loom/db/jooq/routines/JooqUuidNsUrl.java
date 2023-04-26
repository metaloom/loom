/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.routines;


import io.metaloom.loom.db.jooq.JooqPublic;

import java.util.UUID;

import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqUuidNsUrl extends AbstractRoutine<UUID> {

    private static final long serialVersionUID = 1L;

    /**
     * The parameter <code>public.uuid_ns_url.RETURN_VALUE</code>.
     */
    public static final Parameter<UUID> RETURN_VALUE = Internal.createParameter("RETURN_VALUE", SQLDataType.UUID, false, false);

    /**
     * Create a new routine call instance
     */
    public JooqUuidNsUrl() {
        super("uuid_ns_url", JooqPublic.PUBLIC, SQLDataType.UUID);

        setReturnParameter(RETURN_VALUE);
    }
}