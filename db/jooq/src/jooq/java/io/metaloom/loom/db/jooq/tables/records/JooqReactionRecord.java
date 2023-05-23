/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.tables.JooqReaction;
import io.vertx.core.json.JsonObject;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * Stores social reactions on multiple elements
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqReactionRecord extends UpdatableRecordImpl<JooqReactionRecord> implements Record11<UUID, String, Integer, JsonObject, LocalDateTime, UUID, LocalDateTime, UUID, UUID, UUID, UUID> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.reaction.uuid</code>.
     */
    public void setUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.reaction.uuid</code>.
     */
    public UUID getUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.reaction.type</code>. Type of the reaction (e.g.
     * thumbsup)
     */
    public void setType(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.reaction.type</code>. Type of the reaction (e.g.
     * thumbsup)
     */
    public String getType() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.reaction.rating</code>. Rating by the user
     */
    public void setRating(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.reaction.rating</code>. Rating by the user
     */
    public Integer getRating() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>public.reaction.meta</code>. Custom meta properties to
     * the reaction.
     */
    public void setMeta(JsonObject value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.reaction.meta</code>. Custom meta properties to
     * the reaction.
     */
    public JsonObject getMeta() {
        return (JsonObject) get(3);
    }

    /**
     * Setter for <code>public.reaction.created</code>. Creation timestamp
     */
    public void setCreated(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.reaction.created</code>. Creation timestamp
     */
    public LocalDateTime getCreated() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>public.reaction.creator_uuid</code>. Creator of the
     * reaction
     */
    public void setCreatorUuid(UUID value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.reaction.creator_uuid</code>. Creator of the
     * reaction
     */
    public UUID getCreatorUuid() {
        return (UUID) get(5);
    }

    /**
     * Setter for <code>public.reaction.edited</code>.
     */
    public void setEdited(LocalDateTime value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.reaction.edited</code>.
     */
    public LocalDateTime getEdited() {
        return (LocalDateTime) get(6);
    }

    /**
     * Setter for <code>public.reaction.editor_uuid</code>.
     */
    public void setEditorUuid(UUID value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.reaction.editor_uuid</code>.
     */
    public UUID getEditorUuid() {
        return (UUID) get(7);
    }

    /**
     * Setter for <code>public.reaction.asset_uuid</code>.
     */
    public void setAssetUuid(UUID value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.reaction.asset_uuid</code>.
     */
    public UUID getAssetUuid() {
        return (UUID) get(8);
    }

    /**
     * Setter for <code>public.reaction.comment_uuid</code>.
     */
    public void setCommentUuid(UUID value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.reaction.comment_uuid</code>.
     */
    public UUID getCommentUuid() {
        return (UUID) get(9);
    }

    /**
     * Setter for <code>public.reaction.annotation_uuid</code>.
     */
    public void setAnnotationUuid(UUID value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.reaction.annotation_uuid</code>.
     */
    public UUID getAnnotationUuid() {
        return (UUID) get(10);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row11<UUID, String, Integer, JsonObject, LocalDateTime, UUID, LocalDateTime, UUID, UUID, UUID, UUID> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    @Override
    public Row11<UUID, String, Integer, JsonObject, LocalDateTime, UUID, LocalDateTime, UUID, UUID, UUID, UUID> valuesRow() {
        return (Row11) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return JooqReaction.REACTION.UUID;
    }

    @Override
    public Field<String> field2() {
        return JooqReaction.REACTION.TYPE;
    }

    @Override
    public Field<Integer> field3() {
        return JooqReaction.REACTION.RATING;
    }

    @Override
    public Field<JsonObject> field4() {
        return JooqReaction.REACTION.META;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return JooqReaction.REACTION.CREATED;
    }

    @Override
    public Field<UUID> field6() {
        return JooqReaction.REACTION.CREATOR_UUID;
    }

    @Override
    public Field<LocalDateTime> field7() {
        return JooqReaction.REACTION.EDITED;
    }

    @Override
    public Field<UUID> field8() {
        return JooqReaction.REACTION.EDITOR_UUID;
    }

    @Override
    public Field<UUID> field9() {
        return JooqReaction.REACTION.ASSET_UUID;
    }

    @Override
    public Field<UUID> field10() {
        return JooqReaction.REACTION.COMMENT_UUID;
    }

    @Override
    public Field<UUID> field11() {
        return JooqReaction.REACTION.ANNOTATION_UUID;
    }

    @Override
    public UUID component1() {
        return getUuid();
    }

    @Override
    public String component2() {
        return getType();
    }

    @Override
    public Integer component3() {
        return getRating();
    }

    @Override
    public JsonObject component4() {
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
    public UUID component9() {
        return getAssetUuid();
    }

    @Override
    public UUID component10() {
        return getCommentUuid();
    }

    @Override
    public UUID component11() {
        return getAnnotationUuid();
    }

    @Override
    public UUID value1() {
        return getUuid();
    }

    @Override
    public String value2() {
        return getType();
    }

    @Override
    public Integer value3() {
        return getRating();
    }

    @Override
    public JsonObject value4() {
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
    public UUID value9() {
        return getAssetUuid();
    }

    @Override
    public UUID value10() {
        return getCommentUuid();
    }

    @Override
    public UUID value11() {
        return getAnnotationUuid();
    }

    @Override
    public JooqReactionRecord value1(UUID value) {
        setUuid(value);
        return this;
    }

    @Override
    public JooqReactionRecord value2(String value) {
        setType(value);
        return this;
    }

    @Override
    public JooqReactionRecord value3(Integer value) {
        setRating(value);
        return this;
    }

    @Override
    public JooqReactionRecord value4(JsonObject value) {
        setMeta(value);
        return this;
    }

    @Override
    public JooqReactionRecord value5(LocalDateTime value) {
        setCreated(value);
        return this;
    }

    @Override
    public JooqReactionRecord value6(UUID value) {
        setCreatorUuid(value);
        return this;
    }

    @Override
    public JooqReactionRecord value7(LocalDateTime value) {
        setEdited(value);
        return this;
    }

    @Override
    public JooqReactionRecord value8(UUID value) {
        setEditorUuid(value);
        return this;
    }

    @Override
    public JooqReactionRecord value9(UUID value) {
        setAssetUuid(value);
        return this;
    }

    @Override
    public JooqReactionRecord value10(UUID value) {
        setCommentUuid(value);
        return this;
    }

    @Override
    public JooqReactionRecord value11(UUID value) {
        setAnnotationUuid(value);
        return this;
    }

    @Override
    public JooqReactionRecord values(UUID value1, String value2, Integer value3, JsonObject value4, LocalDateTime value5, UUID value6, LocalDateTime value7, UUID value8, UUID value9, UUID value10, UUID value11) {
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
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JooqReactionRecord
     */
    public JooqReactionRecord() {
        super(JooqReaction.REACTION);
    }

    /**
     * Create a detached, initialised JooqReactionRecord
     */
    public JooqReactionRecord(UUID uuid, String type, Integer rating, JsonObject meta, LocalDateTime created, UUID creatorUuid, LocalDateTime edited, UUID editorUuid, UUID assetUuid, UUID commentUuid, UUID annotationUuid) {
        super(JooqReaction.REACTION);

        setUuid(uuid);
        setType(type);
        setRating(rating);
        setMeta(meta);
        setCreated(created);
        setCreatorUuid(creatorUuid);
        setEdited(edited);
        setEditorUuid(editorUuid);
        setAssetUuid(assetUuid);
        setCommentUuid(commentUuid);
        setAnnotationUuid(annotationUuid);
    }
}
