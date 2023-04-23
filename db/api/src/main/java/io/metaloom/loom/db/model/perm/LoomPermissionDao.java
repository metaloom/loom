package io.metaloom.loom.db.model.perm;

import java.util.UUID;

public interface LoomPermissionDao {

	void grantRolePermission(UUID roleUuid);

	void loadPermissionsForUser(UUID userUuid);

}
