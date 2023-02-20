package io.metaloom.loom.db.model.tag;

import java.util.UUID;
import java.util.function.Consumer;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.model.asset.LoomAsset;
import io.metaloom.loom.db.model.content.LoomContent;
import io.metaloom.loom.db.model.namespace.LoomNamespace;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

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
	default Single<? extends LoomTag> createTag(String name, String collection) {
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
	Single<? extends LoomTag> createTag(String name, String collection, Consumer<LoomTag> modifier);

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
