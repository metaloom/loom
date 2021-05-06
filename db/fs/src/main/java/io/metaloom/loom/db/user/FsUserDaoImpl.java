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
import io.reactivex.Maybe;
import io.reactivex.Single;

@Singleton
public class FsUserDaoImpl extends AbstractFSDao implements UserDao {

	@Inject
	public FsUserDaoImpl(DaoCollection daos) {
		super(daos);
	}

	protected FSType getType() {
		return FSType.USER;
	}

	@Override
	public Maybe<? extends User> loadUser(UUID uuid) {
		return FilesystemIoHelper.load(getType(), uuid, FsUserImpl.class);
	}

	@Override
	public void deleteUser(User user) {
		Objects.requireNonNull(user, "User must not be null");
		FilesystemIoHelper.delete(getType(), user.getUuid());
	}

	@Override
	public Single<? extends User> createUser(String username) {
		User user = new FsUserImpl();
		user.setUuid(UUIDUtil.randomUUID());
		user.setUsername(username);
		return Single.just(user);
	}

	@Override
	public void updateUser(User user) {
		Objects.requireNonNull(user, "User must not be null");
		FilesystemIoHelper.store(getType(), user.getUuid(), user);
	}

	@Override
	public void storeUser(User user) {
		Objects.requireNonNull(user, "User must not be null");
		FilesystemIoHelper.store(getType(), user.getUuid(), user);
	}

	@Override
	public void clear() throws IOException {
		FileUtils.deleteDirectory(FilesystemIoHelper.getTypeDir(getType()));
	}

}
