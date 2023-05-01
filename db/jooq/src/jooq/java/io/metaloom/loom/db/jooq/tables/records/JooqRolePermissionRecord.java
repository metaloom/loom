/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.enums.JooqLoomPermission;
import io.metaloom.loom.db.jooq.tables.JooqRolePermission;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqRolePermissionRecord extends UpdatableRecordImpl<JooqRolePermissionRecord> implements Record3<UUID, String, JooqLoomPermission> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.role_permission.role_uuid</code>.
     */
    public void setRoleUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.role_permission.role_uuid</code>.
     */
    public UUID getRoleUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.role_permission.resource</code>.
     */
    public void setResource(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.role_permission.resource</code>.
     */
    public String getResource() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.role_permission.permission</code>. Permission
     * granted / granted to the resource
     */
    public void setPermission(JooqLoomPermission value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.role_permission.permission</code>. Permission
     * granted / granted to the resource
     */
    public JooqLoomPermission getPermission() {
        return (JooqLoomPermission) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<UUID, String, JooqLoomPermission> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<UUID, String, JooqLoomPermission> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return JooqRolePermission.ROLE_PERMISSION.ROLE_UUID;
    }

    @Override
    public Field<String> field2() {
        return JooqRolePermission.ROLE_PERMISSION.RESOURCE;
    }

    @Override
    public Field<JooqLoomPermission> field3() {
        return JooqRolePermission.ROLE_PERMISSION.PERMISSION;
    }

    @Override
    public UUID component1() {
        return getRoleUuid();
    }

    @Override
    public String component2() {
        return getResource();
    }

    @Override
    public JooqLoomPermission component3() {
        return getPermission();
    }

    @Override
    public UUID value1() {
        return getRoleUuid();
    }

    @Override
    public String value2() {
        return getResource();
    }

    @Override
    public JooqLoomPermission value3() {
        return getPermission();
    }

    @Override
    public JooqRolePermissionRecord value1(UUID value) {
        setRoleUuid(value);
        return this;
    }

    @Override
    public JooqRolePermissionRecord value2(String value) {
        setResource(value);
        return this;
    }

    @Override
    public JooqRolePermissionRecord value3(JooqLoomPermission value) {
        setPermission(value);
        return this;
    }

    @Override
    public JooqRolePermissionRecord values(UUID value1, String value2, JooqLoomPermission value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JooqRolePermissionRecord
     */
    public JooqRolePermissionRecord() {
        super(JooqRolePermission.ROLE_PERMISSION);
    }

    /**
     * Create a detached, initialised JooqRolePermissionRecord
     */
    public JooqRolePermissionRecord(UUID roleUuid, String resource, JooqLoomPermission permission) {
        super(JooqRolePermission.ROLE_PERMISSION);

        setRoleUuid(roleUuid);
        setResource(resource);
        setPermission(permission);
    }

    /**
     * Create a detached, initialised JooqRolePermissionRecord
     */
    public JooqRolePermissionRecord(io.metaloom.loom.db.jooq.tables.pojos.JooqRolePermission value) {
        super(JooqRolePermission.ROLE_PERMISSION);

        if (value != null) {
            setRoleUuid(value.getRoleUuid());
            setResource(value.getResource());
            setPermission(value.getPermission());
        }
    }
}
