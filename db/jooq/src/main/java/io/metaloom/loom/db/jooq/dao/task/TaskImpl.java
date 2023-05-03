package io.metaloom.loom.db.jooq.dao.task;

import io.metaloom.loom.db.jooq.AbstractEditableElement;
import io.metaloom.loom.db.model.task.Task;

public class TaskImpl extends AbstractEditableElement<Task> implements Task {

	private String title;

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public Task setTitle(String title) {
		this.title = title;
		return this;
	}

}
