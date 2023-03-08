package io.metaloom.loom.db.user;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;

import io.metaloom.loom.api.uuid.UUIDUtil;
import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.db.model.user.LoomUserDao;

public class MemUsersDaoImpl implements LoomUserDao {

	private Map<UUID, LoomUser> storage = new HashMap<>();

	@Override
	public LoomUser loadUser(UUID uuid) {
		return storage.get(uuid);
	}

	@Override
	public void deleteUser(LoomUser user) {
		if (user != null) {
			storage.remove(user.getUuid());
		}
	}

	@Override
	public LoomUser createUser(String username) {
		LoomUser user = new MemUserImpl();
		user.setUuid(UUIDUtil.randomUUID());
		user.setUsername(username);
		return user;
	}

	@Override
	public void storeUser(LoomUser user) {
		storage.put(user.getUuid(), user);
	}

	@Override
	public void updateUser(LoomUser user) {
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
	public Stream<LoomUser> findAll() {
		return null;
	}

}
