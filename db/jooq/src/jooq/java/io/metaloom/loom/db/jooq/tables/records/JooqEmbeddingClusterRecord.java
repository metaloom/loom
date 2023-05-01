/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.tables.JooqEmbeddingCluster;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * List embeddings for clusters
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqEmbeddingClusterRecord extends UpdatableRecordImpl<JooqEmbeddingClusterRecord> implements Record2<UUID, UUID> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.embedding_cluster.embedding_uuid</code>.
     */
    public void setEmbeddingUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.embedding_cluster.embedding_uuid</code>.
     */
    public UUID getEmbeddingUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.embedding_cluster.cluster_uuid</code>.
     */
    public void setClusterUuid(UUID value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.embedding_cluster.cluster_uuid</code>.
     */
    public UUID getClusterUuid() {
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
        return JooqEmbeddingCluster.EMBEDDING_CLUSTER.EMBEDDING_UUID;
    }

    @Override
    public Field<UUID> field2() {
        return JooqEmbeddingCluster.EMBEDDING_CLUSTER.CLUSTER_UUID;
    }

    @Override
    public UUID component1() {
        return getEmbeddingUuid();
    }

    @Override
    public UUID component2() {
        return getClusterUuid();
    }

    @Override
    public UUID value1() {
        return getEmbeddingUuid();
    }

    @Override
    public UUID value2() {
        return getClusterUuid();
    }

    @Override
    public JooqEmbeddingClusterRecord value1(UUID value) {
        setEmbeddingUuid(value);
        return this;
    }

    @Override
    public JooqEmbeddingClusterRecord value2(UUID value) {
        setClusterUuid(value);
        return this;
    }

    @Override
    public JooqEmbeddingClusterRecord values(UUID value1, UUID value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JooqEmbeddingClusterRecord
     */
    public JooqEmbeddingClusterRecord() {
        super(JooqEmbeddingCluster.EMBEDDING_CLUSTER);
    }

    /**
     * Create a detached, initialised JooqEmbeddingClusterRecord
     */
    public JooqEmbeddingClusterRecord(UUID embeddingUuid, UUID clusterUuid) {
        super(JooqEmbeddingCluster.EMBEDDING_CLUSTER);

        setEmbeddingUuid(embeddingUuid);
        setClusterUuid(clusterUuid);
    }

    /**
     * Create a detached, initialised JooqEmbeddingClusterRecord
     */
    public JooqEmbeddingClusterRecord(io.metaloom.loom.db.jooq.tables.pojos.JooqEmbeddingCluster value) {
        super(JooqEmbeddingCluster.EMBEDDING_CLUSTER);

        if (value != null) {
            setEmbeddingUuid(value.getEmbeddingUuid());
            setClusterUuid(value.getClusterUuid());
        }
    }
}
