package io.metaloom.loom.db.group;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.JooqType;
import io.metaloom.loom.db.jooq.tables.daos.GroupDao;
import io.reactivex.Maybe;

public class JooqGroupsDaoImpl extends AbstractJooqDao implements GroupsDao {

	private final GroupDao delegate;

	protected JooqType getType() {
		return JooqType.GROUP;
	}

	public JooqGroupsDaoImpl(GroupDao delegate) {
		this.delegate = delegate;
	}

	@Override
	public Maybe<? extends Group> loadGroup(UUID uuid) {
		return wrap(delegate.findOneById(uuid), JooqGroupImpl.class);
	}

	@Override
	public void deleteGroup(Group group) {
		Objects.requireNonNull(group, "Group must not be null");
		delegate.deleteById(group.getUuid());
	}

	@Override
	public Group createGroup() {
		io.metaloom.loom.db.jooq.tables.pojos.Group group = new io.metaloom.loom.db.jooq.tables.pojos.Group();
		delegate.insert(group);
		return new JooqGroupImpl(null, group);
	}

	@Override
	public void updateGroup(Group group) {
		Objects.requireNonNull(group, "Group must not be null");
		delegate.update(unwrap(group));
	}

	@Override
	public void storeGroup(Group group) {
		Objects.requireNonNull(group, "Group must not be null");
		delegate.update(unwrap(group));
	}

	@Override
	public void clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
	}

}
