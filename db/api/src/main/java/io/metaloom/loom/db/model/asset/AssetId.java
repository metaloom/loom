package io.metaloom.loom.db.model.asset;

import java.util.UUID;

import io.metaloom.utils.UUIDUtils;
import io.metaloom.utils.hash.SHA512Sum;

public class AssetId {

	private final String id;

	public AssetId(String id) {
		this.id = id;
	}

	public UUID uuid() {
		return UUIDUtils.fromString(id);
	}

	public SHA512Sum hashsum() {
		SHA512Sum sha512 = SHA512Sum.fromString(id);
		return sha512;
	}

	public boolean isUUID() {
		return UUIDUtils.isUUID(id);
}

	@Override
	public String toString() {
		return "Id: " + id;
	}
}
