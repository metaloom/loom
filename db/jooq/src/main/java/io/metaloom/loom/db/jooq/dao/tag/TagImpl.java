package io.metaloom.loom.db.jooq.dao.tag;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.jooq.tables.pojos.JooqTag;
import io.metaloom.loom.db.jooq.wrapper.AbstractWrappedElement;
import io.metaloom.loom.db.model.tag.Tag;
import io.metaloom.loom.db.model.user.User;

/**
 * @See {@link Tag}
 */
public class TagImpl extends AbstractWrappedElement<JooqTag> implements Tag {

	public TagImpl(JooqTag delegate) {
		super(delegate);
	}

	@Override
	public String getName() {
		return delegate().getName();
	}

	@Override
	public Tag setName(String name) {
		delegate().setName(name);
		return this;
	}

	@Override
	public Tag setCollection(String collectionName) {
		delegate().setCollection(collectionName);
		return this;
	}

	@Override
	public String getCollection() {
		return delegate().getCollection();
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
	public Tag setUuid(UUID uuid) {
		delegate().setUuid(uuid);
		return this;
	}

	@Override
	public Tag setCreated(LocalDateTime cdate) {
		delegate().setCreated(cdate);
		return this;
	}

	@Override
	public Tag setCreator(User creator) {
		Objects.requireNonNull(creator, "The provided creator is invalid");
		delegate().setCreatorUuid(creator.getUuid());
		return this;
	}

	@Override
	public Tag setEdited(LocalDateTime edate) {
		delegate().setEdited(edate);
		return this;
	}

	@Override
	public Tag setEditor(User editor) {
		Objects.requireNonNull(editor, "The provided editor is invalid");
		delegate().setEditorUuid(editor.getUuid());
		return this;
	}

}
