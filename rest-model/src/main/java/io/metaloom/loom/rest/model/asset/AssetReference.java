package io.metaloom.loom.rest.model.asset;

import java.util.UUID;

import io.metaloom.loom.rest.model.RestModel;

public class AssetReference implements RestModel {

	private String sha512sum;

	private UUID uuid;

	public UUID getUuid() {
		return uuid;
	}

	public AssetReference setUuid(UUID uuid) {
		this.uuid = uuid;
		return this;
	}

	public String getSha512sum() {
		return sha512sum;
	}

	public AssetReference setSha512sum(String sha512sum) {
		this.sha512sum = sha512sum;
		return this;
	}
}
