package io.metaloom.loom.db.group;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.role.Role;
import io.metaloom.loom.db.user.User;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface GroupDao extends LoomDao {

	Single<? extends Group> createGroup(String name);

	void deleteGroup(Group group);

	void updateGroup(Group group);

	Maybe<? extends Group> loadGroup(UUID uuid);

	void storeGroup(Group group);

	Observable<User> loadUsers(Group group);

	// Users
	Completable addUser(Group group, User user);

	Completable removeUser(Group group, User user);

	// Roles
	void addRole(Group group, Role role);

	void removeRole(Group group, Role role);

	Observable<Role> loadRoles(Group group);

}
