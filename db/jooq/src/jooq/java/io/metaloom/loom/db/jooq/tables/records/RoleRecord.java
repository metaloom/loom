/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.enums.LoomPermissionFlag;
import io.metaloom.loom.db.jooq.tables.Role;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RoleRecord extends UpdatableRecordImpl<RoleRecord> implements Record8<UUID, String, LoomPermissionFlag, String, LocalDateTime, UUID, LocalDateTime, UUID> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.role.uuid</code>.
     */
    public void setUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.role.uuid</code>.
     */
    public UUID getUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.role.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.role.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.role.permissions</code>.
     */
    public void setPermissions(LoomPermissionFlag value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.role.permissions</code>.
     */
    public LoomPermissionFlag getPermissions() {
        return (LoomPermissionFlag) get(2);
    }

    /**
     * Setter for <code>public.role.meta</code>. Custom meta properties to the
     * element
     */
    public void setMeta(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.role.meta</code>. Custom meta properties to the
     * element
     */
    public String getMeta() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.role.created</code>.
     */
    public void setCreated(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.role.created</code>.
     */
    public LocalDateTime getCreated() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>public.role.creator_uuid</code>.
     */
    public void setCreatorUuid(UUID value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.role.creator_uuid</code>.
     */
    public UUID getCreatorUuid() {
        return (UUID) get(5);
    }

    /**
     * Setter for <code>public.role.edited</code>.
     */
    public void setEdited(LocalDateTime value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.role.edited</code>.
     */
    public LocalDateTime getEdited() {
        return (LocalDateTime) get(6);
    }

    /**
     * Setter for <code>public.role.editor_uuid</code>.
     */
    public void setEditorUuid(UUID value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.role.editor_uuid</code>.
     */
    public UUID getEditorUuid() {
        return (UUID) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row8<UUID, String, LoomPermissionFlag, String, LocalDateTime, UUID, LocalDateTime, UUID> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    @Override
    public Row8<UUID, String, LoomPermissionFlag, String, LocalDateTime, UUID, LocalDateTime, UUID> valuesRow() {
        return (Row8) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return Role.ROLE.UUID;
    }

    @Override
    public Field<String> field2() {
        return Role.ROLE.NAME;
    }

    @Override
    public Field<LoomPermissionFlag> field3() {
        return Role.ROLE.PERMISSIONS;
    }

    @Override
    public Field<String> field4() {
        return Role.ROLE.META;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return Role.ROLE.CREATED;
    }

    @Override
    public Field<UUID> field6() {
        return Role.ROLE.CREATOR_UUID;
    }

    @Override
    public Field<LocalDateTime> field7() {
        return Role.ROLE.EDITED;
    }

    @Override
    public Field<UUID> field8() {
        return Role.ROLE.EDITOR_UUID;
    }

    @Override
    public UUID component1() {
        return getUuid();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public LoomPermissionFlag component3() {
        return getPermissions();
    }

    @Override
    public String component4() {
        return getMeta();
    }

    @Override
    public LocalDateTime component5() {
        return getCreated();
    }

    @Override
    public UUID component6() {
        return getCreatorUuid();
    }

    @Override
    public LocalDateTime component7() {
        return getEdited();
    }

    @Override
    public UUID component8() {
        return getEditorUuid();
    }

    @Override
    public UUID value1() {
        return getUuid();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public LoomPermissionFlag value3() {
        return getPermissions();
    }

    @Override
    public String value4() {
        return getMeta();
    }

    @Override
    public LocalDateTime value5() {
        return getCreated();
    }

    @Override
    public UUID value6() {
        return getCreatorUuid();
    }

    @Override
    public LocalDateTime value7() {
        return getEdited();
    }

    @Override
    public UUID value8() {
        return getEditorUuid();
    }

    @Override
    public RoleRecord value1(UUID value) {
        setUuid(value);
        return this;
    }

    @Override
    public RoleRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public RoleRecord value3(LoomPermissionFlag value) {
        setPermissions(value);
        return this;
    }

    @Override
    public RoleRecord value4(String value) {
        setMeta(value);
        return this;
    }

    @Override
    public RoleRecord value5(LocalDateTime value) {
        setCreated(value);
        return this;
    }

    @Override
    public RoleRecord value6(UUID value) {
        setCreatorUuid(value);
        return this;
    }

    @Override
    public RoleRecord value7(LocalDateTime value) {
        setEdited(value);
        return this;
    }

    @Override
    public RoleRecord value8(UUID value) {
        setEditorUuid(value);
        return this;
    }

    @Override
    public RoleRecord values(UUID value1, String value2, LoomPermissionFlag value3, String value4, LocalDateTime value5, UUID value6, LocalDateTime value7, UUID value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RoleRecord
     */
    public RoleRecord() {
        super(Role.ROLE);
    }

    /**
     * Create a detached, initialised RoleRecord
     */
    public RoleRecord(UUID uuid, String name, LoomPermissionFlag permissions, String meta, LocalDateTime created, UUID creatorUuid, LocalDateTime edited, UUID editorUuid) {
        super(Role.ROLE);

        setUuid(uuid);
        setName(name);
        setPermissions(permissions);
        setMeta(meta);
        setCreated(created);
        setCreatorUuid(creatorUuid);
        setEdited(edited);
        setEditorUuid(editorUuid);
    }
}
