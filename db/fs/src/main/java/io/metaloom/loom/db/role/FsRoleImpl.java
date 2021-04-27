package io.metaloom.loom.db.role;

import java.util.UUID;

import io.metaloom.loom.db.user.User;

public class FsRoleImpl implements Role {

	private UUID uuid;
	private User editor;
	private User creator;
	private String name;

	@Override
	public User getEditor() {
		return editor;
	}

	@Override
	public void setEditor(User editor) {
		this.editor = editor;
	}

	@Override
	public User getCreator() {
		return creator;
	}

	@Override
	public void setCreator(User creator) {
		this.creator = creator;
	}

	@Override
	public UUID getUuid() {
		return uuid;
	}

	@Override
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Role setName(String name) {
		this.name = name;
		return this;
	}

}
