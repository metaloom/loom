/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.Public;
import io.metaloom.loom.db.jooq.tables.records.AssetBinarieRecord;

import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function10;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row10;
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
 * This table stores the immutable asset information
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AssetBinarie extends TableImpl<AssetBinarieRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.asset_binarie</code>
     */
    public static final AssetBinarie ASSET_BINARIE = new AssetBinarie();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AssetBinarieRecord> getRecordType() {
        return AssetBinarieRecord.class;
    }

    /**
     * The column <code>public.asset_binarie.uuid</code>.
     */
    public final TableField<AssetBinarieRecord, java.util.UUID> UUID = createField(DSL.name("uuid"), SQLDataType.UUID.nullable(false).defaultValue(DSL.field("uuid_generate_v4()", SQLDataType.UUID)), this, "");

    /**
     * The column <code>public.asset_binarie.sha512sum</code>.
     */
    public final TableField<AssetBinarieRecord, String> SHA512SUM = createField(DSL.name("sha512sum"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.asset_binarie.sha256sum</code>.
     */
    public final TableField<AssetBinarieRecord, String> SHA256SUM = createField(DSL.name("sha256sum"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.asset_binarie.chunkHash</code>.
     */
    public final TableField<AssetBinarieRecord, String> CHUNKHASH = createField(DSL.name("chunkHash"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.asset_binarie.md5sum</code>.
     */
    public final TableField<AssetBinarieRecord, String> MD5SUM = createField(DSL.name("md5sum"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.asset_binarie.size</code>.
     */
    public final TableField<AssetBinarieRecord, Long> SIZE = createField(DSL.name("size"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.asset_binarie.media_width</code>. Only set for
     * images
     */
    public final TableField<AssetBinarieRecord, Integer> MEDIA_WIDTH = createField(DSL.name("media_width"), SQLDataType.INTEGER, this, "Only set for images");

    /**
     * The column <code>public.asset_binarie.media_height</code>. Only set for
     * images
     */
    public final TableField<AssetBinarieRecord, Integer> MEDIA_HEIGHT = createField(DSL.name("media_height"), SQLDataType.INTEGER, this, "Only set for images");

    /**
     * The column <code>public.asset_binarie.zero_chunk_count</code>.
     */
    public final TableField<AssetBinarieRecord, Long> ZERO_CHUNK_COUNT = createField(DSL.name("zero_chunk_count"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.asset_binarie.fingerprint</code>. Media
     * fingerprint information
     */
    public final TableField<AssetBinarieRecord, String> FINGERPRINT = createField(DSL.name("fingerprint"), SQLDataType.VARCHAR, this, "Media fingerprint information");

    private AssetBinarie(Name alias, Table<AssetBinarieRecord> aliased) {
        this(alias, aliased, null);
    }

    private AssetBinarie(Name alias, Table<AssetBinarieRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("This table stores the immutable asset information"), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.asset_binarie</code> table reference
     */
    public AssetBinarie(String alias) {
        this(DSL.name(alias), ASSET_BINARIE);
    }

    /**
     * Create an aliased <code>public.asset_binarie</code> table reference
     */
    public AssetBinarie(Name alias) {
        this(alias, ASSET_BINARIE);
    }

    /**
     * Create a <code>public.asset_binarie</code> table reference
     */
    public AssetBinarie() {
        this(DSL.name("asset_binarie"), null);
    }

    public <O extends Record> AssetBinarie(Table<O> child, ForeignKey<O, AssetBinarieRecord> key) {
        super(child, key, ASSET_BINARIE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<AssetBinarieRecord> getPrimaryKey() {
        return Keys.ASSET_BINARIE_PKEY;
    }

    @Override
    public AssetBinarie as(String alias) {
        return new AssetBinarie(DSL.name(alias), this);
    }

    @Override
    public AssetBinarie as(Name alias) {
        return new AssetBinarie(alias, this);
    }

    @Override
    public AssetBinarie as(Table<?> alias) {
        return new AssetBinarie(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public AssetBinarie rename(String name) {
        return new AssetBinarie(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public AssetBinarie rename(Name name) {
        return new AssetBinarie(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public AssetBinarie rename(Table<?> name) {
        return new AssetBinarie(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row10 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row10<java.util.UUID, String, String, String, String, Long, Integer, Integer, Long, String> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function10<? super java.util.UUID, ? super String, ? super String, ? super String, ? super String, ? super Long, ? super Integer, ? super Integer, ? super Long, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function10<? super java.util.UUID, ? super String, ? super String, ? super String, ? super String, ? super Long, ? super Integer, ? super Integer, ? super Long, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
