/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.tables.JooqGroup;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.JSONB;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqGroupRecord extends UpdatableRecordImpl<JooqGroupRecord> implements Record7<UUID, String, JSONB, LocalDateTime, UUID, LocalDateTime, UUID> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.group.uuid</code>.
     */
    public void setUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.group.uuid</code>.
     */
    public UUID getUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.group.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.group.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.group.meta</code>. Custom meta properties to the
     * element
     */
    public void setMeta(JSONB value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.group.meta</code>. Custom meta properties to the
     * element
     */
    public JSONB getMeta() {
        return (JSONB) get(2);
    }

    /**
     * Setter for <code>public.group.created</code>.
     */
    public void setCreated(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.group.created</code>.
     */
    public LocalDateTime getCreated() {
        return (LocalDateTime) get(3);
    }

    /**
     * Setter for <code>public.group.creator_uuid</code>.
     */
    public void setCreatorUuid(UUID value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.group.creator_uuid</code>.
     */
    public UUID getCreatorUuid() {
        return (UUID) get(4);
    }

    /**
     * Setter for <code>public.group.edited</code>.
     */
    public void setEdited(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.group.edited</code>.
     */
    public LocalDateTime getEdited() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>public.group.editor_uuid</code>.
     */
    public void setEditorUuid(UUID value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.group.editor_uuid</code>.
     */
    public UUID getEditorUuid() {
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
    public Row7<UUID, String, JSONB, LocalDateTime, UUID, LocalDateTime, UUID> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<UUID, String, JSONB, LocalDateTime, UUID, LocalDateTime, UUID> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return JooqGroup.GROUP.UUID;
    }

    @Override
    public Field<String> field2() {
        return JooqGroup.GROUP.NAME;
    }

    @Override
    public Field<JSONB> field3() {
        return JooqGroup.GROUP.META;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return JooqGroup.GROUP.CREATED;
    }

    @Override
    public Field<UUID> field5() {
        return JooqGroup.GROUP.CREATOR_UUID;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return JooqGroup.GROUP.EDITED;
    }

    @Override
    public Field<UUID> field7() {
        return JooqGroup.GROUP.EDITOR_UUID;
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
    public JSONB component3() {
        return getMeta();
    }

    @Override
    public LocalDateTime component4() {
        return getCreated();
    }

    @Override
    public UUID component5() {
        return getCreatorUuid();
    }

    @Override
    public LocalDateTime component6() {
        return getEdited();
    }

    @Override
    public UUID component7() {
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
    public JSONB value3() {
        return getMeta();
    }

    @Override
    public LocalDateTime value4() {
        return getCreated();
    }

    @Override
    public UUID value5() {
        return getCreatorUuid();
    }

    @Override
    public LocalDateTime value6() {
        return getEdited();
    }

    @Override
    public UUID value7() {
        return getEditorUuid();
    }

    @Override
    public JooqGroupRecord value1(UUID value) {
        setUuid(value);
        return this;
    }

    @Override
    public JooqGroupRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public JooqGroupRecord value3(JSONB value) {
        setMeta(value);
        return this;
    }

    @Override
    public JooqGroupRecord value4(LocalDateTime value) {
        setCreated(value);
        return this;
    }

    @Override
    public JooqGroupRecord value5(UUID value) {
        setCreatorUuid(value);
        return this;
    }

    @Override
    public JooqGroupRecord value6(LocalDateTime value) {
        setEdited(value);
        return this;
    }

    @Override
    public JooqGroupRecord value7(UUID value) {
        setEditorUuid(value);
        return this;
    }

    @Override
    public JooqGroupRecord values(UUID value1, String value2, JSONB value3, LocalDateTime value4, UUID value5, LocalDateTime value6, UUID value7) {
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
     * Create a detached JooqGroupRecord
     */
    public JooqGroupRecord() {
        super(JooqGroup.GROUP);
    }

    /**
     * Create a detached, initialised JooqGroupRecord
     */
    public JooqGroupRecord(UUID uuid, String name, JSONB meta, LocalDateTime created, UUID creatorUuid, LocalDateTime edited, UUID editorUuid) {
        super(JooqGroup.GROUP);

        setUuid(uuid);
        setName(name);
        setMeta(meta);
        setCreated(created);
        setCreatorUuid(creatorUuid);
        setEdited(edited);
        setEditorUuid(editorUuid);
    }
}
