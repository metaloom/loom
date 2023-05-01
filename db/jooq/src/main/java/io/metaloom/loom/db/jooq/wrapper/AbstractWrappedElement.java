package io.metaloom.loom.db.jooq.wrapper;

import java.io.Serializable;

public abstract class AbstractWrappedElement<T extends Serializable> implements JooqWrapper<T> {

	private final T delegate;

	public AbstractWrappedElement(T delegate) {
		this.delegate = delegate;
	}

	@Override
	public T delegate() {
		return delegate;
	}

}
