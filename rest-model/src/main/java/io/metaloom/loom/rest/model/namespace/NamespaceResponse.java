package io.metaloom.loom.rest.model.namespace;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;

public class NamespaceResponse extends AbstractCreatorEditorRestResponse {

	@JsonProperty(required = true)
	@JsonPropertyDescription("The name of the namespace")
	private String name;

	public NamespaceResponse() {
	}

	public String getName() {
		return name;
	}

	public NamespaceResponse setName(String name) {
		this.name = name;
		return this;
	}

}
