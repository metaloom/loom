package io.metaloom.loom.rest.endpoint.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.rest.AbstractCRUDEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.AnnotationEndpointService;

public class AnnotationEndpoint extends AbstractCRUDEndpoint<AnnotationEndpointService> {

	private static final Logger log = LoggerFactory.getLogger(AnnotationEndpoint.class);

	@Inject
	public AnnotationEndpoint(AnnotationEndpointService service, EndpointDependencies deps) {
		super(service, deps);
	}

	@Override
	protected String basePath() {
		return "/annotations";
	}

	@Override
	protected String name() {
		return "annotation";
	}

}
