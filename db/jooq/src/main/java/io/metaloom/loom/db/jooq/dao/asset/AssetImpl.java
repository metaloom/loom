package io.metaloom.loom.db.jooq.dao.asset;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.jooq.tables.pojos.JooqAsset;
import io.metaloom.loom.db.jooq.wrapper.AbstractWrappedElement;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.user.LoomUser;
import io.vertx.core.json.JsonObject;

public class AssetImpl extends AbstractWrappedElement<JooqAsset> implements Asset {

	public AssetImpl(JooqAsset delegate) {
		super(delegate);
	}

	@Override
	public String getFilename() {
		return delegate().getFilename();
	}

	@Override
	public Asset setFilename(String filename) {
		delegate().setFilename(filename);
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
	public Asset setCreator(LoomUser creator) {
		Objects.requireNonNull(creator, "Invalid creator provided");
		delegate().setCreatorUuid(creator.getUuid());
		return this;
	}

	@Override
	public Asset setEditor(LoomUser editor) {
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
	public String getS3BucketName() {
		return delegate().getS3BucketName();
	}

	@Override
	public Asset setS3BucketName(String bucketName) {
		delegate().setS3BucketName(bucketName);
		return this;
	}

	@Override
	public String getS3ObjectPath() {
		return delegate().getS3ObjectPath();
	}

	@Override
	public Asset setS3ObjectPath(String path) {
		delegate().setS3ObjectPath(path);
		return this;
	}

	@Override
	public String getDominantColor() {
		return delegate().getDominantcolor();
	}

	@Override
	public Asset setDominantColor(String color) {
		delegate().setDominantcolor(color);
		return this;
	}

	@Override
	public BigDecimal getGPSLat() {
		return delegate().getGpsLat();
	}

	@Override
	public Asset setGPSLat(BigDecimal lat) {
		delegate().setGpsLat(lat);
		return this;
	}

	@Override
	public BigDecimal getGPSLon() {
		return delegate().getGpsLon();
	}

	@Override
	public Asset setGPSLon(BigDecimal lon) {
		delegate().setGpsLon(lon);
		return this;
	}

	@Override
	public String getLocalPath() {
		return delegate().getLocalpath();
	}

	@Override
	public Asset setLocalPath(String path) {
		delegate().setLocalpath(path);
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
	public String getMimeType() {
		return delegate().getMimetype();
	}

	@Override
	public Asset setMimeType(String mimeType) {
		delegate().setMimetype(mimeType);
		return this;
	}

	@Override
	public Integer getRating() {
		return delegate().getRating();
	}

	@Override
	public Asset setRating(Integer rating) {
		delegate().setRating(rating);
		return this;
	}

	@Override
	public String toString() {
		return String.format("Asset [%s] - %s", getUuid(), getFilename());
	}

}
