package io.metaloom.loom.core.endpoint;

import io.metaloom.loom.client.http.LoomHttpClient;
import io.metaloom.loom.test.TestValues;

public interface EndpointTest extends TestValues {

	LoomHttpClient httpClient();

}
