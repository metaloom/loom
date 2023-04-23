package io.metaloom.loom.db.model.user;

import java.util.UUID;
import java.util.stream.Stream;

import io.metaloom.loom.db.Dao;
import io.metaloom.loom.db.page.Page;

public interface UserDao extends Dao {

	/**
	 * Create and store a new user with the given username.
	 * 
	 * @param username
	 * @return
	 */
	User createUser(String username);

	/**
	 * Load the user with the given uuid.
	 * 
	 * @param uuid
	 * @return
	 */
	User loadUser(UUID uuid);

	/**
	 * Load the user by username.
	 * 
	 * @param username
	 * @return
	 */
	User loadUserByUsername(String username);

	/**
	 * Load a page of users.
	 * 
	 * @param fromUuid
	 * @param pageSize
	 * @return
	 */
	Page<User> loadUsers(UUID fromUuid, int pageSize);

	/**
	 * Update the user using the provided element information.
	 * 
	 * @param user
	 * @return
	 */
	void updateUser(User user);

	/**
	 * Store the user information.
	 * 
	 * @param user
	 */
	void storeUser(User user);

	/**
	 * Delete the user.
	 * 
	 * @param user
	 * @return
	 */
	// TODO switch to uuid?
	void deleteUser(User user);

	/**
	 * Load all users.
	 * 
	 * @return
	 */
	Stream<User> findAll();

}
