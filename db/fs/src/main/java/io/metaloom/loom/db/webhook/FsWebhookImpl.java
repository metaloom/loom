package io.metaloom.loom.db.webhook;

import io.metaloom.loom.db.fs.AbstractFSCUDElement;

public class FsWebhookImpl extends AbstractFSCUDElement implements LoomWebhook {

	private String url;

	@Override
	public String getURL() {
		return url;
	}

	@Override
	public LoomWebhook setURL(String url) {
		this.url = url;
		return this;
	}

}
