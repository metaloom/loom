package io.metaloom.loom.db.jooq.extension;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.jooq.tables.pojos.JooqExtension;
import io.metaloom.loom.db.jooq.wrapper.AbstractWrappedElement;
import io.metaloom.loom.db.model.extension.Extension;
import io.metaloom.loom.db.model.user.User;
import io.vertx.core.json.JsonObject;

public class ExtensionImpl extends AbstractWrappedElement<JooqExtension> implements Extension {

	public ExtensionImpl(JooqExtension delegate) {
		super(delegate);
	}

	@Override
	public String getURL() {
		return delegate().getUrl();
	}

	@Override
	public Extension setURL(String url) {
		delegate().setUrl(url);
		return this;
	}

	@Override
	public JsonObject getMeta() {
		// return new JsonObject(delegate().getMeta());
		return null;
	}

	@Override
	public Extension setMeta(JsonObject meta) {
		// delegate().setMeta(meta.encode());
		return this;
	}

	@Override
	public LocalDateTime getCreated() {
		return delegate().getCreated();
	}

	@Override
	public LocalDateTime getEdited() {
		return delegate().getEdited();
	}

	@Override
	public UUID getUuid() {
		return delegate().getUuid();
	}

	@Override
	public Extension setUuid(UUID uuid) {
		delegate().setUuid(uuid);
		return this;
	}

	@Override
	public Extension setCreated(LocalDateTime cdate) {
		delegate().setCreated(cdate);
		return this;
	}

	@Override
	public Extension setCreator(User creator) {
		Objects.requireNonNull(creator, "The creator is invalid");
		delegate().setCreatorUuid(creator.getUuid());
		return this;
	}

	@Override
	public Extension setEdited(LocalDateTime edate) {
		delegate().setEdited(edate);
		return this;
	}

	@Override
	public Extension setEditor(User editor) {
		Objects.requireNonNull(editor, "The editor is invalid");
		delegate().setEditorUuid(editor.getUuid());
		return this;
	}

}
