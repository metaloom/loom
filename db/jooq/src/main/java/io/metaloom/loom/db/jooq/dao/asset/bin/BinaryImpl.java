package io.metaloom.loom.db.jooq.dao.asset.bin;

import java.math.BigDecimal;

import io.metaloom.loom.db.jooq.AbstractEditableElement;
import io.metaloom.loom.db.model.asset.Binary;

public class BinaryImpl extends AbstractEditableElement<Binary> implements Binary {

	private String sha512sum;
	private String sha256sum;
	private String md5sum;
	private String chunkHash;
	private long zeroChunkCount;
	private String videoFingerprint;
	private String audioFingerprint;
	private Integer mediaHeight;
	private Integer mediaWidth;
	private String s3BucketName;
	private long size;
	private String s3ObjectPath;
	private String imageDominantColor;
	private BigDecimal geoLat;
	private BigDecimal geoLon;
	private String mimeType;

	public BinaryImpl() {
	}

	
	@Override
	public String getSHA512() {
		return sha512sum;
	}

	@Override
	public Binary setSHA512(String sha512sum) {
		this.sha512sum = sha512sum;
		return this;
	}

	@Override
	public String getSHA256() {
		return sha256sum;
	}

	@Override
	public Binary setSHA256(String sha256sum) {
		this.sha256sum = sha256sum;
		return this;
	}

	@Override
	public String getMD5() {
		return md5sum;
	}

	@Override
	public Binary setMD5(String md5sum) {
		this.md5sum = md5sum;
		return this;
	}

	@Override
	public String getChunkHash() {
		return chunkHash;
	}

	@Override
	public Binary setChunkHash(String chunkHash) {
		this.chunkHash = chunkHash;
		return this;
	}

	@Override
	public long getZeroChunkCount() {
		return zeroChunkCount;
	}

	@Override
	public Binary setZeroChunkCount(long zeroChunkCount) {
		this.zeroChunkCount = zeroChunkCount;
		return this;
	}

	@Override
	public Integer getMediaWidth() {
		return mediaWidth;
	}

	@Override
	public Binary setMediaWidth(Integer width) {
		this.mediaWidth = width;
		return this;
	}

	@Override
	public Integer getMediaHeight() {
		return mediaHeight;
	}

	@Override
	public Binary setMediaHeight(Integer height) {
		this.mediaHeight = height;
		return this;
	}

	@Override
	public String getVideoFingerprint() {
		return videoFingerprint;
	}

	@Override
	public Binary setVideoFingerprint(String videoFingerprint) {
		this.videoFingerprint = videoFingerprint;
		return this;
	}

	@Override
	public String getAudioFingerprint() {
		return audioFingerprint;
	}

	@Override
	public Binary setAudioFingerprint(String audioFingerprint) {
		this.audioFingerprint = audioFingerprint;
		return this;
	}

	@Override
	public long getSize() {
		return size;
	}

	@Override
	public Binary setSize(long size) {
		this.size = size;
		return this;
	}

	@Override
	public String getS3BucketName() {
		return this.s3BucketName;
	}

	@Override
	public Binary setS3BucketName(String bucketName) {
		this.s3BucketName = bucketName;
		return this;
	}

	@Override
	public String getS3ObjectPath() {
		return s3ObjectPath;
	}

	@Override
	public Binary setS3ObjectPath(String path) {
		this.s3ObjectPath = path;
		return this;
	}

	@Override
	public String getDominantColor() {
		return imageDominantColor;
	}

	@Override
	public Binary setDominantColor(String color) {
		this.imageDominantColor = color;
		return this;
	}

	@Override
	public BigDecimal getGeoLat() {
		return geoLat;
	}

	@Override
	public Binary setGeoLat(BigDecimal lat) {
		this.geoLat = lat;
		return this;
	}

	@Override
	public BigDecimal getGeoLon() {
		return geoLon;
	}

	@Override
	public Binary setGeoLon(BigDecimal lon) {
		this.geoLon = lon;
		return this;
	}
	//

	@Override
	public String getMimeType() {
		return mimeType;
	}

	@Override
	public Binary setMimeType(String mimeType) {
		this.mimeType = mimeType;
		return this;
	}
}
