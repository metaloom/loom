package io.metaloom.loom.db.perm;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import io.metaloom.loom.db.jooq.AbstractJooqTest;
import io.metaloom.loom.db.model.perm.ResourcePermission;
import io.metaloom.loom.db.model.user.User;

public class PermissionDaoTest extends AbstractJooqTest {

	@Test
	public void testLoadUserPerms() {
		User user = userDao().loadUserByUsername("admin");
		UUID userUuid = user.getUuid();
		List<ResourcePermission> perms = permissionDao().loadPermissionsForUser(userUuid);
		assertNotNull(perms);
		for (ResourcePermission perm : perms) {
			System.out.println(perm);
		}
	}
}
