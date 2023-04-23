package io.metaloom.loom.auth;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.model.perm.PermissionDao;
import io.metaloom.loom.db.model.user.LoomUserDao;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.ext.auth.User;
import io.vertx.ext.auth.authorization.AuthorizationProvider;

@Singleton
public class LoomAuthorizationProvider implements AuthorizationProvider {

	private LoomUserDao userDao;
	private PermissionDao permissionDao;

	@Inject
	public LoomAuthorizationProvider(LoomUserDao userDao, PermissionDao permissionDao) {
		this.userDao = userDao;
		this.permissionDao = permissionDao;
	}

	@Override
	public String getId() {
		return "loom";
	}

	@Override
	public void getAuthorizations(User user, Handler<AsyncResult<Void>> handler) {
		UUID userUuid = UUID.fromString("8ee5e9ac-0953-439c-bef3-fbaaa4108e49"); 
		permissionDao.loadPermissionsForUser(userUuid);

	}

}
