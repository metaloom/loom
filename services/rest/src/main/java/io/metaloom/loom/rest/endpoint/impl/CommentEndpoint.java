package io.metaloom.loom.rest.endpoint.impl;

import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.CommentEndpointService;

public class CommentEndpoint extends AbstractRESTEndpoint {

	private final CommentEndpointService commentService;

	public CommentEndpoint(CommentEndpointService commentService, EndpointDependencies deps) {
		super(deps);
		this.commentService = commentService;
	}

	@Override
	public void register() {
		// TODO Auto-generated method stub

	}

}
