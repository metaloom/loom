package io.metaloom.loom.core;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import io.metaloom.loom.client.http.LoomHttpClient;
import io.metaloom.loom.rest.model.asset.AssetCreateRequest;
import io.metaloom.loom.rest.model.asset.AssetListResponse;
import io.metaloom.loom.rest.model.asset.AssetResponse;
import io.metaloom.loom.rest.model.user.UserResponse;

public class UserEndpointTest {

	@RegisterExtension
	LoomCoreTestExtension loom = new LoomCoreTestExtension();

	@Test
	public void testBasics() throws Exception {
		System.out.println("TEST");
		try (LoomHttpClient client = loom.httpClient()) {
			UserResponse response = client.getUserResponse().sync();
			assertNotNull(response);

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
