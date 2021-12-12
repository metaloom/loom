package io.metaloom.loom.db.jooq.dao.group;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.jooq.JSONB;

import io.metaloom.loom.db.model.group.Group;
import io.metaloom.loom.db.model.user.LoomUser;
import io.vertx.core.json.JsonObject;

public class GroupImpl implements Group {

	private io.metaloom.loom.db.jooq.tables.pojos.Group pojo;

	public GroupImpl() {
	}

	public GroupImpl(io.metaloom.loom.db.jooq.tables.pojos.Group pojo) {
		this.pojo = pojo;
	}

	@Override
	public Group setEditor(LoomUser editor) {
		pojo.setEditorUuid(editor.getUuid());
		return this;
	}

	@Override
	public Group setCreator(LoomUser creator) {
		pojo.setCreatorUuid(creator.getUuid());
		return this;
	}

	@Override
	public LocalDateTime getEdited() {
		return pojo.getEdited();
	}

	@Override
	public Group setEdited(LocalDateTime edate) {
		pojo.setEdited(edate);
		return this;
	}

	@Override
	public LocalDateTime getCreated() {
		return pojo.getCreated();
	}

	@Override
	public Group setCreated(LocalDateTime cdate) {
		pojo.setCreated(cdate);
		return this;
	}

	@Override
	public UUID getUuid() {
		return pojo.getUuid();
	}

	@Override
	public Group setUuid(UUID uuid) {
		pojo.setUuid(uuid);
		return this;
	}

	@Override
	public JsonObject getMeta() {
		return new JsonObject(pojo.getMeta().data());
	}

	@Override
	public Group setMeta(JsonObject meta) {
		pojo.setMeta(JSONB.jsonb(meta.encode()));
		return this;
	}

	@Override
	public String getName() {
		return pojo.getName();
	}

	@Override
	public Group setName(String name) {
		pojo.setName(name);
		return this;
	}

	@Override
	public List<LoomUser> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group setUsers(List<LoomUser> users) {
		// TODO Auto-generated method stub
		return null;
	}

}
