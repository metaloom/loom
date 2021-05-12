package io.metaloom.loom.db.webhook;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.MetaElement;

public interface LoomWebhook extends CUDElement, MetaElement {

	/**
	 * Return the connection URL of the webhook.
	 * 
	 * @return
	 */
	String getURL();

	/**
	 * Set the connection URL for the webhook.
	 * 
	 * @param url
	 * @return Fluent API
	 */
	LoomWebhook setURL(String url);
}
