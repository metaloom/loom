package io.metaloom.loom.db.jooq.tables.mappers;

import io.vertx.sqlclient.Row;
import java.util.function.Function;

public class RowMappers {

        private RowMappers(){}

        public static Function<Row,io.metaloom.loom.db.jooq.tables.pojos.Asset> getAssetMapper() {
                return row -> {
                        io.metaloom.loom.db.jooq.tables.pojos.Asset pojo = new io.metaloom.loom.db.jooq.tables.pojos.Asset();
                        pojo.setUuid(row.getUUID("uuid"));
                        pojo.setAssetBinaryUuid(row.getUUID("asset_binary_uuid"));
                        pojo.setNamespaceUuid(row.getUUID("namespace_uuid"));
                        pojo.setFilename(row.getString("filename"));
                        pojo.setLocalpath(row.getString("localPath"));
                        pojo.setMeta(row.getString("meta"));
                        pojo.setRating(row.getInteger("rating"));
                        pojo.setDominantcolor(row.getString("dominantColor"));
                        pojo.setMimetype(row.getString("mimeType"));
                        pojo.setGpsLon(row.getBigDecimal("gps_lon"));
                        pojo.setGpsLat(row.getBigDecimal("gps_lat"));
                        pojo.setS3BucketName(row.getString("s3_bucket_name"));
                        pojo.setS3ObjectPath(row.getString("s3_object_path"));
                        pojo.setCreated(row.getLocalDateTime("created"));
                        pojo.setCreatorUuid(row.getUUID("creator_uuid"));
                        pojo.setEdited(row.getLocalDateTime("edited"));
                        pojo.setEditorUuid(row.getUUID("editor_uuid"));
                        return pojo;
                };
        }

        public static Function<Row,io.metaloom.loom.db.jooq.tables.pojos.AssetBinary> getAssetBinaryMapper() {
                return row -> {
                        io.metaloom.loom.db.jooq.tables.pojos.AssetBinary pojo = new io.metaloom.loom.db.jooq.tables.pojos.AssetBinary();
                        pojo.setUuid(row.getUUID("uuid"));
                        pojo.setSha512sum(row.getString("sha512sum"));
                        pojo.setSize(row.getInteger("size"));
                        pojo.setSha256sum(row.getString("sha256sum"));
                        pojo.setMd5sum(row.getString("md5sum"));
                        pojo.setMediaWidth(row.getInteger("media_width"));
                        pojo.setMediaHeight(row.getInteger("media_height"));
                        pojo.setFingerprint(row.getString("fingerprint"));
                        return pojo;
                };
        }

        public static Function<Row,io.metaloom.loom.db.jooq.tables.pojos.AssetTimeline> getAssetTimelineMapper() {
                return row -> {
                        io.metaloom.loom.db.jooq.tables.pojos.AssetTimeline pojo = new io.metaloom.loom.db.jooq.tables.pojos.AssetTimeline();
                        pojo.setUuid(row.getUUID("uuid"));
                        pojo.setAssetUuid(row.getUUID("asset_uuid"));
                        pojo.setFrom(row.getInteger("from"));
                        pojo.setTo(row.getInteger("to"));
                        pojo.setDescription(row.getString("description"));
                        pojo.setTags(row.getString("tags"));
                        pojo.setMeta(row.getString("meta"));
                        pojo.setThumbail(row.getString("thumbail"));
                        return pojo;
                };
        }

        public static Function<Row,io.metaloom.loom.db.jooq.tables.pojos.AssetUserMeta> getAssetUserMetaMapper() {
                return row -> {
                        io.metaloom.loom.db.jooq.tables.pojos.AssetUserMeta pojo = new io.metaloom.loom.db.jooq.tables.pojos.AssetUserMeta();
                        pojo.setAssetUuid(row.getUUID("asset_uuid"));
                        pojo.setUserUuid(row.getUUID("user_uuid"));
                        pojo.setRating(row.getInteger("rating"));
                        pojo.setMeta(row.getString("meta"));
                        return pojo;
                };
        }

