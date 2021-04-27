CREATE TABLE `loom` (
  `db_rev` varchar(255),
  `last_used_timestamp` timestamp NOT NULL DEFAULT (now())
);

CREATE TABLE `users` (
  `uuid` uuid PRIMARY KEY AUTO_INCREMENT,
  `username` varchar(255) UNIQUE NOT NULL,
  `firstname` varchar(255),
  `lastname` varchar(255),
  `email` varchar(255),
  `enabled` boolean NOT NULL DEFAULT true,
  `meta` varchar(255) COMMENT 'Custom meta properties to the element',
  `permissions` ENUM ('CREATE_CONTENT', 'READ_CONTENT', 'UPDATE_CONTENT', 'DELETE_CONTENT', 'PUBLISH_CONTENT', 'UNPUBLISH_CONTENT', 'CREATE_NAMESPACE', 'READ_NAMESPACE', 'UPDATE_NAMESPACE', 'DELETE_NAMESPACE', 'CREATE_USER', 'READ_USER', 'UPDATE_USER', 'DELETE_USER', 'CREATE_GROUP', 'READ_GROUP', 'UPDATE_GROUP', 'DELETE_GROUP', 'CREATE_ROLE', 'READ_ROLE', 'UPDATE_ROLE', 'DELETE_ROLE', 'CREATE_TAG', 'READ_TAG', 'UPDATE_TAG', 'DELETE_TAG', 'CREATE_MODEL', 'READ_MODEL', 'UPDATE_MODEL', 'DELETE_MODEL', 'CREATE_ASSET', 'READ_ASSET', 'UPDATE_ASSET', 'DELETE_ASSET', 'UPLOAD_ASSET', 'DOWNLOAD_ASSET', 'CREATE_WEBHOOK', 'READ_WEBHOOK', 'UPDATE_WEBHOOK', 'DELETE_WEBHOOK', 'CREATE_EXTENSION', 'READ_EXTENSION', 'UPDATE_EXTENSION', 'DELETE_EXTENSION', 'CREATE_LANGUAGE', 'READ_LANGUAGE', 'UPDATE_LANGUAGE', 'DELETE_LANGUAGE'),
  `created` timestamp DEFAULT (now()),
  `creator_uuid` uuid,
  `edited` timestamp DEFAULT (now()),
  `editor_uuid` uuid,
  PRIMARY KEY (`uuid`)
);

CREATE TABLE `user_tokens` (
  `uuid` uuid PRIMARY KEY AUTO_INCREMENT,
  `user_uuid` user_uuid,
  `note` varchar(255),
  `token` varchar(255) NOT NULL,
  `permissions` ENUM ('CREATE_CONTENT', 'READ_CONTENT', 'UPDATE_CONTENT', 'DELETE_CONTENT', 'PUBLISH_CONTENT', 'UNPUBLISH_CONTENT', 'CREATE_NAMESPACE', 'READ_NAMESPACE', 'UPDATE_NAMESPACE', 'DELETE_NAMESPACE', 'CREATE_USER', 'READ_USER', 'UPDATE_USER', 'DELETE_USER', 'CREATE_GROUP', 'READ_GROUP', 'UPDATE_GROUP', 'DELETE_GROUP', 'CREATE_ROLE', 'READ_ROLE', 'UPDATE_ROLE', 'DELETE_ROLE', 'CREATE_TAG', 'READ_TAG', 'UPDATE_TAG', 'DELETE_TAG', 'CREATE_MODEL', 'READ_MODEL', 'UPDATE_MODEL', 'DELETE_MODEL', 'CREATE_ASSET', 'READ_ASSET', 'UPDATE_ASSET', 'DELETE_ASSET', 'UPLOAD_ASSET', 'DOWNLOAD_ASSET', 'CREATE_WEBHOOK', 'READ_WEBHOOK', 'UPDATE_WEBHOOK', 'DELETE_WEBHOOK', 'CREATE_EXTENSION', 'READ_EXTENSION', 'UPDATE_EXTENSION', 'DELETE_EXTENSION', 'CREATE_LANGUAGE', 'READ_LANGUAGE', 'UPDATE_LANGUAGE', 'DELETE_LANGUAGE'),
  PRIMARY KEY (`uuid`)
);

