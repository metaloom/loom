package io.metaloom.loom.rest.endpoint.impl;

import static io.vertx.core.http.HttpMethod.DELETE;
import static io.vertx.core.http.HttpMethod.GET;
import static io.vertx.core.http.HttpMethod.POST;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.loom.rest.AbstractCRUDEndpoint;
import io.metaloom.loom.rest.EndpointDependencies;
import io.metaloom.loom.rest.service.impl.ReactionEndpointService;
import io.metaloom.loom.rest.service.impl.TaskEndpointService;

public class TaskEndpoint extends AbstractCRUDEndpoint<TaskEndpointService> {

	private static final Logger log = LoggerFactory.getLogger(TaskEndpoint.class);

	private final ReactionEndpointService reactionService;

	@Inject
	public TaskEndpoint(TaskEndpointService service, ReactionEndpointService reactionService, EndpointDependencies deps) {
		super(service, deps);
		this.reactionService = reactionService;
	}

	@Override
	public String name() {
		return "task";
	}

	@Override
	protected String basePath() {
		return "/tasks";
	}

	@Override
	public void register() {
		super.register();

		// REACTION

		addRoute(basePath() + "/:taskUuid/reactions", POST, "Create a new reaction for a task", lrc -> {
			reactionService.createTaskReaction(lrc, lrc.pathParamUUID("taskUuid"));
		});

		addRoute(basePath() + "/:taskUuid/reactions/:reactionUuid", DELETE, "Delete a reaction for a task",lrc -> {
			reactionService.deleteTaskReaction(lrc, lrc.pathParamUUID("taskUuid"), lrc.pathParamUUID("reactionUuid"));
		});

		addRoute(basePath() + "/:taskUuid/reactions", GET, "Load a paged list of reactions for a task",  lrc -> {
			reactionService.listTaskReactions(lrc, lrc.pathParamUUID("taskUuid"));
		});

		addRoute(basePath() + "/:taskUuid/reactions/:reactionUuid", GET, "Return a specific reaction for a task", lrc -> {
			reactionService.loadTaskReaction(lrc, lrc.pathParamUUID("taskUuid"), lrc.pathParamUUID("reactionUuid"));
		});

		addRoute(basePath() + "/:taskUuid/reactions/:reactionUuid", POST, "Update a reaction for a task", lrc -> {
			reactionService.updateTaskReaction(lrc, lrc.pathParamUUID("taskUuid"), lrc.pathParamUUID("reactionUuid"));
		});

	}
}
