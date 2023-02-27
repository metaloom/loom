/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.Public;
import io.metaloom.loom.db.jooq.tables.records.TagNamespaceRecord;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
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
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * Table used to taggings on namespaces
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TagNamespace extends TableImpl<TagNamespaceRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.tag_namespace</code>
     */
    public static final TagNamespace TAG_NAMESPACE = new TagNamespace();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TagNamespaceRecord> getRecordType() {
        return TagNamespaceRecord.class;
    }

    /**
     * The column <code>public.tag_namespace.tag_uuid</code>.
     */
    public final TableField<TagNamespaceRecord, UUID> TAG_UUID = createField(DSL.name("tag_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.tag_namespace.namespace_uuid</code>.
     */
    public final TableField<TagNamespaceRecord, UUID> NAMESPACE_UUID = createField(DSL.name("namespace_uuid"), SQLDataType.UUID.nullable(false), this, "");

    private TagNamespace(Name alias, Table<TagNamespaceRecord> aliased) {
        this(alias, aliased, null);
    }

    private TagNamespace(Name alias, Table<TagNamespaceRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Table used to taggings on namespaces"), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.tag_namespace</code> table reference
     */
    public TagNamespace(String alias) {
        this(DSL.name(alias), TAG_NAMESPACE);
    }

    /**
     * Create an aliased <code>public.tag_namespace</code> table reference
     */
    public TagNamespace(Name alias) {
        this(alias, TAG_NAMESPACE);
    }

    /**
     * Create a <code>public.tag_namespace</code> table reference
     */
    public TagNamespace() {
        this(DSL.name("tag_namespace"), null);
    }

    public <O extends Record> TagNamespace(Table<O> child, ForeignKey<O, TagNamespaceRecord> key) {
        super(child, key, TAG_NAMESPACE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<TagNamespaceRecord> getPrimaryKey() {
        return Keys.TAG_NAMESPACE_PKEY;
    }

    @Override
    public List<ForeignKey<TagNamespaceRecord, ?>> getReferences() {
        return Arrays.asList(Keys.TAG_NAMESPACE__TAG_NAMESPACE_TAG_UUID_FKEY, Keys.TAG_NAMESPACE__TAG_NAMESPACE_NAMESPACE_UUID_FKEY);
    }

    private transient Tag _tag;
    private transient Namespace _namespace;

    /**
     * Get the implicit join path to the <code>public.tag</code> table.
     */
    public Tag tag() {
        if (_tag == null)
            _tag = new Tag(this, Keys.TAG_NAMESPACE__TAG_NAMESPACE_TAG_UUID_FKEY);

        return _tag;
    }

    /**
     * Get the implicit join path to the <code>public.namespace</code> table.
     */
    public Namespace namespace() {
        if (_namespace == null)
            _namespace = new Namespace(this, Keys.TAG_NAMESPACE__TAG_NAMESPACE_NAMESPACE_UUID_FKEY);

        return _namespace;
    }

    @Override
    public TagNamespace as(String alias) {
        return new TagNamespace(DSL.name(alias), this);
    }

    @Override
    public TagNamespace as(Name alias) {
        return new TagNamespace(alias, this);
    }

    @Override
    public TagNamespace as(Table<?> alias) {
        return new TagNamespace(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public TagNamespace rename(String name) {
        return new TagNamespace(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TagNamespace rename(Name name) {
        return new TagNamespace(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public TagNamespace rename(Table<?> name) {
        return new TagNamespace(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<UUID, UUID> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function2<? super UUID, ? super UUID, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function2<? super UUID, ? super UUID, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}