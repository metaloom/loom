package io.metaloom.loom.db.asset;

import java.math.BigDecimal;

import io.metaloom.loom.db.fs.AbstractFSCUDElement;
import io.metaloom.loom.db.model.asset.Asset;
import io.vertx.core.json.JsonObject;

public class FsAssetImpl extends AbstractFSCUDElement implements Asset {

	private String filename;

	private String localPath;

	private String s3BucketName;

	private String s3ObjectPath;

	private String dominantColor;

	private String mimeType;

	private JsonObject meta;

	private BigDecimal gpsLon;

	private BigDecimal gpsLat;

	private Integer rating;

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
	public String getLocalPath() {
		return localPath;
	}

	@Override
	public Asset setLocalPath(String path) {
		this.localPath = path;
		return this;
	}

	@Override
	public String getS3BucketName() {
		return s3BucketName;
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
		return dominantColor;
	}

	@Override
	public Asset setDominantColor(String color) {
		this.dominantColor = color;
		return this;
	}

	@Override
	public JsonObject getMeta() {
		return meta;
	}

	@Override
	public Asset setMeta(JsonObject meta) {
		this.meta = meta;
		return this;
	}

	@Override
	public BigDecimal getGPSLat() {
		return gpsLat;
	}

	@Override
	public Asset setGPSLat(BigDecimal lat) {
		this.gpsLat = lat;
		return this;
	}

	@Override
	public BigDecimal getGPSLon() {
		return gpsLon;
	}

	@Override
	public Asset setGPSLon(BigDecimal lon) {
		this.gpsLon = lon;
		return this;
	}

	@Override
	public Integer getRating() {
		return rating;
	}

	@Override
	public Asset setRating(Integer rating) {
		this.rating = rating;
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
}
