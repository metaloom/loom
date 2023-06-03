package io.metaloom.loom.rest.endpoint.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.rest.AbstractCRUDEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.CommentEndpointService;

public class CommentEndpoint extends AbstractCRUDEndpoint<CommentEndpointService> {

	private static final Logger log = LoggerFactory.getLogger(CommentEndpoint.class);

	@Inject
	public CommentEndpoint(CommentEndpointService service, EndpointDependencies deps) {
		super(service, deps);
	}

	@Override
	public String name() {
		return "comment";
	}

	@Override
	protected String basePath() {
		return "/comments";
	}
	
	@Override
	public void register() {
		super.register();
		
		
	}

}
