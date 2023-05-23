package io.metaloom.loom.db.model.asset;

import java.util.UUID;

import io.metaloom.loom.db.CRUDDao;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.utils.hash.SHA512Sum;
import io.vertx.core.json.JsonObject;

public interface AssetDao extends CRUDDao<Asset> {

	default Asset createAsset(User user, SHA512Sum sha512sum, String mimeType, String initialOrigin, long size) {
		return createAsset(user.getUuid(), sha512sum, mimeType, initialOrigin, size);
	}

	Asset createAsset(UUID userUuid, SHA512Sum sha512sum, String mimeType, String initialOrigin, long size);

	void storeUserMeta(User user, Asset asset, JsonObject meta);

	void deleteUserMeta(User user, Asset asset);

	JsonObject readUserMeta(User user, Asset asset);

	Asset loadBySHA512(SHA512Sum sha512sum);

	Asset loadBySHA512OrUuid(String sha512sumOrUuid);

	void deleteBySHA512(SHA512Sum sha512sum);

}
