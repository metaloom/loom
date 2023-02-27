/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.tables.TagNamespace;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * Table used to taggings on namespaces
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TagNamespaceRecord extends UpdatableRecordImpl<TagNamespaceRecord> implements Record2<UUID, UUID> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.tag_namespace.tag_uuid</code>.
     */
    public void setTagUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.tag_namespace.tag_uuid</code>.
     */
    public UUID getTagUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.tag_namespace.namespace_uuid</code>.
     */
    public void setNamespaceUuid(UUID value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.tag_namespace.namespace_uuid</code>.
     */
    public UUID getNamespaceUuid() {
        return (UUID) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<UUID, UUID> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<UUID, UUID> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<UUID, UUID> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return TagNamespace.TAG_NAMESPACE.TAG_UUID;
    }

    @Override
    public Field<UUID> field2() {
        return TagNamespace.TAG_NAMESPACE.NAMESPACE_UUID;
    }

    @Override
    public UUID component1() {
        return getTagUuid();
    }

    @Override
    public UUID component2() {
        return getNamespaceUuid();
    }

    @Override
    public UUID value1() {
        return getTagUuid();
    }

    @Override
    public UUID value2() {
        return getNamespaceUuid();
    }

    @Override
    public TagNamespaceRecord value1(UUID value) {
        setTagUuid(value);
        return this;
    }

    @Override
    public TagNamespaceRecord value2(UUID value) {
        setNamespaceUuid(value);
        return this;
    }

    @Override
    public TagNamespaceRecord values(UUID value1, UUID value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TagNamespaceRecord
     */
    public TagNamespaceRecord() {
        super(TagNamespace.TAG_NAMESPACE);
    }

    /**
     * Create a detached, initialised TagNamespaceRecord
     */
    public TagNamespaceRecord(UUID tagUuid, UUID namespaceUuid) {
        super(TagNamespace.TAG_NAMESPACE);

        setTagUuid(tagUuid);
        setNamespaceUuid(namespaceUuid);
    }

    /**
     * Create a detached, initialised TagNamespaceRecord
     */
    public TagNamespaceRecord(io.metaloom.loom.db.jooq.tables.pojos.TagNamespace value) {
        super(TagNamespace.TAG_NAMESPACE);

        if (value != null) {
            setTagUuid(value.getTagUuid());
            setNamespaceUuid(value.getNamespaceUuid());
        }
    }
}