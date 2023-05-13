package io.metaloom.loom.rest.service.impl;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.dagger.DaoCollection;
import io.metaloom.loom.db.model.task.Task;
import io.metaloom.loom.db.model.task.TaskDao;
import io.metaloom.loom.rest.LoomRoutingContext;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.service.AbstractCRUDEndpointService;

@Singleton
public class TaskEndpointService extends AbstractCRUDEndpointService<TaskDao, Task, UUID> {

	@Inject
	public TaskEndpointService(TaskDao taskDao, DaoCollection daos, LoomModelBuilder modelBuilder) {
		super(taskDao, daos, modelBuilder);
	}

	@Override
	public void delete(LoomRoutingContext lrc, UUID uuid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void list(LoomRoutingContext lrc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load(LoomRoutingContext lrc, UUID uuid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(LoomRoutingContext lrc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(LoomRoutingContext lrc, UUID uuid) {
		
	}
}
