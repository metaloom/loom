CREATE TABLE "binary" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "sha512sum" varchar NOT NULL,
  "size" bigint NOT NULL,
  "sha256sum" varchar,
  "md5sum" varchar,
  "chunk_hash" varchar,
  "zero_chunk_count" bigint,
  "mime_type" varchar NOT NULL,
  "meta" jsonb,
  "author" varchar,
  "geo_lon" decimal(9,6),
  "geo_lat" decimal(8,6),
  "geo_alias" varchar,
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

CREATE TABLE "collection_binary" (
  "collection_uuid" uuid NOT NULL,
  "binary_uuid" uuid NOT NULL,
  PRIMARY KEY ("collection_uuid", "binary_uuid")
);

CREATE UNIQUE INDEX ON "binary" ("uuid");

CREATE INDEX ON "binary" ("geo_lon", "geo_lat");

CREATE INDEX ON "binary_remix" ("binary_a_uuid");

CREATE INDEX ON "binary_remix" ("binary_b_uuid");

CREATE INDEX ON "collection_binary" ("collection_uuid");

CREATE INDEX ON "collection_binary" ("binary_uuid");

ALTER TABLE "binary" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "binary" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "binary_remix" ADD FOREIGN KEY ("binary_a_uuid") REFERENCES "binary" ("uuid");

ALTER TABLE "binary_remix" ADD FOREIGN KEY ("binary_b_uuid") REFERENCES "binary" ("uuid");

ALTER TABLE "binary_remix" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "collection_binary" ADD FOREIGN KEY ("collection_uuid") REFERENCES "collection" ("uuid");

ALTER TABLE "collection_binary" ADD FOREIGN KEY ("binary_uuid") REFERENCES "binary" ("uuid");

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

COMMENT ON TABLE "collection_binary" IS 'Track binaries that belong to a collection.
User facing this will result in all transitive assets being added to the collection.';
