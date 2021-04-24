package io.metaloom.loom.rest.model.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;

public class WebhookResponse extends AbstractCreatorEditorRestResponse {

	@JsonProperty(required = true)
	@JsonPropertyDescription("The url which should be invoked by the webhook.")
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
