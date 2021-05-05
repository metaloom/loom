package io.metaloom.loom.db.tag;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.JooqType;
import io.metaloom.loom.db.jooq.tables.daos.TagDao;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class JooqTagsDaoImpl extends AbstractJooqDao implements TagsDao {

	private final TagDao delegate;

	protected JooqType getType() {
		return JooqType.ROLE;
	}

	public JooqTagsDaoImpl(TagDao delegate) {
		this.delegate = delegate;
	}

	@Override
	public Maybe<? extends Tag> loadTag(UUID uuid) {
		return wrap(delegate.findOneById(uuid), JooqTagImpl.class);
	}

	@Override
	public void deleteTag(Tag role) {
		Objects.requireNonNull(role, "Tag must not be null");
		delegate.deleteById(role.getUuid());
	}

	@Override
	public Single<Tag> createTag() {
		return Single.create(sub -> {
			io.metaloom.loom.db.jooq.tables.pojos.Tag tag = new io.metaloom.loom.db.jooq.tables.pojos.Tag();
			delegate.insert(tag);
			sub.onSuccess(new JooqTagImpl(tag));
		});
	}

	@Override
	public void updateTag(Tag tag) {
		Objects.requireNonNull(tag, "Tag must not be null");
		io.metaloom.loom.db.jooq.tables.pojos.Tag jooqTag = unwrap(tag);
		delegate.update(jooqTag);
	}

	@Override
	public void storeTag(Tag tag) {
		Objects.requireNonNull(tag, "Tag must not be null");
		delegate.update(unwrap(tag));
	}

	@Override
	public void clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
	}

}
