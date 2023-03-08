package io.metaloom.loom.db.jooq.dao.namespace;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.jooq.tables.pojos.JooqNamespace;
import io.metaloom.loom.db.jooq.wrapper.AbstractWrappedElement;
import io.metaloom.loom.db.model.namespace.LoomNamespace;
import io.metaloom.loom.db.model.user.LoomUser;
import io.vertx.core.json.JsonObject;

public class LoomNamespaceImpl extends AbstractWrappedElement<JooqNamespace> implements LoomNamespace {

	public LoomNamespaceImpl(JooqNamespace delegate) {
		super(delegate);
	}

	@Override
	public String getName() {
		return delegate().getName();
	}

	@Override
	public LoomNamespace setName(String name) {
		delegate().setName(name);
		return this;
	}

	@Override
	public LocalDateTime getCreated() {
		return delegate().getCreated();
	}

	@Override
	public LocalDateTime getEdited() {
		return delegate().getEdited();
	}

	@Override
	public UUID getUuid() {
		return delegate().getUuid();
	}

	@Override
	public LoomNamespace setUuid(UUID uuid) {
		delegate().setUuid(uuid);
		return this;
	}

	@Override
	public LoomNamespace setCreated(LocalDateTime cdate) {
		delegate().setCreated(cdate);
		return this;
	}

	@Override
	public LoomNamespace setCreator(LoomUser creator) {
		Objects.requireNonNull(creator, "Invalid creator provided");
		delegate().setCreatorUuid(creator.getUuid());
		return this;
	}

	@Override
	public LoomNamespace setEdited(LocalDateTime edate) {
		delegate().setEdited(edate);
		return this;
	}

	@Override
	public LoomNamespace setEditor(LoomUser editor) {
		Objects.requireNonNull(editor, "Invalid editor provided");
		delegate().setEditorUuid(editor.getUuid());
		return this;
	}

	@Override
	public JsonObject getMeta() {
		// return new JsonObject(delegate.getMeta());
		return null;
	}

	@Override
	public LoomNamespace setMeta(JsonObject meta) {
		// delegate.setMeta(meta.encode());
		return this;
	}

}
