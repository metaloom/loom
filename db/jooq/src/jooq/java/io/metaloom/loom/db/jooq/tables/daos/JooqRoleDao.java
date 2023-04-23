/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.daos;


import io.metaloom.loom.db.jooq.tables.Role;
import io.metaloom.loom.db.jooq.tables.pojos.JooqRole;
import io.metaloom.loom.db.jooq.tables.records.RoleRecord;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.jooq.Configuration;
import org.jooq.JSONB;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqRoleDao extends DAOImpl<RoleRecord, JooqRole, UUID> {

    /**
     * Create a new JooqRoleDao without any configuration
     */
    public JooqRoleDao() {
        super(Role.ROLE, JooqRole.class);
    }

    /**
     * Create a new JooqRoleDao with an attached configuration
     */
    public JooqRoleDao(Configuration configuration) {
        super(Role.ROLE, JooqRole.class, configuration);
    }

    @Override
    public UUID getId(JooqRole object) {
        return object.getUuid();
    }

    /**
     * Fetch records that have <code>uuid BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<JooqRole> fetchRangeOfUuid(UUID lowerInclusive, UUID upperInclusive) {
        return fetchRange(Role.ROLE.UUID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>uuid IN (values)</code>
     */
    public List<JooqRole> fetchByUuid(UUID... values) {
        return fetch(Role.ROLE.UUID, values);
    }

    /**
     * Fetch a unique record that has <code>uuid = value</code>
     */
    public JooqRole fetchOneByUuid(UUID value) {
        return fetchOne(Role.ROLE.UUID, value);
    }

    /**
     * Fetch a unique record that has <code>uuid = value</code>
     */
    public Optional<JooqRole> fetchOptionalByUuid(UUID value) {
        return fetchOptional(Role.ROLE.UUID, value);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<JooqRole> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Role.ROLE.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<JooqRole> fetchByName(String... values) {
        return fetch(Role.ROLE.NAME, values);
    }

    /**
     * Fetch a unique record that has <code>name = value</code>
     */
    public JooqRole fetchOneByName(String value) {
        return fetchOne(Role.ROLE.NAME, value);
    }

    /**
     * Fetch a unique record that has <code>name = value</code>
     */
    public Optional<JooqRole> fetchOptionalByName(String value) {
        return fetchOptional(Role.ROLE.NAME, value);
    }

    /**
     * Fetch records that have <code>meta BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<JooqRole> fetchRangeOfMeta(JSONB lowerInclusive, JSONB upperInclusive) {
        return fetchRange(Role.ROLE.META, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>meta IN (values)</code>
     */
    public List<JooqRole> fetchByMeta(JSONB... values) {
        return fetch(Role.ROLE.META, values);
    }

    /**
     * Fetch records that have <code>created BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<JooqRole> fetchRangeOfCreated(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(Role.ROLE.CREATED, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>created IN (values)</code>
     */
    public List<JooqRole> fetchByCreated(LocalDateTime... values) {
        return fetch(Role.ROLE.CREATED, values);
    }

    /**
     * Fetch records that have <code>creator_uuid BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<JooqRole> fetchRangeOfCreatorUuid(UUID lowerInclusive, UUID upperInclusive) {
        return fetchRange(Role.ROLE.CREATOR_UUID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>creator_uuid IN (values)</code>
     */
    public List<JooqRole> fetchByCreatorUuid(UUID... values) {
        return fetch(Role.ROLE.CREATOR_UUID, values);
    }

    /**
     * Fetch records that have <code>edited BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<JooqRole> fetchRangeOfEdited(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(Role.ROLE.EDITED, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>edited IN (values)</code>
     */
    public List<JooqRole> fetchByEdited(LocalDateTime... values) {
        return fetch(Role.ROLE.EDITED, values);
    }

    /**
     * Fetch records that have <code>editor_uuid BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<JooqRole> fetchRangeOfEditorUuid(UUID lowerInclusive, UUID upperInclusive) {
        return fetchRange(Role.ROLE.EDITOR_UUID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>editor_uuid IN (values)</code>
     */
    public List<JooqRole> fetchByEditorUuid(UUID... values) {
        return fetch(Role.ROLE.EDITOR_UUID, values);
    }
}
