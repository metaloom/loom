package io.metaloom.loom.rest.model.task;

import java.util.ArrayList;
import java.util.List;

import io.metaloom.loom.rest.model.comment.CommentResponse;
import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;

public class TaskResponse extends AbstractCreatorEditorRestResponse<TaskResponse> {

	private String title;

	private String description;

	private List<CommentResponse> comments = new ArrayList<>();

	// reactions

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

	public List<CommentResponse> getComments() {
		return comments;
	}

	public TaskResponse setComments(List<CommentResponse> comments) {
		this.comments = comments;
		return this;
	}

	@Override
	public TaskResponse self() {
		return this;
	}
}
