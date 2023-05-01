/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.daos;


import io.metaloom.loom.db.jooq.enums.JooqLoomPermission;
import io.metaloom.loom.db.jooq.tables.JooqUserPermission;
import io.metaloom.loom.db.jooq.tables.records.JooqUserPermissionRecord;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqUserPermissionDao extends DAOImpl<JooqUserPermissionRecord, io.metaloom.loom.db.jooq.tables.pojos.JooqUserPermission, UUID> {

    /**
     * Create a new JooqUserPermissionDao without any configuration
     */
    public JooqUserPermissionDao() {
        super(JooqUserPermission.USER_PERMISSION, io.metaloom.loom.db.jooq.tables.pojos.JooqUserPermission.class);
    }

    /**
     * Create a new JooqUserPermissionDao with an attached configuration
     */
    public JooqUserPermissionDao(Configuration configuration) {
        super(JooqUserPermission.USER_PERMISSION, io.metaloom.loom.db.jooq.tables.pojos.JooqUserPermission.class, configuration);
    }

    @Override
    public UUID getId(io.metaloom.loom.db.jooq.tables.pojos.JooqUserPermission object) {
        return object.getUserUuid();
    }

    /**
     * Fetch records that have <code>user_uuid BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqUserPermission> fetchRangeOfJooqUserUuid(UUID lowerInclusive, UUID upperInclusive) {
        return fetchRange(JooqUserPermission.USER_PERMISSION.USER_UUID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>user_uuid IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqUserPermission> fetchByJooqUserUuid(UUID... values) {
        return fetch(JooqUserPermission.USER_PERMISSION.USER_UUID, values);
    }

    /**
     * Fetch a unique record that has <code>user_uuid = value</code>
     */
    public io.metaloom.loom.db.jooq.tables.pojos.JooqUserPermission fetchOneByJooqUserUuid(UUID value) {
        return fetchOne(JooqUserPermission.USER_PERMISSION.USER_UUID, value);
    }

    /**
     * Fetch a unique record that has <code>user_uuid = value</code>
     */
    public Optional<io.metaloom.loom.db.jooq.tables.pojos.JooqUserPermission> fetchOptionalByJooqUserUuid(UUID value) {
        return fetchOptional(JooqUserPermission.USER_PERMISSION.USER_UUID, value);
    }

    /**
     * Fetch records that have <code>resource BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqUserPermission> fetchRangeOfJooqResource(String lowerInclusive, String upperInclusive) {
        return fetchRange(JooqUserPermission.USER_PERMISSION.RESOURCE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>resource IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqUserPermission> fetchByJooqResource(String... values) {
        return fetch(JooqUserPermission.USER_PERMISSION.RESOURCE, values);
    }

    /**
     * Fetch records that have <code>permission BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqUserPermission> fetchRangeOfJooqPermission(JooqLoomPermission lowerInclusive, JooqLoomPermission upperInclusive) {
        return fetchRange(JooqUserPermission.USER_PERMISSION.PERMISSION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>permission IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.JooqUserPermission> fetchByJooqPermission(JooqLoomPermission... values) {
        return fetch(JooqUserPermission.USER_PERMISSION.PERMISSION, values);
    }
}
