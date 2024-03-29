/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.JooqPublic;
import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.tables.records.JooqVectorConfigRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function7;
import org.jooq.JSONB;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row7;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This table stores the custom index definition that will be used when creating
 * custom indices in a vector database that list specific aspects of loom data.
 * 
 * A custom configuration may define that a specific meta property should be
 * added to the index when generating the vector.
 * This feature can be used to generate a custom recommendation feature by
 * including and ranking and encoding specific properties as vectors.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqVectorConfig extends TableImpl<JooqVectorConfigRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.vector_config</code>
     */
    public static final JooqVectorConfig VECTOR_CONFIG = new JooqVectorConfig();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JooqVectorConfigRecord> getRecordType() {
        return JooqVectorConfigRecord.class;
    }

    /**
     * The column <code>public.vector_config.uuid</code>.
     */
    public final TableField<JooqVectorConfigRecord, java.util.UUID> UUID = createField(DSL.name("uuid"), SQLDataType.UUID.defaultValue(DSL.field("uuid_generate_v4()", SQLDataType.UUID)), this, "");

    /**
     * The column <code>public.vector_config.name</code>.
     */
    public final TableField<JooqVectorConfigRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.vector_config.weights</code>. Index definition
     * which lists the weights for each component that should be included in the
     * index
     */
    public final TableField<JooqVectorConfigRecord, JSONB> WEIGHTS = createField(DSL.name("weights"), SQLDataType.JSONB, this, "Index definition which lists the weights for each component that should be included in the index");

    /**
     * The column <code>public.vector_config.created</code>.
     */
    public final TableField<JooqVectorConfigRecord, LocalDateTime> CREATED = createField(DSL.name("created"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.vector_config.creator_uuid</code>.
     */
    public final TableField<JooqVectorConfigRecord, java.util.UUID> CREATOR_UUID = createField(DSL.name("creator_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.vector_config.edited</code>.
     */
    public final TableField<JooqVectorConfigRecord, LocalDateTime> EDITED = createField(DSL.name("edited"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.vector_config.editor_uuid</code>.
     */
    public final TableField<JooqVectorConfigRecord, java.util.UUID> EDITOR_UUID = createField(DSL.name("editor_uuid"), SQLDataType.UUID.nullable(false), this, "");

    private JooqVectorConfig(Name alias, Table<JooqVectorConfigRecord> aliased) {
        this(alias, aliased, null);
    }

    private JooqVectorConfig(Name alias, Table<JooqVectorConfigRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("This table stores the custom index definition that will be used when creating custom indices in a vector database that list specific aspects of loom data.\n\nA custom configuration may define that a specific meta property should be added to the index when generating the vector.\nThis feature can be used to generate a custom recommendation feature by including and ranking and encoding specific properties as vectors."), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.vector_config</code> table reference
     */
    public JooqVectorConfig(String alias) {
        this(DSL.name(alias), VECTOR_CONFIG);
    }

    /**
     * Create an aliased <code>public.vector_config</code> table reference
     */
    public JooqVectorConfig(Name alias) {
        this(alias, VECTOR_CONFIG);
    }

    /**
     * Create a <code>public.vector_config</code> table reference
     */
    public JooqVectorConfig() {
        this(DSL.name("vector_config"), null);
    }

    public <O extends Record> JooqVectorConfig(Table<O> child, ForeignKey<O, JooqVectorConfigRecord> key) {
        super(child, key, VECTOR_CONFIG);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : JooqPublic.PUBLIC;
    }

    @Override
    public List<UniqueKey<JooqVectorConfigRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.VECTOR_CONFIG_NAME_KEY);
    }

    @Override
    public JooqVectorConfig as(String alias) {
        return new JooqVectorConfig(DSL.name(alias), this);
    }

    @Override
    public JooqVectorConfig as(Name alias) {
        return new JooqVectorConfig(alias, this);
    }

    @Override
    public JooqVectorConfig as(Table<?> alias) {
        return new JooqVectorConfig(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqVectorConfig rename(String name) {
        return new JooqVectorConfig(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqVectorConfig rename(Name name) {
        return new JooqVectorConfig(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqVectorConfig rename(Table<?> name) {
        return new JooqVectorConfig(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<java.util.UUID, String, JSONB, LocalDateTime, java.util.UUID, LocalDateTime, java.util.UUID> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function7<? super java.util.UUID, ? super String, ? super JSONB, ? super LocalDateTime, ? super java.util.UUID, ? super LocalDateTime, ? super java.util.UUID, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function7<? super java.util.UUID, ? super String, ? super JSONB, ? super LocalDateTime, ? super java.util.UUID, ? super LocalDateTime, ? super java.util.UUID, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
