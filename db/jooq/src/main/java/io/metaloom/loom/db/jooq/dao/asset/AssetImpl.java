package io.metaloom.loom.db.jooq.dao.asset;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.jooq.tables.pojos.JooqAsset;
import io.metaloom.loom.db.jooq.wrapper.AbstractWrappedElement;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.user.User;
import io.vertx.core.json.JsonObject;

public class AssetImpl extends AbstractWrappedElement<JooqAsset> implements Asset {

	public AssetImpl(JooqAsset delegate) {
		super(delegate);
	}

	@Override
	public String getPath() {
		return delegate().getPath();
	}

	@Override
	public Asset setPath(String filename) {
		delegate().setPath(filename);
		return this;
	}

	@Override
	public UUID getUuid() {
		return delegate().getUuid();
	}

	@Override
	public Asset setUuid(UUID uuid) {
		delegate().setUuid(uuid);
		return this;
	}

	@Override
	public Asset setCreator(User creator) {
		Objects.requireNonNull(creator, "Invalid creator provided");
		delegate().setCreatorUuid(creator.getUuid());
		return this;
	}

	@Override
	public Asset setEditor(User editor) {
		Objects.requireNonNull(editor, "Invalid editor provided");
		delegate().setEditorUuid(editor.getUuid());
		return this;
	}

	@Override
	public LocalDateTime getCreated() {
		return delegate().getCreated();
	}

	@Override
	public Asset setCreated(LocalDateTime cdate) {
		delegate().setCreated(cdate);
		return this;
	}

	@Override
	public LocalDateTime getEdited() {
		return delegate().getEdited();
	}

	@Override
	public Asset setEdited(LocalDateTime edate) {
		delegate().setEdited(edate);
		return this;
	}

	@Override
	public JsonObject getMeta() {
		// return new JsonObject(delegate().getMeta());
		return null;
	}

	@Override
	public Asset setMeta(JsonObject meta) {
		// delegate().setMeta(meta.encode());
		return this;
	}

	@Override
	public String toString() {
		return String.format("Asset [%s] - %s", getUuid(), getPath());
	}

}
