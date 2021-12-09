package io.metaloom.loom.db.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import io.metaloom.loom.db.LoomElement;

@MappedSuperclass
public abstract class AbstractLoomElement implements LoomElement {

	@Id
	@Column(name = "uuid", unique = true, nullable = false)
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
