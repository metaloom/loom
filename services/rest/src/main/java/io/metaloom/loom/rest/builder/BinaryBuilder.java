package io.metaloom.loom.rest.builder;

import io.metaloom.loom.db.model.asset.Binary;
import io.metaloom.loom.rest.model.asset.binary.BinaryResponse;

public interface BinaryBuilder extends Builder {

	default BinaryResponse toResponse(Binary binary) {
		BinaryResponse response = new BinaryResponse();
		response.getHashes().setSha512(binary.getSHA512());
		return response;
	}
}
