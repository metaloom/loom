package io.metaloom.loom.db.model.asset;

import java.util.UUID;

import io.metaloom.loom.api.asset.AssetId;
import io.metaloom.loom.db.CRUDDao;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.utils.hash.SHA512;
import io.vertx.core.json.JsonObject;

public interface AssetDao extends CRUDDao<Asset> {

	default Asset createAsset(User user, SHA512 sha512sum, String mimeType, String filename, String initialOrigin, long size) {
		return createAsset(user.getUuid(), sha512sum, mimeType, filename, initialOrigin, size);
	}

	Asset createAsset(UUID userUuid, SHA512 sha512sum, String mimeType, String filename, String initialOrigin, long size);

	void storeUserMeta(User user, Asset asset, JsonObject meta);

	void deleteUserMeta(User user, Asset asset);

	JsonObject readUserMeta(User user, Asset asset);

	Asset loadBySHA512(SHA512 sha512sum);

	void deleteBySHA512(SHA512 sha512sum);

	Asset loadById(AssetId assetId);

}
