/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.tables.JooqTagContent;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqTagContentRecord extends UpdatableRecordImpl<JooqTagContentRecord> implements Record2<UUID, UUID> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.tag_content.tag_uuid</code>.
     */
    public void setTagUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.tag_content.tag_uuid</code>.
     */
    public UUID getTagUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.tag_content.content_uuid</code>.
     */
    public void setContentUuid(UUID value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.tag_content.content_uuid</code>.
     */
    public UUID getContentUuid() {
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
        return JooqTagContent.TAG_CONTENT.TAG_UUID;
    }

    @Override
    public Field<UUID> field2() {
        return JooqTagContent.TAG_CONTENT.CONTENT_UUID;
    }

    @Override
    public UUID component1() {
        return getTagUuid();
    }

    @Override
    public UUID component2() {
        return getContentUuid();
    }

    @Override
    public UUID value1() {
        return getTagUuid();
    }

    @Override
    public UUID value2() {
        return getContentUuid();
    }

    @Override
    public JooqTagContentRecord value1(UUID value) {
        setTagUuid(value);
        return this;
    }

    @Override
    public JooqTagContentRecord value2(UUID value) {
        setContentUuid(value);
        return this;
    }

    @Override
    public JooqTagContentRecord values(UUID value1, UUID value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JooqTagContentRecord
     */
    public JooqTagContentRecord() {
        super(JooqTagContent.TAG_CONTENT);
    }

    /**
     * Create a detached, initialised JooqTagContentRecord
     */
    public JooqTagContentRecord(UUID tagUuid, UUID contentUuid) {
        super(JooqTagContent.TAG_CONTENT);

        setTagUuid(tagUuid);
        setContentUuid(contentUuid);
    }

    /**
     * Create a detached, initialised JooqTagContentRecord
     */
    public JooqTagContentRecord(io.metaloom.loom.db.jooq.tables.pojos.JooqTagContent value) {
        super(JooqTagContent.TAG_CONTENT);

        if (value != null) {
            setTagUuid(value.getTagUuid());
            setContentUuid(value.getContentUuid());
        }
    }
}