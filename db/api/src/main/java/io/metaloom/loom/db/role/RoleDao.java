package io.metaloom.loom.db.role;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.reactivex.Maybe;

public interface RoleDao extends LoomDao {

	Role createRole();

	void deleteRole(Role role);

	void updateRole(Role role);

	Maybe<? extends Role> loadRole(UUID uuid);

	void storeRole(Role role);

}
