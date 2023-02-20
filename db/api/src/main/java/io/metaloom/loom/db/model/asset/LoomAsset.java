package io.metaloom.loom.db.model.asset;

import java.math.BigDecimal;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.LoomMetaElement;
import io.metaloom.loom.db.LoomTaggable;

public interface LoomAsset extends CUDElement, LoomTaggable, LoomMetaElement {

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
	LoomAsset setFilename(String filename);

	Integer getRating();

	LoomAsset setRating(Integer rating);

	BigDecimal getGPSLon();

	LoomAsset setGPSLon(BigDecimal lon);

	BigDecimal getGPSLat();

	LoomAsset setGPSLat(BigDecimal lat);

	String getLocalPath();

	LoomAsset setLocalPath(String path);

	String getDominantColor();

	LoomAsset setDominantColor(String color);

	String getMimeType();

	LoomAsset setMimeType(String mimeType);

	String getS3BucketName();

	LoomAsset setS3BucketName(String bucketName);

	String getS3ObjectPath();

	LoomAsset setS3ObjectPath(String path);
}
