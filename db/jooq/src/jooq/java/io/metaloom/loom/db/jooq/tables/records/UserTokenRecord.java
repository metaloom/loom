/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;
import io.metaloom.loom.db.jooq.enums.LoomPermissionFlag;
import io.metaloom.loom.db.jooq.tables.UserToken;
import io.metaloom.loom.db.jooq.tables.interfaces.IUserToken;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserTokenRecord extends UpdatableRecordImpl<UserTokenRecord> implements VertxPojo, Record5<UUID, UUID, String, String, LoomPermissionFlag>, IUserToken {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.user_token.uuid</code>.
     */
    @Override
    public UserTokenRecord setUuid(UUID value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.user_token.uuid</code>.
     */
    @Override
    public UUID getUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.user_token.user_uuid</code>.
     */
    @Override
    public UserTokenRecord setUserUuid(UUID value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.user_token.user_uuid</code>.
     */
    @Override
    public UUID getUserUuid() {
        return (UUID) get(1);
    }

    /**
     * Setter for <code>public.user_token.note</code>.
     */
    @Override
    public UserTokenRecord setNote(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.user_token.note</code>.
     */
    @Override
    public String getNote() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.user_token.token</code>.
     */
    @Override
    public UserTokenRecord setToken(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.user_token.token</code>.
     */
    @Override
    public String getToken() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.user_token.permissions</code>.
     */
    @Override
    public UserTokenRecord setPermissions(LoomPermissionFlag value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.user_token.permissions</code>.
     */
    @Override
    public LoomPermissionFlag getPermissions() {
        return (LoomPermissionFlag) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<UUID, UUID, String, String, LoomPermissionFlag> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<UUID, UUID, String, String, LoomPermissionFlag> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return UserToken.USER_TOKEN.UUID;
    }

    @Override
    public Field<UUID> field2() {
        return UserToken.USER_TOKEN.USER_UUID;
    }

    @Override
    public Field<String> field3() {
        return UserToken.USER_TOKEN.NOTE;
    }

    @Override
    public Field<String> field4() {
        return UserToken.USER_TOKEN.TOKEN;
    }

    @Override
    public Field<LoomPermissionFlag> field5() {
        return UserToken.USER_TOKEN.PERMISSIONS;
    }

    @Override
    public UUID component1() {
        return getUuid();
    }

    @Override
    public UUID component2() {
        return getUserUuid();
    }

    @Override
    public String component3() {
        return getNote();
    }

    @Override
    public String component4() {
        return getToken();
    }

    @Override
    public LoomPermissionFlag component5() {
        return getPermissions();
    }

    @Override
    public UUID value1() {
        return getUuid();
    }

    @Override
    public UUID value2() {
        return getUserUuid();
    }

    @Override
    public String value3() {
        return getNote();
    }

    @Override
    public String value4() {
        return getToken();
    }

    @Override
    public LoomPermissionFlag value5() {
        return getPermissions();
    }

    @Override
    public UserTokenRecord value1(UUID value) {
        setUuid(value);
        return this;
    }

    @Override
    public UserTokenRecord value2(UUID value) {
        setUserUuid(value);
        return this;
    }

    @Override
    public UserTokenRecord value3(String value) {
        setNote(value);
        return this;
    }

    @Override
    public UserTokenRecord value4(String value) {
        setToken(value);
        return this;
    }

    @Override
    public UserTokenRecord value5(LoomPermissionFlag value) {
        setPermissions(value);
        return this;
    }

    @Override
    public UserTokenRecord values(UUID value1, UUID value2, String value3, String value4, LoomPermissionFlag value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IUserToken from) {
        setUuid(from.getUuid());
        setUserUuid(from.getUserUuid());
        setNote(from.getNote());
        setToken(from.getToken());
        setPermissions(from.getPermissions());
    }

    @Override
    public <E extends IUserToken> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserTokenRecord
     */
    public UserTokenRecord() {
        super(UserToken.USER_TOKEN);
    }

    /**
     * Create a detached, initialised UserTokenRecord
     */
    public UserTokenRecord(UUID uuid, UUID userUuid, String note, String token, LoomPermissionFlag permissions) {
        super(UserToken.USER_TOKEN);

        setUuid(uuid);
        setUserUuid(userUuid);
        setNote(note);
        setToken(token);
        setPermissions(permissions);
    }

        public UserTokenRecord(io.vertx.core.json.JsonObject json) {
                this();
                fromJson(json);
        }
}
