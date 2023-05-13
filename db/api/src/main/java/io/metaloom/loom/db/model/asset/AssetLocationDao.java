package io.metaloom.loom.db.model.asset;

import java.util.UUID;

import io.metaloom.loom.db.CRUDDao;

public interface AssetLocationDao extends CRUDDao<AssetLocation, UUID> {

	AssetLocation createAssetLocation(String path, UUID assetUuid, UUID creatorUuid, UUID libraryUuid);

}
