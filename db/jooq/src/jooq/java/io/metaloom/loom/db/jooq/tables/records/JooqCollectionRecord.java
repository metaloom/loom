/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.tables.JooqCollection;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.JSONB;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * Collections are used to group assets together.
 * 
 * A collection may be a folder which groups together assets for a project.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqCollectionRecord extends UpdatableRecordImpl<JooqCollectionRecord> implements Record9<UUID, String, JSONB, String, LocalDateTime, UUID, LocalDateTime, UUID, UUID> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.collection.uuid</code>.
     */
    public void setUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.collection.uuid</code>.
     */
    public UUID getUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.collection.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.collection.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.collection.meta</code>. Custom meta properties
     */
    public void setMeta(JSONB value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.collection.meta</code>. Custom meta properties
     */
    public JSONB getMeta() {
        return (JSONB) get(2);
    }

    /**
     * Setter for <code>public.collection.description</code>.
     */
    public void setDescription(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.collection.description</code>.
     */
    public String getDescription() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.collection.created</code>.
     */
    public void setCreated(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.collection.created</code>.
     */
    public LocalDateTime getCreated() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>public.collection.creator_uuid</code>.
     */
    public void setCreatorUuid(UUID value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.collection.creator_uuid</code>.
     */
    public UUID getCreatorUuid() {
        return (UUID) get(5);
    }

    /**
     * Setter for <code>public.collection.edited</code>.
     */
    public void setEdited(LocalDateTime value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.collection.edited</code>.
     */
    public LocalDateTime getEdited() {
        return (LocalDateTime) get(6);
    }

    /**
     * Setter for <code>public.collection.editor_uuid</code>.
     */
    public void setEditorUuid(UUID value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.collection.editor_uuid</code>.
     */
    public UUID getEditorUuid() {
        return (UUID) get(7);
    }

    /**
     * Setter for <code>public.collection.parent_collection_uuid</code>.
     */
    public void setParentCollectionUuid(UUID value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.collection.parent_collection_uuid</code>.
     */
    public UUID getParentCollectionUuid() {
        return (UUID) get(8);
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
    public Row9<UUID, String, JSONB, String, LocalDateTime, UUID, LocalDateTime, UUID, UUID> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<UUID, String, JSONB, String, LocalDateTime, UUID, LocalDateTime, UUID, UUID> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return JooqCollection.COLLECTION.UUID;
    }

    @Override
    public Field<String> field2() {
        return JooqCollection.COLLECTION.NAME;
    }

    @Override
    public Field<JSONB> field3() {
        return JooqCollection.COLLECTION.META;
    }

    @Override
    public Field<String> field4() {
        return JooqCollection.COLLECTION.DESCRIPTION;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return JooqCollection.COLLECTION.CREATED;
    }

    @Override
    public Field<UUID> field6() {
        return JooqCollection.COLLECTION.CREATOR_UUID;
    }

    @Override
    public Field<LocalDateTime> field7() {
        return JooqCollection.COLLECTION.EDITED;
    }

    @Override
    public Field<UUID> field8() {
        return JooqCollection.COLLECTION.EDITOR_UUID;
    }

    @Override
    public Field<UUID> field9() {
        return JooqCollection.COLLECTION.PARENT_COLLECTION_UUID;
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
    public String component4() {
        return getDescription();
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
        return getParentCollectionUuid();
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
    public String value4() {
        return getDescription();
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
        return getParentCollectionUuid();
    }

    @Override
    public JooqCollectionRecord value1(UUID value) {
        setUuid(value);
        return this;
    }

    @Override
    public JooqCollectionRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public JooqCollectionRecord value3(JSONB value) {
        setMeta(value);
        return this;
    }

    @Override
    public JooqCollectionRecord value4(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public JooqCollectionRecord value5(LocalDateTime value) {
        setCreated(value);
        return this;
    }

    @Override
    public JooqCollectionRecord value6(UUID value) {
        setCreatorUuid(value);
        return this;
    }

    @Override
    public JooqCollectionRecord value7(LocalDateTime value) {
        setEdited(value);
        return this;
    }

    @Override
    public JooqCollectionRecord value8(UUID value) {
        setEditorUuid(value);
        return this;
    }

    @Override
    public JooqCollectionRecord value9(UUID value) {
        setParentCollectionUuid(value);
        return this;
    }

    @Override
    public JooqCollectionRecord values(UUID value1, String value2, JSONB value3, String value4, LocalDateTime value5, UUID value6, LocalDateTime value7, UUID value8, UUID value9) {
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
     * Create a detached JooqCollectionRecord
     */
    public JooqCollectionRecord() {
        super(JooqCollection.COLLECTION);
    }

    /**
     * Create a detached, initialised JooqCollectionRecord
     */
    public JooqCollectionRecord(UUID uuid, String name, JSONB meta, String description, LocalDateTime created, UUID creatorUuid, LocalDateTime edited, UUID editorUuid, UUID parentCollectionUuid) {
        super(JooqCollection.COLLECTION);

        setUuid(uuid);
        setName(name);
        setMeta(meta);
        setDescription(description);
        setCreated(created);
        setCreatorUuid(creatorUuid);
        setEdited(edited);
        setEditorUuid(editorUuid);
        setParentCollectionUuid(parentCollectionUuid);
    }
}