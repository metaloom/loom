package io.metaloom.loom.rest.endpoint.impl;

import static io.vertx.core.http.HttpMethod.DELETE;
import static io.vertx.core.http.HttpMethod.GET;
import static io.vertx.core.http.HttpMethod.POST;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.rest.AbstractCRUDEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.AnnotationEndpointService;
import io.metaloom.loom.rest.service.impl.ReactionEndpointService;

public class AnnotationEndpoint extends AbstractCRUDEndpoint<AnnotationEndpointService> {

	private static final Logger log = LoggerFactory.getLogger(AnnotationEndpoint.class);
	
	private final ReactionEndpointService reactionService;

	@Inject
	public AnnotationEndpoint(AnnotationEndpointService service, ReactionEndpointService reactionService, EndpointDependencies deps) {
		super(service, deps);
		this.reactionService = reactionService;
	}

	@Override
	public String name() {
		return "annotation";
	}

	@Override
	protected String basePath() {
		return "/annotations";
	}

	@Override
	public void register() {
		super.register();
		
		// REACTION

		addRoute(basePath() + "/:annotationUuid/reactions", POST, "Create a new reaction for an annotation", lrc -> {
			reactionService.createAnnotationReaction(lrc, lrc.pathParamUUID("annotationUuid"));
		});

		addRoute(basePath() + "/:annotationUuid/reactions/:reactionUuid", DELETE, "Delete a reaction for an annotation",lrc -> {
			reactionService.deleteAnnotationReaction(lrc, lrc.pathParamUUID("annotationUuid"), lrc.pathParamUUID("reactionUuid"));
		});

		addRoute(basePath() + "/:annotationUuid/reactions", GET, "Load a paged list of reactions on the annotation",lrc -> {
			reactionService.listAnnotationReactions(lrc, lrc.pathParamUUID("annotationUuid"));
		});

		addRoute(basePath() + "/:annotationUuid/reactions/:reactionUuid", GET, "Load the reaction for the annotation",lrc -> {
			reactionService.loadAnnotationReaction(lrc, lrc.pathParamUUID("annotationUuid"), lrc.pathParamUUID("reactionUuid"));
		});

		addRoute(basePath() + "/:annotationUuid/reactions/:reactionUuid", POST, "Update the reaction on the annotation", lrc -> {
			reactionService.updateAnnotationReaction(lrc, lrc.pathParamUUID("annotationUuid"), lrc.pathParamUUID("reactionUuid"));
		});
	}
	
}
