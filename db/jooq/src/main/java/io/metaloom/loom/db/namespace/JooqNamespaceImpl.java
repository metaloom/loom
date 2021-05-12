package io.metaloom.loom.db.namespace;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqCUDElement;
import io.metaloom.loom.db.jooq.JooqWrapper;
import io.metaloom.loom.db.jooq.tables.pojos.Namespace;
import io.metaloom.loom.db.user.LoomUser;
import io.vertx.core.json.JsonObject;

public class JooqNamespaceImpl extends AbstractJooqCUDElement implements LoomNamespace, JooqWrapper<Namespace> {

	private final Namespace delegate;

	public JooqNamespaceImpl(Namespace delegate) {
		this.delegate = delegate;
	}

	@Override
	public String getName() {
		return delegate.getName();
	}

	@Override
	public LoomNamespace setName(String name) {
		delegate.setName(name);
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
	public LoomNamespace setUuid(UUID uuid) {
		delegate.setUuid(uuid);
		return this;
	}

	@Override
	public LoomNamespace setCdate(LocalDateTime cdate) {
		// TODO Auto-generated method stub
		return this;

	}

	@Override
	public LoomNamespace setCreator(LoomUser creator) {
		Objects.requireNonNull(creator, "Invalid creator provided");
		delegate.setCreatorUuid(creator.getUuid());
		return this;
	}

	@Override
	public LoomNamespace setEdate(LocalDateTime edate) {
		// delegate.setEdited();
		return this;
	}

	@Override
	public LoomNamespace setEditor(LoomUser editor) {
		Objects.requireNonNull(editor, "Invalid editor provided");
		delegate.setEditorUuid(editor.getUuid());
		return this;
	}

	@Override
	public JsonObject getMeta() {
		return new JsonObject(delegate.getMeta());
	}

	@Override
	public LoomNamespace setMeta(JsonObject meta) {
		delegate.setMeta(meta.encode());
		return this;
	}

	@Override
	public Namespace getDelegate() {
		return delegate;
	}

}