CREATE TABLE `roles` (
  `uuid` uuid PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255) UNIQUE NOT NULL,
  `permissions` ENUM ('CREATE_CONTENT', 'READ_CONTENT', 'UPDATE_CONTENT', 'DELETE_CONTENT', 'PUBLISH_CONTENT', 'UNPUBLISH_CONTENT', 'CREATE_NAMESPACE', 'READ_NAMESPACE', 'UPDATE_NAMESPACE', 'DELETE_NAMESPACE', 'CREATE_USER', 'READ_USER', 'UPDATE_USER', 'DELETE_USER', 'CREATE_GROUP', 'READ_GROUP', 'UPDATE_GROUP', 'DELETE_GROUP', 'CREATE_ROLE', 'READ_ROLE', 'UPDATE_ROLE', 'DELETE_ROLE', 'CREATE_TAG', 'READ_TAG', 'UPDATE_TAG', 'DELETE_TAG', 'CREATE_MODEL', 'READ_MODEL', 'UPDATE_MODEL', 'DELETE_MODEL', 'CREATE_ASSET', 'READ_ASSET', 'UPDATE_ASSET', 'DELETE_ASSET', 'UPLOAD_ASSET', 'DOWNLOAD_ASSET', 'CREATE_WEBHOOK', 'READ_WEBHOOK', 'UPDATE_WEBHOOK', 'DELETE_WEBHOOK', 'CREATE_EXTENSION', 'READ_EXTENSION', 'UPDATE_EXTENSION', 'DELETE_EXTENSION', 'CREATE_LANGUAGE', 'READ_LANGUAGE', 'UPDATE_LANGUAGE', 'DELETE_LANGUAGE'),
  `meta` varchar(255) COMMENT 'Custom meta properties to the element',
  `created` timestamp NOT NULL DEFAULT (now()),
  `creator_uuid` uuid NOT NULL,
  `edited` timestamp DEFAULT (now()),
  `editor_uuid` uuid,
  PRIMARY KEY (`uuid`)
);

CREATE TABLE `role_permissions` (
  `role_uuid` uuid,
  `element_uuid` uuid NOT NULL,
  `create_perm` boolean NOT NULL DEFAULT false,
  `read_perm` boolean NOT NULL DEFAULT false,
  `delete_perm` boolean NOT NULL DEFAULT false,
  `update_perm` boolean NOT NULL DEFAULT false,
  `read_publish_perm` boolean NOT NULL DEFAULT false,
  `publish_perm` boolean NOT NULL DEFAULT false,
  PRIMARY KEY (`role_uuid`, `element_uuid`)
);

CREATE TABLE `groups` (
  `uuid` uuid PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255) UNIQUE NOT NULL,
  `meta` varchar(255) COMMENT 'Custom meta properties to the element',
  `created` timestamp NOT NULL DEFAULT (now()),
  `creator_uuid` uuid NOT NULL,
  `edited` timestamp DEFAULT (now()),
  `editor_uuid` uuid,
  PRIMARY KEY (`uuid`)
);

CREATE TABLE `roles_groups` (
  `group_uuid` uuid NOT NULL,
  `role_uuid` uuid NOT NULL,
  PRIMARY KEY (`group_uuid`, `role_uuid`)
);

CREATE TABLE `user_groups` (
  `user_uuid` uuid NOT NULL,
  `group_uuid` uuid NOT NULL,
  PRIMARY KEY (`user_uuid`, `group_uuid`)
);

CREATE TABLE `tags` (
  `uuid` uuid PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `collection` varchar(255) NOT NULL,
  `meta` varchar(255) COMMENT 'Custom meta properties to the element',
  `created` timestamp NOT NULL DEFAULT (now()),
  `creator_uuid` uuid NOT NULL,
  `edited` timestamp DEFAULT (now()),
  `editor_uuid` uuid,
  PRIMARY KEY (`uuid`)
);

CREATE TABLE `tags_namespaces` (
  `tag_uuid` uuid NOT NULL,
  `namespace_uuid` uuid NOT NULL,
  PRIMARY KEY (`tag_uuid`, `namespace_uuid`)
);

CREATE TABLE `tags_contents` (
  `tag_uuid` uuid NOT NULL,
  `content_uuid` uuid NOT NULL,
  PRIMARY KEY (`tag_uuid`, `content_uuid`)
);

CREATE TABLE `assets` (
  `uuid` uuid PRIMARY KEY AUTO_INCREMENT,
  `size` long NOT NULL,
  `sha512sum` varchar(255) NOT NULL,
  `sha256sum` varchar(255) NOT NULL,
  `md5sum` varchar(255) NOT NULL,
  `meta` varchar(255) COMMENT 'Custom meta properties to the element',
  `media_width` int COMMENT 'Only set for images',
  `media_height` int COMMENT 'Only set for images',
  `created` timestamp NOT NULL DEFAULT (now()),
  `creator_uuid` uuid NOT NULL,
  `edited` timestamp DEFAULT (now()),
  `editor_uuid` uuid,
  PRIMARY KEY (`uuid`)
);

