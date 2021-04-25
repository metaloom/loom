package io.metaloom.loom.db;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import io.metaloom.loom.db.user.User;
import io.metaloom.loom.db.user.UsersDao;
import io.metaloom.loom.uuid.UUIDUtil;

public class MemUersDaoImpl implements UsersDao {

	private Map<UUID, User> storage = new HashMap<>();

	@Override
	public User loadUser(UUID uuid) {
		return storage.get(uuid);
	}

	@Override
	public void deleteUser(User user) {
		if (user != null) {
			storage.remove(user.getUuid());
		}
	}

	@Override
	public User createUser() {
		User user = new MemUserImpl();
		user.setUuid(UUIDUtil.randomUUID());
		storage.put(user.getUuid(), user);
		return user;
	}

	@Override
	public void updateUser(User user) {
		// NOOP since memory mode does not persist
	}

}
