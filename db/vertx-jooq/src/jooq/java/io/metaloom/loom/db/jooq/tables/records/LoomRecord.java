/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;
import io.metaloom.loom.db.jooq.tables.Loom;
import io.metaloom.loom.db.jooq.tables.interfaces.ILoom;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.TableRecordImpl;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LoomRecord extends TableRecordImpl<LoomRecord> implements VertxPojo, Record2<String, LocalDateTime>, ILoom {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.loom.db_rev</code>.
     */
    @Override
    public LoomRecord setDbRev(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.loom.db_rev</code>.
     */
    @Override
    public String getDbRev() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.loom.last_used_timestamp</code>.
     */
    @Override
    public LoomRecord setLastUsedTimestamp(LocalDateTime value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.loom.last_used_timestamp</code>.
     */
    @Override
    public LocalDateTime getLastUsedTimestamp() {
        return (LocalDateTime) get(1);
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, LocalDateTime> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<String, LocalDateTime> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Loom.LOOM.DB_REV;
    }

    @Override
    public Field<LocalDateTime> field2() {
        return Loom.LOOM.LAST_USED_TIMESTAMP;
    }

    @Override
    public String component1() {
        return getDbRev();
    }

    @Override
    public LocalDateTime component2() {
        return getLastUsedTimestamp();
    }

    @Override
    public String value1() {
        return getDbRev();
    }

    @Override
    public LocalDateTime value2() {
        return getLastUsedTimestamp();
    }

    @Override
    public LoomRecord value1(String value) {
        setDbRev(value);
        return this;
    }

    @Override
    public LoomRecord value2(LocalDateTime value) {
        setLastUsedTimestamp(value);
        return this;
    }

    @Override
    public LoomRecord values(String value1, LocalDateTime value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(ILoom from) {
        setDbRev(from.getDbRev());
        setLastUsedTimestamp(from.getLastUsedTimestamp());
    }

    @Override
    public <E extends ILoom> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LoomRecord
     */
    public LoomRecord() {
        super(Loom.LOOM);
    }

    /**
     * Create a detached, initialised LoomRecord
     */
    public LoomRecord(String dbRev, LocalDateTime lastUsedTimestamp) {
        super(Loom.LOOM);

        setDbRev(dbRev);
        setLastUsedTimestamp(lastUsedTimestamp);
    }

        public LoomRecord(io.vertx.core.json.JsonObject json) {
                this();
                fromJson(json);
        }
}
