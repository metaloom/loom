package io.metaloom.loom.core;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import io.metaloom.loom.client.http.LoomHttpClient;
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
		}
	}
}
