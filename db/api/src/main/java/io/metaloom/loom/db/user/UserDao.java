package io.metaloom.loom.db.user;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface UserDao extends LoomDao {

	Single<? extends User> createUser(String username);

	Maybe<? extends User> loadUser(UUID uuid);

	void updateUser(User user);

	void deleteUser(User user);

	void storeUser(User user);
}
