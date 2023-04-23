/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.JooqPublic;
import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.enums.JooqLoomExtensionType;
import io.metaloom.loom.db.jooq.tables.records.JooqExtensionRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function9;
import org.jooq.JSONB;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row9;
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
 * Table which lists the registered extensions
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqExtension extends TableImpl<JooqExtensionRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.extension</code>
     */
    public static final JooqExtension EXTENSION = new JooqExtension();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JooqExtensionRecord> getRecordType() {
        return JooqExtensionRecord.class;
    }

    /**
     * The column <code>public.extension.uuid</code>.
     */
    public final TableField<JooqExtensionRecord, java.util.UUID> UUID = createField(DSL.name("uuid"), SQLDataType.UUID.nullable(false).defaultValue(DSL.field("uuid_generate_v4()", SQLDataType.UUID)), this, "");

    /**
     * The column <code>public.extension.url</code>.
     */
    public final TableField<JooqExtensionRecord, String> URL = createField(DSL.name("url"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.extension.kind</code>. Defines the type of the
     * extension service
     */
    public final TableField<JooqExtensionRecord, JooqLoomExtensionType> KIND = createField(DSL.name("kind"), SQLDataType.VARCHAR.asEnumDataType(io.metaloom.loom.db.jooq.enums.JooqLoomExtensionType.class), this, "Defines the type of the extension service");

    /**
     * The column <code>public.extension.status</code>.
     */
    public final TableField<JooqExtensionRecord, String> STATUS = createField(DSL.name("status"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.extension.meta</code>. Custom meta properties to
     * the element
     */
    public final TableField<JooqExtensionRecord, JSONB> META = createField(DSL.name("meta"), SQLDataType.JSONB, this, "Custom meta properties to the element");

    /**
     * The column <code>public.extension.created</code>.
     */
    public final TableField<JooqExtensionRecord, LocalDateTime> CREATED = createField(DSL.name("created"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.extension.creator_uuid</code>.
     */
    public final TableField<JooqExtensionRecord, java.util.UUID> CREATOR_UUID = createField(DSL.name("creator_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.extension.edited</code>.
     */
    public final TableField<JooqExtensionRecord, LocalDateTime> EDITED = createField(DSL.name("edited"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.extension.editor_uuid</code>.
     */
    public final TableField<JooqExtensionRecord, java.util.UUID> EDITOR_UUID = createField(DSL.name("editor_uuid"), SQLDataType.UUID, this, "");

    private JooqExtension(Name alias, Table<JooqExtensionRecord> aliased) {
        this(alias, aliased, null);
    }

    private JooqExtension(Name alias, Table<JooqExtensionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Table which lists the registered extensions"), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.extension</code> table reference
     */
    public JooqExtension(String alias) {
        this(DSL.name(alias), EXTENSION);
    }

    /**
     * Create an aliased <code>public.extension</code> table reference
     */
    public JooqExtension(Name alias) {
        this(alias, EXTENSION);
    }

    /**
     * Create a <code>public.extension</code> table reference
     */
    public JooqExtension() {
        this(DSL.name("extension"), null);
    }

    public <O extends Record> JooqExtension(Table<O> child, ForeignKey<O, JooqExtensionRecord> key) {
        super(child, key, EXTENSION);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : JooqPublic.PUBLIC;
    }

    @Override
    public UniqueKey<JooqExtensionRecord> getPrimaryKey() {
        return Keys.EXTENSION_PKEY;
    }

    @Override
    public List<ForeignKey<JooqExtensionRecord, ?>> getReferences() {
        return Arrays.asList(Keys.EXTENSION__EXTENSION_CREATOR_UUID_FKEY, Keys.EXTENSION__EXTENSION_EDITOR_UUID_FKEY);
    }

    private transient JooqUser _extensionCreatorUuidFkey;
    private transient JooqUser _extensionEditorUuidFkey;

    /**
     * Get the implicit join path to the <code>public.user</code> table, via the
     * <code>extension_creator_uuid_fkey</code> key.
     */
    public JooqUser extensionCreatorUuidFkey() {
        if (_extensionCreatorUuidFkey == null)
            _extensionCreatorUuidFkey = new JooqUser(this, Keys.EXTENSION__EXTENSION_CREATOR_UUID_FKEY);

        return _extensionCreatorUuidFkey;
    }

    /**
     * Get the implicit join path to the <code>public.user</code> table, via the
     * <code>extension_editor_uuid_fkey</code> key.
     */
    public JooqUser extensionEditorUuidFkey() {
        if (_extensionEditorUuidFkey == null)
            _extensionEditorUuidFkey = new JooqUser(this, Keys.EXTENSION__EXTENSION_EDITOR_UUID_FKEY);

        return _extensionEditorUuidFkey;
    }

    @Override
    public JooqExtension as(String alias) {
        return new JooqExtension(DSL.name(alias), this);
    }

    @Override
    public JooqExtension as(Name alias) {
        return new JooqExtension(alias, this);
    }

    @Override
    public JooqExtension as(Table<?> alias) {
        return new JooqExtension(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqExtension rename(String name) {
        return new JooqExtension(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqExtension rename(Name name) {
        return new JooqExtension(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqExtension rename(Table<?> name) {
        return new JooqExtension(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<java.util.UUID, String, JooqLoomExtensionType, String, JSONB, LocalDateTime, java.util.UUID, LocalDateTime, java.util.UUID> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function9<? super java.util.UUID, ? super String, ? super JooqLoomExtensionType, ? super String, ? super JSONB, ? super LocalDateTime, ? super java.util.UUID, ? super LocalDateTime, ? super java.util.UUID, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function9<? super java.util.UUID, ? super String, ? super JooqLoomExtensionType, ? super String, ? super JSONB, ? super LocalDateTime, ? super java.util.UUID, ? super LocalDateTime, ? super java.util.UUID, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
