package io.metaloom.loom.db.tag;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;

public interface TagsDao extends LoomDao {

	Tag createTag();

	void deleteTag(Tag tag);

	void updateTag(Tag tag);

	Tag loadTag(UUID uuid);

	void storeTag(Tag tag);
}
