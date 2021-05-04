package io.metaloom.loom.db.user;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.JooqType;
import io.metaloom.loom.db.jooq.tables.daos.UserDao;
import io.reactivex.Maybe;

public class JooqUsersDaoImpl extends AbstractJooqDao implements UsersDao {

	private final UserDao delegate;

	protected JooqType getType() {
		return JooqType.USER;
	}

	public JooqUsersDaoImpl(UserDao delegate) {
		this.delegate = delegate;
	}

	@Override
	public Maybe<? extends User> loadUser(UUID uuid) {
		return wrap(delegate.findOneById(uuid), JooqUserImpl.class);
	}

	@Override
	public void deleteUser(User user) {
		Objects.requireNonNull(user, "User must not be null");
		delegate.deleteById(user.getUuid());
	}

	@Override
	public User createUser() {
		io.metaloom.loom.db.jooq.tables.pojos.User user = new io.metaloom.loom.db.jooq.tables.pojos.User();
		delegate.insert(user);
		return new JooqUserImpl(user);
	}

	@Override
	public void updateUser(User user) {
		Objects.requireNonNull(user, "User must not be null");
		delegate.update(unwrap(user));
	}

	@Override
	public void storeUser(User user) {
		Objects.requireNonNull(user, "User must not be null");
		delegate.update(unwrap(user));
	}

	@Override
	public void clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
	}

}
