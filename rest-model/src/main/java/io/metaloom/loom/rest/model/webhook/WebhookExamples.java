package io.metaloom.loom.rest.model.webhook;

import java.util.Arrays;

import io.metaloom.loom.rest.model.example.ExampleValues;

public interface WebhookExamples extends ExampleValues {

	default WebhookResponse webhookResponse() {
		WebhookResponse model = new WebhookResponse();
		model.setUuid(uuidC());
		model.setUrl("http://myService/hook");
		model.setTriggers(Arrays.asList(WebhookTrigger.ASSET_CREATED));
		model.setActive(true);
		setCreatorEditor(model);
		return model;
	}

	default WebhookListResponse webhookListResponse() {
		WebhookListResponse model = new WebhookListResponse();
		model.add(webhookResponse());
		model.add(webhookResponse());
		model.setMetainfo(pagingInfo());
		return model;
	}

	default WebhookUpdateRequest webhookUpdateRequest() {
		WebhookUpdateRequest model = new WebhookUpdateRequest();
		model.setUrl("http://myService/newHook");
		model.setTriggers(Arrays.asList(WebhookTrigger.ASSET_CREATED));
		model.setActive(true);
		return model;
	}

	default WebhookCreateRequest webhookCreateRequest() {
		WebhookCreateRequest model = new WebhookCreateRequest();
		model.setUrl("http://myService/hook");
		model.setTriggers(Arrays.asList(WebhookTrigger.ASSET_CREATED));
		return model;
	}
}
