package io.metaloom.loom.db.asset;

import java.util.ArrayList;
import java.util.List;

import io.metaloom.loom.db.fs.AbstractFSCUDElement;
import io.metaloom.loom.db.tag.LoomTag;

public class FsAssetImpl extends AbstractFSCUDElement implements LoomAsset {

	private String name;

	private List<LoomTag> tags = new ArrayList<>();

	@Override
	public String getFilename() {
		return name;
	}

	@Override
	public LoomAsset setFilename(String name) {
		this.name = name;
		return this;
	}

}