CREATE TABLE `assets_timeline` (
  `uuid` uuid PRIMARY KEY AUTO_INCREMENT,
  `asset_uuid` uuid,
  `from` int NOT NULL,
  `to` int NOT NULL,
  `description` varchar(255),
  `tags` varchar(255),
  `meta` varchar(255),
  `thumbail` varchar(255)
);

CREATE TABLE `assets_timeline_tags` (
  `assettimeline_uuid` uuid,
  `tag_uuid` uuid
);

CREATE TABLE `contents` (
  `uuid` uuid PRIMARY KEY AUTO_INCREMENT,
  `namespace_uuid` uuid NOT NULL,
  `parent` uuid COMMENT 'Reference to the parent content.',
  `created` timestamp NOT NULL DEFAULT (now()),
  `creator_uuid` uuid NOT NULL,
  `model_uuid` uuid NOT NULL,
  PRIMARY KEY (`uuid`)
);

CREATE TABLE `fields_references` (
  `source_uuid` uuid NOT NULL,
  `target_uuid` uuid NOT NULL,
  `field_name` varchar(255) NOT NULL COMMENT 'Name of the field in which the content reference was listed.',
  PRIMARY KEY (`source_uuid`, `target_uuid`)
);

CREATE TABLE `fields_contents` (
  `fields_uuid` uuid NOT NULL,
  `content_uuid` uuid,
  `webroot_path_info` varchar(255) UNIQUE COMMENT 'prefixed with branch',
  `content_type` ENUM ('D', 'P', 'I') NOT NULL COMMENT 'D or P for draft and published'
);

CREATE TABLE `fields` (
  `uuid` uuid PRIMARY KEY AUTO_INCREMENT,
  `content_uuid` uuid COMMENT 'Reference to the content that uses this fields record',
  `fields_json` varchar(255) COMMENT 'JSON which contains the actual fields content',
  `language_tag` varchar(255),
  `edited` timestamp DEFAULT (now()),
  `editor_uuid` uuid,
  `modelversion_uuid` uuid,
  `version` int,
  PRIMARY KEY (`uuid`)
);

CREATE TABLE `fields_assets` (
  `field_uuid` uuid,
  `asset_uuid` uuid,
  `field_name` varchar(255),
  PRIMARY KEY (`field_uuid`, `asset_uuid`)
);

CREATE TABLE `namespaces` (
  `uuid` uuid PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255) UNIQUE NOT NULL,
  `root_conten_uuid` uuid,
  `meta` varchar(255) COMMENT 'Custom meta properties to the element',
  `path_prefix` varchar(255) COMMENT 'Prefix for webroot paths',
  `model_filters` varchar(255) COMMENT 'filter for models that can be used in the namespace',
  `created` timestamp NOT NULL DEFAULT (now()),
  `creator_uuid` uuid NOT NULL,
  `edited` timestamp DEFAULT (now()),
  `editor_uuid` uuid,
  PRIMARY KEY (`uuid`)
);

CREATE TABLE `models` (
  `uuid` uuid PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255) UNIQUE NOT NULL,
  `latest_version_uuid` uuid,
  `created` timestamp NOT NULL DEFAULT (now()),
  `creator_uuid` uuid NOT NULL,
  `edited` timestamp DEFAULT (now()),
  `editor_uuid` uuid
);

CREATE TABLE `model_versions` (
  `uuid` uuid PRIMARY KEY AUTO_INCREMENT,
  `model_uuid` uuid,
  `json` varchar(255) NOT NULL,
  `next_version_uuid` uuid,
  `prev_version_uuid` uuid,
  PRIMARY KEY (`uuid`)
);

CREATE TABLE `languages` (
  `uuid` uuid PRIMARY KEY AUTO_INCREMENT,
  `native_name` varchar(255) NOT NULL,
  `tag` varchar(255) UNIQUE NOT NULL,
  `meta` varchar(255) COMMENT 'Custom meta properties to the element',
  PRIMARY KEY (`uuid`)
);

