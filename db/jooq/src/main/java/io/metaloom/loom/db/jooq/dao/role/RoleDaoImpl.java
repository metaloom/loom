package io.metaloom.loom.db.jooq.dao.role;

import java.io.IOException;
import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.jooq.AbstractDao;
import io.metaloom.loom.db.model.role.Role;
import io.metaloom.loom.db.model.role.RoleDao;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

@Singleton
public class RoleDaoImpl extends AbstractDao implements RoleDao {

	@Inject
	public RoleDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Completable clear() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Single<? extends Role> createRole(String name, Consumer<Role> modifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Maybe<? extends Role> loadRole(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable deleteRole(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable updateRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

}
