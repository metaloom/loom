package io.metaloom.loom.rest.validation;

import io.metaloom.loom.rest.model.asset.AssetCreateRequest;
import io.metaloom.loom.rest.model.asset.AssetResponse;
import io.metaloom.loom.rest.model.asset.AssetUpdateRequest;

public interface AssetModelValidator extends ModelValidator {

	default void validate(AssetUpdateRequest request) {

	}

	default void validate(AssetResponse response) {

	}

	default void validate(AssetCreateRequest request) {

	}
}
