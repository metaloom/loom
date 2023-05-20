package io.metaloom.loom.rest.parameter;

import java.util.UUID;
import java.util.function.Function;

import io.metaloom.filter.parser.LHSFilterParser;
import io.metaloom.loom.api.sort.SortDirection;
import io.metaloom.loom.api.sort.SortKey;

public enum QueryParameterKey {

	LIMIT("limit", 25, Integer::valueOf),

	FROM("from", null, UUID::fromString),

	FILTER("filter", null, filterStr -> {
		return LHSFilterParser.getInstance().parse(filterStr);
	}),

	SORT("sort", null, SortKey::fromString),

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
