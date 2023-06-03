/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.tables.JooqComment;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * Stores comments on tasks, annotations..
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqCommentRecord extends UpdatableRecordImpl<JooqCommentRecord> implements Record11<UUID, String, String, UUID, LocalDateTime, UUID, LocalDateTime, UUID, UUID, UUID, UUID> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.comment.uuid</code>.
     */
    public void setUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.comment.uuid</code>.
     */
    public UUID getUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.comment.title</code>. Comment title
     */
    public void setTitle(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.comment.title</code>. Comment title
     */
    public String getTitle() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.comment.content</code>. Comment text
     */
    public void setContent(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.comment.content</code>. Comment text
     */
    public String getContent() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.comment.parent_uuid</code>.
     */
    public void setParentUuid(UUID value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.comment.parent_uuid</code>.
     */
    public UUID getParentUuid() {
        return (UUID) get(3);
    }

    /**
     * Setter for <code>public.comment.created</code>. Creation timestamp
     */
    public void setCreated(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.comment.created</code>. Creation timestamp
     */
    public LocalDateTime getCreated() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>public.comment.creator_uuid</code>.
     */
    public void setCreatorUuid(UUID value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.comment.creator_uuid</code>.
     */
    public UUID getCreatorUuid() {
        return (UUID) get(5);
    }

    /**
     * Setter for <code>public.comment.edited</code>. Edit timestamp
     */
    public void setEdited(LocalDateTime value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.comment.edited</code>. Edit timestamp
     */
    public LocalDateTime getEdited() {
        return (LocalDateTime) get(6);
    }

    /**
     * Setter for <code>public.comment.editor_uuid</code>.
     */
    public void setEditorUuid(UUID value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.comment.editor_uuid</code>.
     */
    public UUID getEditorUuid() {
        return (UUID) get(7);
    }

    /**
     * Setter for <code>public.comment.task_uuid</code>.
     */
    public void setTaskUuid(UUID value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.comment.task_uuid</code>.
     */
    public UUID getTaskUuid() {
        return (UUID) get(8);
    }

    /**
     * Setter for <code>public.comment.asset_uuid</code>.
     */
    public void setAssetUuid(UUID value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.comment.asset_uuid</code>.
     */
    public UUID getAssetUuid() {
        return (UUID) get(9);
    }

    /**
     * Setter for <code>public.comment.annotation_uuid</code>.
     */
    public void setAnnotationUuid(UUID value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.comment.annotation_uuid</code>.
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
    public Row11<UUID, String, String, UUID, LocalDateTime, UUID, LocalDateTime, UUID, UUID, UUID, UUID> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    @Override
    public Row11<UUID, String, String, UUID, LocalDateTime, UUID, LocalDateTime, UUID, UUID, UUID, UUID> valuesRow() {
        return (Row11) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return JooqComment.COMMENT.UUID;
    }

    @Override
    public Field<String> field2() {
        return JooqComment.COMMENT.TITLE;
    }

    @Override
    public Field<String> field3() {
        return JooqComment.COMMENT.CONTENT;
    }

    @Override
    public Field<UUID> field4() {
        return JooqComment.COMMENT.PARENT_UUID;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return JooqComment.COMMENT.CREATED;
    }

    @Override
    public Field<UUID> field6() {
        return JooqComment.COMMENT.CREATOR_UUID;
    }

    @Override
    public Field<LocalDateTime> field7() {
        return JooqComment.COMMENT.EDITED;
    }

    @Override
    public Field<UUID> field8() {
        return JooqComment.COMMENT.EDITOR_UUID;
    }

    @Override
    public Field<UUID> field9() {
        return JooqComment.COMMENT.TASK_UUID;
    }

    @Override
    public Field<UUID> field10() {
        return JooqComment.COMMENT.ASSET_UUID;
    }

    @Override
    public Field<UUID> field11() {
        return JooqComment.COMMENT.ANNOTATION_UUID;
    }

    @Override
    public UUID component1() {
        return getUuid();
    }

    @Override
    public String component2() {
        return getTitle();
    }

    @Override
    public String component3() {
        return getContent();
    }

    @Override
    public UUID component4() {
        return getParentUuid();
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
        return getTaskUuid();
    }

    @Override
    public UUID component10() {
        return getAssetUuid();
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
        return getTitle();
    }

    @Override
    public String value3() {
        return getContent();
    }

    @Override
    public UUID value4() {
        return getParentUuid();
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
        return getTaskUuid();
    }

    @Override
    public UUID value10() {
        return getAssetUuid();
    }

    @Override
    public UUID value11() {
        return getAnnotationUuid();
    }

    @Override
    public JooqCommentRecord value1(UUID value) {
        setUuid(value);
        return this;
    }

    @Override
    public JooqCommentRecord value2(String value) {
        setTitle(value);
        return this;
    }

    @Override
    public JooqCommentRecord value3(String value) {
        setContent(value);
        return this;
    }

    @Override
    public JooqCommentRecord value4(UUID value) {
        setParentUuid(value);
        return this;
    }

    @Override
    public JooqCommentRecord value5(LocalDateTime value) {
        setCreated(value);
        return this;
    }

    @Override
    public JooqCommentRecord value6(UUID value) {
        setCreatorUuid(value);
        return this;
    }

    @Override
    public JooqCommentRecord value7(LocalDateTime value) {
        setEdited(value);
        return this;
    }

    @Override
    public JooqCommentRecord value8(UUID value) {
        setEditorUuid(value);
        return this;
    }

    @Override
    public JooqCommentRecord value9(UUID value) {
        setTaskUuid(value);
        return this;
    }

    @Override
    public JooqCommentRecord value10(UUID value) {
        setAssetUuid(value);
        return this;
    }

    @Override
    public JooqCommentRecord value11(UUID value) {
        setAnnotationUuid(value);
        return this;
    }

    @Override
    public JooqCommentRecord values(UUID value1, String value2, String value3, UUID value4, LocalDateTime value5, UUID value6, LocalDateTime value7, UUID value8, UUID value9, UUID value10, UUID value11) {
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
     * Create a detached JooqCommentRecord
     */
    public JooqCommentRecord() {
        super(JooqComment.COMMENT);
    }

    /**
     * Create a detached, initialised JooqCommentRecord
     */
    public JooqCommentRecord(UUID uuid, String title, String content, UUID parentUuid, LocalDateTime created, UUID creatorUuid, LocalDateTime edited, UUID editorUuid, UUID taskUuid, UUID assetUuid, UUID annotationUuid) {
        super(JooqComment.COMMENT);

        setUuid(uuid);
        setTitle(title);
        setContent(content);
        setParentUuid(parentUuid);
        setCreated(created);
        setCreatorUuid(creatorUuid);
        setEdited(edited);
        setEditorUuid(editorUuid);
        setTaskUuid(taskUuid);
        setAssetUuid(assetUuid);
        setAnnotationUuid(annotationUuid);
    }
}
