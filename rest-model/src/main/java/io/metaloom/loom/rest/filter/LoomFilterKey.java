package io.metaloom.loom.rest.filter;

import io.metaloom.filter.FilterKey;

public enum LoomFilterKey implements FilterKey {

	USER_USERNAME("username", String.class);

	private String key;
	private Class<String> clazz;

	LoomFilterKey(String key, Class<String> clazz) {
		this.key = key;
		this.clazz = clazz;
	}

	@Override
	public String key() {
		return key;
	}

	public static FilterKey fromKey(String key) {
		for (FilterKey v : values()) {
			if (v.key().equals(key)) {
				return v;
			}
		}
		return null;
	}

}
