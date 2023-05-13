package io.metaloom.loom.core.endpoint.test;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import io.metaloom.loom.client.http.LoomHttpClient;
import io.metaloom.loom.client.http.impl.HttpErrorException;
import io.metaloom.loom.core.endpoint.AbstractEndpointTest;
import io.metaloom.loom.core.endpoint.CRUDEndpointTestcases;
import io.metaloom.loom.rest.model.asset.AssetCreateRequest;
import io.metaloom.loom.rest.model.asset.AssetListResponse;
import io.metaloom.loom.rest.model.asset.AssetResponse;
import io.metaloom.loom.rest.model.asset.AssetUpdateRequest;

public class AssetEndpointTest extends AbstractEndpointTest implements CRUDEndpointTestcases {

	@Test
	@Override
	public void testCreate() throws HttpErrorException {
		try (LoomHttpClient client = httpClient()) {
			AssetCreateRequest request = new AssetCreateRequest();
			request.setFilename("test.png");
			request.setLocalPath("/tmp/test.png");
			client.storeAsset(request).sync();
		}
	}

	@Test
	@Override
	public void testRead() throws HttpErrorException {
		try (LoomHttpClient client = httpClient()) {
			AssetResponse response = client.loadAsset(ASSET_UUID).sync();
			assertNotNull(response);
		}
	}

	@Test
	@Override
	public void testDelete() throws HttpErrorException {
		try (LoomHttpClient client = httpClient()) {
			client.deleteAsset(ASSET_UUID).sync();
			try {
				client.loadAsset(ASSET_UUID).sync();
				fail("The load should fail");
			} catch (HttpErrorException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	@Override
	public void testUpdate() throws HttpErrorException {
		final String NEW_NAME = "the_new_local_path.jpg";
		try (LoomHttpClient client = httpClient()) {

			AssetUpdateRequest request = new AssetUpdateRequest();
			request.setLocalPath(NEW_NAME);
			AssetResponse response = client.updateAsset(ASSET_UUID, request).sync();
			assertEquals(NEW_NAME, response.getLocations().get(0).getPath());

			AssetResponse loadResponse = client.loadAsset(ASSET_UUID).sync();
			assertEquals(NEW_NAME, loadResponse.getLocations().get(0).getPath());
		}
	}

	@Test
	@Override
	public void testReadPaged() throws HttpErrorException {
		try (LoomHttpClient client = httpClient()) {
			for (int i = 0; i < 100; i++) {
				AssetCreateRequest request = new AssetCreateRequest();
				request.setFilename("test_" + i + ".png");
				request.setLocalPath("/tmp/test_" + i + ".png");
				client.storeAsset(request).sync();
			}

			AssetListResponse response = client.listAssets(null, 25).sync();
			assertNotNull(response);
		}

	}

}