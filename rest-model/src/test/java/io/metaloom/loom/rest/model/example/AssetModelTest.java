package io.metaloom.loom.rest.model.example;

import static io.metaloom.loom.rest.model.example.ModelTestHelper.assertModel;

import org.junit.jupiter.api.Test;

import io.vertx.core.json.Json;

public class AssetModelTest implements ModelTestcases {

	@Test
	public void testModelOutput() {
		System.out.println(Json.encodePrettily(assetResponse()));
	}

	@Test
	@Override
	public void testResponse() {
		assertModel(assetResponse(), "AssetResponse");
	}

	@Test
	@Override
	public void testCreateRequest() {
		assertModel(assetCreateRequest(), "AssetCreateRequest");
	}

	@Test
	@Override
	public void testUpdateRequest() {
		assertModel(assetUpdateRequest(), "AssetUpdateRequest");
	}

	@Test
	@Override
	public void testReference() {
		assertModel(assetReference(), "AssetReference");
	}

	@Test
	@Override
	public void testListResponse() {
		assertModel(assetListResponse(), "AssetListResponse");
	}

}
