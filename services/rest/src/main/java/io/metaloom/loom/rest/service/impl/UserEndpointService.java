package io.metaloom.loom.rest.service.impl;

import static io.metaloom.loom.db.model.perm.Permission.CREATE_USER;
import static io.metaloom.loom.db.model.perm.Permission.DELETE_USER;
import static io.metaloom.loom.db.model.perm.Permission.READ_USER;
import static io.metaloom.loom.db.model.perm.Permission.UPDATE_USER;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.db.dagger.DaoCollection;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.db.model.user.UserDao;
import io.metaloom.loom.rest.LoomRoutingContext;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.model.user.UserCreateRequest;
import io.metaloom.loom.rest.model.user.UserUpdateRequest;
import io.metaloom.loom.rest.service.AbstractCRUDEndpointService;
import io.metaloom.loom.rest.validation.LoomModelValidator;

@Singleton
public class UserEndpointService extends AbstractCRUDEndpointService<UserDao, User> {

	private static final Logger log = LoggerFactory.getLogger(UserEndpointService.class);

	@Inject
	public UserEndpointService(UserDao userDao, DaoCollection daos, LoomModelBuilder modelBuilder, LoomModelValidator validator) {
		super(userDao, daos, modelBuilder, validator);
	}

	@Override
	public void delete(LoomRoutingContext lrc, UUID uuid) {
		delete(lrc, DELETE_USER, uuid);
	}

	public void create(LoomRoutingContext lrc) {
		create(lrc, CREATE_USER, () -> {
			UserCreateRequest request = lrc.requestBody(UserCreateRequest.class);
			validator.validate(request);

			UUID userUuid = lrc.userUuid();
			String userName = request.getUsername();

			// TODO validate request
			// TODO handle conflicts

			User element = dao().createUser(userUuid, userName);
			return element;
		}, modelBuilder::toResponse);
	}

	@Override
	public void update(LoomRoutingContext lrc, UUID uuid) {
		update(lrc, UPDATE_USER, () -> {
			UserUpdateRequest request = lrc.requestBody(UserUpdateRequest.class);
			validator.validate(request);

			User user = dao().load(uuid);
			// TODO update
			return dao().update(user);
		}, modelBuilder::toResponse);
	}

	public void load(LoomRoutingContext lrc, UUID uuid) {
		load(lrc, READ_USER, () -> {
			return dao().load(uuid);
		}, modelBuilder::toResponse);
	}

	public void list(LoomRoutingContext lrc) {
		list(lrc, READ_USER, modelBuilder::toUserList);
	}

}
