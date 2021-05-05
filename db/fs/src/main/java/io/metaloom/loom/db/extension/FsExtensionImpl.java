package io.metaloom.loom.db.extension;

import io.metaloom.loom.db.fs.AbstractFSCUDElement;

public class FsExtensionImpl extends AbstractFSCUDElement implements Extension {

	private String url;

	@Override
	public String getURL() {
		return url;
	}

	@Override
	public Extension setURL(String url) {
		this.url = url;
		return this;
	}

}
