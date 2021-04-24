package io.metaloom.loom.rest.model.namespace;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestModel;

public class NamespaceCreateRequest implements RestModel {

	@JsonPropertyDescription("The name of the namespace.")
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
