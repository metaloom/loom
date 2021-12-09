package io.metaloom.loom.db.user;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.Configuration;

import io.metaloom.loom.db.jooq.tables.daos.UserDao;
import io.metaloom.loom.db.jooq.tables.pojos.User;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.vertx.reactivex.sqlclient.SqlClient;

@Singleton
public class JooqUserDaoImpl extends UserDao implements LoomUserDao {


	@Inject
	public JooqUserDaoImpl(Configuration configuration, SqlClient rxClient) {
		super(configuration, rxClient);
	}

	// protected JooqType getType() {
	// return JooqType.USER;
	// }

	@Override
	public Maybe<? extends LoomUser> loadUser(UUID uuid) {
		return wrap(findOneById(uuid), JooqUserImpl.class);
	}

	@Override
	public Completable deleteUser(LoomUser user) {
		Objects.requireNonNull(user, "User must not be null");
		return deleteById(user.getUuid()).ignoreElement();
	}

	@Override
	public Single<? extends LoomUser> createUser(String username) {
		User user = new User();
		user.setUsername(username);
		return insertReturningPrimary(user).map(pk -> new JooqUserImpl(user.setUuid(pk)));
	}

	@Override
	public Completable updateUser(LoomUser user) {
		Objects.requireNonNull(user, "User must not be null");
		return update(unwrap(user)).ignoreElement();
	}

	@Override
	public Completable clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
		return Completable.complete();
	}

}
