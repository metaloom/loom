package io.metaloom.loom.db.model.asset;

import java.util.UUID;

import io.metaloom.loom.db.CRUDDao;
import io.metaloom.loom.db.model.tag.Tag;

public interface AssetDao extends CRUDDao<Asset>{

	Asset createAsset(String filename, UUID binaryUuid, UUID creatorUuid, UUID libraryUuid);

	Tag loadTags(Asset asset);

	void addTag(Asset asset, Tag tag);

	void removeTag(Asset asset, Tag tag);

}
