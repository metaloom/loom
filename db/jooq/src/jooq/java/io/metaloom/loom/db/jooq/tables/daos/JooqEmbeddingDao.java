/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.daos;


import io.metaloom.loom.db.jooq.enums.JooqEmbeddingType;
import io.metaloom.loom.db.jooq.tables.JooqEmbedding;
import io.metaloom.loom.db.jooq.tables.records.JooqEmbeddingRecord;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.jooq.Configuration;
import org.jooq.JSONB;
import org.jooq.impl.DAOImpl;


/**
 * Embedding information which was extracted from a binary.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqEmbeddingDao extends DAOImpl<JooqEmbeddingRecord, io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding, UUID> {

    /**
     * Create a new JooqEmbeddingDao without any configuration
     */
    public JooqEmbeddingDao() {
        super(JooqEmbedding.EMBEDDING, io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding.class);
    }

    /**
     * Create a new JooqEmbeddingDao with an attached configuration
     */
    public JooqEmbeddingDao(Configuration configuration) {
        super(JooqEmbedding.EMBEDDING, io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding.class, configuration);
    }

    @Override
    public UUID getId(io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding object) {
        return object.getUuid();
    }

    /**
     * Fetch records that have <code>uuid BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchRangeOfJooqUuid(UUID lowerInclusive, UUID upperInclusive) {
        return fetchRange(JooqEmbedding.EMBEDDING.UUID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>uuid IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchByJooqUuid(UUID... values) {
        return fetch(JooqEmbedding.EMBEDDING.UUID, values);
    }

    /**
     * Fetch a unique record that has <code>uuid = value</code>
     */
    public io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding fetchOneByJooqUuid(UUID value) {
        return fetchOne(JooqEmbedding.EMBEDDING.UUID, value);
    }

    /**
     * Fetch a unique record that has <code>uuid = value</code>
     */
    public Optional<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchOptionalByJooqUuid(UUID value) {
        return fetchOptional(JooqEmbedding.EMBEDDING.UUID, value);
    }

    /**
     * Fetch records that have <code>meta BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchRangeOfJooqMeta(JSONB lowerInclusive, JSONB upperInclusive) {
        return fetchRange(JooqEmbedding.EMBEDDING.META, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>meta IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchByJooqMeta(JSONB... values) {
        return fetch(JooqEmbedding.EMBEDDING.META, values);
    }

    /**
     * Fetch records that have <code>source BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchRangeOfJooqSource(String lowerInclusive, String upperInclusive) {
        return fetchRange(JooqEmbedding.EMBEDDING.SOURCE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>source IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchByJooqSource(String... values) {
        return fetch(JooqEmbedding.EMBEDDING.SOURCE, values);
    }

    /**
     * Fetch records that have <code>frame BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchRangeOfJooqFrame(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JooqEmbedding.EMBEDDING.FRAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>frame IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchByJooqFrame(Integer... values) {
        return fetch(JooqEmbedding.EMBEDDING.FRAME, values);
    }

    /**
     * Fetch records that have <code>areaHeight BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchRangeOfJooqAreaheight(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JooqEmbedding.EMBEDDING.AREAHEIGHT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>areaHeight IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchByJooqAreaheight(Integer... values) {
        return fetch(JooqEmbedding.EMBEDDING.AREAHEIGHT, values);
    }

    /**
     * Fetch records that have <code>areaWidth BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchRangeOfJooqAreawidth(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JooqEmbedding.EMBEDDING.AREAWIDTH, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>areaWidth IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchByJooqAreawidth(Integer... values) {
        return fetch(JooqEmbedding.EMBEDDING.AREAWIDTH, values);
    }

    /**
     * Fetch records that have <code>areaStartX BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchRangeOfJooqAreastartx(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JooqEmbedding.EMBEDDING.AREASTARTX, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>areaStartX IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchByJooqAreastartx(Integer... values) {
        return fetch(JooqEmbedding.EMBEDDING.AREASTARTX, values);
    }

    /**
     * Fetch records that have <code>areaStartY BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchRangeOfJooqAreastarty(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JooqEmbedding.EMBEDDING.AREASTARTY, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>areaStartY IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchByJooqAreastarty(Integer... values) {
        return fetch(JooqEmbedding.EMBEDDING.AREASTARTY, values);
    }

    /**
     * Fetch records that have <code>embeddings BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchRangeOfJooqEmbeddings(byte[] lowerInclusive, byte[] upperInclusive) {
        return fetchRange(JooqEmbedding.EMBEDDING.EMBEDDINGS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>embeddings IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchByJooqEmbeddings(byte[]... values) {
        return fetch(JooqEmbedding.EMBEDDING.EMBEDDINGS, values);
    }

    /**
     * Fetch records that have <code>embedding_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchRangeOfJooqEmbeddingId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(JooqEmbedding.EMBEDDING.EMBEDDING_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>embedding_id IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchByJooqEmbeddingId(Long... values) {
        return fetch(JooqEmbedding.EMBEDDING.EMBEDDING_ID, values);
    }

    /**
     * Fetch records that have <code>embedding_type BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchRangeOfJooqEmbeddingType(JooqEmbeddingType lowerInclusive, JooqEmbeddingType upperInclusive) {
        return fetchRange(JooqEmbedding.EMBEDDING.EMBEDDING_TYPE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>embedding_type IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchByJooqEmbeddingType(JooqEmbeddingType... values) {
        return fetch(JooqEmbedding.EMBEDDING.EMBEDDING_TYPE, values);
    }

    /**
     * Fetch records that have <code>created BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchRangeOfJooqCreated(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(JooqEmbedding.EMBEDDING.CREATED, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>created IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchByJooqCreated(LocalDateTime... values) {
        return fetch(JooqEmbedding.EMBEDDING.CREATED, values);
    }

    /**
     * Fetch records that have <code>creator_uuid BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchRangeOfJooqCreatorUuid(UUID lowerInclusive, UUID upperInclusive) {
        return fetchRange(JooqEmbedding.EMBEDDING.CREATOR_UUID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>creator_uuid IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchByJooqCreatorUuid(UUID... values) {
        return fetch(JooqEmbedding.EMBEDDING.CREATOR_UUID, values);
    }

    /**
     * Fetch records that have <code>edited BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchRangeOfJooqEdited(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(JooqEmbedding.EMBEDDING.EDITED, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>edited IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchByJooqEdited(LocalDateTime... values) {
        return fetch(JooqEmbedding.EMBEDDING.EDITED, values);
    }

    /**
     * Fetch records that have <code>editor_uuid BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchRangeOfJooqEditorUuid(UUID lowerInclusive, UUID upperInclusive) {
        return fetchRange(JooqEmbedding.EMBEDDING.EDITOR_UUID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>editor_uuid IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchByJooqEditorUuid(UUID... values) {
        return fetch(JooqEmbedding.EMBEDDING.EDITOR_UUID, values);
    }

    /**
     * Fetch records that have <code>binary_uuid BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchRangeOfJooqBinaryUuid(UUID lowerInclusive, UUID upperInclusive) {
        return fetchRange(JooqEmbedding.EMBEDDING.BINARY_UUID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>binary_uuid IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqEmbedding> fetchByJooqBinaryUuid(UUID... values) {
        return fetch(JooqEmbedding.EMBEDDING.BINARY_UUID, values);
    }
}
