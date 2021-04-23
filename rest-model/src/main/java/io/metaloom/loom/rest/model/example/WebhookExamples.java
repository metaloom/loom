package io.metaloom.loom.rest.model.example;

import io.metaloom.loom.rest.model.webhook.WebhookCreateRequest;
import io.metaloom.loom.rest.model.webhook.WebhookListResponse;
import io.metaloom.loom.rest.model.webhook.WebhookResponse;
import io.metaloom.loom.rest.model.webhook.WebhookUpdateRequest;

public class WebhookExamples extends AbstractExamples {

	public static WebhookResponse webhookResponse() {
		WebhookResponse model = new WebhookResponse();
		model.setUuid(uuidC());
		model.setUrl("http://myService/hook");
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
		return model;
	}

	public static WebhookCreateRequest webhookCreateRequest() {
		WebhookCreateRequest model = new WebhookCreateRequest();
		model.setUrl("http://myService/hook");
		return model;
	}
}
