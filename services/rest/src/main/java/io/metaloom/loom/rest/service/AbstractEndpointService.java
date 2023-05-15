package io.metaloom.loom.rest.service;

import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.validation.LoomModelValidator;

public abstract class AbstractEndpointService implements EndpointService {

	protected final LoomModelBuilder modelBuilder;
	protected final LoomModelValidator validator;

	public AbstractEndpointService(LoomModelBuilder modelBuilder, LoomModelValidator validator) {
		this.modelBuilder = modelBuilder;
		this.validator = validator;
	}

}
