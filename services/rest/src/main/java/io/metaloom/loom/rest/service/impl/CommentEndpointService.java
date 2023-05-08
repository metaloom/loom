package io.metaloom.loom.rest.service.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.model.comment.CommentDao;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.service.AbstractEndpointService;

@Singleton
public class CommentEndpointService extends AbstractEndpointService {

	private final CommentDao commentDao;

	@Inject
	public CommentEndpointService(CommentDao commentDao, LoomModelBuilder modelBuilder) {
		super(modelBuilder);
		this.commentDao = commentDao;
	}

}
