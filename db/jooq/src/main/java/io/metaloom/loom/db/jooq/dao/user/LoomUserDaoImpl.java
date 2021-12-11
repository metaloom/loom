package io.metaloom.loom.db.jooq.dao.user;

import java.io.IOException;
import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.jooq.AbstractDao;
import io.metaloom.loom.db.jooq.tables.daos.UserDao;
import io.metaloom.loom.db.jooq.tables.pojos.User;
import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.db.model.user.LoomUserDao;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

@Singleton
public class LoomUserDaoImpl extends AbstractDao implements LoomUserDao {

	private UserDao userDao;

	@Inject
	public LoomUserDaoImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Completable clear() throws IOException {
		return null;
	}

	@Override
	public Single<? extends LoomUser> createUser(String username, Consumer<LoomUser> modifier) {
		return Single.create(sub -> {
			try {
				User u = new User();
				u.setUuid(UUID.randomUUID());
				u.setUsername("dummy");
				userDao.insert(u);
				sub.onSuccess(new LoomUserImpl(u));
			} catch (Throwable e) {
				sub.onError(e);
			}
		});
	}

	@Override
	public Maybe<? extends LoomUser> loadUser(UUID uuid) {
		return null;
	}

	@Override
	public Completable updateUser(LoomUser user) {
		return null;
	}

	@Override
	public Completable deleteUser(LoomUser user) {
		return null;
	}

	@Override
	public Observable<LoomUser> findAll() {
		return Single.just(userDao.findAll()).flatMapObservable(Observable::fromIterable).map(LoomUserImpl::new);
	}
}
