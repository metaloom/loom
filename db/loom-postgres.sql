CREATE TYPE "content_type" AS ENUM (
  'D',
  'P',
  'I'
);

CREATE TYPE "permission_flag" AS ENUM (
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

CREATE TABLE "users" (
  "uuid" SERIAL PRIMARY KEY,
  "username" varchar UNIQUE NOT NULL,
  "firstname" varchar,
  "lastname" varchar,
  "email" varchar,
  "enabled" boolean NOT NULL DEFAULT true,
  "meta" varchar,
  "permissions" permission_flag,
  "created" timestamp DEFAULT (now()),
  "creator_uuid" uuid,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "user_tokens" (
  "uuid" SERIAL PRIMARY KEY,
  "user_uuid" user_uuid,
  "note" varchar,
  "token" varchar NOT NULL,
  "permissions" permission_flag,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "roles" (
  "uuid" SERIAL PRIMARY KEY,
  "name" varchar UNIQUE NOT NULL,
  "permissions" permission_flag,
  "meta" varchar,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid NOT NULL,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "role_permissions" (
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

CREATE TABLE "groups" (
  "uuid" SERIAL PRIMARY KEY,
  "name" varchar UNIQUE NOT NULL,
  "meta" varchar,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid NOT NULL,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "roles_groups" (
  "group_uuid" uuid NOT NULL,
  "role_uuid" uuid NOT NULL,
  PRIMARY KEY ("group_uuid", "role_uuid")
);

CREATE TABLE "user_groups" (
  "user_uuid" uuid NOT NULL,
  "group_uuid" uuid NOT NULL,
  PRIMARY KEY ("user_uuid", "group_uuid")
);

CREATE TABLE "tags" (
  "uuid" SERIAL PRIMARY KEY,
  "name" varchar NOT NULL,
  "collection" varchar NOT NULL,
  "meta" varchar,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid NOT NULL,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "tags_namespaces" (
  "tag_uuid" uuid NOT NULL,
  "namespace_uuid" uuid NOT NULL,
  PRIMARY KEY ("tag_uuid", "namespace_uuid")
);

CREATE TABLE "tags_contents" (
  "tag_uuid" uuid NOT NULL,
  "content_uuid" uuid NOT NULL,
  PRIMARY KEY ("tag_uuid", "content_uuid")
);

CREATE TABLE "assets" (
  "uuid" SERIAL PRIMARY KEY,
  "size" long NOT NULL,
  "sha512sum" varchar NOT NULL,
  "sha256sum" varchar NOT NULL,
  "md5sum" varchar NOT NULL,
  "meta" varchar,
  "media_width" int,
  "media_height" int,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid NOT NULL,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "assets_timeline" (
  "uuid" SERIAL PRIMARY KEY,
  "asset_uuid" uuid,
  "from" int NOT NULL,
  "to" int NOT NULL,
  "description" varchar,
  "tags" varchar,
  "meta" varchar,
  "thumbail" varchar
);

CREATE TABLE "assets_timeline_tags" (
  "assettimeline_uuid" uuid,
  "tag_uuid" uuid
);

CREATE TABLE "contents" (
  "uuid" SERIAL PRIMARY KEY,
  "namespace_uuid" uuid NOT NULL,
  "parent" uuid,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid NOT NULL,
  "model_uuid" uuid NOT NULL,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "fields_references" (
  "source_uuid" uuid NOT NULL,
  "target_uuid" uuid NOT NULL,
  "field_name" varchar NOT NULL,
  PRIMARY KEY ("source_uuid", "target_uuid")
);

CREATE TABLE "fields_contents" (
  "fields_uuid" uuid NOT NULL,
  "content_uuid" uuid,
  "webroot_path_info" varchar UNIQUE,
  "content_type" content_type NOT NULL
);

CREATE TABLE "fields" (
  "uuid" SERIAL PRIMARY KEY,
  "content_uuid" uuid,
  "fields_json" varchar,
  "language_tag" varchar,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid,
  "modelversion_uuid" uuid,
  "version" int,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "fields_assets" (
  "field_uuid" uuid,
  "asset_uuid" uuid,
  "field_name" varchar,
  PRIMARY KEY ("field_uuid", "asset_uuid")
);

CREATE TABLE "namespaces" (
  "uuid" SERIAL PRIMARY KEY,
  "name" varchar UNIQUE NOT NULL,
  "root_conten_uuid" uuid,
  "meta" varchar,
  "path_prefix" varchar,
  "model_filters" varchar,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid NOT NULL,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "models" (
  "uuid" SERIAL PRIMARY KEY,
  "name" varchar UNIQUE NOT NULL,
  "latest_version_uuid" uuid,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid NOT NULL,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid
);

CREATE TABLE "model_versions" (
  "uuid" SERIAL PRIMARY KEY,
  "model_uuid" uuid,
  "json" varchar NOT NULL,
  "next_version_uuid" uuid,
  "prev_version_uuid" uuid,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "languages" (
  "uuid" SERIAL PRIMARY KEY,
  "native_name" varchar NOT NULL,
  "tag" varchar UNIQUE NOT NULL,
  "meta" varchar,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "extensions" (
  "uuid" SERIAL PRIMARY KEY,
  "url" varchar NOT NULL,
  "kind" varchar,
  "status" varchar,
  "meta" varchar,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid NOT NULL,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid
);

CREATE TABLE "webhooks" (
  "uuid" SERIAL PRIMARY KEY,
  "url" varchar NOT NULL,
  "status" varchar,
  "active" boolean NOT NULL DEFAULT true,
  "triggers" varchar,
  "secretToken" varchar,
  "meta" varchar,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid NOT NULL,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid
);

ALTER TABLE "users" ADD FOREIGN KEY ("creator_uuid") REFERENCES "users" ("uuid");

ALTER TABLE "users" ADD FOREIGN KEY ("editor_uuid") REFERENCES "users" ("uuid");

ALTER TABLE "user_tokens" ADD FOREIGN KEY ("user_uuid") REFERENCES "users" ("uuid");

ALTER TABLE "roles" ADD FOREIGN KEY ("creator_uuid") REFERENCES "users" ("uuid");

ALTER TABLE "roles" ADD FOREIGN KEY ("editor_uuid") REFERENCES "users" ("uuid");

ALTER TABLE "role_permissions" ADD FOREIGN KEY ("role_uuid") REFERENCES "roles" ("uuid");

ALTER TABLE "groups" ADD FOREIGN KEY ("creator_uuid") REFERENCES "users" ("uuid");

ALTER TABLE "groups" ADD FOREIGN KEY ("editor_uuid") REFERENCES "users" ("uuid");

ALTER TABLE "roles_groups" ADD FOREIGN KEY ("group_uuid") REFERENCES "groups" ("uuid");

ALTER TABLE "roles_groups" ADD FOREIGN KEY ("role_uuid") REFERENCES "roles" ("uuid");

ALTER TABLE "user_groups" ADD FOREIGN KEY ("user_uuid") REFERENCES "users" ("uuid");

ALTER TABLE "user_groups" ADD FOREIGN KEY ("group_uuid") REFERENCES "groups" ("uuid");

ALTER TABLE "tags" ADD FOREIGN KEY ("creator_uuid") REFERENCES "users" ("uuid");

ALTER TABLE "tags" ADD FOREIGN KEY ("editor_uuid") REFERENCES "users" ("uuid");

ALTER TABLE "tags_namespaces" ADD FOREIGN KEY ("tag_uuid") REFERENCES "tags" ("uuid");

ALTER TABLE "tags_namespaces" ADD FOREIGN KEY ("namespace_uuid") REFERENCES "namespaces" ("uuid");

ALTER TABLE "tags_contents" ADD FOREIGN KEY ("tag_uuid") REFERENCES "tags" ("uuid");

ALTER TABLE "tags_contents" ADD FOREIGN KEY ("content_uuid") REFERENCES "contents" ("uuid");

ALTER TABLE "assets" ADD FOREIGN KEY ("creator_uuid") REFERENCES "users" ("uuid");

ALTER TABLE "assets" ADD FOREIGN KEY ("editor_uuid") REFERENCES "users" ("uuid");

ALTER TABLE "assets_timeline" ADD FOREIGN KEY ("asset_uuid") REFERENCES "assets" ("uuid");

ALTER TABLE "assets_timeline_tags" ADD FOREIGN KEY ("assettimeline_uuid") REFERENCES "assets_timeline" ("uuid");

ALTER TABLE "assets_timeline_tags" ADD FOREIGN KEY ("tag_uuid") REFERENCES "tags" ("uuid");

ALTER TABLE "contents" ADD FOREIGN KEY ("namespace_uuid") REFERENCES "namespaces" ("uuid");

ALTER TABLE "contents" ADD FOREIGN KEY ("parent") REFERENCES "contents" ("uuid");

ALTER TABLE "contents" ADD FOREIGN KEY ("creator_uuid") REFERENCES "users" ("uuid");

ALTER TABLE "contents" ADD FOREIGN KEY ("model_uuid") REFERENCES "models" ("uuid");

ALTER TABLE "fields_references" ADD FOREIGN KEY ("source_uuid") REFERENCES "fields" ("uuid");

ALTER TABLE "fields_references" ADD FOREIGN KEY ("target_uuid") REFERENCES "fields" ("uuid");

ALTER TABLE "fields_contents" ADD FOREIGN KEY ("fields_uuid") REFERENCES "fields" ("uuid");

ALTER TABLE "fields_contents" ADD FOREIGN KEY ("content_uuid") REFERENCES "contents" ("uuid");

ALTER TABLE "fields" ADD FOREIGN KEY ("content_uuid") REFERENCES "namespaces" ("uuid");

ALTER TABLE "fields" ADD FOREIGN KEY ("editor_uuid") REFERENCES "users" ("uuid");

ALTER TABLE "fields" ADD FOREIGN KEY ("modelversion_uuid") REFERENCES "model_versions" ("uuid");

ALTER TABLE "fields_assets" ADD FOREIGN KEY ("field_uuid") REFERENCES "fields" ("uuid");

ALTER TABLE "fields_assets" ADD FOREIGN KEY ("asset_uuid") REFERENCES "assets" ("uuid");

ALTER TABLE "namespaces" ADD FOREIGN KEY ("root_conten_uuid") REFERENCES "contents" ("uuid");

ALTER TABLE "namespaces" ADD FOREIGN KEY ("creator_uuid") REFERENCES "users" ("uuid");

ALTER TABLE "namespaces" ADD FOREIGN KEY ("editor_uuid") REFERENCES "users" ("uuid");

ALTER TABLE "models" ADD FOREIGN KEY ("latest_version_uuid") REFERENCES "model_versions" ("uuid");

ALTER TABLE "models" ADD FOREIGN KEY ("creator_uuid") REFERENCES "users" ("uuid");

ALTER TABLE "models" ADD FOREIGN KEY ("editor_uuid") REFERENCES "users" ("uuid");

ALTER TABLE "model_versions" ADD FOREIGN KEY ("model_uuid") REFERENCES "models" ("uuid");

ALTER TABLE "model_versions" ADD FOREIGN KEY ("next_version_uuid") REFERENCES "model_versions" ("uuid");

ALTER TABLE "model_versions" ADD FOREIGN KEY ("prev_version_uuid") REFERENCES "model_versions" ("uuid");

ALTER TABLE "extensions" ADD FOREIGN KEY ("creator_uuid") REFERENCES "users" ("uuid");

ALTER TABLE "extensions" ADD FOREIGN KEY ("editor_uuid") REFERENCES "users" ("uuid");

ALTER TABLE "webhooks" ADD FOREIGN KEY ("creator_uuid") REFERENCES "users" ("uuid");

ALTER TABLE "webhooks" ADD FOREIGN KEY ("editor_uuid") REFERENCES "users" ("uuid");

CREATE UNIQUE INDEX ON "users" ("username");

CREATE INDEX ON "user_tokens" ("user_uuid");

CREATE UNIQUE INDEX ON "roles" ("name");

CREATE UNIQUE INDEX ON "groups" ("name");

CREATE UNIQUE INDEX ON "tags" ("name", "collection");

CREATE INDEX ON "fields_contents" ("content_uuid", "content_type");

CREATE INDEX ON "fields_contents" ("content_type", "webroot_path_info");

CREATE UNIQUE INDEX ON "namespaces" ("name");

CREATE INDEX ON "languages" ("tag");

COMMENT ON COLUMN "users"."meta" IS 'Custom meta properties to the element';

COMMENT ON COLUMN "roles"."meta" IS 'Custom meta properties to the element';

COMMENT ON COLUMN "groups"."meta" IS 'Custom meta properties to the element';

COMMENT ON COLUMN "tags"."meta" IS 'Custom meta properties to the element';

COMMENT ON COLUMN "assets"."meta" IS 'Custom meta properties to the element';

COMMENT ON COLUMN "assets"."media_width" IS 'Only set for images';

COMMENT ON COLUMN "assets"."media_height" IS 'Only set for images';

COMMENT ON TABLE "assets_timeline" IS 'This table contains asset timeline entries';

COMMENT ON COLUMN "contents"."parent" IS 'Reference to the parent content.';

COMMENT ON TABLE "fields_references" IS 'This table is mainly used to lookup foreign references to contents';

COMMENT ON COLUMN "fields_references"."field_name" IS 'Name of the field in which the content reference was listed.';

COMMENT ON TABLE "fields_contents" IS 'Crosstable that tracks all fields for a content';

COMMENT ON COLUMN "fields_contents"."webroot_path_info" IS 'prefixed with branch';

COMMENT ON COLUMN "fields_contents"."content_type" IS 'D or P for draft and published';

COMMENT ON TABLE "fields" IS 'Table which stores the actual fields content as JSON';

COMMENT ON COLUMN "fields"."content_uuid" IS 'Reference to the content that uses this fields record';

COMMENT ON COLUMN "fields"."fields_json" IS 'JSON which contains the actual fields content';

COMMENT ON TABLE "fields_assets" IS 'Crosstable which tracks the used assets in a fields record';

COMMENT ON COLUMN "namespaces"."meta" IS 'Custom meta properties to the element';

COMMENT ON COLUMN "namespaces"."path_prefix" IS 'Prefix for webroot paths';

COMMENT ON COLUMN "namespaces"."model_filters" IS 'filter for models that can be used in the namespace';

COMMENT ON COLUMN "languages"."meta" IS 'Custom meta properties to the element';

COMMENT ON TABLE "extensions" IS 'Table which lists the registered extensions';

COMMENT ON COLUMN "extensions"."kind" IS 'Defines the type of the extension service';

COMMENT ON COLUMN "extensions"."meta" IS 'Custom meta properties to the element';

COMMENT ON TABLE "webhooks" IS 'Table which stores the registered webhooks';

COMMENT ON COLUMN "webhooks"."secretToken" IS 'Secret token which webhook services can use to authenticate the request.';

COMMENT ON COLUMN "webhooks"."meta" IS 'Custom meta properties to the element';
