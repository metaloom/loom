package io.metaloom.loom.rest.endpoint.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.rest.AbstractCRUDEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.LibraryEndpointService;

public class LibraryEndpoint extends AbstractCRUDEndpoint<LibraryEndpointService> {

	private static final Logger log = LoggerFactory.getLogger(LibraryEndpoint.class);

	@Inject
	public LibraryEndpoint(LibraryEndpointService service, EndpointDependencies deps) {
		super(service, deps);
	}

	@Override
	public String name() {
		return "library";
	}

	@Override
	protected String basePath() {
		return "/libraries";
	}
}
