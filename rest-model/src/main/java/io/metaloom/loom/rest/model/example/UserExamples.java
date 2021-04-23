package io.metaloom.loom.rest.model.example;

import io.metaloom.loom.rest.model.user.UserCreateRequest;
import io.metaloom.loom.rest.model.user.UserListResponse;
import io.metaloom.loom.rest.model.user.UserReference;
import io.metaloom.loom.rest.model.user.UserResponse;
import io.metaloom.loom.rest.model.user.UserUpdateRequest;

public class UserExamples extends AbstractExamples {

	public static UserResponse userResponse() {
		UserResponse model = new UserResponse();
		model.setUuid(uuidA());
		model.setUsername("joedoe");
		model.setEmail("joedoe@metaloom.io");
		model.setFirstname("Joe");
		model.setLastname("Doe");
		setCreatorEditor(model);
		return model;
	}

	public static UserUpdateRequest userUpdateRequest() {
		UserUpdateRequest model = new UserUpdateRequest();
		model.setUsername("joedoe");
		model.setEmail("joedoe@metaloom.io");
		model.setFirstname("Joe");
		model.setLastname("Doe");

		return model;
	}

	public static UserCreateRequest userCreateRequest() {
		UserCreateRequest model = new UserCreateRequest();
		model.setUsername("joedoe");
		model.setEmail("joedoe@metaloom.io");
		model.setFirstname("Joe");
		model.setLastname("Doe");
		return model;
	}

	public static UserReference userReference() {
		UserReference model = new UserReference();
		model.setUuid(uuidA());
		model.setName("joedoe");
		return model;
	}

	public static UserListResponse userListResponse() {
		UserListResponse model = new UserListResponse();
		model.setMetainfo(pagingInfo());
		model.add(userResponse());
		model.add(userResponse());
		return model;
	}
}
