package io.metaloom.loom.db.jooq.dao.task;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;
import org.jooq.Table;
import org.jooq.TableRecord;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.JooqTask;
import io.metaloom.loom.db.model.task.Task;
import io.metaloom.loom.db.model.task.TaskDao;

@Singleton
public class TaskDaoImpl extends AbstractJooqDao<Task> implements TaskDao {

	@Inject
	public TaskDaoImpl(DSLContext ctx) {
		super(ctx);
	}

	@Override
	protected Table<? extends TableRecord<?>> getTable() {
		return JooqTask.TASK;
	}

	@Override
	protected Class<? extends Task> getPojoClass() {
		return TaskImpl.class;
	}

	@Override
	public Task createTask(String title) {
		Task task = new TaskImpl();
		task.setTitle(title);
		return task;
	}

}
