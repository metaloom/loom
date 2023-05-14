/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.tables.JooqAssetTask;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqAssetTaskRecord extends UpdatableRecordImpl<JooqAssetTaskRecord> implements Record2<UUID, UUID> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.asset_task.asset_uuid</code>.
     */
    public void setAssetUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.asset_task.asset_uuid</code>.
     */
    public UUID getAssetUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.asset_task.task_uuid</code>.
     */
    public void setTaskUuid(UUID value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.asset_task.task_uuid</code>.
     */
    public UUID getTaskUuid() {
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
        return JooqAssetTask.ASSET_TASK.ASSET_UUID;
    }

    @Override
    public Field<UUID> field2() {
        return JooqAssetTask.ASSET_TASK.TASK_UUID;
    }

    @Override
    public UUID component1() {
        return getAssetUuid();
    }

    @Override
    public UUID component2() {
        return getTaskUuid();
    }

    @Override
    public UUID value1() {
        return getAssetUuid();
    }

    @Override
    public UUID value2() {
        return getTaskUuid();
    }

    @Override
    public JooqAssetTaskRecord value1(UUID value) {
        setAssetUuid(value);
        return this;
    }

    @Override
    public JooqAssetTaskRecord value2(UUID value) {
        setTaskUuid(value);
        return this;
    }

    @Override
    public JooqAssetTaskRecord values(UUID value1, UUID value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JooqAssetTaskRecord
     */
    public JooqAssetTaskRecord() {
        super(JooqAssetTask.ASSET_TASK);
    }

    /**
     * Create a detached, initialised JooqAssetTaskRecord
     */
    public JooqAssetTaskRecord(UUID assetUuid, UUID taskUuid) {
        super(JooqAssetTask.ASSET_TASK);

        setAssetUuid(assetUuid);
        setTaskUuid(taskUuid);
    }
}