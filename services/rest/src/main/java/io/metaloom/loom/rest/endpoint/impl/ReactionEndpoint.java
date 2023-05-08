package io.metaloom.loom.rest.endpoint.impl;

import javax.inject.Inject;

import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.ReactionEndpointService;

public class ReactionEndpoint extends AbstractRESTEndpoint {

	private final ReactionEndpointService reactionService;

	@Inject
	public ReactionEndpoint(ReactionEndpointService reactionService, EndpointDependencies deps) {
		super(deps);
		this.reactionService = reactionService;
	}
	
	@Override
	public void register() {
		// TODO Auto-generated method stub
		
	}

}
