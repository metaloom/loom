package io.metaloom.loom.rest.service;

import io.metaloom.loom.rest.builder.LoomModelBuilder;

public abstract class AbstractEndpointService implements EndpointService {

	protected final LoomModelBuilder modelBuilder;

	public AbstractEndpointService(LoomModelBuilder modelBuilder) {
		this.modelBuilder = modelBuilder;
	}

}
