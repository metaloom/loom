package io.metaloom.loom.db.perm;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import io.metaloom.loom.db.jooq.AbstractJooqTest;
import io.metaloom.loom.db.model.user.LoomUser;

public class PermissionDaoTest extends AbstractJooqTest {

	@Test
	public void testLoadUserPerms() {
		LoomUser user = userDao().loadUserByUsername("admin");
		UUID userUuid = user.getUuid();
		permissionDao().loadPermissionsForUser(userUuid);
	}
}
