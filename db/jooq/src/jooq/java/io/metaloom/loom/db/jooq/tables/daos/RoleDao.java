/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.daos;


import io.metaloom.loom.db.jooq.enums.LoomPermissionFlag;
import io.metaloom.loom.db.jooq.tables.Role;
import io.metaloom.loom.db.jooq.tables.records.RoleRecord;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.jooq.Configuration;
import org.jooq.JSONB;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RoleDao extends DAOImpl<RoleRecord, io.metaloom.loom.db.jooq.tables.pojos.Role, UUID> {

    /**
     * Create a new RoleDao without any configuration
     */
    public RoleDao() {
        super(Role.ROLE, io.metaloom.loom.db.jooq.tables.pojos.Role.class);
    }

    /**
     * Create a new RoleDao with an attached configuration
     */
    public RoleDao(Configuration configuration) {
        super(Role.ROLE, io.metaloom.loom.db.jooq.tables.pojos.Role.class, configuration);
    }

    @Override
    public UUID getId(io.metaloom.loom.db.jooq.tables.pojos.Role object) {
        return object.getUuid();
    }

    /**
     * Fetch records that have <code>uuid BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.Role> fetchRangeOfUuid(UUID lowerInclusive, UUID upperInclusive) {
        return fetchRange(Role.ROLE.UUID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>uuid IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.Role> fetchByUuid(UUID... values) {
        return fetch(Role.ROLE.UUID, values);
    }

    /**
     * Fetch a unique record that has <code>uuid = value</code>
     */
    public io.metaloom.loom.db.jooq.tables.pojos.Role fetchOneByUuid(UUID value) {
        return fetchOne(Role.ROLE.UUID, value);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.Role> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Role.ROLE.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.Role> fetchByName(String... values) {
        return fetch(Role.ROLE.NAME, values);
    }

    /**
     * Fetch a unique record that has <code>name = value</code>
     */
    public io.metaloom.loom.db.jooq.tables.pojos.Role fetchOneByName(String value) {
        return fetchOne(Role.ROLE.NAME, value);
    }

    /**
     * Fetch records that have <code>permissions BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.Role> fetchRangeOfPermissions(LoomPermissionFlag lowerInclusive, LoomPermissionFlag upperInclusive) {
        return fetchRange(Role.ROLE.PERMISSIONS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>permissions IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.Role> fetchByPermissions(LoomPermissionFlag... values) {
        return fetch(Role.ROLE.PERMISSIONS, values);
    }

    /**
     * Fetch records that have <code>meta BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.Role> fetchRangeOfMeta(JSONB lowerInclusive, JSONB upperInclusive) {
        return fetchRange(Role.ROLE.META, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>meta IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.Role> fetchByMeta(JSONB... values) {
        return fetch(Role.ROLE.META, values);
    }

    /**
     * Fetch records that have <code>created BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.Role> fetchRangeOfCreated(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(Role.ROLE.CREATED, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>created IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.Role> fetchByCreated(LocalDateTime... values) {
        return fetch(Role.ROLE.CREATED, values);
    }

    /**
     * Fetch records that have <code>creator_uuid BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.Role> fetchRangeOfCreatorUuid(UUID lowerInclusive, UUID upperInclusive) {
        return fetchRange(Role.ROLE.CREATOR_UUID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>creator_uuid IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.Role> fetchByCreatorUuid(UUID... values) {
        return fetch(Role.ROLE.CREATOR_UUID, values);
    }

    /**
     * Fetch records that have <code>edited BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.Role> fetchRangeOfEdited(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(Role.ROLE.EDITED, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>edited IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.Role> fetchByEdited(LocalDateTime... values) {
        return fetch(Role.ROLE.EDITED, values);
    }

    /**
     * Fetch records that have <code>editor_uuid BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.Role> fetchRangeOfEditorUuid(UUID lowerInclusive, UUID upperInclusive) {
        return fetchRange(Role.ROLE.EDITOR_UUID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>editor_uuid IN (values)</code>
     */
    public List<io.metaloom.loom.db.jooq.tables.pojos.Role> fetchByEditorUuid(UUID... values) {
        return fetch(Role.ROLE.EDITOR_UUID, values);
    }
}
