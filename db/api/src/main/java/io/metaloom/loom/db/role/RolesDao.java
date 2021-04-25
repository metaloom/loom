package io.metaloom.loom.db.role;

import java.util.UUID;

public interface RolesDao {

	Role createRole();

	void deleteRole(Role role);

	void updateRole(Role role);

	Role loadRole(UUID uuid);
}
