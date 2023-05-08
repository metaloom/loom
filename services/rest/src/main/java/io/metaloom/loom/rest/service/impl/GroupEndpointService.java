package io.metaloom.loom.rest.service.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.model.group.GroupDao;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.service.AbstractEndpointService;

@Singleton
public class GroupEndpointService extends AbstractEndpointService {

	private final GroupDao groupDao;

	@Inject
	public GroupEndpointService(GroupDao groupDao, LoomModelBuilder modelBuilder) {
		super(modelBuilder);
		this.groupDao = groupDao;
	}

}
