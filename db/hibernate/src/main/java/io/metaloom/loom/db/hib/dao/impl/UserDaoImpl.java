package io.metaloom.loom.db.hib.dao.impl;

import java.io.IOException;
import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.hibernate.reactive.mutiny.Mutiny;

import io.metaloom.loom.db.hib.dao.AbstractDao;
import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.db.model.user.UserDao;
import io.metaloom.loom.db.model.user.impl.LoomUserImpl;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

@Singleton
public class UserDaoImpl extends AbstractDao implements UserDao {

	public static final String TYPE_NAME = "User";

	@Inject
	public UserDaoImpl(Mutiny.SessionFactory emf) {
		super(emf);
	}

	@Override
	public Completable clear() throws IOException {
		return invokeClear(TYPE_NAME);
	}

	@Override
	public Single<? extends LoomUser> createUser(String username, Consumer<LoomUser> modifier) {
		return Single.defer(() -> {
			if (username == null) {
				return Single.error(new NullPointerException("Username must be set"));
			}
			LoomUser user = new LoomUserImpl(username);
			user.setUuid(UUID.randomUUID());
			if (modifier != null) {
				modifier.accept(user);
			}
			return persistAndReturnElement(user);
		});
	}

	@Override
	public Maybe<? extends LoomUser> loadUser(UUID uuid) {
		return loadByUuid(LoomUserImpl.class, uuid);
	}

	@Override
	public Completable updateUser(LoomUser user) {
		return persistElement(user);
	}

	@Override
	public Completable deleteUser(LoomUser user) {
		return deleteElement(user);
	}
}
