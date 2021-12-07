package io.metaloom.loom.db.hib.dao.impl;

import java.io.IOException;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.hibernate.reactive.mutiny.Mutiny;

import io.metaloom.loom.db.hib.dao.AbstractDao;
import io.metaloom.loom.db.model.content.Content;
import io.metaloom.loom.db.model.content.ContentDao;
import io.metaloom.loom.db.model.tag.Tag;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

@Singleton
public class ContentDaoImpl extends AbstractDao implements ContentDao {

	public static final String TYPE_NAME = "Content";

	@Inject
	public ContentDaoImpl(Mutiny.SessionFactory emf) {
		super(emf);
	}

	@Override
	public Completable clear() throws IOException {
		return invokeClear(TYPE_NAME);
	}

	@Override
	public Single<? extends Content> createContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable deleteContent(Content content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable updateContent(Content content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Maybe<? extends Content> loadContent(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<Tag> loadTags(Content content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable addTag(Content content, Tag tag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable removeTag(Content content, Tag tag) {
		// TODO Auto-generated method stub
		return null;
	}

}
