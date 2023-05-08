package io.metaloom.loom.rest.model.collection;

import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;

public class CollectionResponse extends AbstractCreatorEditorRestResponse<CollectionResponse> {

	private String name;

	public String getName() {
		return name;
	}

	public CollectionResponse setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public CollectionResponse self() {
		return this;
	}

}
