package io.metaloom.loom.rest.model.tag;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;

public class TagResponse extends AbstractCreatorEditorRestResponse<TagResponse> {

	@JsonProperty(required = true)
	@JsonPropertyDescription("Text value of the tag.")
	private String name;

	@JsonProperty(required = true)
	@JsonPropertyDescription("Name of the collection to which the tag belongs.")
	private String collection;

	public TagResponse() {
	}

	public String getName() {
		return name;
	}

	public TagResponse setName(String name) {
		this.name = name;
		return this;
	}

	public String getCollection() {
		return collection;
	}

	public TagResponse setCollection(String collection) {
		this.collection = collection;
		return this;
	}

	@Override
	public TagResponse self() {
		return this;
	}
}
