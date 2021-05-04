package io.metaloom.loom.db.role;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.JooqType;
import io.metaloom.loom.db.jooq.tables.daos.RoleDao;
import io.reactivex.Maybe;

public class JooqRolesDaoImpl extends AbstractJooqDao implements RolesDao {

	private final RoleDao delegate;

	protected JooqType getType() {
		return JooqType.ROLE;
	}

	public JooqRolesDaoImpl(RoleDao delegate) {
		this.delegate = delegate;
	}

	@Override
	public Maybe<? extends Role> loadRole(UUID uuid) {
		return wrap(delegate.findOneById(uuid), JooqRoleImpl.class);
	}

	@Override
	public void deleteRole(Role role) {
		Objects.requireNonNull(role, "Role must not be null");
		delegate.deleteById(role.getUuid());
	}

	@Override
	public Role createRole() {
		io.metaloom.loom.db.jooq.tables.pojos.Role role = new io.metaloom.loom.db.jooq.tables.pojos.Role();
		delegate.insert(role);
		return new JooqRoleImpl(role);
	}

	@Override
	public void updateRole(Role role) {
		Objects.requireNonNull(role, "Role must not be null");
		io.metaloom.loom.db.jooq.tables.pojos.Role jooqRole = unwrap(role);
		delegate.update(jooqRole);
	}

	@Override
	public void storeRole(Role role) {
		Objects.requireNonNull(role, "Role must not be null");
		JooqRoleImpl jooqRole = (JooqRoleImpl) role;
		delegate.update(jooqRole.getDelegate());
	}

	@Override
	public void clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
	}

}
