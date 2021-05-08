package io.metaloom.loom.db.role;

import io.metaloom.loom.db.fs.AbstractFSCUDElement;

public class FsRoleImpl extends AbstractFSCUDElement implements LoomRole {

	private String name;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public LoomRole setName(String name) {
		this.name = name;
		return this;
	}

}
