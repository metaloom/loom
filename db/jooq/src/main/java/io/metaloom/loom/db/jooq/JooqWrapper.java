package io.metaloom.loom.db.jooq;

public interface JooqWrapper<T> {

	/**
	 * Return the wrapped jooq POJO
	 * 
	 * @return
	 */
	T getDelegate();

}
