package io.metaloom.loom.db.jooq.user;

import java.io.IOException;
import java.util.UUID;
import java.util.function.Consumer;

import io.metaloom.loom.db.jooq.AbstractDao;
import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.db.model.user.UserDao;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public class UserDaoImpl extends AbstractDao implements UserDao {

	@Override
	public Completable clear() throws IOException {
		return null;
	}

	@Override
	public Single<? extends LoomUser> createUser(String username, Consumer<LoomUser> modifier) {
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
