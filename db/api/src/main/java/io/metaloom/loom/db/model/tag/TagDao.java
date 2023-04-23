package io.metaloom.loom.db.model.tag;

import java.util.UUID;
import java.util.function.Consumer;

import io.metaloom.loom.db.Dao;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.content.Content;
import io.metaloom.loom.db.model.namespace.Namespace;

/**
 * DAO to manage {@link Tag} elements.
 */
public interface TagDao extends Dao {

	/**
	 * Create a new tag.
	 * 
	 * @param name
	 * @param collection
	 * @return
	 */
	default Tag createTag(String name, String collection) {
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
	Tag createTag(String name, String collection, Consumer<Tag> modifier);

	/**
	 * Load the tag with the given uuid.
	 * 
	 * @param uuid
	 * @return
	 */
	Tag loadTag(UUID uuid);

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
	void updateTag(Tag tag);

	/**
	 * Assign the tag to the namespace.
	 * 
	 * @param tag
	 * @param namespace
	 * @return
	 */
	void tagNamespace(Tag tag, Namespace namespace);

	void untagNamespace(Tag tag, Namespace namespace);

	void tagAsset(Tag tag, Asset asset);

	void untagAsset(Tag tag, Asset asset);

	void tagContent(Tag tag, Content content);

	void untagContent(Tag tag, Content content);

}
