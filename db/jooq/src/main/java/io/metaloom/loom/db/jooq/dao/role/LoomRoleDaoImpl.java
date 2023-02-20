package io.metaloom.loom.db.jooq.dao.role;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.util.UUID;
import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;

import io.metaloom.loom.db.jooq.AbstractDao;
import io.metaloom.loom.db.jooq.tables.daos.RoleDao;
import io.metaloom.loom.db.model.role.LoomRole;
import io.metaloom.loom.db.model.role.LoomRoleDao;

@Singleton
public class LoomRoleDaoImpl extends AbstractDao implements LoomRoleDao {

	private RoleDao dao;

	@Inject
	public LoomRoleDaoImpl(RoleDao dao, DSLContext ctx) {
		super(ctx);
		this.dao = dao;
	}

	// protected JooqType getType() {
	// return JooqType.ROLE;
	// }

	@Override
	public LoomRole loadRole(UUID uuid) {
		return wrap(dao.findById(uuid), LoomRoleImpl.class);
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
	public void clear() {
		// TODO run jooq SQL to delete contents of table
	}

	@Override
	public LoomRole createRole(String name, Consumer<LoomRole> modifier) {
		// TODO Auto-generated method stub
		return null;
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
