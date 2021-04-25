package io.metaloom.loom.db.user;

import java.util.UUID;

public interface UsersDao {

	User loadUser(UUID uuid);

	void deleteUser(User user);

	User createUser();

	void updateUser(User user);
}
