package io.metaloom.loom.db.hib.dao.impl;

import java.io.IOException;
import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.hibernate.reactive.mutiny.Mutiny;

import io.metaloom.loom.db.hib.dao.AbstractDao;
import io.metaloom.loom.db.model.role.Role;
import io.metaloom.loom.db.model.role.RoleDao;
import io.metaloom.loom.db.model.role.impl.RoleImpl;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

@Singleton
public class RoleDaoImpl extends AbstractDao implements RoleDao {

	public static final String TYPE_NAME = "Role";

	@Inject
	public RoleDaoImpl(Mutiny.SessionFactory emf) {
		super(emf);
	}

	@Override
	public Completable clear() throws IOException {
		return invokeClear(TYPE_NAME);
	}

	@Override
	public Single<? extends Role> createRole(String name, Consumer<Role> modifier) {
		return Single.defer(() -> {
			if (name == null) {
				return Single.error(new NullPointerException("Name must be set"));
			}
			Role role = new RoleImpl(name);
			if (modifier != null) {
				modifier.accept(role);
			}
			return persistAndReturnElement(role);
		});
	}

	@Override
	public Maybe<? extends Role> loadRole(UUID uuid) {
		return loadByUuid(RoleImpl.class, uuid);
	}

	@Override
	public Completable deleteRole(UUID uuid) {
		return deleteByUuid(RoleImpl.class, uuid);
	}

	@Override
	public Completable updateRole(Role role) {
		return persistElement(role);
	}

}
