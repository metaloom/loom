package io.metaloom.loom.db.role;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface RoleDao extends LoomDao {

	Single<? extends Role> createRole(String name);

	void deleteRole(Role role);

	void updateRole(Role role);

	Maybe<? extends Role> loadRole(UUID uuid);

	void storeRole(Role role);

}
