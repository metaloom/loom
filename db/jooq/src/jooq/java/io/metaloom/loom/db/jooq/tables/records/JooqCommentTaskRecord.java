/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.tables.JooqCommentTask;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqCommentTaskRecord extends UpdatableRecordImpl<JooqCommentTaskRecord> implements Record2<UUID, UUID> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.comment_task.comment_uuid</code>.
     */
    public void setCommentUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.comment_task.comment_uuid</code>.
     */
    public UUID getCommentUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.comment_task.task_uuid</code>.
     */
    public void setTaskUuid(UUID value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.comment_task.task_uuid</code>.
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
        return JooqCommentTask.COMMENT_TASK.COMMENT_UUID;
    }

    @Override
    public Field<UUID> field2() {
        return JooqCommentTask.COMMENT_TASK.TASK_UUID;
    }

    @Override
    public UUID component1() {
        return getCommentUuid();
    }

    @Override
    public UUID component2() {
        return getTaskUuid();
    }

    @Override
    public UUID value1() {
        return getCommentUuid();
    }

    @Override
    public UUID value2() {
        return getTaskUuid();
    }

    @Override
    public JooqCommentTaskRecord value1(UUID value) {
        setCommentUuid(value);
        return this;
    }

    @Override
    public JooqCommentTaskRecord value2(UUID value) {
        setTaskUuid(value);
        return this;
    }

    @Override
    public JooqCommentTaskRecord values(UUID value1, UUID value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JooqCommentTaskRecord
     */
    public JooqCommentTaskRecord() {
        super(JooqCommentTask.COMMENT_TASK);
    }

    /**
     * Create a detached, initialised JooqCommentTaskRecord
     */
    public JooqCommentTaskRecord(UUID commentUuid, UUID taskUuid) {
        super(JooqCommentTask.COMMENT_TASK);

        setCommentUuid(commentUuid);
        setTaskUuid(taskUuid);
    }

    /**
     * Create a detached, initialised JooqCommentTaskRecord
     */
    public JooqCommentTaskRecord(io.metaloom.loom.db.jooq.tables.pojos.JooqCommentTask value) {
        super(JooqCommentTask.COMMENT_TASK);

        if (value != null) {
            setCommentUuid(value.getCommentUuid());
            setTaskUuid(value.getTaskUuid());
        }
    }
}
