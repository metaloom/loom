package io.metaloom.loom.db.model.role;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;

public interface LoomRoleDao extends LoomDao {

	default LoomRole createRole(String name) {
		return createRole(name, null);
	}

	/**
	 * Create and persist a new role.
	 * 
	 * @param name
	 * @param creator
	 * @return
	 */
	LoomRole createRole(String name, UUID creator);

	/**
	 * Load the role with the given uuid.
	 * 
	 * @param uuid
	 * @return
	 */
	LoomRole loadRole(UUID uuid);

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
	void updateRole(LoomRole role);

	void storeRole(LoomRole role);

}
