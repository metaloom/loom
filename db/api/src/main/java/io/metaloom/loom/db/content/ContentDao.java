package io.metaloom.loom.db.content;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.tag.Tag;
import io.reactivex.Maybe;
import io.reactivex.Observable;

public interface ContentDao extends LoomDao {

	Content createContent();

	void deleteContent(Content content);

	void updateContent(Content content);

	Maybe<? extends Content> loadContent(UUID uuid);

	void storeContent(Content content);

	Observable<Tag> loadTags(Content content);

	void addTag(Content content, Tag tag);

	void removeTag(Content content, Tag tag);

}
