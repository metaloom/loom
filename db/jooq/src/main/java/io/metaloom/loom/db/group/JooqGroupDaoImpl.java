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
import org.jooq.ResultQuery;

import io.github.jklingsporn.vertx.jooq.rx.reactivepg.ReactiveRXQueryExecutor;
import io.metaloom.loom.db.jooq.JooqWrapperHelper;
import io.metaloom.loom.db.jooq.tables.daos.GroupDao;
import io.metaloom.loom.db.jooq.tables.daos.UserGroupDao;
import io.metaloom.loom.db.jooq.tables.pojos.Group;
import io.metaloom.loom.db.jooq.tables.pojos.User;
import io.metaloom.loom.db.jooq.tables.pojos.UserGroup;
import io.metaloom.loom.db.jooq.tables.records.UserGroupRecord;
import io.metaloom.loom.db.jooq.tables.records.UserRecord;
import io.metaloom.loom.db.role.LoomRole;
import io.metaloom.loom.db.user.JooqUserDaoImpl;
import io.metaloom.loom.db.user.JooqUserImpl;
import io.metaloom.loom.db.user.LoomUser;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.vertx.reactivex.sqlclient.SqlClient;

@Singleton
public class JooqGroupDaoImpl extends GroupDao implements LoomGroupDao {

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
	public Maybe<? extends LoomGroup> loadGroup(UUID uuid) {
		return wrap(findOneById(uuid), JooqGroupImpl.class);
	}

	@Override
	public Completable deleteGroup(LoomGroup group) {
		Objects.requireNonNull(group, "Group must not be null");
		return deleteById(group.getUuid()).ignoreElement();
	}

	@Override
	public Single<LoomGroup> createGroup(String name) {
		Group group = new Group();
		group.setName(name);
		return insertReturningPrimary(group).map(pk -> new JooqGroupImpl(group.setUuid(pk)));
	}

	@Override
	public Completable updateGroup(LoomGroup group) {
		Objects.requireNonNull(group, "Group must not be null");
		return update(unwrap(group)).ignoreElement();
	}

	@Override
	public Completable addUser(LoomGroup group, LoomUser user) {
		UserGroup userGroup = new UserGroup();
		userGroup.setGroupUuid(group.getUuid());
		userGroup.setUserUuid(user.getUuid());
		return userGroupDao.insert(userGroup).ignoreElement();
	}

	@Override
	public Completable removeUser(LoomGroup group, LoomUser user) {
		UserGroupRecord record = new UserGroupRecord(user.getUuid(), group.getUuid());
		return userGroupDao.deleteById(record).ignoreElement();
	}

	@Override
	public Completable removeRole(LoomGroup group, LoomRole role) {
		// TODO Auto-generated method stub
		return Completable.complete();
	}

	@Override
	public Completable addRole(LoomGroup group, LoomRole role) {
		// TODO Auto-generated method stub
		return Completable.complete();
	}

	@Override
	public Observable<LoomRole> loadRoles(LoomGroup group) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<LoomUser> loadUsers(LoomGroup group) {
		ReactiveRXQueryExecutor<UserRecord, User, UUID> queryExecutor = userDao.queryExecutor();
		Single<List<User>> result = queryExecutor.findMany(dslContext -> dslContext.select()
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
	public Completable testMultiOp() {
		Observable<User> txOperation = userDao.queryExecutor().beginTransaction()
			.flatMapObservable(tx -> {
				Single<List<User>> users1 = tx.findMany(ctx -> {
					ResultQuery<UserRecord> userRecords = ctx.select().from(USER).coerce(USER);
					return userRecords;
				});

				User userPojo = new User();
				userPojo.setUsername("ABCD");
				// Single<User> createdUser1 = tx.executeAny(ctx -> {
				// return ctx
				// .insertInto(USER)
				// .set(ctx.newRecord(USER, userPojo))
				// .returning(USER.getPrimaryKey().getFieldsArray());
				// }).map(rows -> rows.iterator().next())
				// .map(io.vertx.reactivex.sqlclient.Row::getDelegate)
				// .map(keyConverter()::apply).map(pk -> userPojo.setUuid(pk));

				User userPojo2 = new User();
				userPojo2.setUsername("ABCD2");

				Single<User> createdUser1 = GroupOps.createUserOp(tx, userPojo, keyConverter());

				// Single<User> createdUser1 = tx.insertReturning(ctx -> {
				// return ctx
				// .insertInto(USER)
				// .set(ctx.newRecord(USER, userPojo))
				// .returning(USER.getPrimaryKey().getFieldsArray());
				// }, keyConverter()).map(pk -> userPojo.setUuid(pk));

				Single<User> createdUser2 = GroupOps.insertUser(tx, userPojo2, keyConverter());

				Single<List<User>> s = Single.zip(users1, createdUser1, createdUser2, (u1, c1, c2) -> {
					System.out.println("Adding users");
					u1.add(c1);
					u1.add(c2);
					return u1;
				});

				Observable<User> obs = s.flatMapObservable(list -> {
					System.out.println("Convert to list");
					return Observable.fromIterable(list);
				});

				return tx.commit().andThen(obs);
			});

//		.blockingForEach(user -> {
//			System.out.println(user.getUsername());
//		});
		return txOperation.ignoreElements();
	}

	@Override
	public Completable clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
		return Completable.complete();
	}

}
