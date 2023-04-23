package io.metaloom.loom.db.model.asset;

import java.util.UUID;

import io.metaloom.loom.db.Dao;
import io.metaloom.loom.db.model.tag.Tag;
import io.metaloom.loom.db.page.Page;

public interface AssetDao extends Dao {

	Asset createAsset(String filename, UUID binaryUuid, UUID creatorUuid, UUID namespaceUuid);

	void storeAsset(Asset asset);

	void deleteAsset(Asset asset);

	void updateAsset(Asset asset);

	Asset loadAsset(UUID uuid);

	Tag loadTags(Asset asset);

	void addTag(Asset asset, Tag tag);

	void removeTag(Asset asset, Tag tag);

	Page<Asset> loadAssets(UUID uuid, int pageSize);

}
