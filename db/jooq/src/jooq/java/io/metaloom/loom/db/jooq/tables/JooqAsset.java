/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables;


import io.metaloom.loom.db.jooq.Indexes;
import io.metaloom.loom.db.jooq.JooqPublic;
import io.metaloom.loom.db.jooq.Keys;
import io.metaloom.loom.db.jooq.converter.JsonObjectConverter;
import io.metaloom.loom.db.jooq.tables.records.JooqAssetRecord;
import io.vertx.core.json.JsonObject;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This table stores information on the asset component of the asset
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqAsset extends TableImpl<JooqAssetRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.asset</code>
     */
    public static final JooqAsset ASSET = new JooqAsset();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JooqAssetRecord> getRecordType() {
        return JooqAssetRecord.class;
    }

    /**
     * The column <code>public.asset.uuid</code>.
     */
    public final TableField<JooqAssetRecord, java.util.UUID> UUID = createField(DSL.name("uuid"), SQLDataType.UUID.defaultValue(DSL.field("uuid_generate_v4()", SQLDataType.UUID)), this, "");

    /**
     * The column <code>public.asset.sha512sum</code>.
     */
    public final TableField<JooqAssetRecord, String> SHA512SUM = createField(DSL.name("sha512sum"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.asset.size</code>.
     */
    public final TableField<JooqAssetRecord, Long> SIZE = createField(DSL.name("size"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.asset.sha256sum</code>.
     */
    public final TableField<JooqAssetRecord, String> SHA256SUM = createField(DSL.name("sha256sum"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.asset.md5sum</code>.
     */
    public final TableField<JooqAssetRecord, String> MD5SUM = createField(DSL.name("md5sum"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.asset.chunk_hash</code>.
     */
    public final TableField<JooqAssetRecord, String> CHUNK_HASH = createField(DSL.name("chunk_hash"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.asset.zero_chunk_count</code>.
     */
    public final TableField<JooqAssetRecord, Long> ZERO_CHUNK_COUNT = createField(DSL.name("zero_chunk_count"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.asset.mime_type</code>.
     */
    public final TableField<JooqAssetRecord, String> MIME_TYPE = createField(DSL.name("mime_type"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.asset.filename</code>.
     */
    public final TableField<JooqAssetRecord, String> FILENAME = createField(DSL.name("filename"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.asset.initial_origin</code>. Document the initial
     * origin of the asset (e.g. first filepath encountered, first s3 path, url,
     * hash)
     */
    public final TableField<JooqAssetRecord, String> INITIAL_ORIGIN = createField(DSL.name("initial_origin"), SQLDataType.VARCHAR.nullable(false), this, "Document the initial origin of the asset (e.g. first filepath encountered, first s3 path, url, hash)");

    /**
     * The column <code>public.asset.first_seen</code>.
     */
    public final TableField<JooqAssetRecord, LocalDateTime> FIRST_SEEN = createField(DSL.name("first_seen"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.asset.meta</code>. Custom meta properties to the
     * asset
     */
    public final TableField<JooqAssetRecord, JsonObject> META = createField(DSL.name("meta"), SQLDataType.JSONB, this, "Custom meta properties to the asset", new JsonObjectConverter());

    /**
     * The column <code>public.asset.geo_lon</code>.
     */
    public final TableField<JooqAssetRecord, BigDecimal> GEO_LON = createField(DSL.name("geo_lon"), SQLDataType.NUMERIC(9, 6), this, "");

    /**
     * The column <code>public.asset.geo_lat</code>.
     */
    public final TableField<JooqAssetRecord, BigDecimal> GEO_LAT = createField(DSL.name("geo_lat"), SQLDataType.NUMERIC(8, 6), this, "");

    /**
     * The column <code>public.asset.geo_alias</code>.
     */
    public final TableField<JooqAssetRecord, String> GEO_ALIAS = createField(DSL.name("geo_alias"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.asset.created</code>.
     */
    public final TableField<JooqAssetRecord, LocalDateTime> CREATED = createField(DSL.name("created"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.asset.creator_uuid</code>.
     */
    public final TableField<JooqAssetRecord, java.util.UUID> CREATOR_UUID = createField(DSL.name("creator_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.asset.edited</code>.
     */
    public final TableField<JooqAssetRecord, LocalDateTime> EDITED = createField(DSL.name("edited"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.asset.editor_uuid</code>.
     */
    public final TableField<JooqAssetRecord, java.util.UUID> EDITOR_UUID = createField(DSL.name("editor_uuid"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.asset.s3_bucket_name</code>.
     */
    public final TableField<JooqAssetRecord, String> S3_BUCKET_NAME = createField(DSL.name("s3_bucket_name"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.asset.s3_object_path</code>.
     */
    public final TableField<JooqAssetRecord, String> S3_OBJECT_PATH = createField(DSL.name("s3_object_path"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.asset.media_width</code>. Only set for images,
     * video
     */
    public final TableField<JooqAssetRecord, Integer> MEDIA_WIDTH = createField(DSL.name("media_width"), SQLDataType.INTEGER, this, "Only set for images, video");

    /**
     * The column <code>public.asset.media_height</code>. Only set for images,
     * video
     */
    public final TableField<JooqAssetRecord, Integer> MEDIA_HEIGHT = createField(DSL.name("media_height"), SQLDataType.INTEGER, this, "Only set for images, video");

    /**
     * The column <code>public.asset.media_duration</code>. Duration of the
     * video, audio
     */
    public final TableField<JooqAssetRecord, Integer> MEDIA_DURATION = createField(DSL.name("media_duration"), SQLDataType.INTEGER, this, "Duration of the video, audio");

    /**
     * The column <code>public.asset.video_width</code>.
     */
    public final TableField<JooqAssetRecord, Integer> VIDEO_WIDTH = createField(DSL.name("video_width"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.asset.video_height</code>.
     */
    public final TableField<JooqAssetRecord, Integer> VIDEO_HEIGHT = createField(DSL.name("video_height"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.asset.video_fingerprint</code>. Video fingerprint
     * information
     */
    public final TableField<JooqAssetRecord, String> VIDEO_FINGERPRINT = createField(DSL.name("video_fingerprint"), SQLDataType.VARCHAR, this, "Video fingerprint information");

    /**
     * The column <code>public.asset.video_bitrate</code>.
     */
    public final TableField<JooqAssetRecord, Integer> VIDEO_BITRATE = createField(DSL.name("video_bitrate"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.asset.video_encoding</code>.
     */
    public final TableField<JooqAssetRecord, String> VIDEO_ENCODING = createField(DSL.name("video_encoding"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.asset.image_dominant_color</code>.
     */
    public final TableField<JooqAssetRecord, String> IMAGE_DOMINANT_COLOR = createField(DSL.name("image_dominant_color"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.asset.image_encoding</code>.
     */
    public final TableField<JooqAssetRecord, String> IMAGE_ENCODING = createField(DSL.name("image_encoding"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.asset.image_fingerprint</code>. Image fingerprint
     * information
     */
    public final TableField<JooqAssetRecord, String> IMAGE_FINGERPRINT = createField(DSL.name("image_fingerprint"), SQLDataType.VARCHAR, this, "Image fingerprint information");

    /**
     * The column <code>public.asset.audio_bpm</code>.
     */
    public final TableField<JooqAssetRecord, Integer> AUDIO_BPM = createField(DSL.name("audio_bpm"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.asset.audio_sampling_rate</code>.
     */
    public final TableField<JooqAssetRecord, Integer> AUDIO_SAMPLING_RATE = createField(DSL.name("audio_sampling_rate"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.asset.audio_channels</code>.
     */
    public final TableField<JooqAssetRecord, Integer> AUDIO_CHANNELS = createField(DSL.name("audio_channels"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.asset.audio_bitrate</code>.
     */
    public final TableField<JooqAssetRecord, Integer> AUDIO_BITRATE = createField(DSL.name("audio_bitrate"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.asset.audio_encoding</code>. Store the audio
     * encoding used for the asset (e.g. mp3, flac)
     */
    public final TableField<JooqAssetRecord, String> AUDIO_ENCODING = createField(DSL.name("audio_encoding"), SQLDataType.VARCHAR, this, "Store the audio encoding used for the asset (e.g. mp3, flac)");

    /**
     * The column <code>public.asset.audio_fingerprint</code>. Audio fingerprint
     * information
     */
    public final TableField<JooqAssetRecord, String> AUDIO_FINGERPRINT = createField(DSL.name("audio_fingerprint"), SQLDataType.VARCHAR, this, "Audio fingerprint information");

    /**
     * The column <code>public.asset.doc_plain_text</code>. Extracted text of
     * the document
     */
    public final TableField<JooqAssetRecord, String> DOC_PLAIN_TEXT = createField(DSL.name("doc_plain_text"), SQLDataType.VARCHAR, this, "Extracted text of the document");

    /**
     * The column <code>public.asset.doc_word_count</code>.
     */
    public final TableField<JooqAssetRecord, Integer> DOC_WORD_COUNT = createField(DSL.name("doc_word_count"), SQLDataType.INTEGER, this, "");

    private JooqAsset(Name alias, Table<JooqAssetRecord> aliased) {
        this(alias, aliased, null);
    }

    private JooqAsset(Name alias, Table<JooqAssetRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("This table stores information on the asset component of the asset"), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.asset</code> table reference
     */
    public JooqAsset(String alias) {
        this(DSL.name(alias), ASSET);
    }

    /**
     * Create an aliased <code>public.asset</code> table reference
     */
    public JooqAsset(Name alias) {
        this(alias, ASSET);
    }

    /**
     * Create a <code>public.asset</code> table reference
     */
    public JooqAsset() {
        this(DSL.name("asset"), null);
    }

    public <O extends Record> JooqAsset(Table<O> child, ForeignKey<O, JooqAssetRecord> key) {
        super(child, key, ASSET);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : JooqPublic.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.ASSET_GEO_LON_GEO_LAT_IDX, Indexes.ASSET_UUID_IDX);
    }

    @Override
    public UniqueKey<JooqAssetRecord> getPrimaryKey() {
        return Keys.ASSET_PKEY;
    }

    @Override
    public List<ForeignKey<JooqAssetRecord, ?>> getReferences() {
        return Arrays.asList(Keys.ASSET__ASSET_CREATOR_UUID_FKEY, Keys.ASSET__ASSET_EDITOR_UUID_FKEY);
    }

    private transient JooqUser _assetCreatorUuidFkey;
    private transient JooqUser _assetEditorUuidFkey;

    /**
     * Get the implicit join path to the <code>public.user</code> table, via the
     * <code>asset_creator_uuid_fkey</code> key.
     */
    public JooqUser assetCreatorUuidFkey() {
        if (_assetCreatorUuidFkey == null)
            _assetCreatorUuidFkey = new JooqUser(this, Keys.ASSET__ASSET_CREATOR_UUID_FKEY);

        return _assetCreatorUuidFkey;
    }

    /**
     * Get the implicit join path to the <code>public.user</code> table, via the
     * <code>asset_editor_uuid_fkey</code> key.
     */
    public JooqUser assetEditorUuidFkey() {
        if (_assetEditorUuidFkey == null)
            _assetEditorUuidFkey = new JooqUser(this, Keys.ASSET__ASSET_EDITOR_UUID_FKEY);

        return _assetEditorUuidFkey;
    }

    @Override
    public JooqAsset as(String alias) {
        return new JooqAsset(DSL.name(alias), this);
    }

    @Override
    public JooqAsset as(Name alias) {
        return new JooqAsset(alias, this);
    }

    @Override
    public JooqAsset as(Table<?> alias) {
        return new JooqAsset(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqAsset rename(String name) {
        return new JooqAsset(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqAsset rename(Name name) {
        return new JooqAsset(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public JooqAsset rename(Table<?> name) {
        return new JooqAsset(name.getQualifiedName(), null);
    }
}
