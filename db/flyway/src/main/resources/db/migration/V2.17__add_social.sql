CREATE TABLE "comment" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "title" varchar,
  "content" varchar NOT NULL,
  "parent_uuid" uuid,

  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid NOT NULL,
  "edited" timestamp NOT NULL DEFAULT (now()),
  "editor_uuid" uuid NOT NULL,

  PRIMARY KEY ("uuid")
);
ALTER TABLE "comment" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");
ALTER TABLE "comment" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");
ALTER TABLE "comment" ADD FOREIGN KEY ("parent_uuid") REFERENCES "comment" ("uuid");
COMMENT ON TABLE "comment" IS 'Stores comments on tasks, annotations..';
COMMENT ON COLUMN "comment"."title" IS 'Comment title';
COMMENT ON COLUMN "comment"."content" IS 'Comment text';
COMMENT ON COLUMN "comment"."created" IS 'Creation timestamp';
COMMENT ON COLUMN "comment"."edited" IS 'Edit timestamp';

CREATE TABLE "comment_task" (
  "comment_uuid" uuid NOT NULL,
  "task_uuid" uuid NOT NULL,
  PRIMARY KEY ("comment_uuid", "task_uuid")
);
ALTER TABLE "comment_task" ADD FOREIGN KEY ("comment_uuid") REFERENCES "comment" ("uuid");
ALTER TABLE "comment_task" ADD FOREIGN KEY ("task_uuid") REFERENCES "task" ("uuid");


CREATE TABLE "reaction" (
  "uuid" uuid DEFAULT uuid_generate_v4 (),
  "type" varchar,
  "rating" int,
  "meta" jsonb,

  "created" timestamp NOT NULL DEFAULT (now()),
  "creator_uuid" uuid NOT NULL,
  "edited" timestamp NOT NULL DEFAULT (now()),
  "editor_uuid" uuid NOT NULL,

  "asset_uuid" uuid,
  "comment_uuid" uuid,
  "annotation_uuid" uuid,
  PRIMARY KEY ("uuid")
);

CREATE UNIQUE INDEX ON "reaction" ("creator_uuid", "type", "asset_uuid");
CREATE UNIQUE INDEX ON "reaction" ("creator_uuid", "type", "comment_uuid");
CREATE UNIQUE INDEX ON "reaction" ("creator_uuid", "type", "annotation_uuid");
ALTER TABLE "reaction" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");
ALTER TABLE "reaction" ADD FOREIGN KEY ("editor_uuid") REFERENCES "user" ("uuid");
ALTER TABLE "reaction" ADD FOREIGN KEY ("asset_uuid") REFERENCES "asset" ("uuid");
ALTER TABLE "reaction" ADD FOREIGN KEY ("annotation_uuid") REFERENCES "annotation" ("uuid");
ALTER TABLE "reaction" ADD FOREIGN KEY ("comment_uuid") REFERENCES "comment" ("uuid");

COMMENT ON TABLE "reaction" IS 'Stores social reactions on multiple elements';
COMMENT ON COLUMN "reaction"."type" IS 'Type of the reaction (e.g. thumbsup)';
COMMENT ON COLUMN "reaction"."rating" IS 'Rating by the user';
COMMENT ON COLUMN "reaction"."meta" IS 'Custom meta properties to the reaction.';
COMMENT ON COLUMN "reaction"."created" IS 'Creation timestamp';
COMMENT ON COLUMN "reaction"."creator_uuid" IS 'Creator of the reaction';

CREATE TABLE "comment_reaction" (
  "comment_uuid" uuid,
  "reaction_comment_uuid" uuid,
  PRIMARY KEY ("comment_uuid", "reaction_comment_uuid")
);
ALTER TABLE "comment_reaction" ADD FOREIGN KEY ("comment_uuid") REFERENCES "comment" ("uuid");
ALTER TABLE "comment_reaction" ADD FOREIGN KEY ("reaction_comment_uuid") REFERENCES "comment" ("uuid");

CREATE TABLE "asset_reaction" (
  "asset_uuid" uuid,
  "reaction_uuid" uuid,
  PRIMARY KEY ("asset_uuid", "reaction_uuid")
);
ALTER TABLE "asset_reaction" ADD FOREIGN KEY ("asset_uuid") REFERENCES "asset" ("uuid");
ALTER TABLE "asset_reaction" ADD FOREIGN KEY ("reaction_uuid") REFERENCES "reaction" ("uuid");

CREATE TABLE "annotation_reaction" (
  "annotation_uuid" uuid,
  "reaction_annotation_uuid" uuid,
  PRIMARY KEY ("annotation_uuid", "reaction_annotation_uuid")
);
ALTER TABLE "annotation_reaction" ADD FOREIGN KEY ("annotation_uuid") REFERENCES "annotation" ("uuid") ON DELETE CASCADE;
ALTER TABLE "annotation_reaction" ADD FOREIGN KEY ("reaction_annotation_uuid") REFERENCES "reaction" ("uuid") ON DELETE CASCADE;

CREATE TABLE "annotation_comment" (
  "annotation_uuid" uuid NOT NULL,
  "comment_uuid" uuid NOT NULL,
  PRIMARY KEY ("annotation_uuid", "comment_uuid")
);
ALTER TABLE "annotation_comment" ADD FOREIGN KEY ("annotation_uuid") REFERENCES "annotation" ("uuid") ON DELETE CASCADE;
ALTER TABLE "annotation_comment" ADD FOREIGN KEY ("comment_uuid") REFERENCES "comment" ("uuid") ON DELETE CASCADE;


