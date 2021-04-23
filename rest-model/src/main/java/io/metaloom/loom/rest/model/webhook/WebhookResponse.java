package io.metaloom.loom.rest.model.webhook;

import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;

public class WebhookResponse extends AbstractCreatorEditorRestResponse {

	private String url;

	public WebhookResponse() {
	}

	public String getUrl() {
		return url;
	}

	public WebhookResponse setUrl(String url) {
		this.url = url;
		return this;
	}

}
