package io.metaloom.loom.db.webhook;

import java.time.LocalDateTime;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqCUDElement;
import io.metaloom.loom.db.jooq.JooqWrapper;
import io.metaloom.loom.db.user.User;

public class JooqWebhookImpl extends AbstractJooqCUDElement implements Webhook, JooqWrapper<io.metaloom.loom.db.jooq.tables.pojos.Webhook> {

	private final io.metaloom.loom.db.jooq.tables.pojos.Webhook delegate;

	public JooqWebhookImpl(io.metaloom.loom.db.jooq.tables.pojos.Webhook delegate) {
		super(null);
		this.delegate = delegate;
	}

	@Override
	public String getURL() {
		return delegate.getUrl();
	}

	@Override
	public Webhook setURL(String url) {
		delegate.setUrl(url);
		return this;
	}

	@Override
	public User getCreator() {
		// return wrap(delegate.getCreatorUuid())
		return null;
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
	public User getEditor() {
		// TODO Auto-generated method stub
		return null;
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
	public void setCreator(User creator) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setEdate(LocalDateTime edate) {
		// delegate.setEdited();
	}

	@Override
	public void setEditor(User editor) {
		// TODO Auto-generated method stub
	}

	@Override
	public io.metaloom.loom.db.jooq.tables.pojos.Webhook getDelegate() {
		return delegate;
	}

}
