package io.metaloom.loom.rest.model.extension;

import io.metaloom.loom.rest.model.RestModel;

public class ExtensionCreateRequest implements RestModel {

	private String url;

	public ExtensionCreateRequest() {
	}

	public String getURL() {
		return url;
	}

	public void setURL(String url) {
		this.url = url;
	}
}
