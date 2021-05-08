package io.metaloom.loom.db.asset;

import java.time.LocalDateTime;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqCUDElement;
import io.metaloom.loom.db.jooq.JooqWrapper;
import io.metaloom.loom.db.jooq.tables.pojos.Asset;
import io.metaloom.loom.db.user.LoomUser;

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
	public void setUuid(UUID uuid) {
		delegate.setUuid(uuid);
	}

	@Override
	public void setCreator(LoomUser creator) {
		delegate.setCreatorUuid(creator.getUuid());
	}

	@Override
	public void setEditor(LoomUser editor) {
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
	public Asset getDelegate() {
		return delegate;
	}

}
