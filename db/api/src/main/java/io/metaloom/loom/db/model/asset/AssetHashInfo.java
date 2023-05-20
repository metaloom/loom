package io.metaloom.loom.db.model.asset;

public interface AssetHashInfo {

	String getSHA512();

	Asset setSHA512(String hashsum);

	String getSHA256();

	Asset setSHA256(String hashsum);

	String getMD5();

	Asset setMD5(String hashsum);

	String getChunkHash();

	Asset setChunkHash(String chunkHash);

}
