package io.metaloom.loom.db.hib.dao;

import java.util.UUID;

import org.hibernate.reactive.mutiny.Mutiny.SessionFactory;

import io.metaloom.loom.db.LoomElement;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import io.smallrye.mutiny.Uni;

public abstract class AbstractDao {

	protected SessionFactory emf;

	public AbstractDao(SessionFactory emf) {
		this.emf = emf;
	}

	protected Completable invokeClear(String typeName) {
		return null;
	}

	protected <T extends LoomElement> Maybe<? extends T> loadByUuid(Class<T> clazz, UUID uuid) {
		Uni<T> uni = emf.withSession(session -> session.find(clazz, uuid));
		return Maybe.fromCompletionStage(uni.subscribeAsCompletionStage());
	}

	protected Completable persistElement(LoomElement element) {
		Uni<Void> uni = emf.withSession(session -> {
			return session.persist(element).call(session::flush);
		});
		return Completable.fromCompletionStage(uni.subscribeAsCompletionStage());
	}

	protected <T extends LoomElement> Single<? extends T> persistAndReturnElement(T element) {
		Uni<T> uni = emf.withSession(session -> {
			return session.persist(element).call(session::flush).replaceWith(element);
		});
		return Single.fromCompletionStage(uni.subscribeAsCompletionStage());
	}

	protected Completable deleteElement(LoomElement element) {
		Uni<Void> uni = emf.withSession(session -> {
			return session.remove(element).call(session::flush);
		});
		return Completable.fromCompletionStage(uni.subscribeAsCompletionStage());
	}

	protected Completable deleteByUuid(Class<? extends LoomElement> clazz, UUID uuid) {
		Uni<Void> uni = emf.withSession(session -> {
			return session.find(clazz, uuid).flatMap(element -> {
				return session.remove(element).call(session::flush);
			});
		});
		return Completable.fromCompletionStage(uni.subscribeAsCompletionStage());
	}
}
