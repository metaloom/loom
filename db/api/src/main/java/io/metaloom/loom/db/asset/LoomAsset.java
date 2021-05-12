package io.metaloom.loom.db.asset;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.MetaElement;
import io.metaloom.loom.db.Taggable;

public interface LoomAsset extends CUDElement, Taggable, MetaElement {

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

	Double getGPSLon();

	LoomAsset setGPSLon(Double lon);

	Double getGPSLat();

	LoomAsset setGPSLat(Double lat);

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
