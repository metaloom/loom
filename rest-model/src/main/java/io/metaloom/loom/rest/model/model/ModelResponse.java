package io.metaloom.loom.rest.model.model;

import java.util.List;

import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;
import io.metaloom.loom.rest.model.model.field.ModelField;

public class ModelResponse extends AbstractCreatorEditorRestResponse {

	private String name;

	private List<ModelField> fields;

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
