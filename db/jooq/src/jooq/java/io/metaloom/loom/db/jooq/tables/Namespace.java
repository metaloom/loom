/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.Indexes;
import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.Public;
import io.metaloom.loom.db.jooq.tables.records.NamespaceRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function10;
import org.jooq.Index;
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
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Namespace extends TableImpl<NamespaceRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.namespace</code>
     */
    public static final Namespace NAMESPACE = new Namespace();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<NamespaceRecord> getRecordType() {
        return NamespaceRecord.class;
    }

    /**
     * The column <code>public.namespace.uuid</code>.
     */
    public final TableField<NamespaceRecord, java.util.UUID> UUID = createField(DSL.name("uuid"), SQLDataType.UUID.nullable(false).defaultValue(DSL.field("uuid_generate_v4()", SQLDataType.UUID)), this, "");

    /**
     * The column <code>public.namespace.name</code>.
     */
    public final TableField<NamespaceRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.namespace.root_content_uuid</code>.
     */
    public final TableField<NamespaceRecord, java.util.UUID> ROOT_CONTENT_UUID = createField(DSL.name("root_content_uuid"), SQLDataType.UUID, this, "");

    /**
     * The column <code>public.namespace.meta</code>. Custom meta properties to
     * the element
     */
    public final TableField<NamespaceRecord, JSONB> META = createField(DSL.name("meta"), SQLDataType.JSONB, this, "Custom meta properties to the element");

    /**
     * The column <code>public.namespace.path_prefix</code>. Prefix for webroot
     * paths
     */
    public final TableField<NamespaceRecord, String> PATH_PREFIX = createField(DSL.name("path_prefix"), SQLDataType.VARCHAR, this, "Prefix for webroot paths");

    /**
     * The column <code>public.namespace.model_filter</code>. filter for models
     * that can be used in the namespace
     */
    public final TableField<NamespaceRecord, String> MODEL_FILTER = createField(DSL.name("model_filter"), SQLDataType.VARCHAR, this, "filter for models that can be used in the namespace");

    /**
     * The column <code>public.namespace.created</code>.
     */
    public final TableField<NamespaceRecord, LocalDateTime> CREATED = createField(DSL.name("created"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.namespace.creator_uuid</code>.
     */
    public final TableField<NamespaceRecord, java.util.UUID> CREATOR_UUID = createField(DSL.name("creator_uuid"), SQLDataType.UUID, this, "");

    /**
     * The column <code>public.namespace.edited</code>.
     */
    public final TableField<NamespaceRecord, LocalDateTime> EDITED = createField(DSL.name("edited"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.namespace.editor_uuid</code>.
     */
    public final TableField<NamespaceRecord, java.util.UUID> EDITOR_UUID = createField(DSL.name("editor_uuid"), SQLDataType.UUID, this, "");

    private Namespace(Name alias, Table<NamespaceRecord> aliased) {
        this(alias, aliased, null);
    }

    private Namespace(Name alias, Table<NamespaceRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.namespace</code> table reference
     */
    public Namespace(String alias) {
        this(DSL.name(alias), NAMESPACE);
    }

    /**
     * Create an aliased <code>public.namespace</code> table reference
     */
    public Namespace(Name alias) {
        this(alias, NAMESPACE);
    }

    /**
     * Create a <code>public.namespace</code> table reference
     */
    public Namespace() {
        this(DSL.name("namespace"), null);
    }

    public <O extends Record> Namespace(Table<O> child, ForeignKey<O, NamespaceRecord> key) {
        super(child, key, NAMESPACE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.NAMESPACE_NAME_IDX);
    }

    @Override
    public UniqueKey<NamespaceRecord> getPrimaryKey() {
        return Keys.NAMESPACE_PKEY;
    }

    @Override
    public List<UniqueKey<NamespaceRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.NAMESPACE_NAME_KEY);
    }

    @Override
    public List<ForeignKey<NamespaceRecord, ?>> getReferences() {
        return Arrays.asList(Keys.NAMESPACE__NAMESPACE_ROOT_CONTENT_UUID_FKEY, Keys.NAMESPACE__NAMESPACE_CREATOR_UUID_FKEY, Keys.NAMESPACE__NAMESPACE_EDITOR_UUID_FKEY);
    }

    private transient Content _content;
    private transient User _namespaceCreatorUuidFkey;
    private transient User _namespaceEditorUuidFkey;

    /**
     * Get the implicit join path to the <code>public.content</code> table.
     */
    public Content content() {
        if (_content == null)
            _content = new Content(this, Keys.NAMESPACE__NAMESPACE_ROOT_CONTENT_UUID_FKEY);

        return _content;
    }

    /**
     * Get the implicit join path to the <code>public.user</code> table, via the
     * <code>namespace_creator_uuid_fkey</code> key.
     */
    public User namespaceCreatorUuidFkey() {
        if (_namespaceCreatorUuidFkey == null)
            _namespaceCreatorUuidFkey = new User(this, Keys.NAMESPACE__NAMESPACE_CREATOR_UUID_FKEY);

        return _namespaceCreatorUuidFkey;
    }

    /**
     * Get the implicit join path to the <code>public.user</code> table, via the
     * <code>namespace_editor_uuid_fkey</code> key.
     */
    public User namespaceEditorUuidFkey() {
        if (_namespaceEditorUuidFkey == null)
            _namespaceEditorUuidFkey = new User(this, Keys.NAMESPACE__NAMESPACE_EDITOR_UUID_FKEY);

        return _namespaceEditorUuidFkey;
    }

    @Override
    public Namespace as(String alias) {
        return new Namespace(DSL.name(alias), this);
    }

    @Override
    public Namespace as(Name alias) {
        return new Namespace(alias, this);
    }

    @Override
    public Namespace as(Table<?> alias) {
        return new Namespace(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Namespace rename(String name) {
        return new Namespace(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Namespace rename(Name name) {
        return new Namespace(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Namespace rename(Table<?> name) {
        return new Namespace(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row10 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row10<java.util.UUID, String, java.util.UUID, JSONB, String, String, LocalDateTime, java.util.UUID, LocalDateTime, java.util.UUID> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function10<? super java.util.UUID, ? super String, ? super java.util.UUID, ? super JSONB, ? super String, ? super String, ? super LocalDateTime, ? super java.util.UUID, ? super LocalDateTime, ? super java.util.UUID, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function10<? super java.util.UUID, ? super String, ? super java.util.UUID, ? super JSONB, ? super String, ? super String, ? super LocalDateTime, ? super java.util.UUID, ? super LocalDateTime, ? super java.util.UUID, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
