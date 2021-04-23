package io.metaloom.loom.rest.model.extension;

import io.metaloom.loom.rest.model.RestModel;

public class ExtensionUpdateRequest implements RestModel {

	private String url;

	public ExtensionUpdateRequest() {
	}

	public String getURL() {
		return url;
	}

	public void setURL(String url) {
		this.url = url;
	}
}
