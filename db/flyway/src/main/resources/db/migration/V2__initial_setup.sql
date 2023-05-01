CREATE TYPE "embedding_type" AS ENUM (
  'DLIB_FACE_RESNET_v1',
  'VIDEO4J_FINGERPRINT_V1'
);

CREATE TYPE "cluster_type" AS ENUM (
  'PERSON',
  'REMIX'
);

CREATE TYPE "annotation_type" AS ENUM (
  'FEEDBACK',
  'TAG',
  'CHAPTER'
);

CREATE TYPE "task_status" AS ENUM (
  'PENDING',
  'REJECTED',
  'ACCEPTED',
  'REVIEW'
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
  'ASSET_UPLOADED',
  'ASSET_CREATED',
  'ASSET_UPDATED',
  'ASSET_DELETED',
  'ASSET_TAGGED',
  'TAG_CREATED',
  'TAG_DELETED',
  'TAG_UPDATED',
  'WEBHOOK_CREATED',
  'WEBHOOK_DELETED',
  'WEBHOOK_UPDATED'
);

CREATE TYPE "loom_permission" AS ENUM (
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
  'DELETE_WEBHOOK'
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
  "email" varchar,
  "enabled" boolean NOT NULL DEFAULT true,
  "sso" boolean NOT NULL DEFAULT false,
  "passwordHash" varchar,
  "meta" jsonb,
  "created" timestamp DEFAULT (now()),
  "creator_uuid" uuid,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "token" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "user_uuid" uuid,
  "description" varchar,
  "token" varchar NOT NULL,
  "created" timestamp DEFAULT (now()),
  "meta" jsonb,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "role" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "name" varchar UNIQUE NOT NULL,
  "meta" jsonb,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "role_permission" (
  "role_uuid" uuid,
  "resource" varchar NOT NULL,
  "permission" loom_permission NOT NULL,
  PRIMARY KEY ("role_uuid")
);

CREATE TABLE "user_permission" (
  "user_uuid" uuid,
  "resource" varchar NOT NULL,
  "permission" loom_permission NOT NULL,
  PRIMARY KEY ("user_uuid")
);

CREATE TABLE "token_permission" (
  "token_uuid" uuid,
  "resource" varchar NOT NULL,
  "permission" loom_permission NOT NULL,
  PRIMARY KEY ("token_uuid")
);

CREATE TABLE "group" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "name" varchar UNIQUE NOT NULL,
  "meta" jsonb,
  "created" timestamp NOT NULL DEFAULT (now()),
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
  "meta" jsonb,
  PRIMARY KEY ("tag_uuid", "user_uuid")
);

CREATE TABLE "tag_asset" (
  "tag_uuid" uuid NOT NULL,
  "asset_uuid" uuid NOT NULL,
  PRIMARY KEY ("tag_uuid", "asset_uuid")
);

CREATE TABLE "tag_collection" (
  "tag_uuid" uuid NOT NULL,
  "collection_uuid" uuid NOT NULL,
  PRIMARY KEY ("tag_uuid", "collection_uuid")
);

CREATE TABLE "tag_cluster" (
  "tag_uuid" uuid NOT NULL,
  "cluster_uuid" uuid NOT NULL,
  PRIMARY KEY ("tag_uuid", "cluster_uuid")
);

CREATE TABLE "binary" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "sha512sum" varchar NOT NULL,
  "size" bigint NOT NULL,
  "sha256sum" varchar NOT NULL,
  "md5sum" varchar NOT NULL,
  "chunk_hash" varchar NOT NULL,
  "zero_chunk_count" bigint NOT NULL,
  "mime_type" varchar NOT NULL,
  "meta" jsonb,
  "author" varchar,
  "geo_lon" decimal(9,6),
  "geo_lat" decimal(8,6),
  "initial_origin" varchar NOT NULL,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid,
  "s3_bucket_name" varchar,
  "s3_object_path" varchar,
  "media_width" int,
  "media_height" int,
  "duration" int,
  "video_fingerprint" varchar,
  "image_fingerprint" varchar,
  "image_dominant_color" varchar,
  "audio_bpm" int,
  "audio_sampling_rate" int,
  "audio_channels" int,
  "audio_encoding" varchar,
  "audio_fingerprint" varchar,
  "doc_plain_text" varchar,
  "doc_word_count" int,
  PRIMARY KEY ("sha512sum")
);

