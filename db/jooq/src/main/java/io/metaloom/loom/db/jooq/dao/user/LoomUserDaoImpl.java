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
import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.db.model.user.LoomUserDao;
import io.metaloom.loom.db.page.Page;

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
		if (user == null) {
			return null;
		}
		return new LoomUserImpl(user);
	}

	@Override
	public LoomUser loadUserByUsername(String username) {
		JooqUser user = dao().fetchOneByJooqUsername(username);
		if (user == null) {
			return null;
		}
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

	@Override
	public Page<LoomUser> loadUsers(UUID fromUuid, int pageSize) {
		SelectSeekStep1<Record3<UUID, String, String>, UUID> query = dao().ctx()
			.select(USER.UUID, USER.USERNAME, USER.EMAIL)
			.from(USER)
			.orderBy(USER.UUID);
		if (fromUuid != null) {
			query.seek(fromUuid);
		}
		List<LoomUser> list = query
			.limit(pageSize)
			.fetchStreamInto(JooqUser.class)
			.map(LoomUserImpl::new)
			.collect(Collectors.toList());
		return new Page<>(list);
	}
}
