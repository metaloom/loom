package io.metaloom.loom.rest.parameter;

import java.util.UUID;
import java.util.function.Function;

import io.metaloom.loom.api.filter.LoomLHSFilterParser;
import io.metaloom.loom.api.sort.LoomSortKey;
import io.metaloom.loom.api.sort.SortDirection;

public enum QueryParameterKey {

	LIMIT("limit", 25, Integer::valueOf),

	FROM("from", null, UUID::fromString),

	FILTER("filter", null, filterStr -> {
		return new LoomLHSFilterParser().parse(filterStr);
	}),

	SORT("sort", null, LoomSortKey::fromString),

	DIRECTION("dir", null, SortDirection::fromString);

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
