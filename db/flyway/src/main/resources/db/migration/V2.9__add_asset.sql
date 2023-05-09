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

CREATE TABLE "collection_asset" (
  "collection_uuid" uuid NOT NULL,
  "asset_uuid" uuid NOT NULL,
  PRIMARY KEY ("collection_uuid", "asset_uuid")
);

CREATE TABLE "tag_asset" (
  "tag_uuid" uuid NOT NULL,
  "asset_uuid" uuid NOT NULL,
  PRIMARY KEY ("tag_uuid", "asset_uuid")
);

CREATE TABLE "asset_user_meta" (
  "asset_uuid" uuid NOT NULL,
  "user_uuid" uuid NOT NULL,
  "meta" varchar,
  PRIMARY KEY ("asset_uuid", "user_uuid")
);

CREATE TABLE "task_asset" (
  "task_uuid" uuid NOT NULL,
  "asset_uuid" uuid NOT NULL,
  PRIMARY KEY ("task_uuid", "asset_uuid")
);

CREATE TABLE "asset_reaction" (
  "asset_uuid" uuid,
  "reaction_asset_uuid" uuid,
  PRIMARY KEY ("asset_uuid", "reaction_asset_uuid")
);


ALTER TABLE "asset_user_meta" ADD FOREIGN KEY ("asset_uuid") REFERENCES "asset" ("uuid");

ALTER TABLE "asset_user_meta" ADD FOREIGN KEY ("user_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "asset_reaction" ADD FOREIGN KEY ("asset_uuid") REFERENCES "asset" ("uuid");

ALTER TABLE "asset_reaction" ADD FOREIGN KEY ("reaction_asset_uuid") REFERENCES "reaction" ("uuid");

ALTER TABLE "task_asset" ADD FOREIGN KEY ("task_uuid") REFERENCES "task" ("uuid");

ALTER TABLE "task_asset" ADD FOREIGN KEY ("asset_uuid") REFERENCES "asset" ("uuid");

CREATE INDEX ON "asset" ("path");

CREATE INDEX ON "collection_asset" ("collection_uuid");

CREATE INDEX ON "collection_asset" ("asset_uuid");

ALTER TABLE "asset" ADD FOREIGN KEY ("binary_uuid") REFERENCES "binary" ("uuid");

ALTER TABLE "asset" ADD FOREIGN KEY ("locked_by_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "asset" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "asset" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "tag_asset" ADD FOREIGN KEY ("tag_uuid") REFERENCES "tag" ("uuid");

ALTER TABLE "tag_asset" ADD FOREIGN KEY ("asset_uuid") REFERENCES "asset" ("uuid");

ALTER TABLE "collection_asset" ADD FOREIGN KEY ("collection_uuid") REFERENCES "collection" ("uuid");

ALTER TABLE "collection_asset" ADD FOREIGN KEY ("asset_uuid") REFERENCES "asset" ("uuid");

COMMENT ON TABLE "tag_asset" IS 'Store tag <-> asset reference';

COMMENT ON TABLE "asset" IS 'Assets keep track of media that has been found by the scanner. Multiple assets may share the same binary thus the properties will be decoupled from binary.';

COMMENT ON COLUMN "asset"."binary_uuid" IS 'Reference to the media binary that contains the actual data for the asset.';

COMMENT ON COLUMN "asset"."path" IS 'Currently known path to the asset in the filesystem';

COMMENT ON COLUMN "asset"."meta" IS 'Custom meta properties to the asset';

COMMENT ON TABLE "asset_user_meta" IS 'Stores user specific metadata that can be added to assets';

COMMENT ON COLUMN "asset_user_meta"."meta" IS 'Custom meta properties';

COMMENT ON TABLE "collection_asset" IS 'Track assets that belong to a collection.';