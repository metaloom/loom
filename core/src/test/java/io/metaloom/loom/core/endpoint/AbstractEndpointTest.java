package io.metaloom.loom.core.endpoint;

import org.junit.jupiter.api.extension.RegisterExtension;

import io.metaloom.loom.client.http.LoomHttpClient;
import io.metaloom.loom.core.LoomCoreTestExtension;

public abstract class AbstractEndpointTest implements EndpointTest {

	@RegisterExtension
	protected LoomCoreTestExtension loom = new LoomCoreTestExtension();

	@Override
	public LoomHttpClient httpClient() {
		return loom.httpClient();
	}
}
