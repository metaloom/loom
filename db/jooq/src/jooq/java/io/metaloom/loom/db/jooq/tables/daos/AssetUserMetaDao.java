/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.daos;


import io.metaloom.loom.db.jooq.tables.AssetUserMeta;
import io.metaloom.loom.db.jooq.tables.records.AssetUserMetaRecord;

import java.util.List;
import java.util.UUID;

import org.jooq.Configuration;
import org.jooq.JSONB;
import org.jooq.Record2;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AssetUserMetaDao extends DAOImpl<AssetUserMetaRecord, io.metaloom.loom.db.jooq.tables.pojos.AssetUserMeta, Record2<UUID, UUID>> {

    /**
     * Create a new AssetUserMetaDao without any configuration
     */
    public AssetUserMetaDao() {
        super(AssetUserMeta.ASSET_USER_META, io.metaloom.loom.db.jooq.tables.pojos.AssetUserMeta.class);
    }

    /**
     * Create a new AssetUserMetaDao with an attached configuration
     */
    public AssetUserMetaDao(Configuration configuration) {
        super(AssetUserMeta.ASSET_USER_META, io.metaloom.loom.db.jooq.tables.pojos.AssetUserMeta.class, configuration);
    }

    @Override
    public Record2<UUID, UUID> getId(io.metaloom.loom.db.jooq.tables.pojos.AssetUserMeta object) {
        return compositeKeyRecord(object.getAssetUuid(), object.getUserUuid());
    }

    /**
     * Fetch records that have <code>asset_uuid BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.AssetUserMeta> fetchRangeOfAssetUuid(UUID lowerInclusive, UUID upperInclusive) {
        return fetchRange(AssetUserMeta.ASSET_USER_META.ASSET_UUID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>asset_uuid IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.AssetUserMeta> fetchByAssetUuid(UUID... values) {
        return fetch(AssetUserMeta.ASSET_USER_META.ASSET_UUID, values);
    }

    /**
     * Fetch records that have <code>user_uuid BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.AssetUserMeta> fetchRangeOfUserUuid(UUID lowerInclusive, UUID upperInclusive) {
        return fetchRange(AssetUserMeta.ASSET_USER_META.USER_UUID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>user_uuid IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.AssetUserMeta> fetchByUserUuid(UUID... values) {
        return fetch(AssetUserMeta.ASSET_USER_META.USER_UUID, values);
    }

    /**
     * Fetch records that have <code>rating BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.AssetUserMeta> fetchRangeOfRating(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(AssetUserMeta.ASSET_USER_META.RATING, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>rating IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.AssetUserMeta> fetchByRating(Integer... values) {
        return fetch(AssetUserMeta.ASSET_USER_META.RATING, values);
    }

    /**
     * Fetch records that have <code>meta BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.AssetUserMeta> fetchRangeOfMeta(JSONB lowerInclusive, JSONB upperInclusive) {
        return fetchRange(AssetUserMeta.ASSET_USER_META.META, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>meta IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.AssetUserMeta> fetchByMeta(JSONB... values) {
        return fetch(AssetUserMeta.ASSET_USER_META.META, values);
    }
}
