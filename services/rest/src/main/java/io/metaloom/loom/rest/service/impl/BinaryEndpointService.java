package io.metaloom.loom.rest.service.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.model.binary.BinaryDao;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.service.AbstractEndpointService;

@Singleton
public class BinaryEndpointService extends AbstractEndpointService {

	private final BinaryDao binaryDao;

	@Inject
	public BinaryEndpointService(BinaryDao binaryDao, LoomModelBuilder modelBuilder) {
		super(modelBuilder);
		this.binaryDao = binaryDao;
	}
}
