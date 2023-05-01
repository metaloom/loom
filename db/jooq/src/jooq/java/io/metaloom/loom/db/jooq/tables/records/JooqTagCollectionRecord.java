/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.tables.JooqTagCollection;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * Store tag &lt;-&gt; collection reference
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqTagCollectionRecord extends UpdatableRecordImpl<JooqTagCollectionRecord> implements Record2<UUID, UUID> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.tag_collection.tag_uuid</code>.
     */
    public void setTagUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.tag_collection.tag_uuid</code>.
     */
    public UUID getTagUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.tag_collection.collection_uuid</code>.
     */
    public void setCollectionUuid(UUID value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.tag_collection.collection_uuid</code>.
     */
    public UUID getCollectionUuid() {
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
        return JooqTagCollection.TAG_COLLECTION.TAG_UUID;
    }

    @Override
    public Field<UUID> field2() {
        return JooqTagCollection.TAG_COLLECTION.COLLECTION_UUID;
    }

    @Override
    public UUID component1() {
        return getTagUuid();
    }

    @Override
    public UUID component2() {
        return getCollectionUuid();
    }

    @Override
    public UUID value1() {
        return getTagUuid();
    }

    @Override
    public UUID value2() {
        return getCollectionUuid();
    }

    @Override
    public JooqTagCollectionRecord value1(UUID value) {
        setTagUuid(value);
        return this;
    }

    @Override
    public JooqTagCollectionRecord value2(UUID value) {
        setCollectionUuid(value);
        return this;
    }

    @Override
    public JooqTagCollectionRecord values(UUID value1, UUID value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JooqTagCollectionRecord
     */
    public JooqTagCollectionRecord() {
        super(JooqTagCollection.TAG_COLLECTION);
    }

    /**
     * Create a detached, initialised JooqTagCollectionRecord
     */
    public JooqTagCollectionRecord(UUID tagUuid, UUID collectionUuid) {
        super(JooqTagCollection.TAG_COLLECTION);

        setTagUuid(tagUuid);
        setCollectionUuid(collectionUuid);
    }

    /**
     * Create a detached, initialised JooqTagCollectionRecord
     */
    public JooqTagCollectionRecord(io.metaloom.loom.db.jooq.tables.pojos.JooqTagCollection value) {
        super(JooqTagCollection.TAG_COLLECTION);

        if (value != null) {
            setTagUuid(value.getTagUuid());
            setCollectionUuid(value.getCollectionUuid());
        }
    }
}
