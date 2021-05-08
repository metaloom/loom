package io.metaloom.loom.db.user;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface LoomUserDao extends LoomDao {

	Single<? extends LoomUser> createUser(String username);

	Maybe<? extends LoomUser> loadUser(UUID uuid);

	void updateUser(LoomUser user);

	void deleteUser(LoomUser user);

	void storeUser(LoomUser user);
}
