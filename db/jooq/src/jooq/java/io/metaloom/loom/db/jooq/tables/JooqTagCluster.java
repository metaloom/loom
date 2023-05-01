/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.JooqPublic;
import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.tables.records.JooqTagClusterRecord;

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
 * Store tag &lt;-&gt; cluster reference
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqTagCluster extends TableImpl<JooqTagClusterRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.tag_cluster</code>
     */
    public static final JooqTagCluster TAG_CLUSTER = new JooqTagCluster();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JooqTagClusterRecord> getRecordType() {
        return JooqTagClusterRecord.class;
    }

    /**
     * The column <code>public.tag_cluster.tag_uuid</code>.
     */
    public final TableField<JooqTagClusterRecord, UUID> TAG_UUID = createField(DSL.name("tag_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.tag_cluster.cluster_uuid</code>.
     */
    public final TableField<JooqTagClusterRecord, UUID> CLUSTER_UUID = createField(DSL.name("cluster_uuid"), SQLDataType.UUID.nullable(false), this, "");

    private JooqTagCluster(Name alias, Table<JooqTagClusterRecord> aliased) {
        this(alias, aliased, null);
    }

    private JooqTagCluster(Name alias, Table<JooqTagClusterRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Store tag <-> cluster reference"), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.tag_cluster</code> table reference
     */
    public JooqTagCluster(String alias) {
        this(DSL.name(alias), TAG_CLUSTER);
    }

    /**
     * Create an aliased <code>public.tag_cluster</code> table reference
     */
    public JooqTagCluster(Name alias) {
        this(alias, TAG_CLUSTER);
    }

    /**
     * Create a <code>public.tag_cluster</code> table reference
     */
    public JooqTagCluster() {
        this(DSL.name("tag_cluster"), null);
    }

    public <O extends Record> JooqTagCluster(Table<O> child, ForeignKey<O, JooqTagClusterRecord> key) {
        super(child, key, TAG_CLUSTER);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : JooqPublic.PUBLIC;
    }

    @Override
    public UniqueKey<JooqTagClusterRecord> getPrimaryKey() {
        return Keys.TAG_CLUSTER_PKEY;
    }

    @Override
    public List<ForeignKey<JooqTagClusterRecord, ?>> getReferences() {
        return Arrays.asList(Keys.TAG_CLUSTER__TAG_CLUSTER_TAG_UUID_FKEY, Keys.TAG_CLUSTER__TAG_CLUSTER_CLUSTER_UUID_FKEY);
    }

    private transient JooqTag _tag;
    private transient JooqCluster _cluster;

    /**
     * Get the implicit join path to the <code>public.tag</code> table.
     */
    public JooqTag tag() {
        if (_tag == null)
            _tag = new JooqTag(this, Keys.TAG_CLUSTER__TAG_CLUSTER_TAG_UUID_FKEY);

        return _tag;
    }

    /**
     * Get the implicit join path to the <code>public.cluster</code> table.
     */
    public JooqCluster cluster() {
        if (_cluster == null)
            _cluster = new JooqCluster(this, Keys.TAG_CLUSTER__TAG_CLUSTER_CLUSTER_UUID_FKEY);

        return _cluster;
    }

    @Override
    public JooqTagCluster as(String alias) {
        return new JooqTagCluster(DSL.name(alias), this);
    }

    @Override
    public JooqTagCluster as(Name alias) {
        return new JooqTagCluster(alias, this);
    }

    @Override
    public JooqTagCluster as(Table<?> alias) {
        return new JooqTagCluster(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqTagCluster rename(String name) {
        return new JooqTagCluster(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqTagCluster rename(Name name) {
        return new JooqTagCluster(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqTagCluster rename(Table<?> name) {
        return new JooqTagCluster(name.getQualifiedName(), null);
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
