package io.metaloom.loom.db.model;

import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.fs.AbstractFSCUDElement;

public class FsModelImpl extends AbstractFSCUDElement implements Model {

	private String name;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Model setName(String name) {
		this.name = name;
		return this;
	}

}
