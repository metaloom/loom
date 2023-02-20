package io.metaloom.loom.db.jooq.dao.webhook;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqCUDElement;
import io.metaloom.loom.db.jooq.JooqWrapper;
import io.metaloom.loom.db.jooq.tables.pojos.Webhook;
import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.db.model.webhook.LoomWebhook;
import io.vertx.core.json.JsonObject;

public class LoomWebhookImpl extends AbstractJooqCUDElement implements LoomWebhook, JooqWrapper<Webhook> {

	private final Webhook delegate;

	public LoomWebhookImpl(Webhook delegate) {
		this.delegate = delegate;
	}

	@Override
	public String getURL() {
		return delegate.getUrl();
	}

	@Override
	public LoomWebhook setURL(String url) {
		delegate.setUrl(url);
		return this;
	}

	@Override
	public LocalDateTime getCreated() {
		return delegate.getCreated();
	}

	@Override
	public LoomWebhook setCreated(LocalDateTime cdate) {
		delegate.setCreated(cdate);
		return this;
	}

	@Override
	public LocalDateTime getEdited() {
		return delegate.getEdited();
	}

	@Override
	public LoomWebhook setEdited(LocalDateTime edate) {
		delegate.setEdited(edate);
		return this;
	}

	@Override
	public UUID getUuid() {
		return delegate.getUuid();
	}

	@Override
	public LoomWebhook setUuid(UUID uuid) {
		delegate.setUuid(uuid);
		return this;
	}

	@Override
	public LoomWebhook setCreator(LoomUser creator) {
		Objects.requireNonNull(creator, "Invalid creator provided");
		delegate.setCreatorUuid(creator.getUuid());
		return this;
	}

	@Override
	public LoomWebhook setEditor(LoomUser editor) {
		Objects.requireNonNull(editor, "Invalid editor provided");
		delegate.setEditorUuid(editor.getUuid());
		return this;
	}

	@Override
	public JsonObject getMeta() {
//		return new JsonObject(delegate.getMeta());
		return null;
	}

	@Override
	public LoomWebhook setMeta(JsonObject meta) {
//		delegate.setMeta(meta.encode());
		return this;
	}

	@Override
	public Webhook getDelegate() {
		return delegate;
	}

}
