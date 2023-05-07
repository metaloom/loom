package io.metaloom.loom.rest.builder;

import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.asset.Binary;
import io.metaloom.loom.rest.model.asset.AssetResponse;
import io.metaloom.loom.rest.model.asset.binary.BinaryResponse;

public interface AssetBuilder extends Builder, BinaryBuilder {

	default AssetResponse toResponse(Asset asset, Binary binary) {
		BinaryResponse binaryResponse = toResponse(binary);
		AssetResponse response = new AssetResponse();
		response.setBinary(binaryResponse);
		response.setUuid(asset.getUuid());
		return response;
	}

}
