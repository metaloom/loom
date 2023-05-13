package io.metaloom.loom.db.model.role;

import java.util.UUID;

import io.metaloom.loom.db.CRUDDao;

public interface RoleDao extends CRUDDao<Role, UUID> {

	default Role createRole(String name) {
		return createRole(name, null);
	}

	/**
	 * Create and persist a new role.
	 * 
	 * @param name
	 * @param creator
	 * @return
	 */
	Role createRole(String name, UUID creator);

}
