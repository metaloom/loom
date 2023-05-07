package io.metaloom.loom.rest.model.library;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;

public class LibraryResponse extends AbstractCreatorEditorRestResponse<LibraryResponse> {

	@JsonProperty(required = true)
	@JsonPropertyDescription("The name of the library")
	private String name;

	@JsonProperty(required = false)
	@JsonPropertyDescription("Additional custom meta properties for the element.")
	private Map<String, String> meta;

	public LibraryResponse() {
	}

	public String getName() {
		return name;
	}

	public LibraryResponse setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public LibraryResponse self() {
		return this;
	}
}
