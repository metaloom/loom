package io.metaloom.loom.db.model.tag;

import java.util.UUID;
import java.util.function.Consumer;

import io.metaloom.loom.db.LoomDao;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.content.Content;
import io.metaloom.loom.db.model.namespace.Namespace;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

/**
 * DAO to manage {@link Tag} elements.
 */
public interface TagDao extends LoomDao {

	/**
	 * Create a new tag.
	 * 
	 * @param name
	 * @param collection
	 * @return
	 */
	default Single<? extends Tag> createTag(String name, String collection) {
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
	Single<? extends Tag> createTag(String name, String collection, Consumer<Tag> modifier);

	/**
	 * Load the tag with the given uuid.
	 * 
	 * @param uuid
	 * @return
	 */
	Maybe<? extends Tag> loadTag(UUID uuid);

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
	Completable updateTag(Tag tag);

	/**
	 * Assign the tag to the namespace.
	 * 
	 * @param tag
	 * @param namespace
	 * @return
	 */
	Completable tagNamespace(Tag tag, Namespace namespace);

	Completable untagNamespace(Tag tag, Namespace namespace);

	Completable tagAsset(Tag tag, Asset asset);

	Completable untagAsset(Tag tag, Asset asset);

	Completable tagContent(Tag tag, Content content);

	Completable untagContent(Tag tag, Content content);

}
