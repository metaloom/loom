/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq;


import io.metaloom.loom.db.jooq.tables.Asset;
import io.metaloom.loom.db.jooq.tables.AssetBinary;
import io.metaloom.loom.db.jooq.tables.AssetTimeline;
import io.metaloom.loom.db.jooq.tables.AssetTimelineTag;
import io.metaloom.loom.db.jooq.tables.AssetUserMeta;
import io.metaloom.loom.db.jooq.tables.Content;
import io.metaloom.loom.db.jooq.tables.ContentUserMeta;
import io.metaloom.loom.db.jooq.tables.Extension;
import io.metaloom.loom.db.jooq.tables.Field;
import io.metaloom.loom.db.jooq.tables.FieldAsset;
import io.metaloom.loom.db.jooq.tables.FieldContent;
import io.metaloom.loom.db.jooq.tables.FieldReference;
import io.metaloom.loom.db.jooq.tables.Group;
import io.metaloom.loom.db.jooq.tables.Language;
import io.metaloom.loom.db.jooq.tables.Loom;
import io.metaloom.loom.db.jooq.tables.Model;
import io.metaloom.loom.db.jooq.tables.ModelVersion;
import io.metaloom.loom.db.jooq.tables.Namespace;
import io.metaloom.loom.db.jooq.tables.Role;
import io.metaloom.loom.db.jooq.tables.RoleGroup;
import io.metaloom.loom.db.jooq.tables.RolePermission;
import io.metaloom.loom.db.jooq.tables.Tag;
import io.metaloom.loom.db.jooq.tables.TagContent;
import io.metaloom.loom.db.jooq.tables.TagNamespace;
import io.metaloom.loom.db.jooq.tables.TagUserMeta;
import io.metaloom.loom.db.jooq.tables.User;
import io.metaloom.loom.db.jooq.tables.UserGroup;
import io.metaloom.loom.db.jooq.tables.UserToken;
import io.metaloom.loom.db.jooq.tables.Webhook;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.asset</code>.
     */
    public final Asset ASSET = Asset.ASSET;

    /**
     * This table stores the immutable asset information
     */
    public final AssetBinary ASSET_BINARY = AssetBinary.ASSET_BINARY;

    /**
     * This table contains asset timeline entries
     */
    public final AssetTimeline ASSET_TIMELINE = AssetTimeline.ASSET_TIMELINE;

    /**
     * The table <code>public.asset_timeline_tag</code>.
     */
    public final AssetTimelineTag ASSET_TIMELINE_TAG = AssetTimelineTag.ASSET_TIMELINE_TAG;

    /**
     * The table <code>public.asset_user_meta</code>.
     */
    public final AssetUserMeta ASSET_USER_META = AssetUserMeta.ASSET_USER_META;

    /**
     * The table <code>public.content</code>.
     */
    public final Content CONTENT = Content.CONTENT;

    /**
     * The table <code>public.content_user_meta</code>.
     */
    public final ContentUserMeta CONTENT_USER_META = ContentUserMeta.CONTENT_USER_META;

    /**
     * Table which lists the registered extensions
     */
    public final Extension EXTENSION = Extension.EXTENSION;

    /**
     * Table which stores the actual fields content as JSON
     */
    public final Field FIELD = Field.FIELD;

    /**
     * Crosstable which tracks the used assets in a fields record
     */
    public final FieldAsset FIELD_ASSET = FieldAsset.FIELD_ASSET;

    /**
     * Crosstable that tracks all fields for a content
     */
    public final FieldContent FIELD_CONTENT = FieldContent.FIELD_CONTENT;

    /**
     * This table is mainly used to lookup foreign references to contents
     */
    public final FieldReference FIELD_REFERENCE = FieldReference.FIELD_REFERENCE;

    /**
     * The table <code>public.group</code>.
     */
    public final Group GROUP = Group.GROUP;

    /**
     * Table which stores the languages for loom
     */
    public final Language LANGUAGE = Language.LANGUAGE;

    /**
     * The table <code>public.loom</code>.
     */
    public final Loom LOOM = Loom.LOOM;

    /**
     * The table <code>public.model</code>.
     */
    public final Model MODEL = Model.MODEL;

    /**
     * The table <code>public.model_version</code>.
     */
    public final ModelVersion MODEL_VERSION = ModelVersion.MODEL_VERSION;

    /**
     * The table <code>public.namespace</code>.
     */
    public final Namespace NAMESPACE = Namespace.NAMESPACE;

    /**
     * The table <code>public.role</code>.
     */
    public final Role ROLE = Role.ROLE;

    /**
     * The table <code>public.role_group</code>.
     */
    public final RoleGroup ROLE_GROUP = RoleGroup.ROLE_GROUP;

    /**
     * The table <code>public.role_permission</code>.
     */
    public final RolePermission ROLE_PERMISSION = RolePermission.ROLE_PERMISSION;

    /**
     * The table <code>public.tag</code>.
     */
    public final Tag TAG = Tag.TAG;

    /**
     * The table <code>public.tag_content</code>.
     */
    public final TagContent TAG_CONTENT = TagContent.TAG_CONTENT;

    /**
     * Table used to taggings on namespaces
     */
    public final TagNamespace TAG_NAMESPACE = TagNamespace.TAG_NAMESPACE;

    /**
     * The table <code>public.tag_user_meta</code>.
     */
    public final TagUserMeta TAG_USER_META = TagUserMeta.TAG_USER_META;

    /**
     * The table <code>public.user</code>.
     */
    public final User USER = User.USER;

    /**
     * The table <code>public.user_group</code>.
     */
    public final UserGroup USER_GROUP = UserGroup.USER_GROUP;

    /**
     * The table <code>public.user_token</code>.
     */
    public final UserToken USER_TOKEN = UserToken.USER_TOKEN;

    /**
     * Table which stores the registered webhooks
     */
    public final Webhook WEBHOOK = Webhook.WEBHOOK;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            Asset.ASSET,
            AssetBinary.ASSET_BINARY,
            AssetTimeline.ASSET_TIMELINE,
            AssetTimelineTag.ASSET_TIMELINE_TAG,
            AssetUserMeta.ASSET_USER_META,
            Content.CONTENT,
            ContentUserMeta.CONTENT_USER_META,
            Extension.EXTENSION,
            Field.FIELD,
            FieldAsset.FIELD_ASSET,
            FieldContent.FIELD_CONTENT,
            FieldReference.FIELD_REFERENCE,
            Group.GROUP,
            Language.LANGUAGE,
            Loom.LOOM,
            Model.MODEL,
            ModelVersion.MODEL_VERSION,
            Namespace.NAMESPACE,
            Role.ROLE,
            RoleGroup.ROLE_GROUP,
            RolePermission.ROLE_PERMISSION,
            Tag.TAG,
            TagContent.TAG_CONTENT,
            TagNamespace.TAG_NAMESPACE,
            TagUserMeta.TAG_USER_META,
            User.USER,
            UserGroup.USER_GROUP,
            UserToken.USER_TOKEN,
            Webhook.WEBHOOK);
    }
}
