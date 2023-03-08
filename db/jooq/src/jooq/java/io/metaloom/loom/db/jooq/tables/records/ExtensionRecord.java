/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.enums.LoomExtensionType;
import io.metaloom.loom.db.jooq.tables.Extension;
import io.metaloom.loom.db.jooq.tables.pojos.JooqExtension;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.JSONB;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * Table which lists the registered extensions
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ExtensionRecord extends UpdatableRecordImpl<ExtensionRecord> implements Record9<UUID, String, LoomExtensionType, String, JSONB, LocalDateTime, UUID, LocalDateTime, UUID> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.extension.uuid</code>.
     */
    public void setUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.extension.uuid</code>.
     */
    public UUID getUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.extension.url</code>.
     */
    public void setUrl(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.extension.url</code>.
     */
    public String getUrl() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.extension.kind</code>. Defines the type of the
     * extension service
     */
    public void setKind(LoomExtensionType value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.extension.kind</code>. Defines the type of the
     * extension service
     */
    public LoomExtensionType getKind() {
        return (LoomExtensionType) get(2);
    }

    /**
     * Setter for <code>public.extension.status</code>.
     */
    public void setStatus(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.extension.status</code>.
     */
    public String getStatus() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.extension.meta</code>. Custom meta properties to
     * the element
     */
    public void setMeta(JSONB value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.extension.meta</code>. Custom meta properties to
     * the element
     */
    public JSONB getMeta() {
        return (JSONB) get(4);
    }

    /**
     * Setter for <code>public.extension.created</code>.
     */
    public void setCreated(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.extension.created</code>.
     */
    public LocalDateTime getCreated() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>public.extension.creator_uuid</code>.
     */
    public void setCreatorUuid(UUID value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.extension.creator_uuid</code>.
     */
    public UUID getCreatorUuid() {
        return (UUID) get(6);
    }

    /**
     * Setter for <code>public.extension.edited</code>.
     */
    public void setEdited(LocalDateTime value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.extension.edited</code>.
     */
    public LocalDateTime getEdited() {
        return (LocalDateTime) get(7);
    }

    /**
     * Setter for <code>public.extension.editor_uuid</code>.
     */
    public void setEditorUuid(UUID value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.extension.editor_uuid</code>.
     */
    public UUID getEditorUuid() {
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
    public Row9<UUID, String, LoomExtensionType, String, JSONB, LocalDateTime, UUID, LocalDateTime, UUID> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<UUID, String, LoomExtensionType, String, JSONB, LocalDateTime, UUID, LocalDateTime, UUID> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return Extension.EXTENSION.UUID;
    }

    @Override
    public Field<String> field2() {
        return Extension.EXTENSION.URL;
    }

    @Override
    public Field<LoomExtensionType> field3() {
        return Extension.EXTENSION.KIND;
    }

    @Override
    public Field<String> field4() {
        return Extension.EXTENSION.STATUS;
    }

    @Override
    public Field<JSONB> field5() {
        return Extension.EXTENSION.META;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return Extension.EXTENSION.CREATED;
    }

    @Override
    public Field<UUID> field7() {
        return Extension.EXTENSION.CREATOR_UUID;
    }

    @Override
    public Field<LocalDateTime> field8() {
        return Extension.EXTENSION.EDITED;
    }

    @Override
    public Field<UUID> field9() {
        return Extension.EXTENSION.EDITOR_UUID;
    }

    @Override
    public UUID component1() {
        return getUuid();
    }

    @Override
    public String component2() {
        return getUrl();
    }

    @Override
    public LoomExtensionType component3() {
        return getKind();
    }

    @Override
    public String component4() {
        return getStatus();
    }

    @Override
    public JSONB component5() {
        return getMeta();
    }

    @Override
    public LocalDateTime component6() {
        return getCreated();
    }

    @Override
    public UUID component7() {
        return getCreatorUuid();
    }

    @Override
    public LocalDateTime component8() {
        return getEdited();
    }

    @Override
    public UUID component9() {
        return getEditorUuid();
    }

    @Override
    public UUID value1() {
        return getUuid();
    }

    @Override
    public String value2() {
        return getUrl();
    }

    @Override
    public LoomExtensionType value3() {
        return getKind();
    }

    @Override
    public String value4() {
        return getStatus();
    }

    @Override
    public JSONB value5() {
        return getMeta();
    }

    @Override
    public LocalDateTime value6() {
        return getCreated();
    }

    @Override
    public UUID value7() {
        return getCreatorUuid();
    }

    @Override
    public LocalDateTime value8() {
        return getEdited();
    }

    @Override
    public UUID value9() {
        return getEditorUuid();
    }

    @Override
    public ExtensionRecord value1(UUID value) {
        setUuid(value);
        return this;
    }

    @Override
    public ExtensionRecord value2(String value) {
        setUrl(value);
        return this;
    }

    @Override
    public ExtensionRecord value3(LoomExtensionType value) {
        setKind(value);
        return this;
    }

    @Override
    public ExtensionRecord value4(String value) {
        setStatus(value);
        return this;
    }

    @Override
    public ExtensionRecord value5(JSONB value) {
        setMeta(value);
        return this;
    }

    @Override
    public ExtensionRecord value6(LocalDateTime value) {
        setCreated(value);
        return this;
    }

    @Override
    public ExtensionRecord value7(UUID value) {
        setCreatorUuid(value);
        return this;
    }

    @Override
    public ExtensionRecord value8(LocalDateTime value) {
        setEdited(value);
        return this;
    }

    @Override
    public ExtensionRecord value9(UUID value) {
        setEditorUuid(value);
        return this;
    }

    @Override
    public ExtensionRecord values(UUID value1, String value2, LoomExtensionType value3, String value4, JSONB value5, LocalDateTime value6, UUID value7, LocalDateTime value8, UUID value9) {
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
     * Create a detached ExtensionRecord
     */
    public ExtensionRecord() {
        super(Extension.EXTENSION);
    }

    /**
     * Create a detached, initialised ExtensionRecord
     */
    public ExtensionRecord(UUID uuid, String url, LoomExtensionType kind, String status, JSONB meta, LocalDateTime created, UUID creatorUuid, LocalDateTime edited, UUID editorUuid) {
        super(Extension.EXTENSION);

        setUuid(uuid);
        setUrl(url);
        setKind(kind);
        setStatus(status);
        setMeta(meta);
        setCreated(created);
        setCreatorUuid(creatorUuid);
        setEdited(edited);
        setEditorUuid(editorUuid);
    }

    /**
     * Create a detached, initialised ExtensionRecord
     */
    public ExtensionRecord(JooqExtension value) {
        super(Extension.EXTENSION);

        if (value != null) {
            setUuid(value.getUuid());
            setUrl(value.getUrl());
            setKind(value.getKind());
            setStatus(value.getStatus());
            setMeta(value.getMeta());
            setCreated(value.getCreated());
            setCreatorUuid(value.getCreatorUuid());
            setEdited(value.getEdited());
            setEditorUuid(value.getEditorUuid());
        }
    }
}
