package io.metaloom.loom.rest.endpoint.impl;

import javax.inject.Inject;

import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.LibraryEndpointService;

public class LibraryEndpoint extends AbstractRESTEndpoint {

	private final LibraryEndpointService libraryService;

	@Inject
	public LibraryEndpoint(LibraryEndpointService libraryService, EndpointDependencies deps) {
		super(deps);
		this.libraryService = libraryService;
	}

	@Override
	public void register() {

	}

}
