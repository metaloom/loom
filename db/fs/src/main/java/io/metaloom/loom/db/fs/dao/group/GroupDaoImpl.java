package io.metaloom.loom.db.fs.dao.group;

import static io.metaloom.loom.db.fs.FSWrapperUtil.toFs;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.metaloom.loom.db.LoomDaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.model.group.Group;
import io.metaloom.loom.db.model.group.GroupDao;
import io.metaloom.loom.db.model.role.Role;
import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.vertx.rxjava3.core.file.FileSystem;

@Singleton
public class GroupDaoImpl extends AbstractFSDao implements GroupDao {

	@Inject
	public GroupDaoImpl(LoomDaoCollection daos, FileSystem rxFilesystem) {
		super(daos, rxFilesystem);
	}

	protected FSType getType() {
		return FSType.GROUP;
	}

	@Override
	public Maybe<? extends Group> loadGroup(UUID uuid) {
		return load(uuid, GroupImpl.class);
	}

	@Override
	public Completable deleteGroup(UUID uuid) {
		Objects.requireNonNull(uuid, "Group uuid must not be null");
		return delete(uuid);
	}

	@Override
	public Single<Group> createGroup(String name, Consumer<Group> modifier) {
		return Single.defer(() -> {
			Group group = new GroupImpl();
			group.setUuid(UUIDUtil.randomUUID());
			group.setName(name);
			if (modifier != null) {
				modifier.accept(group);
			}
			return Single.just(group);
		});
	}

	@Override
	public Single<? extends Group> updateGroup(Group group) {
		return store(group);
	}

	@Override
	@JsonIgnore
	public Observable<LoomUser> loadUsers(Group group) {
		return Observable.fromIterable(toFs(group).users);
	}

	@Override
	public Completable addUserToGroup(Group group, LoomUser user) {
		return Completable.fromAction(() -> {
			toFs(group).users.add(user);
		});
	}

	@Override
	public Completable removeUserFromGroup(Group group, LoomUser user) {
		return Completable.fromAction(() -> {
			toFs(group).users.remove(user);
		});
	}

	@Override
	public Completable addRoleToGroup(Group group, Role role) {
		toFs(group).roles.add(role);
		return Completable.complete();
	}

	@Override
	public Completable removeRoleFromGroup(Group group, Role role) {
		toFs(group).roles.remove(role);
		return Completable.complete();
	}

	@Override
	public Completable testMultiOp() {
		// TODO Auto-generated method stub
		return Completable.complete();
	}

	@Override
	@JsonIgnore
	public Observable<Role> loadRoles(Group group) {
		return Observable.fromIterable(toFs(group).roles);
	}

	@Override
	public Observable<? extends Group> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
