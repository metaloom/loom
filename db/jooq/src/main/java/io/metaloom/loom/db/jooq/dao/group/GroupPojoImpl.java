package io.metaloom.loom.db.jooq.dao.group;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import io.metaloom.loom.db.model.group.Group;
import io.metaloom.loom.db.model.user.LoomUser;
import io.vertx.core.json.JsonObject;

public class GroupPojoImpl implements Group {

	private UUID creatorUuid;
	private UUID editorUuid;
	private JsonObject meta;
	private String name;
	private UUID uuid;
	private LocalDateTime edate;
	private LocalDateTime cdate;
	private List<LoomUser> users;

	public GroupPojoImpl() {
	}

	@Override
	public Group setEditor(LoomUser editor) {
		this.editorUuid = editor.getUuid();
		return this;
	}

	@Override
	public Group setCreator(LoomUser creator) {
		this.creatorUuid = creator.getUuid();
		return this;
	}

	@Override
	public LocalDateTime getEdited() {
		return edate;
	}

	@Override
	public Group setEdited(LocalDateTime edate) {
		this.edate = edate;
		return this;
	}

	@Override
	public LocalDateTime getCreated() {
		return cdate;
	}

	@Override
	public Group setCreated(LocalDateTime cdate) {
		this.cdate = cdate;
		return this;
	}

	@Override
	public UUID getUuid() {
		return uuid;
	}

	@Override
	public Group setUuid(UUID uuid) {
		this.uuid = uuid;
		return this;
	}

	@Override
	public JsonObject getMeta() {
		return meta;
	}

	@Override
	public Group setMeta(JsonObject meta) {
		this.meta = meta;
		return this;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Group setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public List<LoomUser> getUsers() {
		return users;
	}

	@Override
	public Group setUsers(List<LoomUser> users) {
		this.users = users;
		return this;
	}

}