        public static Function<Row,io.metaloom.loom.db.jooq.tables.pojos.Content> getContentMapper() {
                return row -> {
                        io.metaloom.loom.db.jooq.tables.pojos.Content pojo = new io.metaloom.loom.db.jooq.tables.pojos.Content();
                        pojo.setUuid(row.getUUID("uuid"));
                        pojo.setNamespaceUuid(row.getUUID("namespace_uuid"));
                        pojo.setParent(row.getUUID("parent"));
                        pojo.setCreated(row.getLocalDateTime("created"));
                        pojo.setCreatorUuid(row.getUUID("creator_uuid"));
                        pojo.setModelUuid(row.getUUID("model_uuid"));
                        return pojo;
                };
        }

        public static Function<Row,io.metaloom.loom.db.jooq.tables.pojos.ContentUserMeta> getContentUserMetaMapper() {
                return row -> {
                        io.metaloom.loom.db.jooq.tables.pojos.ContentUserMeta pojo = new io.metaloom.loom.db.jooq.tables.pojos.ContentUserMeta();
                        pojo.setContentUuid(row.getUUID("content_uuid"));
                        pojo.setUserUuid(row.getUUID("user_uuid"));
                        pojo.setRating(row.getInteger("rating"));
                        pojo.setMeta(row.getString("meta"));
                        return pojo;
                };
        }

        public static Function<Row,io.metaloom.loom.db.jooq.tables.pojos.Extension> getExtensionMapper() {
                return row -> {
                        io.metaloom.loom.db.jooq.tables.pojos.Extension pojo = new io.metaloom.loom.db.jooq.tables.pojos.Extension();
                        pojo.setUuid(row.getUUID("uuid"));
                        pojo.setUrl(row.getString("url"));
                        pojo.setKind(java.util.Arrays.stream(io.metaloom.loom.db.jooq.enums.LoomExtensionType.values()).filter(td -> td.getLiteral().equals(row.getString("kind"))).findFirst().orElse(null));
                        pojo.setStatus(row.getString("status"));
                        pojo.setMeta(row.getString("meta"));
                        pojo.setCreated(row.getLocalDateTime("created"));
                        pojo.setCreatorUuid(row.getUUID("creator_uuid"));
                        pojo.setEdited(row.getLocalDateTime("edited"));
                        pojo.setEditorUuid(row.getUUID("editor_uuid"));
                        return pojo;
                };
        }

        public static Function<Row,io.metaloom.loom.db.jooq.tables.pojos.Field> getFieldMapper() {
                return row -> {
                        io.metaloom.loom.db.jooq.tables.pojos.Field pojo = new io.metaloom.loom.db.jooq.tables.pojos.Field();
                        pojo.setUuid(row.getUUID("uuid"));
                        pojo.setContentUuid(row.getUUID("content_uuid"));
                        pojo.setFieldsJson(row.getString("fields_json"));
                        pojo.setLanguageUuid(row.getUUID("language_uuid"));
                        pojo.setEdited(row.getLocalDateTime("edited"));
                        pojo.setEditorUuid(row.getUUID("editor_uuid"));
                        pojo.setModelversionUuid(row.getUUID("modelversion_uuid"));
                        pojo.setVersion(row.getInteger("version"));
                        return pojo;
                };
        }

        public static Function<Row,io.metaloom.loom.db.jooq.tables.pojos.FieldAsset> getFieldAssetMapper() {
                return row -> {
                        io.metaloom.loom.db.jooq.tables.pojos.FieldAsset pojo = new io.metaloom.loom.db.jooq.tables.pojos.FieldAsset();
                        pojo.setFieldUuid(row.getUUID("field_uuid"));
                        pojo.setAssetUuid(row.getUUID("asset_uuid"));
                        pojo.setFieldName(row.getString("field_name"));
                        return pojo;
                };
        }

        public static Function<Row,io.metaloom.loom.db.jooq.tables.pojos.FieldReference> getFieldReferenceMapper() {
                return row -> {
                        io.metaloom.loom.db.jooq.tables.pojos.FieldReference pojo = new io.metaloom.loom.db.jooq.tables.pojos.FieldReference();
                        pojo.setSourceUuid(row.getUUID("source_uuid"));
                        pojo.setTargetUuid(row.getUUID("target_uuid"));
                        pojo.setFieldName(row.getString("field_name"));
                        return pojo;
                };
        }

