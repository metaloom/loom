package io.metaloom.loom.db.model.perm;

import java.util.List;
import java.util.UUID;

public interface PermissionDao {

	void grantRolePermission(UUID roleUuid);

	List<ResourcePermission> loadPermissionsForUser(UUID userUuid);

}
