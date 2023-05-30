package io.metaloom.loom.core.endpoint;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.extension.RegisterExtension;

import io.metaloom.loom.client.http.LoomClientRequest;
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

	protected void expect(int statusCode, String statusMsg, LoomClientRequest<?> request) {
		try {
			request.sync();
			fail("The rquest should have failed with code " + statusCode + " and msg " + statusMsg + " but it succeeded.");
		} catch (HttpErrorException e) {
			assertEquals(statusCode, e.getStatusCode(), "The status code did not match");
			assertEquals(statusMsg, e.getStatusMsg(), "The status message did not match up");
			// TODO assert body
		}

	}
}
