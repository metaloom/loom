package io.metaloom.loom.rest.model.cluster;

import io.metaloom.loom.rest.model.RestRequestModel;

public class ClusterUpdateRequest implements RestRequestModel {

	private String name;

	private String type;

	public String getName() {
		return name;
	}

	public ClusterUpdateRequest setName(String name) {
		this.name = name;
		return this;
	}

	public String getType() {
		return type;
	}

	public ClusterUpdateRequest setType(String type) {
		this.type = type;
		return this;
	}

}
