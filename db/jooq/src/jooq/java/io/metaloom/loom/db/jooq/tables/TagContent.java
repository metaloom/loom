/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.Public;
import io.metaloom.loom.db.jooq.tables.records.TagContentRecord;

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
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TagContent extends TableImpl<TagContentRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.tag_content</code>
     */
    public static final TagContent TAG_CONTENT = new TagContent();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TagContentRecord> getRecordType() {
        return TagContentRecord.class;
    }

    /**
     * The column <code>public.tag_content.tag_uuid</code>.
     */
    public final TableField<TagContentRecord, UUID> TAG_UUID = createField(DSL.name("tag_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.tag_content.content_uuid</code>.
     */
    public final TableField<TagContentRecord, UUID> CONTENT_UUID = createField(DSL.name("content_uuid"), SQLDataType.UUID.nullable(false), this, "");

    private TagContent(Name alias, Table<TagContentRecord> aliased) {
        this(alias, aliased, null);
    }

    private TagContent(Name alias, Table<TagContentRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.tag_content</code> table reference
     */
    public TagContent(String alias) {
        this(DSL.name(alias), TAG_CONTENT);
    }

    /**
     * Create an aliased <code>public.tag_content</code> table reference
     */
    public TagContent(Name alias) {
        this(alias, TAG_CONTENT);
    }

    /**
     * Create a <code>public.tag_content</code> table reference
     */
    public TagContent() {
        this(DSL.name("tag_content"), null);
    }

    public <O extends Record> TagContent(Table<O> child, ForeignKey<O, TagContentRecord> key) {
        super(child, key, TAG_CONTENT);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<TagContentRecord> getPrimaryKey() {
        return Keys.TAG_CONTENT_PKEY;
    }

    @Override
    public List<ForeignKey<TagContentRecord, ?>> getReferences() {
        return Arrays.asList(Keys.TAG_CONTENT__TAG_CONTENT_TAG_UUID_FKEY, Keys.TAG_CONTENT__TAG_CONTENT_CONTENT_UUID_FKEY);
    }

    private transient Tag _tag;
    private transient Content _content;

    /**
     * Get the implicit join path to the <code>public.tag</code> table.
     */
    public Tag tag() {
        if (_tag == null)
            _tag = new Tag(this, Keys.TAG_CONTENT__TAG_CONTENT_TAG_UUID_FKEY);

        return _tag;
    }

    /**
     * Get the implicit join path to the <code>public.content</code> table.
     */
    public Content content() {
        if (_content == null)
            _content = new Content(this, Keys.TAG_CONTENT__TAG_CONTENT_CONTENT_UUID_FKEY);

        return _content;
    }

    @Override
    public TagContent as(String alias) {
        return new TagContent(DSL.name(alias), this);
    }

    @Override
    public TagContent as(Name alias) {
        return new TagContent(alias, this);
    }

    @Override
    public TagContent as(Table<?> alias) {
        return new TagContent(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public TagContent rename(String name) {
        return new TagContent(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TagContent rename(Name name) {
        return new TagContent(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public TagContent rename(Table<?> name) {
        return new TagContent(name.getQualifiedName(), null);
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