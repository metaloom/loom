package io.metaloom.loom.db.role;

import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.fs.AbstractFSCUDElement;

public class FsRoleImpl extends AbstractFSCUDElement implements Role {

	private String name;

	public FsRoleImpl(DaoCollection daos) {
		super(daos);
	}

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
