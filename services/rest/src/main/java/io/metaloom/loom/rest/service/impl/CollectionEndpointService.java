package io.metaloom.loom.rest.service.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.model.collection.CollectionDao;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.service.AbstractEndpointService;

@Singleton
public class CollectionEndpointService extends AbstractEndpointService {

	private final CollectionDao collectionDao;

	@Inject
	public CollectionEndpointService(CollectionDao collectionDao, LoomModelBuilder modelBuilder) {
		super(modelBuilder);
		this.collectionDao = collectionDao;
	}

}
