package io.metaloom.loom.rest.model.task;

import java.util.ArrayList;
import java.util.List;

import io.metaloom.loom.rest.model.asset.workflow.Comment;
import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;

public class TaskResponse extends AbstractCreatorEditorRestResponse<TaskResponse> {

	private String title;

	private String description;

	private List<Comment> comments = new ArrayList<>();

	// creator
	// editor

	// reactions
	// comments

	// assignedTo

	public String getTitle() {
		return title;
	}

	public TaskResponse setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public TaskResponse setDescription(String description) {
		this.description = description;
		return this;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public TaskResponse setComments(List<Comment> comments) {
		this.comments = comments;
		return this;
	}

	@Override
	public TaskResponse self() {
		return this;
	}
}
