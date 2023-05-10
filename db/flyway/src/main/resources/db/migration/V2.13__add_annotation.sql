CREATE TYPE "annotation_type" AS ENUM (
  'FEEDBACK',
  'TAG',
  'CHAPTER'
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
  "thumbnail" varchar,
  PRIMARY KEY ("uuid")
);

ALTER TABLE "annotation" ADD FOREIGN KEY ("asset_uuid") REFERENCES "asset" ("uuid");
ALTER TABLE "annotation" ADD FOREIGN KEY ("creator_uuid") REFERENCES "user" ("uuid");

COMMENT ON TABLE "annotation" IS 'This table contains asset annotation entries which can be used to create chapters or sections to assign tasks to.';
COMMENT ON COLUMN "annotation"."created" IS 'Creation timestamp';
COMMENT ON COLUMN "annotation"."meta" IS 'Custom meta properties';
COMMENT ON COLUMN "annotation"."thumbnail" IS 'Reference to the thumbnail that depics the annotated element/area';

CREATE TABLE "annotation_task" (
  "annotation_uuid" uuid NOT NULL,
  "task_uuid" uuid NOT NULL,
  PRIMARY KEY ("annotation_uuid", "task_uuid")
);
ALTER TABLE "annotation_task" ADD FOREIGN KEY ("annotation_uuid") REFERENCES "annotation" ("uuid");
ALTER TABLE "annotation_task" ADD FOREIGN KEY ("task_uuid") REFERENCES "task" ("uuid");

CREATE TABLE "annotation_asset" (
  "annotation_uuid" uuid NOT NULL,
  "asset_uuid" uuid NOT NULL,
  PRIMARY KEY ("annotation_uuid", "asset_uuid")
);
ALTER TABLE "annotation_asset" ADD FOREIGN KEY ("annotation_uuid") REFERENCES "annotation" ("uuid");
ALTER TABLE "annotation_asset" ADD FOREIGN KEY ("asset_uuid") REFERENCES "asset" ("uuid");

CREATE TABLE "annotation_tag" (
  "annotation_uuid" uuid NOT NULL,
  "tag_uuid" uuid NOT NULL,
  PRIMARY KEY ("annotation_uuid", "tag_uuid")
);
ALTER TABLE "annotation_tag" ADD FOREIGN KEY ("annotation_uuid") REFERENCES "annotation" ("uuid");
ALTER TABLE "annotation_tag" ADD FOREIGN KEY ("tag_uuid") REFERENCES "tag" ("uuid");


CREATE TABLE "annotation_reaction" (
  "annotation_uuid" uuid,
  "reaction_annotation_uuid" uuid,
  PRIMARY KEY ("annotation_uuid", "reaction_annotation_uuid")
);
ALTER TABLE "annotation_reaction" ADD FOREIGN KEY ("annotation_uuid") REFERENCES "annotation" ("uuid");
ALTER TABLE "annotation_reaction" ADD FOREIGN KEY ("reaction_annotation_uuid") REFERENCES "reaction" ("uuid");

CREATE TABLE "annotation_comment" (
  "annotation_uuid" uuid NOT NULL,
  "comment_uuid" uuid NOT NULL,
  PRIMARY KEY ("annotation_uuid", "comment_uuid")
);
ALTER TABLE "annotation_comment" ADD FOREIGN KEY ("annotation_uuid") REFERENCES "annotation" ("uuid");
ALTER TABLE "annotation_comment" ADD FOREIGN KEY ("comment_uuid") REFERENCES "comment" ("uuid");
