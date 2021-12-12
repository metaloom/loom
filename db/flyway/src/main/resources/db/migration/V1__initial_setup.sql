
/*
Enable UUID V4 Support
*/
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TYPE "loom_extension_type" AS ENUM (
  'ASSET_PROCESSOR',
  'USER_MAPPER'
);

CREATE TYPE "loom_event" AS ENUM (
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

CREATE TYPE "loom_permission_flag" AS ENUM (
  'CREATE_CONTENT',
  'READ_CONTENT',
  'UPDATE_CONTENT',
  'DELETE_CONTENT',
  'PUBLISH_CONTENT',
  'UNPUBLISH_CONTENT',
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

CREATE TABLE "user" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "username" varchar UNIQUE NOT NULL,
  "firstname" varchar,
  "lastname" varchar,
  "passwordhash" varchar,
  "email" varchar,
  "enabled" boolean NOT NULL DEFAULT true,
  "sso" boolean NOT NULL DEFAULT false,
  "meta" jsonb,
  "permissions" loom_permission_flag,
  "created" timestamp DEFAULT (now()),
  "creator_uuid" uuid,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "user_token" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "user_uuid" uuid,
  "note" varchar,
  "token" varchar NOT NULL,
  "permissions" loom_permission_flag,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "role" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "name" varchar UNIQUE NOT NULL,
  "permissions" loom_permission_flag,
  "meta" jsonb,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid NOT NULL,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "role_permission" (
  "role_uuid" uuid,
  "element_uuid" uuid NOT NULL,
  "create_perm" boolean NOT NULL DEFAULT false,
  "read_perm" boolean NOT NULL DEFAULT false,
  "delete_perm" boolean NOT NULL DEFAULT false,
  "update_perm" boolean NOT NULL DEFAULT false,
  "read_publish_perm" boolean NOT NULL DEFAULT false,
  "publish_perm" boolean NOT NULL DEFAULT false,
  PRIMARY KEY ("role_uuid", "element_uuid")
);

CREATE TABLE "group" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "name" varchar UNIQUE NOT NULL,
  "meta" jsonb,
  "created" timestamp DEFAULT (now()),
  "creator_uuid" uuid,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "role_group" (
  "group_uuid" uuid NOT NULL,
  "role_uuid" uuid NOT NULL,
  PRIMARY KEY ("group_uuid", "role_uuid")
);

CREATE TABLE "user_group" (
  "user_uuid" uuid NOT NULL,
  "group_uuid" uuid NOT NULL,
  PRIMARY KEY ("user_uuid", "group_uuid")
);

CREATE TABLE "tag" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "name" varchar NOT NULL,
  "collection" varchar NOT NULL,
  "namespace_uuid" uuid NOT NULL,
  "meta" jsonb,
  "rating" int,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid NOT NULL,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "tag_user_meta" (
  "tag_uuid" uuid NOT NULL,
  "user_uuid" uuid NOT NULL,
  "rating" int NOT NULL,
  "meta" jsonb
);

CREATE TABLE "tag_namespace" (
  "tag_uuid" uuid NOT NULL,
  "namespace_uuid" uuid NOT NULL,
  PRIMARY KEY ("tag_uuid", "namespace_uuid")
);

CREATE TABLE "tag_asset" (
  "tag_uuid" uuid NOT NULL,
  "asset_uuid" uuid NOT NULL,
  PRIMARY KEY ("tag_uuid", "asset_uuid")
);

CREATE TABLE "tag_content" (
  "tag_uuid" uuid NOT NULL,
  "content_uuid" uuid NOT NULL,
  PRIMARY KEY ("tag_uuid", "content_uuid")
);

CREATE TABLE "asset_binarie" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "sha512sum" varchar NOT NULL,
  "size" bigint NOT NULL,
  "sha256sum" varchar NOT NULL,
  "md5sum" varchar NOT NULL,
  "media_width" int,
  "media_height" int,
  "fingerprint" varchar,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "asset" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "asset_binaries_uuid" uuid NOT NULL,
  "namespace_uuid" uuid NOT NULL,
  "filename" varchar NOT NULL,
  "localPath" varchar,
  "meta" jsonb,
  "rating" int,
  "dominantColor" varchar,
  "mimeType" varchar,
  "gps_lon" decimal(9,6),
  "gps_lat" decimal(8,6),
  "s3_bucket_name" varchar,
  "s3_object_path" varchar,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid NOT NULL,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "asset_user_meta" (
  "asset_uuid" uuid NOT NULL,
  "user_uuid" uuid NOT NULL,
  "rating" int,
  "meta" jsonb,
  PRIMARY KEY ("asset_uuid", "user_uuid")
);

CREATE TABLE "asset_timeline" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "asset_uuid" uuid NOT NULL,
  "from" int NOT NULL,
  "to" int NOT NULL,
  "description" varchar,
  "tags" varchar,
  "meta" jsonb,
  "thumbail" varchar,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "asset_timeline_tag" (
  "assettimeline_uuid" uuid NOT NULL,
  "tag_uuid" uuid NOT NULL
);

CREATE TABLE "content" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "namespace_uuid" uuid NOT NULL,
  "parent" uuid,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid NOT NULL,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid,
  "meta" jsonb,
  "model_uuid" uuid NOT NULL,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "content_user_meta" (
  "content_uuid" uuid NOT NULL,
  "user_uuid" uuid NOT NULL,
  "rating" int NOT NULL,
  "meta" jsonb,
  PRIMARY KEY ("content_uuid", "user_uuid")
);

CREATE TABLE "field_reference" (
  "source_uuid" uuid NOT NULL,
  "target_uuid" uuid NOT NULL,
  "field_name" varchar NOT NULL,
  PRIMARY KEY ("source_uuid", "target_uuid")
);

CREATE TABLE "field_content" (
  "fields_uuid" uuid NOT NULL,
  "content_uuid" uuid,
  "webroot_path_info" varchar UNIQUE,
  "content_type" loom_content_type NOT NULL
);

CREATE TABLE "field" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "content_uuid" uuid,
  "fields_json" jsonb,
  "language_uuid" uuid,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid,
  "modelversion_uuid" uuid,
  "version" int,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "field_asset" (
  "field_uuid" uuid,
  "asset_uuid" uuid,
  "field_name" varchar,
  PRIMARY KEY ("field_uuid", "asset_uuid")
);

CREATE TABLE "namespace" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "name" varchar UNIQUE NOT NULL,
  "root_content_uuid" uuid,
  "meta" jsonb,
  "path_prefix" varchar,
  "model_filter" varchar,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "model" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "name" varchar UNIQUE NOT NULL,
  "latest_version_uuid" uuid,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid NOT NULL,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "model_version" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "model_uuid" uuid,
  "json" varchar NOT NULL,
  "next_version_uuid" uuid,
  "prev_version_uuid" uuid,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "language" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "native_name" varchar NOT NULL,
  "tag" varchar UNIQUE NOT NULL,
  "meta" jsonb,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "extension" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "url" varchar NOT NULL,
  "kind" loom_extension_type,
  "status" varchar,
  "meta" jsonb,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid NOT NULL,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "webhook" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "url" varchar NOT NULL,
  "status" varchar,
  "active" boolean NOT NULL DEFAULT true,
  "trigger" loom_event,
  "secretToken" varchar,
  "meta" jsonb,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid NOT NULL,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid,
  PRIMARY KEY ("uuid")
);

ALTER TABLE "user" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "user" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "user_token" ADD FOREIGN KEY ("user_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "role" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "role" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "role_permission" ADD FOREIGN KEY ("role_uuid") REFERENCES "role" ("uuid");

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

ALTER TABLE "tag_content" ADD FOREIGN KEY ("tag_uuid") REFERENCES "tag" ("uuid");

ALTER TABLE "tag_content" ADD FOREIGN KEY ("content_uuid") REFERENCES "content" ("uuid");

ALTER TABLE "asset" ADD FOREIGN KEY ("asset_binaries_uuid") REFERENCES "asset_binarie" ("uuid");

ALTER TABLE "asset" ADD FOREIGN KEY ("namespace_uuid") REFERENCES "namespace" ("uuid");

ALTER TABLE "asset" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "asset" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "asset_user_meta" ADD FOREIGN KEY ("asset_uuid") REFERENCES "asset" ("uuid");

ALTER TABLE "asset_user_meta" ADD FOREIGN KEY ("user_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "asset_timeline" ADD FOREIGN KEY ("asset_uuid") REFERENCES "asset" ("uuid");

ALTER TABLE "asset_timeline_tag" ADD FOREIGN KEY ("assettimeline_uuid") REFERENCES "asset_timeline" ("uuid");

ALTER TABLE "asset_timeline_tag" ADD FOREIGN KEY ("tag_uuid") REFERENCES "tag" ("uuid");

ALTER TABLE "content" ADD FOREIGN KEY ("namespace_uuid") REFERENCES "namespace" ("uuid");

ALTER TABLE "content" ADD FOREIGN KEY ("parent") REFERENCES "content" ("uuid");

ALTER TABLE "content" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "content" ADD FOREIGN KEY ("model_uuid") REFERENCES "model" ("uuid");

ALTER TABLE "content_user_meta" ADD FOREIGN KEY ("content_uuid") REFERENCES "tag" ("uuid");

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

CREATE UNIQUE INDEX ON "user" ("username");

CREATE INDEX ON "user_token" ("user_uuid");

CREATE UNIQUE INDEX ON "role" ("name");

CREATE UNIQUE INDEX ON "group" ("name");

CREATE UNIQUE INDEX ON "tag" ("name", "collection", "namespace_uuid");

CREATE UNIQUE INDEX ON "asset" ("uuid", "namespace_uuid");

CREATE INDEX ON "field_content" ("content_uuid", "content_type");

CREATE INDEX ON "field_content" ("content_type", "webroot_path_info");

CREATE UNIQUE INDEX ON "namespace" ("name");

CREATE UNIQUE INDEX ON "model" ("name");

CREATE INDEX ON "language" ("tag");

COMMENT ON COLUMN "user"."enabled" IS 'Flag to enable or disable the user.';

COMMENT ON COLUMN "user"."sso" IS 'Flag that indicates that the user was created via SSO mappings';

COMMENT ON COLUMN "user"."meta" IS 'Custom meta properties to the element';

COMMENT ON COLUMN "role"."meta" IS 'Custom meta properties to the element';

COMMENT ON COLUMN "group"."meta" IS 'Custom meta properties to the element';

COMMENT ON COLUMN "tag"."meta" IS 'Custom meta properties to the element';

COMMENT ON COLUMN "tag"."rating" IS 'Absolute or buffered/precomputed rating information';

COMMENT ON COLUMN "tag_user_meta"."rating" IS 'Rating of the tag by the user';

COMMENT ON COLUMN "tag_user_meta"."meta" IS 'Custom meta properties';

COMMENT ON TABLE "tag_namespace" IS 'Table used to taggings on namespaces';

COMMENT ON TABLE "asset_binarie" IS 'This table stores the immutable asset information';

COMMENT ON COLUMN "asset_binarie"."media_width" IS 'Only set for images';

COMMENT ON COLUMN "asset_binarie"."media_height" IS 'Only set for images';

COMMENT ON COLUMN "asset_binarie"."fingerprint" IS 'Media fingerprint information';

COMMENT ON COLUMN "asset"."localPath" IS 'Local path to the asset (when using the local path feature)';

COMMENT ON COLUMN "asset"."meta" IS 'Custom meta properties to the element';

COMMENT ON COLUMN "asset"."rating" IS 'Absolute or computed asset rating';

COMMENT ON COLUMN "asset_user_meta"."rating" IS 'Asset rating by the user';

COMMENT ON COLUMN "asset_user_meta"."meta" IS 'Custom meta properties';

COMMENT ON TABLE "asset_timeline" IS 'This table contains asset timeline entries';

COMMENT ON COLUMN "content"."parent" IS 'Reference to the parent content.';

COMMENT ON COLUMN "content_user_meta"."rating" IS 'Rating of the content by the user';

COMMENT ON COLUMN "content_user_meta"."meta" IS 'Custom meta properties';

COMMENT ON TABLE "field_reference" IS 'This table is mainly used to lookup foreign references to contents';

COMMENT ON COLUMN "field_reference"."field_name" IS 'Name of the field in which the content reference was listed.';

COMMENT ON TABLE "field_content" IS 'Crosstable that tracks all fields for a content';

COMMENT ON COLUMN "field_content"."webroot_path_info" IS 'prefixed with branch';

COMMENT ON COLUMN "field_content"."content_type" IS 'D or P for draft and published';

COMMENT ON TABLE "field" IS 'Table which stores the actual fields content as JSON';

COMMENT ON COLUMN "field"."content_uuid" IS 'Reference to the content that uses this fields record';

COMMENT ON COLUMN "field"."fields_json" IS 'JSON which contains the actual fields content';

COMMENT ON TABLE "field_asset" IS 'Crosstable which tracks the used assets in a fields record';

COMMENT ON COLUMN "namespace"."meta" IS 'Custom meta properties to the element';

COMMENT ON COLUMN "namespace"."path_prefix" IS 'Prefix for webroot paths';

COMMENT ON COLUMN "namespace"."model_filter" IS 'filter for models that can be used in the namespace';

COMMENT ON COLUMN "model"."name" IS 'Human readable name of the content model';

COMMENT ON TABLE "language" IS 'Table which stores the languages for loom';

COMMENT ON COLUMN "language"."meta" IS 'Custom meta properties to the element';

COMMENT ON TABLE "extension" IS 'Table which lists the registered extensions';

COMMENT ON COLUMN "extension"."kind" IS 'Defines the type of the extension service';

COMMENT ON COLUMN "extension"."meta" IS 'Custom meta properties to the element';

COMMENT ON TABLE "webhook" IS 'Table which stores the registered webhooks';

COMMENT ON COLUMN "webhook"."trigger" IS 'List of triggers which can invoke the webhook';

COMMENT ON COLUMN "webhook"."secretToken" IS 'Secret token which webhook services can use to authenticate the request.';

COMMENT ON COLUMN "webhook"."meta" IS 'Custom meta properties to the element';
