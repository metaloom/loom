package io.metaloom.loom.rest.endpoint.impl;

import javax.inject.Inject;

import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.BinaryEndpointService;

public class BinaryEndpoint extends AbstractRESTEndpoint {

	private final BinaryEndpointService binaryService;

	@Inject
	public BinaryEndpoint(BinaryEndpointService binaryService, EndpointDependencies deps) {
		super(deps);
		this.binaryService = binaryService;
	}

	@Override
	public void register() {

	}

}
