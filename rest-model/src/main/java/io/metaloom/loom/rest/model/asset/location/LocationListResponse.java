package io.metaloom.loom.rest.model.asset.location;

import io.metaloom.loom.rest.model.common.AbstractListResponse;

public class LocationListResponse extends AbstractListResponse<LocationListResponse, LocationResponse> {

	@Override
	public LocationListResponse self() {
		return this;
	}

}
