package io.metaloom.loom.rest.model.tag;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestModel;

public class TagCreateRequest implements RestModel {

	@JsonProperty(required = true)
	@JsonPropertyDescription("Text value of the tag.")
	private String name;

	@JsonProperty(required = true)
	@JsonPropertyDescription("Name of the collection to which the tag belongs.")
	private String collection;

	@JsonProperty(required = false)
	@JsonPropertyDescription("Additional custom meta properties for the element.")
	private Map<String, String> meta;

	public TagCreateRequest() {
	}

	public String getName() {
		return name;
	}

	public TagCreateRequest setName(String name) {
		this.name = name;
		return this;
	}

	public String getCollection() {
		return collection;
	}

	public TagCreateRequest setCollection(String collection) {
		this.collection = collection;
		return this;
	}

	public Map<String, String> getMeta() {
		return meta;
	}

	public TagCreateRequest setMeta(Map<String, String> meta) {
		this.meta = meta;
		return this;
	}

}
