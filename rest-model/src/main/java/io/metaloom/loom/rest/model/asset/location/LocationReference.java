package io.metaloom.loom.rest.model.asset.location;

import java.util.UUID;

import io.metaloom.loom.rest.model.RestModel;

public class LocationReference implements RestModel {

	private UUID uuid;

	private String path;

	public LocationReference() {
	}

	public UUID getUuid() {
		return uuid;
	}

	public LocationReference setUuid(UUID uuid) {
		this.uuid = uuid;
		return this;
	}

	public LocationReference setPath(String path) {
		this.path = path;
		return this;
	}

	public String getPath() {
		return path;
	}

}