CREATE TABLE `extensions` (
  `uuid` uuid PRIMARY KEY AUTO_INCREMENT,
  `url` varchar(255) NOT NULL,
  `kind` varchar(255) COMMENT 'Defines the type of the extension service',
  `status` varchar(255),
  `meta` varchar(255) COMMENT 'Custom meta properties to the element',
  `created` timestamp NOT NULL DEFAULT (now()),
  `creator_uuid` uuid NOT NULL,
  `edited` timestamp DEFAULT (now()),
  `editor_uuid` uuid
);

CREATE TABLE `webhooks` (
  `uuid` uuid PRIMARY KEY AUTO_INCREMENT,
  `url` varchar(255) NOT NULL,
  `status` varchar(255),
  `active` boolean NOT NULL DEFAULT true,
  `triggers` varchar(255),
  `secretToken` varchar(255) COMMENT 'Secret token which webhook services can use to authenticate the request.',
  `meta` varchar(255) COMMENT 'Custom meta properties to the element',
  `created` timestamp NOT NULL DEFAULT (now()),
  `creator_uuid` uuid NOT NULL,
  `edited` timestamp DEFAULT (now()),
  `editor_uuid` uuid
);

ALTER TABLE `users` ADD FOREIGN KEY (`creator_uuid`) REFERENCES `users` (`uuid`);

ALTER TABLE `users` ADD FOREIGN KEY (`editor_uuid`) REFERENCES `users` (`uuid`);

ALTER TABLE `user_tokens` ADD FOREIGN KEY (`user_uuid`) REFERENCES `users` (`uuid`);

ALTER TABLE `roles` ADD FOREIGN KEY (`creator_uuid`) REFERENCES `users` (`uuid`);

ALTER TABLE `roles` ADD FOREIGN KEY (`editor_uuid`) REFERENCES `users` (`uuid`);

ALTER TABLE `role_permissions` ADD FOREIGN KEY (`role_uuid`) REFERENCES `roles` (`uuid`);

ALTER TABLE `groups` ADD FOREIGN KEY (`creator_uuid`) REFERENCES `users` (`uuid`);

ALTER TABLE `groups` ADD FOREIGN KEY (`editor_uuid`) REFERENCES `users` (`uuid`);

ALTER TABLE `roles_groups` ADD FOREIGN KEY (`group_uuid`) REFERENCES `groups` (`uuid`);

ALTER TABLE `roles_groups` ADD FOREIGN KEY (`role_uuid`) REFERENCES `roles` (`uuid`);

ALTER TABLE `user_groups` ADD FOREIGN KEY (`user_uuid`) REFERENCES `users` (`uuid`);

ALTER TABLE `user_groups` ADD FOREIGN KEY (`group_uuid`) REFERENCES `groups` (`uuid`);

ALTER TABLE `tags` ADD FOREIGN KEY (`creator_uuid`) REFERENCES `users` (`uuid`);

ALTER TABLE `tags` ADD FOREIGN KEY (`editor_uuid`) REFERENCES `users` (`uuid`);

ALTER TABLE `tags_namespaces` ADD FOREIGN KEY (`tag_uuid`) REFERENCES `tags` (`uuid`);

ALTER TABLE `tags_namespaces` ADD FOREIGN KEY (`namespace_uuid`) REFERENCES `namespaces` (`uuid`);

ALTER TABLE `tags_contents` ADD FOREIGN KEY (`tag_uuid`) REFERENCES `tags` (`uuid`);

ALTER TABLE `tags_contents` ADD FOREIGN KEY (`content_uuid`) REFERENCES `contents` (`uuid`);

ALTER TABLE `assets` ADD FOREIGN KEY (`creator_uuid`) REFERENCES `users` (`uuid`);

ALTER TABLE `assets` ADD FOREIGN KEY (`editor_uuid`) REFERENCES `users` (`uuid`);

ALTER TABLE `assets_timeline` ADD FOREIGN KEY (`asset_uuid`) REFERENCES `assets` (`uuid`);

ALTER TABLE `assets_timeline_tags` ADD FOREIGN KEY (`assettimeline_uuid`) REFERENCES `assets_timeline` (`uuid`);

ALTER TABLE `assets_timeline_tags` ADD FOREIGN KEY (`tag_uuid`) REFERENCES `tags` (`uuid`);

ALTER TABLE `contents` ADD FOREIGN KEY (`namespace_uuid`) REFERENCES `namespaces` (`uuid`);

ALTER TABLE `contents` ADD FOREIGN KEY (`parent`) REFERENCES `contents` (`uuid`);

ALTER TABLE `contents` ADD FOREIGN KEY (`creator_uuid`) REFERENCES `users` (`uuid`);

ALTER TABLE `contents` ADD FOREIGN KEY (`model_uuid`) REFERENCES `models` (`uuid`);

