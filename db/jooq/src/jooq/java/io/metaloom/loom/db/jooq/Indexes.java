/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq;


import io.metaloom.loom.db.jooq.tables.Assets;
import io.metaloom.loom.db.jooq.tables.FieldContent;
import io.metaloom.loom.db.jooq.tables.Groups;
import io.metaloom.loom.db.jooq.tables.Languages;
import io.metaloom.loom.db.jooq.tables.Models;
import io.metaloom.loom.db.jooq.tables.Namespaces;
import io.metaloom.loom.db.jooq.tables.Roles;
import io.metaloom.loom.db.jooq.tables.SchemaVersion;
import io.metaloom.loom.db.jooq.tables.Tags;
import io.metaloom.loom.db.jooq.tables.UserToken;
import io.metaloom.loom.db.jooq.tables.Users;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables in public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index ASSETS_UUID_NAMESPACE_UUID_IDX = Internal.createIndex(DSL.name("assets_uuid_namespace_uuid_idx"), Assets.ASSETS, new OrderField[] { Assets.ASSETS.UUID, Assets.ASSETS.NAMESPACE_UUID }, true);
    public static final Index FIELD_CONTENT_CONTENT_TYPE_WEBROOT_PATH_INFO_IDX = Internal.createIndex(DSL.name("field_content_content_type_webroot_path_info_idx"), FieldContent.FIELD_CONTENT, new OrderField[] { FieldContent.FIELD_CONTENT.CONTENT_TYPE, FieldContent.FIELD_CONTENT.WEBROOT_PATH_INFO }, false);
    public static final Index FIELD_CONTENT_CONTENT_UUID_CONTENT_TYPE_IDX = Internal.createIndex(DSL.name("field_content_content_uuid_content_type_idx"), FieldContent.FIELD_CONTENT, new OrderField[] { FieldContent.FIELD_CONTENT.CONTENT_UUID, FieldContent.FIELD_CONTENT.CONTENT_TYPE }, false);
    public static final Index GROUPS_NAME_IDX = Internal.createIndex(DSL.name("groups_name_idx"), Groups.GROUPS, new OrderField[] { Groups.GROUPS.NAME }, true);
    public static final Index LANGUAGES_TAGS_IDX = Internal.createIndex(DSL.name("languages_tags_idx"), Languages.LANGUAGES, new OrderField[] { Languages.LANGUAGES.TAGS }, false);
    public static final Index MODELS_NAME_IDX = Internal.createIndex(DSL.name("models_name_idx"), Models.MODELS, new OrderField[] { Models.MODELS.NAME }, true);
    public static final Index NAMESPACES_NAME_IDX = Internal.createIndex(DSL.name("namespaces_name_idx"), Namespaces.NAMESPACES, new OrderField[] { Namespaces.NAMESPACES.NAME }, true);
    public static final Index ROLES_NAME_IDX = Internal.createIndex(DSL.name("roles_name_idx"), Roles.ROLES, new OrderField[] { Roles.ROLES.NAME }, true);
    public static final Index SCHEMA_VERSION_IR_IDX = Internal.createIndex(DSL.name("schema_version_ir_idx"), SchemaVersion.SCHEMA_VERSION, new OrderField[] { SchemaVersion.SCHEMA_VERSION.INSTALLED_RANK }, false);
    public static final Index SCHEMA_VERSION_S_IDX = Internal.createIndex(DSL.name("schema_version_s_idx"), SchemaVersion.SCHEMA_VERSION, new OrderField[] { SchemaVersion.SCHEMA_VERSION.SUCCESS }, false);
    public static final Index SCHEMA_VERSION_VR_IDX = Internal.createIndex(DSL.name("schema_version_vr_idx"), SchemaVersion.SCHEMA_VERSION, new OrderField[] { SchemaVersion.SCHEMA_VERSION.VERSION_RANK }, false);
    public static final Index TAGS_NAME_COLLECTION_NAMESPACE_UUID_IDX = Internal.createIndex(DSL.name("tags_name_collection_namespace_uuid_idx"), Tags.TAGS, new OrderField[] { Tags.TAGS.NAME, Tags.TAGS.COLLECTION, Tags.TAGS.NAMESPACE_UUID }, true);
    public static final Index USER_TOKEN_USER_UUID_IDX = Internal.createIndex(DSL.name("user_token_user_uuid_idx"), UserToken.USER_TOKEN, new OrderField[] { UserToken.USER_TOKEN.USER_UUID }, false);
    public static final Index USERS_USERNAME_IDX = Internal.createIndex(DSL.name("users_username_idx"), Users.USERS, new OrderField[] { Users.USERS.USERNAME }, true);
}
