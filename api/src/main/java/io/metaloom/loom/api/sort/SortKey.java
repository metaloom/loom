package io.metaloom.loom.api.sort;

public class SortKey {

	private final String name;

	public SortKey(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

	// TODO use enum and thus fail when unknown key has been specified
	public static SortKey fromString(String value) {
		return new SortKey(value);
	}

}
