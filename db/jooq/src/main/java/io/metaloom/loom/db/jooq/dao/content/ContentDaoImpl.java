package io.metaloom.loom.db.jooq.dao.content;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqContentDao;
import io.metaloom.loom.db.model.content.LoomContent;
import io.metaloom.loom.db.model.content.LoomContentDao;
import io.metaloom.loom.db.model.tag.LoomTag;

@Singleton
public class ContentDaoImpl extends AbstractJooqDao<JooqContentDao> implements LoomContentDao {

	@Inject
	public ContentDaoImpl(JooqContentDao dao,  DSLContext ctx) {
		super(dao, ctx);
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

	@Override
	public LoomContent loadContent(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

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
	
}
