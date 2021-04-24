package io.metaloom.loom.rest.model.asset;

import java.util.UUID;

import io.metaloom.loom.rest.model.RestModel;

public class AssetReference implements RestModel {

	private UUID uuid;

	public AssetReference() {
	}

	public UUID getUuid() {
		return uuid;
	}

	public AssetReference setUuid(UUID uuid) {
		this.uuid = uuid;
		return this;
	}

}
