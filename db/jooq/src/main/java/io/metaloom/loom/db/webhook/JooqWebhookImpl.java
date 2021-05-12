package io.metaloom.loom.db.webhook;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.LoomElement;
import io.metaloom.loom.db.group.LoomGroup;
import io.metaloom.loom.db.jooq.AbstractJooqCUDElement;
import io.metaloom.loom.db.jooq.JooqWrapper;
import io.metaloom.loom.db.jooq.tables.pojos.Webhook;
import io.metaloom.loom.db.user.LoomUser;
import io.vertx.core.json.JsonObject;

public class JooqWebhookImpl extends AbstractJooqCUDElement implements LoomWebhook, JooqWrapper<Webhook> {

	private final Webhook delegate;

	public JooqWebhookImpl(Webhook delegate) {
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
	public LocalDateTime getCdate() {
		return delegate.getCreated();
	}

	@Override
	public LocalDateTime getEdate() {
		return delegate.getEdited();
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
	public LoomWebhook setCdate(LocalDateTime cdate) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public LoomWebhook setCreator(LoomUser creator) {
		Objects.requireNonNull(creator, "Invalid creator provided");
		delegate.setCreatorUuid(creator.getUuid());
		return this;
	}

	@Override
	public LoomWebhook setEdate(LocalDateTime edate) {
		// delegate.setEdited();
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
		return new JsonObject(delegate.getMeta());
	}

	@Override
	public LoomWebhook setMeta(JsonObject meta) {
		delegate.setMeta(meta.encode());
		return this;
	}

	@Override
	public Webhook getDelegate() {
		return delegate;
	}

}
