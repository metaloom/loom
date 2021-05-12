package io.metaloom.loom.db.role;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.LoomElement;
import io.metaloom.loom.db.jooq.AbstractJooqCUDElement;
import io.metaloom.loom.db.jooq.JooqWrapper;
import io.metaloom.loom.db.jooq.tables.pojos.Role;
import io.metaloom.loom.db.user.LoomUser;
import io.vertx.core.json.JsonObject;

public class JooqRoleImpl extends AbstractJooqCUDElement implements LoomRole, JooqWrapper<Role> {

	private final Role delegate;

	public JooqRoleImpl(Role delegate) {
		this.delegate = delegate;
	}

	@Override
	public String getName() {
		return delegate.getName();
	}

	@Override
	public LoomRole setName(String name) {
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
	public LoomRole setUuid(UUID uuid) {
		delegate.setUuid(uuid);
		return this;
	}

	@Override
	public LoomRole setCdate(LocalDateTime cdate) {
		delegate.setCreated(cdate);
		return this;
	}

	@Override
	public JsonObject getMeta() {
		return new JsonObject(delegate.getMeta());
	}

	@Override
	public LoomRole setMeta(JsonObject meta) {
		delegate.setMeta(meta.encode());
		return this;
	}

	@Override
	public LoomRole setCreator(LoomUser creator) {
		Objects.requireNonNull(creator, "Invalid creator specified.");
		delegate.setCreatorUuid(creator.getUuid());
		return this;
	}

	@Override
	public LoomRole setEdate(LocalDateTime edate) {
		delegate.setEdited(edate);
		return this;
	}

	@Override
	public LoomRole setEditor(LoomUser editor) {
		Objects.requireNonNull(editor, "Invalid editor specified.");
		delegate.setEditorUuid(editor.getUuid());
		return this;
	}

	@Override
	public Role getDelegate() {
		return delegate;
	}

}
