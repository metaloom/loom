package io.metaloom.loom.db.jooq.dao.tag;

import java.io.IOException;
import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.jooq.AbstractDao;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.content.Content;
import io.metaloom.loom.db.model.namespace.Namespace;
import io.metaloom.loom.db.model.tag.Tag;
import io.metaloom.loom.db.model.tag.TagDao;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

@Singleton
public class TagDaoImpl extends AbstractDao implements TagDao {

	@Inject
	public TagDaoImpl() {
		
	}

	@Override
	public Completable clear() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Single<? extends Tag> createTag(String name, String collection, Consumer<Tag> modifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Maybe<? extends Tag> loadTag(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable deleteTag(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable updateTag(Tag tag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable tagNamespace(Tag tag, Namespace namespace) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable untagNamespace(Tag tag, Namespace namespace) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable tagAsset(Tag tag, Asset asset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable untagAsset(Tag tag, Asset asset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable tagContent(Tag tag, Content content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable untagContent(Tag tag, Content content) {
		// TODO Auto-generated method stub
		return null;
	}
}
