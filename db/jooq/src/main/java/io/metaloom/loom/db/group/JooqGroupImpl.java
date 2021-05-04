package io.metaloom.loom.db.group;

import static io.metaloom.loom.db.jooq.tables.User.USER;
import static io.metaloom.loom.db.jooq.tables.UserGroup.USER_GROUP;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import io.github.jklingsporn.vertx.jooq.rx.reactivepg.ReactiveRXQueryExecutor;
import io.metaloom.loom.db.jooq.AbstractJooqCUDElement;
import io.metaloom.loom.db.jooq.JooqDaoCollection;
import io.metaloom.loom.db.jooq.JooqWrapper;
import io.metaloom.loom.db.jooq.JooqWrapperHelper;
import io.metaloom.loom.db.jooq.tables.records.UserGroupRecord;
import io.metaloom.loom.db.jooq.tables.records.UserRecord;
import io.metaloom.loom.db.role.Role;
import io.metaloom.loom.db.user.JooqUserImpl;
import io.metaloom.loom.db.user.User;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public class JooqGroupImpl extends AbstractJooqCUDElement implements Group, JooqWrapper<io.metaloom.loom.db.jooq.tables.pojos.Group> {

	private final io.metaloom.loom.db.jooq.tables.pojos.Group delegate;

	public JooqGroupImpl(JooqDaoCollection daos, io.metaloom.loom.db.jooq.tables.pojos.Group delegate) {
		super(daos);
		this.delegate = delegate;
	}

	@Override
	public String getName() {
		return delegate.getName();
	}

	@Override
	public Group setName(String name) {
		delegate.setName(name);
		return this;
	}

	@Override
	public User getCreator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalDateTime getCdate() {
		return delegate.getCreated();
	}

	@Override
	public LocalDateTime getEdate() {
		return delegate.getEdited();
	}

	@Override
	public User getEditor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID getUuid() {
		return delegate.getUuid();
	}

	@Override
	public void setUuid(UUID uuid) {
		delegate.setUuid(uuid);
	}

	@Override
	public void setCdate(LocalDateTime cdate) {
		delegate.setCreated(cdate);
	}

	@Override
	public void setCreator(User creator) {
		delegate.setCreatorUuid(creator.getUuid());
	}

	@Override
	public void setEdate(LocalDateTime edate) {
		delegate.setEdited(edate);
	}

	@Override
	public void setEditor(User editor) {
		delegate.setEditorUuid(editor.getUuid());
	}

	@Override
	public Observable<Role> findRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group addRole(Role role) {

		return this;
	}

	@Override
	public Group addUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group removeRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Completable removeUser(User user) {
		UserGroupRecord record = new UserGroupRecord(user.getUuid(), getUuid());
		return daos.getUserGroupDao().deleteById(record).ignoreElement();
	}

	@Override
	public Observable<User> findUsers() {
		ReactiveRXQueryExecutor<UserRecord, io.metaloom.loom.db.jooq.tables.pojos.User, UUID> queryExecutor = daos.getUserDao().queryExecutor();
		Single<List<io.metaloom.loom.db.jooq.tables.pojos.User>> result = queryExecutor.findMany(dslContext -> dslContext.select()
			.from(USER_GROUP
				.join(USER)
				.on(USER.UUID.eq(USER_GROUP.USER_UUID))
				.where(USER_GROUP.GROUP_UUID.eq(getUuid())).asTable(USER))
			.coerce(USER));

		return result.flatMapObservable(list -> {
			return Observable.fromIterable(list);
		}).map(jooq -> {
			return JooqWrapperHelper.wrap(jooq, JooqUserImpl.class);
		});
	}

	@Override
	public io.metaloom.loom.db.jooq.tables.pojos.Group getDelegate() {
		return delegate;
	}

}
