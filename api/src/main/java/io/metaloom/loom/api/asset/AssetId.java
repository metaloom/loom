package io.metaloom.loom.api.asset;

import java.util.UUID;

import io.metaloom.loom.api.asset.impl.AssetIdImpl;
import io.metaloom.utils.UUIDUtils;
import io.metaloom.utils.hash.SHA512Sum;

public interface AssetId {

	boolean isUUID();

	SHA512Sum hashsum();

	UUID uuid();

	public static AssetId assetId(UUID uuid) {
		return new AssetIdImpl(uuid);
	}

	public static AssetId assetId(SHA512Sum hash) {
		return new AssetIdImpl(hash);
	}

	public static AssetId assetId(String id) {
		if (UUIDUtils.isUUID(id)) {
			return new AssetIdImpl(UUIDUtils.fromString(id));
		} else {
			SHA512Sum sha512 = SHA512Sum.fromString(id);
			return new AssetIdImpl(sha512);
		}
	}
}
