/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.Indexes;
import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.Public;
import io.metaloom.loom.db.jooq.enums.LoomContentType;
import io.metaloom.loom.db.jooq.tables.records.FieldContentRecord;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * Crosstable that tracks all fields for a content
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FieldContent extends TableImpl<FieldContentRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.field_content</code>
     */
    public static final FieldContent FIELD_CONTENT = new FieldContent();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FieldContentRecord> getRecordType() {
        return FieldContentRecord.class;
    }

    /**
     * The column <code>public.field_content.fields_uuid</code>.
     */
    public final TableField<FieldContentRecord, UUID> FIELDS_UUID = createField(DSL.name("fields_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.field_content.content_uuid</code>.
     */
    public final TableField<FieldContentRecord, UUID> CONTENT_UUID = createField(DSL.name("content_uuid"), SQLDataType.UUID, this, "");

    /**
     * The column <code>public.field_content.webroot_path_info</code>. prefixed
     * with branch
     */
    public final TableField<FieldContentRecord, String> WEBROOT_PATH_INFO = createField(DSL.name("webroot_path_info"), SQLDataType.VARCHAR, this, "prefixed with branch");

    /**
     * The column <code>public.field_content.content_type</code>. D or P for
     * draft and published
     */
    public final TableField<FieldContentRecord, LoomContentType> CONTENT_TYPE = createField(DSL.name("content_type"), SQLDataType.VARCHAR.nullable(false).asEnumDataType(io.metaloom.loom.db.jooq.enums.LoomContentType.class), this, "D or P for draft and published");

    private FieldContent(Name alias, Table<FieldContentRecord> aliased) {
        this(alias, aliased, null);
    }

    private FieldContent(Name alias, Table<FieldContentRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Crosstable that tracks all fields for a content"), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.field_content</code> table reference
     */
    public FieldContent(String alias) {
        this(DSL.name(alias), FIELD_CONTENT);
    }

    /**
     * Create an aliased <code>public.field_content</code> table reference
     */
    public FieldContent(Name alias) {
        this(alias, FIELD_CONTENT);
    }

    /**
     * Create a <code>public.field_content</code> table reference
     */
    public FieldContent() {
        this(DSL.name("field_content"), null);
    }

    public <O extends Record> FieldContent(Table<O> child, ForeignKey<O, FieldContentRecord> key) {
        super(child, key, FIELD_CONTENT);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.FIELD_CONTENT_CONTENT_TYPE_WEBROOT_PATH_INFO_IDX, Indexes.FIELD_CONTENT_CONTENT_UUID_CONTENT_TYPE_IDX);
    }

    @Override
    public List<UniqueKey<FieldContentRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.FIELD_CONTENT_WEBROOT_PATH_INFO_KEY);
    }

    @Override
    public List<ForeignKey<FieldContentRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FIELD_CONTENT__FIELD_CONTENT_FIELDS_UUID_FKEY, Keys.FIELD_CONTENT__FIELD_CONTENT_CONTENT_UUID_FKEY);
    }

    private transient io.metaloom.loom.db.jooq.tables.Field _field;
    private transient Content _content;

    public io.metaloom.loom.db.jooq.tables.Field field() {
        if (_field == null)
            _field = new io.metaloom.loom.db.jooq.tables.Field(this, Keys.FIELD_CONTENT__FIELD_CONTENT_FIELDS_UUID_FKEY);

        return _field;
    }

    public Content content() {
        if (_content == null)
            _content = new Content(this, Keys.FIELD_CONTENT__FIELD_CONTENT_CONTENT_UUID_FKEY);

        return _content;
    }

    @Override
    public FieldContent as(String alias) {
        return new FieldContent(DSL.name(alias), this);
    }

    @Override
    public FieldContent as(Name alias) {
        return new FieldContent(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public FieldContent rename(String name) {
        return new FieldContent(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public FieldContent rename(Name name) {
        return new FieldContent(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<UUID, UUID, String, LoomContentType> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}
