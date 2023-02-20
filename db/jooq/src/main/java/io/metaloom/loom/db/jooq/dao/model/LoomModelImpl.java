package io.metaloom.loom.db.jooq.dao.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqCUDElement;
import io.metaloom.loom.db.jooq.JooqWrapper;
import io.metaloom.loom.db.jooq.tables.pojos.Model;
import io.metaloom.loom.db.model.model.LoomModel;
import io.metaloom.loom.db.model.user.LoomUser;

public class LoomModelImpl extends AbstractJooqCUDElement implements LoomModel, JooqWrapper<Model> {

	private final Model delegate;

	public LoomModelImpl(Model delegate) {
		this.delegate = delegate;
	}

	@Override
	public String getName() {
		return delegate.getName();
	}

	@Override
	public LoomModel setName(String name) {
		delegate.setName(name);
		return this;
	}

	@Override
	public LocalDateTime getCreated() {
		return delegate.getCreated();
	}

	@Override
	public LocalDateTime getEdited() {
		return delegate.getEdited();
	}

	@Override
	public UUID getUuid() {
		return delegate.getUuid();
	}

	@Override
	public LoomModel setUuid(UUID uuid) {
		delegate.setUuid(uuid);
		return this;
	}

	@Override
	public LoomModel setCreated(LocalDateTime cdate) {
		delegate.setCreated(cdate);
		return this;
	}

	@Override
	public LoomModel setCreator(LoomUser creator) {
		Objects.requireNonNull(creator, "The creator is invalid");
		delegate.setCreatorUuid(creator.getUuid());
		return this;
	}

	@Override
	public LoomModel setEdited(LocalDateTime edate) {
		delegate.setEdited(edate);
		return this;
	}

	@Override
	public LoomModel setEditor(LoomUser editor) {
		Objects.requireNonNull(editor, "The editor is invalid");
		delegate.setEditorUuid(editor.getUuid());
		return this;
	}

	@Override
	public Model getDelegate() {
		return delegate;
	}

}
