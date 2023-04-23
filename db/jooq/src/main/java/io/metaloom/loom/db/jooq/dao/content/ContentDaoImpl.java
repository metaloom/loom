package io.metaloom.loom.db.jooq.dao.content;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqContentDao;
import io.metaloom.loom.db.model.content.Content;
import io.metaloom.loom.db.model.content.ContentDao;
import io.metaloom.loom.db.model.tag.Tag;

@Singleton
public class ContentDaoImpl extends AbstractJooqDao<JooqContentDao> implements ContentDao {

	@Inject
	public ContentDaoImpl(JooqContentDao dao,  DSLContext ctx) {
		super(dao, ctx);
	}

	@Override
	public Content createContent(Consumer<Content> modifier) {
		// TODO Auto-generated method stub
		return null;
	}

	// @Override
	// public Completable deleteContent(LoomContent content) {
	// Objects.requireNonNull(content, "Content must not be null");
	// return deleteById(content.getUuid()).ignoreElement();
	// }
	//
	// @Override
	// public Single<? extends LoomContent> createContent() {
	// Content content = new Content();
	// return insertReturningPrimary(content).map(pk -> new LoomContentImpl(content.setUuid(pk)));
	// }
	//
	// @Override
	// public Completable updateContent(LoomContent content) {
	// Objects.requireNonNull(content, "Content must not be null");
	// Content jooqContent = unwrap(content);
	// return update(jooqContent).ignoreElement();
	// }

	
	@Override
	public void deleteContent(Content content) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateContent(Content content) {
		// TODO Auto-generated method stub
	}

	@Override
	public Content loadContent(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stream<Tag> loadTags(Content content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTag(Content content, Tag tag) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeTag(Content content, Tag tag) {
		// TODO Auto-generated method stub
	}
	
}
