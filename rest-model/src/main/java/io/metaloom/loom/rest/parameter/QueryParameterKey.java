package io.metaloom.loom.rest.parameter;

import java.util.UUID;
import java.util.function.Function;

import io.metaloom.filter.Filter;
import io.metaloom.loom.rest.filter.LoomFilterKey;

public enum QueryParameterKey {

	PER_PAGE("perPage", 25, Integer::valueOf),

	FROM("from", null, UUID::fromString), 

	FILTER("filter", null, filterStr -> {
		return Filter.parse(filterStr, LoomFilterKey::fromKey);
	});

	private String key;
	private Function<String, ?> converter;
	private Object defaultValue;

	QueryParameterKey(String key, Object defaultValue, Function<String, ?> converter) {
		this.key = key;
		this.converter = converter;
		this.defaultValue = defaultValue;
	}

	public String key() {
		return key;
	}

	@SuppressWarnings("unchecked")
	<T> T map(String value) {
		return (T) converter.apply(value);
	}

	@SuppressWarnings("unchecked")
	<T> T defaultValue() {
		return (T) defaultValue;
	}
}
