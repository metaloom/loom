package io.metaloom.loom.db.model.role;

import java.util.UUID;
import java.util.function.Consumer;

import io.metaloom.loom.db.LoomDao;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public interface RoleDao extends LoomDao {

	default Single<? extends Role> createRole(String name) {
		return createRole(name, null);
	}

	/**
	 * Create and persist a new role.
	 * 
	 * @param name
	 * @param modifier
	 * @return
	 */
	Single<? extends Role> createRole(String name, Consumer<Role> modifier);

	/**
	 * Load the role with the given uuid.
	 * 
	 * @param uuid
	 * @return
	 */
	Maybe<? extends Role> loadRole(UUID uuid);

	/**
	 * Delete the role with the given uuid.
	 * 
	 * @param uuid
	 * @return
	 */
	Completable deleteRole(UUID uuid);

	/**
	 * Update the role.
	 * 
	 * @param role
	 * @return
	 */
	Completable updateRole(Role role);

}
