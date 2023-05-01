/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.tables.JooqComment;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * Stores comments on tasks, annotations..
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqCommentRecord extends UpdatableRecordImpl<JooqCommentRecord> implements Record7<UUID, String, String, UUID, String, String, UUID> {

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
     * Setter for <code>public.comment.user_uuid</code>.
     */
    public void setUserUuid(UUID value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.comment.user_uuid</code>.
     */
    public UUID getUserUuid() {
        return (UUID) get(3);
    }

    /**
     * Setter for <code>public.comment.created</code>. Creation timestamp
     */
    public void setCreated(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.comment.created</code>. Creation timestamp
     */
    public String getCreated() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.comment.edited</code>. Edit timestamp
     */
    public void setEdited(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.comment.edited</code>. Edit timestamp
     */
    public String getEdited() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.comment.parent_uuid</code>.
     */
    public void setParentUuid(UUID value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.comment.parent_uuid</code>.
     */
    public UUID getParentUuid() {
        return (UUID) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row7<UUID, String, String, UUID, String, String, UUID> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<UUID, String, String, UUID, String, String, UUID> valuesRow() {
        return (Row7) super.valuesRow();
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
        return JooqComment.COMMENT.USER_UUID;
    }

    @Override
    public Field<String> field5() {
        return JooqComment.COMMENT.CREATED;
    }

    @Override
    public Field<String> field6() {
        return JooqComment.COMMENT.EDITED;
    }

    @Override
    public Field<UUID> field7() {
        return JooqComment.COMMENT.PARENT_UUID;
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
        return getUserUuid();
    }

    @Override
    public String component5() {
        return getCreated();
    }

    @Override
    public String component6() {
        return getEdited();
    }

    @Override
    public UUID component7() {
        return getParentUuid();
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
        return getUserUuid();
    }

    @Override
    public String value5() {
        return getCreated();
    }

    @Override
    public String value6() {
        return getEdited();
    }

    @Override
    public UUID value7() {
        return getParentUuid();
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
        setUserUuid(value);
        return this;
    }

    @Override
    public JooqCommentRecord value5(String value) {
        setCreated(value);
        return this;
    }

    @Override
    public JooqCommentRecord value6(String value) {
        setEdited(value);
        return this;
    }

    @Override
    public JooqCommentRecord value7(UUID value) {
        setParentUuid(value);
        return this;
    }

    @Override
    public JooqCommentRecord values(UUID value1, String value2, String value3, UUID value4, String value5, String value6, UUID value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
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
    public JooqCommentRecord(UUID uuid, String title, String content, UUID userUuid, String created, String edited, UUID parentUuid) {
        super(JooqComment.COMMENT);

        setUuid(uuid);
        setTitle(title);
        setContent(content);
        setUserUuid(userUuid);
        setCreated(created);
        setEdited(edited);
        setParentUuid(parentUuid);
    }

    /**
     * Create a detached, initialised JooqCommentRecord
     */
    public JooqCommentRecord(io.metaloom.loom.db.jooq.tables.pojos.JooqComment value) {
        super(JooqComment.COMMENT);

        if (value != null) {
            setUuid(value.getUuid());
            setTitle(value.getTitle());
            setContent(value.getContent());
            setUserUuid(value.getUserUuid());
            setCreated(value.getCreated());
            setEdited(value.getEdited());
            setParentUuid(value.getParentUuid());
        }
    }
}
