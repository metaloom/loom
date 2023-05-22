/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq;


import io.metaloom.loom.db.jooq.tables.JooqAsset;
import io.metaloom.loom.db.jooq.tables.JooqAssetLocation;
import io.metaloom.loom.db.jooq.tables.JooqAssetRemix;
import io.metaloom.loom.db.jooq.tables.JooqBlacklist;
import io.metaloom.loom.db.jooq.tables.JooqCluster;
import io.metaloom.loom.db.jooq.tables.JooqCollectionAsset;
import io.metaloom.loom.db.jooq.tables.JooqCollectionCluster;
import io.metaloom.loom.db.jooq.tables.JooqEmbedding;
import io.metaloom.loom.db.jooq.tables.JooqFlywaySchemaHistory;
import io.metaloom.loom.db.jooq.tables.JooqGroup;
import io.metaloom.loom.db.jooq.tables.JooqReaction;
import io.metaloom.loom.db.jooq.tables.JooqRole;
import io.metaloom.loom.db.jooq.tables.JooqRolePermission;
import io.metaloom.loom.db.jooq.tables.JooqTag;
import io.metaloom.loom.db.jooq.tables.JooqToken;
import io.metaloom.loom.db.jooq.tables.JooqTokenPermission;
import io.metaloom.loom.db.jooq.tables.JooqUser;
import io.metaloom.loom.db.jooq.tables.JooqUserPermission;

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

    public static final Index ASSET_GEO_LON_GEO_LAT_IDX = Internal.createIndex(DSL.name("asset_geo_lon_geo_lat_idx"), JooqAsset.ASSET, new OrderField[] { JooqAsset.ASSET.GEO_LON, JooqAsset.ASSET.GEO_LAT }, false);
    public static final Index ASSET_LOCATION_PATH_IDX = Internal.createIndex(DSL.name("asset_location_path_idx"), JooqAssetLocation.ASSET_LOCATION, new OrderField[] { JooqAssetLocation.ASSET_LOCATION.PATH }, false);
    public static final Index ASSET_REMIX_ASSET_A_UUID_IDX = Internal.createIndex(DSL.name("asset_remix_asset_a_uuid_idx"), JooqAssetRemix.ASSET_REMIX, new OrderField[] { JooqAssetRemix.ASSET_REMIX.ASSET_A_UUID }, false);
    public static final Index ASSET_REMIX_ASSET_B_UUID_IDX = Internal.createIndex(DSL.name("asset_remix_asset_b_uuid_idx"), JooqAssetRemix.ASSET_REMIX, new OrderField[] { JooqAssetRemix.ASSET_REMIX.ASSET_B_UUID }, false);
    public static final Index ASSET_UUID_IDX = Internal.createIndex(DSL.name("asset_uuid_idx"), JooqAsset.ASSET, new OrderField[] { JooqAsset.ASSET.UUID }, true);
    public static final Index BLACKLIST_ASSET_UUID_CREATOR_UUID_IDX = Internal.createIndex(DSL.name("blacklist_asset_uuid_creator_uuid_idx"), JooqBlacklist.BLACKLIST, new OrderField[] { JooqBlacklist.BLACKLIST.ASSET_UUID, JooqBlacklist.BLACKLIST.CREATOR_UUID }, true);
    public static final Index CLUSTER_NAME_IDX = Internal.createIndex(DSL.name("cluster_name_idx"), JooqCluster.CLUSTER, new OrderField[] { JooqCluster.CLUSTER.NAME }, true);
    public static final Index COLLECTION_ASSET_ASSET_UUID_IDX = Internal.createIndex(DSL.name("collection_asset_asset_uuid_idx"), JooqCollectionAsset.COLLECTION_ASSET, new OrderField[] { JooqCollectionAsset.COLLECTION_ASSET.ASSET_UUID }, false);
    public static final Index COLLECTION_ASSET_COLLECTION_UUID_IDX = Internal.createIndex(DSL.name("collection_asset_collection_uuid_idx"), JooqCollectionAsset.COLLECTION_ASSET, new OrderField[] { JooqCollectionAsset.COLLECTION_ASSET.COLLECTION_UUID }, false);
    public static final Index COLLECTION_CLUSTER_CLUSTER_UUID_IDX = Internal.createIndex(DSL.name("collection_cluster_cluster_uuid_idx"), JooqCollectionCluster.COLLECTION_CLUSTER, new OrderField[] { JooqCollectionCluster.COLLECTION_CLUSTER.CLUSTER_UUID }, false);
    public static final Index COLLECTION_CLUSTER_COLLECTION_UUID_IDX = Internal.createIndex(DSL.name("collection_cluster_collection_uuid_idx"), JooqCollectionCluster.COLLECTION_CLUSTER, new OrderField[] { JooqCollectionCluster.COLLECTION_CLUSTER.COLLECTION_UUID }, false);
    public static final Index EMBEDDING_ASSET_UUID_IDX = Internal.createIndex(DSL.name("embedding_asset_uuid_idx"), JooqEmbedding.EMBEDDING, new OrderField[] { JooqEmbedding.EMBEDDING.ASSET_UUID }, false);
    public static final Index FLYWAY_SCHEMA_HISTORY_S_IDX = Internal.createIndex(DSL.name("flyway_schema_history_s_idx"), JooqFlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, new OrderField[] { JooqFlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.SUCCESS }, false);
    public static final Index GROUP_NAME_IDX = Internal.createIndex(DSL.name("group_name_idx"), JooqGroup.GROUP, new OrderField[] { JooqGroup.GROUP.NAME }, true);
    public static final Index REACTION_CREATOR_UUID_TYPE_ANNOTATION_UUID_IDX = Internal.createIndex(DSL.name("reaction_creator_uuid_type_annotation_uuid_idx"), JooqReaction.REACTION, new OrderField[] { JooqReaction.REACTION.CREATOR_UUID, JooqReaction.REACTION.TYPE, JooqReaction.REACTION.ANNOTATION_UUID }, true);
    public static final Index REACTION_CREATOR_UUID_TYPE_ASSET_UUID_IDX = Internal.createIndex(DSL.name("reaction_creator_uuid_type_asset_uuid_idx"), JooqReaction.REACTION, new OrderField[] { JooqReaction.REACTION.CREATOR_UUID, JooqReaction.REACTION.TYPE, JooqReaction.REACTION.ASSET_UUID }, true);
    public static final Index REACTION_CREATOR_UUID_TYPE_COMMENT_UUID_IDX = Internal.createIndex(DSL.name("reaction_creator_uuid_type_comment_uuid_idx"), JooqReaction.REACTION, new OrderField[] { JooqReaction.REACTION.CREATOR_UUID, JooqReaction.REACTION.TYPE, JooqReaction.REACTION.COMMENT_UUID }, true);
    public static final Index ROLE_NAME_IDX = Internal.createIndex(DSL.name("role_name_idx"), JooqRole.ROLE, new OrderField[] { JooqRole.ROLE.NAME }, true);
    public static final Index ROLE_PERMISSION_ROLE_UUID_RESOURCE_PERMISSION_IDX = Internal.createIndex(DSL.name("role_permission_role_uuid_resource_permission_idx"), JooqRolePermission.ROLE_PERMISSION, new OrderField[] { JooqRolePermission.ROLE_PERMISSION.ROLE_UUID, JooqRolePermission.ROLE_PERMISSION.RESOURCE, JooqRolePermission.ROLE_PERMISSION.PERMISSION }, true);
    public static final Index TAG_NAME_COLLECTION_IDX = Internal.createIndex(DSL.name("tag_name_collection_idx"), JooqTag.TAG, new OrderField[] { JooqTag.TAG.NAME, JooqTag.TAG.COLLECTION }, true);
    public static final Index TOKEN_CREATOR_UUID_IDX = Internal.createIndex(DSL.name("token_creator_uuid_idx"), JooqToken.TOKEN, new OrderField[] { JooqToken.TOKEN.CREATOR_UUID }, false);
    public static final Index TOKEN_CREATOR_UUID_NAME_IDX = Internal.createIndex(DSL.name("token_creator_uuid_name_idx"), JooqToken.TOKEN, new OrderField[] { JooqToken.TOKEN.CREATOR_UUID, JooqToken.TOKEN.NAME }, true);
    public static final Index TOKEN_PERMISSION_TOKEN_UUID_RESOURCE_PERMISSION_IDX = Internal.createIndex(DSL.name("token_permission_token_uuid_resource_permission_idx"), JooqTokenPermission.TOKEN_PERMISSION, new OrderField[] { JooqTokenPermission.TOKEN_PERMISSION.TOKEN_UUID, JooqTokenPermission.TOKEN_PERMISSION.RESOURCE, JooqTokenPermission.TOKEN_PERMISSION.PERMISSION }, true);
    public static final Index TOKEN_TOKEN_IDX = Internal.createIndex(DSL.name("token_token_idx"), JooqToken.TOKEN, new OrderField[] { JooqToken.TOKEN.TOKEN_ }, true);
    public static final Index USER_PERMISSION_USER_UUID_RESOURCE_PERMISSION_IDX = Internal.createIndex(DSL.name("user_permission_user_uuid_resource_permission_idx"), JooqUserPermission.USER_PERMISSION, new OrderField[] { JooqUserPermission.USER_PERMISSION.USER_UUID, JooqUserPermission.USER_PERMISSION.RESOURCE, JooqUserPermission.USER_PERMISSION.PERMISSION }, true);
    public static final Index USER_USERNAME_IDX = Internal.createIndex(DSL.name("user_username_idx"), JooqUser.USER, new OrderField[] { JooqUser.USER.USERNAME }, true);
}
