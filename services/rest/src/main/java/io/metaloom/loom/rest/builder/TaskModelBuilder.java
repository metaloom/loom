package io.metaloom.loom.rest.builder;

import io.metaloom.loom.db.model.task.Task;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.rest.model.task.TaskResponse;

public interface TaskModelBuilder extends ModelBuilder, UserModelBuilder {

	default TaskResponse toResponse(Task task, User creator, User editor) {
		TaskResponse response = new TaskResponse();
		response.setUuid(task.getUuid());
		response.setTitle(task.getTitle());
		response.setDescription(task.getDescription());
		setStatus(task, creator, editor, response);
		return response;
	}
}
