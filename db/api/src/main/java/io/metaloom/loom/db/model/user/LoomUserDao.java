package io.metaloom.loom.db.model.user;

import java.util.UUID;
import java.util.function.Consumer;

import io.metaloom.loom.db.LoomDao;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public interface LoomUserDao extends LoomDao {

	default Single<? extends LoomUser> createUser(String username) {
		return createUser(username, null);
	}

	/**
	 * Create and store a new user with the given username.
	 * 
	 * @param username
	 * @param modifier
	 * @return
	 */
	Single<? extends LoomUser> createUser(String username, Consumer<LoomUser> modifier);

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
	// TODO switch to uuid?
	Completable deleteUser(LoomUser user);

	/**
	 * Load all users.
	 * 
	 * @return
	 */
	Observable<LoomUser> findAll();

}
