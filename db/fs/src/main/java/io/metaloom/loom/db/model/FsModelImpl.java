package io.metaloom.loom.db.model;

import io.metaloom.loom.db.fs.AbstractFSCUDElement;

public class FsModelImpl extends AbstractFSCUDElement implements LoomModel {

	private String name;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public LoomModel setName(String name) {
		this.name = name;
		return this;
	}

}
