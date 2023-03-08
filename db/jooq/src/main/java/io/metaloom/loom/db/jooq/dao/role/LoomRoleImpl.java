package io.metaloom.loom.db.jooq.dao.role;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.jooq.tables.pojos.JooqRole;
import io.metaloom.loom.db.jooq.wrapper.AbstractWrappedElement;
import io.metaloom.loom.db.jooq.wrapper.JooqWrapper;
import io.metaloom.loom.db.model.role.LoomRole;
import io.metaloom.loom.db.model.user.LoomUser;
import io.vertx.core.json.JsonObject;

public class LoomRoleImpl extends AbstractWrappedElement<JooqRole> implements LoomRole, JooqWrapper<JooqRole> {

	public LoomRoleImpl(JooqRole delegate) {
		super(delegate);
	}

	@Override
	public String getName() {
		return delegate().getName();
	}

	@Override
	public LoomRole setName(String name) {
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
	public LoomRole setUuid(UUID uuid) {
		delegate().setUuid(uuid);
		return this;
	}

	@Override
	public LoomRole setCreated(LocalDateTime cdate) {
		delegate().setCreated(cdate);
		return this;
	}

	@Override
	public JsonObject getMeta() {
		// return new JsonObject(delegate().getMeta());
		return null;
	}

	@Override
	public LoomRole setMeta(JsonObject meta) {
		// delegate().setMeta(meta.encode());
		return this;
	}

	@Override
	public LoomRole setCreator(LoomUser creator) {
		Objects.requireNonNull(creator, "Invalid creator specified.");
		delegate().setCreatorUuid(creator.getUuid());
		return this;
	}

	@Override
	public LoomRole setEdited(LocalDateTime edate) {
		delegate().setEdited(edate);
		return this;
	}

	@Override
	public LoomRole setEditor(LoomUser editor) {
		Objects.requireNonNull(editor, "Invalid editor specified.");
		delegate().setEditorUuid(editor.getUuid());
		return this;
	}

}
