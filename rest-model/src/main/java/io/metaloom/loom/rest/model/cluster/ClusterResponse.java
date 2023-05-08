package io.metaloom.loom.rest.model.cluster;

import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;

public class ClusterResponse extends AbstractCreatorEditorRestResponse<ClusterResponse> {

	private String name;

	public String getName() {
		return name;
	}

	public ClusterResponse setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public ClusterResponse self() {
		return this;
	}

}
