package io.metaloom.loom.db.hib.dao.impl;

import java.io.IOException;
import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.hibernate.reactive.mutiny.Mutiny;

import io.metaloom.loom.db.hib.dao.AbstractDao;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.content.Content;
import io.metaloom.loom.db.model.namespace.Namespace;
import io.metaloom.loom.db.model.tag.Tag;
import io.metaloom.loom.db.model.tag.TagDao;
import io.metaloom.loom.db.model.tag.impl.TagImpl;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

@Singleton
public class TagDaoImpl extends AbstractDao implements TagDao {

	private static final String TYPE_NAME = "Tag";

	@Inject
	public TagDaoImpl(Mutiny.SessionFactory emf) {
		super(emf);
	}

	@Override
	public Completable clear() throws IOException {
		return invokeClear(TYPE_NAME);
	}

	@Override
	public Single<? extends Tag> createTag(String name, String collection, Consumer<Tag> modifier) {
		return Single.defer(() -> {
			if (name == null) {
				return Single.error(new NullPointerException("Name must be set"));
			}
			Tag tag = new TagImpl(name);
			if (modifier != null) {
				modifier.accept(tag);
			}
			return persistAndReturnElement(tag);
		});
	}

	@Override
	public Maybe<? extends Tag> loadTag(UUID uuid) {
		return loadByUuid(TagImpl.class, uuid);
	}

	@Override
	public Completable deleteTag(UUID uuid) {
		return deleteByUuid(TagImpl.class, uuid);
	}

	@Override
	public Completable updateTag(Tag tag) {
		return persistElement(tag);
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
