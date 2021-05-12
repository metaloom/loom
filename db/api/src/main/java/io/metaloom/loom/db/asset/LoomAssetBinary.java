package io.metaloom.loom.db.asset;

import io.metaloom.loom.db.LoomElement;

public interface LoomAssetBinary extends LoomElement {

	String getSHA512();

	LoomAssetBinary setSHA512(String hashsum);

	String getSHA256();

	LoomAssetBinary setSHA256(String hashsum);

	String getMD5();

	LoomAssetBinary setMD5(String hashsum);

	/**
	 * Return the media width.
	 * 
	 * @return
	 */
	Integer getMediaWidth();

	LoomAssetBinary setMediaWidth(Integer width);

	/**
	 * Return the media height.
	 * 
	 * @return
	 */
	Integer getMediaHeight();

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
