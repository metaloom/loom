package io.metaloom.loom.rest.model.embedding;

import java.util.UUID;

import io.metaloom.loom.rest.model.RestModel;

public class EmbeddingReference implements RestModel {

	private UUID uuid;
	
	public UUID getUuid() {
		return uuid;
	}

	public EmbeddingReference setUuid(UUID uuid) {
		this.uuid = uuid;
		return this;
	}
}
