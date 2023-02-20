package io.metaloom.loom.db.jooq.dao.user;

import static io.metaloom.loom.db.jooq.tables.User.USER;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractDao;
import io.metaloom.loom.db.jooq.tables.daos.UserDao;
import io.metaloom.loom.db.jooq.tables.pojos.User;
import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.db.model.user.LoomUserDao;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;

@Singleton
public class LoomUserDaoImpl extends AbstractDao implements LoomUserDao {

	private UserDao userDao;
	private Scheduler scheduler;

	@Inject
	public LoomUserDaoImpl(UserDao userDao, DSLContext ctx, @Named("jooq") Scheduler scheduler) {
		super(ctx);
		this.userDao = userDao;
		this.scheduler = scheduler;
	}

	@Override
	public void clear() {
		context().deleteFrom(USER).execute();
	}

	@Override
	public LoomUser createUser(String username, Consumer<LoomUser> modifier) {
		User u = new User();
		u.setUuid(UUID.randomUUID());
		u.setUsername("dummy");
		userDao.insert(u);
		return new LoomUserImpl(u);
	}

	@Override
	public LoomUser loadUser(UUID uuid) {
		User user = userDao.findById(uuid);
		return new LoomUserImpl(user);
	}

	@Override
	public void updateUser(LoomUser user) {
	}

	@Override
	public void deleteUser(LoomUser user) {
	}

	@Override
	public Stream<LoomUser> findAll() {
		return userDao.findAll().stream().map(LoomUserImpl::new);
	}
}
