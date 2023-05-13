package io.metaloom.loom.rest.service.impl;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.dagger.DaoCollection;
import io.metaloom.loom.db.model.group.Group;
import io.metaloom.loom.db.model.group.GroupDao;
import io.metaloom.loom.rest.LoomRoutingContext;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.service.AbstractCRUDEndpointService;

@Singleton
public class GroupEndpointService extends AbstractCRUDEndpointService<GroupDao, Group, UUID> {

	@Inject
	public GroupEndpointService(GroupDao groupDao, DaoCollection daos, LoomModelBuilder modelBuilder) {
		super(groupDao, daos, modelBuilder);
	}

	@Override
	public void delete(LoomRoutingContext lrc, UUID uuid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void list(LoomRoutingContext lrc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void load(LoomRoutingContext lrc, UUID uuid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void create(LoomRoutingContext lrc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(LoomRoutingContext lrc, UUID uuid) {
		// TODO Auto-generated method stub

	}

}
