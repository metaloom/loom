package io.metaloom.loom.db.model.content;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Stream;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.model.tag.LoomTag;

public interface LoomContentDao extends LoomDao {

	default LoomContent createContent() {
		return createContent(null);
	}

	LoomContent createContent(Consumer<LoomContent> modifier);

	void deleteContent(LoomContent content);

	void updateContent(LoomContent content);

	LoomContent loadContent(UUID uuid);

	Stream<LoomTag> loadTags(LoomContent content);

	void addTag(LoomContent content, LoomTag tag);

	void removeTag(LoomContent content, LoomTag tag);

}
