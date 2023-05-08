package io.metaloom.loom.rest.model.binary;

import io.metaloom.loom.rest.model.common.AbstractListResponse;

public class BinaryListResponse extends AbstractListResponse<BinaryListResponse, BinaryResponse> {

	@Override
	public BinaryListResponse self() {
		return this;
	}

}
