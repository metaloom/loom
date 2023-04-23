package io.metaloom.loom.db.jooq.dao.perm;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import io.metaloom.loom.db.jooq.enums.LoomPermission;
import io.metaloom.loom.db.jooq.tables.RoleGroup;
import io.metaloom.loom.db.jooq.tables.RolePermission;
import io.metaloom.loom.db.jooq.tables.UserGroup;
import io.metaloom.loom.db.jooq.tables.daos.JooqRolePermissionDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqTokenPermissionDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqUserPermissionDao;
import io.metaloom.loom.db.jooq.tables.pojos.JooqRolePermission;
import io.metaloom.loom.db.jooq.tables.pojos.JooqTokenPermission;
import io.metaloom.loom.db.jooq.tables.pojos.JooqUserPermission;
import io.metaloom.loom.db.model.perm.LoomPermissionDao;

@Singleton
public class LoomPermissionDaoImpl implements LoomPermissionDao {

	private final JooqRolePermissionDao rolePermDao;
	private final JooqTokenPermissionDao tokenPermDao;
	private final JooqUserPermissionDao userPermDao;
	private final DSLContext ctx;

	@Inject
	public LoomPermissionDaoImpl(JooqRolePermissionDao roleDao, JooqTokenPermissionDao tokenDao, JooqUserPermissionDao userDao, DSLContext ctx) {
		this.rolePermDao = roleDao;
		this.tokenPermDao = tokenDao;
		this.userPermDao = userDao;
		this.ctx = ctx;
	}

	@Override
	public void loadPermissionsForUser(UUID userUuid) {

		Result<Record> result = ctx.select()
			.from(RolePermission.ROLE_PERMISSION.leftJoin(RoleGroup.ROLE_GROUP)
				.on(RolePermission.ROLE_PERMISSION.ROLE_UUID.eq(RoleGroup.ROLE_GROUP.ROLE_UUID)).leftJoin(UserGroup.USER_GROUP)
				.on(UserGroup.USER_GROUP.GROUP_UUID.eq(RoleGroup.ROLE_GROUP.GROUP_UUID)).where(UserGroup.USER_GROUP.USER_UUID.eq(userUuid)))
			.fetch();

		for (Record r : result) {
			System.out.println(r);
		}

		// System.out.println(result.);
		List<JooqUserPermission> userPerms = userPermDao.fetchByUserUuid(userUuid);

	}

	public void loadPermissionsForToken(UUID tokenUUID) {
		List<JooqTokenPermission> tokenPerms = tokenPermDao.fetchByTokenUuid(tokenUUID);
	}

	@Override
	public void grantRolePermission(UUID roleUuid) {
		JooqRolePermission perm = new JooqRolePermission(roleUuid, "test", LoomPermission.CREATE_ASSET);
		rolePermDao.insert(perm);
	}

}
