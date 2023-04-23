package io.metaloom.loom.db.model.asset;

import io.metaloom.loom.db.LoomElement;

public interface AssetBinary extends LoomElement {

	String getSHA512();

	AssetBinary setSHA512(String hashsum);

	String getSHA256();

	AssetBinary setSHA256(String hashsum);

	String getMD5();

	AssetBinary setMD5(String hashsum);

	String getChunkHash();

	AssetBinary setChunkHash(String chunkHash);

	long getZeroChunkCount();

	AssetBinary setZeroChunkCount(long zeroChunkCount);

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
	AssetBinary setMediaWidth(Integer width);

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
	AssetBinary setMediaHeight(Integer height);

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
	AssetBinary setFingerprint(String fingerprint);

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
	AssetBinary setSize(long size);

}
