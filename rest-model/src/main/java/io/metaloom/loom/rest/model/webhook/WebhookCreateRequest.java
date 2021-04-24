package io.metaloom.loom.rest.model.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestModel;

public class WebhookCreateRequest implements RestModel {

	@JsonProperty(required = true)
	@JsonPropertyDescription("The url which should be invoked by the webhook.")
	private String url;

	@JsonProperty(required = true)
	@JsonPropertyDescription("The trigger defines the events on which the hook should be invoked.")
	private WebhookTrigger trigger;

	@JsonPropertyDescription("The specified token which will be included in every webhook request to the endpoint. The endpoint can use this information to verify that the request is legitimate.")
	private String secretToken;

	public WebhookCreateRequest() {
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public WebhookTrigger getTrigger() {
		return trigger;
	}

	public WebhookCreateRequest setTrigger(WebhookTrigger trigger) {
		this.trigger = trigger;
		return this;
	}

	public String getSecretToken() {
		return secretToken;
	}

	public WebhookCreateRequest setSecretToken(String secretToken) {
		this.secretToken = secretToken;
		return this;
	}

}
