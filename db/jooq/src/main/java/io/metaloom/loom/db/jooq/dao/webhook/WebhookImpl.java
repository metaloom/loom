package io.metaloom.loom.db.jooq.dao.webhook;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.jooq.tables.pojos.JooqWebhook;
import io.metaloom.loom.db.jooq.wrapper.AbstractWrappedElement;
import io.metaloom.loom.db.jooq.wrapper.JooqWrapper;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.db.model.webhook.Webhook;
import io.vertx.core.json.JsonObject;

public class WebhookImpl extends AbstractWrappedElement<JooqWebhook> implements Webhook, JooqWrapper<JooqWebhook> {

	

	public WebhookImpl(JooqWebhook delegate) {
		super(delegate);
	}

	@Override
	public String getURL() {
		return delegate().getUrl();
	}

	@Override
	public Webhook setURL(String url) {
		delegate().setUrl(url);
		return this;
	}

	@Override
	public LocalDateTime getCreated() {
		return delegate().getCreated();
	}

	@Override
	public Webhook setCreated(LocalDateTime cdate) {
		delegate().setCreated(cdate);
		return this;
	}

	@Override
	public LocalDateTime getEdited() {
		return delegate().getEdited();
	}

	@Override
	public Webhook setEdited(LocalDateTime edate) {
		delegate().setEdited(edate);
		return this;
	}

	@Override
	public UUID getUuid() {
		return delegate().getUuid();
	}

	@Override
	public Webhook setUuid(UUID uuid) {
		delegate().setUuid(uuid);
		return this;
	}

	@Override
	public Webhook setCreator(User creator) {
		Objects.requireNonNull(creator, "Invalid creator provided");
		delegate().setCreatorUuid(creator.getUuid());
		return this;
	}

	@Override
	public Webhook setEditor(User editor) {
		Objects.requireNonNull(editor, "Invalid editor provided");
		delegate().setEditorUuid(editor.getUuid());
		return this;
	}

	@Override
	public JsonObject getMeta() {
//		return new JsonObject(delegate.getMeta());
		return null;
	}

	@Override
	public Webhook setMeta(JsonObject meta) {
//		delegate.setMeta(meta.encode());
		return this;
	}

	

}
