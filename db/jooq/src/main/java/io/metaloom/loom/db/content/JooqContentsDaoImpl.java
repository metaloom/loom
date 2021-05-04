package io.metaloom.loom.db.content;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.JooqType;
import io.metaloom.loom.db.jooq.tables.daos.ContentDao;
import io.reactivex.Maybe;

public class JooqContentsDaoImpl extends AbstractJooqDao implements ContentsDao {

	private final ContentDao delegate;

	protected JooqType getType() {
		return JooqType.ASSET;
	}

	public JooqContentsDaoImpl(ContentDao delegate) {
		this.delegate = delegate;
	}

	@Override
	public Maybe<? extends Content> loadContent(UUID uuid) {
		return wrap(delegate.findOneById(uuid), JooqContentImpl.class);
	}

	@Override
	public void deleteContent(Content asset) {
		Objects.requireNonNull(asset, "Content must not be null");
		delegate.deleteById(asset.getUuid());
	}

	@Override
	public Content createContent() {
		io.metaloom.loom.db.jooq.tables.pojos.Content content = new io.metaloom.loom.db.jooq.tables.pojos.Content();
		delegate.insert(content);
		return new JooqContentImpl(content);
	}

	@Override
	public void updateContent(Content asset) {
		Objects.requireNonNull(asset, "Content must not be null");
		io.metaloom.loom.db.jooq.tables.pojos.Content jooqContent = unwrap(asset);
		delegate.update(jooqContent);
	}

	@Override
	public void storeContent(Content asset) {
		Objects.requireNonNull(asset, "Content must not be null");
		delegate.update(unwrap(asset));
	}

	@Override
	public void clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
	}

}
