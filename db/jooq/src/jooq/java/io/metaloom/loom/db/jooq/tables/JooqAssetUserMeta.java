/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.JooqPublic;
import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.tables.records.JooqAssetUserMetaRecord;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function3;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row3;
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
 * Stores user specific metadata that can be added to asset
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqAssetUserMeta extends TableImpl<JooqAssetUserMetaRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.asset_user_meta</code>
     */
    public static final JooqAssetUserMeta ASSET_USER_META = new JooqAssetUserMeta();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JooqAssetUserMetaRecord> getRecordType() {
        return JooqAssetUserMetaRecord.class;
    }

    /**
     * The column <code>public.asset_user_meta.asset_uuid</code>.
     */
    public final TableField<JooqAssetUserMetaRecord, UUID> ASSET_UUID = createField(DSL.name("asset_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.asset_user_meta.user_uuid</code>.
     */
    public final TableField<JooqAssetUserMetaRecord, UUID> USER_UUID = createField(DSL.name("user_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.asset_user_meta.meta</code>. Custom meta
     * properties
     */
    public final TableField<JooqAssetUserMetaRecord, String> META = createField(DSL.name("meta"), SQLDataType.VARCHAR, this, "Custom meta properties");

    private JooqAssetUserMeta(Name alias, Table<JooqAssetUserMetaRecord> aliased) {
        this(alias, aliased, null);
    }

    private JooqAssetUserMeta(Name alias, Table<JooqAssetUserMetaRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Stores user specific metadata that can be added to asset"), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.asset_user_meta</code> table reference
     */
    public JooqAssetUserMeta(String alias) {
        this(DSL.name(alias), ASSET_USER_META);
    }

    /**
     * Create an aliased <code>public.asset_user_meta</code> table reference
     */
    public JooqAssetUserMeta(Name alias) {
        this(alias, ASSET_USER_META);
    }

    /**
     * Create a <code>public.asset_user_meta</code> table reference
     */
    public JooqAssetUserMeta() {
        this(DSL.name("asset_user_meta"), null);
    }

    public <O extends Record> JooqAssetUserMeta(Table<O> child, ForeignKey<O, JooqAssetUserMetaRecord> key) {
        super(child, key, ASSET_USER_META);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : JooqPublic.PUBLIC;
    }

    @Override
    public UniqueKey<JooqAssetUserMetaRecord> getPrimaryKey() {
        return Keys.ASSET_USER_META_PKEY;
    }

    @Override
    public List<ForeignKey<JooqAssetUserMetaRecord, ?>> getReferences() {
        return Arrays.asList(Keys.ASSET_USER_META__ASSET_USER_META_USER_UUID_FKEY);
    }

    private transient JooqUser _user;

    /**
     * Get the implicit join path to the <code>public.user</code> table.
     */
    public JooqUser user() {
        if (_user == null)
            _user = new JooqUser(this, Keys.ASSET_USER_META__ASSET_USER_META_USER_UUID_FKEY);

        return _user;
    }

    @Override
    public JooqAssetUserMeta as(String alias) {
        return new JooqAssetUserMeta(DSL.name(alias), this);
    }

    @Override
    public JooqAssetUserMeta as(Name alias) {
        return new JooqAssetUserMeta(alias, this);
    }

    @Override
    public JooqAssetUserMeta as(Table<?> alias) {
        return new JooqAssetUserMeta(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqAssetUserMeta rename(String name) {
        return new JooqAssetUserMeta(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqAssetUserMeta rename(Name name) {
        return new JooqAssetUserMeta(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqAssetUserMeta rename(Table<?> name) {
        return new JooqAssetUserMeta(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<UUID, UUID, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function3<? super UUID, ? super UUID, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function3<? super UUID, ? super UUID, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
