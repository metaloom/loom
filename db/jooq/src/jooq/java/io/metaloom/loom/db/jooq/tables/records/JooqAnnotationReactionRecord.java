/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.tables.JooqAnnotationReaction;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqAnnotationReactionRecord extends UpdatableRecordImpl<JooqAnnotationReactionRecord> implements Record2<UUID, UUID> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.annotation_reaction.annotation_uuid</code>.
     */
    public void setAnnotationUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.annotation_reaction.annotation_uuid</code>.
     */
    public UUID getAnnotationUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for
     * <code>public.annotation_reaction.reaction_annotation_uuid</code>.
     */
    public void setReactionAnnotationUuid(UUID value) {
        set(1, value);
    }

    /**
     * Getter for
     * <code>public.annotation_reaction.reaction_annotation_uuid</code>.
     */
    public UUID getReactionAnnotationUuid() {
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
        return JooqAnnotationReaction.ANNOTATION_REACTION.ANNOTATION_UUID;
    }

    @Override
    public Field<UUID> field2() {
        return JooqAnnotationReaction.ANNOTATION_REACTION.REACTION_ANNOTATION_UUID;
    }

    @Override
    public UUID component1() {
        return getAnnotationUuid();
    }

    @Override
    public UUID component2() {
        return getReactionAnnotationUuid();
    }

    @Override
    public UUID value1() {
        return getAnnotationUuid();
    }

    @Override
    public UUID value2() {
        return getReactionAnnotationUuid();
    }

    @Override
    public JooqAnnotationReactionRecord value1(UUID value) {
        setAnnotationUuid(value);
        return this;
    }

    @Override
    public JooqAnnotationReactionRecord value2(UUID value) {
        setReactionAnnotationUuid(value);
        return this;
    }

    @Override
    public JooqAnnotationReactionRecord values(UUID value1, UUID value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JooqAnnotationReactionRecord
     */
    public JooqAnnotationReactionRecord() {
        super(JooqAnnotationReaction.ANNOTATION_REACTION);
    }

    /**
     * Create a detached, initialised JooqAnnotationReactionRecord
     */
    public JooqAnnotationReactionRecord(UUID annotationUuid, UUID reactionAnnotationUuid) {
        super(JooqAnnotationReaction.ANNOTATION_REACTION);

        setAnnotationUuid(annotationUuid);
        setReactionAnnotationUuid(reactionAnnotationUuid);
    }
}