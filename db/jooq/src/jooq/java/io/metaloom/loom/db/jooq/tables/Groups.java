/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.Indexes;
import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.Public;
import io.metaloom.loom.db.jooq.tables.records.GroupsRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.JSONB;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row7;
import org.jooq.Schema;
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
public class Groups extends TableImpl<GroupsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.groups</code>
     */
    public static final Groups GROUPS = new Groups();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GroupsRecord> getRecordType() {
        return GroupsRecord.class;
    }

    /**
     * The column <code>public.groups.uuid</code>.
     */
    public final TableField<GroupsRecord, java.util.UUID> UUID = createField(DSL.name("uuid"), SQLDataType.UUID.nullable(false).defaultValue(DSL.field("uuid_generate_v4()", SQLDataType.UUID)), this, "");

    /**
     * The column <code>public.groups.name</code>.
     */
    public final TableField<GroupsRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.groups.meta</code>. Custom meta properties to the
     * element
     */
    public final TableField<GroupsRecord, JSONB> META = createField(DSL.name("meta"), SQLDataType.JSONB, this, "Custom meta properties to the element");

    /**
     * The column <code>public.groups.created</code>.
     */
    public final TableField<GroupsRecord, LocalDateTime> CREATED = createField(DSL.name("created"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.groups.creator_uuid</code>.
     */
    public final TableField<GroupsRecord, java.util.UUID> CREATOR_UUID = createField(DSL.name("creator_uuid"), SQLDataType.UUID, this, "");

    /**
     * The column <code>public.groups.edited</code>.
     */
    public final TableField<GroupsRecord, LocalDateTime> EDITED = createField(DSL.name("edited"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.groups.editor_uuid</code>.
     */
    public final TableField<GroupsRecord, java.util.UUID> EDITOR_UUID = createField(DSL.name("editor_uuid"), SQLDataType.UUID, this, "");

    private Groups(Name alias, Table<GroupsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Groups(Name alias, Table<GroupsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.groups</code> table reference
     */
    public Groups(String alias) {
        this(DSL.name(alias), GROUPS);
    }

    /**
     * Create an aliased <code>public.groups</code> table reference
     */
    public Groups(Name alias) {
        this(alias, GROUPS);
    }

    /**
     * Create a <code>public.groups</code> table reference
     */
    public Groups() {
        this(DSL.name("groups"), null);
    }

    public <O extends Record> Groups(Table<O> child, ForeignKey<O, GroupsRecord> key) {
        super(child, key, GROUPS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.GROUPS_NAME_IDX);
    }

    @Override
    public UniqueKey<GroupsRecord> getPrimaryKey() {
        return Keys.GROUPS_PKEY;
    }

    @Override
    public List<UniqueKey<GroupsRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.GROUPS_NAME_KEY);
    }

    @Override
    public List<ForeignKey<GroupsRecord, ?>> getReferences() {
        return Arrays.asList(Keys.GROUPS__GROUPS_CREATOR_UUID_FKEY, Keys.GROUPS__GROUPS_EDITOR_UUID_FKEY);
    }

    private transient Users _groupsCreatorUuidFkey;
    private transient Users _groupsEditorUuidFkey;

    public Users groupsCreatorUuidFkey() {
        if (_groupsCreatorUuidFkey == null)
            _groupsCreatorUuidFkey = new Users(this, Keys.GROUPS__GROUPS_CREATOR_UUID_FKEY);

        return _groupsCreatorUuidFkey;
    }

    public Users groupsEditorUuidFkey() {
        if (_groupsEditorUuidFkey == null)
            _groupsEditorUuidFkey = new Users(this, Keys.GROUPS__GROUPS_EDITOR_UUID_FKEY);

        return _groupsEditorUuidFkey;
    }

    @Override
    public Groups as(String alias) {
        return new Groups(DSL.name(alias), this);
    }

    @Override
    public Groups as(Name alias) {
        return new Groups(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Groups rename(String name) {
        return new Groups(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Groups rename(Name name) {
        return new Groups(name, null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<java.util.UUID, String, JSONB, LocalDateTime, java.util.UUID, LocalDateTime, java.util.UUID> fieldsRow() {
        return (Row7) super.fieldsRow();
    }
}
