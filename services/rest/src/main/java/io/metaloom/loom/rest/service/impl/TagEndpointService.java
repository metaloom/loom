package io.metaloom.loom.rest.service.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.model.tag.TagDao;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.service.AbstractEndpointService;

@Singleton
public class TagEndpointService extends AbstractEndpointService {

	private final TagDao tagDao;

	@Inject
	public TagEndpointService(TagDao tagDao, LoomModelBuilder modelBuilder) {
		super(modelBuilder);
		this.tagDao = tagDao;
	}

}
