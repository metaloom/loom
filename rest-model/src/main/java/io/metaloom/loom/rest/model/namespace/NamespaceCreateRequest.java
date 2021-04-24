package io.metaloom.loom.rest.model.namespace;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestModel;

public class NamespaceCreateRequest implements RestModel {

	@JsonProperty(required = true)
	@JsonPropertyDescription("The name of the namespace.")
	private String name;

	@JsonProperty(required = false)
	@JsonPropertyDescription("Additional custom meta properties for the element.")
	private Map<String, String> meta;

	public NamespaceCreateRequest() {
	}

	public String getName() {
		return name;
	}

	public NamespaceCreateRequest setName(String name) {
		this.name = name;
		return this;
	}

	public Map<String, String> getMeta() {
		return meta;
	}

	public NamespaceCreateRequest setMeta(Map<String, String> meta) {
		this.meta = meta;
		return this;
	}

}
