package io.metaloom.loom.db.model.user;

import io.metaloom.loom.db.CRUDDao;

public interface UserDao extends CRUDDao<User> {

	/**
	 * Create and store a new user with the given username.
	 * 
	 * @param username
	 * @return
	 */
	User createUser(String username);

	/**
	 * Load the user by username.
	 * 
	 * @param username
	 * @return
	 */
	User loadUserByUsername(String username);

}
