package io.metaloom.loom.db.webhook;

import io.metaloom.loom.db.CUDElement;

public interface LoomWebhook extends CUDElement {

	String getURL();

	LoomWebhook setURL(String url);
}
