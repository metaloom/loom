package io.metaloom.loom.rest.model.example;

import java.util.Arrays;

import deprecated.model.webhook.WebhookCreateRequest;
import deprecated.model.webhook.WebhookListResponse;
import deprecated.model.webhook.WebhookResponse;
import deprecated.model.webhook.WebhookTrigger;
import deprecated.model.webhook.WebhookUpdateRequest;

public class WebhookExamples extends AbstractExamples {

	public static WebhookResponse webhookResponse() {
		WebhookResponse model = new WebhookResponse();
		model.setUuid(uuidC());
		model.setUrl("http://myService/hook");
		model.setTriggers(Arrays.asList(WebhookTrigger.ASSET_CREATED));
		model.setActive(true);
		setCreatorEditor(model);
		return model;
	}

	public static WebhookListResponse webhookListResponse() {
		WebhookListResponse model = new WebhookListResponse();
		model.add(webhookResponse());
		model.add(webhookResponse());
		model.setMetainfo(pagingInfo());
		return model;
	}

	public static WebhookUpdateRequest webhookUpdateRequest() {
		WebhookUpdateRequest model = new WebhookUpdateRequest();
		model.setUrl("http://myService/newHook");
		model.setTriggers(Arrays.asList(WebhookTrigger.ASSET_CREATED));
		model.setActive(true);
		return model;
	}

	public static WebhookCreateRequest webhookCreateRequest() {
		WebhookCreateRequest model = new WebhookCreateRequest();
		model.setUrl("http://myService/hook");
		model.setTriggers(Arrays.asList(WebhookTrigger.ASSET_CREATED));
		return model;
	}
}
