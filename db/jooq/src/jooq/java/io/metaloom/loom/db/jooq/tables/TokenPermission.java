/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.Public;
import io.metaloom.loom.db.jooq.enums.LoomPermission;
import io.metaloom.loom.db.jooq.tables.records.TokenPermissionRecord;

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
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TokenPermission extends TableImpl<TokenPermissionRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.token_permission</code>
     */
    public static final TokenPermission TOKEN_PERMISSION = new TokenPermission();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TokenPermissionRecord> getRecordType() {
        return TokenPermissionRecord.class;
    }

    /**
     * The column <code>public.token_permission.token_uuid</code>.
     */
    public final TableField<TokenPermissionRecord, UUID> TOKEN_UUID = createField(DSL.name("token_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.token_permission.resource</code>.
     */
    public final TableField<TokenPermissionRecord, String> RESOURCE = createField(DSL.name("resource"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.token_permission.permission</code>.
     */
    public final TableField<TokenPermissionRecord, LoomPermission> PERMISSION = createField(DSL.name("permission"), SQLDataType.VARCHAR.asEnumDataType(io.metaloom.loom.db.jooq.enums.LoomPermission.class), this, "");

    private TokenPermission(Name alias, Table<TokenPermissionRecord> aliased) {
        this(alias, aliased, null);
    }

    private TokenPermission(Name alias, Table<TokenPermissionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.token_permission</code> table reference
     */
    public TokenPermission(String alias) {
        this(DSL.name(alias), TOKEN_PERMISSION);
    }

    /**
     * Create an aliased <code>public.token_permission</code> table reference
     */
    public TokenPermission(Name alias) {
        this(alias, TOKEN_PERMISSION);
    }

    /**
     * Create a <code>public.token_permission</code> table reference
     */
    public TokenPermission() {
        this(DSL.name("token_permission"), null);
    }

    public <O extends Record> TokenPermission(Table<O> child, ForeignKey<O, TokenPermissionRecord> key) {
        super(child, key, TOKEN_PERMISSION);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<TokenPermissionRecord> getPrimaryKey() {
        return Keys.TOKEN_PERMISSION_PKEY;
    }

    @Override
    public TokenPermission as(String alias) {
        return new TokenPermission(DSL.name(alias), this);
    }

    @Override
    public TokenPermission as(Name alias) {
        return new TokenPermission(alias, this);
    }

    @Override
    public TokenPermission as(Table<?> alias) {
        return new TokenPermission(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public TokenPermission rename(String name) {
        return new TokenPermission(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TokenPermission rename(Name name) {
        return new TokenPermission(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public TokenPermission rename(Table<?> name) {
        return new TokenPermission(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<UUID, String, LoomPermission> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function3<? super UUID, ? super String, ? super LoomPermission, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function3<? super UUID, ? super String, ? super LoomPermission, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
