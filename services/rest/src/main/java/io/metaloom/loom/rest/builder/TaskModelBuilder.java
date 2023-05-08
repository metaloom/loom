package io.metaloom.loom.rest.builder;

import io.metaloom.loom.db.model.task.Task;
import io.metaloom.loom.db.page.Page;
import io.metaloom.loom.rest.model.task.TaskListResponse;
import io.metaloom.loom.rest.model.task.TaskResponse;

public interface TaskModelBuilder extends ModelBuilder, UserModelBuilder {

	default TaskResponse toResponse(Task task) {
		TaskResponse response = new TaskResponse();
		response.setUuid(task.getUuid());
		response.setTitle(task.getTitle());
		response.setDescription(task.getDescription());
		setStatus(task, response);
		return response;
	}

	default TaskListResponse toTaskList(Page<Task> page) {
		return setPage(new TaskListResponse(), page, task -> {
			return toResponse(task);
		});
	}
}
