CREATE TABLE "embedding_attachment" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "meta" jsonb,
  "embedding_uuid" uuid NOT NULL,
  "asset_uuid" uuid NOT NULL,
  "sha512sum" varchar NOT NULL,
 
  "size" bigint NOT NULL,
  "mime_type" varchar NOT NULL,
  "filename" varchar NOT NULL,

  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid NOT NULL,
  "edited" timestamp NOT NULL DEFAULT (now()),
  "editor_uuid" uuid NOT NULL,

  PRIMARY KEY ("uuid")
);
CREATE UNIQUE INDEX ON "embedding_attachment" ("uuid");
ALTER TABLE "embedding_attachment" ADD FOREIGN KEY ("embedding_uuid") REFERENCES "embedding" ("uuid");
ALTER TABLE "embedding_attachment" ADD FOREIGN KEY ("asset_uuid") REFERENCES "asset" ("uuid");
ALTER TABLE "embedding_attachment" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");
ALTER TABLE "embedding_attachment" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");