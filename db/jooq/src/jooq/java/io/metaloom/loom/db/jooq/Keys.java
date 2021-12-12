/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq;


import io.metaloom.loom.db.jooq.tables.Asset;
import io.metaloom.loom.db.jooq.tables.AssetBinarie;
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
import io.metaloom.loom.db.jooq.tables.Model;
import io.metaloom.loom.db.jooq.tables.ModelVersion;
import io.metaloom.loom.db.jooq.tables.Namespace;
import io.metaloom.loom.db.jooq.tables.Role;
import io.metaloom.loom.db.jooq.tables.RoleGroup;
import io.metaloom.loom.db.jooq.tables.RolePermission;
import io.metaloom.loom.db.jooq.tables.SchemaVersion;
import io.metaloom.loom.db.jooq.tables.Tag;
import io.metaloom.loom.db.jooq.tables.TagAsset;
import io.metaloom.loom.db.jooq.tables.TagContent;
import io.metaloom.loom.db.jooq.tables.TagNamespace;
import io.metaloom.loom.db.jooq.tables.TagUserMeta;
import io.metaloom.loom.db.jooq.tables.User;
import io.metaloom.loom.db.jooq.tables.UserGroup;
import io.metaloom.loom.db.jooq.tables.UserToken;
import io.metaloom.loom.db.jooq.tables.Webhook;
import io.metaloom.loom.db.jooq.tables.records.AssetBinarieRecord;
import io.metaloom.loom.db.jooq.tables.records.AssetRecord;
import io.metaloom.loom.db.jooq.tables.records.AssetTimelineRecord;
import io.metaloom.loom.db.jooq.tables.records.AssetTimelineTagRecord;
import io.metaloom.loom.db.jooq.tables.records.AssetUserMetaRecord;
import io.metaloom.loom.db.jooq.tables.records.ContentRecord;
import io.metaloom.loom.db.jooq.tables.records.ContentUserMetaRecord;
import io.metaloom.loom.db.jooq.tables.records.ExtensionRecord;
import io.metaloom.loom.db.jooq.tables.records.FieldAssetRecord;
import io.metaloom.loom.db.jooq.tables.records.FieldContentRecord;
import io.metaloom.loom.db.jooq.tables.records.FieldRecord;
import io.metaloom.loom.db.jooq.tables.records.FieldReferenceRecord;
import io.metaloom.loom.db.jooq.tables.records.GroupRecord;
import io.metaloom.loom.db.jooq.tables.records.LanguageRecord;
import io.metaloom.loom.db.jooq.tables.records.ModelRecord;
import io.metaloom.loom.db.jooq.tables.records.ModelVersionRecord;
import io.metaloom.loom.db.jooq.tables.records.NamespaceRecord;
import io.metaloom.loom.db.jooq.tables.records.RoleGroupRecord;
import io.metaloom.loom.db.jooq.tables.records.RolePermissionRecord;
import io.metaloom.loom.db.jooq.tables.records.RoleRecord;
import io.metaloom.loom.db.jooq.tables.records.SchemaVersionRecord;
import io.metaloom.loom.db.jooq.tables.records.TagAssetRecord;
import io.metaloom.loom.db.jooq.tables.records.TagContentRecord;
import io.metaloom.loom.db.jooq.tables.records.TagNamespaceRecord;
import io.metaloom.loom.db.jooq.tables.records.TagRecord;
import io.metaloom.loom.db.jooq.tables.records.TagUserMetaRecord;
import io.metaloom.loom.db.jooq.tables.records.UserGroupRecord;
import io.metaloom.loom.db.jooq.tables.records.UserRecord;
import io.metaloom.loom.db.jooq.tables.records.UserTokenRecord;
import io.metaloom.loom.db.jooq.tables.records.WebhookRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AssetRecord> ASSET_PKEY = Internal.createUniqueKey(Asset.ASSET, DSL.name("asset_pkey"), new TableField[] { Asset.ASSET.UUID }, true);
    public static final UniqueKey<AssetBinarieRecord> ASSET_BINARIE_PKEY = Internal.createUniqueKey(AssetBinarie.ASSET_BINARIE, DSL.name("asset_binarie_pkey"), new TableField[] { AssetBinarie.ASSET_BINARIE.UUID }, true);
    public static final UniqueKey<AssetTimelineRecord> ASSET_TIMELINE_PKEY = Internal.createUniqueKey(AssetTimeline.ASSET_TIMELINE, DSL.name("asset_timeline_pkey"), new TableField[] { AssetTimeline.ASSET_TIMELINE.UUID }, true);
    public static final UniqueKey<AssetUserMetaRecord> ASSET_USER_META_PKEY = Internal.createUniqueKey(AssetUserMeta.ASSET_USER_META, DSL.name("asset_user_meta_pkey"), new TableField[] { AssetUserMeta.ASSET_USER_META.ASSET_UUID, AssetUserMeta.ASSET_USER_META.USER_UUID }, true);
    public static final UniqueKey<ContentRecord> CONTENT_PKEY = Internal.createUniqueKey(Content.CONTENT, DSL.name("content_pkey"), new TableField[] { Content.CONTENT.UUID }, true);
    public static final UniqueKey<ContentUserMetaRecord> CONTENT_USER_META_PKEY = Internal.createUniqueKey(ContentUserMeta.CONTENT_USER_META, DSL.name("content_user_meta_pkey"), new TableField[] { ContentUserMeta.CONTENT_USER_META.CONTENT_UUID, ContentUserMeta.CONTENT_USER_META.USER_UUID }, true);
    public static final UniqueKey<ExtensionRecord> EXTENSION_PKEY = Internal.createUniqueKey(Extension.EXTENSION, DSL.name("extension_pkey"), new TableField[] { Extension.EXTENSION.UUID }, true);
    public static final UniqueKey<FieldRecord> FIELD_PKEY = Internal.createUniqueKey(Field.FIELD, DSL.name("field_pkey"), new TableField[] { Field.FIELD.UUID }, true);
    public static final UniqueKey<FieldAssetRecord> FIELD_ASSET_PKEY = Internal.createUniqueKey(FieldAsset.FIELD_ASSET, DSL.name("field_asset_pkey"), new TableField[] { FieldAsset.FIELD_ASSET.FIELD_UUID, FieldAsset.FIELD_ASSET.ASSET_UUID }, true);
    public static final UniqueKey<FieldContentRecord> FIELD_CONTENT_WEBROOT_PATH_INFO_KEY = Internal.createUniqueKey(FieldContent.FIELD_CONTENT, DSL.name("field_content_webroot_path_info_key"), new TableField[] { FieldContent.FIELD_CONTENT.WEBROOT_PATH_INFO }, true);
    public static final UniqueKey<FieldReferenceRecord> FIELD_REFERENCE_PKEY = Internal.createUniqueKey(FieldReference.FIELD_REFERENCE, DSL.name("field_reference_pkey"), new TableField[] { FieldReference.FIELD_REFERENCE.SOURCE_UUID, FieldReference.FIELD_REFERENCE.TARGET_UUID }, true);
    public static final UniqueKey<GroupRecord> GROUP_NAME_KEY = Internal.createUniqueKey(Group.GROUP, DSL.name("group_name_key"), new TableField[] { Group.GROUP.NAME }, true);
    public static final UniqueKey<GroupRecord> GROUP_PKEY = Internal.createUniqueKey(Group.GROUP, DSL.name("group_pkey"), new TableField[] { Group.GROUP.UUID }, true);
    public static final UniqueKey<LanguageRecord> LANGUAGE_PKEY = Internal.createUniqueKey(Language.LANGUAGE, DSL.name("language_pkey"), new TableField[] { Language.LANGUAGE.UUID }, true);
    public static final UniqueKey<LanguageRecord> LANGUAGE_TAG_KEY = Internal.createUniqueKey(Language.LANGUAGE, DSL.name("language_tag_key"), new TableField[] { Language.LANGUAGE.TAG }, true);
    public static final UniqueKey<ModelRecord> MODEL_NAME_KEY = Internal.createUniqueKey(Model.MODEL, DSL.name("model_name_key"), new TableField[] { Model.MODEL.NAME }, true);
    public static final UniqueKey<ModelRecord> MODEL_PKEY = Internal.createUniqueKey(Model.MODEL, DSL.name("model_pkey"), new TableField[] { Model.MODEL.UUID }, true);
    public static final UniqueKey<ModelVersionRecord> MODEL_VERSION_PKEY = Internal.createUniqueKey(ModelVersion.MODEL_VERSION, DSL.name("model_version_pkey"), new TableField[] { ModelVersion.MODEL_VERSION.UUID }, true);
    public static final UniqueKey<NamespaceRecord> NAMESPACE_NAME_KEY = Internal.createUniqueKey(Namespace.NAMESPACE, DSL.name("namespace_name_key"), new TableField[] { Namespace.NAMESPACE.NAME }, true);
    public static final UniqueKey<NamespaceRecord> NAMESPACE_PKEY = Internal.createUniqueKey(Namespace.NAMESPACE, DSL.name("namespace_pkey"), new TableField[] { Namespace.NAMESPACE.UUID }, true);
    public static final UniqueKey<RoleRecord> ROLE_NAME_KEY = Internal.createUniqueKey(Role.ROLE, DSL.name("role_name_key"), new TableField[] { Role.ROLE.NAME }, true);
    public static final UniqueKey<RoleRecord> ROLE_PKEY = Internal.createUniqueKey(Role.ROLE, DSL.name("role_pkey"), new TableField[] { Role.ROLE.UUID }, true);
    public static final UniqueKey<RoleGroupRecord> ROLE_GROUP_PKEY = Internal.createUniqueKey(RoleGroup.ROLE_GROUP, DSL.name("role_group_pkey"), new TableField[] { RoleGroup.ROLE_GROUP.GROUP_UUID, RoleGroup.ROLE_GROUP.ROLE_UUID }, true);
    public static final UniqueKey<RolePermissionRecord> ROLE_PERMISSION_PKEY = Internal.createUniqueKey(RolePermission.ROLE_PERMISSION, DSL.name("role_permission_pkey"), new TableField[] { RolePermission.ROLE_PERMISSION.ROLE_UUID, RolePermission.ROLE_PERMISSION.ELEMENT_UUID }, true);
    public static final UniqueKey<SchemaVersionRecord> SCHEMA_VERSION_PK = Internal.createUniqueKey(SchemaVersion.SCHEMA_VERSION, DSL.name("schema_version_pk"), new TableField[] { SchemaVersion.SCHEMA_VERSION.VERSION }, true);
    public static final UniqueKey<TagRecord> TAG_PKEY = Internal.createUniqueKey(Tag.TAG, DSL.name("tag_pkey"), new TableField[] { Tag.TAG.UUID }, true);
    public static final UniqueKey<TagAssetRecord> TAG_ASSET_PKEY = Internal.createUniqueKey(TagAsset.TAG_ASSET, DSL.name("tag_asset_pkey"), new TableField[] { TagAsset.TAG_ASSET.TAG_UUID, TagAsset.TAG_ASSET.ASSET_UUID }, true);
    public static final UniqueKey<TagContentRecord> TAG_CONTENT_PKEY = Internal.createUniqueKey(TagContent.TAG_CONTENT, DSL.name("tag_content_pkey"), new TableField[] { TagContent.TAG_CONTENT.TAG_UUID, TagContent.TAG_CONTENT.CONTENT_UUID }, true);
    public static final UniqueKey<TagNamespaceRecord> TAG_NAMESPACE_PKEY = Internal.createUniqueKey(TagNamespace.TAG_NAMESPACE, DSL.name("tag_namespace_pkey"), new TableField[] { TagNamespace.TAG_NAMESPACE.TAG_UUID, TagNamespace.TAG_NAMESPACE.NAMESPACE_UUID }, true);
    public static final UniqueKey<UserRecord> USER_PKEY = Internal.createUniqueKey(User.USER, DSL.name("user_pkey"), new TableField[] { User.USER.UUID }, true);
    public static final UniqueKey<UserRecord> USER_USERNAME_KEY = Internal.createUniqueKey(User.USER, DSL.name("user_username_key"), new TableField[] { User.USER.USERNAME }, true);
    public static final UniqueKey<UserGroupRecord> USER_GROUP_PKEY = Internal.createUniqueKey(UserGroup.USER_GROUP, DSL.name("user_group_pkey"), new TableField[] { UserGroup.USER_GROUP.USER_UUID, UserGroup.USER_GROUP.GROUP_UUID }, true);
    public static final UniqueKey<UserTokenRecord> USER_TOKEN_PKEY = Internal.createUniqueKey(UserToken.USER_TOKEN, DSL.name("user_token_pkey"), new TableField[] { UserToken.USER_TOKEN.UUID }, true);
    public static final UniqueKey<WebhookRecord> WEBHOOK_PKEY = Internal.createUniqueKey(Webhook.WEBHOOK, DSL.name("webhook_pkey"), new TableField[] { Webhook.WEBHOOK.UUID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<AssetRecord, AssetBinarieRecord> ASSET__ASSET_ASSET_BINARIES_UUID_FKEY = Internal.createForeignKey(Asset.ASSET, DSL.name("asset_asset_binaries_uuid_fkey"), new TableField[] { Asset.ASSET.ASSET_BINARIES_UUID }, Keys.ASSET_BINARIE_PKEY, new TableField[] { AssetBinarie.ASSET_BINARIE.UUID }, true);
    public static final ForeignKey<AssetRecord, UserRecord> ASSET__ASSET_CREATOR_UUID_FKEY = Internal.createForeignKey(Asset.ASSET, DSL.name("asset_creator_uuid_fkey"), new TableField[] { Asset.ASSET.CREATOR_UUID }, Keys.USER_PKEY, new TableField[] { User.USER.UUID }, true);
    public static final ForeignKey<AssetRecord, UserRecord> ASSET__ASSET_EDITOR_UUID_FKEY = Internal.createForeignKey(Asset.ASSET, DSL.name("asset_editor_uuid_fkey"), new TableField[] { Asset.ASSET.EDITOR_UUID }, Keys.USER_PKEY, new TableField[] { User.USER.UUID }, true);
    public static final ForeignKey<AssetRecord, NamespaceRecord> ASSET__ASSET_NAMESPACE_UUID_FKEY = Internal.createForeignKey(Asset.ASSET, DSL.name("asset_namespace_uuid_fkey"), new TableField[] { Asset.ASSET.NAMESPACE_UUID }, Keys.NAMESPACE_PKEY, new TableField[] { Namespace.NAMESPACE.UUID }, true);
    public static final ForeignKey<AssetTimelineRecord, AssetRecord> ASSET_TIMELINE__ASSET_TIMELINE_ASSET_UUID_FKEY = Internal.createForeignKey(AssetTimeline.ASSET_TIMELINE, DSL.name("asset_timeline_asset_uuid_fkey"), new TableField[] { AssetTimeline.ASSET_TIMELINE.ASSET_UUID }, Keys.ASSET_PKEY, new TableField[] { Asset.ASSET.UUID }, true);
    public static final ForeignKey<AssetTimelineTagRecord, AssetTimelineRecord> ASSET_TIMELINE_TAG__ASSET_TIMELINE_TAG_ASSETTIMELINE_UUID_FKEY = Internal.createForeignKey(AssetTimelineTag.ASSET_TIMELINE_TAG, DSL.name("asset_timeline_tag_assettimeline_uuid_fkey"), new TableField[] { AssetTimelineTag.ASSET_TIMELINE_TAG.ASSETTIMELINE_UUID }, Keys.ASSET_TIMELINE_PKEY, new TableField[] { AssetTimeline.ASSET_TIMELINE.UUID }, true);
    public static final ForeignKey<AssetTimelineTagRecord, TagRecord> ASSET_TIMELINE_TAG__ASSET_TIMELINE_TAG_TAG_UUID_FKEY = Internal.createForeignKey(AssetTimelineTag.ASSET_TIMELINE_TAG, DSL.name("asset_timeline_tag_tag_uuid_fkey"), new TableField[] { AssetTimelineTag.ASSET_TIMELINE_TAG.TAG_UUID }, Keys.TAG_PKEY, new TableField[] { Tag.TAG.UUID }, true);
    public static final ForeignKey<AssetUserMetaRecord, AssetRecord> ASSET_USER_META__ASSET_USER_META_ASSET_UUID_FKEY = Internal.createForeignKey(AssetUserMeta.ASSET_USER_META, DSL.name("asset_user_meta_asset_uuid_fkey"), new TableField[] { AssetUserMeta.ASSET_USER_META.ASSET_UUID }, Keys.ASSET_PKEY, new TableField[] { Asset.ASSET.UUID }, true);
    public static final ForeignKey<AssetUserMetaRecord, UserRecord> ASSET_USER_META__ASSET_USER_META_USER_UUID_FKEY = Internal.createForeignKey(AssetUserMeta.ASSET_USER_META, DSL.name("asset_user_meta_user_uuid_fkey"), new TableField[] { AssetUserMeta.ASSET_USER_META.USER_UUID }, Keys.USER_PKEY, new TableField[] { User.USER.UUID }, true);
    public static final ForeignKey<ContentRecord, UserRecord> CONTENT__CONTENT_CREATOR_UUID_FKEY = Internal.createForeignKey(Content.CONTENT, DSL.name("content_creator_uuid_fkey"), new TableField[] { Content.CONTENT.CREATOR_UUID }, Keys.USER_PKEY, new TableField[] { User.USER.UUID }, true);
    public static final ForeignKey<ContentRecord, ModelRecord> CONTENT__CONTENT_MODEL_UUID_FKEY = Internal.createForeignKey(Content.CONTENT, DSL.name("content_model_uuid_fkey"), new TableField[] { Content.CONTENT.MODEL_UUID }, Keys.MODEL_PKEY, new TableField[] { Model.MODEL.UUID }, true);
    public static final ForeignKey<ContentRecord, NamespaceRecord> CONTENT__CONTENT_NAMESPACE_UUID_FKEY = Internal.createForeignKey(Content.CONTENT, DSL.name("content_namespace_uuid_fkey"), new TableField[] { Content.CONTENT.NAMESPACE_UUID }, Keys.NAMESPACE_PKEY, new TableField[] { Namespace.NAMESPACE.UUID }, true);
    public static final ForeignKey<ContentRecord, ContentRecord> CONTENT__CONTENT_PARENT_FKEY = Internal.createForeignKey(Content.CONTENT, DSL.name("content_parent_fkey"), new TableField[] { Content.CONTENT.PARENT }, Keys.CONTENT_PKEY, new TableField[] { Content.CONTENT.UUID }, true);
    public static final ForeignKey<ContentUserMetaRecord, TagRecord> CONTENT_USER_META__CONTENT_USER_META_CONTENT_UUID_FKEY = Internal.createForeignKey(ContentUserMeta.CONTENT_USER_META, DSL.name("content_user_meta_content_uuid_fkey"), new TableField[] { ContentUserMeta.CONTENT_USER_META.CONTENT_UUID }, Keys.TAG_PKEY, new TableField[] { Tag.TAG.UUID }, true);
    public static final ForeignKey<ContentUserMetaRecord, UserRecord> CONTENT_USER_META__CONTENT_USER_META_USER_UUID_FKEY = Internal.createForeignKey(ContentUserMeta.CONTENT_USER_META, DSL.name("content_user_meta_user_uuid_fkey"), new TableField[] { ContentUserMeta.CONTENT_USER_META.USER_UUID }, Keys.USER_PKEY, new TableField[] { User.USER.UUID }, true);
    public static final ForeignKey<ExtensionRecord, UserRecord> EXTENSION__EXTENSION_CREATOR_UUID_FKEY = Internal.createForeignKey(Extension.EXTENSION, DSL.name("extension_creator_uuid_fkey"), new TableField[] { Extension.EXTENSION.CREATOR_UUID }, Keys.USER_PKEY, new TableField[] { User.USER.UUID }, true);
    public static final ForeignKey<ExtensionRecord, UserRecord> EXTENSION__EXTENSION_EDITOR_UUID_FKEY = Internal.createForeignKey(Extension.EXTENSION, DSL.name("extension_editor_uuid_fkey"), new TableField[] { Extension.EXTENSION.EDITOR_UUID }, Keys.USER_PKEY, new TableField[] { User.USER.UUID }, true);
    public static final ForeignKey<FieldRecord, NamespaceRecord> FIELD__FIELD_CONTENT_UUID_FKEY = Internal.createForeignKey(Field.FIELD, DSL.name("field_content_uuid_fkey"), new TableField[] { Field.FIELD.CONTENT_UUID }, Keys.NAMESPACE_PKEY, new TableField[] { Namespace.NAMESPACE.UUID }, true);
    public static final ForeignKey<FieldRecord, UserRecord> FIELD__FIELD_EDITOR_UUID_FKEY = Internal.createForeignKey(Field.FIELD, DSL.name("field_editor_uuid_fkey"), new TableField[] { Field.FIELD.EDITOR_UUID }, Keys.USER_PKEY, new TableField[] { User.USER.UUID }, true);
    public static final ForeignKey<FieldRecord, LanguageRecord> FIELD__FIELD_LANGUAGE_UUID_FKEY = Internal.createForeignKey(Field.FIELD, DSL.name("field_language_uuid_fkey"), new TableField[] { Field.FIELD.LANGUAGE_UUID }, Keys.LANGUAGE_PKEY, new TableField[] { Language.LANGUAGE.UUID }, true);
    public static final ForeignKey<FieldRecord, ModelVersionRecord> FIELD__FIELD_MODELVERSION_UUID_FKEY = Internal.createForeignKey(Field.FIELD, DSL.name("field_modelversion_uuid_fkey"), new TableField[] { Field.FIELD.MODELVERSION_UUID }, Keys.MODEL_VERSION_PKEY, new TableField[] { ModelVersion.MODEL_VERSION.UUID }, true);
    public static final ForeignKey<FieldAssetRecord, AssetRecord> FIELD_ASSET__FIELD_ASSET_ASSET_UUID_FKEY = Internal.createForeignKey(FieldAsset.FIELD_ASSET, DSL.name("field_asset_asset_uuid_fkey"), new TableField[] { FieldAsset.FIELD_ASSET.ASSET_UUID }, Keys.ASSET_PKEY, new TableField[] { Asset.ASSET.UUID }, true);
    public static final ForeignKey<FieldAssetRecord, FieldRecord> FIELD_ASSET__FIELD_ASSET_FIELD_UUID_FKEY = Internal.createForeignKey(FieldAsset.FIELD_ASSET, DSL.name("field_asset_field_uuid_fkey"), new TableField[] { FieldAsset.FIELD_ASSET.FIELD_UUID }, Keys.FIELD_PKEY, new TableField[] { Field.FIELD.UUID }, true);
    public static final ForeignKey<FieldContentRecord, ContentRecord> FIELD_CONTENT__FIELD_CONTENT_CONTENT_UUID_FKEY = Internal.createForeignKey(FieldContent.FIELD_CONTENT, DSL.name("field_content_content_uuid_fkey"), new TableField[] { FieldContent.FIELD_CONTENT.CONTENT_UUID }, Keys.CONTENT_PKEY, new TableField[] { Content.CONTENT.UUID }, true);
    public static final ForeignKey<FieldContentRecord, FieldRecord> FIELD_CONTENT__FIELD_CONTENT_FIELDS_UUID_FKEY = Internal.createForeignKey(FieldContent.FIELD_CONTENT, DSL.name("field_content_fields_uuid_fkey"), new TableField[] { FieldContent.FIELD_CONTENT.FIELDS_UUID }, Keys.FIELD_PKEY, new TableField[] { Field.FIELD.UUID }, true);
    public static final ForeignKey<FieldReferenceRecord, FieldRecord> FIELD_REFERENCE__FIELD_REFERENCE_SOURCE_UUID_FKEY = Internal.createForeignKey(FieldReference.FIELD_REFERENCE, DSL.name("field_reference_source_uuid_fkey"), new TableField[] { FieldReference.FIELD_REFERENCE.SOURCE_UUID }, Keys.FIELD_PKEY, new TableField[] { Field.FIELD.UUID }, true);
    public static final ForeignKey<FieldReferenceRecord, FieldRecord> FIELD_REFERENCE__FIELD_REFERENCE_TARGET_UUID_FKEY = Internal.createForeignKey(FieldReference.FIELD_REFERENCE, DSL.name("field_reference_target_uuid_fkey"), new TableField[] { FieldReference.FIELD_REFERENCE.TARGET_UUID }, Keys.FIELD_PKEY, new TableField[] { Field.FIELD.UUID }, true);
    public static final ForeignKey<GroupRecord, UserRecord> GROUP__GROUP_CREATOR_UUID_FKEY = Internal.createForeignKey(Group.GROUP, DSL.name("group_creator_uuid_fkey"), new TableField[] { Group.GROUP.CREATOR_UUID }, Keys.USER_PKEY, new TableField[] { User.USER.UUID }, true);
    public static final ForeignKey<GroupRecord, UserRecord> GROUP__GROUP_EDITOR_UUID_FKEY = Internal.createForeignKey(Group.GROUP, DSL.name("group_editor_uuid_fkey"), new TableField[] { Group.GROUP.EDITOR_UUID }, Keys.USER_PKEY, new TableField[] { User.USER.UUID }, true);
    public static final ForeignKey<ModelRecord, UserRecord> MODEL__MODEL_CREATOR_UUID_FKEY = Internal.createForeignKey(Model.MODEL, DSL.name("model_creator_uuid_fkey"), new TableField[] { Model.MODEL.CREATOR_UUID }, Keys.USER_PKEY, new TableField[] { User.USER.UUID }, true);
    public static final ForeignKey<ModelRecord, UserRecord> MODEL__MODEL_EDITOR_UUID_FKEY = Internal.createForeignKey(Model.MODEL, DSL.name("model_editor_uuid_fkey"), new TableField[] { Model.MODEL.EDITOR_UUID }, Keys.USER_PKEY, new TableField[] { User.USER.UUID }, true);
    public static final ForeignKey<ModelRecord, ModelVersionRecord> MODEL__MODEL_LATEST_VERSION_UUID_FKEY = Internal.createForeignKey(Model.MODEL, DSL.name("model_latest_version_uuid_fkey"), new TableField[] { Model.MODEL.LATEST_VERSION_UUID }, Keys.MODEL_VERSION_PKEY, new TableField[] { ModelVersion.MODEL_VERSION.UUID }, true);
    public static final ForeignKey<ModelVersionRecord, ModelRecord> MODEL_VERSION__MODEL_VERSION_MODEL_UUID_FKEY = Internal.createForeignKey(ModelVersion.MODEL_VERSION, DSL.name("model_version_model_uuid_fkey"), new TableField[] { ModelVersion.MODEL_VERSION.MODEL_UUID }, Keys.MODEL_PKEY, new TableField[] { Model.MODEL.UUID }, true);
    public static final ForeignKey<ModelVersionRecord, ModelVersionRecord> MODEL_VERSION__MODEL_VERSION_NEXT_VERSION_UUID_FKEY = Internal.createForeignKey(ModelVersion.MODEL_VERSION, DSL.name("model_version_next_version_uuid_fkey"), new TableField[] { ModelVersion.MODEL_VERSION.NEXT_VERSION_UUID }, Keys.MODEL_VERSION_PKEY, new TableField[] { ModelVersion.MODEL_VERSION.UUID }, true);
    public static final ForeignKey<ModelVersionRecord, ModelVersionRecord> MODEL_VERSION__MODEL_VERSION_PREV_VERSION_UUID_FKEY = Internal.createForeignKey(ModelVersion.MODEL_VERSION, DSL.name("model_version_prev_version_uuid_fkey"), new TableField[] { ModelVersion.MODEL_VERSION.PREV_VERSION_UUID }, Keys.MODEL_VERSION_PKEY, new TableField[] { ModelVersion.MODEL_VERSION.UUID }, true);
    public static final ForeignKey<NamespaceRecord, UserRecord> NAMESPACE__NAMESPACE_CREATOR_UUID_FKEY = Internal.createForeignKey(Namespace.NAMESPACE, DSL.name("namespace_creator_uuid_fkey"), new TableField[] { Namespace.NAMESPACE.CREATOR_UUID }, Keys.USER_PKEY, new TableField[] { User.USER.UUID }, true);
    public static final ForeignKey<NamespaceRecord, UserRecord> NAMESPACE__NAMESPACE_EDITOR_UUID_FKEY = Internal.createForeignKey(Namespace.NAMESPACE, DSL.name("namespace_editor_uuid_fkey"), new TableField[] { Namespace.NAMESPACE.EDITOR_UUID }, Keys.USER_PKEY, new TableField[] { User.USER.UUID }, true);
    public static final ForeignKey<NamespaceRecord, ContentRecord> NAMESPACE__NAMESPACE_ROOT_CONTENT_UUID_FKEY = Internal.createForeignKey(Namespace.NAMESPACE, DSL.name("namespace_root_content_uuid_fkey"), new TableField[] { Namespace.NAMESPACE.ROOT_CONTENT_UUID }, Keys.CONTENT_PKEY, new TableField[] { Content.CONTENT.UUID }, true);
    public static final ForeignKey<RoleRecord, UserRecord> ROLE__ROLE_CREATOR_UUID_FKEY = Internal.createForeignKey(Role.ROLE, DSL.name("role_creator_uuid_fkey"), new TableField[] { Role.ROLE.CREATOR_UUID }, Keys.USER_PKEY, new TableField[] { User.USER.UUID }, true);
    public static final ForeignKey<RoleRecord, UserRecord> ROLE__ROLE_EDITOR_UUID_FKEY = Internal.createForeignKey(Role.ROLE, DSL.name("role_editor_uuid_fkey"), new TableField[] { Role.ROLE.EDITOR_UUID }, Keys.USER_PKEY, new TableField[] { User.USER.UUID }, true);
    public static final ForeignKey<RoleGroupRecord, GroupRecord> ROLE_GROUP__ROLE_GROUP_GROUP_UUID_FKEY = Internal.createForeignKey(RoleGroup.ROLE_GROUP, DSL.name("role_group_group_uuid_fkey"), new TableField[] { RoleGroup.ROLE_GROUP.GROUP_UUID }, Keys.GROUP_PKEY, new TableField[] { Group.GROUP.UUID }, true);
    public static final ForeignKey<RoleGroupRecord, RoleRecord> ROLE_GROUP__ROLE_GROUP_ROLE_UUID_FKEY = Internal.createForeignKey(RoleGroup.ROLE_GROUP, DSL.name("role_group_role_uuid_fkey"), new TableField[] { RoleGroup.ROLE_GROUP.ROLE_UUID }, Keys.ROLE_PKEY, new TableField[] { Role.ROLE.UUID }, true);
    public static final ForeignKey<RolePermissionRecord, RoleRecord> ROLE_PERMISSION__ROLE_PERMISSION_ROLE_UUID_FKEY = Internal.createForeignKey(RolePermission.ROLE_PERMISSION, DSL.name("role_permission_role_uuid_fkey"), new TableField[] { RolePermission.ROLE_PERMISSION.ROLE_UUID }, Keys.ROLE_PKEY, new TableField[] { Role.ROLE.UUID }, true);
    public static final ForeignKey<TagRecord, UserRecord> TAG__TAG_CREATOR_UUID_FKEY = Internal.createForeignKey(Tag.TAG, DSL.name("tag_creator_uuid_fkey"), new TableField[] { Tag.TAG.CREATOR_UUID }, Keys.USER_PKEY, new TableField[] { User.USER.UUID }, true);
    public static final ForeignKey<TagRecord, UserRecord> TAG__TAG_EDITOR_UUID_FKEY = Internal.createForeignKey(Tag.TAG, DSL.name("tag_editor_uuid_fkey"), new TableField[] { Tag.TAG.EDITOR_UUID }, Keys.USER_PKEY, new TableField[] { User.USER.UUID }, true);
    public static final ForeignKey<TagRecord, NamespaceRecord> TAG__TAG_NAMESPACE_UUID_FKEY = Internal.createForeignKey(Tag.TAG, DSL.name("tag_namespace_uuid_fkey"), new TableField[] { Tag.TAG.NAMESPACE_UUID }, Keys.NAMESPACE_PKEY, new TableField[] { Namespace.NAMESPACE.UUID }, true);
    public static final ForeignKey<TagContentRecord, ContentRecord> TAG_CONTENT__TAG_CONTENT_CONTENT_UUID_FKEY = Internal.createForeignKey(TagContent.TAG_CONTENT, DSL.name("tag_content_content_uuid_fkey"), new TableField[] { TagContent.TAG_CONTENT.CONTENT_UUID }, Keys.CONTENT_PKEY, new TableField[] { Content.CONTENT.UUID }, true);
    public static final ForeignKey<TagContentRecord, TagRecord> TAG_CONTENT__TAG_CONTENT_TAG_UUID_FKEY = Internal.createForeignKey(TagContent.TAG_CONTENT, DSL.name("tag_content_tag_uuid_fkey"), new TableField[] { TagContent.TAG_CONTENT.TAG_UUID }, Keys.TAG_PKEY, new TableField[] { Tag.TAG.UUID }, true);
    public static final ForeignKey<TagNamespaceRecord, NamespaceRecord> TAG_NAMESPACE__TAG_NAMESPACE_NAMESPACE_UUID_FKEY = Internal.createForeignKey(TagNamespace.TAG_NAMESPACE, DSL.name("tag_namespace_namespace_uuid_fkey"), new TableField[] { TagNamespace.TAG_NAMESPACE.NAMESPACE_UUID }, Keys.NAMESPACE_PKEY, new TableField[] { Namespace.NAMESPACE.UUID }, true);
    public static final ForeignKey<TagNamespaceRecord, TagRecord> TAG_NAMESPACE__TAG_NAMESPACE_TAG_UUID_FKEY = Internal.createForeignKey(TagNamespace.TAG_NAMESPACE, DSL.name("tag_namespace_tag_uuid_fkey"), new TableField[] { TagNamespace.TAG_NAMESPACE.TAG_UUID }, Keys.TAG_PKEY, new TableField[] { Tag.TAG.UUID }, true);
    public static final ForeignKey<TagUserMetaRecord, TagRecord> TAG_USER_META__TAG_USER_META_TAG_UUID_FKEY = Internal.createForeignKey(TagUserMeta.TAG_USER_META, DSL.name("tag_user_meta_tag_uuid_fkey"), new TableField[] { TagUserMeta.TAG_USER_META.TAG_UUID }, Keys.TAG_PKEY, new TableField[] { Tag.TAG.UUID }, true);
    public static final ForeignKey<TagUserMetaRecord, UserRecord> TAG_USER_META__TAG_USER_META_USER_UUID_FKEY = Internal.createForeignKey(TagUserMeta.TAG_USER_META, DSL.name("tag_user_meta_user_uuid_fkey"), new TableField[] { TagUserMeta.TAG_USER_META.USER_UUID }, Keys.USER_PKEY, new TableField[] { User.USER.UUID }, true);
    public static final ForeignKey<UserRecord, UserRecord> USER__USER_CREATOR_UUID_FKEY = Internal.createForeignKey(User.USER, DSL.name("user_creator_uuid_fkey"), new TableField[] { User.USER.CREATOR_UUID }, Keys.USER_PKEY, new TableField[] { User.USER.UUID }, true);
    public static final ForeignKey<UserRecord, UserRecord> USER__USER_EDITOR_UUID_FKEY = Internal.createForeignKey(User.USER, DSL.name("user_editor_uuid_fkey"), new TableField[] { User.USER.EDITOR_UUID }, Keys.USER_PKEY, new TableField[] { User.USER.UUID }, true);
    public static final ForeignKey<UserGroupRecord, GroupRecord> USER_GROUP__USER_GROUP_GROUP_UUID_FKEY = Internal.createForeignKey(UserGroup.USER_GROUP, DSL.name("user_group_group_uuid_fkey"), new TableField[] { UserGroup.USER_GROUP.GROUP_UUID }, Keys.GROUP_PKEY, new TableField[] { Group.GROUP.UUID }, true);
    public static final ForeignKey<UserGroupRecord, UserRecord> USER_GROUP__USER_GROUP_USER_UUID_FKEY = Internal.createForeignKey(UserGroup.USER_GROUP, DSL.name("user_group_user_uuid_fkey"), new TableField[] { UserGroup.USER_GROUP.USER_UUID }, Keys.USER_PKEY, new TableField[] { User.USER.UUID }, true);
    public static final ForeignKey<UserTokenRecord, UserRecord> USER_TOKEN__USER_TOKEN_USER_UUID_FKEY = Internal.createForeignKey(UserToken.USER_TOKEN, DSL.name("user_token_user_uuid_fkey"), new TableField[] { UserToken.USER_TOKEN.USER_UUID }, Keys.USER_PKEY, new TableField[] { User.USER.UUID }, true);
    public static final ForeignKey<WebhookRecord, UserRecord> WEBHOOK__WEBHOOK_CREATOR_UUID_FKEY = Internal.createForeignKey(Webhook.WEBHOOK, DSL.name("webhook_creator_uuid_fkey"), new TableField[] { Webhook.WEBHOOK.CREATOR_UUID }, Keys.USER_PKEY, new TableField[] { User.USER.UUID }, true);
    public static final ForeignKey<WebhookRecord, UserRecord> WEBHOOK__WEBHOOK_EDITOR_UUID_FKEY = Internal.createForeignKey(Webhook.WEBHOOK, DSL.name("webhook_editor_uuid_fkey"), new TableField[] { Webhook.WEBHOOK.EDITOR_UUID }, Keys.USER_PKEY, new TableField[] { User.USER.UUID }, true);
}
