package io.metaloom.loom.db.jooq.wrapper;

public interface JooqWrapper<T> {

	/**
	 * Return the wrapped jooq POJO
	 * 
	 * @return
	 */
	T delegate();

}
