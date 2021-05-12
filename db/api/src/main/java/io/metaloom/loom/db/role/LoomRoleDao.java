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

	Completable deleteRole(LoomRole role);

	Completable updateRole(LoomRole role);

	Maybe<? extends LoomRole> loadRole(UUID uuid);

}
