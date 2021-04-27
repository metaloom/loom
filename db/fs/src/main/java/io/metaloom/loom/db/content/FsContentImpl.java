package io.metaloom.loom.db.content;

import java.util.UUID;
import java.util.stream.Stream;

import io.metaloom.loom.db.tag.Tag;
import io.metaloom.loom.db.user.User;

public class FsContentImpl implements Content {

	private UUID uuid;
	private User editor;
	private User creator;

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
	public Stream<Tag> getTags() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTag(Tag tag) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeTag(Tag tag) {
		// TODO Auto-generated method stub
	}
}
