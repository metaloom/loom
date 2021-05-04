package io.metaloom.loom.db;

import io.metaloom.loom.db.tag.Tag;
import io.reactivex.Observable;

public interface Taggable {

	Observable<Tag> getTags();

	void addTag(Tag tag);

	void removeTag(Tag tag);
}
