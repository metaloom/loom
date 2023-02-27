/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.daos;


import io.metaloom.loom.db.jooq.tables.AssetBinarie;
import io.metaloom.loom.db.jooq.tables.records.AssetBinarieRecord;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This table stores the immutable asset information
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AssetBinarieDao extends DAOImpl<AssetBinarieRecord, io.metaloom.loom.db.jooq.tables.pojos.AssetBinarie, UUID> {

    /**
     * Create a new AssetBinarieDao without any configuration
     */
    public AssetBinarieDao() {
        super(AssetBinarie.ASSET_BINARIE, io.metaloom.loom.db.jooq.tables.pojos.AssetBinarie.class);
    }

    /**
     * Create a new AssetBinarieDao with an attached configuration
     */
    public AssetBinarieDao(Configuration configuration) {
        super(AssetBinarie.ASSET_BINARIE, io.metaloom.loom.db.jooq.tables.pojos.AssetBinarie.class, configuration);
    }

    @Override
    public UUID getId(io.metaloom.loom.db.jooq.tables.pojos.AssetBinarie object) {
        return object.getUuid();
    }

    /**
     * Fetch records that have <code>uuid BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.AssetBinarie> fetchRangeOfUuid(UUID lowerInclusive, UUID upperInclusive) {
        return fetchRange(AssetBinarie.ASSET_BINARIE.UUID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>uuid IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.AssetBinarie> fetchByUuid(UUID... values) {
        return fetch(AssetBinarie.ASSET_BINARIE.UUID, values);
    }

    /**
     * Fetch a unique record that has <code>uuid = value</code>
     */
    public io.metaloom.loom.db.jooq.tables.pojos.AssetBinarie fetchOneByUuid(UUID value) {
        return fetchOne(AssetBinarie.ASSET_BINARIE.UUID, value);
    }

    /**
     * Fetch a unique record that has <code>uuid = value</code>
     */
    public Optional<io.metaloom.loom.db.jooq.tables.pojos.AssetBinarie> fetchOptionalByUuid(UUID value) {
        return fetchOptional(AssetBinarie.ASSET_BINARIE.UUID, value);
    }

    /**
     * Fetch records that have <code>sha512sum BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.AssetBinarie> fetchRangeOfSha512sum(String lowerInclusive, String upperInclusive) {
        return fetchRange(AssetBinarie.ASSET_BINARIE.SHA512SUM, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>sha512sum IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.AssetBinarie> fetchBySha512sum(String... values) {
        return fetch(AssetBinarie.ASSET_BINARIE.SHA512SUM, values);
    }

    /**
     * Fetch records that have <code>size BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.AssetBinarie> fetchRangeOfSize(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(AssetBinarie.ASSET_BINARIE.SIZE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>size IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.AssetBinarie> fetchBySize(Long... values) {
        return fetch(AssetBinarie.ASSET_BINARIE.SIZE, values);
    }

    /**
     * Fetch records that have <code>sha256sum BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.AssetBinarie> fetchRangeOfSha256sum(String lowerInclusive, String upperInclusive) {
        return fetchRange(AssetBinarie.ASSET_BINARIE.SHA256SUM, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>sha256sum IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.AssetBinarie> fetchBySha256sum(String... values) {
        return fetch(AssetBinarie.ASSET_BINARIE.SHA256SUM, values);
    }

    /**
     * Fetch records that have <code>md5sum BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.AssetBinarie> fetchRangeOfMd5sum(String lowerInclusive, String upperInclusive) {
        return fetchRange(AssetBinarie.ASSET_BINARIE.MD5SUM, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>md5sum IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.AssetBinarie> fetchByMd5sum(String... values) {
        return fetch(AssetBinarie.ASSET_BINARIE.MD5SUM, values);
    }

    /**
     * Fetch records that have <code>media_width BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.AssetBinarie> fetchRangeOfMediaWidth(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(AssetBinarie.ASSET_BINARIE.MEDIA_WIDTH, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>media_width IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.AssetBinarie> fetchByMediaWidth(Integer... values) {
        return fetch(AssetBinarie.ASSET_BINARIE.MEDIA_WIDTH, values);
    }

    /**
     * Fetch records that have <code>media_height BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.AssetBinarie> fetchRangeOfMediaHeight(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(AssetBinarie.ASSET_BINARIE.MEDIA_HEIGHT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>media_height IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.AssetBinarie> fetchByMediaHeight(Integer... values) {
        return fetch(AssetBinarie.ASSET_BINARIE.MEDIA_HEIGHT, values);
    }

    /**
     * Fetch records that have <code>fingerprint BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.AssetBinarie> fetchRangeOfFingerprint(String lowerInclusive, String upperInclusive) {
        return fetchRange(AssetBinarie.ASSET_BINARIE.FINGERPRINT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>fingerprint IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.AssetBinarie> fetchByFingerprint(String... values) {
        return fetch(AssetBinarie.ASSET_BINARIE.FINGERPRINT, values);
    }
}