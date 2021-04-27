package io.metaloom.loom.db.content;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;

public interface ContentsDao extends LoomDao {

	Content createContent();

	void deleteContent(Content content);

	void updateContent(Content content);

	Content loadContent(UUID uuid);

	void storeContent(Content content);

}
