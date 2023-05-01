/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.tables.JooqTagAsset;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * Store tag &lt;-&gt; asset reference
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqTagAssetRecord extends UpdatableRecordImpl<JooqTagAssetRecord> implements Record2<UUID, UUID> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.tag_asset.tag_uuid</code>.
     */
    public void setTagUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.tag_asset.tag_uuid</code>.
     */
    public UUID getTagUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.tag_asset.asset_uuid</code>.
     */
    public void setAssetUuid(UUID value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.tag_asset.asset_uuid</code>.
     */
    public UUID getAssetUuid() {
        return (UUID) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<UUID, UUID> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<UUID, UUID> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<UUID, UUID> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return JooqTagAsset.TAG_ASSET.TAG_UUID;
    }

    @Override
    public Field<UUID> field2() {
        return JooqTagAsset.TAG_ASSET.ASSET_UUID;
    }

    @Override
    public UUID component1() {
        return getTagUuid();
    }

    @Override
    public UUID component2() {
        return getAssetUuid();
    }

    @Override
    public UUID value1() {
        return getTagUuid();
    }

    @Override
    public UUID value2() {
        return getAssetUuid();
    }

    @Override
    public JooqTagAssetRecord value1(UUID value) {
        setTagUuid(value);
        return this;
    }

    @Override
    public JooqTagAssetRecord value2(UUID value) {
        setAssetUuid(value);
        return this;
    }

    @Override
    public JooqTagAssetRecord values(UUID value1, UUID value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JooqTagAssetRecord
     */
    public JooqTagAssetRecord() {
        super(JooqTagAsset.TAG_ASSET);
    }

    /**
     * Create a detached, initialised JooqTagAssetRecord
     */
    public JooqTagAssetRecord(UUID tagUuid, UUID assetUuid) {
        super(JooqTagAsset.TAG_ASSET);

        setTagUuid(tagUuid);
        setAssetUuid(assetUuid);
    }

    /**
     * Create a detached, initialised JooqTagAssetRecord
     */
    public JooqTagAssetRecord(io.metaloom.loom.db.jooq.tables.pojos.JooqTagAsset value) {
        super(JooqTagAsset.TAG_ASSET);

        if (value != null) {
            setTagUuid(value.getTagUuid());
            setAssetUuid(value.getAssetUuid());
        }
    }
}
