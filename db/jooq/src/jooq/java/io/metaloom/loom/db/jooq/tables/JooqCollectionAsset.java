/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.Indexes;
import io.metaloom.loom.db.jooq.JooqPublic;
import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.tables.records.JooqCollectionAssetRecord;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function2;
import org.jooq.Index;
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
 * Track assets that belong to a collection.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqCollectionAsset extends TableImpl<JooqCollectionAssetRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.collection_asset</code>
     */
    public static final JooqCollectionAsset COLLECTION_ASSET = new JooqCollectionAsset();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JooqCollectionAssetRecord> getRecordType() {
        return JooqCollectionAssetRecord.class;
    }

    /**
     * The column <code>public.collection_asset.collection_uuid</code>.
     */
    public final TableField<JooqCollectionAssetRecord, UUID> COLLECTION_UUID = createField(DSL.name("collection_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.collection_asset.asset_uuid</code>.
     */
    public final TableField<JooqCollectionAssetRecord, UUID> ASSET_UUID = createField(DSL.name("asset_uuid"), SQLDataType.UUID.nullable(false), this, "");

    private JooqCollectionAsset(Name alias, Table<JooqCollectionAssetRecord> aliased) {
        this(alias, aliased, null);
    }

    private JooqCollectionAsset(Name alias, Table<JooqCollectionAssetRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Track assets that belong to a collection."), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.collection_asset</code> table reference
     */
    public JooqCollectionAsset(String alias) {
        this(DSL.name(alias), COLLECTION_ASSET);
    }

    /**
     * Create an aliased <code>public.collection_asset</code> table reference
     */
    public JooqCollectionAsset(Name alias) {
        this(alias, COLLECTION_ASSET);
    }

    /**
     * Create a <code>public.collection_asset</code> table reference
     */
    public JooqCollectionAsset() {
        this(DSL.name("collection_asset"), null);
    }

    public <O extends Record> JooqCollectionAsset(Table<O> child, ForeignKey<O, JooqCollectionAssetRecord> key) {
        super(child, key, COLLECTION_ASSET);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : JooqPublic.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.COLLECTION_ASSET_ASSET_UUID_IDX, Indexes.COLLECTION_ASSET_COLLECTION_UUID_IDX);
    }

    @Override
    public UniqueKey<JooqCollectionAssetRecord> getPrimaryKey() {
        return Keys.COLLECTION_ASSET_PKEY;
    }

    @Override
    public List<ForeignKey<JooqCollectionAssetRecord, ?>> getReferences() {
        return Arrays.asList(Keys.COLLECTION_ASSET__COLLECTION_ASSET_COLLECTION_UUID_FKEY);
    }

    private transient JooqCollection _collection;

    /**
     * Get the implicit join path to the <code>public.collection</code> table.
     */
    public JooqCollection collection() {
        if (_collection == null)
            _collection = new JooqCollection(this, Keys.COLLECTION_ASSET__COLLECTION_ASSET_COLLECTION_UUID_FKEY);

        return _collection;
    }

    @Override
    public JooqCollectionAsset as(String alias) {
        return new JooqCollectionAsset(DSL.name(alias), this);
    }

    @Override
    public JooqCollectionAsset as(Name alias) {
        return new JooqCollectionAsset(alias, this);
    }

    @Override
    public JooqCollectionAsset as(Table<?> alias) {
        return new JooqCollectionAsset(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqCollectionAsset rename(String name) {
        return new JooqCollectionAsset(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqCollectionAsset rename(Name name) {
        return new JooqCollectionAsset(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqCollectionAsset rename(Table<?> name) {
        return new JooqCollectionAsset(name.getQualifiedName(), null);
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
