package io.metaloom.loom.rest.endpoint.impl;

import javax.inject.Inject;

import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.AssetLocationEndpointService;

public class BinaryEndpoint extends AbstractRESTEndpoint {

	private final AssetLocationEndpointService binaryService;

	@Inject
	public BinaryEndpoint(AssetLocationEndpointService binaryService, EndpointDependencies deps) {
		super(deps);
		this.binaryService = binaryService;
	}

	@Override
	public void register() {

	}

}
