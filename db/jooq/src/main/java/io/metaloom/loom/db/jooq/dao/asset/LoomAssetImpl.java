package io.metaloom.loom.db.jooq.dao.asset;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqCUDElement;
import io.metaloom.loom.db.jooq.JooqWrapper;
import io.metaloom.loom.db.jooq.tables.pojos.Asset;
import io.metaloom.loom.db.model.asset.LoomAsset;
import io.metaloom.loom.db.model.user.LoomUser;
import io.vertx.core.json.JsonObject;

public class LoomAssetImpl extends AbstractJooqCUDElement implements LoomAsset, JooqWrapper<Asset> {

	private final Asset delegate;

	public LoomAssetImpl(Asset delegate) {
		this.delegate = delegate;
	}

	@Override
	public String getFilename() {
		return delegate.getFilename();
	}

	@Override
	public LoomAsset setFilename(String filename) {
		delegate.setFilename(filename);
		return this;
	}

	@Override
	public UUID getUuid() {
		return delegate.getUuid();
	}

	@Override
	public LoomAsset setUuid(UUID uuid) {
		delegate.setUuid(uuid);
		return this;
	}

	@Override
	public LoomAsset setCreator(LoomUser creator) {
		Objects.requireNonNull(creator, "Invalid creator provided");
		delegate.setCreatorUuid(creator.getUuid());
		return this;
	}

	@Override
	public LoomAsset setEditor(LoomUser editor) {
		Objects.requireNonNull(editor, "Invalid editor provided");
		delegate.setEditorUuid(editor.getUuid());
		return this;
	}

	@Override
	public LocalDateTime getCreated() {
		return delegate.getCreated();
	}

	@Override
	public LoomAsset setCreated(LocalDateTime cdate) {
		delegate.setCreated(cdate);
		return this;
	}

	@Override
	public LocalDateTime getEdited() {
		return delegate.getEdited();
	}

	@Override
	public LoomAsset setEdited(LocalDateTime edate) {
		delegate.setEdited(edate);
		return this;
	}

	@Override
	public String getS3BucketName() {
		return delegate.getS3BucketName();
	}

	@Override
	public LoomAsset setS3BucketName(String bucketName) {
		delegate.setS3BucketName(bucketName);
		return this;
	}

	@Override
	public String getS3ObjectPath() {
		return delegate.getS3ObjectPath();
	}

	@Override
	public LoomAsset setS3ObjectPath(String path) {
		delegate.setS3ObjectPath(path);
		return this;
	}

	@Override
	public String getDominantColor() {
		return delegate.getDominantcolor();
	}

	@Override
	public LoomAsset setDominantColor(String color) {
		delegate.setDominantcolor(color);
		return this;
	}

	@Override
	public BigDecimal getGPSLat() {
		return delegate.getGpsLat();
	}

	@Override
	public LoomAsset setGPSLat(BigDecimal lat) {
		delegate.setGpsLat(lat);
		return this;
	}

	@Override
	public BigDecimal getGPSLon() {
		return delegate.getGpsLon();
	}

	@Override
	public LoomAsset setGPSLon(BigDecimal lon) {
		delegate.setGpsLon(lon);
		return this;
	}

	@Override
	public String getLocalPath() {
		return delegate.getLocalpath();
	}

	@Override
	public LoomAsset setLocalPath(String path) {
		delegate.setLocalpath(path);
		return this;
	}

	@Override
	public JsonObject getMeta() {
//		return new JsonObject(delegate.getMeta());
		return null;
	}

	@Override
	public LoomAsset setMeta(JsonObject meta) {
//		delegate.setMeta(meta.encode());
		return this;
	}

	@Override
	public String getMimeType() {
		return delegate.getMimetype();
	}

	@Override
	public LoomAsset setMimeType(String mimeType) {
		delegate.setMimetype(mimeType);
		return this;
	}

	@Override
	public Integer getRating() {
		return delegate.getRating();
	}

	@Override
	public LoomAsset setRating(Integer rating) {
		delegate.setRating(rating);
		return this;
	}

	@Override
	public Asset getDelegate() {
		return delegate;
	}

}
