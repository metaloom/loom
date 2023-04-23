package io.metaloom.loom.db.model.role;

import java.util.UUID;

import io.metaloom.loom.db.Dao;

public interface RoleDao extends Dao {

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

	/**
	 * Load the role with the given uuid.
	 * 
	 * @param uuid
	 * @return
	 */
	Role loadRole(UUID uuid);

	/**
	 * Delete the role with the given uuid.
	 * 
	 * @param uuid
	 * @return
	 */
	void deleteRole(UUID uuid);

	/**
	 * Update the role.
	 * 
	 * @param role
	 * @return
	 */
	void updateRole(Role role);

	void storeRole(Role role);

}
