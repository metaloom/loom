package io.metaloom.loom.db.model;

import io.metaloom.loom.db.fs.AbstractFSCUDElement;
import io.metaloom.loom.db.model.model.Model;

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
