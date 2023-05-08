package io.metaloom.loom.rest.builder;

import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.asset.Binary;
import io.metaloom.loom.db.page.Page;
import io.metaloom.loom.rest.model.asset.AssetListResponse;
import io.metaloom.loom.rest.model.asset.AssetResponse;
import io.metaloom.loom.rest.model.binary.BinaryResponse;

public interface AssetModelBuilder extends ModelBuilder, BinaryModelBuilder {

	default AssetResponse toResponse(Asset asset) {
		AssetResponse response = new AssetResponse();
		Binary binary = daos().binaryDao().loadByUuid(asset.getBinaryUuid());
		BinaryResponse binaryResponse = toResponse(binary);
		response.setBinary(binaryResponse);
		response.setUuid(asset.getUuid());
		return response;
	}
	
	default AssetListResponse toAssetList(Page<Asset> page) {
		return setPage(new AssetListResponse(), page, asset -> {
			return toResponse(asset);
		});
	}

}
