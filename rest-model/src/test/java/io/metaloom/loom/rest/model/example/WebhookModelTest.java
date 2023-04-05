package io.metaloom.loom.rest.model.example;

import static io.metaloom.loom.rest.model.example.ModelTestHelper.assertModel;
import static io.metaloom.loom.rest.model.example.WebhookExamples.webhookCreateRequest;
import static io.metaloom.loom.rest.model.example.WebhookExamples.webhookListResponse;
import static io.metaloom.loom.rest.model.example.WebhookExamples.webhookResponse;
import static io.metaloom.loom.rest.model.example.WebhookExamples.webhookUpdateRequest;

import org.junit.jupiter.api.Test;

public class WebhookModelTest implements ModelTestcases {

	@Test
	@Override
	public void testResponse() {
		assertModel(webhookResponse(), "WebhookResponse");
	}

	@Test
	@Override
	public void testCreateRequest() {
		assertModel(webhookCreateRequest(), "WebhookCreateRequest");
	}

	@Test
	@Override
	public void testUpdateRequest() {
		assertModel(webhookUpdateRequest(), "WebhookUpdateRequest");
	}

	@Override
	public void testReference() {
		// Does not apply for webhooks		
	}

	@Test
	@Override
	public void testListResponse() {
		assertModel(webhookListResponse(), "WebhookListResponse");
	}

}
