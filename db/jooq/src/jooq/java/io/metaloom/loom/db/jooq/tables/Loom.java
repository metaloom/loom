/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.Public;
import io.metaloom.loom.db.jooq.tables.records.LoomRecord;

import java.time.LocalDateTime;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function2;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Loom extends TableImpl<LoomRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.loom</code>
     */
    public static final Loom LOOM = new Loom();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LoomRecord> getRecordType() {
        return LoomRecord.class;
    }

    /**
     * The column <code>public.loom.db_rev</code>.
     */
    public final TableField<LoomRecord, String> DB_REV = createField(DSL.name("db_rev"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.loom.last_used_timestamp</code>.
     */
    public final TableField<LoomRecord, LocalDateTime> LAST_USED_TIMESTAMP = createField(DSL.name("last_used_timestamp"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    private Loom(Name alias, Table<LoomRecord> aliased) {
        this(alias, aliased, null);
    }

    private Loom(Name alias, Table<LoomRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.loom</code> table reference
     */
    public Loom(String alias) {
        this(DSL.name(alias), LOOM);
    }

    /**
     * Create an aliased <code>public.loom</code> table reference
     */
    public Loom(Name alias) {
        this(alias, LOOM);
    }

    /**
     * Create a <code>public.loom</code> table reference
     */
    public Loom() {
        this(DSL.name("loom"), null);
    }

    public <O extends Record> Loom(Table<O> child, ForeignKey<O, LoomRecord> key) {
        super(child, key, LOOM);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Loom as(String alias) {
        return new Loom(DSL.name(alias), this);
    }

    @Override
    public Loom as(Name alias) {
        return new Loom(alias, this);
    }

    @Override
    public Loom as(Table<?> alias) {
        return new Loom(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Loom rename(String name) {
        return new Loom(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Loom rename(Name name) {
        return new Loom(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Loom rename(Table<?> name) {
        return new Loom(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, LocalDateTime> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function2<? super String, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function2<? super String, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}