package io.metaloom.loom.rest.model.example;

import static io.metaloom.loom.rest.model.example.AssetExamples.assetCreateRequest;
import static io.metaloom.loom.rest.model.example.AssetExamples.assetListResponse;
import static io.metaloom.loom.rest.model.example.AssetExamples.assetReference;
import static io.metaloom.loom.rest.model.example.AssetExamples.assetResponse;
import static io.metaloom.loom.rest.model.example.AssetExamples.assetUpdateRequest;
import static io.metaloom.loom.rest.model.example.ModelTestHelper.assertModel;

import org.junit.jupiter.api.Test;

public class AssetModelTest implements ModelTestcases {

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
