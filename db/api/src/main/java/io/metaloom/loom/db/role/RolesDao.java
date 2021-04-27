package io.metaloom.loom.db.role;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;

public interface RolesDao extends LoomDao {

	Role createRole();

	void deleteRole(Role role);

	void updateRole(Role role);

	Role loadRole(UUID uuid);

	void storeRole(Role role);

}
