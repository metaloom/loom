package io.metaloom.loom.db.group;

import static io.metaloom.loom.db.fs.FSWrapperUtil.toFs;

import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.fs.FilesystemIoHelper;
import io.metaloom.loom.db.role.Role;
import io.metaloom.loom.db.user.User;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

@Singleton
public class FsGroupDaoImpl extends AbstractFSDao implements GroupDao {

	@Inject
	public FsGroupDaoImpl(DaoCollection daos) {
		super(daos);
	}

	protected FSType getType() {
		return FSType.GROUP;
	}

	@Override
	public Maybe<? extends Group> loadGroup(UUID uuid) {
		return FilesystemIoHelper.load(getType(), uuid, FsGroupImpl.class);
	}

	@Override
	public void deleteGroup(Group group) {
		Objects.requireNonNull(group, "Group must not be null");
		FilesystemIoHelper.delete(getType(), group.getUuid());
	}

	@Override
	public Single<Group> createGroup(String name) {
		Group group = new FsGroupImpl();
		group.setUuid(UUIDUtil.randomUUID());
		group.setName(name);
		return Single.just(group);
	}

	@Override
	public void updateGroup(Group group) {
		Objects.requireNonNull(group, "Group must not be null");
		FilesystemIoHelper.store(getType(), group.getUuid(), group);
	}

	@Override
	public void storeGroup(Group group) {
		Objects.requireNonNull(group, "Group must not be null");
		FilesystemIoHelper.store(getType(), group.getUuid(), group);
	}

	@Override
	@JsonIgnore
	public Observable<User> loadUsers(Group group) {
		return Observable.fromIterable(toFs(group).users);
	}

	@Override
	public Completable addUser(Group group, User user) {
		return Completable.fromAction(() -> {
			toFs(group).users.add(user);
		});
	}

	@Override
	public Completable removeUser(Group group, User user) {
		return Completable.fromAction(() -> {
			toFs(group).users.remove(user);
		});
	}

	@Override
	public void addRole(Group group, Role role) {
		toFs(group).roles.add(role);
	}

	@Override
	public void removeRole(Group group, Role role) {
		toFs(group).roles.remove(role);
	}
	
	@Override
	public void testMultiOp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	@JsonIgnore
	public Observable<Role> loadRoles(Group group) {
		return Observable.fromIterable(toFs(group).roles);
	}

}
