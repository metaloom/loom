package io.metaloom.loom.rest.model.user;

import io.metaloom.loom.rest.model.example.ExampleValues;

public interface UserExamples extends ExampleValues {

	default UserResponse userResponse() {
		UserResponse model = new UserResponse();
		model.setUuid(uuidA());
		model.setUsername("joedoe");
		model.setEmail("joedoe@metaloom.io");
		model.setFirstname("Joe");
		model.setLastname("Doe");
		model.setMeta(meta());
		setCreatorEditor(model);
		return model;
	}

	default UserUpdateRequest userUpdateRequest() {
		UserUpdateRequest model = new UserUpdateRequest();
		model.setUsername("joedoe");
		model.setEmail("joedoe@metaloom.io");
		model.setFirstname("Joe");
		model.setLastname("Doe");
		model.setMeta(meta());
		return model;
	}

	default UserCreateRequest userCreateRequest() {
		UserCreateRequest model = new UserCreateRequest();
		model.setUsername("joedoe");
		model.setEmail("joedoe@metaloom.io");
		model.setFirstname("Joe");
		model.setLastname("Doe");
		model.setMeta(meta());
		return model;
	}

	default UserReference userReference() {
		UserReference model = new UserReference();
		model.setUuid(uuidA());
		model.setName("joedoe");
		return model;
	}

	default UserListResponse userListResponse() {
		UserListResponse model = new UserListResponse();
		model.setMetainfo(pagingInfo());
		model.add(userResponse());
		model.add(userResponse());
		return model;
	}
}
