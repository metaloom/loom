package io.metaloom.loom.rest.service.impl;

import static io.metaloom.loom.db.model.perm.Permission.READ_USER;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.db.model.user.UserDao;
import io.metaloom.loom.db.page.Page;
import io.metaloom.loom.rest.LoomRoutingContext;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.model.message.GenericMessageResponse;
import io.metaloom.loom.rest.model.user.UserCreateRequest;
import io.metaloom.loom.rest.model.user.UserListResponse;
import io.metaloom.loom.rest.model.user.UserResponse;
import io.metaloom.loom.rest.service.EndpointService;

@Singleton
public class UserEndpointService implements EndpointService {

	private static final Logger log = LoggerFactory.getLogger(UserEndpointService.class);

	private final UserDao userDao;
	private final LoomModelBuilder modelBuilder;

	@Inject
	public UserEndpointService(UserDao userDao, LoomModelBuilder modelBuilder) {
		this.userDao = userDao;
		this.modelBuilder = modelBuilder;
	}

	public void deleteUser(LoomRoutingContext lrc) {
		String uuidStr = lrc.pathParam("uuid");
		UUID uuid = UUID.fromString(uuidStr);
		User user = userDao.load(uuid);
		if (user == null) {
			lrc.send(new GenericMessageResponse(), 404);
			return;
		} else {
			userDao.delete(user);
			lrc.send();
		}
	}

	public void listUsers(LoomRoutingContext lrc) {
		Page<User> page = userDao.loadPage(null, 25);
		UserListResponse response = modelBuilder.toUserList(page);
		lrc.send(response);
	}

	public void createUser(LoomRoutingContext lrc) {
		UserCreateRequest request = lrc.requestBody(UserCreateRequest.class);
		String userName = request.getUsername();

		// TODO check permissions
		// TODO validate request
		// TODO handle conflicts

		User creatorEditor = userDao.load(lrc.user().get("uuid"));
		User user = userDao.createUser(userName);
		userDao.store(user);
		lrc.send(modelBuilder.toResponse(user, creatorEditor, creatorEditor), 201);
	}

	public void loadUser(LoomRoutingContext lrc) {
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

	}

}
