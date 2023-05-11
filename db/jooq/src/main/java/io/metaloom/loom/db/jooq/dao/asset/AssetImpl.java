package io.metaloom.loom.db.jooq.dao.asset;

import java.math.BigDecimal;

import io.metaloom.loom.db.jooq.AbstractEditableElement;
import io.metaloom.loom.db.model.asset.Asset;

public class AssetImpl extends AbstractEditableElement<Asset> implements Asset {

	private String sha512sum;
	private String sha256sum;
	private String md5sum;
	private String chunkHash;
	private long zeroChunkCount;
	private long size;

	// Video
	private String videoFingerprint;
	private String videoEncoding;

	// Audio
	private Integer audioBPM;
	private Integer audioChannels;
	private Integer audioSampleRate;
	private String audioEncoding;
	private String audioFingerprint;

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
	private BigDecimal geoLat;
	private BigDecimal geoLon;
	private String geoAlias;

	private String mimeType;
	private String initialOrigin;

	public AssetImpl() {
	}

	@Override
	public String getSHA512() {
		return sha512sum;
	}

	@Override
	public Asset setSHA512(String sha512sum) {
		this.sha512sum = sha512sum;
		return this;
	}

	@Override
	public String getSHA256() {
		return sha256sum;
	}

	@Override
	public Asset setSHA256(String sha256sum) {
		this.sha256sum = sha256sum;
		return this;
	}

	@Override
	public String getMD5() {
		return md5sum;
	}

	@Override
	public Asset setMD5(String md5sum) {
		this.md5sum = md5sum;
		return this;
	}

	@Override
	public String getChunkHash() {
		return chunkHash;
	}

	@Override
	public Asset setChunkHash(String chunkHash) {
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
	public String getVideoFingerprint() {
		return videoFingerprint;
	}

	@Override
	public Asset setVideoFingerprint(String videoFingerprint) {
		this.videoFingerprint = videoFingerprint;
		return this;
	}

	@Override
	public String getAudioFingerprint() {
		return audioFingerprint;
	}

	@Override
	public Asset setAudioFingerprint(String audioFingerprint) {
		this.audioFingerprint = audioFingerprint;
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
	public BigDecimal getGeoLat() {
		return geoLat;
	}

	@Override
	public Asset setGeoLat(BigDecimal lat) {
		this.geoLat = lat;
		return this;
	}

	@Override
	public BigDecimal getGeoLon() {
		return geoLon;
	}

	@Override
	public Asset setGeoLon(BigDecimal lon) {
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
