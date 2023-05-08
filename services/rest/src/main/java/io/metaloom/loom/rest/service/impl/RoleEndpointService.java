package io.metaloom.loom.rest.service.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.model.role.RoleDao;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.service.AbstractEndpointService;
import io.metaloom.loom.rest.service.EndpointService;

@Singleton
public class RoleEndpointService extends AbstractEndpointService {

	private final RoleDao roleDao;

	@Inject
	public RoleEndpointService(RoleDao roleDao, LoomModelBuilder modelBuilder) {
		super(modelBuilder);
		this.roleDao = roleDao;
	}

}
