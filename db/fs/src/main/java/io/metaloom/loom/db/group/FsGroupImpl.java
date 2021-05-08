package io.metaloom.loom.db.group;

import java.util.ArrayList;
import java.util.List;

import io.metaloom.loom.db.fs.AbstractFSCUDElement;
import io.metaloom.loom.db.role.LoomRole;
import io.metaloom.loom.db.user.LoomUser;

public class FsGroupImpl extends AbstractFSCUDElement implements LoomGroup {

	private String name;

	protected List<LoomRole> roles = new ArrayList<>();
	protected List<LoomUser> users = new ArrayList<>();

	@Override
	public String getName() {
		return name;
	}

	@Override
	public LoomGroup setName(String name) {
		this.name = name;
		return this;
	}
}
