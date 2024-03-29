/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.tables.JooqVectorConfig;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.JSONB;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.TableRecordImpl;


/**
 * This table stores the custom index definition that will be used when creating
 * custom indices in a vector database that list specific aspects of loom data.
 * 
 * A custom configuration may define that a specific meta property should be
 * added to the index when generating the vector.
 * This feature can be used to generate a custom recommendation feature by
 * including and ranking and encoding specific properties as vectors.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqVectorConfigRecord extends TableRecordImpl<JooqVectorConfigRecord> implements Record7<UUID, String, JSONB, LocalDateTime, UUID, LocalDateTime, UUID> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.vector_config.uuid</code>.
     */
    public void setUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.vector_config.uuid</code>.
     */
    public UUID getUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.vector_config.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.vector_config.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.vector_config.weights</code>. Index definition
     * which lists the weights for each component that should be included in the
     * index
     */
    public void setWeights(JSONB value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.vector_config.weights</code>. Index definition
     * which lists the weights for each component that should be included in the
     * index
     */
    public JSONB getWeights() {
        return (JSONB) get(2);
    }

    /**
     * Setter for <code>public.vector_config.created</code>.
     */
    public void setCreated(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.vector_config.created</code>.
     */
    public LocalDateTime getCreated() {
        return (LocalDateTime) get(3);
    }

    /**
     * Setter for <code>public.vector_config.creator_uuid</code>.
     */
    public void setCreatorUuid(UUID value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.vector_config.creator_uuid</code>.
     */
    public UUID getCreatorUuid() {
        return (UUID) get(4);
    }

    /**
     * Setter for <code>public.vector_config.edited</code>.
     */
    public void setEdited(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.vector_config.edited</code>.
     */
    public LocalDateTime getEdited() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>public.vector_config.editor_uuid</code>.
     */
    public void setEditorUuid(UUID value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.vector_config.editor_uuid</code>.
     */
    public UUID getEditorUuid() {
        return (UUID) get(6);
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row7<UUID, String, JSONB, LocalDateTime, UUID, LocalDateTime, UUID> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<UUID, String, JSONB, LocalDateTime, UUID, LocalDateTime, UUID> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return JooqVectorConfig.VECTOR_CONFIG.UUID;
    }

    @Override
    public Field<String> field2() {
        return JooqVectorConfig.VECTOR_CONFIG.NAME;
    }

    @Override
    public Field<JSONB> field3() {
        return JooqVectorConfig.VECTOR_CONFIG.WEIGHTS;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return JooqVectorConfig.VECTOR_CONFIG.CREATED;
    }

    @Override
    public Field<UUID> field5() {
        return JooqVectorConfig.VECTOR_CONFIG.CREATOR_UUID;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return JooqVectorConfig.VECTOR_CONFIG.EDITED;
    }

    @Override
    public Field<UUID> field7() {
        return JooqVectorConfig.VECTOR_CONFIG.EDITOR_UUID;
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
    public JSONB component3() {
        return getWeights();
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
    public LocalDateTime component6() {
        return getEdited();
    }

    @Override
    public UUID component7() {
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
    public JSONB value3() {
        return getWeights();
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
    public LocalDateTime value6() {
        return getEdited();
    }

    @Override
    public UUID value7() {
        return getEditorUuid();
    }

    @Override
    public JooqVectorConfigRecord value1(UUID value) {
        setUuid(value);
        return this;
    }

    @Override
    public JooqVectorConfigRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public JooqVectorConfigRecord value3(JSONB value) {
        setWeights(value);
        return this;
    }

    @Override
    public JooqVectorConfigRecord value4(LocalDateTime value) {
        setCreated(value);
        return this;
    }

    @Override
    public JooqVectorConfigRecord value5(UUID value) {
        setCreatorUuid(value);
        return this;
    }

    @Override
    public JooqVectorConfigRecord value6(LocalDateTime value) {
        setEdited(value);
        return this;
    }

    @Override
    public JooqVectorConfigRecord value7(UUID value) {
        setEditorUuid(value);
        return this;
    }

    @Override
    public JooqVectorConfigRecord values(UUID value1, String value2, JSONB value3, LocalDateTime value4, UUID value5, LocalDateTime value6, UUID value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JooqVectorConfigRecord
     */
    public JooqVectorConfigRecord() {
        super(JooqVectorConfig.VECTOR_CONFIG);
    }

    /**
     * Create a detached, initialised JooqVectorConfigRecord
     */
    public JooqVectorConfigRecord(UUID uuid, String name, JSONB weights, LocalDateTime created, UUID creatorUuid, LocalDateTime edited, UUID editorUuid) {
        super(JooqVectorConfig.VECTOR_CONFIG);

        setUuid(uuid);
        setName(name);
        setWeights(weights);
        setCreated(created);
        setCreatorUuid(creatorUuid);
        setEdited(edited);
        setEditorUuid(editorUuid);
    }
}
