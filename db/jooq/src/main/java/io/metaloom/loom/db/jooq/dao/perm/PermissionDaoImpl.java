package io.metaloom.loom.db.jooq.dao.perm;

import static io.metaloom.loom.db.jooq.tables.JooqRoleGroup.ROLE_GROUP;
import static io.metaloom.loom.db.jooq.tables.JooqRolePermission.ROLE_PERMISSION;
import static io.metaloom.loom.db.jooq.tables.JooqUserPermission.*;
import static io.metaloom.loom.db.jooq.tables.JooqUserGroup.USER_GROUP;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.enums.JooqLoomPermission;
import io.metaloom.loom.db.jooq.tables.daos.JooqRolePermissionDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqTokenPermissionDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqUserPermissionDao;
import io.metaloom.loom.db.jooq.tables.pojos.JooqRolePermission;
import io.metaloom.loom.db.jooq.tables.pojos.JooqTokenPermission;
import io.metaloom.loom.db.model.perm.ResourcePermission;
import io.metaloom.loom.db.model.perm.PermissionDao;

@Singleton
public class PermissionDaoImpl implements PermissionDao {

	private final JooqRolePermissionDao rolePermDao;
	private final JooqTokenPermissionDao tokenPermDao;
	private final JooqUserPermissionDao userPermDao;
	private final DSLContext ctx;

	@Inject
	public PermissionDaoImpl(JooqRolePermissionDao roleDao, JooqTokenPermissionDao tokenDao, JooqUserPermissionDao userDao, DSLContext ctx) {
		this.rolePermDao = roleDao;
		this.tokenPermDao = tokenDao;
		this.userPermDao = userDao;
		this.ctx = ctx;
	}

	@Override
	public List<ResourcePermission> loadPermissionsForUser(UUID userUuid) {
		// Fetch permissions for effective roles which belong to the user
		List<ResourcePermission> rolePerms = ctx.select()
			.from(ROLE_PERMISSION)
			.leftJoin(ROLE_GROUP)
			.on(ROLE_PERMISSION.ROLE_UUID.eq(ROLE_GROUP.ROLE_UUID))
			.leftJoin(USER_GROUP)
			.on(USER_GROUP.GROUP_UUID.eq(ROLE_GROUP.GROUP_UUID))
			.where(USER_GROUP.USER_UUID.eq(userUuid))
			.fetchInto(ResourcePermission.class);

		// Fetch dedicated user permissions
		List<ResourcePermission> userPerms = ctx.select()
			.from(USER_PERMISSION)
			.where(USER_PERMISSION.USER_UUID.eq(userUuid))
			.fetchInto(ResourcePermission.class);

		// Return the combined perms
		rolePerms.addAll(userPerms);
		return rolePerms;

	}

	public void loadPermissionsForToken(UUID tokenUUID) {
		List<JooqTokenPermission> tokenPerms = tokenPermDao.fetchByJooqTokenUuid(tokenUUID);
	}

	@Override
	public void grantRolePermission(UUID roleUuid) {
		JooqRolePermission perm = new JooqRolePermission(roleUuid, "test", JooqLoomPermission.CREATE_ASSET);
		rolePermDao.insert(perm);
	}

}
