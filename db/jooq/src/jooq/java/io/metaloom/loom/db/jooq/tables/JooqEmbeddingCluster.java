/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.JooqPublic;
import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.tables.records.JooqEmbeddingClusterRecord;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function2;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * List embeddings for clusters
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqEmbeddingCluster extends TableImpl<JooqEmbeddingClusterRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.embedding_cluster</code>
     */
    public static final JooqEmbeddingCluster EMBEDDING_CLUSTER = new JooqEmbeddingCluster();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JooqEmbeddingClusterRecord> getRecordType() {
        return JooqEmbeddingClusterRecord.class;
    }

    /**
     * The column <code>public.embedding_cluster.embedding_uuid</code>.
     */
    public final TableField<JooqEmbeddingClusterRecord, UUID> EMBEDDING_UUID = createField(DSL.name("embedding_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.embedding_cluster.cluster_uuid</code>.
     */
    public final TableField<JooqEmbeddingClusterRecord, UUID> CLUSTER_UUID = createField(DSL.name("cluster_uuid"), SQLDataType.UUID.nullable(false), this, "");

    private JooqEmbeddingCluster(Name alias, Table<JooqEmbeddingClusterRecord> aliased) {
        this(alias, aliased, null);
    }

    private JooqEmbeddingCluster(Name alias, Table<JooqEmbeddingClusterRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("List embeddings for clusters"), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.embedding_cluster</code> table reference
     */
    public JooqEmbeddingCluster(String alias) {
        this(DSL.name(alias), EMBEDDING_CLUSTER);
    }

    /**
     * Create an aliased <code>public.embedding_cluster</code> table reference
     */
    public JooqEmbeddingCluster(Name alias) {
        this(alias, EMBEDDING_CLUSTER);
    }

    /**
     * Create a <code>public.embedding_cluster</code> table reference
     */
    public JooqEmbeddingCluster() {
        this(DSL.name("embedding_cluster"), null);
    }

    public <O extends Record> JooqEmbeddingCluster(Table<O> child, ForeignKey<O, JooqEmbeddingClusterRecord> key) {
        super(child, key, EMBEDDING_CLUSTER);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : JooqPublic.PUBLIC;
    }

    @Override
    public UniqueKey<JooqEmbeddingClusterRecord> getPrimaryKey() {
        return Keys.EMBEDDING_CLUSTER_PKEY;
    }

    @Override
    public List<ForeignKey<JooqEmbeddingClusterRecord, ?>> getReferences() {
        return Arrays.asList(Keys.EMBEDDING_CLUSTER__EMBEDDING_CLUSTER_EMBEDDING_UUID_FKEY, Keys.EMBEDDING_CLUSTER__EMBEDDING_CLUSTER_CLUSTER_UUID_FKEY);
    }

    private transient JooqEmbedding _embedding;
    private transient JooqCluster _cluster;

    /**
     * Get the implicit join path to the <code>public.embedding</code> table.
     */
    public JooqEmbedding embedding() {
        if (_embedding == null)
            _embedding = new JooqEmbedding(this, Keys.EMBEDDING_CLUSTER__EMBEDDING_CLUSTER_EMBEDDING_UUID_FKEY);

        return _embedding;
    }

    /**
     * Get the implicit join path to the <code>public.cluster</code> table.
     */
    public JooqCluster cluster() {
        if (_cluster == null)
            _cluster = new JooqCluster(this, Keys.EMBEDDING_CLUSTER__EMBEDDING_CLUSTER_CLUSTER_UUID_FKEY);

        return _cluster;
    }

    @Override
    public JooqEmbeddingCluster as(String alias) {
        return new JooqEmbeddingCluster(DSL.name(alias), this);
    }

    @Override
    public JooqEmbeddingCluster as(Name alias) {
        return new JooqEmbeddingCluster(alias, this);
    }

    @Override
    public JooqEmbeddingCluster as(Table<?> alias) {
        return new JooqEmbeddingCluster(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqEmbeddingCluster rename(String name) {
        return new JooqEmbeddingCluster(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqEmbeddingCluster rename(Name name) {
        return new JooqEmbeddingCluster(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqEmbeddingCluster rename(Table<?> name) {
        return new JooqEmbeddingCluster(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<UUID, UUID> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function2<? super UUID, ? super UUID, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function2<? super UUID, ? super UUID, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