        public static Function<Row,io.metaloom.loom.db.jooq.tables.pojos.Group> getGroupMapper() {
                return row -> {
                        io.metaloom.loom.db.jooq.tables.pojos.Group pojo = new io.metaloom.loom.db.jooq.tables.pojos.Group();
                        pojo.setUuid(row.getUUID("uuid"));
                        pojo.setName(row.getString("name"));
                        pojo.setMeta(row.getString("meta"));
                        pojo.setCreated(row.getLocalDateTime("created"));
                        pojo.setCreatorUuid(row.getUUID("creator_uuid"));
                        pojo.setEdited(row.getLocalDateTime("edited"));
                        pojo.setEditorUuid(row.getUUID("editor_uuid"));
                        return pojo;
                };
        }

        public static Function<Row,io.metaloom.loom.db.jooq.tables.pojos.Language> getLanguageMapper() {
                return row -> {
                        io.metaloom.loom.db.jooq.tables.pojos.Language pojo = new io.metaloom.loom.db.jooq.tables.pojos.Language();
                        pojo.setUuid(row.getUUID("uuid"));
                        pojo.setNativeName(row.getString("native_name"));
                        pojo.setTag(row.getString("tag"));
                        pojo.setMeta(row.getString("meta"));
                        return pojo;
                };
        }

        public static Function<Row,io.metaloom.loom.db.jooq.tables.pojos.Model> getModelMapper() {
                return row -> {
                        io.metaloom.loom.db.jooq.tables.pojos.Model pojo = new io.metaloom.loom.db.jooq.tables.pojos.Model();
                        pojo.setUuid(row.getUUID("uuid"));
                        pojo.setName(row.getString("name"));
                        pojo.setLatestVersionUuid(row.getUUID("latest_version_uuid"));
                        pojo.setCreated(row.getLocalDateTime("created"));
                        pojo.setCreatorUuid(row.getUUID("creator_uuid"));
                        pojo.setEdited(row.getLocalDateTime("edited"));
                        pojo.setEditorUuid(row.getUUID("editor_uuid"));
                        return pojo;
                };
        }

        public static Function<Row,io.metaloom.loom.db.jooq.tables.pojos.ModelVersion> getModelVersionMapper() {
                return row -> {
                        io.metaloom.loom.db.jooq.tables.pojos.ModelVersion pojo = new io.metaloom.loom.db.jooq.tables.pojos.ModelVersion();
                        pojo.setUuid(row.getUUID("uuid"));
                        pojo.setModelUuid(row.getUUID("model_uuid"));
                        pojo.setJson(row.getString("json"));
                        pojo.setNextVersionUuid(row.getUUID("next_version_uuid"));
                        pojo.setPrevVersionUuid(row.getUUID("prev_version_uuid"));
                        return pojo;
                };
        }

        public static Function<Row,io.metaloom.loom.db.jooq.tables.pojos.Namespace> getNamespaceMapper() {
                return row -> {
                        io.metaloom.loom.db.jooq.tables.pojos.Namespace pojo = new io.metaloom.loom.db.jooq.tables.pojos.Namespace();
                        pojo.setUuid(row.getUUID("uuid"));
                        pojo.setName(row.getString("name"));
                        pojo.setRootContentUuid(row.getUUID("root_content_uuid"));
                        pojo.setMeta(row.getString("meta"));
                        pojo.setPathPrefix(row.getString("path_prefix"));
                        pojo.setModelFilters(row.getString("model_filters"));
                        pojo.setCreated(row.getLocalDateTime("created"));
                        pojo.setCreatorUuid(row.getUUID("creator_uuid"));
                        pojo.setEdited(row.getLocalDateTime("edited"));
                        pojo.setEditorUuid(row.getUUID("editor_uuid"));
                        return pojo;
                };
        }

