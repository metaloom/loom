package io.metaloom.loom.db.model.group;

import java.util.UUID;
import java.util.function.Consumer;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.model.role.Role;
import io.metaloom.loom.db.model.user.LoomUser;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public interface GroupDao extends LoomDao {

	default Single<? extends Group> createGroup(String name) {
		return createGroup(name, null);
	}

	Single<? extends Group> createGroup(String name, Consumer<Group> modifier);

	Completable deleteGroup(UUID uuid);

	Single<? extends Group> updateGroup(Group group);

	Maybe<? extends Group> loadGroup(UUID uuid);

	// Users
	Completable addUserToGroup(Group group, LoomUser user);

	Completable removeUserFromGroup(Group group, LoomUser user);

	Observable<LoomUser> loadUsers(Group group);

	// Roles
	Completable addRoleToGroup(Group group, Role role);

	Completable removeRoleFromGroup(Group group, Role role);

	Observable<Role> loadRoles(Group group);

	Completable testMultiOp();

}
