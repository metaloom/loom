package io.metaloom.loom.db.group;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.fs.AbstractFSCUDElement;
import io.metaloom.loom.db.role.Role;
import io.metaloom.loom.db.user.User;
import io.reactivex.Completable;
import io.reactivex.Observable;

public class FsGroupImpl extends AbstractFSCUDElement implements Group {

	private String name;

	private List<Role> roles = new ArrayList<>();
	private List<User> users = new ArrayList<>();

	public FsGroupImpl(DaoCollection daos) {
		super(daos);
	}

	public FsGroupImpl() {
		this(null);
	}

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
	public Observable<User> findUsers() {
		return Observable.fromIterable(users);
	}

	@Override
	public Group addUser(User user) {
		users.add(user);
		return this;
	}

	@Override
	public Completable removeUser(User user) {
		return Completable.fromAction(() -> {
			users.remove(user);
		});
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
	public Observable<Role> findRoles() {
		return Observable.fromIterable(roles);
	}
}
