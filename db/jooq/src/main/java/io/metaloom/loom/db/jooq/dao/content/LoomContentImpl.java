package io.metaloom.loom.db.jooq.dao.content;

import java.time.LocalDateTime;
import java.util.UUID;

import io.metaloom.loom.db.jooq.tables.pojos.JooqContent;
import io.metaloom.loom.db.jooq.wrapper.AbstractWrappedElement;
import io.metaloom.loom.db.model.content.LoomContent;
import io.metaloom.loom.db.model.user.LoomUser;
import io.vertx.core.json.JsonObject;

public class LoomContentImpl extends AbstractWrappedElement<JooqContent> implements LoomContent {

	public LoomContentImpl(JooqContent delegate) {
		super(delegate);
	}

	@Override
	public LocalDateTime getCreated() {
		return delegate().getCreated();
	}

	@Override
	public LocalDateTime getEdited() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID getUuid() {
		return delegate().getUuid();
	}

	@Override
	public LoomContent setUuid(UUID uuid) {
		delegate().setUuid(uuid);
		return this;
	}

	@Override
	public LoomContent setCreated(LocalDateTime cdate) {
		// TODO Auto-generated method stub
		return this;

	}

	@Override
	public LoomContent setCreator(LoomUser creator) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public LoomContent setEdited(LocalDateTime edate) {
		// delegate.setEdited();
		return this;
	}

	@Override
	public LoomContent setEditor(LoomUser editor) {
		return this;
	}

	@Override
	public JsonObject getMeta() {
		// return new JsonObject(delegate.getMeta());
		return null;
	}

	@Override
	public LoomContent setMeta(JsonObject meta) {
		// delegate.setMeta(meta.encode());
		return this;
	}

}
