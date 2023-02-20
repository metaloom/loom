package io.metaloom.loom.db.jooq.dao.group;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.jooq.JSONB;

import io.metaloom.loom.db.jooq.tables.pojos.Group;
import io.metaloom.loom.db.model.group.LoomGroup;
import io.metaloom.loom.db.model.user.LoomUser;
import io.vertx.core.json.JsonObject;

public class LoomGroupImpl implements LoomGroup {

	private Group pojo;

	public LoomGroupImpl() {
	}

	public LoomGroupImpl(Group pojo) {
		this.pojo = pojo;
	}

	@Override
	public LoomGroup setEditor(LoomUser editor) {
		pojo.setEditorUuid(editor.getUuid());
		return this;
	}

	@Override
	public LoomGroup setCreator(LoomUser creator) {
		pojo.setCreatorUuid(creator.getUuid());
		return this;
	}

	@Override
	public LocalDateTime getEdited() {
		return pojo.getEdited();
	}

	@Override
	public LoomGroup setEdited(LocalDateTime edate) {
		pojo.setEdited(edate);
		return this;
	}

	@Override
	public LocalDateTime getCreated() {
		return pojo.getCreated();
	}

	@Override
	public LoomGroup setCreated(LocalDateTime cdate) {
		pojo.setCreated(cdate);
		return this;
	}

	@Override
	public UUID getUuid() {
		return pojo.getUuid();
	}

	@Override
	public LoomGroup setUuid(UUID uuid) {
		pojo.setUuid(uuid);
		return this;
	}

	@Override
	public JsonObject getMeta() {
		return new JsonObject(pojo.getMeta().data());
	}

	@Override
	public LoomGroup setMeta(JsonObject meta) {
		pojo.setMeta(JSONB.jsonb(meta.encode()));
		return this;
	}

	@Override
	public String getName() {
		return pojo.getName();
	}

	@Override
	public LoomGroup setName(String name) {
		pojo.setName(name);
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
