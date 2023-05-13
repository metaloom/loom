package io.metaloom.loom.db;

import java.util.stream.Stream;

import io.metaloom.loom.db.page.Page;

/**
 * @param <T>
 *            Element type for the DTO
 * @param <PT>
 *            Type of the id
 */
public interface CRUDDao<T extends Element<T>, PT> extends Dao {

	default void delete(T element) {
		delete(primaryId(element));
	}

	default PT primaryId(T element) {
		return (PT) element.getUuid();
	}

	/**
	 * Delete the element with the given id.
	 * 
	 * @param id
	 */
	void delete(PT id);

	T update(T element);

	T load(PT id);

	/**
	 * Store the element.
	 * 
	 * @param element
	 */
	void store(T element);

	/**
	 * Load a page of elements.
	 * 
	 * @param fromId
	 * @param pageSize
	 * @return
	 */
	Page<T> loadPage(PT fromId, int pageSize);

	Stream<? extends T> findAll();

}
