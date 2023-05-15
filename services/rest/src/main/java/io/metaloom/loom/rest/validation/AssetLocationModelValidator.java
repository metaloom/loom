package io.metaloom.loom.rest.validation;

import io.metaloom.loom.rest.model.asset.location.AssetLocationCreateRequest;
import io.metaloom.loom.rest.model.asset.location.AssetLocationResponse;
import io.metaloom.loom.rest.model.asset.location.AssetLocationUpdateRequest;

public interface AssetLocationModelValidator extends ModelValidator {

	default void validate(AssetLocationUpdateRequest request) {

	}

	default void validate(AssetLocationResponse response) {
		validateCreatorEditorResponse(response);
	}

	default void validate(AssetLocationCreateRequest request) {

	}
}
