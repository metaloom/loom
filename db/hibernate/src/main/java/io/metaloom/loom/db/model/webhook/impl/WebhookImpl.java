package io.metaloom.loom.db.model.webhook.impl;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.metaloom.loom.db.LoomElement;
import io.metaloom.loom.db.model.AbstractCUDElement;
import io.metaloom.loom.db.model.webhook.Webhook;
import io.vertx.core.json.JsonObject;

@Entity
@Table(name = "webhooks")
public class WebhookImpl extends AbstractCUDElement implements Webhook {

	@Size(max = 128)
	private String url;

	public WebhookImpl(String url) {
		this.url = url;
	}

	@Override
	public String getURL() {
		return url;
	}

	@Override
	public Webhook setURL(String url) {
		this.url = url;
		return this;
	}

	@Override
	public JsonObject getMeta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoomElement setMeta(JsonObject meta) {
		// TODO Auto-generated method stub
		return null;
	}

}
