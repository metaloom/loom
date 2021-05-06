package io.metaloom.loom.db.group;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;
import static io.metaloom.loom.db.jooq.tables.User.USER;
import static io.metaloom.loom.db.jooq.tables.UserGroup.USER_GROUP;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.Configuration;

import io.github.jklingsporn.vertx.jooq.rx.reactivepg.ReactiveRXQueryExecutor;
import io.metaloom.loom.db.jooq.JooqWrapperHelper;
import io.metaloom.loom.db.jooq.tables.daos.UserGroupDao;
import io.metaloom.loom.db.jooq.tables.pojos.UserGroup;
import io.metaloom.loom.db.jooq.tables.records.UserGroupRecord;
import io.metaloom.loom.db.jooq.tables.records.UserRecord;
import io.metaloom.loom.db.role.Role;
import io.metaloom.loom.db.user.JooqUserDaoImpl;
import io.metaloom.loom.db.user.JooqUserImpl;
import io.metaloom.loom.db.user.User;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.vertx.reactivex.sqlclient.SqlClient;

@Singleton
public class JooqGroupDaoImpl extends io.metaloom.loom.db.jooq.tables.daos.GroupDao implements GroupDao {

	private final UserGroupDao userGroupDao;

	private final JooqUserDaoImpl userDao;

	@Inject
	public JooqGroupDaoImpl(JooqUserDaoImpl userDao, UserGroupDao userGroupDao, Configuration configuration, SqlClient rxSqlClient) {
		super(configuration, rxSqlClient);
		this.userDao = userDao;
		this.userGroupDao = userGroupDao;
	}

	// protected JooqType getType() {
	// return JooqType.GROUP;
	// }

	@Override
	public Maybe<? extends Group> loadGroup(UUID uuid) {
		return wrap(findOneById(uuid), JooqGroupImpl.class);
	}

	@Override
	public void deleteGroup(Group group) {
		Objects.requireNonNull(group, "Group must not be null");
		deleteById(group.getUuid());
	}

	@Override
	public Single<Group> createGroup(String name) {
		io.metaloom.loom.db.jooq.tables.pojos.Group group = new io.metaloom.loom.db.jooq.tables.pojos.Group();
		group.setName(name);
		return insertReturningPrimary(group).map(pk -> new JooqGroupImpl(group.setUuid(pk)));
	}

	@Override
	public void updateGroup(Group group) {
		Objects.requireNonNull(group, "Group must not be null");
		update(unwrap(group));
	}

	@Override
	public void storeGroup(Group group) {
		Objects.requireNonNull(group, "Group must not be null");
		update(unwrap(group));
	}

	@Override
	public Completable addUser(Group group, User user) {
		UserGroup userGroup = new UserGroup();
		userGroup.setGroupUuid(group.getUuid());
		userGroup.setUserUuid(user.getUuid());
		return userGroupDao.insert(userGroup).ignoreElement();
	}

	@Override
	public Completable removeUser(Group group, User user) {
		UserGroupRecord record = new UserGroupRecord(user.getUuid(), group.getUuid());
		return userGroupDao.deleteById(record).ignoreElement();
	}

	@Override
	public void removeRole(Group group, Role role) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRole(Group group, Role role) {
		// TODO Auto-generated method stub

	}

	@Override
	public Observable<Role> loadRoles(Group group) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<User> loadUsers(Group group) {
		ReactiveRXQueryExecutor<UserRecord, io.metaloom.loom.db.jooq.tables.pojos.User, UUID> queryExecutor = userDao.queryExecutor();
		Single<List<io.metaloom.loom.db.jooq.tables.pojos.User>> result = queryExecutor.findMany(dslContext -> dslContext.select()
			.from(USER_GROUP
				.join(USER)
				.on(USER.UUID.eq(USER_GROUP.USER_UUID))
				.where(USER_GROUP.GROUP_UUID.eq(group.getUuid())).asTable(USER))
			.coerce(USER));

		return result.flatMapObservable(list -> {
			return Observable.fromIterable(list);
		}).map(jooq -> {
			return JooqWrapperHelper.wrap(jooq, JooqUserImpl.class);
		});
	}

	@Override
	public void clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
	}

}
