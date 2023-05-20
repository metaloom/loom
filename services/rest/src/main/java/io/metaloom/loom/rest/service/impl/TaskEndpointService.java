package io.metaloom.loom.rest.service.impl;

import static io.metaloom.loom.db.model.perm.Permission.CREATE_TASK;
import static io.metaloom.loom.db.model.perm.Permission.DELETE_TASK;
import static io.metaloom.loom.db.model.perm.Permission.READ_TASK;
import static io.metaloom.loom.db.model.perm.Permission.UPDATE_TASK;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.dagger.DaoCollection;
import io.metaloom.loom.db.model.task.Task;
import io.metaloom.loom.db.model.task.TaskDao;
import io.metaloom.loom.rest.LoomRoutingContext;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.model.task.TaskCreateRequest;
import io.metaloom.loom.rest.model.task.TaskUpdateRequest;
import io.metaloom.loom.rest.service.AbstractCRUDEndpointService;
import io.metaloom.loom.rest.validation.LoomModelValidator;

@Singleton
public class TaskEndpointService extends AbstractCRUDEndpointService<TaskDao, Task> {

	@Inject
	public TaskEndpointService(TaskDao taskDao, DaoCollection daos, LoomModelBuilder modelBuilder, LoomModelValidator validator) {
		super(taskDao, daos, modelBuilder, validator);
	}

	@Override
	public void delete(LoomRoutingContext lrc, UUID id) {
		delete(lrc, DELETE_TASK, id);
	}

	@Override
	public void list(LoomRoutingContext lrc) {
		list(lrc, READ_TASK, () -> {
			return dao().loadPage(null, 0, null, null, null);
		}, modelBuilder::toTaskList);
	}

	@Override
	public void load(LoomRoutingContext lrc, UUID id) {
		load(lrc, READ_TASK, () -> {
			return dao().load(id);
		}, modelBuilder::toResponse);
	}

	@Override
	public void create(LoomRoutingContext lrc) {
		create(lrc, CREATE_TASK, () -> {
			TaskCreateRequest request = lrc.requestBody(TaskCreateRequest.class);
			validator.validate(request);

			String name = null;
			UUID userUuid = lrc.userUuid();
			return dao().createTask(userUuid, name);
		}, modelBuilder::toResponse);
	}

	@Override
	public void update(LoomRoutingContext lrc, UUID id) {
		update(lrc, UPDATE_TASK, () -> {
			TaskUpdateRequest request = lrc.requestBody(TaskUpdateRequest.class);
			validator.validate(request);

			Task task = dao().load(id);
			// TOOD update
			return dao().update(task);
		}, modelBuilder::toResponse);
	}
}
