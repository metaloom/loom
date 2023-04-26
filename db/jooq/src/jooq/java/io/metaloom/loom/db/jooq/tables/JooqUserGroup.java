/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.JooqPublic;
import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.tables.records.JooqUserGroupRecord;

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
public class JooqUserGroup extends TableImpl<JooqUserGroupRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.user_group</code>
     */
    public static final JooqUserGroup USER_GROUP = new JooqUserGroup();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JooqUserGroupRecord> getRecordType() {
        return JooqUserGroupRecord.class;
    }

    /**
     * The column <code>public.user_group.user_uuid</code>.
     */
    public final TableField<JooqUserGroupRecord, UUID> USER_UUID = createField(DSL.name("user_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.user_group.group_uuid</code>.
     */
    public final TableField<JooqUserGroupRecord, UUID> GROUP_UUID = createField(DSL.name("group_uuid"), SQLDataType.UUID.nullable(false), this, "");

    private JooqUserGroup(Name alias, Table<JooqUserGroupRecord> aliased) {
        this(alias, aliased, null);
    }

    private JooqUserGroup(Name alias, Table<JooqUserGroupRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.user_group</code> table reference
     */
    public JooqUserGroup(String alias) {
        this(DSL.name(alias), USER_GROUP);
    }

    /**
     * Create an aliased <code>public.user_group</code> table reference
     */
    public JooqUserGroup(Name alias) {
        this(alias, USER_GROUP);
    }

    /**
     * Create a <code>public.user_group</code> table reference
     */
    public JooqUserGroup() {
        this(DSL.name("user_group"), null);
    }

    public <O extends Record> JooqUserGroup(Table<O> child, ForeignKey<O, JooqUserGroupRecord> key) {
        super(child, key, USER_GROUP);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : JooqPublic.PUBLIC;
    }

    @Override
    public UniqueKey<JooqUserGroupRecord> getPrimaryKey() {
        return Keys.USER_GROUP_PKEY;
    }

    @Override
    public List<ForeignKey<JooqUserGroupRecord, ?>> getReferences() {
        return Arrays.asList(Keys.USER_GROUP__USER_GROUP_USER_UUID_FKEY, Keys.USER_GROUP__USER_GROUP_GROUP_UUID_FKEY);
    }

    private transient JooqUser _user;
    private transient JooqGroup _group;

    /**
     * Get the implicit join path to the <code>public.user</code> table.
     */
    public JooqUser user() {
        if (_user == null)
            _user = new JooqUser(this, Keys.USER_GROUP__USER_GROUP_USER_UUID_FKEY);

        return _user;
    }

    /**
     * Get the implicit join path to the <code>public.group</code> table.
     */
    public JooqGroup group() {
        if (_group == null)
            _group = new JooqGroup(this, Keys.USER_GROUP__USER_GROUP_GROUP_UUID_FKEY);

        return _group;
    }

    @Override
    public JooqUserGroup as(String alias) {
        return new JooqUserGroup(DSL.name(alias), this);
    }

    @Override
    public JooqUserGroup as(Name alias) {
        return new JooqUserGroup(alias, this);
    }

    @Override
    public JooqUserGroup as(Table<?> alias) {
        return new JooqUserGroup(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqUserGroup rename(String name) {
        return new JooqUserGroup(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqUserGroup rename(Name name) {
        return new JooqUserGroup(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqUserGroup rename(Table<?> name) {
        return new JooqUserGroup(name.getQualifiedName(), null);
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