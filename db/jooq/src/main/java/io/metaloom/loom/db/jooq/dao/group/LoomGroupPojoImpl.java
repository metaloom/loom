package io.metaloom.loom.db.jooq.dao.group;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import io.metaloom.loom.db.model.group.LoomGroup;
import io.metaloom.loom.db.model.user.LoomUser;
import io.vertx.core.json.JsonObject;

public class LoomGroupPojoImpl implements LoomGroup {

	private UUID creatorUuid;
	private UUID editorUuid;
	private JsonObject meta;
	private String name;
	private UUID uuid;
	private LocalDateTime edate;
	private LocalDateTime cdate;
	private List<LoomUser> users;

	public LoomGroupPojoImpl() {
	}

	@Override
	public LoomGroup setEditor(LoomUser editor) {
		this.editorUuid = editor.getUuid();
		return this;
	}

	@Override
	public LoomGroup setCreator(LoomUser creator) {
		this.creatorUuid = creator.getUuid();
		return this;
	}

	@Override
	public LocalDateTime getEdited() {
		return edate;
	}

	@Override
	public LoomGroup setEdited(LocalDateTime edate) {
		this.edate = edate;
		return this;
	}

	@Override
	public LocalDateTime getCreated() {
		return cdate;
	}

	@Override
	public LoomGroup setCreated(LocalDateTime cdate) {
		this.cdate = cdate;
		return this;
	}

	@Override
	public UUID getUuid() {
		return uuid;
	}

	@Override
	public LoomGroup setUuid(UUID uuid) {
		this.uuid = uuid;
		return this;
	}

	@Override
	public JsonObject getMeta() {
		return meta;
	}

	@Override
	public LoomGroup setMeta(JsonObject meta) {
		this.meta = meta;
		return this;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public LoomGroup setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public List<LoomUser> getUsers() {
		return users;
	}

	@Override
	public LoomGroup setUsers(List<LoomUser> users) {
		this.users = users;
		return this;
	}

}
