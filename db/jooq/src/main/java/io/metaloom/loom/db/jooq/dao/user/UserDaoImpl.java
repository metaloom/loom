package io.metaloom.loom.db.jooq.dao.user;

import static io.metaloom.loom.db.jooq.tables.JooqUser.USER;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;
import org.jooq.Table;
import org.jooq.TableRecord;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.JooqDao;
import io.metaloom.loom.db.jooq.tables.JooqUser;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.db.model.user.UserDao;

@Singleton
public class UserDaoImpl extends AbstractJooqDao<User> implements UserDao, JooqDao {

	@Inject
	public UserDaoImpl(DSLContext ctx) {
		super(ctx);
	}

	@Override
	protected Table<? extends TableRecord<?>> getTable() {
		return JooqUser.USER;
	}

	@Override
	protected Class<? extends User> getPojoClass() {
		return UserImpl.class;
	}

	@Override
	public User createUser(UUID creatorUuid, String username) {
		User user = new UserImpl();
		user.setUsername(username);
		if (creatorUuid != null) {
			setCreatorEditor(user, creatorUuid);
		}
		return user;
	}

	@Override
	public User loadUserByUsername(String username) {
		return ctx().selectFrom(USER)
			.where(USER.USERNAME.equal(username))
			.fetchOneInto(User.class);
	}

}
