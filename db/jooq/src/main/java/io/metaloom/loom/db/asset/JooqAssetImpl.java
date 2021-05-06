package io.metaloom.loom.db.asset;

import java.time.LocalDateTime;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqCUDElement;
import io.metaloom.loom.db.jooq.JooqWrapper;
import io.metaloom.loom.db.user.User;

public class JooqAssetImpl extends AbstractJooqCUDElement implements Asset, JooqWrapper<io.metaloom.loom.db.jooq.tables.pojos.Asset> {

	private final io.metaloom.loom.db.jooq.tables.pojos.Asset delegate;

	public JooqAssetImpl(io.metaloom.loom.db.jooq.tables.pojos.Asset delegate) {
		this.delegate = delegate;
	}

	@Override
	public String getFilename() {
		// return delegate.getFilename();
		return null;
	}

	@Override
	public Asset setFilename(String filename) {
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
	public void setUuid(UUID uuid) {
		delegate.setUuid(uuid);
	}

	@Override
	public void setCreator(User creator) {
		delegate.setCreatorUuid(creator.getUuid());
	}

	@Override
	public void setEditor(User editor) {
		delegate.setEditorUuid(editor.getUuid());
	}

	@Override
	public void setCdate(LocalDateTime cdate) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEdate(LocalDateTime edate) {
		// delegate.setEdited();

	}

	@Override
	public io.metaloom.loom.db.jooq.tables.pojos.Asset getDelegate() {
		return delegate;
	}

}
