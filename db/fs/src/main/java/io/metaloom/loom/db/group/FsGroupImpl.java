package io.metaloom.loom.db.group;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.metaloom.loom.db.fs.AbstractFSCUDElement;
import io.metaloom.loom.db.role.Role;
import io.metaloom.loom.db.user.User;

public class FsGroupImpl extends AbstractFSCUDElement implements Group {

	private String name;

	private List<Role> roles = new ArrayList<>();
	private List<User> users = new ArrayList<>();

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
	@JsonIgnore
	public Stream<User> streamUsers() {
		return users.stream();
	}

	@Override
	public Group addUser(User user) {
		users.add(user);
		return this;
	}

	@Override
	public Group removeUser(User user) {
		users.remove(user);
		return this;
	}

	@Override
	public Group addRole(Role role) {
		roles.add(role);
		return this;
	}

	@Override
	public Group removeRole(Role role) {
		roles.remove(role);
		return this;
	}

	@Override
	@JsonIgnore
	public Stream<Role> streamRoles() {
		return roles.stream();
	}
}
