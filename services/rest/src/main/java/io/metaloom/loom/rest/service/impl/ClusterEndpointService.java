package io.metaloom.loom.rest.service.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.api.Loom;
import io.metaloom.loom.db.model.cluster.ClusterDao;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.service.AbstractEndpointService;

@Singleton
public class ClusterEndpointService extends AbstractEndpointService {

	private final ClusterDao clusterDao;

	@Inject
	public ClusterEndpointService(ClusterDao clusterDao, LoomModelBuilder modelBuilder) {
		super(modelBuilder);
		this.clusterDao = clusterDao;
	}

}
