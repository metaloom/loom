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
import io.metaloom.loom.db.role.LoomRole;
import io.metaloom.loom.db.user.LoomUser;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

@Singleton
public class FsGroupDaoImpl extends AbstractFSDao implements LoomGroupDao {

	@Inject
	public FsGroupDaoImpl(DaoCollection daos) {
		super(daos);
	}

	protected FSType getType() {
		return FSType.GROUP;
	}

	@Override
	public Maybe<? extends LoomGroup> loadGroup(UUID uuid) {
		return FilesystemIoHelper.load(getType(), uuid, FsGroupImpl.class);
	}

	@Override
	public void deleteGroup(LoomGroup group) {
		Objects.requireNonNull(group, "Group must not be null");
		FilesystemIoHelper.delete(getType(), group.getUuid());
	}

	@Override
	public Single<LoomGroup> createGroup(String name) {
		LoomGroup group = new FsGroupImpl();
		group.setUuid(UUIDUtil.randomUUID());
		group.setName(name);
		return Single.just(group);
	}

	@Override
	public void updateGroup(LoomGroup group) {
		Objects.requireNonNull(group, "Group must not be null");
		FilesystemIoHelper.store(getType(), group.getUuid(), group);
	}

	@Override
	public void storeGroup(LoomGroup group) {
		Objects.requireNonNull(group, "Group must not be null");
		FilesystemIoHelper.store(getType(), group.getUuid(), group);
	}

	@Override
	@JsonIgnore
	public Observable<LoomUser> loadUsers(LoomGroup group) {
		return Observable.fromIterable(toFs(group).users);
	}

	@Override
	public Completable addUser(LoomGroup group, LoomUser user) {
		return Completable.fromAction(() -> {
			toFs(group).users.add(user);
		});
	}

	@Override
	public Completable removeUser(LoomGroup group, LoomUser user) {
		return Completable.fromAction(() -> {
			toFs(group).users.remove(user);
		});
	}

	@Override
	public void addRole(LoomGroup group, LoomRole role) {
		toFs(group).roles.add(role);
	}

	@Override
	public void removeRole(LoomGroup group, LoomRole role) {
		toFs(group).roles.remove(role);
	}
	
	@Override
	public void testMultiOp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	@JsonIgnore
	public Observable<LoomRole> loadRoles(LoomGroup group) {
		return Observable.fromIterable(toFs(group).roles);
	}

}
