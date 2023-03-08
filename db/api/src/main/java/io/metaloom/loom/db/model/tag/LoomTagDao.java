package io.metaloom.loom.db.model.tag;

import java.util.UUID;
import java.util.function.Consumer;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.model.asset.LoomAsset;
import io.metaloom.loom.db.model.content.LoomContent;
import io.metaloom.loom.db.model.namespace.LoomNamespace;

/**
 * DAO to manage {@link LoomTag} elements.
 */
public interface LoomTagDao extends LoomDao {

	/**
	 * Create a new tag.
	 * 
	 * @param name
	 * @param collection
	 * @return
	 */
	default LoomTag createTag(String name, String collection) {
		return createTag(name, collection, null);
	}

	/**
	 * Create a new tag.
	 * 
	 * @param name
	 * @param collection
	 * @param modifier
	 * @return
	 */
	LoomTag createTag(String name, String collection, Consumer<LoomTag> modifier);

	/**
	 * Load the tag with the given uuid.
	 * 
	 * @param uuid
	 * @return
	 */
	LoomTag loadTag(UUID uuid);

	/**
	 * Delete the tag with the given uuid.
	 * 
	 * @param uuid
	 * @return
	 */
	void deleteTag(UUID uuid);

	/**
	 * Update the tag.
	 * 
	 * @param tag
	 * @return
	 */
	void updateTag(LoomTag tag);

	/**
	 * Assign the tag to the namespace.
	 * 
	 * @param tag
	 * @param namespace
	 * @return
	 */
	void tagNamespace(LoomTag tag, LoomNamespace namespace);

	void untagNamespace(LoomTag tag, LoomNamespace namespace);

	void tagAsset(LoomTag tag, LoomAsset asset);

	void untagAsset(LoomTag tag, LoomAsset asset);

	void tagContent(LoomTag tag, LoomContent content);

	void untagContent(LoomTag tag, LoomContent content);

}