ALTER TABLE `fields_references` ADD FOREIGN KEY (`source_uuid`) REFERENCES `fields` (`uuid`);

ALTER TABLE `fields_references` ADD FOREIGN KEY (`target_uuid`) REFERENCES `fields` (`uuid`);

ALTER TABLE `fields_contents` ADD FOREIGN KEY (`fields_uuid`) REFERENCES `fields` (`uuid`);

ALTER TABLE `fields_contents` ADD FOREIGN KEY (`content_uuid`) REFERENCES `contents` (`uuid`);

ALTER TABLE `fields` ADD FOREIGN KEY (`content_uuid`) REFERENCES `namespaces` (`uuid`);

ALTER TABLE `fields` ADD FOREIGN KEY (`editor_uuid`) REFERENCES `users` (`uuid`);

ALTER TABLE `fields` ADD FOREIGN KEY (`modelversion_uuid`) REFERENCES `model_versions` (`uuid`);

ALTER TABLE `fields_assets` ADD FOREIGN KEY (`field_uuid`) REFERENCES `fields` (`uuid`);

ALTER TABLE `fields_assets` ADD FOREIGN KEY (`asset_uuid`) REFERENCES `assets` (`uuid`);

ALTER TABLE `namespaces` ADD FOREIGN KEY (`root_conten_uuid`) REFERENCES `contents` (`uuid`);

ALTER TABLE `namespaces` ADD FOREIGN KEY (`creator_uuid`) REFERENCES `users` (`uuid`);

ALTER TABLE `namespaces` ADD FOREIGN KEY (`editor_uuid`) REFERENCES `users` (`uuid`);

ALTER TABLE `models` ADD FOREIGN KEY (`latest_version_uuid`) REFERENCES `model_versions` (`uuid`);

ALTER TABLE `models` ADD FOREIGN KEY (`creator_uuid`) REFERENCES `users` (`uuid`);

ALTER TABLE `models` ADD FOREIGN KEY (`editor_uuid`) REFERENCES `users` (`uuid`);

ALTER TABLE `model_versions` ADD FOREIGN KEY (`model_uuid`) REFERENCES `models` (`uuid`);

ALTER TABLE `model_versions` ADD FOREIGN KEY (`next_version_uuid`) REFERENCES `model_versions` (`uuid`);

ALTER TABLE `model_versions` ADD FOREIGN KEY (`prev_version_uuid`) REFERENCES `model_versions` (`uuid`);

ALTER TABLE `extensions` ADD FOREIGN KEY (`creator_uuid`) REFERENCES `users` (`uuid`);

ALTER TABLE `extensions` ADD FOREIGN KEY (`editor_uuid`) REFERENCES `users` (`uuid`);

ALTER TABLE `webhooks` ADD FOREIGN KEY (`creator_uuid`) REFERENCES `users` (`uuid`);

ALTER TABLE `webhooks` ADD FOREIGN KEY (`editor_uuid`) REFERENCES `users` (`uuid`);

CREATE UNIQUE INDEX `users_index_0` ON `users` (`username`);

CREATE INDEX `user_tokens_index_1` ON `user_tokens` (`user_uuid`);

CREATE UNIQUE INDEX `roles_index_2` ON `roles` (`name`);

CREATE UNIQUE INDEX `groups_index_3` ON `groups` (`name`);

CREATE UNIQUE INDEX `tags_index_4` ON `tags` (`name`, `collection`);

CREATE INDEX `fields_contents_index_5` ON `fields_contents` (`content_uuid`, `content_type`);

CREATE INDEX `fields_contents_index_6` ON `fields_contents` (`content_type`, `webroot_path_info`);

CREATE UNIQUE INDEX `namespaces_index_7` ON `namespaces` (`name`);

CREATE INDEX `languages_index_8` ON `languages` (`tag`);

ALTER TABLE `assets_timeline` COMMENT = "This table contains asset timeline entries";

ALTER TABLE `fields_references` COMMENT = "This table is mainly used to lookup foreign references to contents";

ALTER TABLE `fields_contents` COMMENT = "Crosstable that tracks all fields for a content";

ALTER TABLE `fields` COMMENT = "Table which stores the actual fields content as JSON";

ALTER TABLE `fields_assets` COMMENT = "Crosstable which tracks the used assets in a fields record";

ALTER TABLE `extensions` COMMENT = "Table which lists the registered extensions";

ALTER TABLE `webhooks` COMMENT = "Table which stores the registered webhooks";
