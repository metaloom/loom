package io.metaloom.loom.rest.service.impl;

import static io.metaloom.loom.db.model.perm.Permission.CREATE_GROUP;
import static io.metaloom.loom.db.model.perm.Permission.DELETE_GROUP;
import static io.metaloom.loom.db.model.perm.Permission.READ_GROUP;
import static io.metaloom.loom.db.model.perm.Permission.UPDATE_GROUP;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.dagger.DaoCollection;
import io.metaloom.loom.db.model.group.Group;
import io.metaloom.loom.db.model.group.GroupDao;
import io.metaloom.loom.rest.LoomRoutingContext;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.service.AbstractCRUDEndpointService;
import io.metaloom.loom.rest.validation.LoomModelValidator;

@Singleton
public class GroupEndpointService extends AbstractCRUDEndpointService<GroupDao, Group> {

	@Inject
	public GroupEndpointService(GroupDao groupDao, DaoCollection daos, LoomModelBuilder modelBuilder, LoomModelValidator validator) {
		super(groupDao, daos, modelBuilder, validator);
	}

	@Override
	public void delete(LoomRoutingContext lrc, UUID id) {
		delete(lrc, DELETE_GROUP, id);
	}

	@Override
	public void list(LoomRoutingContext lrc) {
		list(lrc, READ_GROUP, () -> {
			return dao().loadPage(null, 0);
		}, modelBuilder::toGroupList);
	}

	@Override
	public void load(LoomRoutingContext lrc, UUID id) {
		load(lrc, READ_GROUP, () -> {
			return dao().load(id);
		}, modelBuilder::toResponse);
	}

	@Override
	public void create(LoomRoutingContext lrc) {
		create(lrc, CREATE_GROUP, () -> {
			String name = null;
			UUID userUuid = lrc.userUuid();
			return dao().create(userUuid, name);
		}, modelBuilder::toResponse);
	}

	@Override
	public void update(LoomRoutingContext lrc, UUID id) {
		update(lrc, UPDATE_GROUP, () -> {
			Group group = dao().load(id);
			// TOOD update
			return dao().update(group);
		}, modelBuilder::toResponse);
	}
}
