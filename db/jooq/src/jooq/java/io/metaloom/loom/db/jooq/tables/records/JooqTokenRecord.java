/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.tables.JooqToken;
import io.vertx.core.json.JsonObject;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqTokenRecord extends UpdatableRecordImpl<JooqTokenRecord> implements Record9<UUID, String, String, String, LocalDateTime, UUID, LocalDateTime, UUID, JsonObject> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.token.uuid</code>.
     */
    public void setUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.token.uuid</code>.
     */
    public UUID getUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.token.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.token.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.token.description</code>.
     */
    public void setDescription(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.token.description</code>.
     */
    public String getDescription() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.token.token</code>.
     */
    public void setToken(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.token.token</code>.
     */
    public String getToken() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.token.created</code>.
     */
    public void setCreated(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.token.created</code>.
     */
    public LocalDateTime getCreated() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>public.token.creator_uuid</code>.
     */
    public void setCreatorUuid(UUID value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.token.creator_uuid</code>.
     */
    public UUID getCreatorUuid() {
        return (UUID) get(5);
    }

    /**
     * Setter for <code>public.token.edited</code>.
     */
    public void setEdited(LocalDateTime value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.token.edited</code>.
     */
    public LocalDateTime getEdited() {
        return (LocalDateTime) get(6);
    }

    /**
     * Setter for <code>public.token.editor_uuid</code>.
     */
    public void setEditorUuid(UUID value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.token.editor_uuid</code>.
     */
    public UUID getEditorUuid() {
        return (UUID) get(7);
    }

    /**
     * Setter for <code>public.token.meta</code>. Custom meta properties to the
     * element
     */
    public void setMeta(JsonObject value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.token.meta</code>. Custom meta properties to the
     * element
     */
    public JsonObject getMeta() {
        return (JsonObject) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row9<UUID, String, String, String, LocalDateTime, UUID, LocalDateTime, UUID, JsonObject> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<UUID, String, String, String, LocalDateTime, UUID, LocalDateTime, UUID, JsonObject> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return JooqToken.TOKEN.UUID;
    }

    @Override
    public Field<String> field2() {
        return JooqToken.TOKEN.NAME;
    }

    @Override
    public Field<String> field3() {
        return JooqToken.TOKEN.DESCRIPTION;
    }

    @Override
    public Field<String> field4() {
        return JooqToken.TOKEN.TOKEN_;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return JooqToken.TOKEN.CREATED;
    }

    @Override
    public Field<UUID> field6() {
        return JooqToken.TOKEN.CREATOR_UUID;
    }

    @Override
    public Field<LocalDateTime> field7() {
        return JooqToken.TOKEN.EDITED;
    }

    @Override
    public Field<UUID> field8() {
        return JooqToken.TOKEN.EDITOR_UUID;
    }

    @Override
    public Field<JsonObject> field9() {
        return JooqToken.TOKEN.META;
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
    public String component3() {
        return getDescription();
    }

    @Override
    public String component4() {
        return getToken();
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
    public JsonObject component9() {
        return getMeta();
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
    public String value3() {
        return getDescription();
    }

    @Override
    public String value4() {
        return getToken();
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
    public JsonObject value9() {
        return getMeta();
    }

    @Override
    public JooqTokenRecord value1(UUID value) {
        setUuid(value);
        return this;
    }

    @Override
    public JooqTokenRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public JooqTokenRecord value3(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public JooqTokenRecord value4(String value) {
        setToken(value);
        return this;
    }

    @Override
    public JooqTokenRecord value5(LocalDateTime value) {
        setCreated(value);
        return this;
    }

    @Override
    public JooqTokenRecord value6(UUID value) {
        setCreatorUuid(value);
        return this;
    }

    @Override
    public JooqTokenRecord value7(LocalDateTime value) {
        setEdited(value);
        return this;
    }

    @Override
    public JooqTokenRecord value8(UUID value) {
        setEditorUuid(value);
        return this;
    }

    @Override
    public JooqTokenRecord value9(JsonObject value) {
        setMeta(value);
        return this;
    }

    @Override
    public JooqTokenRecord values(UUID value1, String value2, String value3, String value4, LocalDateTime value5, UUID value6, LocalDateTime value7, UUID value8, JsonObject value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JooqTokenRecord
     */
    public JooqTokenRecord() {
        super(JooqToken.TOKEN);
    }

    /**
     * Create a detached, initialised JooqTokenRecord
     */
    public JooqTokenRecord(UUID uuid, String name, String description, String token, LocalDateTime created, UUID creatorUuid, LocalDateTime edited, UUID editorUuid, JsonObject meta) {
        super(JooqToken.TOKEN);

        setUuid(uuid);
        setName(name);
        setDescription(description);
        setToken(token);
        setCreated(created);
        setCreatorUuid(creatorUuid);
        setEdited(edited);
        setEditorUuid(editorUuid);
        setMeta(meta);
    }
}
