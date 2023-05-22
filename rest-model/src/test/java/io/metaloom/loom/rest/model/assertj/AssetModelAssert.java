package io.metaloom.loom.rest.model.assertj;

import io.metaloom.loom.rest.model.asset.AssetResponse;
import io.metaloom.loom.rest.validation.LoomModelValidator;
import io.metaloom.loom.rest.validation.impl.LoomModelValidatorImpl;

public class AssetModelAssert  extends AbstractModelAssert<AssetModelAssert, AssetResponse> {

	private LoomModelValidator validator = new LoomModelValidatorImpl();

	public AssetModelAssert(AssetResponse actual) {
		super(actual, AssetModelAssert.class);
	}

	public AssetModelAssert isValid() {
		validator.validate(actual);
		return this;
	}



}
