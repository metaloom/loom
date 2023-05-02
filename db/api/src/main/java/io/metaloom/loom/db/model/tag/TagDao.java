package io.metaloom.loom.db.model.tag;

import java.util.function.Consumer;

import io.metaloom.loom.db.CRUDDao;
import io.metaloom.loom.db.model.asset.Asset;

/**
 * DAO to manage {@link Tag} elements.
 */
public interface TagDao extends CRUDDao<Tag> {
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

	void tagAsset(Tag tag, Asset asset);

	void untagAsset(Tag tag, Asset asset);

}
