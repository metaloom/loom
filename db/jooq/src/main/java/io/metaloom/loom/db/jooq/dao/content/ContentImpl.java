package io.metaloom.loom.db.jooq.dao.content;

import java.time.LocalDateTime;
import java.util.UUID;

import io.metaloom.loom.db.jooq.tables.pojos.JooqContent;
import io.metaloom.loom.db.jooq.wrapper.AbstractWrappedElement;
import io.metaloom.loom.db.model.content.Content;
import io.metaloom.loom.db.model.user.User;
import io.vertx.core.json.JsonObject;

public class ContentImpl extends AbstractWrappedElement<JooqContent> implements Content {

	public ContentImpl(JooqContent delegate) {
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
	public Content setUuid(UUID uuid) {
		delegate().setUuid(uuid);
		return this;
	}

	@Override
	public Content setCreated(LocalDateTime cdate) {
		// TODO Auto-generated method stub
		return this;

	}

	@Override
	public Content setCreator(User creator) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public Content setEdited(LocalDateTime edate) {
		// delegate.setEdited();
		return this;
	}

	@Override
	public Content setEditor(User editor) {
		return this;
	}

	@Override
	public JsonObject getMeta() {
		// return new JsonObject(delegate.getMeta());
		return null;
	}

	@Override
	public Content setMeta(JsonObject meta) {
		// delegate.setMeta(meta.encode());
		return this;
	}

}
