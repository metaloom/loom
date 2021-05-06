package io.metaloom.loom.db.user;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import io.metaloom.loom.utils.RxUtils;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class MemUsersDaoImpl implements UserDao {

	private Map<UUID, User> storage = new HashMap<>();

	@Override
	public Maybe<User> loadUser(UUID uuid) {
		return RxUtils.ofNullable(storage.get(uuid));
	}

	@Override
	public void deleteUser(User user) {
		if (user != null) {
			storage.remove(user.getUuid());
		}
	}

	@Override
	public Single<? extends User> createUser(String username) {
		User user = new MemUserImpl();
		user.setUuid(UUIDUtil.randomUUID());
		user.setUsername(username);
		return Single.just(user);
	}

	@Override
	public void updateUser(User user) {
		storage.put(user.getUuid(), user);
	}

	@Override
	public void storeUser(User user) {
		storage.put(user.getUuid(), user);
	}

	@Override
	public void clear() {
		storage.clear();
	}

}
