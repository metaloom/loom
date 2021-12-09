/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.Public;
import io.metaloom.loom.db.jooq.tables.records.AssetTimelineRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row8;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This table contains asset timeline entries
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AssetTimeline extends TableImpl<AssetTimelineRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.asset_timeline</code>
     */
    public static final AssetTimeline ASSET_TIMELINE = new AssetTimeline();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AssetTimelineRecord> getRecordType() {
        return AssetTimelineRecord.class;
    }

    /**
     * The column <code>public.asset_timeline.uuid</code>.
     */
    public final TableField<AssetTimelineRecord, java.util.UUID> UUID = createField(DSL.name("uuid"), SQLDataType.UUID.nullable(false).defaultValue(DSL.field("uuid_generate_v4()", SQLDataType.UUID)), this, "");

    /**
     * The column <code>public.asset_timeline.asset_uuid</code>.
     */
    public final TableField<AssetTimelineRecord, java.util.UUID> ASSET_UUID = createField(DSL.name("asset_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.asset_timeline.from</code>.
     */
    public final TableField<AssetTimelineRecord, Integer> FROM = createField(DSL.name("from"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.asset_timeline.to</code>.
     */
    public final TableField<AssetTimelineRecord, Integer> TO = createField(DSL.name("to"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.asset_timeline.description</code>.
     */
    public final TableField<AssetTimelineRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.asset_timeline.tags</code>.
     */
    public final TableField<AssetTimelineRecord, String> TAGS = createField(DSL.name("tags"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.asset_timeline.meta</code>.
     */
    public final TableField<AssetTimelineRecord, String> META = createField(DSL.name("meta"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.asset_timeline.thumbail</code>.
     */
    public final TableField<AssetTimelineRecord, String> THUMBAIL = createField(DSL.name("thumbail"), SQLDataType.VARCHAR, this, "");

    private AssetTimeline(Name alias, Table<AssetTimelineRecord> aliased) {
        this(alias, aliased, null);
    }

    private AssetTimeline(Name alias, Table<AssetTimelineRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("This table contains asset timeline entries"), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.asset_timeline</code> table reference
     */
    public AssetTimeline(String alias) {
        this(DSL.name(alias), ASSET_TIMELINE);
    }

    /**
     * Create an aliased <code>public.asset_timeline</code> table reference
     */
    public AssetTimeline(Name alias) {
        this(alias, ASSET_TIMELINE);
    }

    /**
     * Create a <code>public.asset_timeline</code> table reference
     */
    public AssetTimeline() {
        this(DSL.name("asset_timeline"), null);
    }

    public <O extends Record> AssetTimeline(Table<O> child, ForeignKey<O, AssetTimelineRecord> key) {
        super(child, key, ASSET_TIMELINE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<AssetTimelineRecord> getPrimaryKey() {
        return Keys.ASSET_TIMELINE_PKEY;
    }

    @Override
    public List<ForeignKey<AssetTimelineRecord, ?>> getReferences() {
        return Arrays.asList(Keys.ASSET_TIMELINE__ASSET_TIMELINE_ASSET_UUID_FKEY);
    }

    private transient Asset _asset;

    public Asset asset() {
        if (_asset == null)
            _asset = new Asset(this, Keys.ASSET_TIMELINE__ASSET_TIMELINE_ASSET_UUID_FKEY);

        return _asset;
    }

    @Override
    public AssetTimeline as(String alias) {
        return new AssetTimeline(DSL.name(alias), this);
    }

    @Override
    public AssetTimeline as(Name alias) {
        return new AssetTimeline(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public AssetTimeline rename(String name) {
        return new AssetTimeline(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public AssetTimeline rename(Name name) {
        return new AssetTimeline(name, null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<java.util.UUID, java.util.UUID, Integer, Integer, String, String, String, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }
}
