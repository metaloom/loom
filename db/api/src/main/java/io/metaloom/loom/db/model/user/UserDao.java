package io.metaloom.loom.db.model.user;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public interface UserDao extends LoomDao {

	/**
	 * Create and store a new user with the given username.
	 * 
	 * @param username
	 * @return
	 */
	Single<? extends LoomUser> createUser(String username);

	/**
	 * Load the user with the given uuid.
	 * 
	 * @param uuid
	 * @return
	 */
	Maybe<? extends LoomUser> loadUser(UUID uuid);

	/**
	 * Update the user using the provided element information.
	 * 
	 * @param user
	 * @return
	 */
	Completable updateUser(LoomUser user);

	/**
	 * Delete the user.
	 * 
	 * @param user
	 * @return
	 */
	Completable deleteUser(LoomUser user);

}
