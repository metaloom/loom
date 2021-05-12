/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;
import io.metaloom.loom.db.jooq.tables.TagAsset;
import io.metaloom.loom.db.jooq.tables.interfaces.ITagAsset;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TagAssetRecord extends UpdatableRecordImpl<TagAssetRecord> implements VertxPojo, Record2<UUID, UUID>, ITagAsset {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.tag_asset.tag_uuid</code>.
     */
    @Override
    public TagAssetRecord setTagUuid(UUID value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.tag_asset.tag_uuid</code>.
     */
    @Override
    public UUID getTagUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.tag_asset.asset_uuid</code>.
     */
    @Override
    public TagAssetRecord setAssetUuid(UUID value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.tag_asset.asset_uuid</code>.
     */
    @Override
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
        return TagAsset.TAG_ASSET.TAG_UUID;
    }

    @Override
    public Field<UUID> field2() {
        return TagAsset.TAG_ASSET.ASSET_UUID;
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
    public TagAssetRecord value1(UUID value) {
        setTagUuid(value);
        return this;
    }

    @Override
    public TagAssetRecord value2(UUID value) {
        setAssetUuid(value);
        return this;
    }

    @Override
    public TagAssetRecord values(UUID value1, UUID value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(ITagAsset from) {
        setTagUuid(from.getTagUuid());
        setAssetUuid(from.getAssetUuid());
    }

    @Override
    public <E extends ITagAsset> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TagAssetRecord
     */
    public TagAssetRecord() {
        super(TagAsset.TAG_ASSET);
    }

    /**
     * Create a detached, initialised TagAssetRecord
     */
    public TagAssetRecord(UUID tagUuid, UUID assetUuid) {
        super(TagAsset.TAG_ASSET);

        setTagUuid(tagUuid);
        setAssetUuid(assetUuid);
    }

        public TagAssetRecord(io.vertx.core.json.JsonObject json) {
                this();
                fromJson(json);
        }
}
