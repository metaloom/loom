package io.metaloom.loom.db.user;

import java.io.IOException;
import java.util.UUID;

public interface UsersDao {

	User createUser();

	User loadUser(UUID uuid);

	void updateUser(User user);

	void deleteUser(User user);

	void storeUser(User user);

	void clear() throws IOException;
}
