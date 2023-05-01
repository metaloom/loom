CREATE TABLE "library" (
  "uuid" uuid,
  "name" varchar NOT NULL,
  "meta" jsonb,
  "description" varchar,
  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid NOT NULL,
  "edited" timestamp DEFAULT (now()),
  "editor_uuid" uuid,
  PRIMARY KEY ("uuid")
);

CREATE TABLE "library_asset" (
  "library_uuid" uuid NOT NULL,
  "asset_uuid" uuid NOT NULL,
  PRIMARY KEY ("library_uuid", "asset_uuid")
);

CREATE TABLE "library_collection" (
  "library_uuid" uuid NOT NULL,
  "collection_uuid" uuid NOT NULL,
  PRIMARY KEY ("library_uuid", "collection_uuid")
);

COMMENT ON COLUMN "library"."meta" IS 'Custom meta properties to the element';

ALTER TABLE "library" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "library" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "library_asset" ADD FOREIGN KEY ("library_uuid") REFERENCES "library" ("uuid");

ALTER TABLE "library_asset" ADD FOREIGN KEY ("asset_uuid") REFERENCES "asset" ("uuid");

ALTER TABLE "library_collection" ADD FOREIGN KEY ("library_uuid") REFERENCES "library" ("uuid");

ALTER TABLE "library_collection" ADD FOREIGN KEY ("collection_uuid") REFERENCES "collection" ("uuid");