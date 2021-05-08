package io.metaloom.loom.db.content;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.tag.LoomTag;
import io.reactivex.Maybe;
import io.reactivex.Observable;

public interface LoomContentDao extends LoomDao {

	LoomContent createContent();

	void deleteContent(LoomContent content);

	void updateContent(LoomContent content);

	Maybe<? extends LoomContent> loadContent(UUID uuid);

	void storeContent(LoomContent content);

	Observable<LoomTag> loadTags(LoomContent content);

	void addTag(LoomContent content, LoomTag tag);

	void removeTag(LoomContent content, LoomTag tag);

}
