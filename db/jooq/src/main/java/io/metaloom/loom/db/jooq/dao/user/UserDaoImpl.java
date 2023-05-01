package io.metaloom.loom.db.jooq.dao.user;

import static io.metaloom.loom.db.jooq.tables.JooqUser.USER;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;
import org.jooq.Record3;
import org.jooq.SelectSeekStep1;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqUserDao;
import io.metaloom.loom.db.jooq.tables.pojos.JooqUser;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.db.model.user.UserDao;
import io.metaloom.loom.db.page.Page;

@Singleton
public class UserDaoImpl extends AbstractJooqDao<JooqUserDao> implements UserDao {

	@Inject
	public UserDaoImpl(JooqUserDao dao, DSLContext ctx) {
		super(dao, ctx);
	}

	@Override
	public User createUser(String username) {
		JooqUser u = new JooqUser();
		u.setUuid(UUID.randomUUID());
		u.setUsername(username);
		return new UserImpl(u);
	}

	@Override
	public void storeUser(User user) {
		JooqUser jooq = unwrap(user);
		dao().insert(jooq);
	}

	@Override
	public User loadUser(UUID uuid) {
		return ctx().selectFrom(USER)
			.where(USER.UUID.equal(uuid))
			.fetchOneInto(User.class);

		// JooqUser user = dao().findById(uuid);
		// if (user == null) {
		// return null;
		// }
		// return new UserImpl(user);
	}

	@Override
	public User loadUserByUsername(String username) {
			return ctx().selectFrom(USER)
			.where(USER.USERNAME.equal(username))
			.fetchOneInto(User.class);
	}

	@Override
	public void updateUser(User user) {
		Objects.requireNonNull(user, "User must not be null");
	}

	@Override
	public void deleteUser(User user) {
		Objects.requireNonNull(user, "User must not be null");

	}

	@Override
	public Stream<User> findAll() {
		return dao().findAll().stream().map(this::wrap);
	}

	@Override
	public Page<User> loadUsers(UUID fromUuid, int pageSize) {
		SelectSeekStep1<Record3<UUID, String, String>, UUID> query = dao().ctx()
			.select(USER.UUID, USER.USERNAME, USER.EMAIL)
			.from(USER)
			.orderBy(USER.UUID);
		if (fromUuid != null) {
			query.seek(fromUuid);
		}
		List<User> list = query
			.limit(pageSize)
			.fetchStreamInto(JooqUser.class)
			.map(UserImpl::new)
			.collect(Collectors.toList());
		return new Page<>(list);
	}
}
