package io.metaloom.loom.rest.builder;

import io.metaloom.loom.db.model.asset.Binary;
import io.metaloom.loom.db.page.Page;
import io.metaloom.loom.rest.model.asset.HashInfo;
import io.metaloom.loom.rest.model.binary.BinaryListResponse;
import io.metaloom.loom.rest.model.binary.BinaryResponse;

public interface BinaryModelBuilder extends ModelBuilder, UserModelBuilder {

	default BinaryResponse toResponse(Binary binary) {
		BinaryResponse response = new BinaryResponse();
		response.setUuid(binary.getUuid());
		HashInfo hashes = new HashInfo();
		hashes.setSha512(binary.getSHA512());
		hashes.setSha256(binary.getSHA256());
		hashes.setMD5(binary.getMD5());
		response.setHashes(hashes);
		setStatus(binary, response);
		return response;
	}

	default BinaryListResponse toBinaryList(Page<Binary> page) {
		return setPage(new BinaryListResponse(), page, binary -> {
			return toResponse(binary);
		});
	}
}
