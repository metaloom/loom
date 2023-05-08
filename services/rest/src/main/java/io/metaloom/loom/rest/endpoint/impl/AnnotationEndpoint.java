package io.metaloom.loom.rest.endpoint.impl;

import javax.inject.Inject;

import io.metaloom.loom.rest.AbstractRESTEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.AnnotationEndpointService;

public class AnnotationEndpoint extends AbstractRESTEndpoint {

	private final AnnotationEndpointService annotationService;

	@Inject
	public AnnotationEndpoint(AnnotationEndpointService annotationService,  EndpointDependencies deps) {
		super(deps);
		this.annotationService = annotationService;
	}

	@Override
	public void register() {

	}

}
