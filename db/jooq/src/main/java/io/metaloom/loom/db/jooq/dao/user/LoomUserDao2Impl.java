package io.metaloom.loom.db.jooq.dao.user;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractDao;
import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.db.model.user.LoomUserDao;

@Singleton
public class LoomUserDao2Impl extends AbstractDao implements LoomUserDao {


	@Inject
	public LoomUserDao2Impl(DSLContext ctx) {
		super(ctx);
	}

	// protected JooqType getType() {
	// return JooqType.USER;
	// }

//	@Override
//	public Maybe<? extends LoomUser> loadUser(UUID uuid) {
//		return wrap(findOneById(uuid), JooqUserImpl.class);
//	}
//
//	@Override
//	public Completable deleteUser(LoomUser user) {
//		Objects.requireNonNull(user, "User must not be null");
//		return deleteById(user.getUuid()).ignoreElement();
//	}
//
//	@Override
//	public Single<? extends LoomUser> createUser(String username) {
//		User user = new User();
//		user.setUsername(username);
//		return insertReturningPrimary(user).map(pk -> new JooqUserImpl(user.setUuid(pk)));
//	}
//
//	@Override
//	public Completable updateUser(LoomUser user) {
//		Objects.requireNonNull(user, "User must not be null");
//		return update(unwrap(user)).ignoreElement();
//	}

	@Override
	public void clear() {
		// TODO run jooq SQL to delete contents of table
	}

	@Override
	public LoomUser createUser(String username, Consumer<LoomUser> modifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoomUser loadUser(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(LoomUser user) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteUser(LoomUser user) {
		// TODO Auto-generated method stub
	}

	@Override
	public Stream<LoomUser> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
