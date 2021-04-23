package io.metaloom.loom.rest.model.namespace;

import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;

public class NamespaceResponse extends AbstractCreatorEditorRestResponse {

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
