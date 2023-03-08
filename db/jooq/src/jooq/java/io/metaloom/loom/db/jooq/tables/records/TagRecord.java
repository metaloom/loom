/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.tables.Tag;
import io.metaloom.loom.db.jooq.tables.pojos.JooqTag;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.JSONB;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Row10;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TagRecord extends UpdatableRecordImpl<TagRecord> implements Record10<UUID, String, String, UUID, JSONB, Integer, LocalDateTime, UUID, LocalDateTime, UUID> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.tag.uuid</code>.
     */
    public void setUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.tag.uuid</code>.
     */
    public UUID getUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.tag.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.tag.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.tag.collection</code>.
     */
    public void setCollection(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.tag.collection</code>.
     */
    public String getCollection() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.tag.namespace_uuid</code>.
     */
    public void setNamespaceUuid(UUID value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.tag.namespace_uuid</code>.
     */
    public UUID getNamespaceUuid() {
        return (UUID) get(3);
    }

    /**
     * Setter for <code>public.tag.meta</code>. Custom meta properties to the
     * element
     */
    public void setMeta(JSONB value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.tag.meta</code>. Custom meta properties to the
     * element
     */
    public JSONB getMeta() {
        return (JSONB) get(4);
    }

    /**
     * Setter for <code>public.tag.rating</code>. Absolute or
     * buffered/precomputed rating information
     */
    public void setRating(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.tag.rating</code>. Absolute or
     * buffered/precomputed rating information
     */
    public Integer getRating() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>public.tag.created</code>.
     */
    public void setCreated(LocalDateTime value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.tag.created</code>.
     */
    public LocalDateTime getCreated() {
        return (LocalDateTime) get(6);
    }

    /**
     * Setter for <code>public.tag.creator_uuid</code>.
     */
    public void setCreatorUuid(UUID value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.tag.creator_uuid</code>.
     */
    public UUID getCreatorUuid() {
        return (UUID) get(7);
    }

    /**
     * Setter for <code>public.tag.edited</code>.
     */
    public void setEdited(LocalDateTime value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.tag.edited</code>.
     */
    public LocalDateTime getEdited() {
        return (LocalDateTime) get(8);
    }

    /**
     * Setter for <code>public.tag.editor_uuid</code>.
     */
    public void setEditorUuid(UUID value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.tag.editor_uuid</code>.
     */
    public UUID getEditorUuid() {
        return (UUID) get(9);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row10<UUID, String, String, UUID, JSONB, Integer, LocalDateTime, UUID, LocalDateTime, UUID> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    @Override
    public Row10<UUID, String, String, UUID, JSONB, Integer, LocalDateTime, UUID, LocalDateTime, UUID> valuesRow() {
        return (Row10) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return Tag.TAG.UUID;
    }

    @Override
    public Field<String> field2() {
        return Tag.TAG.NAME;
    }

    @Override
    public Field<String> field3() {
        return Tag.TAG.COLLECTION;
    }

    @Override
    public Field<UUID> field4() {
        return Tag.TAG.NAMESPACE_UUID;
    }

    @Override
    public Field<JSONB> field5() {
        return Tag.TAG.META;
    }

    @Override
    public Field<Integer> field6() {
        return Tag.TAG.RATING;
    }

    @Override
    public Field<LocalDateTime> field7() {
        return Tag.TAG.CREATED;
    }

    @Override
    public Field<UUID> field8() {
        return Tag.TAG.CREATOR_UUID;
    }

    @Override
    public Field<LocalDateTime> field9() {
        return Tag.TAG.EDITED;
    }

    @Override
    public Field<UUID> field10() {
        return Tag.TAG.EDITOR_UUID;
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
        return getCollection();
    }

    @Override
    public UUID component4() {
        return getNamespaceUuid();
    }

    @Override
    public JSONB component5() {
        return getMeta();
    }

    @Override
    public Integer component6() {
        return getRating();
    }

    @Override
    public LocalDateTime component7() {
        return getCreated();
    }

    @Override
    public UUID component8() {
        return getCreatorUuid();
    }

    @Override
    public LocalDateTime component9() {
        return getEdited();
    }

    @Override
    public UUID component10() {
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
    public String value3() {
        return getCollection();
    }

    @Override
    public UUID value4() {
        return getNamespaceUuid();
    }

    @Override
    public JSONB value5() {
        return getMeta();
    }

    @Override
    public Integer value6() {
        return getRating();
    }

    @Override
    public LocalDateTime value7() {
        return getCreated();
    }

    @Override
    public UUID value8() {
        return getCreatorUuid();
    }

    @Override
    public LocalDateTime value9() {
        return getEdited();
    }

    @Override
    public UUID value10() {
        return getEditorUuid();
    }

    @Override
    public TagRecord value1(UUID value) {
        setUuid(value);
        return this;
    }

    @Override
    public TagRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public TagRecord value3(String value) {
        setCollection(value);
        return this;
    }

    @Override
    public TagRecord value4(UUID value) {
        setNamespaceUuid(value);
        return this;
    }

    @Override
    public TagRecord value5(JSONB value) {
        setMeta(value);
        return this;
    }

    @Override
    public TagRecord value6(Integer value) {
        setRating(value);
        return this;
    }

    @Override
    public TagRecord value7(LocalDateTime value) {
        setCreated(value);
        return this;
    }

    @Override
    public TagRecord value8(UUID value) {
        setCreatorUuid(value);
        return this;
    }

    @Override
    public TagRecord value9(LocalDateTime value) {
        setEdited(value);
        return this;
    }

    @Override
    public TagRecord value10(UUID value) {
        setEditorUuid(value);
        return this;
    }

    @Override
    public TagRecord values(UUID value1, String value2, String value3, UUID value4, JSONB value5, Integer value6, LocalDateTime value7, UUID value8, LocalDateTime value9, UUID value10) {
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
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TagRecord
     */
    public TagRecord() {
        super(Tag.TAG);
    }

    /**
     * Create a detached, initialised TagRecord
     */
    public TagRecord(UUID uuid, String name, String collection, UUID namespaceUuid, JSONB meta, Integer rating, LocalDateTime created, UUID creatorUuid, LocalDateTime edited, UUID editorUuid) {
        super(Tag.TAG);

        setUuid(uuid);
        setName(name);
        setCollection(collection);
        setNamespaceUuid(namespaceUuid);
        setMeta(meta);
        setRating(rating);
        setCreated(created);
        setCreatorUuid(creatorUuid);
        setEdited(edited);
        setEditorUuid(editorUuid);
    }

    /**
     * Create a detached, initialised TagRecord
     */
    public TagRecord(JooqTag value) {
        super(Tag.TAG);

        if (value != null) {
            setUuid(value.getUuid());
            setName(value.getName());
            setCollection(value.getCollection());
            setNamespaceUuid(value.getNamespaceUuid());
            setMeta(value.getMeta());
            setRating(value.getRating());
            setCreated(value.getCreated());
            setCreatorUuid(value.getCreatorUuid());
            setEdited(value.getEdited());
            setEditorUuid(value.getEditorUuid());
        }
    }
}
