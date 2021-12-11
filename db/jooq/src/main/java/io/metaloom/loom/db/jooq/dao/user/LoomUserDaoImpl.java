package io.metaloom.loom.db.jooq.dao.user;

import static io.metaloom.loom.db.jooq.tables.User.USER;

import java.io.IOException;
import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractDao;
import io.metaloom.loom.db.jooq.tables.daos.UserDao;
import io.metaloom.loom.db.jooq.tables.pojos.User;
import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.db.model.user.LoomUserDao;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;

@Singleton
public class LoomUserDaoImpl extends AbstractDao implements LoomUserDao {

	private UserDao userDao;
	private DSLContext ctx;
	private Scheduler scheduler;

	@Inject
	public LoomUserDaoImpl(UserDao userDao, DSLContext context, @Named("jooq") Scheduler scheduler) {
		this.userDao = userDao;
		this.ctx = context;
		this.scheduler = scheduler;
	}

	@Override
	public Completable clear() throws IOException {
		return Completable.create(sub -> {
			ctx.deleteFrom(USER).execute();
			sub.onComplete();
		}).subscribeOn(scheduler);
	}

	@Override
	public Single<? extends LoomUser> createUser(String username, Consumer<LoomUser> modifier) {
		Single<? extends LoomUser> result = Single.create(sub -> {
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
		return result.subscribeOn(scheduler);
	}

	@Override
	public Maybe<? extends LoomUser> loadUser(UUID uuid) {
		Maybe<? extends LoomUser> result = Maybe.create(sub -> {
			try {
				User user = userDao.findById(uuid);
				if (user == null) {
					sub.onComplete();
				} else {
					sub.onSuccess(new LoomUserImpl(user));
				}
			} catch (Throwable t) {
				sub.onError(t);
			}
		});
		return result.subscribeOn(scheduler);
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
		Observable<LoomUser> result = Single.just(userDao.findAll()).flatMapObservable(Observable::fromIterable).map(LoomUserImpl::new);
		return result.observeOn(scheduler);
	}
}
