package io.metaloom.loom.db.tag;

import java.util.UUID;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.asset.LoomAsset;
import io.metaloom.loom.db.content.LoomContent;
import io.metaloom.loom.db.namespace.LoomNamespace;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

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
	Single<? extends LoomTag> createTag(String name, String collection);

	/**
	 * Load the tag with the given uuid.
	 * 
	 * @param uuid
	 * @return
	 */
	Maybe<? extends LoomTag> loadTag(UUID uuid);

	/**
	 * Delete the tag with the given uuid.
	 * 
	 * @param uuid
	 * @return
	 */
	Completable deleteTag(UUID uuid);

	/**
	 * Update the tag.
	 * 
	 * @param tag
	 * @return
	 */
	Completable updateTag(LoomTag tag);

	/**
	 * Assign the tag to the namespace.
	 * 
	 * @param tag
	 * @param namespace
	 * @return
	 */
	Completable tagNamespace(LoomTag tag, LoomNamespace namespace);

	Completable untagNamespace(LoomTag tag, LoomNamespace namespace);

	Completable tagAsset(LoomTag tag, LoomAsset asset);

	Completable untagAsset(LoomTag tag, LoomAsset asset);

	Completable tagContent(LoomTag tag, LoomContent content);

	Completable untagContent(LoomTag tag, LoomContent content);

}
