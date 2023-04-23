CREATE TYPE "loom_extension_type" AS ENUM (
  'ASSET_PROCESSOR',
  'USER_MAPPER'
);

CREATE TYPE "loom_events" AS ENUM (
  'USER_LOGGED_IN',
  'USER_CREATED',
  'USER_UPDATED',
  'USER_DELETED',
  'USER_MAPPED',
  'GROUP_CREATED',
  'GROUP_UPDATED',
  'GROUP_DELETED',
  'ROLE_CREATED',
  'ROLE_UPDATED',
  'ROLE_DELETED',
  'CONTENT_CREATED',
  'CONTENT_UPDATED',
  'CONTENT_DELETED',
  'CONTENT_TAGGED',
  'CONTENT_PUBLISHED',
  'CONTENT_UNPUBLISHED',
  'ASSET_UPLOADED',
  'ASSET_CREATED',
  'ASSET_UPDATED',
  'ASSET_DELETED',
  'ASSET_TAGGED',
  'TAG_CREATED',
  'TAG_DELETED',
  'TAG_UPDATED',
  'NAMESPACE_CREATED',
  'NAMESPACE_UPDATED',
  'NAMESPACE_DELETED',
  'MODEL_CREATED',
  'MODEL_UPDATED',
  'MODEL_DELETED',
  'EXTENSION_CREATED',
  'EXTENSION_DELETED',
  'EXTENSION_UPDATED',
  'WEBHOOK_CREATED',
  'WEBHOOK_DELETED',
  'WEBHOOK_UPDATED'
);

CREATE TYPE "loom_content_type" AS ENUM (
  'D',
  'P',
  'I'
);

CREATE TYPE "state_status" AS ENUM (
  'ACCEPTED',
  'REJECTED',
  'PENDING',
  'REVIEW'
);

CREATE TYPE "loom_permission" AS ENUM (
  'CREATE_CONTENT',
  'READ_CONTENT',
  'UPDATE_CONTENT',
  'DELETE_CONTENT',
  'PUBLISH_CONTENT',
  'UNPUBLISH_CONTENT',
  'LOCK_CONTENT',
  'UNLOCK_CONTENT',
  'CREATE_NAMESPACE',
  'READ_NAMESPACE',
  'UPDATE_NAMESPACE',
  'DELETE_NAMESPACE',
  'CREATE_USER',
  'READ_USER',
  'UPDATE_USER',
  'DELETE_USER',
  'CREATE_GROUP',
  'READ_GROUP',
  'UPDATE_GROUP',
  'DELETE_GROUP',
  'CREATE_ROLE',
  'READ_ROLE',
  'UPDATE_ROLE',
  'DELETE_ROLE',
  'CREATE_TAG',
  'READ_TAG',
  'UPDATE_TAG',
  'DELETE_TAG',
  'CREATE_MODEL',
  'READ_MODEL',
  'UPDATE_MODEL',
  'DELETE_MODEL',
  'CREATE_ASSET',
  'READ_ASSET',
  'UPDATE_ASSET',
  'DELETE_ASSET',
  'UPLOAD_ASSET',
  'DOWNLOAD_ASSET',
  'LOCK_ASSET',
  'UNLOCK_ASSET',
  'CREATE_WEBHOOK',
  'READ_WEBHOOK',
  'UPDATE_WEBHOOK',
  'DELETE_WEBHOOK',
  'CREATE_EXTENSION',
  'READ_EXTENSION',
  'UPDATE_EXTENSION',
  'DELETE_EXTENSION',
  'CREATE_LANGUAGE',
  'READ_LANGUAGE',
  'UPDATE_LANGUAGE',
  'DELETE_LANGUAGE'
);

CREATE TABLE "loom" (
  "db_rev" varchar,
  "last_used_timestamp" timestamp NOT NULL DEFAULT (now())
);

