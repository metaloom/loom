package io.metaloom.loom.db.hib.dao.impl;

import java.io.IOException;
import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.hibernate.reactive.mutiny.Mutiny;

import io.metaloom.loom.db.hib.dao.AbstractDao;
import io.metaloom.loom.db.model.role.Role;
import io.metaloom.loom.db.model.role.RoleDao;
import io.metaloom.loom.db.model.role.impl.RoleImpl;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import io.smallrye.mutiny.Uni;

@Singleton
public class RoleDaoImpl extends AbstractDao implements RoleDao {

	public static final String TYPE_NAME = "Role";

	@Inject
	public RoleDaoImpl(Mutiny.SessionFactory emf) {
		super(emf);
	}

	@Override
	public Completable clear() throws IOException {
		return invokeClear(TYPE_NAME);
	}

	@Override
	public Single<? extends Role> createRole(String name, Consumer<Role> modifier) {
		return Single.defer(() -> {
			if (name== null) {
				return Single.error(new NullPointerException("Name must be set"));
			}
			Role role = new RoleImpl(name);
			if (modifier != null) {
				modifier.accept(role);
			}
			Uni<Role> uni = emf.withSession(session -> session.persist(role).call(session::flush)).replaceWith(role);
			return Single.fromCompletionStage(uni.subscribeAsCompletionStage());
		});
	}

	@Override
	public Maybe<? extends Role> loadRole(UUID uuid) {
		Uni<RoleImpl> uni = emf.withSession(session -> session.find(RoleImpl.class, uuid));
		return Maybe.fromCompletionStage(uni.subscribeAsCompletionStage());
	}

	@Override
	public Completable deleteRole(UUID uuid) {
		Uni<Void> uni = emf.withSession(session -> {
			return session.find(RoleImpl.class, uuid).flatMap(role -> {
				return session.remove(role).call(session::flush);
			});
		});
		return Completable.fromCompletionStage(uni.subscribeAsCompletionStage());
	}

	@Override
	public Completable updateRole(Role role) {
		Uni<Void> uni = emf.withSession(session -> {
			return session.persist(role).call(session::flush);
		});
		return Completable.fromCompletionStage(uni.subscribeAsCompletionStage());
	}

}
