package io.metaloom.loom.db.asset;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqCUDElement;
import io.metaloom.loom.db.jooq.JooqWrapper;
import io.metaloom.loom.db.jooq.tables.pojos.Asset;
import io.metaloom.loom.db.user.LoomUser;
import io.vertx.core.json.JsonObject;

public class JooqAssetImpl extends AbstractJooqCUDElement implements LoomAsset, JooqWrapper<Asset> {

	private final Asset delegate;

	public JooqAssetImpl(Asset delegate) {
		this.delegate = delegate;
	}

	@Override
	public String getFilename() {
		// return delegate.getFilename();
		return null;
	}

	@Override
	public LoomAsset setFilename(String filename) {
		// return delegate.setFilename(filename);
		return this;
	}

	@Override
	public LocalDateTime getCdate() {
		return delegate.getCreated();
	}

	@Override
	public LocalDateTime getEdate() {
		return delegate.getEdited();
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
	public LoomAsset setCdate(LocalDateTime cdate) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public LoomAsset setEdate(LocalDateTime edate) {
		// delegate.setEdited();
		return this;
	}

	@Override
	public String getS3BucketName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoomAsset setS3BucketName(String bucketName) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public String getS3ObjectPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoomAsset setS3ObjectPath(String path) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public String getDominantColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoomAsset setDominantColor(String color) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public Double getGPSLat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoomAsset setGPSLat(Double lat) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public Double getGPSLon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoomAsset setGPSLon(Double lon) {
		// TODO Auto-generated method stub
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
		return new JsonObject(delegate.getMeta());
	}

	@Override
	public LoomAsset setMeta(JsonObject meta) {
		delegate.setMeta(meta.encode());
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
