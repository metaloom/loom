/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.tables.FieldAsset;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * Crosstable which tracks the used assets in a fields record
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FieldAssetRecord extends UpdatableRecordImpl<FieldAssetRecord> implements Record3<UUID, UUID, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.field_asset.field_uuid</code>.
     */
    public void setFieldUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.field_asset.field_uuid</code>.
     */
    public UUID getFieldUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.field_asset.asset_uuid</code>.
     */
    public void setAssetUuid(UUID value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.field_asset.asset_uuid</code>.
     */
    public UUID getAssetUuid() {
        return (UUID) get(1);
    }

    /**
     * Setter for <code>public.field_asset.field_name</code>.
     */
    public void setFieldName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.field_asset.field_name</code>.
     */
    public String getFieldName() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<UUID, UUID> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<UUID, UUID, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<UUID, UUID, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return FieldAsset.FIELD_ASSET.FIELD_UUID;
    }

    @Override
    public Field<UUID> field2() {
        return FieldAsset.FIELD_ASSET.ASSET_UUID;
    }

    @Override
    public Field<String> field3() {
        return FieldAsset.FIELD_ASSET.FIELD_NAME;
    }

    @Override
    public UUID component1() {
        return getFieldUuid();
    }

    @Override
    public UUID component2() {
        return getAssetUuid();
    }

    @Override
    public String component3() {
        return getFieldName();
    }

    @Override
    public UUID value1() {
        return getFieldUuid();
    }

    @Override
    public UUID value2() {
        return getAssetUuid();
    }

    @Override
    public String value3() {
        return getFieldName();
    }

    @Override
    public FieldAssetRecord value1(UUID value) {
        setFieldUuid(value);
        return this;
    }

    @Override
    public FieldAssetRecord value2(UUID value) {
        setAssetUuid(value);
        return this;
    }

    @Override
    public FieldAssetRecord value3(String value) {
        setFieldName(value);
        return this;
    }

    @Override
    public FieldAssetRecord values(UUID value1, UUID value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached FieldAssetRecord
     */
    public FieldAssetRecord() {
        super(FieldAsset.FIELD_ASSET);
    }

    /**
     * Create a detached, initialised FieldAssetRecord
     */
    public FieldAssetRecord(UUID fieldUuid, UUID assetUuid, String fieldName) {
        super(FieldAsset.FIELD_ASSET);

        setFieldUuid(fieldUuid);
        setAssetUuid(assetUuid);
        setFieldName(fieldName);
    }

    /**
     * Create a detached, initialised FieldAssetRecord
     */
    public FieldAssetRecord(io.metaloom.loom.db.jooq.tables.pojos.FieldAsset value) {
        super(FieldAsset.FIELD_ASSET);

        if (value != null) {
            setFieldUuid(value.getFieldUuid());
            setAssetUuid(value.getAssetUuid());
            setFieldName(value.getFieldName());
        }
    }
}
