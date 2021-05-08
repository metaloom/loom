package io.metaloom.loom.db.extension;

import java.time.LocalDateTime;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqCUDElement;
import io.metaloom.loom.db.jooq.JooqWrapper;
import io.metaloom.loom.db.jooq.tables.pojos.Extension;
import io.metaloom.loom.db.user.LoomUser;

public class JooqExtensionImpl extends AbstractJooqCUDElement implements LoomExtension, JooqWrapper<Extension> {

	private final Extension delegate;

	public JooqExtensionImpl(Extension delegate) {
		this.delegate = delegate;
	}

	@Override
	public String getURL() {
		return delegate.getUrl();
	}

	@Override
	public LoomExtension setURL(String url) {
		delegate.setUrl(url);
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
	public void setCdate(LocalDateTime cdate) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCreator(LoomUser creator) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEdate(LocalDateTime edate) {
		// delegate.setEdited();

	}

	@Override
	public void setEditor(LoomUser editor) {
		// TODO Auto-generated method stub
	}

	@Override
	public Extension getDelegate() {
		return delegate;
	}

}
