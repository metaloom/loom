package io.metaloom.loom.db.jooq.dao.user;

import static io.metaloom.loom.db.jooq.tables.User.USER;

import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqUserDao;
import io.metaloom.loom.db.jooq.tables.pojos.JooqUser;
import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.db.model.user.LoomUserDao;

@Singleton
public class LoomUserDaoImpl extends AbstractJooqDao<JooqUserDao> implements LoomUserDao {

	@Inject
	public LoomUserDaoImpl(JooqUserDao dao, DSLContext ctx) {
		super(dao, ctx);
	}

	@Override
	public LoomUser createUser(String username) {
		JooqUser u = new JooqUser();
		u.setUuid(UUID.randomUUID());
		u.setUsername(username);
		return new LoomUserImpl(u);
	}

	@Override
	public void storeUser(LoomUser user) {
		JooqUser jooq = unwrap(user);
		dao().insert(jooq);
	}

	@Override
	public LoomUser loadUser(UUID uuid) {
		JooqUser user = dao().findById(uuid);
		return new LoomUserImpl(user);
	}

	@Override
	public void updateUser(LoomUser user) {
		Objects.requireNonNull(user, "User must not be null");
	}

	@Override
	public void deleteUser(LoomUser user) {
		Objects.requireNonNull(user, "User must not be null");

	}

	@Override
	public Stream<LoomUser> findAll() {
		return dao().findAll().stream().map(this::wrap);
	}
}
