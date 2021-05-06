package io.metaloom.loom.db.role;

import io.metaloom.loom.db.fs.AbstractFSCUDElement;

public class FsRoleImpl extends AbstractFSCUDElement implements Role {

	private String name;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Role setName(String name) {
		this.name = name;
		return this;
	}

}
