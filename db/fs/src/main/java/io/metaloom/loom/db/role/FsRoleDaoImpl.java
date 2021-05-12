package io.metaloom.loom.db.role;

import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.LoomDaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.vertx.reactivex.core.Vertx;

@Singleton
public class FsRoleDaoImpl extends AbstractFSDao implements LoomRoleDao {

	@Inject
	public FsRoleDaoImpl(LoomDaoCollection daos, Vertx rxVertx) {
		super(daos, rxVertx);
	}

	protected FSType getType() {
		return FSType.ROLE;
	}

	@Override
	public Maybe<? extends LoomRole> loadRole(UUID uuid) {
		return load(uuid, FsRoleImpl.class);
	}

	@Override
	public Completable deleteRole(UUID uuid) {
		Objects.requireNonNull(uuid, "Role uuid must not be null");
		return delete(uuid);
	}

	@Override
	public Single<? extends LoomRole> createRole(String name) {
		LoomRole role = new FsRoleImpl();
		role.setName(name);
		role.setUuid(UUIDUtil.randomUUID());
		return store(role);
	}

	@Override
	public Completable updateRole(LoomRole role) {
		Objects.requireNonNull(role, "Role must not be null");
		return store(role).ignoreElement();
	}

}
