package io.metaloom.loom.rest.model.namespace;

import io.metaloom.loom.rest.model.RestModel;

public class NamespaceUpdateRequest implements RestModel {

	private String name;

	public NamespaceUpdateRequest() {
	}

	public String getName() {
		return name;
	}

	public NamespaceUpdateRequest setName(String name) {
		this.name = name;
		return this;
	}

}
