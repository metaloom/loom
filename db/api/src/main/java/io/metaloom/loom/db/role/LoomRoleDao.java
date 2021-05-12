package io.metaloom.loom.db.role;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface LoomRoleDao extends LoomDao {

	/**
	 * Create and persist a new role.
	 * 
	 * @param name
	 * @return
	 */
	Single<? extends LoomRole> createRole(String name);

	/**
	 * Load the role with the given uuid.
	 * 
	 * @param uuid
	 * @return
	 */
	Maybe<? extends LoomRole> loadRole(UUID uuid);

	/**
	 * Delete the role with the given uuid.
	 * 
	 * @param uuid
	 * @return
	 */
	Completable deleteRole(UUID uuid);

	Completable updateRole(LoomRole role);

}
