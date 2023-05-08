package io.metaloom.loom.rest.service.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.model.reaction.ReactionDao;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.service.AbstractEndpointService;

@Singleton
public class ReactionEndpointService extends AbstractEndpointService {

	private final ReactionDao reactionDao;

	@Inject
	public ReactionEndpointService(ReactionDao reactionDao, LoomModelBuilder modelBuilder) {
		super(modelBuilder);
		this.reactionDao = reactionDao;
	}

}
