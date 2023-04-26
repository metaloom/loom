package io.metaloom.loom.rest.model.asset.workflow;

import java.util.List;
import java.util.UUID;

public class Task {

	private UUID uuid;

	private String title;

	private String description;

	private List<Comment> comments;

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
	
}
