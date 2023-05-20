package io.metaloom.loom.rest.model.asset.location;

import io.metaloom.loom.rest.model.example.ExampleValues;

public interface AssetLocationExamples extends ExampleValues {

	default AssetLocationResponse locationResponse() {
		AssetLocationResponse model = new AssetLocationResponse();
		model.setFilesystem(new LocationFilesystemInfo().setFilekey(new FileKey().setInode(42).setStDev(12)).setLastSeen(DATE_NEW)
			.setPath("/the-current-path/bigbuckbunny-4k.mp4"));
		model.setS3(new AssetS3Meta().setBucket("big_bucket").setObjectPath("themovie"));
		return model;
	}

	default LocationListResponse locationListResponse() {
		LocationListResponse model = new LocationListResponse();
		model.setMetainfo(pagingInfo());
		model.add(locationResponse());
		model.add(locationResponse());
		return model;
	}

	default AssetLocationUpdateRequest locationUpdateRequest() {
		AssetLocationUpdateRequest model = new AssetLocationUpdateRequest();
		
		return model;
	}

	default LocationReference locationReference() {
		LocationReference model = new LocationReference();
		model.setUuid(uuidC());
		model.setPath("/the-current-path/bigbuckbunny-4k.mp4");
		return model;
	}
}
