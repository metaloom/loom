package io.metaloom.loom.rest.service.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.model.annotation.AnnotationDao;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.service.AbstractEndpointService;

@Singleton
public class AnnotationEndpointService extends AbstractEndpointService {

	private final AnnotationDao annotationDao;

	@Inject
	public AnnotationEndpointService(AnnotationDao annotationDao, LoomModelBuilder modelBuilder) {
		super(modelBuilder);
		this.annotationDao = annotationDao;
	}

}
