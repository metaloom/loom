package io.metaloom.loom.db.jooq.dao.content;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractDao;
import io.metaloom.loom.db.jooq.tables.daos.ContentDao;
import io.metaloom.loom.db.model.content.LoomContent;
import io.metaloom.loom.db.model.content.LoomContentDao;
import io.metaloom.loom.db.model.tag.LoomTag;

@Singleton
public class LoomContentDaoImpl extends AbstractDao implements LoomContentDao {

	private ContentDao dao;

	@Inject
	public LoomContentDaoImpl(ContentDao dao, DSLContext ctx) {
		super(ctx);
		this.dao = dao;
	}

	// protected JooqType getType() {
	// return JooqType.CONTENT;
	// }

	@Override
	public LoomContent loadContent(UUID uuid) {
		return wrap(dao.findById(uuid), LoomContentImpl.class);
	}

//	@Override
//	public Completable deleteContent(LoomContent content) {
//		Objects.requireNonNull(content, "Content must not be null");
//		return deleteById(content.getUuid()).ignoreElement();
//	}
//
//	@Override
//	public Single<? extends LoomContent> createContent() {
//		Content content = new Content();
//		return insertReturningPrimary(content).map(pk -> new LoomContentImpl(content.setUuid(pk)));
//	}
//
//	@Override
//	public Completable updateContent(LoomContent content) {
//		Objects.requireNonNull(content, "Content must not be null");
//		Content jooqContent = unwrap(content);
//		return update(jooqContent).ignoreElement();
//	}

	@Override
	public Stream<LoomTag> loadTags(LoomContent content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTag(LoomContent content, LoomTag tag) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeTag(LoomContent content, LoomTag tag) {
		// TODO Auto-generated method stub
	}

	@Override
	public void clear() {
		// TODO run jooq SQL to delete contents of table
	}

	@Override
	public LoomContent createContent(Consumer<LoomContent> modifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteContent(LoomContent content) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateContent(LoomContent content) {
		// TODO Auto-generated method stub
	}

}