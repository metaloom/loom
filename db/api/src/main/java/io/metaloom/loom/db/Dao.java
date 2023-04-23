package io.metaloom.loom.db;

public interface Dao {

	/**
	 * Clear the elements that are managed by the DAO.
	 */
	void clear();

	/**
	 * Count all elements that are managed by the DAO.
	 * 
	 * @return
	 */
	long count();
}
