package io.metaloom.loom.rest.service.impl;

import static io.metaloom.loom.db.model.perm.Permission.CREATE_USER;
import static io.metaloom.loom.db.model.perm.Permission.READ_USER;

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
import io.metaloom.loom.rest.service.AbstractCRUDEndpointService;

@Singleton
public class UserEndpointService extends AbstractCRUDEndpointService<UserDao, User> {

	private static final Logger log = LoggerFactory.getLogger(UserEndpointService.class);

	@Inject
	public UserEndpointService(UserDao userDao, DaoCollection daos, LoomModelBuilder modelBuilder) {
		super(userDao, daos, modelBuilder);
	}

	public void createUser(LoomRoutingContext lrc) {
		create(lrc, CREATE_USER, () -> {
			UserDao userDao = daos().userDao();
			UserCreateRequest request = lrc.requestBody(UserCreateRequest.class);
			String userName = request.getUsername();

			// TODO validate request
			// TODO handle conflicts

			User creatorEditor = dao().load(lrc.loomUser().getUuid());
			User element = dao().createUser(userName);
			element.setCreator(creatorEditor);
			element.setEditor(creatorEditor);

			return userDao.createUser("test");
		}, user -> {
			return modelBuilder.toResponse(user);
		});
	}

	public void loadUser(LoomRoutingContext lrc) {
		load(lrc, READ_USER, dao -> {
			return dao.loadUserByUsername(lrc.pathParam("name"));
		}, user -> {
			return modelBuilder.toResponse(user);
		});
	}

	public void listUsers(LoomRoutingContext lrc) {
		list(lrc, READ_USER, dao -> {
			return dao.loadPage(null, 25);
		}, page -> {
			return modelBuilder.toUserList(page);
		});
	}

}
