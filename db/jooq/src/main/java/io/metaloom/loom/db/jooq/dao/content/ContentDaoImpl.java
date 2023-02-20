package io.metaloom.loom.db.jooq.dao.content;

import java.io.IOException;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractDao;
import io.metaloom.loom.db.model.content.LoomContent;
import io.metaloom.loom.db.model.content.LoomContentDao;
import io.metaloom.loom.db.model.tag.LoomTag;
import io.reactivex.rxjava3.core.Completable;

@Singleton
public class ContentDaoImpl extends AbstractDao implements LoomContentDao {

	@Inject
	public ContentDaoImpl(DSLContext ctx) {
		super(ctx);
	}

	@Override
	public void clear() {
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
