/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.Public;
import io.metaloom.loom.db.jooq.tables.records.FieldRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.ForeignKey;
import org.jooq.Function10;
import org.jooq.JSONB;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row10;
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
 * Table which stores the actual fields content as JSON
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Field extends TableImpl<FieldRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.field</code>
     */
    public static final Field FIELD = new Field();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FieldRecord> getRecordType() {
        return FieldRecord.class;
    }

    /**
     * The column <code>public.field.uuid</code>.
     */
    public final TableField<FieldRecord, java.util.UUID> UUID = createField(DSL.name("uuid"), SQLDataType.UUID.nullable(false).defaultValue(DSL.field("uuid_generate_v4()", SQLDataType.UUID)), this, "");

    /**
     * The column <code>public.field.content_uuid</code>. Reference to the
     * content that uses this fields record
     */
    public final TableField<FieldRecord, java.util.UUID> CONTENT_UUID = createField(DSL.name("content_uuid"), SQLDataType.UUID, this, "Reference to the content that uses this fields record");

    /**
     * The column <code>public.field.fields_json</code>. JSON which contains the
     * actual fields content
     */
    public final TableField<FieldRecord, JSONB> FIELDS_JSON = createField(DSL.name("fields_json"), SQLDataType.JSONB, this, "JSON which contains the actual fields content");

    /**
     * The column <code>public.field.language_uuid</code>.
     */
    public final TableField<FieldRecord, java.util.UUID> LANGUAGE_UUID = createField(DSL.name("language_uuid"), SQLDataType.UUID, this, "");

    /**
     * The column <code>public.field.edited</code>.
     */
    public final TableField<FieldRecord, LocalDateTime> EDITED = createField(DSL.name("edited"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.field.editor_uuid</code>.
     */
    public final TableField<FieldRecord, java.util.UUID> EDITOR_UUID = createField(DSL.name("editor_uuid"), SQLDataType.UUID, this, "");

    /**
     * The column <code>public.field.created</code>.
     */
    public final TableField<FieldRecord, LocalDateTime> CREATED = createField(DSL.name("created"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.field.creator_uuid</code>.
     */
    public final TableField<FieldRecord, java.util.UUID> CREATOR_UUID = createField(DSL.name("creator_uuid"), SQLDataType.UUID, this, "");

    /**
     * The column <code>public.field.modelversion_uuid</code>.
     */
    public final TableField<FieldRecord, java.util.UUID> MODELVERSION_UUID = createField(DSL.name("modelversion_uuid"), SQLDataType.UUID, this, "");

    /**
     * The column <code>public.field.version</code>.
     */
    public final TableField<FieldRecord, Integer> VERSION = createField(DSL.name("version"), SQLDataType.INTEGER, this, "");

    private Field(Name alias, Table<FieldRecord> aliased) {
        this(alias, aliased, null);
    }

    private Field(Name alias, Table<FieldRecord> aliased, org.jooq.Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Table which stores the actual fields content as JSON"), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.field</code> table reference
     */
    public Field(String alias) {
        this(DSL.name(alias), FIELD);
    }

    /**
     * Create an aliased <code>public.field</code> table reference
     */
    public Field(Name alias) {
        this(alias, FIELD);
    }

    /**
     * Create a <code>public.field</code> table reference
     */
    public Field() {
        this(DSL.name("field"), null);
    }

    public <O extends Record> Field(Table<O> child, ForeignKey<O, FieldRecord> key) {
        super(child, key, FIELD);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<FieldRecord> getPrimaryKey() {
        return Keys.FIELD_PKEY;
    }

    @Override
    public List<ForeignKey<FieldRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FIELD__FIELD_CONTENT_UUID_FKEY, Keys.FIELD__FIELD_LANGUAGE_UUID_FKEY, Keys.FIELD__FIELD_EDITOR_UUID_FKEY, Keys.FIELD__FIELD_MODELVERSION_UUID_FKEY);
    }

    private transient Namespace _namespace;
    private transient Language _language;
    private transient User _user;
    private transient ModelVersion _modelVersion;

    /**
     * Get the implicit join path to the <code>public.namespace</code> table.
     */
    public Namespace namespace() {
        if (_namespace == null)
            _namespace = new Namespace(this, Keys.FIELD__FIELD_CONTENT_UUID_FKEY);

        return _namespace;
    }

    /**
     * Get the implicit join path to the <code>public.language</code> table.
     */
    public Language language() {
        if (_language == null)
            _language = new Language(this, Keys.FIELD__FIELD_LANGUAGE_UUID_FKEY);

        return _language;
    }

    /**
     * Get the implicit join path to the <code>public.user</code> table.
     */
    public User user() {
        if (_user == null)
            _user = new User(this, Keys.FIELD__FIELD_EDITOR_UUID_FKEY);

        return _user;
    }

    /**
     * Get the implicit join path to the <code>public.model_version</code>
     * table.
     */
    public ModelVersion modelVersion() {
        if (_modelVersion == null)
            _modelVersion = new ModelVersion(this, Keys.FIELD__FIELD_MODELVERSION_UUID_FKEY);

        return _modelVersion;
    }

    @Override
    public Field as(String alias) {
        return new Field(DSL.name(alias), this);
    }

    @Override
    public Field as(Name alias) {
        return new Field(alias, this);
    }

    @Override
    public Field as(Table<?> alias) {
        return new Field(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Field rename(String name) {
        return new Field(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Field rename(Name name) {
        return new Field(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Field rename(Table<?> name) {
        return new Field(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row10 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row10<java.util.UUID, java.util.UUID, JSONB, java.util.UUID, LocalDateTime, java.util.UUID, LocalDateTime, java.util.UUID, java.util.UUID, Integer> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function10<? super java.util.UUID, ? super java.util.UUID, ? super JSONB, ? super java.util.UUID, ? super LocalDateTime, ? super java.util.UUID, ? super LocalDateTime, ? super java.util.UUID, ? super java.util.UUID, ? super Integer, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function10<? super java.util.UUID, ? super java.util.UUID, ? super JSONB, ? super java.util.UUID, ? super LocalDateTime, ? super java.util.UUID, ? super LocalDateTime, ? super java.util.UUID, ? super java.util.UUID, ? super Integer, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
