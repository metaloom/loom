/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq;


import io.metaloom.loom.db.jooq.tables.JooqAnnotation;
import io.metaloom.loom.db.jooq.tables.JooqAnnotationAsset;
import io.metaloom.loom.db.jooq.tables.JooqAnnotationTag;
import io.metaloom.loom.db.jooq.tables.JooqAnnotationTask;
import io.metaloom.loom.db.jooq.tables.JooqAsset;
import io.metaloom.loom.db.jooq.tables.JooqAssetLocation;
import io.metaloom.loom.db.jooq.tables.JooqAssetRemix;
import io.metaloom.loom.db.jooq.tables.JooqAssetTask;
import io.metaloom.loom.db.jooq.tables.JooqAssetUserMeta;
import io.metaloom.loom.db.jooq.tables.JooqAttachment;
import io.metaloom.loom.db.jooq.tables.JooqAttachmentBinary;
import io.metaloom.loom.db.jooq.tables.JooqBlacklist;
import io.metaloom.loom.db.jooq.tables.JooqCluster;
import io.metaloom.loom.db.jooq.tables.JooqCollection;
import io.metaloom.loom.db.jooq.tables.JooqCollectionAsset;
import io.metaloom.loom.db.jooq.tables.JooqCollectionCluster;
import io.metaloom.loom.db.jooq.tables.JooqComment;
import io.metaloom.loom.db.jooq.tables.JooqEmbedding;
import io.metaloom.loom.db.jooq.tables.JooqEmbeddingCluster;
import io.metaloom.loom.db.jooq.tables.JooqFlywaySchemaHistory;
import io.metaloom.loom.db.jooq.tables.JooqGroup;
import io.metaloom.loom.db.jooq.tables.JooqLibrary;
import io.metaloom.loom.db.jooq.tables.JooqLibraryAsset;
import io.metaloom.loom.db.jooq.tables.JooqLibraryCollection;
import io.metaloom.loom.db.jooq.tables.JooqLoom;
import io.metaloom.loom.db.jooq.tables.JooqProject;
import io.metaloom.loom.db.jooq.tables.JooqProjectCollection;
import io.metaloom.loom.db.jooq.tables.JooqProjectLibrary;
import io.metaloom.loom.db.jooq.tables.JooqReaction;
import io.metaloom.loom.db.jooq.tables.JooqRole;
import io.metaloom.loom.db.jooq.tables.JooqRoleGroup;
import io.metaloom.loom.db.jooq.tables.JooqRolePermission;
import io.metaloom.loom.db.jooq.tables.JooqTag;
import io.metaloom.loom.db.jooq.tables.JooqTagAsset;
import io.metaloom.loom.db.jooq.tables.JooqTagCluster;
import io.metaloom.loom.db.jooq.tables.JooqTagCollection;
import io.metaloom.loom.db.jooq.tables.JooqTagUserMeta;
import io.metaloom.loom.db.jooq.tables.JooqTask;
import io.metaloom.loom.db.jooq.tables.JooqToken;
import io.metaloom.loom.db.jooq.tables.JooqTokenPermission;
import io.metaloom.loom.db.jooq.tables.JooqUser;
import io.metaloom.loom.db.jooq.tables.JooqUserGroup;
import io.metaloom.loom.db.jooq.tables.JooqUserPermission;
import io.metaloom.loom.db.jooq.tables.JooqVectorConfig;
import io.metaloom.loom.db.jooq.tables.JooqWebhook;


