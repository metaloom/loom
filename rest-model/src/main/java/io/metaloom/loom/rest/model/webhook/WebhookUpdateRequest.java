package io.metaloom.loom.rest.model.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestModel;

public class WebhookUpdateRequest implements RestModel {

	@JsonProperty(required = false)
	@JsonPropertyDescription("The url which should be invoked by the webhook.")
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
