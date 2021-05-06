package io.metaloom.loom.db.user;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.Configuration;

import io.reactivex.Maybe;
import io.reactivex.Single;
import io.vertx.reactivex.sqlclient.SqlClient;

@Singleton
public class JooqUserDaoImpl extends io.metaloom.loom.db.jooq.tables.daos.UserDao implements UserDao {

	@Inject
	public JooqUserDaoImpl(Configuration configuration, SqlClient rxSqlClient) {
		super(configuration, rxSqlClient);
	}

	// protected JooqType getType() {
	// return JooqType.USER;
	// }

	@Override
	public Maybe<? extends User> loadUser(UUID uuid) {
		return wrap(findOneById(uuid), JooqUserImpl.class);
	}

	@Override
	public void deleteUser(User user) {
		Objects.requireNonNull(user, "User must not be null");
		deleteById(user.getUuid());
	}

	@Override
	public Single<? extends User> createUser(String username) {
		io.metaloom.loom.db.jooq.tables.pojos.User user = new io.metaloom.loom.db.jooq.tables.pojos.User();
		user.setUsername(username);
		return insert(user).map(e -> new JooqUserImpl(user));
	}

	@Override
	public void updateUser(User user) {
		Objects.requireNonNull(user, "User must not be null");
		update(unwrap(user));
	}

	@Override
	public void storeUser(User user) {
		Objects.requireNonNull(user, "User must not be null");
		update(unwrap(user));
	}

	@Override
	public void clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
	}

}
