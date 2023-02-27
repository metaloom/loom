/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.Public;
import io.metaloom.loom.db.jooq.tables.records.AssetUserMetaRecord;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function4;
import org.jooq.JSONB;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row4;
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
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AssetUserMeta extends TableImpl<AssetUserMetaRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.asset_user_meta</code>
     */
    public static final AssetUserMeta ASSET_USER_META = new AssetUserMeta();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AssetUserMetaRecord> getRecordType() {
        return AssetUserMetaRecord.class;
    }

    /**
     * The column <code>public.asset_user_meta.asset_uuid</code>.
     */
    public final TableField<AssetUserMetaRecord, UUID> ASSET_UUID = createField(DSL.name("asset_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.asset_user_meta.user_uuid</code>.
     */
    public final TableField<AssetUserMetaRecord, UUID> USER_UUID = createField(DSL.name("user_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.asset_user_meta.rating</code>. Asset rating by
     * the user
     */
    public final TableField<AssetUserMetaRecord, Integer> RATING = createField(DSL.name("rating"), SQLDataType.INTEGER, this, "Asset rating by the user");

    /**
     * The column <code>public.asset_user_meta.meta</code>. Custom meta
     * properties
     */
    public final TableField<AssetUserMetaRecord, JSONB> META = createField(DSL.name("meta"), SQLDataType.JSONB, this, "Custom meta properties");

    private AssetUserMeta(Name alias, Table<AssetUserMetaRecord> aliased) {
        this(alias, aliased, null);
    }

    private AssetUserMeta(Name alias, Table<AssetUserMetaRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.asset_user_meta</code> table reference
     */
    public AssetUserMeta(String alias) {
        this(DSL.name(alias), ASSET_USER_META);
    }

    /**
     * Create an aliased <code>public.asset_user_meta</code> table reference
     */
    public AssetUserMeta(Name alias) {
        this(alias, ASSET_USER_META);
    }

    /**
     * Create a <code>public.asset_user_meta</code> table reference
     */
    public AssetUserMeta() {
        this(DSL.name("asset_user_meta"), null);
    }

    public <O extends Record> AssetUserMeta(Table<O> child, ForeignKey<O, AssetUserMetaRecord> key) {
        super(child, key, ASSET_USER_META);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<AssetUserMetaRecord> getPrimaryKey() {
        return Keys.ASSET_USER_META_PKEY;
    }

    @Override
    public List<ForeignKey<AssetUserMetaRecord, ?>> getReferences() {
        return Arrays.asList(Keys.ASSET_USER_META__ASSET_USER_META_ASSET_UUID_FKEY, Keys.ASSET_USER_META__ASSET_USER_META_USER_UUID_FKEY);
    }

    private transient Asset _asset;
    private transient User _user;

    /**
     * Get the implicit join path to the <code>public.asset</code> table.
     */
    public Asset asset() {
        if (_asset == null)
            _asset = new Asset(this, Keys.ASSET_USER_META__ASSET_USER_META_ASSET_UUID_FKEY);

        return _asset;
    }

    /**
     * Get the implicit join path to the <code>public.user</code> table.
     */
    public User user() {
        if (_user == null)
            _user = new User(this, Keys.ASSET_USER_META__ASSET_USER_META_USER_UUID_FKEY);

        return _user;
    }

    @Override
    public AssetUserMeta as(String alias) {
        return new AssetUserMeta(DSL.name(alias), this);
    }

    @Override
    public AssetUserMeta as(Name alias) {
        return new AssetUserMeta(alias, this);
    }

    @Override
    public AssetUserMeta as(Table<?> alias) {
        return new AssetUserMeta(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public AssetUserMeta rename(String name) {
        return new AssetUserMeta(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public AssetUserMeta rename(Name name) {
        return new AssetUserMeta(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public AssetUserMeta rename(Table<?> name) {
        return new AssetUserMeta(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<UUID, UUID, Integer, JSONB> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function4<? super UUID, ? super UUID, ? super Integer, ? super JSONB, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function4<? super UUID, ? super UUID, ? super Integer, ? super JSONB, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}