package io.metaloom.loom.db.jooq.wrapper;

public abstract class AbstractWrappedElement<T> implements JooqWrapper<T> {

	private final T delegate;

	public AbstractWrappedElement(T delegate) {
		this.delegate = delegate;
	}

	@Override
	public T delegate() {
		return delegate;
	}

}
