package io.metaloom.loom.db.model.webhook;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.LoomMetaElement;

public interface LoomWebhook extends CUDElement, LoomMetaElement {

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
