package io.metaloom.loom.rest.validation;

import io.metaloom.loom.rest.model.user.UserCreateRequest;
import io.metaloom.loom.rest.model.user.UserResponse;
import io.metaloom.loom.rest.model.user.UserUpdateRequest;

public interface UserModelValidator extends ModelValidator {

	default void validate(UserUpdateRequest request) {

	}

	default void validate(UserResponse response) {

	}

	default void validate(UserCreateRequest request) {

	}
}
