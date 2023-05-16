package io.metaloom.loom.api.filter;

import io.metaloom.filter.FilterKey;
import io.metaloom.filter.key.impl.StringFilterKey;

public enum LoomFilterKey {

	USER_USERNAME(new StringFilterKey("username"));

	private FilterKey<?> key;

	LoomFilterKey(FilterKey<?> key) {
		this.key = key;
	}

	public FilterKey<?> getKey() {
		return key;
	}

	public static FilterKey<?> fromKey(String key) {
		for (LoomFilterKey v : values()) {
			if (v.getKey().key().equals(key)) {
				return v.getKey();
			}
		}
		return null;
	}

}
