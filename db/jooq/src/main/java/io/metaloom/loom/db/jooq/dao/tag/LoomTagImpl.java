package io.metaloom.loom.db.jooq.dao.tag;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqCUDElement;
import io.metaloom.loom.db.jooq.JooqWrapper;
import io.metaloom.loom.db.jooq.tables.pojos.Tag;
import io.metaloom.loom.db.model.tag.LoomTag;
import io.metaloom.loom.db.model.user.LoomUser;

/**
 * @See {@link LoomTag}
 */
public class LoomTagImpl extends AbstractJooqCUDElement implements LoomTag, JooqWrapper<Tag> {

	private final Tag delegate;

	public LoomTagImpl(Tag delegate) {
		this.delegate = delegate;
	}

	@Override
	public String getName() {
		return delegate.getName();
	}

	@Override
	public LoomTag setName(String name) {
		delegate.setName(name);
		return this;
	}

	@Override
	public LoomTag setCollection(String collectionName) {
		delegate.setCollection(collectionName);
		return this;
	}

	@Override
	public String getCollection() {
		return delegate.getCollection();
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
	public LoomTag setUuid(UUID uuid) {
		delegate.setUuid(uuid);
		return this;
	}

	@Override
	public LoomTag setCreated(LocalDateTime cdate) {
		delegate.setCreated(cdate);
		return this;
	}

	@Override
	public LoomTag setCreator(LoomUser creator) {
		Objects.requireNonNull(creator, "The provided creator is invalid");
		delegate.setCreatorUuid(creator.getUuid());
		return this;
	}

	@Override
	public LoomTag setEdited(LocalDateTime edate) {
		delegate.setEdited(edate);
		return this;
	}

	@Override
	public LoomTag setEditor(LoomUser editor) {
		Objects.requireNonNull(editor, "The provided editor is invalid");
		delegate.setEditorUuid(editor.getUuid());
		return this;
	}

	@Override
	public Tag getDelegate() {
		return delegate;
	}

}
