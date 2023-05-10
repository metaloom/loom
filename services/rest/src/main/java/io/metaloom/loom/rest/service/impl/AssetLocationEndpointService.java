package io.metaloom.loom.rest.service.impl;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.model.asset.AssetLocationDao;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.service.AbstractEndpointService;

@Singleton
public class AssetLocationEndpointService extends AbstractEndpointService {

	private final AssetLocationDao assetLocationDao;

	@Inject
	public AssetLocationEndpointService(AssetLocationDao assetLocationDao, LoomModelBuilder modelBuilder) {
		super(modelBuilder);
		this.assetLocationDao = assetLocationDao;
	}
}
