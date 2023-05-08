package io.metaloom.loom.rest.service.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.model.asset.BinaryDao;

@Singleton
public class BinaryEndpointService {

	private final BinaryDao binaryDao;

	@Inject
	public BinaryEndpointService(BinaryDao binaryDao) {
		this.binaryDao = binaryDao;
	}
}