        public static Function<Row,io.metaloom.loom.db.jooq.tables.pojos.Role> getRoleMapper() {
                return row -> {
                        io.metaloom.loom.db.jooq.tables.pojos.Role pojo = new io.metaloom.loom.db.jooq.tables.pojos.Role();
                        pojo.setUuid(row.getUUID("uuid"));
                        pojo.setName(row.getString("name"));
                        pojo.setPermissions(java.util.Arrays.stream(io.metaloom.loom.db.jooq.enums.LoomPermissionFlag.values()).filter(td -> td.getLiteral().equals(row.getString("permissions"))).findFirst().orElse(null));
                        pojo.setMeta(row.getString("meta"));
                        pojo.setCreated(row.getLocalDateTime("created"));
                        pojo.setCreatorUuid(row.getUUID("creator_uuid"));
                        pojo.setEdited(row.getLocalDateTime("edited"));
                        pojo.setEditorUuid(row.getUUID("editor_uuid"));
                        return pojo;
                };
        }

        public static Function<Row,io.metaloom.loom.db.jooq.tables.pojos.RoleGroup> getRoleGroupMapper() {
                return row -> {
                        io.metaloom.loom.db.jooq.tables.pojos.RoleGroup pojo = new io.metaloom.loom.db.jooq.tables.pojos.RoleGroup();
                        pojo.setGroupUuid(row.getUUID("group_uuid"));
                        pojo.setRoleUuid(row.getUUID("role_uuid"));
                        return pojo;
                };
        }

        public static Function<Row,io.metaloom.loom.db.jooq.tables.pojos.RolePermission> getRolePermissionMapper() {
                return row -> {
                        io.metaloom.loom.db.jooq.tables.pojos.RolePermission pojo = new io.metaloom.loom.db.jooq.tables.pojos.RolePermission();
                        pojo.setRoleUuid(row.getUUID("role_uuid"));
                        pojo.setElementUuid(row.getUUID("element_uuid"));
                        pojo.setCreatePerm(row.getBoolean("create_perm"));
                        pojo.setReadPerm(row.getBoolean("read_perm"));
                        pojo.setDeletePerm(row.getBoolean("delete_perm"));
                        pojo.setUpdatePerm(row.getBoolean("update_perm"));
                        pojo.setReadPublishPerm(row.getBoolean("read_publish_perm"));
                        pojo.setPublishPerm(row.getBoolean("publish_perm"));
                        return pojo;
                };
        }

        public static Function<Row,io.metaloom.loom.db.jooq.tables.pojos.Tag> getTagMapper() {
                return row -> {
                        io.metaloom.loom.db.jooq.tables.pojos.Tag pojo = new io.metaloom.loom.db.jooq.tables.pojos.Tag();
                        pojo.setUuid(row.getUUID("uuid"));
                        pojo.setName(row.getString("name"));
                        pojo.setCollection(row.getString("collection"));
                        pojo.setNamespaceUuid(row.getUUID("namespace_uuid"));
                        pojo.setMeta(row.getString("meta"));
                        pojo.setRating(row.getInteger("rating"));
                        pojo.setCreated(row.getLocalDateTime("created"));
                        pojo.setCreatorUuid(row.getUUID("creator_uuid"));
                        pojo.setEdited(row.getLocalDateTime("edited"));
                        pojo.setEditorUuid(row.getUUID("editor_uuid"));
                        return pojo;
                };
        }

        public static Function<Row,io.metaloom.loom.db.jooq.tables.pojos.TagAsset> getTagAssetMapper() {
                return row -> {
                        io.metaloom.loom.db.jooq.tables.pojos.TagAsset pojo = new io.metaloom.loom.db.jooq.tables.pojos.TagAsset();
                        pojo.setTagUuid(row.getUUID("tag_uuid"));
                        pojo.setAssetUuid(row.getUUID("asset_uuid"));
                        return pojo;
                };
        }

        public static Function<Row,io.metaloom.loom.db.jooq.tables.pojos.TagContent> getTagContentMapper() {
                return row -> {
                        io.metaloom.loom.db.jooq.tables.pojos.TagContent pojo = new io.metaloom.loom.db.jooq.tables.pojos.TagContent();
                        pojo.setTagUuid(row.getUUID("tag_uuid"));
                        pojo.setContentUuid(row.getUUID("content_uuid"));
                        return pojo;
                };
        }

