package io.metaloom.loom.db.model.user;

import java.util.UUID;
import java.util.stream.Stream;

import io.metaloom.loom.db.LoomDao;

public interface LoomUserDao extends LoomDao {

	/**
	 * Create and store a new user with the given username.
	 * 
	 * @param username
	 * @return
	 */
	LoomUser createUser(String username);

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
	 * Store the user information.
	 * 
	 * @param creator
	 */
	void storeUser(LoomUser creator);

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
