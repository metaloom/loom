package io.metaloom.loom.rest.service.impl;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.dagger.DaoCollection;
import io.metaloom.loom.db.model.annotation.Annotation;
import io.metaloom.loom.db.model.annotation.AnnotationDao;
import io.metaloom.loom.rest.LoomRoutingContext;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.service.AbstractCRUDEndpointService;

@Singleton
public class AnnotationEndpointService extends AbstractCRUDEndpointService<AnnotationDao, Annotation, UUID> {

	@Inject
	public AnnotationEndpointService(AnnotationDao annotationDao, DaoCollection daos, LoomModelBuilder modelBuilder) {
		super(annotationDao, daos, modelBuilder);
	}

	@Override
	public void delete(LoomRoutingContext lrc, UUID uuid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void list(LoomRoutingContext lrc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void load(LoomRoutingContext lrc, UUID uuid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void create(LoomRoutingContext lrc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(LoomRoutingContext lrc, UUID uuid) {

	}

}