        public static Function<Row,io.metaloom.loom.db.jooq.tables.pojos.TagNamespace> getTagNamespaceMapper() {
                return row -> {
                        io.metaloom.loom.db.jooq.tables.pojos.TagNamespace pojo = new io.metaloom.loom.db.jooq.tables.pojos.TagNamespace();
                        pojo.setTagUuid(row.getUUID("tag_uuid"));
                        pojo.setNamespaceUuid(row.getUUID("namespace_uuid"));
                        return pojo;
                };
        }

        public static Function<Row,io.metaloom.loom.db.jooq.tables.pojos.User> getUserMapper() {
                return row -> {
                        io.metaloom.loom.db.jooq.tables.pojos.User pojo = new io.metaloom.loom.db.jooq.tables.pojos.User();
                        pojo.setUuid(row.getUUID("uuid"));
                        pojo.setUsername(row.getString("username"));
                        pojo.setFirstname(row.getString("firstname"));
                        pojo.setLastname(row.getString("lastname"));
                        pojo.setEmail(row.getString("email"));
                        pojo.setEnabled(row.getBoolean("enabled"));
                        pojo.setSso(row.getBoolean("sso"));
                        pojo.setMeta(row.getString("meta"));
                        pojo.setPermissions(java.util.Arrays.stream(io.metaloom.loom.db.jooq.enums.LoomPermissionFlag.values()).filter(td -> td.getLiteral().equals(row.getString("permissions"))).findFirst().orElse(null));
                        pojo.setCreated(row.getLocalDateTime("created"));
                        pojo.setCreatorUuid(row.getUUID("creator_uuid"));
                        pojo.setEdited(row.getLocalDateTime("edited"));
                        pojo.setEditorUuid(row.getUUID("editor_uuid"));
                        pojo.setPasswordhash(row.getString("passwordhash"));
                        return pojo;
                };
        }

        public static Function<Row,io.metaloom.loom.db.jooq.tables.pojos.UserGroup> getUserGroupMapper() {
                return row -> {
                        io.metaloom.loom.db.jooq.tables.pojos.UserGroup pojo = new io.metaloom.loom.db.jooq.tables.pojos.UserGroup();
                        pojo.setUserUuid(row.getUUID("user_uuid"));
                        pojo.setGroupUuid(row.getUUID("group_uuid"));
                        return pojo;
                };
        }

        public static Function<Row,io.metaloom.loom.db.jooq.tables.pojos.UserToken> getUserTokenMapper() {
                return row -> {
                        io.metaloom.loom.db.jooq.tables.pojos.UserToken pojo = new io.metaloom.loom.db.jooq.tables.pojos.UserToken();
                        pojo.setUuid(row.getUUID("uuid"));
                        pojo.setUserUuid(row.getUUID("user_uuid"));
                        pojo.setNote(row.getString("note"));
                        pojo.setToken(row.getString("token"));
                        pojo.setPermissions(java.util.Arrays.stream(io.metaloom.loom.db.jooq.enums.LoomPermissionFlag.values()).filter(td -> td.getLiteral().equals(row.getString("permissions"))).findFirst().orElse(null));
                        return pojo;
                };
        }

        public static Function<Row,io.metaloom.loom.db.jooq.tables.pojos.Webhook> getWebhookMapper() {
                return row -> {
                        io.metaloom.loom.db.jooq.tables.pojos.Webhook pojo = new io.metaloom.loom.db.jooq.tables.pojos.Webhook();
                        pojo.setUuid(row.getUUID("uuid"));
                        pojo.setUrl(row.getString("url"));
                        pojo.setStatus(row.getString("status"));
                        pojo.setActive(row.getBoolean("active"));
                        pojo.setTriggers(java.util.Arrays.stream(io.metaloom.loom.db.jooq.enums.LoomEvents.values()).filter(td -> td.getLiteral().equals(row.getString("triggers"))).findFirst().orElse(null));
                        pojo.setSecrettoken(row.getString("secretToken"));
                        pojo.setMeta(row.getString("meta"));
                        pojo.setCreated(row.getLocalDateTime("created"));
                        pojo.setCreatorUuid(row.getUUID("creator_uuid"));
                        pojo.setEdited(row.getLocalDateTime("edited"));
                        pojo.setEditorUuid(row.getUUID("editor_uuid"));
                        return pojo;
                };
        }

}
