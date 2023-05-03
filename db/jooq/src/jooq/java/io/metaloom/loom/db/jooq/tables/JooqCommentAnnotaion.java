/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.JooqPublic;
import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.tables.records.JooqCommentAnnotaionRecord;

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
public class JooqCommentAnnotaion extends TableImpl<JooqCommentAnnotaionRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.comment_annotaion</code>
     */
    public static final JooqCommentAnnotaion COMMENT_ANNOTAION = new JooqCommentAnnotaion();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JooqCommentAnnotaionRecord> getRecordType() {
        return JooqCommentAnnotaionRecord.class;
    }

    /**
     * The column <code>public.comment_annotaion.comment_uuid</code>.
     */
    public final TableField<JooqCommentAnnotaionRecord, UUID> COMMENT_UUID = createField(DSL.name("comment_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.comment_annotaion.annotation_uuid</code>.
     */
    public final TableField<JooqCommentAnnotaionRecord, UUID> ANNOTATION_UUID = createField(DSL.name("annotation_uuid"), SQLDataType.UUID.nullable(false), this, "");

    private JooqCommentAnnotaion(Name alias, Table<JooqCommentAnnotaionRecord> aliased) {
        this(alias, aliased, null);
    }

    private JooqCommentAnnotaion(Name alias, Table<JooqCommentAnnotaionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.comment_annotaion</code> table reference
     */
    public JooqCommentAnnotaion(String alias) {
        this(DSL.name(alias), COMMENT_ANNOTAION);
    }

    /**
     * Create an aliased <code>public.comment_annotaion</code> table reference
     */
    public JooqCommentAnnotaion(Name alias) {
        this(alias, COMMENT_ANNOTAION);
    }

    /**
     * Create a <code>public.comment_annotaion</code> table reference
     */
    public JooqCommentAnnotaion() {
        this(DSL.name("comment_annotaion"), null);
    }

    public <O extends Record> JooqCommentAnnotaion(Table<O> child, ForeignKey<O, JooqCommentAnnotaionRecord> key) {
        super(child, key, COMMENT_ANNOTAION);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : JooqPublic.PUBLIC;
    }

    @Override
    public UniqueKey<JooqCommentAnnotaionRecord> getPrimaryKey() {
        return Keys.COMMENT_ANNOTAION_PKEY;
    }

    @Override
    public List<ForeignKey<JooqCommentAnnotaionRecord, ?>> getReferences() {
        return Arrays.asList(Keys.COMMENT_ANNOTAION__COMMENT_ANNOTAION_COMMENT_UUID_FKEY, Keys.COMMENT_ANNOTAION__COMMENT_ANNOTAION_ANNOTATION_UUID_FKEY);
    }

    private transient JooqComment _comment;
    private transient JooqAnnotation _annotation;

    /**
     * Get the implicit join path to the <code>public.comment</code> table.
     */
    public JooqComment comment() {
        if (_comment == null)
            _comment = new JooqComment(this, Keys.COMMENT_ANNOTAION__COMMENT_ANNOTAION_COMMENT_UUID_FKEY);

        return _comment;
    }

    /**
     * Get the implicit join path to the <code>public.annotation</code> table.
     */
    public JooqAnnotation annotation() {
        if (_annotation == null)
            _annotation = new JooqAnnotation(this, Keys.COMMENT_ANNOTAION__COMMENT_ANNOTAION_ANNOTATION_UUID_FKEY);

        return _annotation;
    }

    @Override
    public JooqCommentAnnotaion as(String alias) {
        return new JooqCommentAnnotaion(DSL.name(alias), this);
    }

    @Override
    public JooqCommentAnnotaion as(Name alias) {
        return new JooqCommentAnnotaion(alias, this);
    }

    @Override
    public JooqCommentAnnotaion as(Table<?> alias) {
        return new JooqCommentAnnotaion(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqCommentAnnotaion rename(String name) {
        return new JooqCommentAnnotaion(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqCommentAnnotaion rename(Name name) {
        return new JooqCommentAnnotaion(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqCommentAnnotaion rename(Table<?> name) {
        return new JooqCommentAnnotaion(name.getQualifiedName(), null);
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