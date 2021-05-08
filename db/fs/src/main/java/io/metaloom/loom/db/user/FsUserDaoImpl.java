package io.metaloom.loom.db.user;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.commons.io.FileUtils;

import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.vertx.reactivex.core.Vertx;

@Singleton
public class FsUserDaoImpl extends AbstractFSDao implements LoomUserDao {

	@Inject
	public FsUserDaoImpl(DaoCollection daos, Vertx rxVertx) {
		super(daos, rxVertx);
	}

	protected FSType getType() {
		return FSType.USER;
	}

	@Override
	public Maybe<? extends LoomUser> loadUser(UUID uuid) {
		return load(uuid, FsUserImpl.class);
	}

	@Override
	public Completable deleteUser(LoomUser user) {
		Objects.requireNonNull(user, "User must not be null");
		return delete(user.getUuid());
	}

	@Override
	public Single<? extends LoomUser> createUser(String username) {
		LoomUser user = new FsUserImpl();
		user.setUuid(UUIDUtil.randomUUID());
		user.setUsername(username);
		return Single.just(user);
	}

	@Override
	public Completable updateUser(LoomUser user) {
		Objects.requireNonNull(user, "User must not be null");
		return store(user).ignoreElement();
	}


	@Override
	public Completable clear() throws IOException {
		return Completable.fromAction(() -> {
			FileUtils.deleteDirectory(getTypeDir(getType()));
		});
	}

}
