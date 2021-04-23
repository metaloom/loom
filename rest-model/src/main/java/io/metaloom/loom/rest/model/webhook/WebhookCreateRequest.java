package io.metaloom.loom.rest.model.webhook;

import io.metaloom.loom.rest.model.RestModel;

public class WebhookCreateRequest implements RestModel {

	private String url;

	public WebhookCreateRequest() {
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
