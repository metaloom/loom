package io.metaloom.loom.rest.service.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.model.task.TaskDao;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.service.AbstractEndpointService;

@Singleton
public class TaskEndpointService extends AbstractEndpointService {

	private final TaskDao taskDao;

	@Inject
	public TaskEndpointService(TaskDao taskDao, LoomModelBuilder modelBuilder) {
		super(modelBuilder);
		this.taskDao = taskDao;
	}

}
