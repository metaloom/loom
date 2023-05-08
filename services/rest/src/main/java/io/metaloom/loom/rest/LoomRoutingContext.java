package io.metaloom.loom.rest;

import javax.inject.Inject;

import io.metaloom.loom.auth.LoomAuthorizationProvider;
import io.metaloom.loom.db.model.perm.Permission;
import io.metaloom.loom.rest.json.Json;
import io.metaloom.loom.rest.model.RestRequestModel;
import io.metaloom.loom.rest.model.RestResponseModel;
import io.vertx.core.Future;
import io.vertx.core.http.HttpHeaders;
import io.vertx.ext.auth.User;
import io.vertx.ext.auth.authorization.PermissionBasedAuthorization;
import io.vertx.ext.web.RoutingContext;

public class LoomRoutingContext {

	private final RoutingContext rc;
	private final LoomAuthorizationProvider authorizationProvider;

	@Inject
	public LoomRoutingContext(RoutingContext rc, LoomAuthorizationProvider authorizationProvider) {
		this.rc = rc;
		this.authorizationProvider = authorizationProvider;
	}

	public <T extends RestRequestModel> T requestBody(Class<T> clazz) {
		return Json.parse(rc.body().buffer(), clazz);
	}

	public void send(RestResponseModel response) {
		send(response, 200);
	}

	public void send(RestResponseModel response, int statusCode) {
		rc.response().headers().set(HttpHeaders.CONTENT_TYPE, "application/json");
		rc.response().setStatusCode(statusCode).end(Json.encodeToBuffer(response));
	}

	/**
	 * Send a 204 (No Content) response.
	 */
	public void send() {
		rc.response().setStatusCode(204).end();
	}

	public String pathParam(String key) {
		return rc.pathParam(key);
	}

	// TODO wrap into LoomUser for typesafe attr access
	public User user() {
		return rc.user();
	}

	public Future<LoomRoutingContext> requirePerm(Permission... perms) {
		User user = user();
		LoomRoutingContext context = this;
		return authorizationProvider.getAuthorizations(user).flatMap(e -> {
			for (Permission perm : perms) {
				boolean hasPerm = PermissionBasedAuthorization.create(perm.name()).match(user);
				if (!hasPerm) {
					return Future.failedFuture("Missing permission " + perm.name());
				}
			}
			return Future.succeededFuture(context);
		});
	}

}
