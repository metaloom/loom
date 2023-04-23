package io.metaloom.loom.db.model.group;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Stream;

import io.metaloom.loom.db.Dao;
import io.metaloom.loom.db.model.role.Role;
import io.metaloom.loom.db.model.user.User;
import io.reactivex.rxjava3.core.Completable;

public interface GroupDao extends Dao {

	default Group createGroup(String name) {
		return createGroup(name, null);
	}

	Group createGroup(String name, Consumer<Group> modifier);

	Completable deleteGroup(UUID uuid);

	Group updateGroup(Group group);

	Group loadGroup(UUID uuid);

	// Users
	void addUserToGroup(Group group, User user);

	void removeUserFromGroup(Group group, User user);

	User  loadUsers(Group group);

	// Roles
	void addRoleToGroup(Group group, Role role);

	void removeRoleFromGroup(Group group, Role role);

	Role loadRoles(Group group);

	void testMultiOp();

	Stream<? extends Group> findAll();

	/**
	 * Store the group information.
	 * 
	 * @param group
	 */
	void storeGroup(Group group);

}
