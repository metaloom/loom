package io.metaloom.loom.rest.model.common;

import java.util.UUID;

import io.metaloom.loom.rest.model.RestResponseModel;

public abstract class AbstractResponse implements RestResponseModel {

	private UUID uuid;

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
}
