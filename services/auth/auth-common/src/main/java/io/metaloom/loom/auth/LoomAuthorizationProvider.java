package io.metaloom.loom.auth;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.model.perm.PermissionDao;
import io.metaloom.loom.db.model.perm.ResourcePermission;
import io.metaloom.loom.db.model.perm.ResourcePermissionSet;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.ext.auth.User;
import io.vertx.ext.auth.authorization.Authorization;
import io.vertx.ext.auth.authorization.AuthorizationProvider;
import io.vertx.ext.auth.authorization.PermissionBasedAuthorization;

/**
 * Implementation of an authorization provider which is able to load persisted permissions.
 */
@Singleton
public class LoomAuthorizationProvider implements AuthorizationProvider {

	private static final String USER_UUID_CLAIM = "uuid";

	private PermissionDao permissionDao;
	private PermissionCache cache;

	@Inject
	public LoomAuthorizationProvider(PermissionDao permissionDao, PermissionCache cache) {
		this.permissionDao = permissionDao;
		this.cache = cache;
	}

	@Override
	public String getId() {
		return "loom";
	}

	@Override
	public void getAuthorizations(User user, Handler<AsyncResult<Void>> handler) {
		getAuthorizations(user)
			.onComplete(handler);
	}

	@Override
	public Future<Void> getAuthorizations(User user) {
		String userUuidStr = user.get(USER_UUID_CLAIM);
		if (userUuidStr == null) {
			return Future.failedFuture("User did not contain uuid");
		}
		UUID userUuid = UUID.fromString(userUuidStr);
		ResourcePermissionSet cachedPerms = cache.get(userUuid, userUUID -> {
			return permissionDao.loadPermissionsForUser(userUuid);
		});

		for (ResourcePermission perm : cachedPerms) {
			Authorization authorization = PermissionBasedAuthorization.create(perm.getPermission());
			user.authorizations().add(getId(), authorization);
		}
		return Future.succeededFuture();
	}

}
