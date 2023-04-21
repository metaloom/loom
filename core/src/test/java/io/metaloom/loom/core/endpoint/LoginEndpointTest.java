package io.metaloom.loom.core.endpoint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import io.metaloom.loom.client.http.LoomHttpClient;
import io.metaloom.loom.core.LoomCoreTestExtension;
import io.metaloom.loom.rest.model.auth.AuthLoginResponse;
import io.metaloom.loom.rest.model.user.UserResponse;

public class LoginEndpointTest {

	@RegisterExtension
	LoomCoreTestExtension loom = new LoomCoreTestExtension();

	@Test
	public void testBasics() throws Exception {
		try (LoomHttpClient client = loom.httpClient()) {
			AuthLoginResponse response = client.login("joedoe", "password").sync();
			System.out.println("Got Token: " + response.getToken());
			client.setToken(response.getToken());
			UserResponse response2 = client.loadUser("admin").sync();
			assertEquals("admin", response2.getUsername());
			assertNotNull(response2);
		}
	}
}
