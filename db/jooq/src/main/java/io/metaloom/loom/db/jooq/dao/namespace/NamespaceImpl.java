package io.metaloom.loom.db.jooq.dao.namespace;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.jooq.tables.pojos.JooqNamespace;
import io.metaloom.loom.db.jooq.wrapper.AbstractWrappedElement;
import io.metaloom.loom.db.model.namespace.Namespace;
import io.metaloom.loom.db.model.user.User;
import io.vertx.core.json.JsonObject;

public class NamespaceImpl extends AbstractWrappedElement<JooqNamespace> implements Namespace {

	public NamespaceImpl(JooqNamespace delegate) {
		super(delegate);
	}

	@Override
	public String getName() {
		return delegate().getName();
	}

	@Override
	public Namespace setName(String name) {
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
	public Namespace setUuid(UUID uuid) {
		delegate().setUuid(uuid);
		return this;
	}

	@Override
	public Namespace setCreated(LocalDateTime cdate) {
		delegate().setCreated(cdate);
		return this;
	}

	@Override
	public Namespace setCreator(User creator) {
		Objects.requireNonNull(creator, "Invalid creator provided");
		delegate().setCreatorUuid(creator.getUuid());
		return this;
	}

	@Override
	public Namespace setEdited(LocalDateTime edate) {
		delegate().setEdited(edate);
		return this;
	}

	@Override
	public Namespace setEditor(User editor) {
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
	public Namespace setMeta(JsonObject meta) {
		// delegate.setMeta(meta.encode());
		return this;
	}

}
