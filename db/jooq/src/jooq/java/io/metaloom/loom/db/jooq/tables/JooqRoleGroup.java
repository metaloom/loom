/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.JooqPublic;
import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.tables.records.JooqRoleGroupRecord;

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
public class JooqRoleGroup extends TableImpl<JooqRoleGroupRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.role_group</code>
     */
    public static final JooqRoleGroup ROLE_GROUP = new JooqRoleGroup();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JooqRoleGroupRecord> getRecordType() {
        return JooqRoleGroupRecord.class;
    }

    /**
     * The column <code>public.role_group.group_uuid</code>.
     */
    public final TableField<JooqRoleGroupRecord, UUID> GROUP_UUID = createField(DSL.name("group_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.role_group.role_uuid</code>.
     */
    public final TableField<JooqRoleGroupRecord, UUID> ROLE_UUID = createField(DSL.name("role_uuid"), SQLDataType.UUID.nullable(false), this, "");

    private JooqRoleGroup(Name alias, Table<JooqRoleGroupRecord> aliased) {
        this(alias, aliased, null);
    }

    private JooqRoleGroup(Name alias, Table<JooqRoleGroupRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.role_group</code> table reference
     */
    public JooqRoleGroup(String alias) {
        this(DSL.name(alias), ROLE_GROUP);
    }

    /**
     * Create an aliased <code>public.role_group</code> table reference
     */
    public JooqRoleGroup(Name alias) {
        this(alias, ROLE_GROUP);
    }

    /**
     * Create a <code>public.role_group</code> table reference
     */
    public JooqRoleGroup() {
        this(DSL.name("role_group"), null);
    }

    public <O extends Record> JooqRoleGroup(Table<O> child, ForeignKey<O, JooqRoleGroupRecord> key) {
        super(child, key, ROLE_GROUP);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : JooqPublic.PUBLIC;
    }

    @Override
    public UniqueKey<JooqRoleGroupRecord> getPrimaryKey() {
        return Keys.ROLE_GROUP_PKEY;
    }

    @Override
    public List<ForeignKey<JooqRoleGroupRecord, ?>> getReferences() {
        return Arrays.asList(Keys.ROLE_GROUP__ROLE_GROUP_GROUP_UUID_FKEY, Keys.ROLE_GROUP__ROLE_GROUP_ROLE_UUID_FKEY);
    }

    private transient JooqGroup _group;
    private transient JooqRole _role;

    /**
     * Get the implicit join path to the <code>public.group</code> table.
     */
    public JooqGroup group() {
        if (_group == null)
            _group = new JooqGroup(this, Keys.ROLE_GROUP__ROLE_GROUP_GROUP_UUID_FKEY);

        return _group;
    }

    /**
     * Get the implicit join path to the <code>public.role</code> table.
     */
    public JooqRole role() {
        if (_role == null)
            _role = new JooqRole(this, Keys.ROLE_GROUP__ROLE_GROUP_ROLE_UUID_FKEY);

        return _role;
    }

    @Override
    public JooqRoleGroup as(String alias) {
        return new JooqRoleGroup(DSL.name(alias), this);
    }

    @Override
    public JooqRoleGroup as(Name alias) {
        return new JooqRoleGroup(alias, this);
    }

    @Override
    public JooqRoleGroup as(Table<?> alias) {
        return new JooqRoleGroup(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqRoleGroup rename(String name) {
        return new JooqRoleGroup(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqRoleGroup rename(Name name) {
        return new JooqRoleGroup(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqRoleGroup rename(Table<?> name) {
        return new JooqRoleGroup(name.getQualifiedName(), null);
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