package io.metaloom.loom.db.jooq;

import java.util.Date;
import java.util.UUID;

import io.metaloom.loom.db.CUDElement;
import io.vertx.core.json.JsonObject;

public abstract class AbstractEditableElement<SELF extends CUDElement<SELF>> extends AbstractElement<SELF>
	implements CUDElement<SELF> {

	private UUID uuid;
	private JsonObject meta;
	private UUID creatorUuid;
	private UUID editorUuid;
	private Date edited;
	private Date created;

	@Override
	public UUID getUuid() {
		return uuid;
	}

	@Override
	public SELF setUuid(UUID uuid) {
		this.uuid = uuid;
		return self();
	}

	@Override
	public UUID getEditorUuid() {
		return editorUuid;
	}

	@Override
	public SELF setEditorUuid(UUID editorUuid) {
		this.editorUuid = editorUuid;
		return self();
	}

	@Override
	public UUID getCreatorUuid() {
		return creatorUuid;
	}

	@Override
	public SELF setCreatorUuid(UUID creatorUuid) {
		this.creatorUuid = creatorUuid;
		return self();
	}

	@Override
	public Date getEdited() {
		return edited;
	}

	@Override
	public SELF setEdited(Date edate) {
		this.edited = edate;
		return self();
	}

	@Override
	public Date getCreated() {
		return created;
	}

	@Override
	public SELF setCreated(Date cdate) {
		this.created = cdate;
		return self();
	}

	@Override
	public JsonObject getMeta() {
		return meta;
	}

	@Override
	public SELF setMeta(JsonObject meta) {
		this.meta = meta;
		return self();
	}

	@Override
	public String toString() {
		return "[" + getClass().getSimpleName() + "] uuid: " + getUuid() + ", creator: " + getCreatorUuid();
	}
}
