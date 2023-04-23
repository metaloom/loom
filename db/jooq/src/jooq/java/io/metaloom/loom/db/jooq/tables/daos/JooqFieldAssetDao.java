/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.daos;


import io.metaloom.loom.db.jooq.tables.JooqFieldAsset;
import io.metaloom.loom.db.jooq.tables.records.JooqFieldAssetRecord;

import java.util.List;
import java.util.UUID;

import org.jooq.Configuration;
import org.jooq.Record2;
import org.jooq.impl.DAOImpl;


/**
 * Crosstable which tracks the used assets in a fields record
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqFieldAssetDao extends DAOImpl<JooqFieldAssetRecord, io.metaloom.loom.db.jooq.tables.pojos.JooqFieldAsset, Record2<UUID, UUID>> {

    /**
     * Create a new JooqFieldAssetDao without any configuration
     */
    public JooqFieldAssetDao() {
        super(JooqFieldAsset.FIELD_ASSET, io.metaloom.loom.db.jooq.tables.pojos.JooqFieldAsset.class);
    }

    /**
     * Create a new JooqFieldAssetDao with an attached configuration
     */
    public JooqFieldAssetDao(Configuration configuration) {
        super(JooqFieldAsset.FIELD_ASSET, io.metaloom.loom.db.jooq.tables.pojos.JooqFieldAsset.class, configuration);
    }

    @Override
    public Record2<UUID, UUID> getId(io.metaloom.loom.db.jooq.tables.pojos.JooqFieldAsset object) {
        return compositeKeyRecord(object.getFieldUuid(), object.getAssetUuid());
    }

    /**
     * Fetch records that have <code>field_uuid BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqFieldAsset> fetchRangeOfJooqFieldUuid(UUID lowerInclusive, UUID upperInclusive) {
        return fetchRange(JooqFieldAsset.FIELD_ASSET.FIELD_UUID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>field_uuid IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqFieldAsset> fetchByJooqFieldUuid(UUID... values) {
        return fetch(JooqFieldAsset.FIELD_ASSET.FIELD_UUID, values);
    }

    /**
     * Fetch records that have <code>asset_uuid BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqFieldAsset> fetchRangeOfJooqAssetUuid(UUID lowerInclusive, UUID upperInclusive) {
        return fetchRange(JooqFieldAsset.FIELD_ASSET.ASSET_UUID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>asset_uuid IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqFieldAsset> fetchByJooqAssetUuid(UUID... values) {
        return fetch(JooqFieldAsset.FIELD_ASSET.ASSET_UUID, values);
    }

    /**
     * Fetch records that have <code>field_name BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqFieldAsset> fetchRangeOfJooqFieldName(String lowerInclusive, String upperInclusive) {
        return fetchRange(JooqFieldAsset.FIELD_ASSET.FIELD_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>field_name IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqFieldAsset> fetchByJooqFieldName(String... values) {
        return fetch(JooqFieldAsset.FIELD_ASSET.FIELD_NAME, values);
    }
}
