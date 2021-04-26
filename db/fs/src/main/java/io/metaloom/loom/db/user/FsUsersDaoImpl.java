package io.metaloom.loom.db.user;

import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.fs.AbstractFSDao;
import io.metaloom.loom.db.fs.FSType;
import io.metaloom.loom.db.fs.FilesystemIoHelper;
import io.metaloom.loom.uuid.UUIDUtil;

public class FsUsersDaoImpl extends AbstractFSDao implements UsersDao {

	protected FSType getType() {
		return FSType.USER;
	}

	@Override
	public User loadUser(UUID uuid) {
		return FilesystemIoHelper.load(getType(), uuid, FsUserImpl.class);
	}

	@Override
	public void deleteUser(User user) {
		Objects.requireNonNull(user, "User must not be null");
		FilesystemIoHelper.delete(getType(), user.getUuid());
	}

	@Override
	public User createUser() {
		User user = new FsUserImpl();
		user.setUuid(UUIDUtil.randomUUID());
		return user;
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

}