CREATE TABLE "stage" (
  "uuid" SERIAL,
  "name" varchar UNIQUE NOT NULL,
  "enabled" boolean DEFAULT false,
  "meta" varchar,
  "next_stage_uuid" uuid_generate_v4,
  "prev_stage_uuid" uuid_generate_v4,
  "created" timestamp DEFAULT (now()),
  "creator_uuid" uuid,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid_generate_v4,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "stage_assignment" (
  "stage_uuid" uuid_generate_v4 NOT NULL,
  "content_uuid" uuid_generate_v4 NOT NULL,
  "asset_uuid" uuid_generate_v4 NOT NULL,
  "note" varchar,
  "status" stage_status,
  "meta" varchar,
  "created" timestamp DEFAULT (now()),
  "creator_uuid" uuid,
  "reviewed" timestamp DEFAULT (now()),
  "reviewer_uuid" uuid_generate_v4,
  PRIMARY KEY ("stage_uuid")
);

CREATE TABLE "stage_ugr" (
  "stage_uuid" uuid_generate_v4 NOT NULL,
  "user_uuid" uuid_generate_v4,
  "group_uuid" uuid_generate_v4,
  "role_uuid" uuid_generate_v4
);

CREATE TABLE "user" (
  "uuid" SERIAL,
  "username" varchar UNIQUE NOT NULL,
  "firstname" varchar,
  "lastname" varchar,
  "email" varchar,
  "enabled" boolean NOT NULL DEFAULT true,
  "sso" boolean NOT NULL DEFAULT false,
  "meta" varchar,
  "created" timestamp DEFAULT (now()),
  "creator_uuid" uuid,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid_generate_v4,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "token" (
  "uuid" SERIAL,
  "user_uuid" uuid_generate_v4,
  "description" varchar,
  "token" varchar NOT NULL,
  "created" timestamp DEFAULT (now()),
  "meta" varchar,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "role" (
  "uuid" SERIAL,
  "name" varchar UNIQUE NOT NULL,
  "permissions" loom_permission_flag,
  "meta" varchar,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid_generate_v4,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid_generate_v4,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "role_permission" (
  "role_uuid" uuid_generate_v4,
  "resource" varchar NOT NULL,
  "permission" loom_permission,
  PRIMARY KEY ("role_uuid", "resource")
);

CREATE TABLE "user_permission" (
  "user_uuid" uuid_generate_v4,
  "resource" varchar NOT NULL,
  "permission" loom_permission,
  PRIMARY KEY ("user_uuid", "resource")
);

CREATE TABLE "token_permission" (
  "token_uuid" uuid_generate_v4,
  "resource" varchar NOT NULL,
  "permission" loom_permission,
  PRIMARY KEY ("token_uuid", "resource")
);

CREATE TABLE "group" (
  "uuid" SERIAL,
  "name" varchar UNIQUE NOT NULL,
  "meta" varchar,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid_generate_v4,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid_generate_v4,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "role_group" (
  "group_uuid" uuid_generate_v4 NOT NULL,
  "role_uuid" uuid_generate_v4 NOT NULL,
  PRIMARY KEY ("group_uuid", "role_uuid")
);

CREATE TABLE "user_group" (
  "user_uuid" uuid_generate_v4 NOT NULL,
  "group_uuid" uuid_generate_v4 NOT NULL,
  PRIMARY KEY ("user_uuid", "group_uuid")
);

CREATE TABLE "tag" (
  "uuid" SERIAL,
  "name" varchar NOT NULL,
  "collection" varchar NOT NULL,
  "namespace_uuid" uuid_generate_v4 NOT NULL,
  "meta" varchar,
  "rating" int,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid_generate_v4 NOT NULL,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid_generate_v4,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "tag_user_meta" (
  "tag_uuid" uuid_generate_v4 NOT NULL,
  "user_uuid" uuid_generate_v4 NOT NULL,
  "rating" int NOT NULL,
  "meta" varchar
);

CREATE TABLE "tag_namespace" (
  "tag_uuid" uuid_generate_v4 NOT NULL,
  "namespace_uuid" uuid_generate_v4 NOT NULL,
  PRIMARY KEY ("tag_uuid", "namespace_uuid")
);

CREATE TABLE "tag_asset" (
  "tag_uuid" uuid_generate_v4 NOT NULL,
  "asset_uuid" uuid_generate_v4 NOT NULL,
  PRIMARY KEY ("tag_uuid", "asset_uuid")
);

CREATE TABLE "tag_content" (
  "tag_uuid" uuid_generate_v4 NOT NULL,
  "content_uuid" uuid_generate_v4 NOT NULL,
  PRIMARY KEY ("tag_uuid", "content_uuid")
);

CREATE TABLE "asset_binary" (
  "uuid" SERIAL,
  "sha512sum" varchar NOT NULL,
  "size" int NOT NULL,
  "sha256sum" varchar NOT NULL,
  "md5sum" varchar NOT NULL,
  "media_width" int,
  "media_height" int,
  "fingerprint" varchar,
  PRIMARY KEY ("sha512sum")
);

CREATE TABLE "asset" (
  "uuid" SERIAL,
  "asset_binary_uuid" uuid_generate_v4 NOT NULL,
  "namespace_uuid" uuid_generate_v4 NOT NULL,
  "filename" varchar NOT NULL,
  "localPath" varchar,
  "meta" varchar,
  "rating" int,
  "dominantColor" varchar,
  "mimeType" varchar,
  "gps_lon" decimal(9,6),
  "gps_lat" decimal(8,6),
  "state" varchar,
  "locked_by_uuid" uuid_generate_v4,
  "s3_bucket_name" varchar,
  "s3_object_path" varchar,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid_generate_v4 NOT NULL,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid_generate_v4,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "asset_face" (
  "asset_uuid" uuid_generate_v4 NOT NULL,
  "face_uuid" uuid_generate_v4 NOT NULL
);

CREATE TABLE "face" (
  "uuid" SERIAL,
  "meta" varchar,
  "source" varchar,
  "face_nr" int NOT NULL,
  "embeddings" bytea NOT NULL
);

CREATE TABLE "face_cluster" (
  "uuid" SERIAL,
  "name" varchar,
  "description" varchar,
  "meta" varchar
);

CREATE TABLE "asset_collection" (
  "asset_uuid" uuid_generate_v4 NOT NULL,
  "collection_uuid" uuid_generate_v4 NOT NULL
);

CREATE TABLE "reaction" (
  "type" varchar
);

CREATE TABLE "comment" (
  "uuid" SERIAL,
  "content" varchar,
  "user_uuid" uuid_generate_v4,
  "created" varchar,
  "parent_uuid" uuid_generate_v4
);

CREATE TABLE "annotation" (
  "uuid" SERIAL,
  "creator_uuid" uuid_generate_v4,
  "created" timestamp DEFAULT (now()),
  "description" varchar,
  "from" int,
  "to" int,
  "area" varchar,
  "meta" jsonb,
  "kind" varchar
);

CREATE TABLE "task" (
  "uuid" SERIAL,
  "content" varchar,
  "created" timestamp DEFAULT (now()),
  "due_date" timestamp DEFAULT (now())
);

CREATE TABLE "task_comment" (
  "task_uuid" uuid_generate_v4 NOT NULL,
  "comment_uuid" uuid_generate_v4 NOT NULL
);

CREATE TABLE "annotation_task" (
  "asset_uuid" uuid_generate_v4 NOT NULL,
  "task_uuid" uuid_generate_v4 NOT NULL
);

CREATE TABLE "collection" (
  "uuid" SERIAL,
  "name" varchar UNIQUE NOT NULL,
  "meta" varchar,
  "description" varchar,
  "tags" varchar,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "asset_user_meta" (
  "asset_uuid" uuid_generate_v4 NOT NULL,
  "user_uuid" uuid_generate_v4 NOT NULL,
  "rating" int,
  "meta" varchar,
  PRIMARY KEY ("asset_uuid", "user_uuid")
);

CREATE TABLE "asset_timeline" (
  "uuid" SERIAL,
  "asset_uuid" uuid_generate_v4 NOT NULL,
  "from" int NOT NULL,
  "to" int NOT NULL,
  "description" varchar,
  "tags" varchar,
  "meta" varchar,
  "thumbail" varchar,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "asset_timeline_tag" (
  "assettimeline_uuid" uuid_generate_v4 NOT NULL,
  "tag_uuid" uuid_generate_v4 NOT NULL
);

CREATE TABLE "content" (
  "uuid" SERIAL,
  "namespace_uuid" uuid_generate_v4 NOT NULL,
  "parent" uuid_generate_v4,
  "meta" varchar,
  "state" varchar,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid_generate_v4 NOT NULL,
  "model_uuid" uuid_generate_v4 NOT NULL,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "content_tree" (
  "content_uuid" uuid_generate_v4 NOT NULL,
  "language" varchar,
  "content_type" loom_content_type NOT NULL,
  "field_uuid" uuid_generate_v4 NOT NULL,
  "meta" varchar,
  "webroot_path_info" varchar UNIQUE,
  PRIMARY KEY ("content_uuid", "field_uuid")
);

CREATE TABLE "content_user_meta" (
  "content_uuid" uuid_generate_v4 NOT NULL,
  "user_uuid" uuid_generate_v4 NOT NULL,
  "rating" int NOT NULL,
  "meta" varchar,
  PRIMARY KEY ("content_uuid", "user_uuid")
);

CREATE TABLE "field_reference" (
  "source_uuid" uuid_generate_v4 NOT NULL,
  "target_uuid" uuid_generate_v4 NOT NULL,
  "field_name" varchar NOT NULL,
  PRIMARY KEY ("source_uuid", "target_uuid")
);

CREATE TABLE "field_content" (
  "fields_uuid" uuid_generate_v4 NOT NULL,
  "content_uuid" uuid_generate_v4,
  "state" varchar,
  "webroot_path_info" varchar UNIQUE
);

CREATE TABLE "field" (
  "uuid" SERIAL,
  "content_uuid" uuid_generate_v4,
  "fields_json" varchar,
  "language_uuid" uuid_generate_v4,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid_generate_v4,
  "modelversion_uuid" uuid_generate_v4,
  "version" int,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "field_asset" (
  "field_uuid" uuid_generate_v4,
  "asset_uuid" uuid_generate_v4,
  "field_name" varchar,
  PRIMARY KEY ("field_uuid", "asset_uuid")
);

CREATE TABLE "namespace" (
  "uuid" SERIAL,
  "name" varchar UNIQUE NOT NULL,
  "root_content_uuid" uuid_generate_v4,
  "meta" varchar,
  "path_prefix" varchar,
  "model_filters" varchar,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid NOT NULL,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid_generate_v4,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "model" (
  "uuid" SERIAL,
  "name" varchar UNIQUE NOT NULL,
  "latest_version_uuid" uuid_generate_v4,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid NOT NULL,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid_generate_v4,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "model_version" (
  "uuid" SERIAL,
  "model_uuid" uuid_generate_v4,
  "json" varchar NOT NULL,
  "next_version_uuid" uuid_generate_v4,
  "prev_version_uuid" uuid_generate_v4,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "language" (
  "uuid" SERIAL,
  "native_name" varchar NOT NULL,
  "tag" varchar UNIQUE NOT NULL,
  "meta" varchar,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "extension" (
  "uuid" SERIAL,
  "url" varchar NOT NULL,
  "kind" loom_extension_type,
  "status" varchar,
  "meta" varchar,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid_generate_v4 NOT NULL,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid_generate_v4,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "webhook" (
  "uuid" SERIAL,
  "url" varchar NOT NULL,
  "status" varchar,
  "active" boolean NOT NULL DEFAULT true,
  "triggers" loom_events,
  "secretToken" varchar,
  "meta" varchar,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid_generate_v4 NOT NULL,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid_generate_v4,
  PRIMARY KEY ("uuid")
);

CREATE UNIQUE INDEX ON "stage" ("name");

CREATE INDEX ON "stage_assignment" ("stage_uuid", "content_uuid");

CREATE INDEX ON "stage_assignment" ("stage_uuid", "asset_uuid");

CREATE UNIQUE INDEX ON "user" ("username");

CREATE UNIQUE INDEX ON "token" ("token");

CREATE INDEX ON "token" ("user_uuid");

CREATE UNIQUE INDEX ON "role" ("name");

CREATE UNIQUE INDEX ON "group" ("name");

CREATE UNIQUE INDEX ON "tag" ("name", "collection", "namespace_uuid");

CREATE UNIQUE INDEX ON "asset" ("uuid", "namespace_uuid");

CREATE INDEX ON "content_tree" ("content_uuid", "content_type");

CREATE INDEX ON "content_tree" ("content_type", "webroot_path_info");

CREATE UNIQUE INDEX ON "namespace" ("name");

CREATE UNIQUE INDEX ON "model" ("name");

CREATE INDEX ON "language" ("tag");

COMMENT ON TABLE "stage" IS 'Stages can be used to create workflow processes for contents.';

COMMENT ON COLUMN "stage"."meta" IS 'Custom meta properties';

COMMENT ON TABLE "stage_assignment" IS 'This crosstable tracks the stage elements';

COMMENT ON COLUMN "stage_assignment"."note" IS 'Added description by the reviewer';

COMMENT ON COLUMN "stage_assignment"."meta" IS 'Additional meta properties for the stage assignment';

COMMENT ON TABLE "stage_ugr" IS 'This table keeps track of the user/group/role stage assignment';

COMMENT ON COLUMN "user"."enabled" IS 'Flag to enable or disable the user.';

COMMENT ON COLUMN "user"."sso" IS 'Flag that indicates that the user was created via SSO mappings';

COMMENT ON COLUMN "user"."meta" IS 'Custom meta properties to the element';

COMMENT ON COLUMN "token"."meta" IS 'Custom meta properties to the element';

COMMENT ON COLUMN "role"."meta" IS 'Custom meta properties to the element';

COMMENT ON COLUMN "role_permission"."permission" IS 'Permission granted / granted to the resource';

COMMENT ON COLUMN "user_permission"."permission" IS 'Permission granted / granted to the resource';

COMMENT ON COLUMN "token_permission"."permission" IS 'Permission granted / granted to the resource';

COMMENT ON COLUMN "group"."meta" IS 'Custom meta properties to the element';

COMMENT ON COLUMN "tag"."meta" IS 'Custom meta properties to the element';

COMMENT ON COLUMN "tag"."rating" IS 'Absolute or buffered/precomputed rating information';

COMMENT ON COLUMN "tag_user_meta"."rating" IS 'Rating of the tag by the user';

COMMENT ON COLUMN "tag_user_meta"."meta" IS 'Custom meta properties';

COMMENT ON TABLE "tag_namespace" IS 'Table used to taggings on namespaces';

COMMENT ON TABLE "tag_asset" IS 'Table used to taggings on assets';

COMMENT ON TABLE "asset_binary" IS 'This table stores the immutable asset information';

COMMENT ON COLUMN "asset_binary"."media_width" IS 'Only set for images';

COMMENT ON COLUMN "asset_binary"."media_height" IS 'Only set for images';

COMMENT ON COLUMN "asset_binary"."fingerprint" IS 'Media fingerprint information';

COMMENT ON COLUMN "asset"."localPath" IS 'Local path to the asset (when using the local path feature)';

COMMENT ON COLUMN "asset"."meta" IS 'Custom meta properties to the element';

COMMENT ON COLUMN "asset"."rating" IS 'Absolute or computed asset rating';

COMMENT ON COLUMN "face"."meta" IS 'Custom meta properties to the face.';

COMMENT ON COLUMN "face"."source" IS 'Source information (e.g.: frame of the media from which the face was extracted).';

COMMENT ON COLUMN "face"."face_nr" IS 'When the source contains more than one face the id can be used to identify them.';

COMMENT ON COLUMN "face"."embeddings" IS 'Actual embedding data';

COMMENT ON COLUMN "face_cluster"."name" IS 'Name of the cluster';

COMMENT ON COLUMN "face_cluster"."description" IS 'Description of the cluster';

COMMENT ON COLUMN "face_cluster"."meta" IS 'Custom meta properties to the cluster.';

COMMENT ON COLUMN "reaction"."type" IS 'Type of the reaction';

COMMENT ON COLUMN "comment"."content" IS 'Comment text';

COMMENT ON COLUMN "comment"."created" IS 'Creation timestamp';

COMMENT ON COLUMN "annotation"."meta" IS 'Custom meta properties';

COMMENT ON COLUMN "annotation"."kind" IS 'Type of the annotation';

COMMENT ON COLUMN "task"."content" IS 'Description of the task';

COMMENT ON TABLE "collection" IS 'Collections are used to group assets together';

COMMENT ON COLUMN "collection"."meta" IS 'Custom meta properties';

COMMENT ON COLUMN "asset_user_meta"."rating" IS 'Asset rating by the user';

COMMENT ON COLUMN "asset_user_meta"."meta" IS 'Custom meta properties';

COMMENT ON TABLE "asset_timeline" IS 'This table contains asset timeline entries';

COMMENT ON COLUMN "content"."parent" IS 'Reference to the parent content.';

COMMENT ON COLUMN "content"."meta" IS 'Custom meta properties';

COMMENT ON TABLE "content_tree" IS 'This table keeps track of the content publish status';

COMMENT ON COLUMN "content_tree"."content_type" IS 'D or P for draft and published';

COMMENT ON COLUMN "content_tree"."meta" IS 'Custom meta properties';

COMMENT ON COLUMN "content_user_meta"."rating" IS 'Rating of the content by the user';

COMMENT ON COLUMN "content_user_meta"."meta" IS 'Custom meta properties';

COMMENT ON TABLE "field_reference" IS 'This table is mainly used to lookup foreign references to contents';

COMMENT ON COLUMN "field_reference"."field_name" IS 'Name of the field in which the content reference was listed.';

COMMENT ON TABLE "field_content" IS 'Crosstable that tracks all fields for a content';

COMMENT ON COLUMN "field_content"."webroot_path_info" IS 'The path info contains a unique path to the content. It may thus also be parentUuid+language+namespace+path specific.';

COMMENT ON TABLE "field" IS 'Table which stores the actual fields content as JSON';

COMMENT ON COLUMN "field"."content_uuid" IS 'Reference to the content that uses this fields record';

COMMENT ON COLUMN "field"."fields_json" IS 'JSON which contains the actual fields content';

COMMENT ON TABLE "field_asset" IS 'Crosstable which tracks the used assets in a fields record';

COMMENT ON COLUMN "namespace"."meta" IS 'Custom meta properties to the element';

COMMENT ON COLUMN "namespace"."path_prefix" IS 'Prefix for webroot paths';

COMMENT ON COLUMN "namespace"."model_filters" IS 'filter for models that can be used in the namespace';

COMMENT ON COLUMN "model"."name" IS 'Human readable name of the content model';

COMMENT ON TABLE "language" IS 'Table which stores the languages for loom';

COMMENT ON COLUMN "language"."meta" IS 'Custom meta properties to the element';

COMMENT ON TABLE "extension" IS 'Table which lists the registered extensions';

COMMENT ON COLUMN "extension"."kind" IS 'Defines the type of the extension service';

COMMENT ON COLUMN "extension"."meta" IS 'Custom meta properties to the element';

COMMENT ON TABLE "webhook" IS 'Table which stores the registered webhooks';

COMMENT ON COLUMN "webhook"."triggers" IS 'List of triggers which can invoke the webhook';

COMMENT ON COLUMN "webhook"."secretToken" IS 'Secret token which webhook services can use to authenticate the request.';

COMMENT ON COLUMN "webhook"."meta" IS 'Custom meta properties to the element';

ALTER TABLE "stage" ADD FOREIGN KEY ("next_stage_uuid") REFERENCES "stage" ("uuid");

ALTER TABLE "stage" ADD FOREIGN KEY ("prev_stage_uuid") REFERENCES "stage" ("uuid");

ALTER TABLE "stage" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "stage" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "stage_assignment" ADD FOREIGN KEY ("stage_uuid") REFERENCES "stage" ("uuid");

ALTER TABLE "stage_assignment" ADD FOREIGN KEY ("content_uuid") REFERENCES "content" ("uuid");

ALTER TABLE "stage_assignment" ADD FOREIGN KEY ("asset_uuid") REFERENCES "asset" ("uuid");

ALTER TABLE "stage_assignment" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "stage_assignment" ADD FOREIGN KEY ("reviewer_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "stage_ugr" ADD FOREIGN KEY ("stage_uuid") REFERENCES "stage" ("uuid");

ALTER TABLE "user" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "user" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "token" ADD FOREIGN KEY ("user_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "role" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "role" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "role_permission" ADD FOREIGN KEY ("role_uuid") REFERENCES "role" ("uuid");

ALTER TABLE "user_permission" ADD FOREIGN KEY ("user_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "token_permission" ADD FOREIGN KEY ("token_uuid") REFERENCES "token" ("uuid");

ALTER TABLE "group" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "group" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "role_group" ADD FOREIGN KEY ("group_uuid") REFERENCES "group" ("uuid");

ALTER TABLE "role_group" ADD FOREIGN KEY ("role_uuid") REFERENCES "role" ("uuid");

ALTER TABLE "user_group" ADD FOREIGN KEY ("user_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "user_group" ADD FOREIGN KEY ("group_uuid") REFERENCES "group" ("uuid");

ALTER TABLE "tag" ADD FOREIGN KEY ("namespace_uuid") REFERENCES "namespace" ("uuid");

ALTER TABLE "tag" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "tag" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "tag_user_meta" ADD FOREIGN KEY ("tag_uuid") REFERENCES "tag" ("uuid");

ALTER TABLE "tag_user_meta" ADD FOREIGN KEY ("user_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "tag_namespace" ADD FOREIGN KEY ("tag_uuid") REFERENCES "tag" ("uuid");

ALTER TABLE "tag_namespace" ADD FOREIGN KEY ("namespace_uuid") REFERENCES "namespace" ("uuid");

ALTER TABLE "tag_asset" ADD FOREIGN KEY ("tag_uuid") REFERENCES "tag" ("uuid");

ALTER TABLE "tag_asset" ADD FOREIGN KEY ("asset_uuid") REFERENCES "asset" ("uuid");

ALTER TABLE "tag_content" ADD FOREIGN KEY ("tag_uuid") REFERENCES "tag" ("uuid");

ALTER TABLE "tag_content" ADD FOREIGN KEY ("content_uuid") REFERENCES "content" ("uuid");

ALTER TABLE "asset" ADD FOREIGN KEY ("asset_binary_uuid") REFERENCES "asset_binary" ("uuid");

ALTER TABLE "asset" ADD FOREIGN KEY ("namespace_uuid") REFERENCES "namespace" ("uuid");

ALTER TABLE "asset" ADD FOREIGN KEY ("locked_by_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "asset" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "asset" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "asset_face" ADD FOREIGN KEY ("asset_uuid") REFERENCES "asset" ("uuid");

ALTER TABLE "asset_face" ADD FOREIGN KEY ("face_uuid") REFERENCES "face" ("uuid");

ALTER TABLE "asset_collection" ADD FOREIGN KEY ("asset_uuid") REFERENCES "asset" ("uuid");

ALTER TABLE "asset_collection" ADD FOREIGN KEY ("collection_uuid") REFERENCES "collection" ("uuid");

ALTER TABLE "comment" ADD FOREIGN KEY ("user_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "comment" ADD FOREIGN KEY ("parent_uuid") REFERENCES "comment" ("uuid");

ALTER TABLE "annotation" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "task_comment" ADD FOREIGN KEY ("task_uuid") REFERENCES "task" ("uuid");

ALTER TABLE "task_comment" ADD FOREIGN KEY ("comment_uuid") REFERENCES "comment" ("uuid");

ALTER TABLE "annotation_task" ADD FOREIGN KEY ("asset_uuid") REFERENCES "asset" ("uuid");

ALTER TABLE "annotation_task" ADD FOREIGN KEY ("task_uuid") REFERENCES "task" ("uuid");

ALTER TABLE "asset_user_meta" ADD FOREIGN KEY ("asset_uuid") REFERENCES "asset" ("uuid");

ALTER TABLE "asset_user_meta" ADD FOREIGN KEY ("user_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "asset_timeline" ADD FOREIGN KEY ("asset_uuid") REFERENCES "asset" ("uuid");

ALTER TABLE "asset_timeline_tag" ADD FOREIGN KEY ("assettimeline_uuid") REFERENCES "asset_timeline" ("uuid");

ALTER TABLE "asset_timeline_tag" ADD FOREIGN KEY ("tag_uuid") REFERENCES "tag" ("uuid");

ALTER TABLE "content" ADD FOREIGN KEY ("namespace_uuid") REFERENCES "namespace" ("uuid");

ALTER TABLE "content" ADD FOREIGN KEY ("parent") REFERENCES "content" ("uuid");

ALTER TABLE "content" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "content" ADD FOREIGN KEY ("model_uuid") REFERENCES "model" ("uuid");

ALTER TABLE "content_tree" ADD FOREIGN KEY ("content_uuid") REFERENCES "content" ("uuid");

ALTER TABLE "content_tree" ADD FOREIGN KEY ("field_uuid") REFERENCES "field" ("uuid");

ALTER TABLE "content_user_meta" ADD FOREIGN KEY ("content_uuid") REFERENCES "content" ("uuid");

ALTER TABLE "content_user_meta" ADD FOREIGN KEY ("user_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "field_reference" ADD FOREIGN KEY ("source_uuid") REFERENCES "field" ("uuid");

ALTER TABLE "field_reference" ADD FOREIGN KEY ("target_uuid") REFERENCES "field" ("uuid");

ALTER TABLE "field_content" ADD FOREIGN KEY ("fields_uuid") REFERENCES "field" ("uuid");

ALTER TABLE "field_content" ADD FOREIGN KEY ("content_uuid") REFERENCES "content" ("uuid");

ALTER TABLE "field" ADD FOREIGN KEY ("content_uuid") REFERENCES "namespace" ("uuid");

ALTER TABLE "field" ADD FOREIGN KEY ("language_uuid") REFERENCES "language" ("uuid");

ALTER TABLE "field" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "field" ADD FOREIGN KEY ("modelversion_uuid") REFERENCES "model_version" ("uuid");

ALTER TABLE "field_asset" ADD FOREIGN KEY ("field_uuid") REFERENCES "field" ("uuid");

ALTER TABLE "field_asset" ADD FOREIGN KEY ("asset_uuid") REFERENCES "asset" ("uuid");

ALTER TABLE "namespace" ADD FOREIGN KEY ("root_content_uuid") REFERENCES "content" ("uuid");

ALTER TABLE "namespace" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "namespace" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "model" ADD FOREIGN KEY ("latest_version_uuid") REFERENCES "model_version" ("uuid");

ALTER TABLE "model" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "model" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "model_version" ADD FOREIGN KEY ("model_uuid") REFERENCES "model" ("uuid");

ALTER TABLE "model_version" ADD FOREIGN KEY ("next_version_uuid") REFERENCES "model_version" ("uuid");

ALTER TABLE "model_version" ADD FOREIGN KEY ("prev_version_uuid") REFERENCES "model_version" ("uuid");

ALTER TABLE "extension" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "extension" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "webhook" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "webhook" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "asset" ADD FOREIGN KEY ("created") REFERENCES "asset" ("edited");

ALTER TABLE "stage_assignment" ADD FOREIGN KEY ("status") REFERENCES "stage_assignment" ("meta");

ALTER TABLE "collection" ADD FOREIGN KEY ("uuid") REFERENCES "collection" ("description");

ALTER TABLE "model" ADD FOREIGN KEY ("creator_uuid") REFERENCES "asset_timeline" ("description");
