package io.metaloom.loom.rest.model.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestModel;

public class WebhookCreateRequest implements RestModel {

	@JsonProperty(required = true)
	@JsonPropertyDescription("The url which should be invoked by the webhook.")
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
