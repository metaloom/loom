/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.Indexes;
import io.metaloom.loom.db.jooq.JooqPublic;
import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.converter.JsonObjectConverter;
import io.metaloom.loom.db.jooq.tables.records.JooqEmbeddingRecord;
import io.vertx.core.json.JsonObject;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function16;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row16;
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
 * Embedding information which was extracted from an asset.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqEmbedding extends TableImpl<JooqEmbeddingRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.embedding</code>
     */
    public static final JooqEmbedding EMBEDDING = new JooqEmbedding();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JooqEmbeddingRecord> getRecordType() {
        return JooqEmbeddingRecord.class;
    }

    /**
     * The column <code>public.embedding.uuid</code>.
     */
    public final TableField<JooqEmbeddingRecord, java.util.UUID> UUID = createField(DSL.name("uuid"), SQLDataType.UUID.nullable(false).defaultValue(DSL.field("uuid_generate_v4()", SQLDataType.UUID)), this, "");

    /**
     * The column <code>public.embedding.meta</code>. Custom meta properties to
     * the embedding.
     */
    public final TableField<JooqEmbeddingRecord, JsonObject> META = createField(DSL.name("meta"), SQLDataType.JSONB, this, "Custom meta properties to the embedding.", new JsonObjectConverter());

    /**
     * The column <code>public.embedding.source</code>. Additional source
     * information (e.g. face number by dlib)
     */
    public final TableField<JooqEmbeddingRecord, String> SOURCE = createField(DSL.name("source"), SQLDataType.VARCHAR, this, "Additional source information (e.g. face number by dlib)");

    /**
     * The column <code>public.embedding.frame</code>. Source frame where the
     * face has been detected.
     */
    public final TableField<JooqEmbeddingRecord, Integer> FRAME = createField(DSL.name("frame"), SQLDataType.INTEGER, this, "Source frame where the face has been detected.");

    /**
     * The column <code>public.embedding.areaHeight</code>. Area info where the
     * face has been detected.
     */
    public final TableField<JooqEmbeddingRecord, Integer> AREAHEIGHT = createField(DSL.name("areaHeight"), SQLDataType.INTEGER, this, "Area info where the face has been detected.");

    /**
     * The column <code>public.embedding.areaWidth</code>. Area info where the
     * face has been detected.
     */
    public final TableField<JooqEmbeddingRecord, Integer> AREAWIDTH = createField(DSL.name("areaWidth"), SQLDataType.INTEGER, this, "Area info where the face has been detected.");

    /**
     * The column <code>public.embedding.areaStartX</code>. Area info where the
     * face has been detected.
     */
    public final TableField<JooqEmbeddingRecord, Integer> AREASTARTX = createField(DSL.name("areaStartX"), SQLDataType.INTEGER, this, "Area info where the face has been detected.");

    /**
     * The column <code>public.embedding.areaStartY</code>. Area info where the
     * face has been detected.
     */
    public final TableField<JooqEmbeddingRecord, Integer> AREASTARTY = createField(DSL.name("areaStartY"), SQLDataType.INTEGER, this, "Area info where the face has been detected.");

    /**
     * The column <code>public.embedding.data</code>. Actual embedding data
     */
    public final TableField<JooqEmbeddingRecord, Float[]> DATA = createField(DSL.name("data"), SQLDataType.REAL.getArrayDataType(), this, "Actual embedding data");

    /**
     * The column <code>public.embedding.id</code>.
     */
    public final TableField<JooqEmbeddingRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.embedding.type</code>. Type of the embedding
     * (e.g. dlib_facemark)
     */
    public final TableField<JooqEmbeddingRecord, String> TYPE = createField(DSL.name("type"), SQLDataType.VARCHAR.nullable(false), this, "Type of the embedding (e.g. dlib_facemark)");

    /**
     * The column <code>public.embedding.created</code>.
     */
    public final TableField<JooqEmbeddingRecord, LocalDateTime> CREATED = createField(DSL.name("created"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.embedding.creator_uuid</code>.
     */
    public final TableField<JooqEmbeddingRecord, java.util.UUID> CREATOR_UUID = createField(DSL.name("creator_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.embedding.edited</code>.
     */
    public final TableField<JooqEmbeddingRecord, LocalDateTime> EDITED = createField(DSL.name("edited"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.embedding.editor_uuid</code>.
     */
    public final TableField<JooqEmbeddingRecord, java.util.UUID> EDITOR_UUID = createField(DSL.name("editor_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.embedding.asset_uuid</code>.
     */
    public final TableField<JooqEmbeddingRecord, java.util.UUID> ASSET_UUID = createField(DSL.name("asset_uuid"), SQLDataType.UUID.nullable(false), this, "");

    private JooqEmbedding(Name alias, Table<JooqEmbeddingRecord> aliased) {
        this(alias, aliased, null);
    }

    private JooqEmbedding(Name alias, Table<JooqEmbeddingRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Embedding information which was extracted from an asset."), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.embedding</code> table reference
     */
    public JooqEmbedding(String alias) {
        this(DSL.name(alias), EMBEDDING);
    }

    /**
     * Create an aliased <code>public.embedding</code> table reference
     */
    public JooqEmbedding(Name alias) {
        this(alias, EMBEDDING);
    }

    /**
     * Create a <code>public.embedding</code> table reference
     */
    public JooqEmbedding() {
        this(DSL.name("embedding"), null);
    }

    public <O extends Record> JooqEmbedding(Table<O> child, ForeignKey<O, JooqEmbeddingRecord> key) {
        super(child, key, EMBEDDING);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : JooqPublic.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.EMBEDDING_ASSET_UUID_IDX);
    }

    @Override
    public UniqueKey<JooqEmbeddingRecord> getPrimaryKey() {
        return Keys.EMBEDDING_PKEY;
    }

    @Override
    public List<ForeignKey<JooqEmbeddingRecord, ?>> getReferences() {
        return Arrays.asList(Keys.EMBEDDING__EMBEDDING_CREATOR_UUID_FKEY, Keys.EMBEDDING__EMBEDDING_EDITOR_UUID_FKEY);
    }

    private transient JooqUser _embeddingCreatorUuidFkey;
    private transient JooqUser _embeddingEditorUuidFkey;

    /**
     * Get the implicit join path to the <code>public.user</code> table, via the
     * <code>embedding_creator_uuid_fkey</code> key.
     */
    public JooqUser embeddingCreatorUuidFkey() {
        if (_embeddingCreatorUuidFkey == null)
            _embeddingCreatorUuidFkey = new JooqUser(this, Keys.EMBEDDING__EMBEDDING_CREATOR_UUID_FKEY);

        return _embeddingCreatorUuidFkey;
    }

    /**
     * Get the implicit join path to the <code>public.user</code> table, via the
     * <code>embedding_editor_uuid_fkey</code> key.
     */
    public JooqUser embeddingEditorUuidFkey() {
        if (_embeddingEditorUuidFkey == null)
            _embeddingEditorUuidFkey = new JooqUser(this, Keys.EMBEDDING__EMBEDDING_EDITOR_UUID_FKEY);

        return _embeddingEditorUuidFkey;
    }

    @Override
    public JooqEmbedding as(String alias) {
        return new JooqEmbedding(DSL.name(alias), this);
    }

    @Override
    public JooqEmbedding as(Name alias) {
        return new JooqEmbedding(alias, this);
    }

    @Override
    public JooqEmbedding as(Table<?> alias) {
        return new JooqEmbedding(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqEmbedding rename(String name) {
        return new JooqEmbedding(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqEmbedding rename(Name name) {
        return new JooqEmbedding(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqEmbedding rename(Table<?> name) {
        return new JooqEmbedding(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row16 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row16<java.util.UUID, JsonObject, String, Integer, Integer, Integer, Integer, Integer, Float[], Long, String, LocalDateTime, java.util.UUID, LocalDateTime, java.util.UUID, java.util.UUID> fieldsRow() {
        return (Row16) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function16<? super java.util.UUID, ? super JsonObject, ? super String, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Float[], ? super Long, ? super String, ? super LocalDateTime, ? super java.util.UUID, ? super LocalDateTime, ? super java.util.UUID, ? super java.util.UUID, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function16<? super java.util.UUID, ? super JsonObject, ? super String, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Float[], ? super Long, ? super String, ? super LocalDateTime, ? super java.util.UUID, ? super LocalDateTime, ? super java.util.UUID, ? super java.util.UUID, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
