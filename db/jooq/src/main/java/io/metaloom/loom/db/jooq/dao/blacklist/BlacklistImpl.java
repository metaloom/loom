package io.metaloom.loom.db.jooq.dao.blacklist;

import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractEditableElement;
import io.metaloom.loom.db.model.blacklist.Blacklist;

public class BlacklistImpl extends AbstractEditableElement<Blacklist> implements Blacklist {

	private String name;
	private UUID binaryUuid;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Blacklist setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public UUID getBinaryUuid() {
		return binaryUuid;
	}

	@Override
	public Blacklist setBinaryUuid(UUID binaryUuid) {
		this.binaryUuid = binaryUuid;
		return this;
	}

}
