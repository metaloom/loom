package io.metaloom.loom.db.group;

import java.util.UUID;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.metaloom.loom.db.role.Role;
import io.metaloom.loom.db.user.User;

public class FsGroupImpl implements Group {

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
	public Group setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	@JsonIgnore
	public Stream<User> streamUsers() {
		return null;
	}

	@Override
	public Group addUser(User user) {
		return this;
	}

	@Override
	public Group addRole(Role role) {
		return this;
	}

	@Override
	public Group removeRole(Role role) {
		return this;
	}
}
