package io.metaloom.loom.db.model.asset;

import java.util.UUID;

import io.metaloom.loom.db.Dao;

public interface AssetBinaryDao extends Dao {

	AssetBinary createBinary(String sha512sum, long size);

	void storeBinary(AssetBinary binary);

	void updateBinary(AssetBinary binary);

	void deleteBinary(AssetBinary binary);

	AssetBinary loadBinary(UUID uuid);

	long count();

	AssetBinary loadBinary(String sha512sum);

}
