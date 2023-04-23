package io.metaloom.loom.db.jooq.dao.group;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.jooq.JSONB;

import io.metaloom.loom.db.jooq.tables.pojos.JooqGroup;
import io.metaloom.loom.db.jooq.wrapper.AbstractWrappedElement;
import io.metaloom.loom.db.model.group.LoomGroup;
import io.metaloom.loom.db.model.user.LoomUser;
import io.vertx.core.json.JsonObject;

public class LoomGroupImpl extends AbstractWrappedElement<JooqGroup> implements LoomGroup {

	public LoomGroupImpl(JooqGroup delegate) {
		super(delegate);
	}

	@Override
	public LoomGroup setEditor(LoomUser editor) {
		delegate().setEditorUuid(editor.getUuid());
		return this;
	}

	@Override
	public LoomGroup setCreator(LoomUser creator) {
		delegate().setCreatorUuid(creator.getUuid());
		return this;
	}

	@Override
	public LocalDateTime getEdited() {
		return delegate().getEdited();
	}

	@Override
	public LoomGroup setEdited(LocalDateTime edate) {
		delegate().setEdited(edate);
		return this;
	}

	@Override
	public LocalDateTime getCreated() {
		return delegate().getCreated();
	}

	@Override
	public LoomGroup setCreated(LocalDateTime cdate) {
		delegate().setCreated(cdate);
		return this;
	}

	@Override
	public UUID getUuid() {
		return delegate().getUuid();
	}

	@Override
	public LoomGroup setUuid(UUID uuid) {
		delegate().setUuid(uuid);
		return this;
	}

	@Override
	public JsonObject getMeta() {
		return new JsonObject(delegate().getMeta().data());
	}

	@Override
	public LoomGroup setMeta(JsonObject meta) {
		delegate().setMeta(JSONB.jsonb(meta.encode()));
		return this;
	}

	@Override
	public String getName() {
		return delegate().getName();
	}

	@Override
	public LoomGroup setName(String name) {
		delegate().setName(name);
		return this;
	}

	@Override
	public List<LoomUser> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoomGroup setUsers(List<LoomUser> users) {
		// TODO Auto-generated method stub
		return null;
	}

}
