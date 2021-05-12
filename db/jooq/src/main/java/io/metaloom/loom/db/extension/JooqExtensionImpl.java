package io.metaloom.loom.db.extension;

import java.time.LocalDateTime;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqCUDElement;
import io.metaloom.loom.db.jooq.JooqWrapper;
import io.metaloom.loom.db.jooq.tables.pojos.Extension;
import io.metaloom.loom.db.user.LoomUser;
import io.vertx.core.json.JsonObject;

public class JooqExtensionImpl extends AbstractJooqCUDElement implements LoomExtension, JooqWrapper<Extension> {

	private final Extension delegate;

	public JooqExtensionImpl(Extension delegate) {
		this.delegate = delegate;
	}

	@Override
	public String getURL() {
		return delegate.getUrl();
	}

	@Override
	public LoomExtension setURL(String url) {
		delegate.setUrl(url);
		return this;
	}

	@Override
	public JsonObject getMeta() {
		return new JsonObject(delegate.getMeta());
	}

	@Override
	public LoomExtension setMeta(JsonObject meta) {
		this.delegate.setMeta(meta.encode());
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
	public LoomExtension setUuid(UUID uuid) {
		delegate.setUuid(uuid);
		return this;
	}

	@Override
	public LoomExtension setCdate(LocalDateTime cdate) {
		return this;
	}

	@Override
	public LoomExtension setCreator(LoomUser creator) {
		return this;
	}

	@Override
	public LoomExtension setEdate(LocalDateTime edate) {
		return this;
	}

	@Override
	public LoomExtension setEditor(LoomUser editor) {
		return this;
	}

	@Override
	public Extension getDelegate() {
		return delegate;
	}

}
