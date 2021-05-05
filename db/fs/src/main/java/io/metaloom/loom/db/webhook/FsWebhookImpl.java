package io.metaloom.loom.db.webhook;

import io.metaloom.loom.db.DaoCollection;
import io.metaloom.loom.db.fs.AbstractFSCUDElement;

public class FsWebhookImpl extends AbstractFSCUDElement implements Webhook {

	public FsWebhookImpl(DaoCollection daos) {
		super(daos);
	}

	private String url;

	@Override
	public String getURL() {
		return url;
	}

	@Override
	public Webhook setURL(String url) {
		this.url = url;
		return this;
	}

}
