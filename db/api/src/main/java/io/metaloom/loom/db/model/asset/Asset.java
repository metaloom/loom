package io.metaloom.loom.db.model.asset;

import java.math.BigDecimal;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.MetaElement;
import io.metaloom.loom.db.Taggable;

public interface Asset extends CUDElement, Taggable, MetaElement {

	/**
	 * Return the filename of the asset.
	 * 
	 * @return
	 */
	String getFilename();

	/**
	 * Set the filename of the asset.
	 * 
	 * @param filename
	 * @return Fluent API
	 */
	Asset setFilename(String filename);

	Integer getRating();

	Asset setRating(Integer rating);

	BigDecimal getGPSLon();

	Asset setGPSLon(BigDecimal lon);

	BigDecimal getGPSLat();

	Asset setGPSLat(BigDecimal lat);

	String getLocalPath();

	Asset setLocalPath(String path);

	String getDominantColor();

	Asset setDominantColor(String color);

	String getMimeType();

	Asset setMimeType(String mimeType);

	String getS3BucketName();

	Asset setS3BucketName(String bucketName);

	String getS3ObjectPath();

	Asset setS3ObjectPath(String path);

}
