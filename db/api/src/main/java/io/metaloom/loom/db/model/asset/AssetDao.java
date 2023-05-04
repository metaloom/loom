package io.metaloom.loom.db.model.asset;

import java.util.UUID;

import io.metaloom.loom.db.CRUDDao;
import io.metaloom.loom.db.model.user.User;
import io.vertx.core.json.JsonObject;

public interface AssetDao extends CRUDDao<Asset> {

	Asset createAsset(String filename, UUID binaryUuid, UUID creatorUuid, UUID libraryUuid);

	void storeUserMeta(User user, Asset asset, JsonObject meta);

	void deleteUserMeta(User user, Asset asset);

	JsonObject readUserMeta(User user, Asset asset);
}
