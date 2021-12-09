/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.Public;
import io.metaloom.loom.db.jooq.enums.LoomEvents;
import io.metaloom.loom.db.jooq.tables.records.WebhooksRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.JSONB;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row11;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * Table which stores the registered webhooks
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Webhooks extends TableImpl<WebhooksRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.webhooks</code>
     */
    public static final Webhooks WEBHOOKS = new Webhooks();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<WebhooksRecord> getRecordType() {
        return WebhooksRecord.class;
    }

    /**
     * The column <code>public.webhooks.uuid</code>.
     */
    public final TableField<WebhooksRecord, java.util.UUID> UUID = createField(DSL.name("uuid"), SQLDataType.UUID.nullable(false).defaultValue(DSL.field("uuid_generate_v4()", SQLDataType.UUID)), this, "");

    /**
     * The column <code>public.webhooks.url</code>.
     */
    public final TableField<WebhooksRecord, String> URL = createField(DSL.name("url"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.webhooks.status</code>.
     */
    public final TableField<WebhooksRecord, String> STATUS = createField(DSL.name("status"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.webhooks.active</code>.
     */
    public final TableField<WebhooksRecord, Boolean> ACTIVE = createField(DSL.name("active"), SQLDataType.BOOLEAN.nullable(false).defaultValue(DSL.field("true", SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>public.webhooks.triggers</code>. List of triggers which
     * can invoke the webhook
     */
    public final TableField<WebhooksRecord, LoomEvents> TRIGGERS = createField(DSL.name("triggers"), SQLDataType.VARCHAR.asEnumDataType(io.metaloom.loom.db.jooq.enums.LoomEvents.class), this, "List of triggers which can invoke the webhook");

    /**
     * The column <code>public.webhooks.secretToken</code>. Secret token which
     * webhook services can use to authenticate the request.
     */
    public final TableField<WebhooksRecord, String> SECRETTOKEN = createField(DSL.name("secretToken"), SQLDataType.VARCHAR, this, "Secret token which webhook services can use to authenticate the request.");

    /**
     * The column <code>public.webhooks.meta</code>. Custom meta properties to
     * the element
     */
    public final TableField<WebhooksRecord, JSONB> META = createField(DSL.name("meta"), SQLDataType.JSONB, this, "Custom meta properties to the element");

    /**
     * The column <code>public.webhooks.created</code>.
     */
    public final TableField<WebhooksRecord, LocalDateTime> CREATED = createField(DSL.name("created"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.webhooks.creator_uuid</code>.
     */
    public final TableField<WebhooksRecord, java.util.UUID> CREATOR_UUID = createField(DSL.name("creator_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.webhooks.edited</code>.
     */
    public final TableField<WebhooksRecord, LocalDateTime> EDITED = createField(DSL.name("edited"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.webhooks.editor_uuid</code>.
     */
    public final TableField<WebhooksRecord, java.util.UUID> EDITOR_UUID = createField(DSL.name("editor_uuid"), SQLDataType.UUID, this, "");

    private Webhooks(Name alias, Table<WebhooksRecord> aliased) {
        this(alias, aliased, null);
    }

    private Webhooks(Name alias, Table<WebhooksRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Table which stores the registered webhooks"), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.webhooks</code> table reference
     */
    public Webhooks(String alias) {
        this(DSL.name(alias), WEBHOOKS);
    }

    /**
     * Create an aliased <code>public.webhooks</code> table reference
     */
    public Webhooks(Name alias) {
        this(alias, WEBHOOKS);
    }

    /**
     * Create a <code>public.webhooks</code> table reference
     */
    public Webhooks() {
        this(DSL.name("webhooks"), null);
    }

    public <O extends Record> Webhooks(Table<O> child, ForeignKey<O, WebhooksRecord> key) {
        super(child, key, WEBHOOKS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<WebhooksRecord> getPrimaryKey() {
        return Keys.WEBHOOKS_PKEY;
    }

    @Override
    public List<ForeignKey<WebhooksRecord, ?>> getReferences() {
        return Arrays.asList(Keys.WEBHOOKS__WEBHOOKS_CREATOR_UUID_FKEY, Keys.WEBHOOKS__WEBHOOKS_EDITOR_UUID_FKEY);
    }

    private transient Users _webhooksCreatorUuidFkey;
    private transient Users _webhooksEditorUuidFkey;

    public Users webhooksCreatorUuidFkey() {
        if (_webhooksCreatorUuidFkey == null)
            _webhooksCreatorUuidFkey = new Users(this, Keys.WEBHOOKS__WEBHOOKS_CREATOR_UUID_FKEY);

        return _webhooksCreatorUuidFkey;
    }

    public Users webhooksEditorUuidFkey() {
        if (_webhooksEditorUuidFkey == null)
            _webhooksEditorUuidFkey = new Users(this, Keys.WEBHOOKS__WEBHOOKS_EDITOR_UUID_FKEY);

        return _webhooksEditorUuidFkey;
    }

    @Override
    public Webhooks as(String alias) {
        return new Webhooks(DSL.name(alias), this);
    }

    @Override
    public Webhooks as(Name alias) {
        return new Webhooks(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Webhooks rename(String name) {
        return new Webhooks(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Webhooks rename(Name name) {
        return new Webhooks(name, null);
    }

    // -------------------------------------------------------------------------
    // Row11 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row11<java.util.UUID, String, String, Boolean, LoomEvents, String, JSONB, LocalDateTime, java.util.UUID, LocalDateTime, java.util.UUID> fieldsRow() {
        return (Row11) super.fieldsRow();
    }
}
