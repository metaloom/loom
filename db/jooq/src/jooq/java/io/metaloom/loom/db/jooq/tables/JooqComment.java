/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.JooqPublic;
import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.tables.records.JooqCommentRecord;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function7;
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
 * Stores comments on tasks, annotations..
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqComment extends TableImpl<JooqCommentRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.comment</code>
     */
    public static final JooqComment COMMENT = new JooqComment();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JooqCommentRecord> getRecordType() {
        return JooqCommentRecord.class;
    }

    /**
     * The column <code>public.comment.uuid</code>.
     */
    public final TableField<JooqCommentRecord, java.util.UUID> UUID = createField(DSL.name("uuid"), SQLDataType.UUID.nullable(false).defaultValue(DSL.field("uuid_generate_v4()", SQLDataType.UUID)), this, "");

    /**
     * The column <code>public.comment.title</code>. Comment title
     */
    public final TableField<JooqCommentRecord, String> TITLE = createField(DSL.name("title"), SQLDataType.VARCHAR, this, "Comment title");

    /**
     * The column <code>public.comment.content</code>. Comment text
     */
    public final TableField<JooqCommentRecord, String> CONTENT = createField(DSL.name("content"), SQLDataType.VARCHAR.nullable(false), this, "Comment text");

    /**
     * The column <code>public.comment.user_uuid</code>.
     */
    public final TableField<JooqCommentRecord, java.util.UUID> USER_UUID = createField(DSL.name("user_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.comment.created</code>. Creation timestamp
     */
    public final TableField<JooqCommentRecord, String> CREATED = createField(DSL.name("created"), SQLDataType.VARCHAR.nullable(false), this, "Creation timestamp");

    /**
     * The column <code>public.comment.edited</code>. Edit timestamp
     */
    public final TableField<JooqCommentRecord, String> EDITED = createField(DSL.name("edited"), SQLDataType.VARCHAR, this, "Edit timestamp");

    /**
     * The column <code>public.comment.parent_uuid</code>.
     */
    public final TableField<JooqCommentRecord, java.util.UUID> PARENT_UUID = createField(DSL.name("parent_uuid"), SQLDataType.UUID, this, "");

    private JooqComment(Name alias, Table<JooqCommentRecord> aliased) {
        this(alias, aliased, null);
    }

    private JooqComment(Name alias, Table<JooqCommentRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Stores comments on tasks, annotations.."), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.comment</code> table reference
     */
    public JooqComment(String alias) {
        this(DSL.name(alias), COMMENT);
    }

    /**
     * Create an aliased <code>public.comment</code> table reference
     */
    public JooqComment(Name alias) {
        this(alias, COMMENT);
    }

    /**
     * Create a <code>public.comment</code> table reference
     */
    public JooqComment() {
        this(DSL.name("comment"), null);
    }

    public <O extends Record> JooqComment(Table<O> child, ForeignKey<O, JooqCommentRecord> key) {
        super(child, key, COMMENT);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : JooqPublic.PUBLIC;
    }

    @Override
    public UniqueKey<JooqCommentRecord> getPrimaryKey() {
        return Keys.COMMENT_PKEY;
    }

    @Override
    public List<ForeignKey<JooqCommentRecord, ?>> getReferences() {
        return Arrays.asList(Keys.COMMENT__COMMENT_USER_UUID_FKEY, Keys.COMMENT__COMMENT_PARENT_UUID_FKEY);
    }

    private transient JooqUser _user;
    private transient JooqComment _comment;

    /**
     * Get the implicit join path to the <code>public.user</code> table.
     */
    public JooqUser user() {
        if (_user == null)
            _user = new JooqUser(this, Keys.COMMENT__COMMENT_USER_UUID_FKEY);

        return _user;
    }

    /**
     * Get the implicit join path to the <code>public.comment</code> table.
     */
    public JooqComment comment() {
        if (_comment == null)
            _comment = new JooqComment(this, Keys.COMMENT__COMMENT_PARENT_UUID_FKEY);

        return _comment;
    }

    @Override
    public JooqComment as(String alias) {
        return new JooqComment(DSL.name(alias), this);
    }

    @Override
    public JooqComment as(Name alias) {
        return new JooqComment(alias, this);
    }

    @Override
    public JooqComment as(Table<?> alias) {
        return new JooqComment(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqComment rename(String name) {
        return new JooqComment(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqComment rename(Name name) {
        return new JooqComment(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqComment rename(Table<?> name) {
        return new JooqComment(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<java.util.UUID, String, String, java.util.UUID, String, String, java.util.UUID> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function7<? super java.util.UUID, ? super String, ? super String, ? super java.util.UUID, ? super String, ? super String, ? super java.util.UUID, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function7<? super java.util.UUID, ? super String, ? super String, ? super java.util.UUID, ? super String, ? super String, ? super java.util.UUID, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
