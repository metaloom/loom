package io.metaloom.loom.core.endpoint.test;

import org.junit.jupiter.api.Test;

import io.metaloom.loom.client.http.LoomHttpClient;
import io.metaloom.loom.core.endpoint.AbstractEndpointTest;
import io.metaloom.loom.rest.model.asset.location.LocationCreateRequest;

public class AssetLocationEndpointTest extends AbstractEndpointTest {

	@Test
	public void testBasics() {
		try (LoomHttpClient client = httpClient()) {
			LocationCreateRequest request = new LocationCreateRequest();
			client.storeLocation(request);
		}
	}
}
