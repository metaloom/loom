package io.metaloom.loom.db.group;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.role.LoomRole;
import io.metaloom.loom.db.user.LoomUser;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface LoomGroupDao extends LoomDao {

	Single<? extends LoomGroup> createGroup(String name);

	Completable deleteGroup(LoomGroup group);

	Completable updateGroup(LoomGroup group);

	Maybe<? extends LoomGroup> loadGroup(UUID uuid);

	Observable<LoomUser> loadUsers(LoomGroup group);

	// Users
	Completable addUser(LoomGroup group, LoomUser user);

	Completable removeUser(LoomGroup group, LoomUser user);

	// Roles
	Completable addRole(LoomGroup group, LoomRole role);

	Completable removeRole(LoomGroup group, LoomRole role);

	Observable<LoomRole> loadRoles(LoomGroup group);

	Completable testMultiOp();

}
