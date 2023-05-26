/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.Indexes;
import io.metaloom.loom.db.jooq.JooqPublic;
import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.converter.JsonObjectConverter;
import io.metaloom.loom.db.jooq.tables.records.JooqReactionRecord;
import io.vertx.core.json.JsonObject;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function11;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row11;
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
 * Stores social reactions on multiple elements
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqReaction extends TableImpl<JooqReactionRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.reaction</code>
     */
    public static final JooqReaction REACTION = new JooqReaction();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JooqReactionRecord> getRecordType() {
        return JooqReactionRecord.class;
    }

    /**
     * The column <code>public.reaction.uuid</code>.
     */
    public final TableField<JooqReactionRecord, java.util.UUID> UUID = createField(DSL.name("uuid"), SQLDataType.UUID.nullable(false).defaultValue(DSL.field("uuid_generate_v4()", SQLDataType.UUID)), this, "");

    /**
     * The column <code>public.reaction.type</code>. Type of the reaction (e.g.
     * thumbsup)
     */
    public final TableField<JooqReactionRecord, String> TYPE = createField(DSL.name("type"), SQLDataType.VARCHAR, this, "Type of the reaction (e.g. thumbsup)");

    /**
     * The column <code>public.reaction.rating</code>. Rating by the user
     */
    public final TableField<JooqReactionRecord, Integer> RATING = createField(DSL.name("rating"), SQLDataType.INTEGER, this, "Rating by the user");

    /**
     * The column <code>public.reaction.meta</code>. Custom meta properties to
     * the reaction.
     */
    public final TableField<JooqReactionRecord, JsonObject> META = createField(DSL.name("meta"), SQLDataType.JSONB, this, "Custom meta properties to the reaction.", new JsonObjectConverter());

    /**
     * The column <code>public.reaction.created</code>. Creation timestamp
     */
    public final TableField<JooqReactionRecord, LocalDateTime> CREATED = createField(DSL.name("created"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "Creation timestamp");

    /**
     * The column <code>public.reaction.creator_uuid</code>. Creator of the
     * reaction
     */
    public final TableField<JooqReactionRecord, java.util.UUID> CREATOR_UUID = createField(DSL.name("creator_uuid"), SQLDataType.UUID.nullable(false), this, "Creator of the reaction");

    /**
     * The column <code>public.reaction.edited</code>.
     */
    public final TableField<JooqReactionRecord, LocalDateTime> EDITED = createField(DSL.name("edited"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.reaction.editor_uuid</code>.
     */
    public final TableField<JooqReactionRecord, java.util.UUID> EDITOR_UUID = createField(DSL.name("editor_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.reaction.asset_uuid</code>.
     */
    public final TableField<JooqReactionRecord, java.util.UUID> ASSET_UUID = createField(DSL.name("asset_uuid"), SQLDataType.UUID, this, "");

    /**
     * The column <code>public.reaction.comment_uuid</code>.
     */
    public final TableField<JooqReactionRecord, java.util.UUID> COMMENT_UUID = createField(DSL.name("comment_uuid"), SQLDataType.UUID, this, "");

    /**
     * The column <code>public.reaction.annotation_uuid</code>.
     */
    public final TableField<JooqReactionRecord, java.util.UUID> ANNOTATION_UUID = createField(DSL.name("annotation_uuid"), SQLDataType.UUID, this, "");

    private JooqReaction(Name alias, Table<JooqReactionRecord> aliased) {
        this(alias, aliased, null);
    }

    private JooqReaction(Name alias, Table<JooqReactionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Stores social reactions on multiple elements"), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.reaction</code> table reference
     */
    public JooqReaction(String alias) {
        this(DSL.name(alias), REACTION);
    }

    /**
     * Create an aliased <code>public.reaction</code> table reference
     */
    public JooqReaction(Name alias) {
        this(alias, REACTION);
    }

    /**
     * Create a <code>public.reaction</code> table reference
     */
    public JooqReaction() {
        this(DSL.name("reaction"), null);
    }

    public <O extends Record> JooqReaction(Table<O> child, ForeignKey<O, JooqReactionRecord> key) {
        super(child, key, REACTION);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : JooqPublic.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.REACTION_CREATOR_UUID_TYPE_ANNOTATION_UUID_IDX, Indexes.REACTION_CREATOR_UUID_TYPE_ASSET_UUID_IDX, Indexes.REACTION_CREATOR_UUID_TYPE_COMMENT_UUID_IDX);
    }

    @Override
    public UniqueKey<JooqReactionRecord> getPrimaryKey() {
        return Keys.REACTION_PKEY;
    }

    @Override
    public List<ForeignKey<JooqReactionRecord, ?>> getReferences() {
        return Arrays.asList(Keys.REACTION__REACTION_CREATOR_UUID_FKEY, Keys.REACTION__REACTION_EDITOR_UUID_FKEY, Keys.REACTION__REACTION_COMMENT_UUID_FKEY, Keys.REACTION__REACTION_ANNOTATION_UUID_FKEY);
    }

    private transient JooqUser _reactionCreatorUuidFkey;
    private transient JooqUser _reactionEditorUuidFkey;
    private transient JooqComment _comment;
    private transient JooqAnnotation _annotation;

    /**
     * Get the implicit join path to the <code>public.user</code> table, via the
     * <code>reaction_creator_uuid_fkey</code> key.
     */
    public JooqUser reactionCreatorUuidFkey() {
        if (_reactionCreatorUuidFkey == null)
            _reactionCreatorUuidFkey = new JooqUser(this, Keys.REACTION__REACTION_CREATOR_UUID_FKEY);

        return _reactionCreatorUuidFkey;
    }

    /**
     * Get the implicit join path to the <code>public.user</code> table, via the
     * <code>reaction_editor_uuid_fkey</code> key.
     */
    public JooqUser reactionEditorUuidFkey() {
        if (_reactionEditorUuidFkey == null)
            _reactionEditorUuidFkey = new JooqUser(this, Keys.REACTION__REACTION_EDITOR_UUID_FKEY);

        return _reactionEditorUuidFkey;
    }

    /**
     * Get the implicit join path to the <code>public.comment</code> table.
     */
    public JooqComment comment() {
        if (_comment == null)
            _comment = new JooqComment(this, Keys.REACTION__REACTION_COMMENT_UUID_FKEY);

        return _comment;
    }

    /**
     * Get the implicit join path to the <code>public.annotation</code> table.
     */
    public JooqAnnotation annotation() {
        if (_annotation == null)
            _annotation = new JooqAnnotation(this, Keys.REACTION__REACTION_ANNOTATION_UUID_FKEY);

        return _annotation;
    }

    @Override
    public JooqReaction as(String alias) {
        return new JooqReaction(DSL.name(alias), this);
    }

    @Override
    public JooqReaction as(Name alias) {
        return new JooqReaction(alias, this);
    }

    @Override
    public JooqReaction as(Table<?> alias) {
        return new JooqReaction(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqReaction rename(String name) {
        return new JooqReaction(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqReaction rename(Name name) {
        return new JooqReaction(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqReaction rename(Table<?> name) {
        return new JooqReaction(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row11 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row11<java.util.UUID, String, Integer, JsonObject, LocalDateTime, java.util.UUID, LocalDateTime, java.util.UUID, java.util.UUID, java.util.UUID, java.util.UUID> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function11<? super java.util.UUID, ? super String, ? super Integer, ? super JsonObject, ? super LocalDateTime, ? super java.util.UUID, ? super LocalDateTime, ? super java.util.UUID, ? super java.util.UUID, ? super java.util.UUID, ? super java.util.UUID, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function11<? super java.util.UUID, ? super String, ? super Integer, ? super JsonObject, ? super LocalDateTime, ? super java.util.UUID, ? super LocalDateTime, ? super java.util.UUID, ? super java.util.UUID, ? super java.util.UUID, ? super java.util.UUID, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
