package io.metaloom.loom.db.field;

import java.time.LocalDateTime;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqCUDElement;
import io.metaloom.loom.db.jooq.JooqWrapper;
import io.metaloom.loom.db.jooq.tables.pojos.Field;
import io.metaloom.loom.db.user.LoomUser;

public class JooqFieldImpl extends AbstractJooqCUDElement implements LoomField, JooqWrapper<Field> {

	private final Field delegate;

	public JooqFieldImpl(Field delegate) {
		this.delegate = delegate;
	}

	@Override
	public LocalDateTime getEdate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID getUuid() {
		return delegate.getUuid();
	}

	@Override
	public LoomField setUuid(UUID uuid) {
		delegate.setUuid(uuid);
		return this;
	}

	@Override
	public LoomField setCdate(LocalDateTime cdate) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public LoomField setEdate(LocalDateTime edate) {
		// delegate.setEdited();
		return this;

	}

	@Override
	public LoomField setCreator(LoomUser creator) {
		// delegate.setCreatorUuid(creator.getUuid());
		return this;
	}

	@Override
	public LoomField setEditor(LoomUser editor) {
		delegate.setEditorUuid(editor.getUuid());
		return this;
	}

	@Override
	public LocalDateTime getCdate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field getDelegate() {
		return delegate;
	}

}
