package io.metaloom.loom.db.mem;

import java.util.UUID;

import io.metaloom.loom.db.Element;

public abstract class AbstractMemLoomElement implements Element {

	private UUID uuid;

	@Override
	public UUID getUuid() {
		return uuid;
	}

	@Override
	public Element setUuid(UUID uuid) {
		this.uuid = uuid;
		return this;
	}

}
