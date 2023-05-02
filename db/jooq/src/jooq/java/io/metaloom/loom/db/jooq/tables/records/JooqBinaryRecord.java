/*
 * This file is generated by jOOQ.
 */
package io.metaloom.loom.db.jooq.tables.records;


import io.metaloom.loom.db.jooq.tables.JooqBinary;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.JSONB;
import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This table stores information on the binary component of the asset
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqBinaryRecord extends UpdatableRecordImpl<JooqBinaryRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.binary.uuid</code>.
     */
    public void setUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.binary.uuid</code>.
     */
    public UUID getUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.binary.sha512sum</code>.
     */
    public void setSha512sum(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.binary.sha512sum</code>.
     */
    public String getSha512sum() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.binary.size</code>.
     */
    public void setSize(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.binary.size</code>.
     */
    public Long getSize() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.binary.sha256sum</code>.
     */
    public void setSha256sum(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.binary.sha256sum</code>.
     */
    public String getSha256sum() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.binary.md5sum</code>.
     */
    public void setMd5sum(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.binary.md5sum</code>.
     */
    public String getMd5sum() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.binary.chunk_hash</code>.
     */
    public void setChunkHash(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.binary.chunk_hash</code>.
     */
    public String getChunkHash() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.binary.zero_chunk_count</code>.
     */
    public void setZeroChunkCount(Long value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.binary.zero_chunk_count</code>.
     */
    public Long getZeroChunkCount() {
        return (Long) get(6);
    }

    /**
     * Setter for <code>public.binary.mime_type</code>.
     */
    public void setMimeType(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.binary.mime_type</code>.
     */
    public String getMimeType() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.binary.meta</code>. Custom meta properties to the
     * asset
     */
    public void setMeta(JSONB value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.binary.meta</code>. Custom meta properties to the
     * asset
     */
    public JSONB getMeta() {
        return (JSONB) get(8);
    }

    /**
     * Setter for <code>public.binary.author</code>.
     */
    public void setAuthor(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.binary.author</code>.
     */
    public String getAuthor() {
        return (String) get(9);
    }

    /**
     * Setter for <code>public.binary.geo_lon</code>.
     */
    public void setGeoLon(BigDecimal value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.binary.geo_lon</code>.
     */
    public BigDecimal getGeoLon() {
        return (BigDecimal) get(10);
    }

    /**
     * Setter for <code>public.binary.geo_lat</code>.
     */
    public void setGeoLat(BigDecimal value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.binary.geo_lat</code>.
     */
    public BigDecimal getGeoLat() {
        return (BigDecimal) get(11);
    }

    /**
     * Setter for <code>public.binary.initial_origin</code>. Document the
     * initial origin of the binary (e.g. first filepath encountered, first s3
     * path, url, hash)
     */
    public void setInitialOrigin(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>public.binary.initial_origin</code>. Document the
     * initial origin of the binary (e.g. first filepath encountered, first s3
     * path, url, hash)
     */
    public String getInitialOrigin() {
        return (String) get(12);
    }

    /**
     * Setter for <code>public.binary.created</code>.
     */
    public void setCreated(LocalDateTime value) {
        set(13, value);
    }

    /**
     * Getter for <code>public.binary.created</code>.
     */
    public LocalDateTime getCreated() {
        return (LocalDateTime) get(13);
    }

    /**
     * Setter for <code>public.binary.creator_uuid</code>.
     */
    public void setCreatorUuid(UUID value) {
        set(14, value);
    }

    /**
     * Getter for <code>public.binary.creator_uuid</code>.
     */
    public UUID getCreatorUuid() {
        return (UUID) get(14);
    }

    /**
     * Setter for <code>public.binary.edited</code>.
     */
    public void setEdited(LocalDateTime value) {
        set(15, value);
    }

    /**
     * Getter for <code>public.binary.edited</code>.
     */
    public LocalDateTime getEdited() {
        return (LocalDateTime) get(15);
    }

    /**
     * Setter for <code>public.binary.editor_uuid</code>.
     */
    public void setEditorUuid(UUID value) {
        set(16, value);
    }

    /**
     * Getter for <code>public.binary.editor_uuid</code>.
     */
    public UUID getEditorUuid() {
        return (UUID) get(16);
    }

    /**
     * Setter for <code>public.binary.s3_bucket_name</code>.
     */
    public void setS3BucketName(String value) {
        set(17, value);
    }

    /**
     * Getter for <code>public.binary.s3_bucket_name</code>.
     */
    public String getS3BucketName() {
        return (String) get(17);
    }

    /**
     * Setter for <code>public.binary.s3_object_path</code>.
     */
    public void setS3ObjectPath(String value) {
        set(18, value);
    }

    /**
     * Getter for <code>public.binary.s3_object_path</code>.
     */
    public String getS3ObjectPath() {
        return (String) get(18);
    }

    /**
     * Setter for <code>public.binary.media_width</code>. Only set for images,
     * video
     */
    public void setMediaWidth(Integer value) {
        set(19, value);
    }

    /**
     * Getter for <code>public.binary.media_width</code>. Only set for images,
     * video
     */
    public Integer getMediaWidth() {
        return (Integer) get(19);
    }

    /**
     * Setter for <code>public.binary.media_height</code>. Only set for images,
     * video
     */
    public void setMediaHeight(Integer value) {
        set(20, value);
    }

    /**
     * Getter for <code>public.binary.media_height</code>. Only set for images,
     * video
     */
    public Integer getMediaHeight() {
        return (Integer) get(20);
    }

    /**
     * Setter for <code>public.binary.duration</code>. Duration of the video,
     * audio
     */
    public void setDuration(Integer value) {
        set(21, value);
    }

    /**
     * Getter for <code>public.binary.duration</code>. Duration of the video,
     * audio
     */
    public Integer getDuration() {
        return (Integer) get(21);
    }

    /**
     * Setter for <code>public.binary.video_fingerprint</code>. Video
     * fingerprint information
     */
    public void setVideoFingerprint(String value) {
        set(22, value);
    }

    /**
     * Getter for <code>public.binary.video_fingerprint</code>. Video
     * fingerprint information
     */
    public String getVideoFingerprint() {
        return (String) get(22);
    }

    /**
     * Setter for <code>public.binary.image_fingerprint</code>. Image
     * fingerprint information
     */
    public void setImageFingerprint(String value) {
        set(23, value);
    }

    /**
     * Getter for <code>public.binary.image_fingerprint</code>. Image
     * fingerprint information
     */
    public String getImageFingerprint() {
        return (String) get(23);
    }

    /**
     * Setter for <code>public.binary.image_dominant_color</code>.
     */
    public void setImageDominantColor(String value) {
        set(24, value);
    }

    /**
     * Getter for <code>public.binary.image_dominant_color</code>.
     */
    public String getImageDominantColor() {
        return (String) get(24);
    }

    /**
     * Setter for <code>public.binary.audio_bpm</code>.
     */
    public void setAudioBpm(Integer value) {
        set(25, value);
    }

    /**
     * Getter for <code>public.binary.audio_bpm</code>.
     */
    public Integer getAudioBpm() {
        return (Integer) get(25);
    }

    /**
     * Setter for <code>public.binary.audio_sampling_rate</code>.
     */
    public void setAudioSamplingRate(Integer value) {
        set(26, value);
    }

    /**
     * Getter for <code>public.binary.audio_sampling_rate</code>.
     */
    public Integer getAudioSamplingRate() {
        return (Integer) get(26);
    }

    /**
     * Setter for <code>public.binary.audio_channels</code>.
     */
    public void setAudioChannels(Integer value) {
        set(27, value);
    }

    /**
     * Getter for <code>public.binary.audio_channels</code>.
     */
    public Integer getAudioChannels() {
        return (Integer) get(27);
    }

    /**
     * Setter for <code>public.binary.audio_encoding</code>. Store the audio
     * encoding used for the binary (e.g. mp3, flac)
     */
    public void setAudioEncoding(String value) {
        set(28, value);
    }

    /**
     * Getter for <code>public.binary.audio_encoding</code>. Store the audio
     * encoding used for the binary (e.g. mp3, flac)
     */
    public String getAudioEncoding() {
        return (String) get(28);
    }

    /**
     * Setter for <code>public.binary.audio_fingerprint</code>. Audio
     * fingerprint information
     */
    public void setAudioFingerprint(String value) {
        set(29, value);
    }

    /**
     * Getter for <code>public.binary.audio_fingerprint</code>. Audio
     * fingerprint information
     */
    public String getAudioFingerprint() {
        return (String) get(29);
    }

    /**
     * Setter for <code>public.binary.doc_plain_text</code>. Extracted text of
     * the document
     */
    public void setDocPlainText(String value) {
        set(30, value);
    }

    /**
     * Getter for <code>public.binary.doc_plain_text</code>. Extracted text of
     * the document
     */
    public String getDocPlainText() {
        return (String) get(30);
    }

    /**
     * Setter for <code>public.binary.doc_word_count</code>.
     */
    public void setDocWordCount(Integer value) {
        set(31, value);
    }

    /**
     * Getter for <code>public.binary.doc_word_count</code>.
     */
    public Integer getDocWordCount() {
        return (Integer) get(31);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JooqBinaryRecord
     */
    public JooqBinaryRecord() {
        super(JooqBinary.BINARY);
    }

    /**
     * Create a detached, initialised JooqBinaryRecord
     */
    public JooqBinaryRecord(UUID uuid, String sha512sum, Long size, String sha256sum, String md5sum, String chunkHash, Long zeroChunkCount, String mimeType, JSONB meta, String author, BigDecimal geoLon, BigDecimal geoLat, String initialOrigin, LocalDateTime created, UUID creatorUuid, LocalDateTime edited, UUID editorUuid, String s3BucketName, String s3ObjectPath, Integer mediaWidth, Integer mediaHeight, Integer duration, String videoFingerprint, String imageFingerprint, String imageDominantColor, Integer audioBpm, Integer audioSamplingRate, Integer audioChannels, String audioEncoding, String audioFingerprint, String docPlainText, Integer docWordCount) {
        super(JooqBinary.BINARY);

        setUuid(uuid);
        setSha512sum(sha512sum);
        setSize(size);
        setSha256sum(sha256sum);
        setMd5sum(md5sum);
        setChunkHash(chunkHash);
        setZeroChunkCount(zeroChunkCount);
        setMimeType(mimeType);
        setMeta(meta);
        setAuthor(author);
        setGeoLon(geoLon);
        setGeoLat(geoLat);
        setInitialOrigin(initialOrigin);
        setCreated(created);
        setCreatorUuid(creatorUuid);
        setEdited(edited);
        setEditorUuid(editorUuid);
        setS3BucketName(s3BucketName);
        setS3ObjectPath(s3ObjectPath);
        setMediaWidth(mediaWidth);
        setMediaHeight(mediaHeight);
        setDuration(duration);
        setVideoFingerprint(videoFingerprint);
        setImageFingerprint(imageFingerprint);
        setImageDominantColor(imageDominantColor);
        setAudioBpm(audioBpm);
        setAudioSamplingRate(audioSamplingRate);
        setAudioChannels(audioChannels);
        setAudioEncoding(audioEncoding);
        setAudioFingerprint(audioFingerprint);
        setDocPlainText(docPlainText);
        setDocWordCount(docWordCount);
    }
}
