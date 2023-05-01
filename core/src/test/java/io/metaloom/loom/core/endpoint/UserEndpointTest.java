package io.metaloom.loom.core.endpoint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import io.metaloom.loom.client.http.LoomHttpClient;
import io.metaloom.loom.core.LoomCoreTestExtension;
import io.metaloom.loom.rest.model.auth.AuthLoginResponse;
import io.metaloom.loom.rest.model.user.UserCreateRequest;
import io.metaloom.loom.rest.model.user.UserListResponse;
import io.metaloom.loom.rest.model.user.UserResponse;

public class UserEndpointTest {

	@RegisterExtension
	LoomCoreTestExtension loom = new LoomCoreTestExtension();

	@Test
	public void testBasics() throws Exception {
		try (LoomHttpClient client = loom.httpClient()) {

			AuthLoginResponse authResponse = client.login("joedoe", "finger").sync();
			System.out.println("Got Token: " + authResponse.getToken());
			client.setToken(authResponse.getToken());

			UserResponse response = client.loadUser("joedoe").sync();
			assertNotNull(response);

			for (int i = 0; i < 100; i++) {
				UserCreateRequest userRequest = new UserCreateRequest();
				userRequest.setUsername("user_" + i);
				client.createUser(userRequest).sync();
			}

			UserListResponse listResponse = client.listUsers().sync();
			assertEquals(25, listResponse.getData().size(), "There should have been 25 users loaded");

			UUID uuid = listResponse.getData().get(0).getUuid();
			client.deleteUser(uuid).sync();

		}
	}

}
