package io.metaloom.loom.db.role;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface LoomRoleDao extends LoomDao {

	Single<? extends LoomRole> createRole(String name);

	void deleteRole(LoomRole role);

	void updateRole(LoomRole role);

	Maybe<? extends LoomRole> loadRole(UUID uuid);

	void storeRole(LoomRole role);

}
