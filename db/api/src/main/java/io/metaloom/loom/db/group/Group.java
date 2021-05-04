package io.metaloom.loom.db.group;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.LoomElement;
import io.metaloom.loom.db.role.Role;
import io.metaloom.loom.db.user.User;
import io.reactivex.Completable;
import io.reactivex.Observable;

public interface Group extends CUDElement, LoomElement {

	String getName();

	Group setName(String name);

	// Users
	Group addUser(User user);

	Completable removeUser(User user);

	Observable<User> findUsers();

	// Roles
	Group addRole(Role role);

	Group removeRole(Role role);

	Observable<Role> findRoles();
}
