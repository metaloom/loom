package io.metaloom.loom.db.group;

import java.util.ArrayList;
import java.util.List;

import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.fs.AbstractFSCUDElement;
import io.metaloom.loom.db.role.Role;
import io.metaloom.loom.db.user.User;

public class FsGroupImpl extends AbstractFSCUDElement implements Group {

	private String name;

	protected List<Role> roles = new ArrayList<>();
	protected List<User> users = new ArrayList<>();

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Group setName(String name) {
		this.name = name;
		return this;
	}
}
