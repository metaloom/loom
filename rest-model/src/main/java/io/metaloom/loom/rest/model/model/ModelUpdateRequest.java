package io.metaloom.loom.rest.model.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestModel;
import io.metaloom.loom.rest.model.model.field.ModelField;

public class ModelUpdateRequest implements RestModel {

	@JsonProperty(required = true)
	@JsonPropertyDescription("Name of the model")
	private String name;

	@JsonProperty(required = true)
	@JsonPropertyDescription("Reference to the field which provides the webroot segment for the content.")
	private String segmentField;

	@JsonProperty(value = "extends", required = false)
	@JsonPropertyDescription("Model from which fields and additional properties will be inherited.")
	private String extension;

	@JsonProperty(required = true)
	@JsonPropertyDescription("Fields which are included in the model.")
	private List<ModelField> fields;

	@JsonProperty(required = false)
	@JsonPropertyDescription("Flag which indicates whether the contents of this model should be searchable.")
	private Boolean searchable;

	public ModelUpdateRequest() {
	}

	public String getName() {
		return name;
	}

	public ModelUpdateRequest setName(String name) {
		this.name = name;
		return this;
	}

	public String getSegmentField() {
		return segmentField;
	}

	public ModelUpdateRequest setSegmentField(String segmentField) {
		this.segmentField = segmentField;
		return this;
	}

	public Boolean getSearchable() {
		return searchable;
	}

	public ModelUpdateRequest setSearchable(Boolean searchable) {
		this.searchable = searchable;
		return this;
	}

	public List<ModelField> getFields() {
		return fields;
	}

	public ModelUpdateRequest setFields(List<ModelField> fields) {
		this.fields = fields;
		return this;
	}

	public String getExtension() {
		return extension;
	}

	public ModelUpdateRequest setExtension(String extension) {
		this.extension = extension;
		return this;
	}
}
