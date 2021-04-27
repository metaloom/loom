package io.metaloom.loom.db.asset;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;

public interface AssetsDao extends LoomDao {

	Asset createAsset();

	void deleteAsset(Asset asset);

	void updateAsset(Asset asset);

	Asset loadAsset(UUID uuid);

	void storeAsset(Asset asset);
}
