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

COMMENT ON TABLE "blacklist" IS 'Stores information on blocked binaries.
A binary can be blocked due to copyright claim issues or because the virus scanner marked it.';

COMMENT ON COLUMN "blacklist"."binary_uuid" IS 'Blacklisted binary';

COMMENT ON COLUMN "blacklist"."created" IS 'Creation timestamp';

COMMENT ON COLUMN "blacklist"."creator_uuid" IS 'Creator of the blacklist entry';

COMMENT ON COLUMN "blacklist"."type" IS 'Type of the blacklist entry (e.g. copyright claim)';

COMMENT ON COLUMN "blacklist"."review_count" IS 'Amount of times this blacklist entry has been reviewed.';

COMMENT ON COLUMN "blacklist"."meta" IS 'Custom meta properties of the block entry. May contain additional information on the reason.';

CREATE UNIQUE INDEX ON "blacklist" ("binary_uuid", "creator_uuid");

ALTER TABLE "blacklist" ADD FOREIGN KEY ("binary_uuid") REFERENCES "binary" ("uuid");

ALTER TABLE "blacklist" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

ALTER TABLE "blacklist" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");
