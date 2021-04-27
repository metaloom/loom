package io.metaloom.loom.db.namespace;

import java.util.UUID;
import java.util.stream.Stream;

import io.metaloom.loom.db.tag.Tag;
import io.metaloom.loom.db.user.User;

public class FsNamespaceImpl implements Namespace {

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
	public Namespace setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public Stream<Tag> getTags() {
		return null;
	}

	@Override
	public void removeTag(Tag tag) {

	}

	@Override
	public void addTag(Tag tag) {

	}

}
