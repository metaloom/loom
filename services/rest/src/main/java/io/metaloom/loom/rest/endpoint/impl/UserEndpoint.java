package io.metaloom.loom.rest.endpoint.impl;

import static io.metaloom.loom.db.model.perm.Permission.READ_USER;
import static io.vertx.core.http.HttpMethod.DELETE;
import static io.vertx.core.http.HttpMethod.GET;
import static io.vertx.core.http.HttpMethod.POST;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.auth.LoomAuthenticationHandler;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.db.model.user.UserDao;
import io.metaloom.loom.db.page.Page;
import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.dagger.RestComponent;
import io.metaloom.loom.rest.model.message.GenericMessageResponse;
import io.metaloom.loom.rest.model.user.UserCreateRequest;
import io.metaloom.loom.rest.model.user.UserListResponse;
import io.metaloom.loom.rest.model.user.UserResponse;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public class UserEndpoint extends AbstractRESTEndpoint {

	private static final Logger log = LoggerFactory.getLogger(UserEndpoint.class);
	private final UserDao userDao;
	private final LoomModelBuilder modelBuilder;

	@Inject
	public UserEndpoint(Vertx vertx, @Named("restRouter") Router router, LoomAuthenticationHandler authHandler, UserDao userDao,
		Provider<RestComponent.Builder> restComponentProvider, LoomModelBuilder modelBuilder) {
		super(vertx, router, restComponentProvider, authHandler);
		this.userDao = userDao;
		this.modelBuilder = modelBuilder;
	}

	@Override
	public void register() {
		log.info("Registering users endpoint");

		secure("/users*");
		registerLoadUser();
		registerCreateUser();
		registerListUsers();
		registerDeleteUser();
	}

	private void registerDeleteUser() {
		addRoute("/users/:uuid", DELETE, lrc -> {
			String uuid = lrc.pathParam("uuid");
			System.out.println("Deleting " + uuid);
			User user = userDao.load(UUID.fromString(uuid));
			if (user == null) {
				lrc.send(new GenericMessageResponse(), 404);
				return;
			} else {
				userDao.delete(user);
				lrc.send();
			}
		});

	}

	private void registerListUsers() {
		addRoute("/users", GET, lrc -> {
			Page<User> page = userDao.loadPage(null, 25);
			UserListResponse response = modelBuilder.toUserList(page);
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

			User creatorEditor = userDao.load(lrc.user().get("uuid"));
			User user = userDao.createUser(userName);
			userDao.store(user);
			lrc.send(modelBuilder.toResponse(user, creatorEditor, creatorEditor), 201);
		});
	}

	private void registerLoadUser() {
		addRoute("/users/:name", GET, lrc -> {
			lrc.requirePerm(READ_USER).onSuccess(l -> {
				User user = userDao.loadUserByUsername(lrc.pathParam("name"));
				if (user == null) {
					lrc.send(new GenericMessageResponse(), 404);
					return;
				}
				User creator = userDao.load(user.getCreatorUuid());
				User editor = userDao.load(user.getEditorUuid());
				UserResponse response = modelBuilder.toResponse(user, creator, editor);
				lrc.send(response);
			}).onFailure(e -> {
				// TODO this should be 500 error
				log.error("Failed to check perms", e);
				lrc.send(new GenericMessageResponse().setMessage("Invalid permissions"), 403);
			});
		});
	}

}
