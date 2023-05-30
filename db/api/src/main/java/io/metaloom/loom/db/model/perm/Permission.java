package io.metaloom.loom.db.model.perm;

public enum Permission {

	// Annotation
	CREATE_ANNOTATION, READ_ANNOTATION, DELETE_ANNOTATION, UPDATE_ANNOTATION,

	// Asset
	CREATE_ASSET, READ_ASSET, DELETE_ASSET, UPDATE_ASSET,

	// Asset Location
	CREATE_ASSET_LOCATION, READ_ASSET_LOCATION, DELETE_ASSET_LOCATION, UPDATE_ASSET_LOCATION,

	// Attachment
	CREATE_ATTACHMENT, READ_ATTACHMENT, DELETE_ATTACHMENT, UPDATE_ATTACHMENT,

	// User
	CREATE_USER, READ_USER, DELETE_USER, UPDATE_USER,

	// Role
	CREATE_ROLE, READ_ROLE, DELETE_ROLE, UPDATE_ROLE,

	// Group
	CREATE_GROUP, READ_GROUP, DELETE_GROUP, UPDATE_GROUP,

	// Project
	CREATE_PROJECT, READ_PROJECT, DELETE_PROJECT, UPDATE_PROJECT,

	// Cluster
	CREATE_CLUSTER, READ_CLUSTER, DELETE_CLUSTER, UPDATE_CLUSTER,

	// Collection
	CREATE_COLLECTION, READ_COLLECTION, DELETE_COLLECTION, UPDATE_COLLECTION,

	// Comment
	CREATE_COMMENT, READ_COMMENT, DELETE_COMMENT, UPDATE_COMMENT,

	// Embedding
	CREATE_EMBEDDING, READ_EMBEDDING, DELETE_EMBEDDING, UPDATE_EMBEDDING,

	// Reaction
	CREATE_REACTION, READ_REACTION, DELETE_REACTION, UPDATE_REACTION,

	// Task
	CREATE_TASK, READ_TASK, DELETE_TASK, UPDATE_TASK,

	// Tag
	CREATE_TAG, READ_TAG, DELETE_TAG, UPDATE_TAG,

	TAG_ASSET, UNTAG_ASSET,

	// Token
	CREATE_TOKEN, READ_TOKEN, DELETE_TOKEN, UPDATE_TOKEN,

	// WebHook
	CREATE_WEBHOOK, READ_WEBHOOK, DELETE_WEBHOOK, UPDATE_WEBHOOK,

	// Library
	CREATE_LIBRARY, READ_LIBRARY, DELETE_LIBRARY, UPDATE_LIBRARY;

}
