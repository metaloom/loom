package io.metaloom.loom.db.jooq.dao.role;

import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.daos.JooqRoleDao;
import io.metaloom.loom.db.jooq.tables.pojos.JooqRole;
import io.metaloom.loom.db.model.role.LoomRole;
import io.metaloom.loom.db.model.role.LoomRoleDao;

@Singleton
public class LoomRoleDaoImpl extends AbstractJooqDao<JooqRoleDao> implements LoomRoleDao {

	@Inject
	public LoomRoleDaoImpl(JooqRoleDao dao, DSLContext ctx) {
		super(dao, ctx);
	}

	// protected JooqType getType() {
	// return JooqType.ROLE;
	// }

	@Override
	public LoomRole loadRole(UUID uuid) {
		return wrap(dao().findById(uuid));
	}

	// @Override
	// public Completable deleteRole(UUID uuid) {
	// Objects.requireNonNull(uuid, "Role uuid must not be null");
	// return deleteById(uuid).ignoreElement();
	// }
	//
	// @Override
	// public Single<? extends LoomRole> createRole(String name) {
	// Role role = new Role();
	// return insertReturningPrimary(role).map(pk -> new LoomRoleImpl(role.setUuid(pk)));
	// }
	//
	// @Override
	// public Completable updateRole(LoomRole role) {
	// Objects.requireNonNull(role, "Role must not be null");
	// Role jooqRole = unwrap(role);
	// return update(jooqRole).ignoreElement();
	// }

	@Override
	public LoomRole createRole(String name, UUID creatorUUID) {
		JooqRole r = new JooqRole();
		r.setCreatorUuid(creatorUUID);
		r.setUuid(UUID.randomUUID());
		r.setName(name);
		return new LoomRoleImpl(r);
	}

	@Override
	public void storeRole(LoomRole role) {
		JooqRole jooq = unwrap(role);
		dao().insert(jooq);
	}

	@Override
	public void deleteRole(UUID uuid) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateRole(LoomRole role) {
		// TODO Auto-generated method stub
	}

}
