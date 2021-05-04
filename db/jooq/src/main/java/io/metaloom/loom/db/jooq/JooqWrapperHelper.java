package io.metaloom.loom.db.jooq;

import java.lang.reflect.Constructor;
import java.util.Optional;

import io.metaloom.loom.db.LoomElement;
import io.reactivex.Maybe;
import io.reactivex.Single;

public final class JooqWrapperHelper {

	private JooqWrapperHelper() {
	}

	public static <T, R> Maybe<T> wrap(Single<Optional<R>> jooq, Class<T> clazz) {
		Maybe<T> r = jooq.flatMapMaybe(e -> {
			if (e.isEmpty()) {
				return Maybe.empty();
			} else {
				R element = e.get();
				Constructor<T> constructor = clazz.getConstructor(element.getClass());
				T wrapper = constructor.newInstance(element);
				return Maybe.just(wrapper);
			}
		});
		return r;
	}

	public static <T> T unwrap(LoomElement element) {
		if (JooqWrapper.class.isInstance(element)) {
			@SuppressWarnings("unchecked")
			JooqWrapper<T> wrapper = JooqWrapper.class.cast(element);
			return wrapper.getDelegate();
		} else {
			throw new RuntimeException("Could not cast element {" + element.getClass() + "} to {" + JooqWrapper.class.getSimpleName() + "}");
		}
	}
}
