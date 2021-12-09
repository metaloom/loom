/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.Public;
import io.metaloom.loom.db.jooq.tables.records.FieldsRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.JSONB;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row10;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * Table which stores the actual fields content as JSON
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Fields extends TableImpl<FieldsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.fields</code>
     */
    public static final Fields FIELDS = new Fields();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FieldsRecord> getRecordType() {
        return FieldsRecord.class;
    }

    /**
     * The column <code>public.fields.uuid</code>.
     */
    public final TableField<FieldsRecord, java.util.UUID> UUID = createField(DSL.name("uuid"), SQLDataType.UUID.nullable(false).defaultValue(DSL.field("uuid_generate_v4()", SQLDataType.UUID)), this, "");

    /**
     * The column <code>public.fields.content_uuid</code>. Reference to the
     * content that uses this fields record
     */
    public final TableField<FieldsRecord, java.util.UUID> CONTENT_UUID = createField(DSL.name("content_uuid"), SQLDataType.UUID, this, "Reference to the content that uses this fields record");

    /**
     * The column <code>public.fields.fields_json</code>. JSON which contains
     * the actual fields content
     */
    public final TableField<FieldsRecord, JSONB> FIELDS_JSON = createField(DSL.name("fields_json"), SQLDataType.JSONB, this, "JSON which contains the actual fields content");

    /**
     * The column <code>public.fields.language_uuid</code>.
     */
    public final TableField<FieldsRecord, java.util.UUID> LANGUAGE_UUID = createField(DSL.name("language_uuid"), SQLDataType.UUID, this, "");

    /**
     * The column <code>public.fields.edited</code>.
     */
    public final TableField<FieldsRecord, LocalDateTime> EDITED = createField(DSL.name("edited"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.fields.editor_uuid</code>.
     */
    public final TableField<FieldsRecord, java.util.UUID> EDITOR_UUID = createField(DSL.name("editor_uuid"), SQLDataType.UUID, this, "");

    /**
     * The column <code>public.fields.created</code>.
     */
    public final TableField<FieldsRecord, LocalDateTime> CREATED = createField(DSL.name("created"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.fields.creator_uuid</code>.
     */
    public final TableField<FieldsRecord, java.util.UUID> CREATOR_UUID = createField(DSL.name("creator_uuid"), SQLDataType.UUID, this, "");

    /**
     * The column <code>public.fields.modelversion_uuid</code>.
     */
    public final TableField<FieldsRecord, java.util.UUID> MODELVERSION_UUID = createField(DSL.name("modelversion_uuid"), SQLDataType.UUID, this, "");

    /**
     * The column <code>public.fields.version</code>.
     */
    public final TableField<FieldsRecord, Integer> VERSION = createField(DSL.name("version"), SQLDataType.INTEGER, this, "");

    private Fields(Name alias, Table<FieldsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Fields(Name alias, Table<FieldsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Table which stores the actual fields content as JSON"), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.fields</code> table reference
     */
    public Fields(String alias) {
        this(DSL.name(alias), FIELDS);
    }

    /**
     * Create an aliased <code>public.fields</code> table reference
     */
    public Fields(Name alias) {
        this(alias, FIELDS);
    }

    /**
     * Create a <code>public.fields</code> table reference
     */
    public Fields() {
        this(DSL.name("fields"), null);
    }

    public <O extends Record> Fields(Table<O> child, ForeignKey<O, FieldsRecord> key) {
        super(child, key, FIELDS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<FieldsRecord> getPrimaryKey() {
        return Keys.FIELDS_PKEY;
    }

    @Override
    public List<ForeignKey<FieldsRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FIELDS__FIELDS_CONTENT_UUID_FKEY, Keys.FIELDS__FIELDS_LANGUAGE_UUID_FKEY, Keys.FIELDS__FIELDS_EDITOR_UUID_FKEY, Keys.FIELDS__FIELDS_MODELVERSION_UUID_FKEY);
    }

    private transient Namespaces _namespaces;
    private transient Languages _languages;
    private transient Users _users;
    private transient ModelVersion _modelVersion;

    public Namespaces namespaces() {
        if (_namespaces == null)
            _namespaces = new Namespaces(this, Keys.FIELDS__FIELDS_CONTENT_UUID_FKEY);

        return _namespaces;
    }

    public Languages languages() {
        if (_languages == null)
            _languages = new Languages(this, Keys.FIELDS__FIELDS_LANGUAGE_UUID_FKEY);

        return _languages;
    }

    public Users users() {
        if (_users == null)
            _users = new Users(this, Keys.FIELDS__FIELDS_EDITOR_UUID_FKEY);

        return _users;
    }

    public ModelVersion modelVersion() {
        if (_modelVersion == null)
            _modelVersion = new ModelVersion(this, Keys.FIELDS__FIELDS_MODELVERSION_UUID_FKEY);

        return _modelVersion;
    }

    @Override
    public Fields as(String alias) {
        return new Fields(DSL.name(alias), this);
    }

    @Override
    public Fields as(Name alias) {
        return new Fields(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Fields rename(String name) {
        return new Fields(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Fields rename(Name name) {
        return new Fields(name, null);
    }

    // -------------------------------------------------------------------------
    // Row10 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row10<java.util.UUID, java.util.UUID, JSONB, java.util.UUID, LocalDateTime, java.util.UUID, LocalDateTime, java.util.UUID, java.util.UUID, Integer> fieldsRow() {
        return (Row10) super.fieldsRow();
    }
}
