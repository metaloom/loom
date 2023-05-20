package io.metaloom.loom.db.model.user;

import java.util.UUID;

import io.metaloom.loom.db.CRUDDao;

public interface UserDao extends CRUDDao<User> {

	/**
	 * Create and store a new user with the given username.
	 * 
	 * @param creatorUuid
	 * @param username
	 * @return
	 */
	User createUser(UUID creatorUuid, String username);

	default User createUser(String username) {
		return createUser(null, username);
	}

	/**
	 * Load the user by username.
	 * 
	 * @param username
	 * @return
	 */
	User loadUserByUsername(String username);

}
