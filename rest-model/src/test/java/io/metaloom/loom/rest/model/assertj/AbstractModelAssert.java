package io.metaloom.loom.rest.model.assertj;

import org.assertj.core.api.AbstractAssert;

public abstract class AbstractModelAssert<U extends AbstractAssert<U, T>, T> extends AbstractAssert<U, T> {

	protected AbstractModelAssert(T actual, Class<?> selfType) {
		super(actual, selfType);
	}

}
