
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

CREATE TABLE "loom" (
  "db_rev" varchar,
  "last_used_timestamp" timestamp NOT NULL DEFAULT (now())
);


