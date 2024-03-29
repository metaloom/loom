/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.JooqPublic;
import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.converter.JsonObjectConverter;
import io.metaloom.loom.db.jooq.tables.records.JooqTagUserMetaRecord;
import io.vertx.core.json.JsonObject;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function4;
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
public class JooqTagUserMeta extends TableImpl<JooqTagUserMetaRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.tag_user_meta</code>
     */
    public static final JooqTagUserMeta TAG_USER_META = new JooqTagUserMeta();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JooqTagUserMetaRecord> getRecordType() {
        return JooqTagUserMetaRecord.class;
    }

    /**
     * The column <code>public.tag_user_meta.tag_uuid</code>.
     */
    public final TableField<JooqTagUserMetaRecord, UUID> TAG_UUID = createField(DSL.name("tag_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.tag_user_meta.user_uuid</code>.
     */
    public final TableField<JooqTagUserMetaRecord, UUID> USER_UUID = createField(DSL.name("user_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.tag_user_meta.rating</code>. Rating of the tag by
     * the user
     */
    public final TableField<JooqTagUserMetaRecord, Integer> RATING = createField(DSL.name("rating"), SQLDataType.INTEGER.nullable(false), this, "Rating of the tag by the user");

    /**
     * The column <code>public.tag_user_meta.meta</code>. Custom meta properties
     */
    public final TableField<JooqTagUserMetaRecord, JsonObject> META = createField(DSL.name("meta"), SQLDataType.JSONB, this, "Custom meta properties", new JsonObjectConverter());

    private JooqTagUserMeta(Name alias, Table<JooqTagUserMetaRecord> aliased) {
        this(alias, aliased, null);
    }

    private JooqTagUserMeta(Name alias, Table<JooqTagUserMetaRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.tag_user_meta</code> table reference
     */
    public JooqTagUserMeta(String alias) {
        this(DSL.name(alias), TAG_USER_META);
    }

    /**
     * Create an aliased <code>public.tag_user_meta</code> table reference
     */
    public JooqTagUserMeta(Name alias) {
        this(alias, TAG_USER_META);
    }

    /**
     * Create a <code>public.tag_user_meta</code> table reference
     */
    public JooqTagUserMeta() {
        this(DSL.name("tag_user_meta"), null);
    }

    public <O extends Record> JooqTagUserMeta(Table<O> child, ForeignKey<O, JooqTagUserMetaRecord> key) {
        super(child, key, TAG_USER_META);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : JooqPublic.PUBLIC;
    }

    @Override
    public UniqueKey<JooqTagUserMetaRecord> getPrimaryKey() {
        return Keys.TAG_USER_META_PKEY;
    }

    @Override
    public List<ForeignKey<JooqTagUserMetaRecord, ?>> getReferences() {
        return Arrays.asList(Keys.TAG_USER_META__TAG_USER_META_TAG_UUID_FKEY, Keys.TAG_USER_META__TAG_USER_META_USER_UUID_FKEY);
    }

    private transient JooqTag _tag;
    private transient JooqUser _user;

    /**
     * Get the implicit join path to the <code>public.tag</code> table.
     */
    public JooqTag tag() {
        if (_tag == null)
            _tag = new JooqTag(this, Keys.TAG_USER_META__TAG_USER_META_TAG_UUID_FKEY);

        return _tag;
    }

    /**
     * Get the implicit join path to the <code>public.user</code> table.
     */
    public JooqUser user() {
        if (_user == null)
            _user = new JooqUser(this, Keys.TAG_USER_META__TAG_USER_META_USER_UUID_FKEY);

        return _user;
    }

    @Override
    public JooqTagUserMeta as(String alias) {
        return new JooqTagUserMeta(DSL.name(alias), this);
    }

    @Override
    public JooqTagUserMeta as(Name alias) {
        return new JooqTagUserMeta(alias, this);
    }

    @Override
    public JooqTagUserMeta as(Table<?> alias) {
        return new JooqTagUserMeta(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqTagUserMeta rename(String name) {
        return new JooqTagUserMeta(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqTagUserMeta rename(Name name) {
        return new JooqTagUserMeta(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqTagUserMeta rename(Table<?> name) {
        return new JooqTagUserMeta(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<UUID, UUID, Integer, JsonObject> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function4<? super UUID, ? super UUID, ? super Integer, ? super JsonObject, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function4<? super UUID, ? super UUID, ? super Integer, ? super JsonObject, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
