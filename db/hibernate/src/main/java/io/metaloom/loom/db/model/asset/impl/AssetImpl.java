package io.metaloom.loom.db.model.asset.impl;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import io.metaloom.loom.db.model.AbstractCUDElement;
import io.metaloom.loom.db.model.asset.Asset;
import io.vertx.core.json.JsonObject;

@Entity
@Table(name = "assets")
public class AssetImpl extends AbstractCUDElement implements Asset {

	@Column(columnDefinition = "jsonb")
	@Type(type = "io.metaloom.loom.db.hib.types.Json")
	private JsonObject meta;

	private String filename;

	private Integer rating;

	private String dominantColor;

	@Column(name = "gps_lon")
	private BigDecimal lon;

	@Column(name = "gps_lat")
	private BigDecimal lat;

	private String localPath;
	private String mimeType;

	@Column(name = "s3_object_path")
	private String s3path;

	@Column(name = "s3_bucket_name")
	private String s3bucketName;

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
	public String getFilename() {
		return filename;
	}

	@Override
	public Asset setFilename(String filename) {
		this.filename = filename;
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
	public BigDecimal getGPSLon() {
		return lon;
	}

	@Override
	public Asset setGPSLon(BigDecimal lon) {
		this.lon = lon;
		return this;
	}

	@Override
	public BigDecimal getGPSLat() {
		return lat;
	}

	@Override
	public Asset setGPSLat(BigDecimal lat) {
		this.lat = lat;
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
	public String getDominantColor() {
		return dominantColor;
	}

	@Override
	public Asset setDominantColor(String color) {
		this.dominantColor = color;
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
	public String getS3BucketName() {
		return s3bucketName;
	}

	@Override
	public Asset setS3BucketName(String bucketName) {
		this.s3bucketName = bucketName;
		return this;
	}

	@Override
	public String getS3ObjectPath() {
		return s3path;
	}

	@Override
	public Asset setS3ObjectPath(String path) {
		this.s3path = path;
		return this;
	}

}
