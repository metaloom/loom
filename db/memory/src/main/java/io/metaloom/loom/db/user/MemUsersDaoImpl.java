package io.metaloom.loom.db.user;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;

import io.metaloom.loom.api.uuid.UUIDUtil;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.db.model.user.UserDao;
import io.metaloom.loom.db.page.Page;

public class MemUsersDaoImpl implements UserDao {

	private Map<UUID, User> storage = new HashMap<>();

	@Override
	public User loadUser(UUID uuid) {
		return storage.get(uuid);
	}

	@Override
	public User loadUserByUsername(String username) {
		return storage.values().stream().filter(u -> u.getUsername().equals(username)).findFirst().get();
	}

	@Override
	public void deleteUser(User user) {
		if (user != null) {
			storage.remove(user.getUuid());
		}
	}

	@Override
	public User createUser(String username) {
		User user = new MemUserImpl();
		user.setUuid(UUIDUtil.randomUUID());
		user.setUsername(username);
		return user;
	}

	@Override
	public void storeUser(User user) {
		storage.put(user.getUuid(), user);
	}

	@Override
	public void updateUser(User user) {
		storage.put(user.getUuid(), user);
	}

	@Override
	public void clear() {
		storage.clear();
	}

	@Override
	public long count() {
		return storage.size();
	}

	@Override
	public Stream<User> findAll() {
		return null;
	}

	@Override
	public Page<User> loadUsers(UUID fromUuid, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
