package io.metaloom.loom.rest.model.extension;

import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;

public class ExtensionResponse extends AbstractCreatorEditorRestResponse {

	private String url;

	public ExtensionResponse() {

	}

	public String getURL() {
		return url;
	}

	public ExtensionResponse setURL(String url) {
		this.url = url;
		return this;
	}
}
