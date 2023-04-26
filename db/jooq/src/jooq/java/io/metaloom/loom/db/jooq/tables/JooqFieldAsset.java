/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.JooqPublic;
import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.tables.records.JooqFieldAssetRecord;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function3;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row3;
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
 * Crosstable which tracks the used assets in a fields record
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqFieldAsset extends TableImpl<JooqFieldAssetRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.field_asset</code>
     */
    public static final JooqFieldAsset FIELD_ASSET = new JooqFieldAsset();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JooqFieldAssetRecord> getRecordType() {
        return JooqFieldAssetRecord.class;
    }

    /**
     * The column <code>public.field_asset.field_uuid</code>.
     */
    public final TableField<JooqFieldAssetRecord, UUID> FIELD_UUID = createField(DSL.name("field_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.field_asset.asset_uuid</code>.
     */
    public final TableField<JooqFieldAssetRecord, UUID> ASSET_UUID = createField(DSL.name("asset_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.field_asset.field_name</code>.
     */
    public final TableField<JooqFieldAssetRecord, String> FIELD_NAME = createField(DSL.name("field_name"), SQLDataType.VARCHAR, this, "");

    private JooqFieldAsset(Name alias, Table<JooqFieldAssetRecord> aliased) {
        this(alias, aliased, null);
    }

    private JooqFieldAsset(Name alias, Table<JooqFieldAssetRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Crosstable which tracks the used assets in a fields record"), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.field_asset</code> table reference
     */
    public JooqFieldAsset(String alias) {
        this(DSL.name(alias), FIELD_ASSET);
    }

    /**
     * Create an aliased <code>public.field_asset</code> table reference
     */
    public JooqFieldAsset(Name alias) {
        this(alias, FIELD_ASSET);
    }

    /**
     * Create a <code>public.field_asset</code> table reference
     */
    public JooqFieldAsset() {
        this(DSL.name("field_asset"), null);
    }

    public <O extends Record> JooqFieldAsset(Table<O> child, ForeignKey<O, JooqFieldAssetRecord> key) {
        super(child, key, FIELD_ASSET);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : JooqPublic.PUBLIC;
    }

    @Override
    public UniqueKey<JooqFieldAssetRecord> getPrimaryKey() {
        return Keys.FIELD_ASSET_PKEY;
    }

    @Override
    public List<ForeignKey<JooqFieldAssetRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FIELD_ASSET__FIELD_ASSET_FIELD_UUID_FKEY, Keys.FIELD_ASSET__FIELD_ASSET_ASSET_UUID_FKEY);
    }

    private transient JooqField _field;
    private transient JooqAsset _asset;

    /**
     * Get the implicit join path to the <code>public.field</code> table.
     */
    public JooqField field() {
        if (_field == null)
            _field = new JooqField(this, Keys.FIELD_ASSET__FIELD_ASSET_FIELD_UUID_FKEY);

        return _field;
    }

    /**
     * Get the implicit join path to the <code>public.asset</code> table.
     */
    public JooqAsset asset() {
        if (_asset == null)
            _asset = new JooqAsset(this, Keys.FIELD_ASSET__FIELD_ASSET_ASSET_UUID_FKEY);

        return _asset;
    }

    @Override
    public JooqFieldAsset as(String alias) {
        return new JooqFieldAsset(DSL.name(alias), this);
    }

    @Override
    public JooqFieldAsset as(Name alias) {
        return new JooqFieldAsset(alias, this);
    }

    @Override
    public JooqFieldAsset as(Table<?> alias) {
        return new JooqFieldAsset(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqFieldAsset rename(String name) {
        return new JooqFieldAsset(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqFieldAsset rename(Name name) {
        return new JooqFieldAsset(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqFieldAsset rename(Table<?> name) {
        return new JooqFieldAsset(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<UUID, UUID, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function3<? super UUID, ? super UUID, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function3<? super UUID, ? super UUID, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}