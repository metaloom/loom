package io.metaloom.loom.rest.model.example;

import static io.metaloom.loom.rest.model.example.ModelTestHelper.assertModel;
import static io.metaloom.loom.rest.model.example.UserExamples.userCreateRequest;
import static io.metaloom.loom.rest.model.example.UserExamples.userListResponse;
import static io.metaloom.loom.rest.model.example.UserExamples.userReference;
import static io.metaloom.loom.rest.model.example.UserExamples.userResponse;
import static io.metaloom.loom.rest.model.example.UserExamples.userUpdateRequest;

import org.junit.jupiter.api.Test;

public class UserModelTest implements ModelTestcases{

	
	@Test
	@Override
	public void testResponse() {
		assertModel(userResponse(), "UserResponse");
	}

	@Test
	@Override
	public void testCreateRequest() {
		assertModel(userCreateRequest(), "UserCreateRequest");
	}

	@Test
	@Override
	public void testUpdateRequest() {
		assertModel(userUpdateRequest(), "UserUpdateRequest");
	}

	@Test
	@Override
	public void testReference() {
		assertModel(userReference(), "UserReference");
	}

	@Test
	@Override
	public void testListResponse() {
		assertModel(userListResponse(), "UserListResponse");
	}
}
