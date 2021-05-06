package io.metaloom.loom.db.role;

import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.fs.FilesystemIoHelper;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.Maybe;
import io.reactivex.Single;

@Singleton
public class FsRoleDaoImpl extends AbstractFSDao implements RoleDao {

	@Inject
	public FsRoleDaoImpl(DaoCollection daos) {
		super(daos);
	}

	protected FSType getType() {
		return FSType.ROLE;
	}

	@Override
	public Maybe<? extends Role> loadRole(UUID uuid) {
		return FilesystemIoHelper.load(getType(), uuid, FsRoleImpl.class);
	}

	@Override
	public void deleteRole(Role role) {
		Objects.requireNonNull(role, "Role must not be null");
		FilesystemIoHelper.delete(getType(), role.getUuid());
	}

	@Override
	public Single<? extends Role> createRole(String name) {
		return Single.fromCallable(() -> {
			Role role = new FsRoleImpl();
			role.setName(name);
			role.setUuid(UUIDUtil.randomUUID());
			return role;
		});
	}

	@Override
	public void updateRole(Role role) {
		Objects.requireNonNull(role, "Role must not be null");
		FilesystemIoHelper.store(getType(), role.getUuid(), role);
	}

	@Override
	public void storeRole(Role role) {
		Objects.requireNonNull(role, "Role must not be null");
		FilesystemIoHelper.store(getType(), role.getUuid(), role);
	}


}
