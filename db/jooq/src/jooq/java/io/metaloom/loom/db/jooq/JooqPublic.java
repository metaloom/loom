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

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqPublic extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public</code>
     */
    public static final JooqPublic PUBLIC = new JooqPublic();

    /**
     * This table contains asset annotation entries which can be used to create
     * chapters or sections to assign tasks to.
     */
    public final JooqAnnotation ANNOTATION = JooqAnnotation.ANNOTATION;

    /**
     * The table <code>public.annotation_asset</code>.
     */
    public final JooqAnnotationAsset ANNOTATION_ASSET = JooqAnnotationAsset.ANNOTATION_ASSET;

    /**
     * The table <code>public.annotation_tag</code>.
     */
    public final JooqAnnotationTag ANNOTATION_TAG = JooqAnnotationTag.ANNOTATION_TAG;

    /**
     * The table <code>public.annotation_task</code>.
     */
    public final JooqAnnotationTask ANNOTATION_TASK = JooqAnnotationTask.ANNOTATION_TASK;

    /**
     * This table stores information on the asset component of the asset
     */
    public final JooqAsset ASSET = JooqAsset.ASSET;

    /**
     * Assets keep track of media that has been found by the scanner. Multiple
     * asset_locations may share the same asset thus the properties will be
     * decoupled from asset.
     */
    public final JooqAssetLocation ASSET_LOCATION = JooqAssetLocation.ASSET_LOCATION;

    /**
     * Store information on remixes of binaries.
     */
    public final JooqAssetRemix ASSET_REMIX = JooqAssetRemix.ASSET_REMIX;

    /**
     * The table <code>public.asset_task</code>.
     */
    public final JooqAssetTask ASSET_TASK = JooqAssetTask.ASSET_TASK;

    /**
     * Stores user specific metadata that can be added to asset
     */
    public final JooqAssetUserMeta ASSET_USER_META = JooqAssetUserMeta.ASSET_USER_META;

    /**
     * The table <code>public.attachment</code>.
     */
    public final JooqAttachment ATTACHMENT = JooqAttachment.ATTACHMENT;

    /**
     * The table <code>public.attachment_binary</code>.
     */
    public final JooqAttachmentBinary ATTACHMENT_BINARY = JooqAttachmentBinary.ATTACHMENT_BINARY;

    /**
     * Stores information on blocked binaries.
     * A asset can be blocked due to copyright claim issues or because the virus
     * scanner marked it.
     */
    public final JooqBlacklist BLACKLIST = JooqBlacklist.BLACKLIST;

    /**
     * Generic cluster that aggregates multiple embeddings. 
     * A cluster could for example represent a person which can have multiple
     * face embeddings.
     * Alternatively media fingerprint embeddings can be used to group media
     * together by visual similarity.
     */
    public final JooqCluster CLUSTER = JooqCluster.CLUSTER;

    /**
     * Collections are used to group assets together.
     *           A collection may be a folder which groups together assets for a
     * project.
     */
    public final JooqCollection COLLECTION = JooqCollection.COLLECTION;

    /**
     * Track assets that belong to a collection.
     */
    public final JooqCollectionAsset COLLECTION_ASSET = JooqCollectionAsset.COLLECTION_ASSET;

    /**
     * The table <code>public.collection_cluster</code>.
     */
    public final JooqCollectionCluster COLLECTION_CLUSTER = JooqCollectionCluster.COLLECTION_CLUSTER;

    /**
     * Stores comments on tasks, annotations..
     */
    public final JooqComment COMMENT = JooqComment.COMMENT;

    /**
     * Embedding information which was extracted from an asset.
     */
    public final JooqEmbedding EMBEDDING = JooqEmbedding.EMBEDDING;

    /**
     * List embeddings for clusters
     */
    public final JooqEmbeddingCluster EMBEDDING_CLUSTER = JooqEmbeddingCluster.EMBEDDING_CLUSTER;

    /**
     * The table <code>public.flyway_schema_history</code>.
     */
    public final JooqFlywaySchemaHistory FLYWAY_SCHEMA_HISTORY = JooqFlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY;

    /**
     * The table <code>public.group</code>.
     */
    public final JooqGroup GROUP = JooqGroup.GROUP;

    /**
     * The table <code>public.library</code>.
     */
    public final JooqLibrary LIBRARY = JooqLibrary.LIBRARY;

    /**
     * The table <code>public.library_asset</code>.
     */
    public final JooqLibraryAsset LIBRARY_ASSET = JooqLibraryAsset.LIBRARY_ASSET;

    /**
     * The table <code>public.library_collection</code>.
     */
    public final JooqLibraryCollection LIBRARY_COLLECTION = JooqLibraryCollection.LIBRARY_COLLECTION;

    /**
     * The table <code>public.loom</code>.
     */
    public final JooqLoom LOOM = JooqLoom.LOOM;

    /**
     * The table <code>public.project</code>.
     */
    public final JooqProject PROJECT = JooqProject.PROJECT;

    /**
     * The table <code>public.project_collection</code>.
     */
    public final JooqProjectCollection PROJECT_COLLECTION = JooqProjectCollection.PROJECT_COLLECTION;

    /**
     * The table <code>public.project_library</code>.
     */
    public final JooqProjectLibrary PROJECT_LIBRARY = JooqProjectLibrary.PROJECT_LIBRARY;

    /**
     * Stores social reactions on multiple elements
     */
    public final JooqReaction REACTION = JooqReaction.REACTION;

    /**
     * The table <code>public.role</code>.
     */
    public final JooqRole ROLE = JooqRole.ROLE;

    /**
     * The table <code>public.role_group</code>.
     */
    public final JooqRoleGroup ROLE_GROUP = JooqRoleGroup.ROLE_GROUP;

    /**
     * The table <code>public.role_permission</code>.
     */
    public final JooqRolePermission ROLE_PERMISSION = JooqRolePermission.ROLE_PERMISSION;

    /**
     * Tag on various elements. Tags are not user specifc
     */
    public final JooqTag TAG = JooqTag.TAG;

    /**
     * Store tag &lt;-&gt; asset reference
     */
    public final JooqTagAsset TAG_ASSET = JooqTagAsset.TAG_ASSET;

    /**
     * Store tag &lt;-&gt; cluster reference
     */
    public final JooqTagCluster TAG_CLUSTER = JooqTagCluster.TAG_CLUSTER;

    /**
     * Store tag &lt;-&gt; collection reference
     */
    public final JooqTagCollection TAG_COLLECTION = JooqTagCollection.TAG_COLLECTION;

    /**
     * The table <code>public.tag_user_meta</code>.
     */
    public final JooqTagUserMeta TAG_USER_META = JooqTagUserMeta.TAG_USER_META;

    /**
     * The table <code>public.task</code>.
     */
    public final JooqTask TASK = JooqTask.TASK;

    /**
     * The table <code>public.token</code>.
     */
    public final JooqToken TOKEN = JooqToken.TOKEN;

    /**
     * The table <code>public.token_permission</code>.
     */
    public final JooqTokenPermission TOKEN_PERMISSION = JooqTokenPermission.TOKEN_PERMISSION;

    /**
     * The table <code>public.user</code>.
     */
    public final JooqUser USER = JooqUser.USER;

    /**
     * The table <code>public.user_group</code>.
     */
    public final JooqUserGroup USER_GROUP = JooqUserGroup.USER_GROUP;

    /**
     * The table <code>public.user_permission</code>.
     */
    public final JooqUserPermission USER_PERMISSION = JooqUserPermission.USER_PERMISSION;

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
    public final JooqVectorConfig VECTOR_CONFIG = JooqVectorConfig.VECTOR_CONFIG;

    /**
     * Table which stores the registered webhooks
     */
    public final JooqWebhook WEBHOOK = JooqWebhook.WEBHOOK;

    /**
     * No further instances allowed
     */
    private JooqPublic() {
        super("public", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            JooqAnnotation.ANNOTATION,
            JooqAnnotationAsset.ANNOTATION_ASSET,
            JooqAnnotationTag.ANNOTATION_TAG,
            JooqAnnotationTask.ANNOTATION_TASK,
            JooqAsset.ASSET,
            JooqAssetLocation.ASSET_LOCATION,
            JooqAssetRemix.ASSET_REMIX,
            JooqAssetTask.ASSET_TASK,
            JooqAssetUserMeta.ASSET_USER_META,
            JooqAttachment.ATTACHMENT,
            JooqAttachmentBinary.ATTACHMENT_BINARY,
            JooqBlacklist.BLACKLIST,
            JooqCluster.CLUSTER,
            JooqCollection.COLLECTION,
            JooqCollectionAsset.COLLECTION_ASSET,
            JooqCollectionCluster.COLLECTION_CLUSTER,
            JooqComment.COMMENT,
            JooqEmbedding.EMBEDDING,
            JooqEmbeddingCluster.EMBEDDING_CLUSTER,
            JooqFlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY,
            JooqGroup.GROUP,
            JooqLibrary.LIBRARY,
            JooqLibraryAsset.LIBRARY_ASSET,
            JooqLibraryCollection.LIBRARY_COLLECTION,
            JooqLoom.LOOM,
            JooqProject.PROJECT,
            JooqProjectCollection.PROJECT_COLLECTION,
            JooqProjectLibrary.PROJECT_LIBRARY,
            JooqReaction.REACTION,
            JooqRole.ROLE,
            JooqRoleGroup.ROLE_GROUP,
            JooqRolePermission.ROLE_PERMISSION,
            JooqTag.TAG,
            JooqTagAsset.TAG_ASSET,
            JooqTagCluster.TAG_CLUSTER,
            JooqTagCollection.TAG_COLLECTION,
            JooqTagUserMeta.TAG_USER_META,
            JooqTask.TASK,
            JooqToken.TOKEN,
            JooqTokenPermission.TOKEN_PERMISSION,
            JooqUser.USER,
            JooqUserGroup.USER_GROUP,
            JooqUserPermission.USER_PERMISSION,
            JooqVectorConfig.VECTOR_CONFIG,
            JooqWebhook.WEBHOOK
        );
    }
}
