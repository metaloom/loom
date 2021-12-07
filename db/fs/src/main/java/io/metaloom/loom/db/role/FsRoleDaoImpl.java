package io.metaloom.loom.db.role;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.LoomDaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.model.role.Role;
import io.metaloom.loom.db.model.role.RoleDao;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import io.vertx.rxjava3.core.file.FileSystem;

@Singleton
public class FsRoleDaoImpl extends AbstractFSDao implements RoleDao {

	@Inject
	public FsRoleDaoImpl(LoomDaoCollection daos, FileSystem rxFilesystem) {
		super(daos, rxFilesystem);
	}

	protected FSType getType() {
		return FSType.ROLE;
	}

	@Override
	public Maybe<? extends Role> loadRole(UUID uuid) {
		return load(uuid, FsRoleImpl.class);
	}

	@Override
	public Completable deleteRole(UUID uuid) {
		Objects.requireNonNull(uuid, "Role uuid must not be null");
		return delete(uuid);
	}

	@Override
	public Single<? extends Role> createRole(String name, Consumer<Role> modifier) {
		Role role = new FsRoleImpl();
		role.setName(name);
		role.setUuid(UUIDUtil.randomUUID());
		if (modifier != null) {
			modifier.accept(role);
		}
		return store(role);
	}

	@Override
	public Completable updateRole(Role role) {
		Objects.requireNonNull(role, "Role must not be null");
		return store(role).ignoreElement();
	}

}
