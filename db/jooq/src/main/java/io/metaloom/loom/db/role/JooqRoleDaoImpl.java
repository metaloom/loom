package io.metaloom.loom.db.role;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.Configuration;

import io.reactivex.Maybe;
import io.reactivex.Single;
import io.vertx.reactivex.sqlclient.SqlClient;

@Singleton
public class JooqRoleDaoImpl extends io.metaloom.loom.db.jooq.tables.daos.RoleDao implements RoleDao {

	@Inject
	public JooqRoleDaoImpl(Configuration configuration, SqlClient rxSqlClient) {
		super(configuration, rxSqlClient);
	}

	// protected JooqType getType() {
	// return JooqType.ROLE;
	// }

	@Override
	public Maybe<? extends Role> loadRole(UUID uuid) {
		return wrap(findOneById(uuid), JooqRoleImpl.class);
	}

	@Override
	public void deleteRole(Role role) {
		Objects.requireNonNull(role, "Role must not be null");
		deleteById(role.getUuid());
	}

	@Override
	public Single<? extends Role> createRole(String name) {
		io.metaloom.loom.db.jooq.tables.pojos.Role role = new io.metaloom.loom.db.jooq.tables.pojos.Role();
		return insertReturningPrimary(role).map(pk -> new JooqRoleImpl(role.setUuid(pk)));
	}

	@Override
	public void updateRole(Role role) {
		Objects.requireNonNull(role, "Role must not be null");
		io.metaloom.loom.db.jooq.tables.pojos.Role jooqRole = unwrap(role);
		update(jooqRole);
	}

	@Override
	public void storeRole(Role role) {
		Objects.requireNonNull(role, "Role must not be null");
		JooqRoleImpl jooqRole = (JooqRoleImpl) role;
		update(jooqRole.getDelegate());
	}

	@Override
	public void clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
	}

}
