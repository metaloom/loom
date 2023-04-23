package io.metaloom.loom.db.jooq.dao.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.jooq.tables.pojos.JooqModel;
import io.metaloom.loom.db.jooq.wrapper.AbstractWrappedElement;
import io.metaloom.loom.db.model.model.Model;
import io.metaloom.loom.db.model.user.User;

public class ModelImpl extends AbstractWrappedElement<JooqModel> implements Model {

	public ModelImpl(JooqModel delegate) {
		super(delegate);
	}

	@Override
	public String getName() {
		return delegate().getName();
	}

	@Override
	public Model setName(String name) {
		delegate().setName(name);
		return this;
	}

	@Override
	public LocalDateTime getCreated() {
		return delegate().getCreated();
	}

	@Override
	public LocalDateTime getEdited() {
		return delegate().getEdited();
	}

	@Override
	public UUID getUuid() {
		return delegate().getUuid();
	}

	@Override
	public Model setUuid(UUID uuid) {
		delegate().setUuid(uuid);
		return this;
	}

	@Override
	public Model setCreated(LocalDateTime cdate) {
		delegate().setCreated(cdate);
		return this;
	}

	@Override
	public Model setCreator(User creator) {
		Objects.requireNonNull(creator, "The creator is invalid");
		delegate().setCreatorUuid(creator.getUuid());
		return this;
	}

	@Override
	public Model setEdited(LocalDateTime edate) {
		delegate().setEdited(edate);
		return this;
	}

	@Override
	public Model setEditor(User editor) {
		Objects.requireNonNull(editor, "The editor is invalid");
		delegate().setEditorUuid(editor.getUuid());
		return this;
	}


}