/**
 * Convenience access to all tables in public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * This table contains asset annotation entries which can be used to create
     * chapters or sections to assign tasks to.
     */
    public static final JooqAnnotation ANNOTATION = JooqAnnotation.ANNOTATION;

    /**
     * The table <code>public.annotation_asset</code>.
     */
    public static final JooqAnnotationAsset ANNOTATION_ASSET = JooqAnnotationAsset.ANNOTATION_ASSET;

    /**
     * The table <code>public.annotation_tag</code>.
     */
    public static final JooqAnnotationTag ANNOTATION_TAG = JooqAnnotationTag.ANNOTATION_TAG;

    /**
     * The table <code>public.annotation_task</code>.
     */
    public static final JooqAnnotationTask ANNOTATION_TASK = JooqAnnotationTask.ANNOTATION_TASK;

    /**
     * This table stores information on the asset component of the asset
     */
    public static final JooqAsset ASSET = JooqAsset.ASSET;

    /**
     * Assets keep track of media that has been found by the scanner. Multiple
     * asset_locations may share the same asset thus the properties will be
     * decoupled from asset.
     */
    public static final JooqAssetLocation ASSET_LOCATION = JooqAssetLocation.ASSET_LOCATION;

    /**
     * Store information on remixes of binaries.
     */
    public static final JooqAssetRemix ASSET_REMIX = JooqAssetRemix.ASSET_REMIX;

    /**
     * The table <code>public.asset_task</code>.
     */
    public static final JooqAssetTask ASSET_TASK = JooqAssetTask.ASSET_TASK;

    /**
     * Stores user specific metadata that can be added to asset
     */
    public static final JooqAssetUserMeta ASSET_USER_META = JooqAssetUserMeta.ASSET_USER_META;

    /**
     * The table <code>public.attachment</code>.
     */
    public static final JooqAttachment ATTACHMENT = JooqAttachment.ATTACHMENT;

    /**
     * The table <code>public.attachment_binary</code>.
     */
    public static final JooqAttachmentBinary ATTACHMENT_BINARY = JooqAttachmentBinary.ATTACHMENT_BINARY;

    /**
     * Stores information on blocked binaries.
     * A asset can be blocked due to copyright claim issues or because the virus
     * scanner marked it.
     */
    public static final JooqBlacklist BLACKLIST = JooqBlacklist.BLACKLIST;

    /**
     * Generic cluster that aggregates multiple embeddings. 
     * A cluster could for example represent a person which can have multiple
     * face embeddings.
     * Alternatively media fingerprint embeddings can be used to group media
     * together by visual similarity.
     */
    public static final JooqCluster CLUSTER = JooqCluster.CLUSTER;

    /**
     * Collections are used to group assets together.
     *           A collection may be a folder which groups together assets for a
     * project.
     */
    public static final JooqCollection COLLECTION = JooqCollection.COLLECTION;

    /**
     * Track assets that belong to a collection.
     */
    public static final JooqCollectionAsset COLLECTION_ASSET = JooqCollectionAsset.COLLECTION_ASSET;

    /**
     * The table <code>public.collection_cluster</code>.
     */
    public static final JooqCollectionCluster COLLECTION_CLUSTER = JooqCollectionCluster.COLLECTION_CLUSTER;

    /**
     * Stores comments on tasks, annotations..
     */
    public static final JooqComment COMMENT = JooqComment.COMMENT;

    /**
     * Embedding information which was extracted from an asset.
     */
    public static final JooqEmbedding EMBEDDING = JooqEmbedding.EMBEDDING;

    /**
     * List embeddings for clusters
     */
    public static final JooqEmbeddingCluster EMBEDDING_CLUSTER = JooqEmbeddingCluster.EMBEDDING_CLUSTER;

    /**
     * The table <code>public.flyway_schema_history</code>.
     */
    public static final JooqFlywaySchemaHistory FLYWAY_SCHEMA_HISTORY = JooqFlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY;

    /**
     * The table <code>public.group</code>.
     */
    public static final JooqGroup GROUP = JooqGroup.GROUP;

    /**
     * The table <code>public.library</code>.
     */
    public static final JooqLibrary LIBRARY = JooqLibrary.LIBRARY;

    /**
     * The table <code>public.library_asset</code>.
     */
    public static final JooqLibraryAsset LIBRARY_ASSET = JooqLibraryAsset.LIBRARY_ASSET;

    /**
     * The table <code>public.library_collection</code>.
     */
    public static final JooqLibraryCollection LIBRARY_COLLECTION = JooqLibraryCollection.LIBRARY_COLLECTION;

    /**
     * The table <code>public.loom</code>.
     */
    public static final JooqLoom LOOM = JooqLoom.LOOM;

    /**
     * The table <code>public.project</code>.
     */
    public static final JooqProject PROJECT = JooqProject.PROJECT;

    /**
     * The table <code>public.project_collection</code>.
     */
    public static final JooqProjectCollection PROJECT_COLLECTION = JooqProjectCollection.PROJECT_COLLECTION;

    /**
     * The table <code>public.project_library</code>.
     */
    public static final JooqProjectLibrary PROJECT_LIBRARY = JooqProjectLibrary.PROJECT_LIBRARY;

    /**
     * Stores social reactions on multiple elements
     */
    public static final JooqReaction REACTION = JooqReaction.REACTION;

    /**
     * The table <code>public.role</code>.
     */
    public static final JooqRole ROLE = JooqRole.ROLE;

    /**
     * The table <code>public.role_group</code>.
     */
    public static final JooqRoleGroup ROLE_GROUP = JooqRoleGroup.ROLE_GROUP;

    /**
     * The table <code>public.role_permission</code>.
     */
    public static final JooqRolePermission ROLE_PERMISSION = JooqRolePermission.ROLE_PERMISSION;

    /**
     * Tag on various elements. Tags are not user specifc
     */
    public static final JooqTag TAG = JooqTag.TAG;

    /**
     * Store tag &lt;-&gt; asset reference
     */
    public static final JooqTagAsset TAG_ASSET = JooqTagAsset.TAG_ASSET;

    /**
     * Store tag &lt;-&gt; cluster reference
     */
    public static final JooqTagCluster TAG_CLUSTER = JooqTagCluster.TAG_CLUSTER;

    /**
     * Store tag &lt;-&gt; collection reference
     */
    public static final JooqTagCollection TAG_COLLECTION = JooqTagCollection.TAG_COLLECTION;

    /**
     * The table <code>public.tag_user_meta</code>.
     */
    public static final JooqTagUserMeta TAG_USER_META = JooqTagUserMeta.TAG_USER_META;

    /**
     * The table <code>public.task</code>.
     */
    public static final JooqTask TASK = JooqTask.TASK;

    /**
     * The table <code>public.token</code>.
     */
    public static final JooqToken TOKEN = JooqToken.TOKEN;

    /**
     * The table <code>public.token_permission</code>.
     */
    public static final JooqTokenPermission TOKEN_PERMISSION = JooqTokenPermission.TOKEN_PERMISSION;

    /**
     * The table <code>public.user</code>.
     */
    public static final JooqUser USER = JooqUser.USER;

    /**
     * The table <code>public.user_group</code>.
     */
    public static final JooqUserGroup USER_GROUP = JooqUserGroup.USER_GROUP;

    /**
     * The table <code>public.user_permission</code>.
     */
    public static final JooqUserPermission USER_PERMISSION = JooqUserPermission.USER_PERMISSION;

    /**
     * This table stores the custom index definition that will be used when
     * creating custom indices in a vector database that list specific aspects
     * of loom data.
     * 
     * A custom configuration may define that a specific meta property should be
     * added to the index when generating the vector.
     * This feature can be used to generate a custom recommendation feature by
     * including and ranking and encoding specific properties as vectors.
     */
    public static final JooqVectorConfig VECTOR_CONFIG = JooqVectorConfig.VECTOR_CONFIG;

    /**
     * Table which stores the registered webhooks
     */
    public static final JooqWebhook WEBHOOK = JooqWebhook.WEBHOOK;
}
