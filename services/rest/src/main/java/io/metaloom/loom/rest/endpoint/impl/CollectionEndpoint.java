package io.metaloom.loom.rest.endpoint.impl;

import javax.inject.Inject;

import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.CollectionEndpointService;

public class CollectionEndpoint extends AbstractRESTEndpoint {

	private final CollectionEndpointService collectionService;

	@Inject
	public CollectionEndpoint(CollectionEndpointService collectionService, EndpointDependencies deps) {
		super(deps);
		this.collectionService = collectionService;
	}
	
	@Override
	public void register() {
		// TODO Auto-generated method stub
		
	}

}
