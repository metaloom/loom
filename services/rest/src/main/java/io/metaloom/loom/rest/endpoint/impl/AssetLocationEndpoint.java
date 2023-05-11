package io.metaloom.loom.rest.endpoint.impl;

import javax.inject.Inject;

import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.AssetLocationEndpointService;

public class AssetLocationEndpoint extends AbstractRESTEndpoint {

	private final AssetLocationEndpointService assetLocationService;

	@Inject
	public AssetLocationEndpoint(AssetLocationEndpointService assetLocationService, EndpointDependencies deps) {
		super(deps);
		this.assetLocationService = assetLocationService;
	}

	@Override
	public void register() {

	}

}
