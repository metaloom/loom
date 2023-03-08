/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.tables.FieldReference;
import io.metaloom.loom.db.jooq.tables.pojos.JooqFieldReference;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This table is mainly used to lookup foreign references to contents
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FieldReferenceRecord extends UpdatableRecordImpl<FieldReferenceRecord> implements Record3<UUID, UUID, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.field_reference.source_uuid</code>.
     */
    public void setSourceUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.field_reference.source_uuid</code>.
     */
    public UUID getSourceUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.field_reference.target_uuid</code>.
     */
    public void setTargetUuid(UUID value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.field_reference.target_uuid</code>.
     */
    public UUID getTargetUuid() {
        return (UUID) get(1);
    }

    /**
     * Setter for <code>public.field_reference.field_name</code>. Name of the
     * field in which the content reference was listed.
     */
    public void setFieldName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.field_reference.field_name</code>. Name of the
     * field in which the content reference was listed.
     */
    public String getFieldName() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<UUID, UUID> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<UUID, UUID, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<UUID, UUID, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return FieldReference.FIELD_REFERENCE.SOURCE_UUID;
    }

    @Override
    public Field<UUID> field2() {
        return FieldReference.FIELD_REFERENCE.TARGET_UUID;
    }

    @Override
    public Field<String> field3() {
        return FieldReference.FIELD_REFERENCE.FIELD_NAME;
    }

    @Override
    public UUID component1() {
        return getSourceUuid();
    }

    @Override
    public UUID component2() {
        return getTargetUuid();
    }

    @Override
    public String component3() {
        return getFieldName();
    }

    @Override
    public UUID value1() {
        return getSourceUuid();
    }

    @Override
    public UUID value2() {
        return getTargetUuid();
    }

    @Override
    public String value3() {
        return getFieldName();
    }

    @Override
    public FieldReferenceRecord value1(UUID value) {
        setSourceUuid(value);
        return this;
    }

    @Override
    public FieldReferenceRecord value2(UUID value) {
        setTargetUuid(value);
        return this;
    }

    @Override
    public FieldReferenceRecord value3(String value) {
        setFieldName(value);
        return this;
    }

    @Override
    public FieldReferenceRecord values(UUID value1, UUID value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached FieldReferenceRecord
     */
    public FieldReferenceRecord() {
        super(FieldReference.FIELD_REFERENCE);
    }

    /**
     * Create a detached, initialised FieldReferenceRecord
     */
    public FieldReferenceRecord(UUID sourceUuid, UUID targetUuid, String fieldName) {
        super(FieldReference.FIELD_REFERENCE);

        setSourceUuid(sourceUuid);
        setTargetUuid(targetUuid);
        setFieldName(fieldName);
    }

    /**
     * Create a detached, initialised FieldReferenceRecord
     */
    public FieldReferenceRecord(JooqFieldReference value) {
        super(FieldReference.FIELD_REFERENCE);

        if (value != null) {
            setSourceUuid(value.getSourceUuid());
            setTargetUuid(value.getTargetUuid());
            setFieldName(value.getFieldName());
        }
    }
}
