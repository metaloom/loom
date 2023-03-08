package io.metaloom.loom.db.model.asset;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.model.tag.LoomTag;
import io.metaloom.loom.db.model.user.LoomUser;

public interface LoomAssetDao extends LoomDao {

	LoomAsset createAsset(String filename, UUID binaryUuid, LoomUser creator, UUID namespaceUuid);

	void storeAsset(LoomAsset asset);

	void deleteAsset(LoomAsset asset);

	void updateAsset(LoomAsset asset);

	LoomAsset loadAsset(UUID uuid);

	LoomTag loadTags(LoomAsset asset);

	void addTag(LoomAsset asset, LoomTag tag);

	void removeTag(LoomAsset asset, LoomTag tag);

}
