package io.metaloom.loom.db.model.task;

import io.metaloom.loom.db.CRUDDao;

public interface TaskDao extends CRUDDao<Task> {

	Task createTask(String title);

}
