package io.metaloom.loom.db.perm;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import io.metaloom.loom.db.jooq.AbstractJooqTest;
import io.metaloom.loom.db.model.perm.LoomResourcePermission;
import io.metaloom.loom.db.model.user.LoomUser;

public class PermissionDaoTest extends AbstractJooqTest {

	@Test
	public void testLoadUserPerms() {
		LoomUser user = userDao().loadUserByUsername("admin");
		UUID userUuid = user.getUuid();
		List<LoomResourcePermission> perms = permissionDao().loadPermissionsForUser(userUuid);
		assertNotNull(perms);
		for (LoomResourcePermission perm : perms) {
			System.out.println(perm);
		}
	}
}
