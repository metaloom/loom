package io.metaloom.loom.rest.model.webhook;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestModel;

public class WebhookCreateRequest implements RestModel {

	@JsonProperty(required = true)
	@JsonPropertyDescription("The url which should be invoked by the webhook.")
	private String url;

	@JsonProperty(required = true)
	@JsonPropertyDescription("The triggers define the events on which the hook should be invoked.")
	private List<WebhookTrigger> triggers;

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

	public List<WebhookTrigger> getTriggers() {
		return triggers;
	}

	public WebhookCreateRequest setTriggers(List<WebhookTrigger> triggers) {
		this.triggers = triggers;
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
