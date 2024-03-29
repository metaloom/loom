package io.metaloom.loom.db.jooq.dao.asset;

import java.time.Instant;

import io.metaloom.loom.db.jooq.AbstractEditableElement;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.utils.hash.ChunkHash;
import io.metaloom.utils.hash.MD5;
import io.metaloom.utils.hash.SHA256;
import io.metaloom.utils.hash.SHA512;

public class AssetImpl extends AbstractEditableElement<Asset> implements Asset {

	private SHA512 sha512sum;
	private SHA256 sha256sum;
	private MD5 md5sum;
	private ChunkHash chunkHash;
	private long zeroChunkCount;

	// File
	private long size;
	private String filename;
	private String mimeType;
	private Instant firstSeen;
	private String initialOrigin;

	// Video
	private Integer videoBitrate;
	private String videoEncoding;

	// Audio
	private Integer audioBPM;
	private Integer audioChannels;
	private Integer audioSampleRate;
	private Integer audioBitrate;
	private String audioEncoding;

	// Image
	private String imageDominantColor;

	// Document
	private Long documentWordCount;

	// General
	private Integer mediaHeight;
	private Integer mediaWidth;
	private Long mediaDuration;

	private String s3BucketName;
	private String s3ObjectPath;

	// Geo
	private Double geoLat;
	private Double geoLon;
	private String geoAlias;

	public AssetImpl() {
	}

	@Override
	public SHA512 getSHA512() {
		return sha512sum;
	}

	@Override
	public Asset setSHA512(SHA512 sha512sum) {
		this.sha512sum = sha512sum;
		return this;
	}

	@Override
	public SHA256 getSHA256() {
		return sha256sum;
	}

	@Override
	public Asset setSHA256(SHA256 sha256sum) {
		this.sha256sum = sha256sum;
		return this;
	}

	@Override
	public MD5 getMD5() {
		return md5sum;
	}

	@Override
	public Asset setMD5(MD5 md5sum) {
		this.md5sum = md5sum;
		return this;
	}

	@Override
	public ChunkHash getChunkHash() {
		return chunkHash;
	}

	@Override
	public Asset setChunkHash(ChunkHash chunkHash) {
		this.chunkHash = chunkHash;
		return this;
	}

	@Override
	public long getZeroChunkCount() {
		return zeroChunkCount;
	}

	@Override
	public Asset setZeroChunkCount(long zeroChunkCount) {
		this.zeroChunkCount = zeroChunkCount;
		return this;
	}

	@Override
	public Integer getMediaWidth() {
		return mediaWidth;
	}

	@Override
	public Asset setMediaWidth(Integer width) {
		this.mediaWidth = width;
		return this;
	}

	@Override
	public Integer getMediaHeight() {
		return mediaHeight;
	}

	@Override
	public Asset setMediaHeight(Integer height) {
		this.mediaHeight = height;
		return this;
	}

	@Override
	public Integer getVideoBitrate() {
		return videoBitrate;
	}

	@Override
	public Asset setVideoBitrate(Integer bitrate) {
		this.videoBitrate = bitrate;
		return this;
	}

	@Override
	public long getSize() {
		return size;
	}

	@Override
	public Asset setSize(long size) {
		this.size = size;
		return this;
	}

	@Override
	public String getFilename() {
		return filename;
	}

	@Override
	public Asset setFilename(String filename) {
		this.filename = filename;
		return this;
	}

	@Override
	public String getS3BucketName() {
		return this.s3BucketName;
	}

	@Override
	public Asset setS3BucketName(String bucketName) {
		this.s3BucketName = bucketName;
		return this;
	}

	@Override
	public String getS3ObjectPath() {
		return s3ObjectPath;
	}

	@Override
	public Asset setS3ObjectPath(String path) {
		this.s3ObjectPath = path;
		return this;
	}

	@Override
	public String getDominantColor() {
		return imageDominantColor;
	}

	@Override
	public Asset setDominantColor(String color) {
		this.imageDominantColor = color;
		return this;
	}

	@Override
	public Double getGeoLat() {
		return geoLat;
	}

	@Override
	public Asset setGeoLat(Double lat) {
		this.geoLat = lat;
		return this;
	}

	@Override
	public Double getGeoLon() {
		return geoLon;
	}

	@Override
	public Asset setGeoLon(Double lon) {
		this.geoLon = lon;
		return this;
	}

	@Override
	public String getGeoAlias() {
		return geoAlias;
	}

	@Override
	public Asset setGeoAlias(String geoAlias) {
		this.geoAlias = geoAlias;
		return this;
	}

	@Override
	public String getMimeType() {
		return mimeType;
	}

	@Override
	public Asset setMimeType(String mimeType) {
		this.mimeType = mimeType;
		return this;
	}

	@Override
	public Instant getFirstSeen() {
		return firstSeen;
	}

	@Override
	public Asset setFirstSeen(Instant time) {
		this.firstSeen = time;
		return this;
	}

	@Override
	public String getInitialOrigin() {
		return initialOrigin;
	}

	@Override
	public Asset setInitialOrigin(String initialOrigin) {
		this.initialOrigin = initialOrigin;
		return this;
	}

	@Override
	public Long getMediaDuration() {
		return mediaDuration;
	}

	@Override
	public Asset setMediaDuration(Long mediaDuration) {
		this.mediaDuration = mediaDuration;
		return this;
	}

	@Override
	public Integer getAudioBPM() {
		return audioBPM;
	}

	@Override
	public Asset setAudioBPM(Integer audioBPM) {
		this.audioBPM = audioBPM;
		return this;
	}

	@Override
	public Integer getAudioChannels() {
		return audioChannels;
	}

	@Override
	public Asset setAudioChannels(Integer channels) {
		this.audioChannels = channels;
		return this;
	}

	@Override
	public Integer getAudioBitrate() {
		return audioBitrate;
	}

	@Override
	public Asset setAudioBitrate(Integer bitrate) {
		this.audioBitrate = bitrate;
		return this;
	}

	@Override
	public String getAudioEncoding() {
		return audioEncoding;
	}

	@Override
	public Asset setAudioEncoding(String audioEncoding) {
		this.audioEncoding = audioEncoding;
		return this;
	}

	@Override
	public Integer getAudioSamplingRate() {
		return audioSampleRate;
	}

	@Override
	public Asset setAudioSampleRate(Integer audioSampleRate) {
		this.audioSampleRate = audioSampleRate;
		return this;
	}

	@Override
	public String getVideoEncoding() {
		return videoEncoding;
	}

	@Override
	public Asset setVideoEncoding(String videoEncoding) {
		this.videoEncoding = videoEncoding;
		return this;
	}

	@Override
	public Long getDocumentWordCount() {
		return documentWordCount;
	}

	@Override
	public Asset setDocumentWordCount(Long documentWordCount) {
		this.documentWordCount = documentWordCount;
		return this;
	}

}
