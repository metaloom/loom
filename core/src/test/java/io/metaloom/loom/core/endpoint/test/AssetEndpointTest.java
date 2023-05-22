package io.metaloom.loom.core.endpoint.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.metaloom.loom.client.http.LoomHttpClient;
import io.metaloom.loom.client.http.impl.HttpErrorException;
import io.metaloom.loom.core.endpoint.AbstractCRUDEndpointTest;
import io.metaloom.loom.rest.model.asset.AssetCreateRequest;
import io.metaloom.loom.rest.model.asset.AssetListResponse;
import io.metaloom.loom.rest.model.asset.AssetResponse;
import io.metaloom.loom.rest.model.asset.AssetUpdateRequest;

public class AssetEndpointTest extends AbstractCRUDEndpointTest {

	@Override
	protected void testCreate(LoomHttpClient client) throws HttpErrorException {
		AssetCreateRequest request = new AssetCreateRequest();
		request.setFilename("test.png");
		request.setLocalPath("/tmp/test.png");
		client.storeAsset(request).sync();
	}

	@Override
	protected void testRead(LoomHttpClient client) throws HttpErrorException {
		AssetResponse response = client.loadAsset(ASSET_UUID).sync();
		assertNotNull(response);
	}

	@Override
	protected void testDelete(LoomHttpClient client) throws HttpErrorException {
		client.deleteAsset(ASSET_UUID).sync();
		expect(404, "Not Found", client.loadAsset(ASSET_UUID));
	}

	@Override
	protected void testUpate(LoomHttpClient client) throws HttpErrorException {
		final String NEW_NAME = "the_new_local_path.jpg";
		AssetUpdateRequest request = new AssetUpdateRequest();
		request.setLocalPath(NEW_NAME);
		AssetResponse response = client.updateAsset(ASSET_UUID, request).sync();
		assertEquals(NEW_NAME, response.getLocations().get(0).getPath());

		AssetResponse loadResponse = client.loadAsset(ASSET_UUID).sync();
		assertEquals(NEW_NAME, loadResponse.getLocations().get(0).getPath());
	}

	@Override
	protected void testReadPage(LoomHttpClient client) throws HttpErrorException {
		for (int i = 0; i < 100; i++) {
			AssetCreateRequest request = new AssetCreateRequest();
			request.setFilename("test_" + i + ".png");
			request.setLocalPath("/tmp/test_" + i + ".png");
			client.storeAsset(request).sync();
		}

		AssetListResponse response = client.listAssets().sync();
		assertNotNull(response);
	}

}