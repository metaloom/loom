package io.metaloom.loom.db.hib.dao.impl;

import java.io.IOException;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.hibernate.reactive.mutiny.Mutiny;

import io.metaloom.loom.db.hib.dao.AbstractDao;
import io.metaloom.loom.db.model.group.Group;
import io.metaloom.loom.db.model.group.GroupDao;
import io.metaloom.loom.db.model.role.Role;
import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.db.model.webhook.impl.WebHookImpl;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.smallrye.mutiny.Uni;

@Singleton
public class GroupDaoImpl extends AbstractDao implements GroupDao {

	private static final String TYPE_NAME = "Group";

	@Inject
	public GroupDaoImpl(Mutiny.SessionFactory emf) {
		super(emf);
	}

	@Override
	public Completable clear() throws IOException {
		return invokeClear(TYPE_NAME);
	}

	@Override
	public Single<? extends Group> createGroup(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable deleteGroup(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable updateGroup(Group group) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Maybe<? extends Group> loadGroup(UUID uuid) {
		Uni<WebHookImpl> uni = emf.withSession(session -> session.find(WebHookImpl.class, uuid));
		return Maybe.fromCompletionStage(uni.subscribeAsCompletionStage());
	}

	@Override
	public Completable addUserToGroup(Group group, LoomUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable removeUserFromGroup(Group group, LoomUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<LoomUser> loadUsers(Group group) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable addRoleToGroup(Group group, Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable removeRoleFromGroup(Group group, Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<Role> loadRoles(Group group) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable testMultiOp() {
		// TODO Auto-generated method stub
		return null;
	}
}
