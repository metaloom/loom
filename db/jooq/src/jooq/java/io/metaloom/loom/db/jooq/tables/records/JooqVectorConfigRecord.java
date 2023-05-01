/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.tables.JooqVectorConfig;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.JSONB;
import org.jooq.Record3;
import org.jooq.Row3;
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
public class JooqVectorConfigRecord extends TableRecordImpl<JooqVectorConfigRecord> implements Record3<UUID, String, JSONB> {

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

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<UUID, String, JSONB> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<UUID, String, JSONB> valuesRow() {
        return (Row3) super.valuesRow();
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
    public JooqVectorConfigRecord values(UUID value1, String value2, JSONB value3) {
        value1(value1);
        value2(value2);
        value3(value3);
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
    public JooqVectorConfigRecord(UUID uuid, String name, JSONB weights) {
        super(JooqVectorConfig.VECTOR_CONFIG);

        setUuid(uuid);
        setName(name);
        setWeights(weights);
    }

    /**
     * Create a detached, initialised JooqVectorConfigRecord
     */
    public JooqVectorConfigRecord(io.metaloom.loom.db.jooq.tables.pojos.JooqVectorConfig value) {
        super(JooqVectorConfig.VECTOR_CONFIG);

        if (value != null) {
            setUuid(value.getUuid());
            setName(value.getName());
            setWeights(value.getWeights());
        }
    }
}
