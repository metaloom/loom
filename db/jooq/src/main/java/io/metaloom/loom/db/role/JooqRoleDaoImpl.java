package io.metaloom.loom.db.role;

import static io.metaloom.loom.db.jooq.JooqWrapperHelper.unwrap;
import static io.metaloom.loom.db.jooq.JooqWrapperHelper.wrap;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.Configuration;

import io.metaloom.loom.db.jooq.tables.daos.RoleDao;
import io.metaloom.loom.db.jooq.tables.pojos.Role;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.vertx.reactivex.sqlclient.SqlClient;

@Singleton
public class JooqRoleDaoImpl extends RoleDao implements LoomRoleDao {

	@Inject
	public JooqRoleDaoImpl(Configuration configuration, SqlClient rxSqlClient) {
		super(configuration, rxSqlClient);
	}

	// protected JooqType getType() {
	// return JooqType.ROLE;
	// }

	@Override
	public Maybe<? extends LoomRole> loadRole(UUID uuid) {
		return wrap(findOneById(uuid), JooqRoleImpl.class);
	}

	@Override
	public Completable deleteRole(LoomRole role) {
		Objects.requireNonNull(role, "Role must not be null");
		return deleteById(role.getUuid()).ignoreElement();
	}

	@Override
	public Single<? extends LoomRole> createRole(String name) {
		Role role = new Role();
		return insertReturningPrimary(role).map(pk -> new JooqRoleImpl(role.setUuid(pk)));
	}

	@Override
	public Completable updateRole(LoomRole role) {
		Objects.requireNonNull(role, "Role must not be null");
		Role jooqRole = unwrap(role);
		return update(jooqRole).ignoreElement();
	}

	@Override
	public Completable clear() throws IOException {
		// TODO run jooq SQL to delete contents of table
		return Completable.complete();
	}

}
