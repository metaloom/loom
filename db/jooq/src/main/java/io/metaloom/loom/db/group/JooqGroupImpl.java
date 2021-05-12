package io.metaloom.loom.db.group;

import java.time.LocalDateTime;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqCUDElement;
import io.metaloom.loom.db.jooq.JooqWrapper;
import io.metaloom.loom.db.jooq.tables.pojos.Group;
import io.metaloom.loom.db.user.LoomUser;
import io.vertx.core.json.JsonObject;

public class JooqGroupImpl extends AbstractJooqCUDElement implements LoomGroup, JooqWrapper<Group> {

	private final Group delegate;

	public JooqGroupImpl(Group delegate) {
		this.delegate = delegate;
	}

	@Override
	public String getName() {
		return delegate.getName();
	}

	@Override
	public LoomGroup setName(String name) {
		delegate.setName(name);
		return this;
	}

	@Override
	public LocalDateTime getCreated() {
		return delegate.getCreated();
	}

	@Override
	public LocalDateTime getEdited() {
		return delegate.getEdited();
	}

	@Override
	public UUID getUuid() {
		return delegate.getUuid();
	}

	@Override
	public LoomGroup setUuid(UUID uuid) {
		delegate.setUuid(uuid);
		return this;
	}

	@Override
	public LoomGroup setCreated(LocalDateTime cdate) {
		delegate.setCreated(cdate);
		return this;
	}

	@Override
	public LoomGroup setCreator(LoomUser creator) {
		delegate.setCreatorUuid(creator.getUuid());
		return this;
	}

	@Override
	public LoomGroup setEdited(LocalDateTime edate) {
		delegate.setEdited(edate);
		return this;
	}

	@Override
	public LoomGroup setEditor(LoomUser editor) {
		delegate.setEditorUuid(editor.getUuid());
		return this;
	}

	@Override
	public JsonObject getMeta() {
		return new JsonObject(delegate.getMeta());
	}

	@Override
	public LoomGroup setMeta(JsonObject meta) {
		delegate.setMeta(meta.encode());
		return this;
	}

	@Override
	public Group getDelegate() {
		return delegate;
	}

}
