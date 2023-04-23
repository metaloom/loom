package io.metaloom.loom.db.jooq.dao.group;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.jooq.JSONB;

import io.metaloom.loom.db.jooq.tables.pojos.JooqGroup;
import io.metaloom.loom.db.jooq.wrapper.AbstractWrappedElement;
import io.metaloom.loom.db.model.group.Group;
import io.metaloom.loom.db.model.user.User;
import io.vertx.core.json.JsonObject;

public class GroupImpl extends AbstractWrappedElement<JooqGroup> implements Group {

	public GroupImpl(JooqGroup delegate) {
		super(delegate);
	}

	@Override
	public Group setEditor(User editor) {
		delegate().setEditorUuid(editor.getUuid());
		return this;
	}

	@Override
	public Group setCreator(User creator) {
		delegate().setCreatorUuid(creator.getUuid());
		return this;
	}

	@Override
	public LocalDateTime getEdited() {
		return delegate().getEdited();
	}

	@Override
	public Group setEdited(LocalDateTime edate) {
		delegate().setEdited(edate);
		return this;
	}

	@Override
	public LocalDateTime getCreated() {
		return delegate().getCreated();
	}

	@Override
	public Group setCreated(LocalDateTime cdate) {
		delegate().setCreated(cdate);
		return this;
	}

	@Override
	public UUID getUuid() {
		return delegate().getUuid();
	}

	@Override
	public Group setUuid(UUID uuid) {
		delegate().setUuid(uuid);
		return this;
	}

	@Override
	public JsonObject getMeta() {
		return new JsonObject(delegate().getMeta().data());
	}

	@Override
	public Group setMeta(JsonObject meta) {
		delegate().setMeta(JSONB.jsonb(meta.encode()));
		return this;
	}

	@Override
	public String getName() {
		return delegate().getName();
	}

	@Override
	public Group setName(String name) {
		delegate().setName(name);
		return this;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group setUsers(List<User> users) {
		// TODO Auto-generated method stub
		return null;
	}

}
