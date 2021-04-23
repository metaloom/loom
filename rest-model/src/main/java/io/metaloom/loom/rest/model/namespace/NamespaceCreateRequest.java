package io.metaloom.loom.rest.model.namespace;

import io.metaloom.loom.rest.model.RestModel;

public class NamespaceCreateRequest implements RestModel {

	private String name;

	public NamespaceCreateRequest() {
	}

	public String getName() {
		return name;
	}

	public NamespaceCreateRequest setName(String name) {
		this.name = name;
		return this;
	}

}
