package io.metaloom.loom.db;

import java.util.stream.Stream;

import io.metaloom.loom.db.tag.Tag;

public interface Taggable {

	Stream<Tag> getTags();

	void addTag(Tag tag);

	void removeTag(Tag tag);
}
