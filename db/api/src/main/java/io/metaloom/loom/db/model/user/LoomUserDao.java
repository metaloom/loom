package io.metaloom.loom.db.model.user;

import java.util.UUID;
import java.util.stream.Stream;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.page.Page;

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
	 * Load the user by username.
	 * 
	 * @param username
	 * @return
	 */
	LoomUser loadUserByUsername(String username);

	/**
	 * Load a page of users.
	 * 
	 * @param fromUuid
	 * @param pageSize
	 * @return
	 */
	Page<LoomUser> loadUsers(UUID fromUuid, int pageSize);

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
	 * @param user
	 */
	void storeUser(LoomUser user);

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
