package io.metaloom.loom.rest.model.asset.location;

import io.metaloom.loom.rest.model.example.ExampleValues;

public interface AssetLocationExamples extends ExampleValues {

	default AssetLocationResponse locationResponse() {
		AssetLocationResponse model = new AssetLocationResponse();
		model.setFilesystem(new AssetLocationFilesystemInfo().setFilekey(new FileKey().setInode(42L).setStDev(12L)).setLastSeen(DATE_NEW)
			.setPath("/the-current-path/bigbuckbunny-4k.mp4"));
		model.setS3(new AssetS3Meta().setBucket("big_bucket").setObjectPath("themovie"));
		return model;
	}

	default AssetLocationListResponse locationListResponse() {
		AssetLocationListResponse model = new AssetLocationListResponse();
		model.setMetainfo(pagingInfo());
		model.add(locationResponse());
		model.add(locationResponse());
		return model;
	}

	default AssetLocationUpdateRequest locationUpdateRequest() {
		AssetLocationUpdateRequest model = new AssetLocationUpdateRequest();
		
		return model;
	}

	default AssetLocationReference locationReference() {
		AssetLocationReference model = new AssetLocationReference();
		model.setUuid(uuidC());
		model.setPath("/the-current-path/bigbuckbunny-4k.mp4");
		return model;
	}
}
