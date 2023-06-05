package io.metaloom.loom.api.asset;

import java.util.UUID;

import io.metaloom.utils.UUIDUtils;
import io.metaloom.utils.hash.SHA512Sum;

public class AssetId {

	private final UUID uuid;

	private final SHA512Sum hash;

	public AssetId(UUID uuid) {
		this.uuid = uuid;
		this.hash = null;
	}

	public AssetId(SHA512Sum hash) {
		this.hash = hash;
		this.uuid = null;
	}

	public UUID uuid() {
		return uuid;
	}

	public SHA512Sum hashsum() {
		return hash;
	}

	public boolean isUUID() {
		return uuid != null;
	}

	@Override
	public String toString() {
		return uuid != null ? uuid.toString() : hash.toString();
	}

	public static AssetId assetId(UUID uuid) {
		return new AssetId(uuid);
	}

	public static AssetId assetId(SHA512Sum hash) {
		return new AssetId(hash);
	}

	public static AssetId assetId(String id) {
		if (UUIDUtils.isUUID(id)) {
			return new AssetId(UUIDUtils.fromString(id));
		} else {
			SHA512Sum sha512 = SHA512Sum.fromString(id);
			return new AssetId(sha512);
		}
	}
}
