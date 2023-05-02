package io.metaloom.loom.db.jooq.dao.asset;

import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractEditableElement;
import io.metaloom.loom.db.model.asset.Asset;

public class AssetImpl extends AbstractEditableElement<Asset> implements Asset {

	private String path;

	private UUID binaryUuid;

	@Override
	public String getPath() {
		return path;
	}

	@Override
	public Asset setPath(String path) {
		this.path = path;
		return this;
	}

	@Override
	public UUID getBinaryUuid() {
		return binaryUuid;
	}

	@Override
	public Asset setBinaryUuid(UUID binaryUuid) {
		this.binaryUuid = binaryUuid;
		return this;
	}

	@Override
	public String toString() {
		return String.format("Asset [%s] - %s", getUuid(), getPath());
	}

}
