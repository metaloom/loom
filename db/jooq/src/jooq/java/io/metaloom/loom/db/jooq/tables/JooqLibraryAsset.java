/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.JooqPublic;
import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.tables.records.JooqLibraryAssetRecord;

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
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqLibraryAsset extends TableImpl<JooqLibraryAssetRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.library_asset</code>
     */
    public static final JooqLibraryAsset LIBRARY_ASSET = new JooqLibraryAsset();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JooqLibraryAssetRecord> getRecordType() {
        return JooqLibraryAssetRecord.class;
    }

    /**
     * The column <code>public.library_asset.library_uuid</code>.
     */
    public final TableField<JooqLibraryAssetRecord, UUID> LIBRARY_UUID = createField(DSL.name("library_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.library_asset.asset_uuid</code>.
     */
    public final TableField<JooqLibraryAssetRecord, UUID> ASSET_UUID = createField(DSL.name("asset_uuid"), SQLDataType.UUID.nullable(false), this, "");

    private JooqLibraryAsset(Name alias, Table<JooqLibraryAssetRecord> aliased) {
        this(alias, aliased, null);
    }

    private JooqLibraryAsset(Name alias, Table<JooqLibraryAssetRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.library_asset</code> table reference
     */
    public JooqLibraryAsset(String alias) {
        this(DSL.name(alias), LIBRARY_ASSET);
    }

    /**
     * Create an aliased <code>public.library_asset</code> table reference
     */
    public JooqLibraryAsset(Name alias) {
        this(alias, LIBRARY_ASSET);
    }

    /**
     * Create a <code>public.library_asset</code> table reference
     */
    public JooqLibraryAsset() {
        this(DSL.name("library_asset"), null);
    }

    public <O extends Record> JooqLibraryAsset(Table<O> child, ForeignKey<O, JooqLibraryAssetRecord> key) {
        super(child, key, LIBRARY_ASSET);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : JooqPublic.PUBLIC;
    }

    @Override
    public UniqueKey<JooqLibraryAssetRecord> getPrimaryKey() {
        return Keys.LIBRARY_ASSET_PKEY;
    }

    @Override
    public List<ForeignKey<JooqLibraryAssetRecord, ?>> getReferences() {
        return Arrays.asList(Keys.LIBRARY_ASSET__LIBRARY_ASSET_LIBRARY_UUID_FKEY);
    }

    private transient JooqLibrary _library;

    /**
     * Get the implicit join path to the <code>public.library</code> table.
     */
    public JooqLibrary library() {
        if (_library == null)
            _library = new JooqLibrary(this, Keys.LIBRARY_ASSET__LIBRARY_ASSET_LIBRARY_UUID_FKEY);

        return _library;
    }

    @Override
    public JooqLibraryAsset as(String alias) {
        return new JooqLibraryAsset(DSL.name(alias), this);
    }

    @Override
    public JooqLibraryAsset as(Name alias) {
        return new JooqLibraryAsset(alias, this);
    }

    @Override
    public JooqLibraryAsset as(Table<?> alias) {
        return new JooqLibraryAsset(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqLibraryAsset rename(String name) {
        return new JooqLibraryAsset(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqLibraryAsset rename(Name name) {
        return new JooqLibraryAsset(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqLibraryAsset rename(Table<?> name) {
        return new JooqLibraryAsset(name.getQualifiedName(), null);
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
