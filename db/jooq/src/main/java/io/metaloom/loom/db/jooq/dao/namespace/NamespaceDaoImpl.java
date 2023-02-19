package io.metaloom.loom.db.jooq.dao.namespace;

import java.io.IOException;
import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.jooq.AbstractDao;
import io.metaloom.loom.db.model.namespace.Namespace;
import io.metaloom.loom.db.model.namespace.NamespaceDao;
import io.metaloom.loom.db.model.tag.Tag;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

@Singleton
public class NamespaceDaoImpl extends AbstractDao implements NamespaceDao {

	@Inject
	public NamespaceDaoImpl() {
	}

	@Override
	public Completable clear() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Maybe<? extends Namespace> loadNamespace(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Single<? extends Namespace> createNamespace(String name, Consumer<Namespace> modifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable deleteNamespace(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable updateNamespace(Namespace namespace) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<Tag> loadTags(Namespace namespace) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable addTag(Namespace namespace, Tag tag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable removeTag(Namespace namespace, Tag tag) {
		// TODO Auto-generated method stub
		return null;
	}

}
