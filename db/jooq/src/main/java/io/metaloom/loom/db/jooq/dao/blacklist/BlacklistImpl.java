package io.metaloom.loom.db.jooq.dao.blacklist;

import io.metaloom.loom.db.jooq.AbstractEditableElement;
import io.metaloom.loom.db.model.blacklist.Blacklist;

public class BlacklistImpl extends AbstractEditableElement<Blacklist> implements Blacklist {

	private String name;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Blacklist setName(String name) {
		this.name = name;
		return this;
	}

}
