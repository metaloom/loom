package io.metaloom.loom.db.user;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;

public interface UsersDao extends LoomDao {

	User createUser();

	User loadUser(UUID uuid);

	void updateUser(User user);

	void deleteUser(User user);

	void storeUser(User user);
}
