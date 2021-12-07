package io.metaloom.loom.db.hib.dao.impl;

import java.io.IOException;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.hibernate.reactive.mutiny.Mutiny;

import io.metaloom.loom.db.hib.dao.AbstractDao;
import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.db.model.user.UserDao;
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
	public Single<? extends LoomUser> createUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Maybe<? extends LoomUser> loadUser(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable updateUser(LoomUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable deleteUser(LoomUser user) {
		// TODO Auto-generated method stub
		return null;
	}
}
