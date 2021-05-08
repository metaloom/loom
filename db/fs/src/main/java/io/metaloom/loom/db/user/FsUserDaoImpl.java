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
import io.metaloom.loom.db.fs.FilesystemIoHelper;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

@Singleton
public class FsUserDaoImpl extends AbstractFSDao implements LoomUserDao {

	@Inject
	public FsUserDaoImpl(DaoCollection daos) {
		super(daos);
	}

	protected FSType getType() {
		return FSType.USER;
	}

	@Override
	public Maybe<? extends LoomUser> loadUser(UUID uuid) {
		return FilesystemIoHelper.load(getType(), uuid, FsUserImpl.class);
	}

	@Override
	public void deleteUser(LoomUser user) {
		Objects.requireNonNull(user, "User must not be null");
		FilesystemIoHelper.delete(getType(), user.getUuid());
	}

	@Override
	public Single<? extends LoomUser> createUser(String username) {
		LoomUser user = new FsUserImpl();
		user.setUuid(UUIDUtil.randomUUID());
		user.setUsername(username);
		return Single.just(user);
	}

	@Override
	public void updateUser(LoomUser user) {
		Objects.requireNonNull(user, "User must not be null");
		FilesystemIoHelper.store(getType(), user.getUuid(), user);
	}

	@Override
	public void storeUser(LoomUser user) {
		Objects.requireNonNull(user, "User must not be null");
		FilesystemIoHelper.store(getType(), user.getUuid(), user);
	}

	@Override
	public Completable clear() throws IOException {
		return Completable.fromAction(() -> {
			FileUtils.deleteDirectory(FilesystemIoHelper.getTypeDir(getType()));
		});
	}

}
