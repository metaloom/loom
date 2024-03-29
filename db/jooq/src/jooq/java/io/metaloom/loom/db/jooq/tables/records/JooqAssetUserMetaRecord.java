/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.tables.JooqAssetUserMeta;
import io.vertx.core.json.JsonObject;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * Stores user specific metadata that can be added to asset
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqAssetUserMetaRecord extends UpdatableRecordImpl<JooqAssetUserMetaRecord> implements Record3<UUID, UUID, JsonObject> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.asset_user_meta.asset_uuid</code>.
     */
    public void setAssetUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.asset_user_meta.asset_uuid</code>.
     */
    public UUID getAssetUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.asset_user_meta.user_uuid</code>.
     */
    public void setUserUuid(UUID value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.asset_user_meta.user_uuid</code>.
     */
    public UUID getUserUuid() {
        return (UUID) get(1);
    }

    /**
     * Setter for <code>public.asset_user_meta.meta</code>. Custom meta
     * properties
     */
    public void setMeta(JsonObject value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.asset_user_meta.meta</code>. Custom meta
     * properties
     */
    public JsonObject getMeta() {
        return (JsonObject) get(2);
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
    public Row3<UUID, UUID, JsonObject> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<UUID, UUID, JsonObject> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return JooqAssetUserMeta.ASSET_USER_META.ASSET_UUID;
    }

    @Override
    public Field<UUID> field2() {
        return JooqAssetUserMeta.ASSET_USER_META.USER_UUID;
    }

    @Override
    public Field<JsonObject> field3() {
        return JooqAssetUserMeta.ASSET_USER_META.META;
    }

    @Override
    public UUID component1() {
        return getAssetUuid();
    }

    @Override
    public UUID component2() {
        return getUserUuid();
    }

    @Override
    public JsonObject component3() {
        return getMeta();
    }

    @Override
    public UUID value1() {
        return getAssetUuid();
    }

    @Override
    public UUID value2() {
        return getUserUuid();
    }

    @Override
    public JsonObject value3() {
        return getMeta();
    }

    @Override
    public JooqAssetUserMetaRecord value1(UUID value) {
        setAssetUuid(value);
        return this;
    }

    @Override
    public JooqAssetUserMetaRecord value2(UUID value) {
        setUserUuid(value);
        return this;
    }

    @Override
    public JooqAssetUserMetaRecord value3(JsonObject value) {
        setMeta(value);
        return this;
    }

    @Override
    public JooqAssetUserMetaRecord values(UUID value1, UUID value2, JsonObject value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JooqAssetUserMetaRecord
     */
    public JooqAssetUserMetaRecord() {
        super(JooqAssetUserMeta.ASSET_USER_META);
    }

    /**
     * Create a detached, initialised JooqAssetUserMetaRecord
     */
    public JooqAssetUserMetaRecord(UUID assetUuid, UUID userUuid, JsonObject meta) {
        super(JooqAssetUserMeta.ASSET_USER_META);

        setAssetUuid(assetUuid);
        setUserUuid(userUuid);
        setMeta(meta);
    }
}
