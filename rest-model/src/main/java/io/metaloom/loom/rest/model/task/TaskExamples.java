package io.metaloom.loom.rest.model.task;

import io.metaloom.loom.rest.model.example.ExampleValues;

public interface TaskExamples extends ExampleValues {

	default TaskResponse taskResponse() {
		TaskResponse model = new TaskResponse();
		model.setUuid(uuidA());
		model.setTitle("The title");
		model.setMeta(meta());
		return model;
	}

	default TaskCreateRequest taskCreateRequest() {
		TaskCreateRequest model = new TaskCreateRequest();
		model.setTitle("The title");
		model.setMeta(meta());
		return model;
	}

	default TaskUpdateRequest taskUpdateRequest() {
		TaskUpdateRequest model = new TaskUpdateRequest();
		model.setTitle("The title");
		model.setMeta(meta());
		return model;
	}

	default TaskListResponse taskListResponse() {
		TaskListResponse model = new TaskListResponse();
		model.setMetainfo(pagingInfo());
		return model;
	}
}
