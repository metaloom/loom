package io.metaloom.loom.rest.builder;

import io.metaloom.loom.db.model.asset.Binary;
import io.metaloom.loom.db.page.Page;
import io.metaloom.loom.rest.model.binary.BinaryListResponse;
import io.metaloom.loom.rest.model.binary.BinaryResponse;

public interface BinaryModelBuilder extends ModelBuilder {

	default BinaryResponse toResponse(Binary binary) {
		BinaryResponse response = new BinaryResponse();
		response.getHashes().setSha512(binary.getSHA512());
		return response;
	}

	default BinaryListResponse toResponse(Page<Binary> page) {
		BinaryListResponse response = new BinaryListResponse();
		for (Binary binary : page) {
			response.add(toResponse(binary));
		}
		return response;
	}
}