CREATE TABLE "binary_remix" (
  "binary_a_uuid" uuid NOT NULL,
  "binary_b_uuid" uuid NOT NULL,
  "meta" jsonb,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid NOT NULL
);

CREATE TABLE "asset" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "binary_uuid" uuid NOT NULL,
  "path" varchar NOT NULL,
  "filekey_inode" int,
  "filekey_stdev" int,
  "filekey_edate_nano" int,
  "filekey_edate" int,
  "meta" varchar,
  "mime_type" varchar,
  "license" varchar,
  "state" varchar,
  "locked_by_uuid" uuid,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid NOT NULL,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "embedding" (
   "uuid" uuid DEFAULT uuid_generate_v4 (),
  "meta" jsonb,
  "source" varchar,
  "frame" int NOT NULL,
  "areaHeight" int NOT NULL,
  "areaWidth" int NOT NULL,
  "areaStartX" int NOT NULL,
  "areaStartY" int NOT NULL,
  "embeddings" bytea NOT NULL,
  "embedding_id" bigint,
  "embedding_type" embedding_type,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid NOT NULL,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid,
  "binary_uuid" uuid NOT NULL,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "cluster" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "name" varchar NOT NULL,
  "meta" jsonb,
  "type" cluster_type NOT NULL,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid NOT NULL,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "embedding_cluster" (
  "embedding_uuid" uuid NOT NULL,
  "cluster_uuid" uuid NOT NULL,
  PRIMARY KEY ("embedding_uuid", "cluster_uuid")
);

CREATE TABLE "collection" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "name" varchar UNIQUE NOT NULL,
  "meta" jsonb,
  "description" varchar,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid NOT NULL,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid,
  "parent_collection_uuid" uuid,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "collection_asset" (
  "collection_uuid" uuid NOT NULL,
  "asset_uuid" uuid NOT NULL,
  PRIMARY KEY ("collection_uuid", "asset_uuid")
);

CREATE TABLE "collection_binary" (
  "collection_uuid" uuid NOT NULL,
  "binary_uuid" uuid NOT NULL,
  PRIMARY KEY ("collection_uuid", "binary_uuid")
);

CREATE TABLE "vector_config" (
   "uuid" uuid DEFAULT uuid_generate_v4 (),
  "name" varchar UNIQUE NOT NULL,
  "weights" jsonb
);

CREATE TABLE "comment" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "title" varchar,
  "content" varchar NOT NULL,
  "user_uuid" uuid NOT NULL,
  "created" varchar NOT NULL,
  "edited" varchar,
  "parent_uuid" uuid,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "comment_task" (
  "comment_uuid" uuid NOT NULL,
  "task_uuid" uuid NOT NULL,
  PRIMARY KEY ("comment_uuid", "task_uuid")
);

CREATE TABLE "comment_annotaion" (
  "comment_uuid" uuid NOT NULL,
  "annotation_uuid" uuid NOT NULL,
  PRIMARY KEY ("comment_uuid", "annotation_uuid")
);

CREATE TABLE "blacklist" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "binary_uuid" uuid NOT NULL,
  "created" varchar NOT NULL,
  "creator_uuid" uuid NOT NULL,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid,
  "type" varchar,
  "review_count" int DEFAULT 1,
  "meta" jsonb,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "reaction" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "type" varchar,
  "rating" int,
  "meta" jsonb,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid NOT NULL,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid,
  "asset_uuid" uuid,
  "comment_uuid" uuid,
  "annotation_uuid" uuid,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "annotation" (
   "uuid" uuid DEFAULT uuid_generate_v4 (),
  "type" annotation_type NOT NULL,
  "asset_uuid" uuid NOT NULL,
  "creator_uuid" uuid NOT NULL,
  "created" timestamp NOT NULL DEFAULT (now()),
  "title" varchar,
  "description" varchar,
  "time_from" int,
  "time_to" int,
  "areaStartX" int,
  "areaStartY" int,
  "areaWidth" int,
  "areaHeight" int,
  "meta" jsonb,
  "thumbail" varchar,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "annotation_tag" (
  "annotation_uuid" uuid NOT NULL,
  "tag_uuid" uuid NOT NULL,
  PRIMARY KEY ("annotation_uuid", "tag_uuid")
);

CREATE TABLE "task" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "title" varchar NOT NULL,
  "content" varchar,
  "due_date" timestamp,
  "status" task_status DEFAULT 'PENDING',
  "priority" int,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid NOT NULL,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "task_asset" (
  "task_uuid" uuid NOT NULL,
  "asset_uuid" uuid NOT NULL,
  PRIMARY KEY ("task_uuid", "asset_uuid")
);

CREATE TABLE "task_annotation" (
  "task_uuid" uuid NOT NULL,
  "annotation_uuid" uuid NOT NULL,
  PRIMARY KEY ("task_uuid", "annotation_uuid")
);

CREATE TABLE "asset_user_meta" (
  "asset_uuid" uuid NOT NULL,
  "user_uuid" uuid NOT NULL,
  "meta" varchar,
  PRIMARY KEY ("asset_uuid", "user_uuid")
);

CREATE TABLE "webhook" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "url" varchar NOT NULL,
  "status" varchar,
  "active" boolean NOT NULL DEFAULT true,
  "triggers" loom_events,
  "secretToken" varchar,
  "meta" jsonb,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid NOT NULL,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid,
  PRIMARY KEY ("uuid")
);

CREATE UNIQUE INDEX ON "user" ("username");

CREATE UNIQUE INDEX ON "token" ("token");

CREATE INDEX ON "token" ("user_uuid");

CREATE UNIQUE INDEX ON "role" ("name");

CREATE UNIQUE INDEX ON "role_permission" ("role_uuid", "resource", "permission");

CREATE UNIQUE INDEX ON "user_permission" ("user_uuid", "resource", "permission");

CREATE UNIQUE INDEX ON "token_permission" ("token_uuid", "resource", "permission");

CREATE UNIQUE INDEX ON "group" ("name");

CREATE UNIQUE INDEX ON "tag" ("name", "collection");

CREATE UNIQUE INDEX ON "binary" ("uuid");

CREATE INDEX ON "binary" ("geo_lon", "geo_lat");

CREATE INDEX ON "binary_remix" ("binary_a_uuid");

CREATE INDEX ON "binary_remix" ("binary_b_uuid");

CREATE INDEX ON "asset" ("path");

CREATE INDEX ON "embedding" ("binary_uuid");

CREATE UNIQUE INDEX ON "cluster" ("name");

CREATE INDEX ON "collection_asset" ("collection_uuid");

CREATE INDEX ON "collection_asset" ("asset_uuid");

CREATE INDEX ON "collection_binary" ("collection_uuid");

CREATE INDEX ON "collection_binary" ("binary_uuid");

CREATE UNIQUE INDEX ON "blacklist" ("binary_uuid", "creator_uuid");

CREATE UNIQUE INDEX ON "reaction" ("creator_uuid", "type", "asset_uuid");

CREATE UNIQUE INDEX ON "reaction" ("creator_uuid", "type", "comment_uuid");

CREATE UNIQUE INDEX ON "reaction" ("creator_uuid", "type", "annotation_uuid");

COMMENT ON COLUMN "user"."enabled" IS 'Flag to enable or disable the user.';

COMMENT ON COLUMN "user"."sso" IS 'Flag that indicates that the user was created via SSO mappings';

COMMENT ON COLUMN "user"."meta" IS 'Custom meta properties to the element';

COMMENT ON COLUMN "token"."meta" IS 'Custom meta properties to the element';

COMMENT ON COLUMN "role"."meta" IS 'Custom meta properties to the element';

COMMENT ON COLUMN "role_permission"."permission" IS 'Permission granted / granted to the resource';

COMMENT ON COLUMN "user_permission"."permission" IS 'Permission granted / granted to the resource';

COMMENT ON COLUMN "token_permission"."permission" IS 'Permission granted / granted to the resource';

COMMENT ON COLUMN "group"."meta" IS 'Custom meta properties to the element';

COMMENT ON TABLE "tag" IS 'Tag on various elements. Tags are not user specifc';

COMMENT ON COLUMN "tag"."meta" IS 'Custom meta properties to the element';

COMMENT ON COLUMN "tag"."rating" IS 'Absolute or buffered/precomputed rating information';

COMMENT ON COLUMN "tag_user_meta"."rating" IS 'Rating of the tag by the user';

COMMENT ON COLUMN "tag_user_meta"."meta" IS 'Custom meta properties';

COMMENT ON TABLE "tag_asset" IS 'Store tag <-> asset reference';

COMMENT ON TABLE "tag_collection" IS 'Store tag <-> collection reference';

COMMENT ON TABLE "tag_cluster" IS 'Store tag <-> cluster reference';

COMMENT ON TABLE "binary" IS 'This table stores information on the binary component of the asset';

COMMENT ON COLUMN "binary"."meta" IS 'Custom meta properties to the asset';

COMMENT ON COLUMN "binary"."initial_origin" IS 'Document the initial origin of the binary (e.g. first filepath encountered, first s3 path, url, hash)';

COMMENT ON COLUMN "binary"."media_width" IS 'Only set for images, video';

COMMENT ON COLUMN "binary"."media_height" IS 'Only set for images, video';

COMMENT ON COLUMN "binary"."duration" IS 'Duration of the video, audio';

COMMENT ON COLUMN "binary"."video_fingerprint" IS 'Video fingerprint information';

COMMENT ON COLUMN "binary"."image_fingerprint" IS 'Image fingerprint information';

COMMENT ON COLUMN "binary"."audio_encoding" IS 'Store the audio encoding used for the binary (e.g. mp3, flac)';

COMMENT ON COLUMN "binary"."audio_fingerprint" IS 'Audio fingerprint information';

COMMENT ON COLUMN "binary"."doc_plain_text" IS 'Extracted text of the document';

COMMENT ON TABLE "binary_remix" IS 'Store information on remixes of binaries.';

COMMENT ON COLUMN "binary_remix"."meta" IS 'Custom meta properties to the element';

COMMENT ON TABLE "asset" IS 'Assets keep track of media that has been found by the scanner. Multiple assets may share the same binary thus the properties will be decoupled from binary.';

COMMENT ON COLUMN "asset"."binary_uuid" IS 'Reference to the media binary that contains the actual data for the asset.';

COMMENT ON COLUMN "asset"."path" IS 'Currently known path to the asset in the filesystem';

COMMENT ON COLUMN "asset"."meta" IS 'Custom meta properties to the asset';

COMMENT ON TABLE "embedding" IS 'Embedding information which was extracted from a binary.';

COMMENT ON COLUMN "embedding"."meta" IS 'Custom meta properties to the embedding.';

COMMENT ON COLUMN "embedding"."source" IS 'Additional source information (e.g. face number by dlib)';

COMMENT ON COLUMN "embedding"."frame" IS 'Source frame where the face has been detected.';

COMMENT ON COLUMN "embedding"."areaHeight" IS 'Area info where the face has been detected.';

COMMENT ON COLUMN "embedding"."areaWidth" IS 'Area info where the face has been detected.';

COMMENT ON COLUMN "embedding"."areaStartX" IS 'Area info where the face has been detected.';

COMMENT ON COLUMN "embedding"."areaStartY" IS 'Area info where the face has been detected.';

COMMENT ON COLUMN "embedding"."embeddings" IS 'Actual embedding data';

COMMENT ON COLUMN "embedding"."embedding_type" IS 'Type of the embedding (e.g. dlib_facemark)';

COMMENT ON TABLE "cluster" IS 'Generic cluster that aggregates multiple embeddings. 
A cluster could for example represent a person which can have multiple face embeddings.
Alternatively media fingerprint embeddings can be used to group media together by visual similarity.';

COMMENT ON COLUMN "cluster"."name" IS 'Name of the cluster. (e.g. name of a person)';

COMMENT ON COLUMN "cluster"."meta" IS 'Custom meta properties to the embedding.';

COMMENT ON COLUMN "cluster"."type" IS 'Type of the cluster (e.g. person)';

COMMENT ON TABLE "embedding_cluster" IS 'List embeddings for clusters';

COMMENT ON TABLE "collection" IS 'Collections are used to group assets together.

A collection may be a folder which groups together assets for a project.';

COMMENT ON COLUMN "collection"."meta" IS 'Custom meta properties';

COMMENT ON TABLE "collection_asset" IS 'Track assets that belong to a collection.';

COMMENT ON TABLE "collection_binary" IS 'Track binaries that belong to a collection.
User facing this will result in all transitive assets being added to the collection.';

COMMENT ON TABLE "vector_config" IS 'This table stores the custom index definition that will be used when creating custom indices in a vector database that list specific aspects of loom data.

A custom configuration may define that a specific meta property should be added to the index when generating the vector.
This feature can be used to generate a custom recommendation feature by including and ranking and encoding specific properties as vectors.';

COMMENT ON COLUMN "vector_config"."weights" IS 'Index definition which lists the weights for each component that should be included in the index';

COMMENT ON TABLE "comment" IS 'Stores comments on tasks, annotations..';

COMMENT ON COLUMN "comment"."title" IS 'Comment title';

COMMENT ON COLUMN "comment"."content" IS 'Comment text';

COMMENT ON COLUMN "comment"."created" IS 'Creation timestamp';

COMMENT ON COLUMN "comment"."edited" IS 'Edit timestamp';

COMMENT ON TABLE "blacklist" IS 'Stores information on blocked binaries.
A binary can be blocked due to copyright claim issues or because the virus scanner marked it.';

COMMENT ON COLUMN "blacklist"."binary_uuid" IS 'Blacklisted binary';

COMMENT ON COLUMN "blacklist"."created" IS 'Creation timestamp';

COMMENT ON COLUMN "blacklist"."creator_uuid" IS 'Creator of the blacklist entry';

COMMENT ON COLUMN "blacklist"."type" IS 'Type of the blacklist entry (e.g. copyright claim)';

COMMENT ON COLUMN "blacklist"."review_count" IS 'Amount of times this blacklist entry has been reviewed.';

COMMENT ON COLUMN "blacklist"."meta" IS 'Custom meta properties of the block entry. May contain additional information on the reason.';

COMMENT ON TABLE "reaction" IS 'Stores social reactions on multiple elements';

COMMENT ON COLUMN "reaction"."type" IS 'Type of the reaction (e.g. thumbsup)';

COMMENT ON COLUMN "reaction"."rating" IS 'Rating by the user';

COMMENT ON COLUMN "reaction"."meta" IS 'Custom meta properties to the reaction.';

COMMENT ON COLUMN "reaction"."created" IS 'Creation timestamp';

COMMENT ON COLUMN "reaction"."creator_uuid" IS 'Creator of the reaction';

COMMENT ON TABLE "annotation" IS 'This table contains asset annotation entries which can be used to create chapters or sections to assign tasks to.';

COMMENT ON COLUMN "annotation"."created" IS 'Creation timestamp';

COMMENT ON COLUMN "annotation"."meta" IS 'Custom meta properties';

COMMENT ON COLUMN "annotation"."thumbail" IS 'Reference to the thumbnail that depics the annotated element/area';

COMMENT ON COLUMN "task"."title" IS 'Title of the task';

COMMENT ON COLUMN "task"."content" IS 'Description of the task';

COMMENT ON COLUMN "task"."status" IS 'Current status of the task (e.g. PENDING, REJECTED)';

COMMENT ON TABLE "asset_user_meta" IS 'Stores user specific metadata that can be added to assets';

COMMENT ON COLUMN "asset_user_meta"."meta" IS 'Custom meta properties';

COMMENT ON TABLE "webhook" IS 'Table which stores the registered webhooks';

COMMENT ON COLUMN "webhook"."triggers" IS 'List of triggers which can invoke the webhook';

COMMENT ON COLUMN "webhook"."secretToken" IS 'Secret token which webhook services can use to authenticate the request.';

COMMENT ON COLUMN "webhook"."meta" IS 'Custom meta properties to the element';

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

ALTER TABLE "tag" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "tag" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "tag_user_meta" ADD FOREIGN KEY ("tag_uuid") REFERENCES "tag" ("uuid");

ALTER TABLE "tag_user_meta" ADD FOREIGN KEY ("user_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "tag_asset" ADD FOREIGN KEY ("tag_uuid") REFERENCES "tag" ("uuid");

ALTER TABLE "tag_asset" ADD FOREIGN KEY ("asset_uuid") REFERENCES "asset" ("uuid");

ALTER TABLE "tag_collection" ADD FOREIGN KEY ("tag_uuid") REFERENCES "tag" ("uuid");

ALTER TABLE "tag_collection" ADD FOREIGN KEY ("collection_uuid") REFERENCES "collection" ("uuid");

ALTER TABLE "tag_cluster" ADD FOREIGN KEY ("tag_uuid") REFERENCES "tag" ("uuid");

ALTER TABLE "tag_cluster" ADD FOREIGN KEY ("cluster_uuid") REFERENCES "cluster" ("uuid");

ALTER TABLE "binary" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "binary" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "binary_remix" ADD FOREIGN KEY ("binary_a_uuid") REFERENCES "binary" ("uuid");

ALTER TABLE "binary_remix" ADD FOREIGN KEY ("binary_b_uuid") REFERENCES "binary" ("uuid");

ALTER TABLE "binary_remix" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "asset" ADD FOREIGN KEY ("binary_uuid") REFERENCES "binary" ("uuid");

ALTER TABLE "asset" ADD FOREIGN KEY ("locked_by_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "asset" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "asset" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "embedding" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "embedding" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "embedding" ADD FOREIGN KEY ("binary_uuid") REFERENCES "binary" ("uuid");

ALTER TABLE "cluster" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "cluster" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "embedding_cluster" ADD FOREIGN KEY ("embedding_uuid") REFERENCES "embedding" ("uuid");

ALTER TABLE "embedding_cluster" ADD FOREIGN KEY ("cluster_uuid") REFERENCES "cluster" ("uuid");

ALTER TABLE "collection" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "collection" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "collection" ADD FOREIGN KEY ("parent_collection_uuid") REFERENCES "collection" ("uuid");

ALTER TABLE "collection_asset" ADD FOREIGN KEY ("collection_uuid") REFERENCES "collection" ("uuid");

ALTER TABLE "collection_asset" ADD FOREIGN KEY ("asset_uuid") REFERENCES "asset" ("uuid");

ALTER TABLE "collection_binary" ADD FOREIGN KEY ("collection_uuid") REFERENCES "collection" ("uuid");

ALTER TABLE "collection_binary" ADD FOREIGN KEY ("binary_uuid") REFERENCES "binary" ("uuid");

ALTER TABLE "comment" ADD FOREIGN KEY ("user_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "comment" ADD FOREIGN KEY ("parent_uuid") REFERENCES "comment" ("uuid");

ALTER TABLE "comment_task" ADD FOREIGN KEY ("comment_uuid") REFERENCES "comment" ("uuid");

ALTER TABLE "comment_task" ADD FOREIGN KEY ("task_uuid") REFERENCES "task" ("uuid");

ALTER TABLE "comment_annotaion" ADD FOREIGN KEY ("comment_uuid") REFERENCES "comment" ("uuid");

ALTER TABLE "comment_annotaion" ADD FOREIGN KEY ("annotation_uuid") REFERENCES "annotation" ("uuid");

ALTER TABLE "blacklist" ADD FOREIGN KEY ("binary_uuid") REFERENCES "binary" ("uuid");

ALTER TABLE "blacklist" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "blacklist" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "reaction" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "reaction" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");

CREATE TABLE "asset_reaction" (
  "asset_uuid" uuid,
  "reaction_asset_uuid" uuid,
  PRIMARY KEY ("asset_uuid", "reaction_asset_uuid")
);

ALTER TABLE "asset_reaction" ADD FOREIGN KEY ("asset_uuid") REFERENCES "asset" ("uuid");

ALTER TABLE "asset_reaction" ADD FOREIGN KEY ("reaction_asset_uuid") REFERENCES "reaction" ("uuid");


CREATE TABLE "comment_reaction" (
  "comment_uuid" uuid,
  "reaction_comment_uuid" uuid,
  PRIMARY KEY ("comment_uuid", "reaction_comment_uuid")
);

ALTER TABLE "comment_reaction" ADD FOREIGN KEY ("comment_uuid") REFERENCES "comment" ("uuid");

ALTER TABLE "comment_reaction" ADD FOREIGN KEY ("reaction_comment_uuid") REFERENCES "comment" ("uuid");


CREATE TABLE "annotation_reaction" (
  "annotation_uuid" uuid,
  "reaction_annotation_uuid" uuid,
  PRIMARY KEY ("annotation_uuid", "reaction_annotation_uuid")
);

ALTER TABLE "annotation_reaction" ADD FOREIGN KEY ("annotation_uuid") REFERENCES "annotation" ("uuid");

ALTER TABLE "annotation_reaction" ADD FOREIGN KEY ("reaction_annotation_uuid") REFERENCES "reaction" ("uuid");

ALTER TABLE "annotation" ADD FOREIGN KEY ("asset_uuid") REFERENCES "asset" ("uuid");

ALTER TABLE "annotation" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "annotation_tag" ADD FOREIGN KEY ("annotation_uuid") REFERENCES "annotation" ("uuid");

ALTER TABLE "annotation_tag" ADD FOREIGN KEY ("tag_uuid") REFERENCES "tag" ("uuid");

ALTER TABLE "task" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "task" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "task_asset" ADD FOREIGN KEY ("task_uuid") REFERENCES "task" ("uuid");

ALTER TABLE "task_asset" ADD FOREIGN KEY ("asset_uuid") REFERENCES "asset" ("uuid");

ALTER TABLE "task_annotation" ADD FOREIGN KEY ("task_uuid") REFERENCES "task" ("uuid");

ALTER TABLE "task_annotation" ADD FOREIGN KEY ("annotation_uuid") REFERENCES "annotation" ("uuid");

ALTER TABLE "asset_user_meta" ADD FOREIGN KEY ("asset_uuid") REFERENCES "asset" ("uuid");

ALTER TABLE "asset_user_meta" ADD FOREIGN KEY ("user_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "webhook" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "webhook" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "collection" ADD FOREIGN KEY ("parent_collection_uuid") REFERENCES "collection" ("uuid");
