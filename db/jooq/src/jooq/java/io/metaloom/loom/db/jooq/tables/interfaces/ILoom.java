/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.interfaces;


import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;

import java.io.Serializable;
import java.time.LocalDateTime;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface ILoom extends VertxPojo, Serializable {

    /**
     * Setter for <code>public.loom.db_rev</code>.
     */
    public ILoom setDbRev(String value);

    /**
     * Getter for <code>public.loom.db_rev</code>.
     */
    public String getDbRev();

    /**
     * Setter for <code>public.loom.last_used_timestamp</code>.
     */
    public ILoom setLastUsedTimestamp(LocalDateTime value);

    /**
     * Getter for <code>public.loom.last_used_timestamp</code>.
     */
    public LocalDateTime getLastUsedTimestamp();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface ILoom
     */
    public void from(ILoom from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface ILoom
     */
    public <E extends ILoom> E into(E into);

        @Override
        public default ILoom fromJson(io.vertx.core.json.JsonObject json) {
                setOrThrow(this::setDbRev,json::getString,"db_rev","java.lang.String");
                setOrThrow(this::setLastUsedTimestamp,key -> {String s = json.getString(key); return s==null?null:java.time.LocalDateTime.parse(s);},"last_used_timestamp","java.time.LocalDateTime");
                return this;
        }


        @Override
        public default io.vertx.core.json.JsonObject toJson() {
                io.vertx.core.json.JsonObject json = new io.vertx.core.json.JsonObject();
                json.put("db_rev",getDbRev());
                json.put("last_used_timestamp",getLastUsedTimestamp()==null?null:getLastUsedTimestamp().toString());
                return json;
        }

}
