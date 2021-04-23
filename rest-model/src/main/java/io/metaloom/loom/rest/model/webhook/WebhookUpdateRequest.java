package io.metaloom.loom.rest.model.webhook;

import io.metaloom.loom.rest.model.RestModel;

public class WebhookUpdateRequest implements RestModel {

	private String url;
	
	public WebhookUpdateRequest() {
	}
	
	public String getUrl() {
		return url;
	}
	
	public WebhookUpdateRequest setUrl(String url) {
		this.url = url;
		return this;
	}
	
}
