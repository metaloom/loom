package io.metaloom.loom.db.model.asset;

import java.math.BigDecimal;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.Taggable;

public interface Binary extends CUDElement<Binary>, Taggable {

	String getSHA512();

	Binary setSHA512(String hashsum);

	String getSHA256();

	Binary setSHA256(String hashsum);

	String getMD5();

	Binary setMD5(String hashsum);

	String getChunkHash();

	Binary setChunkHash(String chunkHash);

	long getZeroChunkCount();

	Binary setZeroChunkCount(long zeroChunkCount);

	/**
	 * Return the media width.
	 * 
	 * @return
	 */
	Integer getMediaWidth();

	/**
	 * Set the media width in pixel.
	 * 
	 * @param width
	 * @return
	 */
	Binary setMediaWidth(Integer width);

	/**
	 * Return the media height.
	 * 
	 * @return
	 */
	Integer getMediaHeight();

	/**
	 * Set the media height in pixel.
	 * 
	 * @param height
	 * @return
	 */
	Binary setMediaHeight(Integer height);

	/**
	 * Return the video fingerprint.
	 * 
	 * @return
	 */
	String getVideoFingerprint();

	/**
	 * Set the video fingerprint.
	 * 
	 * @param fingerprint
	 * @return Fluent API
	 */
	Binary setVideoFingerprint(String fingerprint);

	/**
	 * Return the audio fingerprint.
	 * 
	 * @return
	 */
	String getAudioFingerprint();

	/**
	 * Set the audio fingerprint.
	 * 
	 * @param fingerprint
	 * @return Fluent API
	 */
	Binary setAudioFingerprint(String fingerprint);

	/**
	 * Return the binary size in bytes.
	 * 
	 * @return
	 */
	long getSize();

	/**
	 * Set the binary size in bytes.
	 * 
	 * @param size
	 * @return Fluent API
	 */
	Binary setSize(long size);

	String getDominantColor();

	Binary setDominantColor(String color);

	String getMimeType();

	Binary setMimeType(String mimeType);

	String getS3BucketName();

	Binary setS3BucketName(String bucketName);

	String getS3ObjectPath();

	Binary setS3ObjectPath(String path);

	BigDecimal getGeoLon();

	Binary setGeoLon(BigDecimal lon);

	BigDecimal getGeoLat();

	Binary setGeoLat(BigDecimal lat);
}
