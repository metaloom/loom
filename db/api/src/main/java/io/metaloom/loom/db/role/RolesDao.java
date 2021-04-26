package io.metaloom.loom.db.role;

import java.io.IOException;
import java.util.UUID;

public interface RolesDao {

	Role createRole();

	void deleteRole(Role role);

	void updateRole(Role role);

	Role loadRole(UUID uuid);

	Role storeRole(Role role);
	
	void clear() throws IOException;
}
