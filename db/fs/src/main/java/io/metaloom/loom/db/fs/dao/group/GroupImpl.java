package io.metaloom.loom.db.fs.dao.group;

import java.util.ArrayList;
import java.util.List;

import io.metaloom.loom.db.fs.AbstractFSCUDElement;
import io.metaloom.loom.db.model.group.Group;
import io.metaloom.loom.db.model.role.Role;
import io.metaloom.loom.db.model.user.LoomUser;
import io.vertx.core.json.JsonObject;

public class GroupImpl extends AbstractFSCUDElement implements Group {

	private String name;
	private JsonObject meta;

	protected List<Role> roles = new ArrayList<>();
	protected List<LoomUser> users = new ArrayList<>();

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Group setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public JsonObject getMeta() {
		return meta;
	}

	@Override
	public Group setMeta(JsonObject meta) {
		this.meta = meta;
		return this;
	}

	@Override
	public List<LoomUser> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group setUsers(List<LoomUser> users) {
		// TODO Auto-generated method stub
		return null;
	}
}
