package io.metaloom.loom.db.model.group;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Stream;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.model.role.LoomRole;
import io.metaloom.loom.db.model.user.LoomUser;
import io.reactivex.rxjava3.core.Completable;

public interface LoomGroupDao extends LoomDao {

	default LoomGroup createGroup(String name) {
		return createGroup(name, null);
	}

	LoomGroup createGroup(String name, Consumer<LoomGroup> modifier);

	Completable deleteGroup(UUID uuid);

	LoomGroup updateGroup(LoomGroup group);

	LoomGroup loadGroup(UUID uuid);

	// Users
	void addUserToGroup(LoomGroup group, LoomUser user);

	void removeUserFromGroup(LoomGroup group, LoomUser user);

	LoomUser  loadUsers(LoomGroup group);

	// Roles
	void addRoleToGroup(LoomGroup group, LoomRole role);

	void removeRoleFromGroup(LoomGroup group, LoomRole role);

	LoomRole loadRoles(LoomGroup group);

	void testMultiOp();

	Stream<? extends LoomGroup> findAll();

}
