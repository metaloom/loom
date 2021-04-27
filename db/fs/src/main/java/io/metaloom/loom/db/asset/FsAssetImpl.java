package io.metaloom.loom.db.asset;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.metaloom.loom.db.tag.Tag;
import io.metaloom.loom.db.user.User;

public class FsAssetImpl implements Asset {

	private UUID uuid;
	private User editor;
	private User creator;
	private String name;

	private List<Tag> tags = new ArrayList<>();

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
	public String getFilename() {
		return name;
	}

	@Override
	public Asset setFilename(String name) {
		this.name = name;
		return this;
	}

	@Override
	@JsonIgnore
	public Stream<Tag> getTags() {
		return tags.stream();
	}

	@Override
	public void addTag(Tag tag) {
		tags.add(tag);
	}

	@Override
	public void removeTag(Tag tag) {
		tags.remove(tag);
	}

}
