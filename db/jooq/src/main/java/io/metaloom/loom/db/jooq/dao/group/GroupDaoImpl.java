package io.metaloom.loom.db.jooq.dao.group;

import static io.metaloom.loom.db.jooq.tables.Group.GROUP;
import static io.metaloom.loom.db.jooq.tables.UserGroup.USER_GROUP;
import static org.jooq.impl.DSL.multiset;
import static org.jooq.impl.DSL.select;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractDao;
import io.metaloom.loom.db.jooq.dao.user.LoomUserPojoImpl;
import io.metaloom.loom.db.jooq.tables.daos.UserGroupDao;
import io.metaloom.loom.db.jooq.tables.pojos.UserGroup;
import io.metaloom.loom.db.model.group.Group;
import io.metaloom.loom.db.model.group.GroupDao;
import io.metaloom.loom.db.model.role.Role;
import io.metaloom.loom.db.model.user.LoomUser;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;

@Singleton
public class GroupDaoImpl extends AbstractDao implements GroupDao {

	private io.metaloom.loom.db.jooq.tables.daos.GroupDao groupDao;
	private UserGroupDao userGroupDao;
	private DSLContext ctx;
	private Scheduler scheduler;

	@Inject
	public GroupDaoImpl(io.metaloom.loom.db.jooq.tables.daos.GroupDao groupDao,
		UserGroupDao userGroupDao,
		DSLContext context, @Named("jooq") Scheduler scheduler) {
		this.groupDao = groupDao;
		this.userGroupDao = userGroupDao;
		this.ctx = context;
		this.scheduler = scheduler;
	}

	@Override
	public Completable clear() throws IOException {
		return Completable.create(sub -> {
			ctx.deleteFrom(GROUP).execute();
			sub.onComplete();
		}).subscribeOn(scheduler);
	}

	@Override
	public Single<? extends Group> createGroup(String name, Consumer<Group> modifier) {
		Single<? extends Group> result = Single.create(sub -> {
			try {
				io.metaloom.loom.db.jooq.tables.pojos.Group g = new io.metaloom.loom.db.jooq.tables.pojos.Group();
				g.setUuid(UUID.randomUUID());
				g.setName("dummy");
				groupDao.insert(g);
				sub.onSuccess(new GroupImpl(g));
			} catch (Throwable e) {
				sub.onError(e);
			}
		});
		return result.subscribeOn(scheduler);
	}

	@Override
	public Completable deleteGroup(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Single<? extends Group> updateGroup(Group group) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Maybe<? extends Group> loadGroup(UUID uuid) {
		return Maybe.create(sub -> {
			List<Group> res = ctx.select(
				GROUP.NAME,
				GROUP.UUID,
				multiset(
					select(
						USER_GROUP.user().UUID,
						USER_GROUP.user().USERNAME)
							.from(USER_GROUP)
							.where(USER_GROUP.GROUP_UUID.eq(GROUP.UUID)))
				//.convertFrom(r -> r.map(mapping(LoomUserPojoImpl::new)))
				.convertFrom(r -> r.into(LoomUserPojoImpl.class))
				.as("users"))
				.from(GROUP)
				.fetchInto(GroupPojoImpl.class);
			System.out.println("-----------");
			for (Group g : res) {
				System.out.println(g.getClass().getName());
				System.out.println(g.getUuid());
				System.out.println(g.getName());

				for (LoomUser u : g.getUsers()) {
					System.out.println(u.getClass().getName());
					System.out.println("Users: " + u.toString());
				}
			}
			System.out.println("-----------");
			sub.onComplete();
		});
	}

	@Override
	public Completable addUserToGroup(Group group, LoomUser user) {
		Completable result = Completable.create(sub -> {
			try {
				Objects.requireNonNull(group);
				Objects.requireNonNull(user);
				UserGroup ug = new UserGroup();
				ug.setUserUuid(user.getUuid());
				ug.setGroupUuid(group.getUuid());
				userGroupDao.insert(ug);
				sub.onComplete();
			} catch (Throwable t) {
				sub.onError(t);
			}
		});
		return result.subscribeOn(scheduler);
	}

	@Override
	public Completable removeUserFromGroup(Group group, LoomUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<LoomUser> loadUsers(Group group) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable addRoleToGroup(Group group, Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable removeRoleFromGroup(Group group, Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<Role> loadRoles(Group group) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable testMultiOp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<? extends Group> findAll() {
		Observable<? extends Group> result = Single.just(groupDao.findAll()).flatMapObservable(Observable::fromIterable).map(GroupImpl::new);
		return result.observeOn(scheduler);
	}
}
