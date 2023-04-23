package io.metaloom.loom.db.jooq.dao.group;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqGroupDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqRoleGroupDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqUserGroupDao;
import io.metaloom.loom.db.jooq.tables.pojos.JooqGroup;
import io.metaloom.loom.db.jooq.tables.pojos.JooqRoleGroup;
import io.metaloom.loom.db.jooq.tables.pojos.JooqUserGroup;
import io.metaloom.loom.db.model.group.Group;
import io.metaloom.loom.db.model.group.GroupDao;
import io.metaloom.loom.db.model.role.Role;
import io.metaloom.loom.db.model.user.User;
import io.reactivex.rxjava3.core.Completable;

@Singleton
public class GroupDaoImpl extends AbstractJooqDao<JooqGroupDao> implements GroupDao {

	private final JooqUserGroupDao userGroupDao;
	private final JooqRoleGroupDao roleGroupDao;

	@Inject
	public GroupDaoImpl(JooqGroupDao groupDao,
		JooqUserGroupDao userGroupDao,
		JooqRoleGroupDao roleGroupDao,
		DSLContext context) {
		super(groupDao, context);
		this.userGroupDao = userGroupDao;
		this.roleGroupDao = roleGroupDao;
	}

	// @Override
	// public Single<? extends LoomGroup> createGroup(String name, Consumer<LoomGroup> modifier) {
	// Single<? extends Group> result = Single.create(sub -> {
	// try {
	// Group g = new Group();
	// g.setUuid(UUID.randomUUID());
	// g.setName("dummy");
	// groupDao.insert(g);
	// sub.onSuccess(new LoomGroupImpl(g));
	// } catch (Throwable e) {
	// sub.onError(e);
	// }
	// });
	// return result.subscribeOn(scheduler);
	// }

	@Override
	public Group loadGroup(UUID uuid) {
		return wrap(dao().findById(uuid));
	}

	// @Override
	// public Maybe<? extends Group> loadGroup(UUID uuid) {
	// return Maybe.create(sub -> {
	// List<Group> res = ctx.select(
	// GROUP.NAME,
	// GROUP.UUID,
	// multiset(
	// select(
	// USER_GROUP.user().UUID,
	// USER_GROUP.user().USERNAME)
	// .from(USER_GROUP)
	// .where(USER_GROUP.GROUP_UUID.eq(GROUP.UUID)))
	// // .convertFrom(r -> r.map(mapping(LoomUserPojoImpl::new)))
	// .convertFrom(r -> r.into(LoomUserPojoImpl.class))
	// .as("users"))
	// .from(GROUP)
	// .fetchInto(LoomGroupPojoImpl.class);
	// System.out.println("-----------");
	// for (Group g : res) {
	// System.out.println(g.getClass().getName());
	// System.out.println(g.getUuid());
	// System.out.println(g.getName());
	//
	// for (LoomUser u : g.getUsers()) {
	// System.out.println(u.getClass().getName());
	// System.out.println("Users: " + u.toString());
	// }
	// }
	// System.out.println("-----------");
	// sub.onComplete();
	// });
	// }

	// @Override
	// public Completable addUserToGroup(Group group, LoomUser user) {
	// Completable result = Completable.create(sub -> {
	// try {
	// Objects.requireNonNull(group);
	// Objects.requireNonNull(user);
	// UserGroup ug = new UserGroup();
	// ug.setUserUuid(user.getUuid());
	// ug.setGroupUuid(group.getUuid());
	// userGroupDao.insert(ug);
	// sub.onComplete();
	// } catch (Throwable t) {
	// sub.onError(t);
	// }
	// });
	// return result.subscribeOn(scheduler);
	// }

	// @Override
	// public Completable deleteGroup(UUID uuid) {
	// Objects.requireNonNull(uuid, "Group uuid must not be null");
	// return dao.deleteById(uuid).ignoreElement();
	// }
	//
	// @Override
	// public Single<LoomGroup> createGroup(String name) {
	// LoomGroup group = new LoomGroup();
	// group.setName(name);
	// return insertReturningPrimary(group).map(pk -> new LoomGroup2Impl(group.setUuid(pk)));
	// }
	//
	// @Override
	// public Single<? extends LoomGroup> updateGroup(LoomGroup group) {
	// Objects.requireNonNull(group, "Group must not be null");
	// return update(unwrap(group));
	// }
	//
	// @Override
	// public Completable addUserToGroup(LoomGroup group, LoomUser user) {
	// UserGroup userGroup = new UserGroup();
	// userGroup.setGroupUuid(group.getUuid());
	// userGroup.setUserUuid(user.getUuid());
	// return userGroupDao.insert(userGroup).ignoreElement();
	// }
	//
	// @Override
	// public Completable removeUserFromGroup(LoomGroup group, LoomUser user) {
	// UserGroupRecord record = new UserGroupRecord(user.getUuid(), group.getUuid());
	// return userGroupDao.deleteById(record).ignoreElement();
	// }

