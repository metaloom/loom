/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.Indexes;
import io.metaloom.loom.db.jooq.JooqPublic;
import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.converter.JsonObjectConverter;
import io.metaloom.loom.db.jooq.tables.records.JooqGroupRecord;
import io.vertx.core.json.JsonObject;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function7;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row7;
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
public class JooqGroup extends TableImpl<JooqGroupRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.group</code>
     */
    public static final JooqGroup GROUP = new JooqGroup();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JooqGroupRecord> getRecordType() {
        return JooqGroupRecord.class;
    }

    /**
     * The column <code>public.group.uuid</code>.
     */
    public final TableField<JooqGroupRecord, java.util.UUID> UUID = createField(DSL.name("uuid"), SQLDataType.UUID.nullable(false).defaultValue(DSL.field("uuid_generate_v4()", SQLDataType.UUID)), this, "");

    /**
     * The column <code>public.group.name</code>.
     */
    public final TableField<JooqGroupRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.group.meta</code>. Custom meta properties to the
     * element
     */
    public final TableField<JooqGroupRecord, JsonObject> META = createField(DSL.name("meta"), SQLDataType.JSONB, this, "Custom meta properties to the element", new JsonObjectConverter());

    /**
     * The column <code>public.group.created</code>.
     */
    public final TableField<JooqGroupRecord, LocalDateTime> CREATED = createField(DSL.name("created"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.group.creator_uuid</code>.
     */
    public final TableField<JooqGroupRecord, java.util.UUID> CREATOR_UUID = createField(DSL.name("creator_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.group.edited</code>.
     */
    public final TableField<JooqGroupRecord, LocalDateTime> EDITED = createField(DSL.name("edited"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.group.editor_uuid</code>.
     */
    public final TableField<JooqGroupRecord, java.util.UUID> EDITOR_UUID = createField(DSL.name("editor_uuid"), SQLDataType.UUID.nullable(false), this, "");

    private JooqGroup(Name alias, Table<JooqGroupRecord> aliased) {
        this(alias, aliased, null);
    }

    private JooqGroup(Name alias, Table<JooqGroupRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.group</code> table reference
     */
    public JooqGroup(String alias) {
        this(DSL.name(alias), GROUP);
    }

    /**
     * Create an aliased <code>public.group</code> table reference
     */
    public JooqGroup(Name alias) {
        this(alias, GROUP);
    }

    /**
     * Create a <code>public.group</code> table reference
     */
    public JooqGroup() {
        this(DSL.name("group"), null);
    }

    public <O extends Record> JooqGroup(Table<O> child, ForeignKey<O, JooqGroupRecord> key) {
        super(child, key, GROUP);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : JooqPublic.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.GROUP_NAME_IDX);
    }

    @Override
    public UniqueKey<JooqGroupRecord> getPrimaryKey() {
        return Keys.GROUP_PKEY;
    }

    @Override
    public List<UniqueKey<JooqGroupRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.GROUP_NAME_KEY);
    }

    @Override
    public List<ForeignKey<JooqGroupRecord, ?>> getReferences() {
        return Arrays.asList(Keys.GROUP__GROUP_CREATOR_UUID_FKEY, Keys.GROUP__GROUP_EDITOR_UUID_FKEY);
    }

    private transient JooqUser _groupCreatorUuidFkey;
    private transient JooqUser _groupEditorUuidFkey;

    /**
     * Get the implicit join path to the <code>public.user</code> table, via the
     * <code>group_creator_uuid_fkey</code> key.
     */
    public JooqUser groupCreatorUuidFkey() {
        if (_groupCreatorUuidFkey == null)
            _groupCreatorUuidFkey = new JooqUser(this, Keys.GROUP__GROUP_CREATOR_UUID_FKEY);

        return _groupCreatorUuidFkey;
    }

    /**
     * Get the implicit join path to the <code>public.user</code> table, via the
     * <code>group_editor_uuid_fkey</code> key.
     */
    public JooqUser groupEditorUuidFkey() {
        if (_groupEditorUuidFkey == null)
            _groupEditorUuidFkey = new JooqUser(this, Keys.GROUP__GROUP_EDITOR_UUID_FKEY);

        return _groupEditorUuidFkey;
    }

    @Override
    public JooqGroup as(String alias) {
        return new JooqGroup(DSL.name(alias), this);
    }

    @Override
    public JooqGroup as(Name alias) {
        return new JooqGroup(alias, this);
    }

    @Override
    public JooqGroup as(Table<?> alias) {
        return new JooqGroup(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqGroup rename(String name) {
        return new JooqGroup(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqGroup rename(Name name) {
        return new JooqGroup(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqGroup rename(Table<?> name) {
        return new JooqGroup(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<java.util.UUID, String, JsonObject, LocalDateTime, java.util.UUID, LocalDateTime, java.util.UUID> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function7<? super java.util.UUID, ? super String, ? super JsonObject, ? super LocalDateTime, ? super java.util.UUID, ? super LocalDateTime, ? super java.util.UUID, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function7<? super java.util.UUID, ? super String, ? super JsonObject, ? super LocalDateTime, ? super java.util.UUID, ? super LocalDateTime, ? super java.util.UUID, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
