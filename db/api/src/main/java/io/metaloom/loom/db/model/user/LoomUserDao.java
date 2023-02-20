package io.metaloom.loom.db.model.user;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Stream;

import io.metaloom.loom.db.LoomDao;

public interface LoomUserDao extends LoomDao {

	default LoomUser createUser(String username) {
		return createUser(username, null);
	}

	/**
	 * Create and store a new user with the given username.
	 * 
	 * @param username
	 * @param modifier
	 * @return
	 */
	LoomUser createUser(String username, Consumer<LoomUser> modifier);

	/**
	 * Load the user with the given uuid.
	 * 
	 * @param uuid
	 * @return
	 */
	LoomUser loadUser(UUID uuid);

	/**
	 * Update the user using the provided element information.
	 * 
	 * @param user
	 * @return
	 */
	void updateUser(LoomUser user);

	/**
	 * Delete the user.
	 * 
	 * @param user
	 * @return
	 */
	// TODO switch to uuid?
	void deleteUser(LoomUser user);

	/**
	 * Load all users.
	 * 
	 * @return
	 */
	Stream<LoomUser> findAll();

}
