package io.metaloom.loom.db.mem;

import java.util.UUID;

import io.metaloom.loom.db.LoomElement;

public abstract class AbstractMemLoomElement implements LoomElement {

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
