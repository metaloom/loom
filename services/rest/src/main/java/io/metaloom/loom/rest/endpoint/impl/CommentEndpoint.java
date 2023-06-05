package io.metaloom.loom.rest.endpoint.impl;

import static io.vertx.core.http.HttpMethod.DELETE;
import static io.vertx.core.http.HttpMethod.GET;
import static io.vertx.core.http.HttpMethod.POST;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.rest.AbstractCRUDEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.CommentEndpointService;
import io.metaloom.loom.rest.service.impl.ReactionEndpointService;

public class CommentEndpoint extends AbstractCRUDEndpoint<CommentEndpointService> {

	private static final Logger log = LoggerFactory.getLogger(CommentEndpoint.class);
	
	private final ReactionEndpointService reactionService;

	@Inject
	public CommentEndpoint(CommentEndpointService service, ReactionEndpointService reactionService, EndpointDependencies deps) {
		super(service, deps);
		this.reactionService = reactionService;
	}

	@Override
	public String name() {
		return "comment";
	}

	@Override
	protected String basePath() {
		return "/comments";
	}
	
	@Override
	public void register() {
		super.register();
		
		// REACTION

		addRoute(basePath() + "/:commentUuid/reactions", POST, lrc -> {
			reactionService.createCommentReaction(lrc, lrc.pathParamUUID("commentUuid"));
		});

		addRoute(basePath() + "/:commentUuid/reactions/:reactionUuid", DELETE, lrc -> {
			reactionService.deleteCommentReaction(lrc, lrc.pathParamUUID("commentUuid"), lrc.pathParamUUID("reactionUuid"));
		});

		addRoute(basePath() + "/:commentUuid/reactions", GET, lrc -> {
			reactionService.listCommentReactions(lrc, lrc.pathParamUUID("commentUuid"));
		});

		addRoute(basePath() + "/:commentUuid/reactions/:reactionUuid", GET, lrc -> {
			reactionService.loadCommentReaction(lrc, lrc.pathParamUUID("commentUuid"), lrc.pathParamUUID("reactionUuid"));
		});

		addRoute(basePath() + "/:commentUuid/reactions/:reactionUuid", POST, lrc -> {
			reactionService.updateCommentReaction(lrc, lrc.pathParamUUID("commentUuid"), lrc.pathParamUUID("reactionUuid"));
		});
	}

}
