package io.metaloom.loom.db.hib.dao.impl;

import java.io.IOException;
import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.hibernate.reactive.mutiny.Mutiny;

import io.metaloom.loom.db.hib.dao.AbstractDao;
import io.metaloom.loom.db.model.namespace.Namespace;
import io.metaloom.loom.db.model.namespace.NamespaceDao;
import io.metaloom.loom.db.model.namespace.impl.NamespaceImpl;
import io.metaloom.loom.db.model.role.impl.RoleImpl;
import io.metaloom.loom.db.model.tag.Tag;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.smallrye.mutiny.Uni;

@Singleton
public class NamespaceDaoImpl extends AbstractDao implements NamespaceDao {

	public static final String TYPE_NAME = "namespace";

	@Inject
	public NamespaceDaoImpl(Mutiny.SessionFactory emf) {
		super(emf);
	}

	@Override
	public Completable clear() throws IOException {
		return invokeClear(TYPE_NAME);
	}

	@Override
	public Maybe<? extends Namespace> loadNamespace(UUID uuid) {
		Uni<NamespaceImpl> uni = emf.withSession(session -> session.find(NamespaceImpl.class, uuid));
		return Maybe.fromCompletionStage(uni.subscribeAsCompletionStage());
	}

	@Override
	public Single<? extends Namespace> createNamespace(String name, Consumer<Namespace> modifier) {
		return Single.defer(() -> {
			if (name == null) {
				return Single.error(new NullPointerException("Name must be set"));
			}
			Namespace namespace = new NamespaceImpl(name);
			if (modifier != null) {
				modifier.accept(namespace);
			}
			Uni<Namespace> uni = emf.withSession(session -> session.persist(namespace).call(session::flush)).replaceWith(namespace);
			return Single.fromCompletionStage(uni.subscribeAsCompletionStage());
		});
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
