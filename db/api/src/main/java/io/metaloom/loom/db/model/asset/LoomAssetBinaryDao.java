package io.metaloom.loom.db.model.asset;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;

public interface LoomAssetBinaryDao extends LoomDao {

	LoomAssetBinary createBinary(String sha512sum, long size);

	void storeBinary(LoomAssetBinary binary);

	void updateBinary(LoomAssetBinary binary);

	void deleteBinary(LoomAssetBinary binary);

	LoomAssetBinary loadBinary(UUID uuid);

	long count();

}
