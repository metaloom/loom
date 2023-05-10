package io.metaloom.loom.db.model.asset;

import java.math.BigDecimal;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.Taggable;

public interface Asset extends CUDElement<Asset>, Taggable {

	String getSHA512();

	Asset setSHA512(String hashsum);

	String getSHA256();

	Asset setSHA256(String hashsum);

	String getMD5();

	Asset setMD5(String hashsum);

	String getChunkHash();

	Asset setChunkHash(String chunkHash);

	long getZeroChunkCount();

	Asset setZeroChunkCount(long zeroChunkCount);

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
	Asset setMediaWidth(Integer width);

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
	Asset setMediaHeight(Integer height);

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
	Asset setVideoFingerprint(String fingerprint);

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
	Asset setAudioFingerprint(String fingerprint);

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
	Asset setSize(long size);

	String getDominantColor();

	Asset setDominantColor(String color);

	String getMimeType();

	Asset setMimeType(String mimeType);

	String getS3BucketName();

	Asset setS3BucketName(String bucketName);

	String getS3ObjectPath();

	Asset setS3ObjectPath(String path);

	BigDecimal getGeoLon();

	Asset setGeoLon(BigDecimal lon);

	BigDecimal getGeoLat();

	Asset setGeoLat(BigDecimal lat);

	String getGeoAlias();

	Asset setGeoAlias(String geoAlias);

	String getInitialOrigin();

	Asset setInitialOrigin(String initialOrigin);

	Integer getAudioBPM();

	Asset setAudioBPM(Integer audioBPM);

	Integer getAudioChannels();

	String getAudioEncoding();

	Asset setAudioEncoding(String audioEncoding);

	Integer getAudioSamplingRate();

	Long getDocumentWordCount();

	Asset setDocumentWordCount(Long documentWordCount);

	Long getMediaDuration();

	Asset setMediaDuration(Long mediaDuration);

	String getVideoEncoding();

	Asset setVideoEncoding(String videoEncoding);

	Asset setAudioSampleRate(Integer audioSampleRate);

}
