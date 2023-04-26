/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.tables.JooqModel;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqModelRecord extends UpdatableRecordImpl<JooqModelRecord> implements Record7<UUID, String, UUID, LocalDateTime, UUID, LocalDateTime, UUID> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.model.uuid</code>.
     */
    public void setUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.model.uuid</code>.
     */
    public UUID getUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.model.name</code>. Human readable name of the
     * content model
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.model.name</code>. Human readable name of the
     * content model
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.model.latest_version_uuid</code>.
     */
    public void setLatestVersionUuid(UUID value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.model.latest_version_uuid</code>.
     */
    public UUID getLatestVersionUuid() {
        return (UUID) get(2);
    }

    /**
     * Setter for <code>public.model.created</code>.
     */
    public void setCreated(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.model.created</code>.
     */
    public LocalDateTime getCreated() {
        return (LocalDateTime) get(3);
    }

    /**
     * Setter for <code>public.model.creator_uuid</code>.
     */
    public void setCreatorUuid(UUID value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.model.creator_uuid</code>.
     */
    public UUID getCreatorUuid() {
        return (UUID) get(4);
    }

    /**
     * Setter for <code>public.model.edited</code>.
     */
    public void setEdited(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.model.edited</code>.
     */
    public LocalDateTime getEdited() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>public.model.editor_uuid</code>.
     */
    public void setEditorUuid(UUID value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.model.editor_uuid</code>.
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
    public Row7<UUID, String, UUID, LocalDateTime, UUID, LocalDateTime, UUID> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<UUID, String, UUID, LocalDateTime, UUID, LocalDateTime, UUID> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return JooqModel.MODEL.UUID;
    }

    @Override
    public Field<String> field2() {
        return JooqModel.MODEL.NAME;
    }

    @Override
    public Field<UUID> field3() {
        return JooqModel.MODEL.LATEST_VERSION_UUID;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return JooqModel.MODEL.CREATED;
    }

    @Override
    public Field<UUID> field5() {
        return JooqModel.MODEL.CREATOR_UUID;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return JooqModel.MODEL.EDITED;
    }

    @Override
    public Field<UUID> field7() {
        return JooqModel.MODEL.EDITOR_UUID;
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
    public UUID component3() {
        return getLatestVersionUuid();
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
    public UUID value3() {
        return getLatestVersionUuid();
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
    public JooqModelRecord value1(UUID value) {
        setUuid(value);
        return this;
    }

    @Override
    public JooqModelRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public JooqModelRecord value3(UUID value) {
        setLatestVersionUuid(value);
        return this;
    }

    @Override
    public JooqModelRecord value4(LocalDateTime value) {
        setCreated(value);
        return this;
    }

    @Override
    public JooqModelRecord value5(UUID value) {
        setCreatorUuid(value);
        return this;
    }

    @Override
    public JooqModelRecord value6(LocalDateTime value) {
        setEdited(value);
        return this;
    }

    @Override
    public JooqModelRecord value7(UUID value) {
        setEditorUuid(value);
        return this;
    }

    @Override
    public JooqModelRecord values(UUID value1, String value2, UUID value3, LocalDateTime value4, UUID value5, LocalDateTime value6, UUID value7) {
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
     * Create a detached JooqModelRecord
     */
    public JooqModelRecord() {
        super(JooqModel.MODEL);
    }

    /**
     * Create a detached, initialised JooqModelRecord
     */
    public JooqModelRecord(UUID uuid, String name, UUID latestVersionUuid, LocalDateTime created, UUID creatorUuid, LocalDateTime edited, UUID editorUuid) {
        super(JooqModel.MODEL);

        setUuid(uuid);
        setName(name);
        setLatestVersionUuid(latestVersionUuid);
        setCreated(created);
        setCreatorUuid(creatorUuid);
        setEdited(edited);
        setEditorUuid(editorUuid);
    }

    /**
     * Create a detached, initialised JooqModelRecord
     */
    public JooqModelRecord(io.metaloom.loom.db.jooq.tables.pojos.JooqModel value) {
        super(JooqModel.MODEL);

        if (value != null) {
            setUuid(value.getUuid());
            setName(value.getName());
            setLatestVersionUuid(value.getLatestVersionUuid());
            setCreated(value.getCreated());
            setCreatorUuid(value.getCreatorUuid());
            setEdited(value.getEdited());
            setEditorUuid(value.getEditorUuid());
        }
    }
}