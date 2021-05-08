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

	void deleteGroup(LoomGroup group);

	void updateGroup(LoomGroup group);

	Maybe<? extends LoomGroup> loadGroup(UUID uuid);

	void storeGroup(LoomGroup group);

	Observable<LoomUser> loadUsers(LoomGroup group);

	// Users
	Completable addUser(LoomGroup group, LoomUser user);

	Completable removeUser(LoomGroup group, LoomUser user);

	// Roles
	void addRole(LoomGroup group, LoomRole role);

	void removeRole(LoomGroup group, LoomRole role);

	Observable<LoomRole> loadRoles(LoomGroup group);

	void testMultiOp();

}
