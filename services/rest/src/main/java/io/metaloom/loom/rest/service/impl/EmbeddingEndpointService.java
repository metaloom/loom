package io.metaloom.loom.rest.service.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.model.embedding.EmbeddingDao;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.service.AbstractEndpointService;

@Singleton
public class EmbeddingEndpointService extends AbstractEndpointService {

	private final EmbeddingDao embeddingDao;

	@Inject
	public EmbeddingEndpointService(EmbeddingDao embeddingDao, LoomModelBuilder modelBuilder) {
		super(modelBuilder);
		this.embeddingDao = embeddingDao;
	}

}
