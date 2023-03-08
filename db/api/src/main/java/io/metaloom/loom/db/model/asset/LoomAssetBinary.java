package io.metaloom.loom.db.model.asset;

import io.metaloom.loom.db.LoomElement;

public interface LoomAssetBinary extends LoomElement {

	String getSHA512();

	LoomAssetBinary setSHA512(String hashsum);

	String getSHA256();

	LoomAssetBinary setSHA256(String hashsum);

	String getMD5();

	LoomAssetBinary setMD5(String hashsum);

	String getChunkHash();

	LoomAssetBinary setChunkHash(String chunkHash);

	long getZeroChunkCount();

	LoomAssetBinary setZeroChunkCount(long zeroChunkCount);

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
	LoomAssetBinary setMediaWidth(Integer width);

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
	LoomAssetBinary setMediaHeight(Integer height);

	/**
	 * Return the media fingerprint.
	 * 
	 * @return
	 */
	String getFingerprint();

	/**
	 * Set the media fingerprint.
	 * 
	 * @param fingerprint
	 * @return Fluent API
	 */
	LoomAssetBinary setFingerprint(String fingerprint);

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
	LoomAssetBinary setSize(long size);

}
