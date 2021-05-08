package io.metaloom.loom.db.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import io.metaloom.loom.utils.RxUtils;
import io.metaloom.loom.uuid.UUIDUtil;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class MemUsersDaoImpl implements LoomUserDao {

	private Map<UUID, LoomUser> storage = new HashMap<>();

	@Override
	public Maybe<LoomUser> loadUser(UUID uuid) {
		return RxUtils.ofNullable(storage.get(uuid));
	}

	@Override
	public Completable deleteUser(LoomUser user) {
		if (user != null) {
			storage.remove(user.getUuid());
		}
		return Completable.complete();
	}

	@Override
	public Single<? extends LoomUser> createUser(String username) {
		return Single.fromCallable(() -> {
			LoomUser user = new MemUserImpl();
			user.setUuid(UUIDUtil.randomUUID());
			user.setUsername(username);
			return user;
		});
	}

	@Override
	public Completable updateUser(LoomUser user) {
		storage.put(user.getUuid(), user);
		return Completable.complete();
	}

	@Override
	public Completable clear() throws IOException {
		return Completable.fromAction(() -> {
			storage.clear();
		});
	}

}
