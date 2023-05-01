/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.JooqPublic;
import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.tables.records.JooqCommentReactionRecord;

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
public class JooqCommentReaction extends TableImpl<JooqCommentReactionRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.comment_reaction</code>
     */
    public static final JooqCommentReaction COMMENT_REACTION = new JooqCommentReaction();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JooqCommentReactionRecord> getRecordType() {
        return JooqCommentReactionRecord.class;
    }

    /**
     * The column <code>public.comment_reaction.comment_uuid</code>.
     */
    public final TableField<JooqCommentReactionRecord, UUID> COMMENT_UUID = createField(DSL.name("comment_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.comment_reaction.reaction_comment_uuid</code>.
     */
    public final TableField<JooqCommentReactionRecord, UUID> REACTION_COMMENT_UUID = createField(DSL.name("reaction_comment_uuid"), SQLDataType.UUID.nullable(false), this, "");

    private JooqCommentReaction(Name alias, Table<JooqCommentReactionRecord> aliased) {
        this(alias, aliased, null);
    }

    private JooqCommentReaction(Name alias, Table<JooqCommentReactionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.comment_reaction</code> table reference
     */
    public JooqCommentReaction(String alias) {
        this(DSL.name(alias), COMMENT_REACTION);
    }

    /**
     * Create an aliased <code>public.comment_reaction</code> table reference
     */
    public JooqCommentReaction(Name alias) {
        this(alias, COMMENT_REACTION);
    }

    /**
     * Create a <code>public.comment_reaction</code> table reference
     */
    public JooqCommentReaction() {
        this(DSL.name("comment_reaction"), null);
    }

    public <O extends Record> JooqCommentReaction(Table<O> child, ForeignKey<O, JooqCommentReactionRecord> key) {
        super(child, key, COMMENT_REACTION);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : JooqPublic.PUBLIC;
    }

    @Override
    public UniqueKey<JooqCommentReactionRecord> getPrimaryKey() {
        return Keys.COMMENT_REACTION_PKEY;
    }

    @Override
    public List<ForeignKey<JooqCommentReactionRecord, ?>> getReferences() {
        return Arrays.asList(Keys.COMMENT_REACTION__COMMENT_REACTION_COMMENT_UUID_FKEY, Keys.COMMENT_REACTION__COMMENT_REACTION_REACTION_COMMENT_UUID_FKEY);
    }

    private transient JooqComment _commentReactionCommentUuidFkey;
    private transient JooqComment _commentReactionReactionCommentUuidFkey;

    /**
     * Get the implicit join path to the <code>public.comment</code> table, via
     * the <code>comment_reaction_comment_uuid_fkey</code> key.
     */
    public JooqComment commentReactionCommentUuidFkey() {
        if (_commentReactionCommentUuidFkey == null)
            _commentReactionCommentUuidFkey = new JooqComment(this, Keys.COMMENT_REACTION__COMMENT_REACTION_COMMENT_UUID_FKEY);

        return _commentReactionCommentUuidFkey;
    }

    /**
     * Get the implicit join path to the <code>public.comment</code> table, via
     * the <code>comment_reaction_reaction_comment_uuid_fkey</code> key.
     */
    public JooqComment commentReactionReactionCommentUuidFkey() {
        if (_commentReactionReactionCommentUuidFkey == null)
            _commentReactionReactionCommentUuidFkey = new JooqComment(this, Keys.COMMENT_REACTION__COMMENT_REACTION_REACTION_COMMENT_UUID_FKEY);

        return _commentReactionReactionCommentUuidFkey;
    }

    @Override
    public JooqCommentReaction as(String alias) {
        return new JooqCommentReaction(DSL.name(alias), this);
    }

    @Override
    public JooqCommentReaction as(Name alias) {
        return new JooqCommentReaction(alias, this);
    }

    @Override
    public JooqCommentReaction as(Table<?> alias) {
        return new JooqCommentReaction(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqCommentReaction rename(String name) {
        return new JooqCommentReaction(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqCommentReaction rename(Name name) {
        return new JooqCommentReaction(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqCommentReaction rename(Table<?> name) {
        return new JooqCommentReaction(name.getQualifiedName(), null);
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
