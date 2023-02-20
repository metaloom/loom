/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.Public;
import io.metaloom.loom.db.jooq.enums.LoomEvent;
import io.metaloom.loom.db.jooq.tables.records.WebhookRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function11;
import org.jooq.JSONB;
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
 * Table which stores the registered webhooks
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Webhook extends TableImpl<WebhookRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.webhook</code>
     */
    public static final Webhook WEBHOOK = new Webhook();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<WebhookRecord> getRecordType() {
        return WebhookRecord.class;
    }

    /**
     * The column <code>public.webhook.uuid</code>.
     */
    public final TableField<WebhookRecord, java.util.UUID> UUID = createField(DSL.name("uuid"), SQLDataType.UUID.nullable(false).defaultValue(DSL.field("uuid_generate_v4()", SQLDataType.UUID)), this, "");

    /**
     * The column <code>public.webhook.url</code>.
     */
    public final TableField<WebhookRecord, String> URL = createField(DSL.name("url"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.webhook.status</code>.
     */
    public final TableField<WebhookRecord, String> STATUS = createField(DSL.name("status"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.webhook.active</code>.
     */
    public final TableField<WebhookRecord, Boolean> ACTIVE = createField(DSL.name("active"), SQLDataType.BOOLEAN.nullable(false).defaultValue(DSL.field("true", SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>public.webhook.trigger</code>. List of triggers which
     * can invoke the webhook
     */
    public final TableField<WebhookRecord, LoomEvent> TRIGGER = createField(DSL.name("trigger"), SQLDataType.VARCHAR.asEnumDataType(io.metaloom.loom.db.jooq.enums.LoomEvent.class), this, "List of triggers which can invoke the webhook");

    /**
     * The column <code>public.webhook.secretToken</code>. Secret token which
     * webhook services can use to authenticate the request.
     */
    public final TableField<WebhookRecord, String> SECRETTOKEN = createField(DSL.name("secretToken"), SQLDataType.VARCHAR, this, "Secret token which webhook services can use to authenticate the request.");

    /**
     * The column <code>public.webhook.meta</code>. Custom meta properties to
     * the element
     */
    public final TableField<WebhookRecord, JSONB> META = createField(DSL.name("meta"), SQLDataType.JSONB, this, "Custom meta properties to the element");

    /**
     * The column <code>public.webhook.created</code>.
     */
    public final TableField<WebhookRecord, LocalDateTime> CREATED = createField(DSL.name("created"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.webhook.creator_uuid</code>.
     */
    public final TableField<WebhookRecord, java.util.UUID> CREATOR_UUID = createField(DSL.name("creator_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.webhook.edited</code>.
     */
    public final TableField<WebhookRecord, LocalDateTime> EDITED = createField(DSL.name("edited"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.webhook.editor_uuid</code>.
     */
    public final TableField<WebhookRecord, java.util.UUID> EDITOR_UUID = createField(DSL.name("editor_uuid"), SQLDataType.UUID, this, "");

    private Webhook(Name alias, Table<WebhookRecord> aliased) {
        this(alias, aliased, null);
    }

    private Webhook(Name alias, Table<WebhookRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Table which stores the registered webhooks"), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.webhook</code> table reference
     */
    public Webhook(String alias) {
        this(DSL.name(alias), WEBHOOK);
    }

    /**
     * Create an aliased <code>public.webhook</code> table reference
     */
    public Webhook(Name alias) {
        this(alias, WEBHOOK);
    }

    /**
     * Create a <code>public.webhook</code> table reference
     */
    public Webhook() {
        this(DSL.name("webhook"), null);
    }

    public <O extends Record> Webhook(Table<O> child, ForeignKey<O, WebhookRecord> key) {
        super(child, key, WEBHOOK);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<WebhookRecord> getPrimaryKey() {
        return Keys.WEBHOOK_PKEY;
    }

    @Override
    public List<ForeignKey<WebhookRecord, ?>> getReferences() {
        return Arrays.asList(Keys.WEBHOOK__WEBHOOK_CREATOR_UUID_FKEY, Keys.WEBHOOK__WEBHOOK_EDITOR_UUID_FKEY);
    }

    private transient User _webhookCreatorUuidFkey;
    private transient User _webhookEditorUuidFkey;

    /**
     * Get the implicit join path to the <code>public.user</code> table, via the
     * <code>webhook_creator_uuid_fkey</code> key.
     */
    public User webhookCreatorUuidFkey() {
        if (_webhookCreatorUuidFkey == null)
            _webhookCreatorUuidFkey = new User(this, Keys.WEBHOOK__WEBHOOK_CREATOR_UUID_FKEY);

        return _webhookCreatorUuidFkey;
    }

    /**
     * Get the implicit join path to the <code>public.user</code> table, via the
     * <code>webhook_editor_uuid_fkey</code> key.
     */
    public User webhookEditorUuidFkey() {
        if (_webhookEditorUuidFkey == null)
            _webhookEditorUuidFkey = new User(this, Keys.WEBHOOK__WEBHOOK_EDITOR_UUID_FKEY);

        return _webhookEditorUuidFkey;
    }

    @Override
    public Webhook as(String alias) {
        return new Webhook(DSL.name(alias), this);
    }

    @Override
    public Webhook as(Name alias) {
        return new Webhook(alias, this);
    }

    @Override
    public Webhook as(Table<?> alias) {
        return new Webhook(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Webhook rename(String name) {
        return new Webhook(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Webhook rename(Name name) {
        return new Webhook(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Webhook rename(Table<?> name) {
        return new Webhook(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row11 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row11<java.util.UUID, String, String, Boolean, LoomEvent, String, JSONB, LocalDateTime, java.util.UUID, LocalDateTime, java.util.UUID> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function11<? super java.util.UUID, ? super String, ? super String, ? super Boolean, ? super LoomEvent, ? super String, ? super JSONB, ? super LocalDateTime, ? super java.util.UUID, ? super LocalDateTime, ? super java.util.UUID, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function11<? super java.util.UUID, ? super String, ? super String, ? super Boolean, ? super LoomEvent, ? super String, ? super JSONB, ? super LocalDateTime, ? super java.util.UUID, ? super LocalDateTime, ? super java.util.UUID, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
