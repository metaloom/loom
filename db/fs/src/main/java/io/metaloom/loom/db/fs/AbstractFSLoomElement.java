package io.metaloom.loom.db.fs;

import java.util.UUID;

import io.metaloom.loom.db.LoomElement;

public class AbstractFSLoomElement implements LoomElement {

	private UUID uuid;

	@Override
	public UUID getUuid() {
		return uuid;
	}

	@Override
	public LoomElement setUuid(UUID uuid) {
		this.uuid = uuid;
		return this;
	}

}
