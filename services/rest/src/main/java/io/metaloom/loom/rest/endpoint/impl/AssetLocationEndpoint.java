package io.metaloom.loom.rest.endpoint.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.rest.AbstractCRUDEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.AssetLocationEndpointService;

public class AssetLocationEndpoint extends AbstractCRUDEndpoint<AssetLocationEndpointService> {

	private static final Logger log = LoggerFactory.getLogger(AssetLocationEndpoint.class);

	@Inject
	public AssetLocationEndpoint(AssetLocationEndpointService service, EndpointDependencies deps) {
		super(service, deps);
	}

	@Override
	protected String name() {
		return "location";
	}

	@Override
	protected String basePath() {
		return "/assets/:assetUuid/locations";
	}

}
