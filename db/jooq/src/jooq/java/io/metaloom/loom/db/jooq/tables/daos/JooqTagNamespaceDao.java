/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.daos;


import io.metaloom.loom.db.jooq.tables.TagNamespace;
import io.metaloom.loom.db.jooq.tables.pojos.JooqTagNamespace;
import io.metaloom.loom.db.jooq.tables.records.TagNamespaceRecord;

import java.util.List;
import java.util.UUID;

import org.jooq.Configuration;
import org.jooq.Record2;
import org.jooq.impl.DAOImpl;


/**
 * Table used to taggings on namespaces
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqTagNamespaceDao extends DAOImpl<TagNamespaceRecord, JooqTagNamespace, Record2<UUID, UUID>> {

    /**
     * Create a new JooqTagNamespaceDao without any configuration
     */
    public JooqTagNamespaceDao() {
        super(TagNamespace.TAG_NAMESPACE, JooqTagNamespace.class);
    }

    /**
     * Create a new JooqTagNamespaceDao with an attached configuration
     */
    public JooqTagNamespaceDao(Configuration configuration) {
        super(TagNamespace.TAG_NAMESPACE, JooqTagNamespace.class, configuration);
    }

    @Override
    public Record2<UUID, UUID> getId(JooqTagNamespace object) {
        return compositeKeyRecord(object.getTagUuid(), object.getNamespaceUuid());
    }

    /**
     * Fetch records that have <code>tag_uuid BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<JooqTagNamespace> fetchRangeOfTagUuid(UUID lowerInclusive, UUID upperInclusive) {
        return fetchRange(TagNamespace.TAG_NAMESPACE.TAG_UUID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>tag_uuid IN (values)</code>
     */
    public List<JooqTagNamespace> fetchByTagUuid(UUID... values) {
        return fetch(TagNamespace.TAG_NAMESPACE.TAG_UUID, values);
    }

    /**
     * Fetch records that have <code>namespace_uuid BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<JooqTagNamespace> fetchRangeOfNamespaceUuid(UUID lowerInclusive, UUID upperInclusive) {
        return fetchRange(TagNamespace.TAG_NAMESPACE.NAMESPACE_UUID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>namespace_uuid IN (values)</code>
     */
    public List<JooqTagNamespace> fetchByNamespaceUuid(UUID... values) {
        return fetch(TagNamespace.TAG_NAMESPACE.NAMESPACE_UUID, values);
    }
}