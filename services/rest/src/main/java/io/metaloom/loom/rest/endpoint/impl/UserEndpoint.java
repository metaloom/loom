package io.metaloom.loom.rest.endpoint.impl;

import static io.vertx.core.http.HttpMethod.DELETE;
import static io.vertx.core.http.HttpMethod.GET;
import static io.vertx.core.http.HttpMethod.POST;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.auth.LoomAuthHandler;
import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.db.model.user.LoomUserDao;
import io.metaloom.loom.db.page.Page;
import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.model.message.GenericMessageResponse;
import io.metaloom.loom.rest.model.user.UserCreateRequest;
import io.metaloom.loom.rest.model.user.UserListResponse;
import io.metaloom.loom.rest.model.user.UserResponse;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public class UserEndpoint extends AbstractRESTEndpoint {

	private static final Logger log = LoggerFactory.getLogger(UserEndpoint.class);
	private final LoomUserDao userDao;

	@Inject
	public UserEndpoint(Vertx vertx, @Named("restRouter") Router router, LoomAuthHandler authHandler, LoomUserDao userDao) {
		super(vertx, router, authHandler);
		this.userDao = userDao;
	}

	@Override
	public void register() {
		log.info("Registering users endpoint");

		secure("/users");
		registerLoadUser();
		registerCreateUser();
		registerListUsers();
		registerDeleteUser();

	}

	private void registerDeleteUser() {
		addRoute("/users/:uuid", DELETE, lrc -> {
			String uuid = lrc.pathParam("uuid");
			System.out.println("Deleting " + uuid);
			LoomUser user = userDao.loadUser(UUID.fromString(uuid));
			if (user == null) {
				lrc.send(new GenericMessageResponse(), 404);
				return;
			} else {
				userDao.deleteUser(user);
				lrc.send();
			}
		});

	}

	private void registerListUsers() {
		addRoute("/users", GET, lrc -> {
			Page<LoomUser> page = userDao.loadUsers(null, 25);
			UserListResponse response = new UserListResponse();
			page.forEach(user -> {
				response.add(toResponse(user));
			});
			lrc.send(response);
		});
	}

	private void registerCreateUser() {
		addRoute("/users", POST, lrc -> {
			UserCreateRequest request = lrc.requestBody(UserCreateRequest.class);
			String userName = request.getUsername();

			// TODO check permissions
			// TODO validate request
			// TODO handle conflicts

			LoomUser user = userDao.createUser(userName);
			userDao.storeUser(user);
			lrc.send(toResponse(user), 201);
		});
	}

	private void registerLoadUser() {
		addRoute("/users/:name", GET, lrc -> {
			LoomUser user = userDao.loadUserByUsername(lrc.pathParam("name"));
			if (user == null) {
				lrc.send(new GenericMessageResponse(), 404);
				return;
			}
			System.out.println("Get Users: " + lrc.user());
			UserResponse response = toResponse(user);
			lrc.send(response);
		});
	}

	private UserResponse toResponse(LoomUser user) {
		UserResponse response = new UserResponse();
		response.setUsername(user.getUsername());
		response.setUuid(user.getUuid());
		return response;
	}

}
