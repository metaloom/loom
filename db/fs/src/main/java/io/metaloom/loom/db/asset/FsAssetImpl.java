package io.metaloom.loom.db.asset;

import java.util.ArrayList;
import java.util.List;

import io.metaloom.loom.db.fs.AbstractFSCUDElement;
import io.metaloom.loom.db.tag.Tag;

public class FsAssetImpl extends AbstractFSCUDElement implements Asset {

	private String name;

	private List<Tag> tags = new ArrayList<>();

	@Override
	public String getFilename() {
		return name;
	}

	@Override
	public Asset setFilename(String name) {
		this.name = name;
		return this;
	}

}
