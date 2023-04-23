package io.metaloom.loom.db.model.content;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Stream;

import io.metaloom.loom.db.Dao;
import io.metaloom.loom.db.model.tag.Tag;

public interface ContentDao extends Dao {

	default Content createContent() {
		return createContent(null);
	}

	Content createContent(Consumer<Content> modifier);

	void deleteContent(Content content);

	void updateContent(Content content);

	Content loadContent(UUID uuid);

	Stream<Tag> loadTags(Content content);

	void addTag(Content content, Tag tag);

	void removeTag(Content content, Tag tag);

}
