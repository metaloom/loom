/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.enums.LoomPermissionFlag;
import io.metaloom.loom.db.jooq.tables.User;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.JSONB;
import org.jooq.Record1;
import org.jooq.Record14;
import org.jooq.Row14;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserRecord extends UpdatableRecordImpl<UserRecord> implements Record14<UUID, String, String, String, String, String, Boolean, Boolean, JSONB, LoomPermissionFlag, LocalDateTime, UUID, LocalDateTime, UUID> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.user.uuid</code>.
     */
    public void setUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.user.uuid</code>.
     */
    public UUID getUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.user.username</code>.
     */
    public void setUsername(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.user.username</code>.
     */
    public String getUsername() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.user.firstname</code>.
     */
    public void setFirstname(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.user.firstname</code>.
     */
    public String getFirstname() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.user.lastname</code>.
     */
    public void setLastname(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.user.lastname</code>.
     */
    public String getLastname() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.user.passwordhash</code>.
     */
    public void setPasswordhash(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.user.passwordhash</code>.
     */
    public String getPasswordhash() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.user.email</code>.
     */
    public void setEmail(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.user.email</code>.
     */
    public String getEmail() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.user.enabled</code>. Flag to enable or disable
     * the user.
     */
    public void setEnabled(Boolean value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.user.enabled</code>. Flag to enable or disable
     * the user.
     */
    public Boolean getEnabled() {
        return (Boolean) get(6);
    }

    /**
     * Setter for <code>public.user.sso</code>. Flag that indicates that the
     * user was created via SSO mappings
     */
    public void setSso(Boolean value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.user.sso</code>. Flag that indicates that the
     * user was created via SSO mappings
     */
    public Boolean getSso() {
        return (Boolean) get(7);
    }

    /**
     * Setter for <code>public.user.meta</code>. Custom meta properties to the
     * element
     */
    public void setMeta(JSONB value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.user.meta</code>. Custom meta properties to the
     * element
     */
    public JSONB getMeta() {
        return (JSONB) get(8);
    }

    /**
     * Setter for <code>public.user.permissions</code>.
     */
    public void setPermissions(LoomPermissionFlag value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.user.permissions</code>.
     */
    public LoomPermissionFlag getPermissions() {
        return (LoomPermissionFlag) get(9);
    }

    /**
     * Setter for <code>public.user.created</code>.
     */
    public void setCreated(LocalDateTime value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.user.created</code>.
     */
    public LocalDateTime getCreated() {
        return (LocalDateTime) get(10);
    }

    /**
     * Setter for <code>public.user.creator_uuid</code>.
     */
    public void setCreatorUuid(UUID value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.user.creator_uuid</code>.
     */
    public UUID getCreatorUuid() {
        return (UUID) get(11);
    }

    /**
     * Setter for <code>public.user.edited</code>.
     */
    public void setEdited(LocalDateTime value) {
        set(12, value);
    }

    /**
     * Getter for <code>public.user.edited</code>.
     */
    public LocalDateTime getEdited() {
        return (LocalDateTime) get(12);
    }

    /**
     * Setter for <code>public.user.editor_uuid</code>.
     */
    public void setEditorUuid(UUID value) {
        set(13, value);
    }

    /**
     * Getter for <code>public.user.editor_uuid</code>.
     */
    public UUID getEditorUuid() {
        return (UUID) get(13);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record14 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row14<UUID, String, String, String, String, String, Boolean, Boolean, JSONB, LoomPermissionFlag, LocalDateTime, UUID, LocalDateTime, UUID> fieldsRow() {
        return (Row14) super.fieldsRow();
    }

    @Override
    public Row14<UUID, String, String, String, String, String, Boolean, Boolean, JSONB, LoomPermissionFlag, LocalDateTime, UUID, LocalDateTime, UUID> valuesRow() {
        return (Row14) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return User.USER.UUID;
    }

    @Override
    public Field<String> field2() {
        return User.USER.USERNAME;
    }

    @Override
    public Field<String> field3() {
        return User.USER.FIRSTNAME;
    }

    @Override
    public Field<String> field4() {
        return User.USER.LASTNAME;
    }

    @Override
    public Field<String> field5() {
        return User.USER.PASSWORDHASH;
    }

    @Override
    public Field<String> field6() {
        return User.USER.EMAIL;
    }

    @Override
    public Field<Boolean> field7() {
        return User.USER.ENABLED;
    }

    @Override
    public Field<Boolean> field8() {
        return User.USER.SSO;
    }

    @Override
    public Field<JSONB> field9() {
        return User.USER.META;
    }

    @Override
    public Field<LoomPermissionFlag> field10() {
        return User.USER.PERMISSIONS;
    }

    @Override
    public Field<LocalDateTime> field11() {
        return User.USER.CREATED;
    }

    @Override
    public Field<UUID> field12() {
        return User.USER.CREATOR_UUID;
    }

    @Override
    public Field<LocalDateTime> field13() {
        return User.USER.EDITED;
    }

    @Override
    public Field<UUID> field14() {
        return User.USER.EDITOR_UUID;
    }

    @Override
    public UUID component1() {
        return getUuid();
    }

    @Override
    public String component2() {
        return getUsername();
    }

    @Override
    public String component3() {
        return getFirstname();
    }

    @Override
    public String component4() {
        return getLastname();
    }

    @Override
    public String component5() {
        return getPasswordhash();
    }

    @Override
    public String component6() {
        return getEmail();
    }

    @Override
    public Boolean component7() {
        return getEnabled();
    }

    @Override
    public Boolean component8() {
        return getSso();
    }

    @Override
    public JSONB component9() {
        return getMeta();
    }

    @Override
    public LoomPermissionFlag component10() {
        return getPermissions();
    }

    @Override
    public LocalDateTime component11() {
        return getCreated();
    }

    @Override
    public UUID component12() {
        return getCreatorUuid();
    }

    @Override
    public LocalDateTime component13() {
        return getEdited();
    }

    @Override
    public UUID component14() {
        return getEditorUuid();
    }

    @Override
    public UUID value1() {
        return getUuid();
    }

    @Override
    public String value2() {
        return getUsername();
    }

    @Override
    public String value3() {
        return getFirstname();
    }

    @Override
    public String value4() {
        return getLastname();
    }

    @Override
    public String value5() {
        return getPasswordhash();
    }

    @Override
    public String value6() {
        return getEmail();
    }

    @Override
    public Boolean value7() {
        return getEnabled();
    }

    @Override
    public Boolean value8() {
        return getSso();
    }

    @Override
    public JSONB value9() {
        return getMeta();
    }

    @Override
    public LoomPermissionFlag value10() {
        return getPermissions();
    }

    @Override
    public LocalDateTime value11() {
        return getCreated();
    }

    @Override
    public UUID value12() {
        return getCreatorUuid();
    }

    @Override
    public LocalDateTime value13() {
        return getEdited();
    }

    @Override
    public UUID value14() {
        return getEditorUuid();
    }

    @Override
    public UserRecord value1(UUID value) {
        setUuid(value);
        return this;
    }

    @Override
    public UserRecord value2(String value) {
        setUsername(value);
        return this;
    }

    @Override
    public UserRecord value3(String value) {
        setFirstname(value);
        return this;
    }

    @Override
    public UserRecord value4(String value) {
        setLastname(value);
        return this;
    }

    @Override
    public UserRecord value5(String value) {
        setPasswordhash(value);
        return this;
    }

    @Override
    public UserRecord value6(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public UserRecord value7(Boolean value) {
        setEnabled(value);
        return this;
    }

    @Override
    public UserRecord value8(Boolean value) {
        setSso(value);
        return this;
    }

    @Override
    public UserRecord value9(JSONB value) {
        setMeta(value);
        return this;
    }

    @Override
    public UserRecord value10(LoomPermissionFlag value) {
        setPermissions(value);
        return this;
    }

    @Override
    public UserRecord value11(LocalDateTime value) {
        setCreated(value);
        return this;
    }

    @Override
    public UserRecord value12(UUID value) {
        setCreatorUuid(value);
        return this;
    }

    @Override
    public UserRecord value13(LocalDateTime value) {
        setEdited(value);
        return this;
    }

    @Override
    public UserRecord value14(UUID value) {
        setEditorUuid(value);
        return this;
    }

    @Override
    public UserRecord values(UUID value1, String value2, String value3, String value4, String value5, String value6, Boolean value7, Boolean value8, JSONB value9, LoomPermissionFlag value10, LocalDateTime value11, UUID value12, LocalDateTime value13, UUID value14) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserRecord
     */
    public UserRecord() {
        super(User.USER);
    }

    /**
     * Create a detached, initialised UserRecord
     */
    public UserRecord(UUID uuid, String username, String firstname, String lastname, String passwordhash, String email, Boolean enabled, Boolean sso, JSONB meta, LoomPermissionFlag permissions, LocalDateTime created, UUID creatorUuid, LocalDateTime edited, UUID editorUuid) {
        super(User.USER);

        setUuid(uuid);
        setUsername(username);
        setFirstname(firstname);
        setLastname(lastname);
        setPasswordhash(passwordhash);
        setEmail(email);
        setEnabled(enabled);
        setSso(sso);
        setMeta(meta);
        setPermissions(permissions);
        setCreated(created);
        setCreatorUuid(creatorUuid);
        setEdited(edited);
        setEditorUuid(editorUuid);
    }

    /**
     * Create a detached, initialised UserRecord
     */
    public UserRecord(io.metaloom.loom.db.jooq.tables.pojos.User value) {
        super(User.USER);

        if (value != null) {
            setUuid(value.getUuid());
            setUsername(value.getUsername());
            setFirstname(value.getFirstname());
            setLastname(value.getLastname());
            setPasswordhash(value.getPasswordhash());
            setEmail(value.getEmail());
            setEnabled(value.getEnabled());
            setSso(value.getSso());
            setMeta(value.getMeta());
            setPermissions(value.getPermissions());
            setCreated(value.getCreated());
            setCreatorUuid(value.getCreatorUuid());
            setEdited(value.getEdited());
            setEditorUuid(value.getEditorUuid());
        }
    }
}