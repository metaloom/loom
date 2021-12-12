package io.metaloom.loom.db.hib.dao.group;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.hibernate.reactive.mutiny.Mutiny;
import org.hibernate.reactive.mutiny.Mutiny.Query;

import io.metaloom.loom.db.hib.dao.AbstractDao;
import io.metaloom.loom.db.model.group.Group;
import io.metaloom.loom.db.model.group.GroupDao;
import io.metaloom.loom.db.model.group.impl.GroupImpl;
import io.metaloom.loom.db.model.role.Role;
import io.metaloom.loom.db.model.user.LoomUser;
import io.metaloom.loom.db.model.user.impl.LoomUserImpl;
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
	public Single<? extends Group> createGroup(String name, Consumer<Group> modifier) {
		return Single.defer(() -> {
			if (name == null) {
				return Single.error(new NullPointerException("Name must be set"));
			}
			Group group = new GroupImpl(name);
			group.setUuid(UUID.randomUUID());
			if (modifier != null) {
				modifier.accept(group);
			}
			return persistAndReturnElement(group);
		});
	}

	@Override
	public Completable deleteGroup(UUID uuid) {
		return deleteByUuid(GroupImpl.class, uuid);
	}

	@Override
	public Single<? extends Group> updateGroup(Group group) {
		return mergeElement(group);
	}

	@Override
	public Maybe<? extends Group> loadGroup(UUID uuid) {
		return loadByUuid(GroupImpl.class, uuid);
	}

	@Override
	public Completable addUserToGroup(Group group, LoomUser user) {
		GroupImpl g = ((GroupImpl) group);
		LoomUserImpl u = ((LoomUserImpl) user);
		g.addUser(u);
		return persistElement(g);
	}

	@Override
	public Completable removeUserFromGroup(Group group, LoomUser user) {
		GroupImpl g = ((GroupImpl) group);
		LoomUserImpl u = ((LoomUserImpl) user);
		g.removeUser(u);
		return persistElement(g);
	}

	@Override
	public Observable<LoomUser> loadUsers(Group group) {
		Uni<List<LoomUserImpl>> uni = emf.withSession(session -> {
			// "SELECT g FROM LoomUserImpl g"
			Query<LoomUserImpl> q = session.createQuery("SELECT u FROM GroupImpl g JOIN g.users u WHERE g.uuid = :groupUuid", LoomUserImpl.class);
			q.setParameter("groupUuid", group.getUuid());
			return q.getResultList();
		});
		return Single.fromCompletionStage(uni.subscribeAsCompletionStage()).flatMapObservable(list -> Observable.fromIterable(list));
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
	
	@Override
	public Observable<? extends Group> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
