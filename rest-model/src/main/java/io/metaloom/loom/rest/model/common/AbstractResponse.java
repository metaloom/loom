package io.metaloom.loom.rest.model.common;

import java.util.UUID;

import io.metaloom.loom.rest.model.RestModel;

public abstract class AbstractResponse implements RestModel {

	private UUID uuid;

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
}
