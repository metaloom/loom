/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.tables.JooqBinaryRemix;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.JSONB;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.TableRecordImpl;


/**
 * Store information on remixes of binaries.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqBinaryRemixRecord extends TableRecordImpl<JooqBinaryRemixRecord> implements Record5<UUID, UUID, JSONB, LocalDateTime, UUID> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.binary_remix.binary_a_uuid</code>.
     */
    public void setBinaryAUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.binary_remix.binary_a_uuid</code>.
     */
    public UUID getBinaryAUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.binary_remix.binary_b_uuid</code>.
     */
    public void setBinaryBUuid(UUID value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.binary_remix.binary_b_uuid</code>.
     */
    public UUID getBinaryBUuid() {
        return (UUID) get(1);
    }

    /**
     * Setter for <code>public.binary_remix.meta</code>. Custom meta properties
     * to the element
     */
    public void setMeta(JSONB value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.binary_remix.meta</code>. Custom meta properties
     * to the element
     */
    public JSONB getMeta() {
        return (JSONB) get(2);
    }

    /**
     * Setter for <code>public.binary_remix.created</code>.
     */
    public void setCreated(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.binary_remix.created</code>.
     */
    public LocalDateTime getCreated() {
        return (LocalDateTime) get(3);
    }

    /**
     * Setter for <code>public.binary_remix.creator_uuid</code>.
     */
    public void setCreatorUuid(UUID value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.binary_remix.creator_uuid</code>.
     */
    public UUID getCreatorUuid() {
        return (UUID) get(4);
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<UUID, UUID, JSONB, LocalDateTime, UUID> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<UUID, UUID, JSONB, LocalDateTime, UUID> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return JooqBinaryRemix.BINARY_REMIX.BINARY_A_UUID;
    }

    @Override
    public Field<UUID> field2() {
        return JooqBinaryRemix.BINARY_REMIX.BINARY_B_UUID;
    }

    @Override
    public Field<JSONB> field3() {
        return JooqBinaryRemix.BINARY_REMIX.META;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return JooqBinaryRemix.BINARY_REMIX.CREATED;
    }

    @Override
    public Field<UUID> field5() {
        return JooqBinaryRemix.BINARY_REMIX.CREATOR_UUID;
    }

    @Override
    public UUID component1() {
        return getBinaryAUuid();
    }

    @Override
    public UUID component2() {
        return getBinaryBUuid();
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
    public UUID value1() {
        return getBinaryAUuid();
    }

    @Override
    public UUID value2() {
        return getBinaryBUuid();
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
    public JooqBinaryRemixRecord value1(UUID value) {
        setBinaryAUuid(value);
        return this;
    }

    @Override
    public JooqBinaryRemixRecord value2(UUID value) {
        setBinaryBUuid(value);
        return this;
    }

    @Override
    public JooqBinaryRemixRecord value3(JSONB value) {
        setMeta(value);
        return this;
    }

    @Override
    public JooqBinaryRemixRecord value4(LocalDateTime value) {
        setCreated(value);
        return this;
    }

    @Override
    public JooqBinaryRemixRecord value5(UUID value) {
        setCreatorUuid(value);
        return this;
    }

    @Override
    public JooqBinaryRemixRecord values(UUID value1, UUID value2, JSONB value3, LocalDateTime value4, UUID value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JooqBinaryRemixRecord
     */
    public JooqBinaryRemixRecord() {
        super(JooqBinaryRemix.BINARY_REMIX);
    }

    /**
     * Create a detached, initialised JooqBinaryRemixRecord
     */
    public JooqBinaryRemixRecord(UUID binaryAUuid, UUID binaryBUuid, JSONB meta, LocalDateTime created, UUID creatorUuid) {
        super(JooqBinaryRemix.BINARY_REMIX);

        setBinaryAUuid(binaryAUuid);
        setBinaryBUuid(binaryBUuid);
        setMeta(meta);
        setCreated(created);
        setCreatorUuid(creatorUuid);
    }

    /**
     * Create a detached, initialised JooqBinaryRemixRecord
     */
    public JooqBinaryRemixRecord(io.metaloom.loom.db.jooq.tables.pojos.JooqBinaryRemix value) {
        super(JooqBinaryRemix.BINARY_REMIX);

        if (value != null) {
            setBinaryAUuid(value.getBinaryAUuid());
            setBinaryBUuid(value.getBinaryBUuid());
            setMeta(value.getMeta());
            setCreated(value.getCreated());
            setCreatorUuid(value.getCreatorUuid());
        }
    }
}
