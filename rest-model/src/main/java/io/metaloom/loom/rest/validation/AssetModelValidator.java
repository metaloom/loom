package io.metaloom.loom.rest.validation;

import io.metaloom.loom.rest.model.asset.AssetCreateRequest;
import io.metaloom.loom.rest.model.asset.AssetResponse;
import io.metaloom.loom.rest.model.asset.AssetUpdateRequest;

public interface AssetModelValidator extends ModelValidator {

	default void validate(AssetUpdateRequest request) {

	}

	default AssetResponse validate(AssetResponse response) {
		validateCreatorEditorResponse(response);
		return response;
	}

	default void validate(AssetCreateRequest request) {
		requireNonNull(request.getFile(), "The fileinfo must be set");
		requireNonNullOrEmpty(request.getFile().getMimeType(), "Mimetype must be set");
		requireNonNull(request.getFile().getSize(), "The filesize must be set");
		requireNonNull(request.getHashes(), "Hashes must be set");
		requireNonNull(request.getHashes().getSha512(), "The SHA512 checksum is required when creating an asset");
	}
}
