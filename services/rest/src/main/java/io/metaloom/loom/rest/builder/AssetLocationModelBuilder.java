package io.metaloom.loom.rest.builder;

import io.metaloom.loom.db.model.asset.AssetLocation;
import io.metaloom.loom.db.page.Page;
import io.metaloom.loom.rest.model.asset.location.FileKey;
import io.metaloom.loom.rest.model.asset.location.LocationFilesystemInfo;
import io.metaloom.loom.rest.model.asset.location.LocationListResponse;
import io.metaloom.loom.rest.model.asset.location.LocationReference;
import io.metaloom.loom.rest.model.asset.location.AssetLocationResponse;

public interface AssetLocationModelBuilder extends ModelBuilder {

	default AssetLocationResponse toResponse(AssetLocation location) {
		AssetLocationResponse model = new AssetLocationResponse();
		model.setMeta(location.getMeta());
		model.setUuid(location.getUuid());
		model.setFilesystem(filesystemLocationInfo(location));
		return model;
	}

	default LocationFilesystemInfo filesystemLocationInfo(AssetLocation location) {
		LocationFilesystemInfo model = new LocationFilesystemInfo();
		// location.setLastSeen(asset.getLastSeen());
		model.setPath(location.getPath());
		model.setFilekey(assetFilekey(location));
		return model;
	}

	default LocationReference toReference(AssetLocation location) {
		LocationReference model = new LocationReference();
		model.setPath(location.getPath());
		model.setUuid(location.getUuid());
		return model;
	}

	default FileKey assetFilekey(AssetLocation asset) {
		FileKey key = new FileKey();
		key.setInode(asset.getFilekeyInode());
		key.setStDev(asset.getFilekeyStDev());
		key.setEDate(asset.getFilekeyEdate());
		key.setEDateNano(asset.getFilekeyEdateNano());
		return key;
	}

	default LocationListResponse toLocationList(Page<AssetLocation> page) {
		return setPage(new LocationListResponse(), page, location -> {
			return toResponse(location);
		});
	}

}
