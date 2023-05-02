package io.metaloom.loom.rest.model.library;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestModel;

public class LibraryUpdateRequest implements RestModel {

	@JsonProperty(required = false)
	@JsonPropertyDescription("The name of the library.")
	private String name;

	@JsonProperty(required = false)
	@JsonPropertyDescription("Additional custom meta properties for the element.")
	private Map<String, String> meta;

	public LibraryUpdateRequest() {
	}

	public String getName() {
		return name;
	}

	public LibraryUpdateRequest setName(String name) {
		this.name = name;
		return this;
	}

	public Map<String, String> getMeta() {
		return meta;
	}

	public LibraryUpdateRequest setMeta(Map<String, String> meta) {
		this.meta = meta;
		return this;
	}
}
