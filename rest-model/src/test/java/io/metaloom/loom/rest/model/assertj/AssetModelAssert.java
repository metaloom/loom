package io.metaloom.loom.rest.model.assertj;

import io.metaloom.loom.rest.model.asset.AssetCreateRequest;
import io.metaloom.loom.rest.model.asset.AssetResponse;
import io.metaloom.loom.rest.validation.LoomModelValidator;
import io.metaloom.loom.rest.validation.impl.LoomModelValidatorImpl;

public class AssetModelAssert extends AbstractModelAssert<AssetModelAssert, AssetResponse> {

	private LoomModelValidator validator = new LoomModelValidatorImpl();

	public AssetModelAssert(AssetResponse actual) {
		super(actual, AssetModelAssert.class);
	}

	public AssetModelAssert isValid() {
		validator.validate(actual);
		return this;
	}

	public AssetModelAssert matches(AssetCreateRequest request) {
		assertJson(request.getMeta(), actual.getMeta(), "The meta information mismatch");
		assertJson(request.getHashes(), actual.getHashes(), "The hash information mismatch");
		assertJson(request.getAudio(), actual.getAudio(), "The audio information mismatch");
		assertJson(request.getVideo(), actual.getVideo(), "The video information mismatch");
		assertJson(request.getDocument(), actual.getDocument(), "The video information mismatch");
		assertJson(request.getImage(), actual.getImage(), "The image information mismatch");
		assertJson(request.getGeo(), actual.getGeo(), "The geo location information mismatch");
		assertJson(request.getFile(), actual.getFile(), "The file information mismatch");

		// timeline
		// tags
		// dominant color
		// views
		// origin 
		// localpath
		// social
		// collections
		// kind
		// processing status
		// first seen
		// locations

		return this;
	}

}
