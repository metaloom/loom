package io.metaloom.loom.rest.model.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;
import io.metaloom.loom.rest.model.model.field.ModelField;

public class ModelResponse extends AbstractCreatorEditorRestResponse {

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
	
	public ModelResponse() {
	}

	public String getName() {
		return name;
	}

	public ModelResponse setName(String name) {
		this.name = name;
		return this;
	}
}
