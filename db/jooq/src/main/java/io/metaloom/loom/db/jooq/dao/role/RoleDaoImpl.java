package io.metaloom.loom.db.jooq.dao.role;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;
import org.jooq.Table;
import org.jooq.TableRecord;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.JooqRole;
import io.metaloom.loom.db.model.role.Role;
import io.metaloom.loom.db.model.role.RoleDao;

@Singleton
public class RoleDaoImpl extends AbstractJooqDao<Role> implements RoleDao {

	@Inject
	public RoleDaoImpl(DSLContext ctx) {
		super(ctx);
	}

	@Override
	protected Table<? extends TableRecord<?>> getTable() {
		return JooqRole.ROLE;
	}

	@Override
	protected Class<? extends Role> getPojoClass() {
		return RoleImpl.class;
	}

	@Override
	public Role createRole(String name, UUID creatorUUID) {
		Role r = new RoleImpl();
		r.setCreatorUuid(creatorUUID);
		r.setUuid(UUID.randomUUID());
		r.setName(name);
		return r;
	}

}
