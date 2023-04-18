package io.metaloom.loom.rest.model.example;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import io.metaloom.loom.rest.model.user.UserResponse;

public class UserModelTest extends AbstractModelTest {

	@Test
	public void testUserResponseRequestModel() {
		UserResponse response = load("user/user-response", UserResponse.class);
		assertNotNull(response);
	}
}
