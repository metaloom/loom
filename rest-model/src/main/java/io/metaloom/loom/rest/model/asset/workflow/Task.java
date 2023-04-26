package io.metaloom.loom.rest.model.asset.workflow;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Task {

	private UUID uuid;

	private String title;

	private String description;

	private List<Comment> comments = new ArrayList<>();

	// creator
	// editor

	// reactions
	// comments

	// assignedTo

	public UUID getUuid() {
		return uuid;
	}

	public Task setUuid(UUID uuid) {
		this.uuid = uuid;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Task setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Task setDescription(String description) {
		this.description = description;
		return this;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public Task setComments(List<Comment> comments) {
		this.comments = comments;
		return this;
	}

}