	@Override
	public void removeRoleFromGroup(Group group, Role role) {
	}

	@Override
	public void addRoleToGroup(Group group, Role role) {
		roleGroupDao.insert(new JooqRoleGroup(group.getUuid(), role.getUuid()));
	}

	@Override
	public Role loadRoles(Group group) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group createGroup(String name, Consumer<Group> modifier) {
		JooqGroup group = new JooqGroup();
		group.setName(name);
		return new GroupImpl(group);
	}

	@Override
	public void storeGroup(Group group) {
		JooqGroup jooq = unwrap(group);
		dao().insert(jooq);
	}

	@Override
	public Completable deleteGroup(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group updateGroup(Group group) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUserToGroup(Group group, User user) {
		userGroupDao.insert(new JooqUserGroup(user.getUuid(), group.getUuid()));
	}

	@Override
	public void removeUserFromGroup(Group group, User user) {
	}

	@Override
	public User loadUsers(Group group) {
		return null;
	}

	@Override
	public void testMultiOp() {
	}

	@Override
	public Stream<Group> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	// @Override
	// public Observable<LoomUser> loadUsers(LoomGroup group) {
	// Single<List<User>> result = queryExecutor.findMany(dslContext -> dslContext.select()
	// .from(USER_GROUP
	// .join(USER)
	// .on(USER.UUID.eq(USER_GROUP.USER_UUID))
	// .where(USER_GROUP.GROUP_UUID.eq(group.getUuid())).asTable(USER))
	// .coerce(USER));
	//
	// return result.flatMapObservable(list -> {
	// return Observable.fromIterable(list);
	// }).map(jooq -> {
	// return JooqWrapperHelper.wrap(jooq, JooqUserImpl.class);
	// });
	// }
	//
	// @Override
	// public Completable testMultiOp() {
	// Observable<User> txOperation = userDao.queryExecutor().beginTransaction()
	// .flatMapObservable(tx -> {
	// Single<List<User>> users1 = tx.findMany(ctx -> {
	// ResultQuery<UserRecord> userRecords = ctx.select().from(USER).coerce(USER);
	// return userRecords;
	// });
	//
	// User userPojo = new User();
	// userPojo.setUsername("ABCD");
	// // Single<User> createdUser1 = tx.executeAny(ctx -> {
	// // return ctx
	// // .insertInto(USER)
	// // .set(ctx.newRecord(USER, userPojo))
	// // .returning(USER.getPrimaryKey().getFieldsArray());
	// // }).map(rows -> rows.iterator().next())
	// // .map(io.vertx.reactivex.sqlclient.Row::getDelegate)
	// // .map(keyConverter()::apply).map(pk -> userPojo.setUuid(pk));
	//
	// User userPojo2 = new User();
	// userPojo2.setUsername("ABCD2");
	//
	// Single<User> createdUser1 = GroupOps.createUserOp(tx, userPojo, keyConverter());
	//
	// // Single<User> createdUser1 = tx.insertReturning(ctx -> {
	// // return ctx
	// // .insertInto(USER)
	// // .set(ctx.newRecord(USER, userPojo))
	// // .returning(USER.getPrimaryKey().getFieldsArray());
	// // }, keyConverter()).map(pk -> userPojo.setUuid(pk));
	//
	// Single<User> createdUser2 = GroupOps.insertUser(tx, userPojo2, keyConverter());
	//
	// Single<List<User>> s = Single.zip(users1, createdUser1, createdUser2, (u1, c1, c2) -> {
	// System.out.println("Adding users");
	// u1.add(c1);
	// u1.add(c2);
	// return u1;
	// });
	//
	// Observable<User> obs = s.flatMapObservable(list -> {
	// System.out.println("Convert to list");
	// return Observable.fromIterable(list);
	// });
	//
	// return tx.commit().andThen(obs);
	// });
	//
	// // .blockingForEach(user -> {
	// // System.out.println(user.getUsername());
	// // });
	// return txOperation.ignoreElements();
	// }
	//
	// @Override
	// public Observable<? extends LoomGroup> findAll() {
	// Observable<? extends Group> result = Single.just(groupDao.findAll()).flatMapObservable(Observable::fromIterable).map(LoomGroupImpl::new);
	// return result.observeOn(scheduler);
	// }
}
