package io.metaloom.loom.core.endpoint;

import org.junit.jupiter.api.extension.RegisterExtension;

import io.metaloom.loom.client.http.LoomHttpClient;
import io.metaloom.loom.client.http.impl.HttpErrorException;
import io.metaloom.loom.core.LoomCoreTestExtension;
import io.metaloom.loom.rest.model.auth.AuthLoginResponse;

public abstract class AbstractEndpointTest implements EndpointTest {

	@RegisterExtension
	protected LoomCoreTestExtension loom = new LoomCoreTestExtension();

	@Override
	public LoomHttpClient httpClient() {
		return loom.httpClient();
	}
	
	public void loginAdmin(LoomHttpClient client) throws HttpErrorException {
		AuthLoginResponse loginResponse = client.login("admin", "finger").sync();
		client.setToken(loginResponse.getToken());
		
	}
}
