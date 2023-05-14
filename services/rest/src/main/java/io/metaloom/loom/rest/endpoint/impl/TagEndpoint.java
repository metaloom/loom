package io.metaloom.loom.rest.endpoint.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.rest.AbstractCRUDEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.TagEndpointService;

public class TagEndpoint extends AbstractCRUDEndpoint<TagEndpointService> {

	private static final Logger log = LoggerFactory.getLogger(RoleEndpoint.class);

	@Inject
	public TagEndpoint(TagEndpointService service, EndpointDependencies deps) {
		super(service, deps);
	}

	@Override
	public String name() {
		return "tag";
	}

	@Override
	protected String basePath() {
		return "/tags";
	}

}
