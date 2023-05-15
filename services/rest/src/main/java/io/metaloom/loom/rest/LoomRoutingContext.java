package io.metaloom.loom.rest;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.api.error.LoomRestException;
import io.metaloom.loom.auth.LoomAuthorizationProvider;
import io.metaloom.loom.auth.LoomUser;
import io.metaloom.loom.db.model.perm.Permission;
import io.metaloom.loom.rest.json.Json;
import io.metaloom.loom.rest.model.RestRequestModel;
import io.metaloom.loom.rest.model.RestResponseModel;
import io.metaloom.loom.rest.model.message.GenericMessageResponse;
import io.metaloom.loom.rest.parameter.PagingParameters;
import io.vertx.core.Future;
import io.vertx.core.http.HttpHeaders;
import io.vertx.ext.auth.User;
import io.vertx.ext.auth.authorization.PermissionBasedAuthorization;
import io.vertx.ext.web.RoutingContext;

public class LoomRoutingContext {

	private static final Logger log = LoggerFactory.getLogger(LoomRoutingContext.class);

	private final RoutingContext rc;
	private final LoomAuthorizationProvider authorizationProvider;
	

	@Inject
	public LoomRoutingContext(RoutingContext rc, LoomAuthorizationProvider authorizationProvider) {
		this.rc = rc;
		this.authorizationProvider = authorizationProvider;
	}

	public <T extends RestRequestModel> T requestBody(Class<T> clazz) {
		T model = Json.parse(rc.body().buffer(), clazz);
		return model;
	}

	public void send(RestResponseModel<?> response) {
		send(response, 200);
	}

	public void send(RestResponseModel<?> response, int statusCode) {
		rc.response().headers().set(HttpHeaders.CONTENT_TYPE, "application/json");
		rc.response().setStatusCode(statusCode).end(Json.encodeToBuffer(response));
	}

	/**
	 * Send a 204 (No Content) response.
	 */
	public void send() {
		rc.response().setStatusCode(204).end();
	}

	public List<String> queryParam(String key) {
		return rc.queryParam(key);
	}

	public String pathParam(String key) {
		return rc.pathParam(key);
	}

	// TODO wrap into LoomUser for typesafe attr access
	public User user() {
		return rc.user();
	}

	public LoomUser loomUser() {
		return new LoomUser(user());
	}

	public Future<LoomRoutingContext> requirePerm(Permission... perms) {
		User user = user();
		LoomRoutingContext context = this;
		return authorizationProvider.getAuthorizations(user).flatMap(e -> {
			for (Permission perm : perms) {
				boolean hasPerm = PermissionBasedAuthorization.create(perm.name()).match(user);
				if (!hasPerm) {
					if (log.isDebugEnabled()) {
						log.debug("User is lacking permission {}", perm);
					}
					return Future.failedFuture("Missing permission " + perm.name());
				}
			}
			return Future.succeededFuture(context);
		});
	}

	public void error(String msg) {
		send(new GenericMessageResponse().setMessage(msg), 500);
	}

	public UUID pathParamUUID(String key) {
		String val = pathParam(key);
		if (val == null) {
			throw new LoomRestException(400, "Path parameter " + key + " not found");
		}
		return UUID.fromString(val);
	}

	public int pageSize() {
		String limitStr = pathParam("limit");
		int limit = 25;
		if (limitStr != null) {
			limit = Integer.valueOf(limitStr);
		}
		return limit;
	}

	public UUID userUuid() {
		return loomUser().getUuid();
	}

	public PagingParameters pagingParams() {
		return PagingParameters.create(this);
	}

}
