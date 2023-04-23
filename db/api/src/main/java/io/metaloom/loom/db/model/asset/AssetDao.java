package io.metaloom.loom.db.model.asset;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.model.tag.LoomTag;
import io.metaloom.loom.db.page.Page;

public interface AssetDao extends LoomDao {

	Asset createAsset(String filename, UUID binaryUuid, UUID creatorUuid, UUID namespaceUuid);

	void storeAsset(Asset asset);

	void deleteAsset(Asset asset);

	void updateAsset(Asset asset);

	Asset loadAsset(UUID uuid);

	LoomTag loadTags(Asset asset);

	void addTag(Asset asset, LoomTag tag);

	void removeTag(Asset asset, LoomTag tag);

	Page<Asset> loadAssets(UUID uuid, int pageSize);

}
