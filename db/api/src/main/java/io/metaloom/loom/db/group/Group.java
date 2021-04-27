package io.metaloom.loom.db.group;

import java.util.stream.Stream;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.LoomElement;
import io.metaloom.loom.db.role.Role;
import io.metaloom.loom.db.user.User;

public interface Group extends CUDElement, LoomElement {

	String getName();

	Group setName(String name);

	Group addUser(User user);

	Stream<User> streamUsers();

	Group addRole(Role role);

	Group removeRole(Role role);
}
