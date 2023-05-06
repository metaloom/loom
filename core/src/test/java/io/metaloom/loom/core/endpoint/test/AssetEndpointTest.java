package io.metaloom.loom.core.endpoint.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import io.metaloom.loom.client.http.LoomHttpClient;
import io.metaloom.loom.client.http.impl.HttpErrorException;
import io.metaloom.loom.core.endpoint.AbstractEndpointTest;
import io.metaloom.loom.core.endpoint.CRUDEndpointTestcases;
import io.metaloom.loom.rest.model.asset.AssetCreateRequest;
import io.metaloom.loom.rest.model.asset.AssetListResponse;
import io.metaloom.loom.rest.model.asset.AssetResponse;

public class AssetEndpointTest extends AbstractEndpointTest implements CRUDEndpointTestcases {

	@Test
	public void testBasics() throws HttpErrorException {
		try (LoomHttpClient client = httpClient()) {
			AssetCreateRequest request = new AssetCreateRequest();
			request.setFilename("test.png");
			request.setLocalPath("/tmp/test.png");
			client.storeAsset(request).sync();

			client.deleteAsset(UUID.randomUUID()).sync();

			AssetResponse assetResponse = client.loadAsset(UUID.randomUUID()).sync();
			assertNotNull(assetResponse);

			AssetListResponse assets = client.listAssets().sync();
			assertNotNull(assets);

		}
	}

	
}
