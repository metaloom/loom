package io.metaloom.loom.rest.service.impl;

import static io.metaloom.loom.db.model.perm.Permission.CREATE_ROLE;
import static io.metaloom.loom.db.model.perm.Permission.DELETE_ROLE;
import static io.metaloom.loom.db.model.perm.Permission.READ_CLUSTER;
import static io.metaloom.loom.db.model.perm.Permission.READ_ROLE;
import static io.metaloom.loom.db.model.perm.Permission.UPDATE_ROLE;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.metaloom.loom.db.dagger.DaoCollection;
import io.metaloom.loom.db.model.role.Role;
import io.metaloom.loom.db.model.role.RoleDao;
import io.metaloom.loom.rest.LoomRoutingContext;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.service.AbstractCRUDEndpointService;

@Singleton
public class RoleEndpointService extends AbstractCRUDEndpointService<RoleDao, Role, UUID> {

	@Inject
	public RoleEndpointService(RoleDao roleDao, DaoCollection daos, LoomModelBuilder modelBuilder) {
		super(roleDao, daos, modelBuilder);
	}

	@Override
	public void delete(LoomRoutingContext lrc, UUID id) {
		delete(lrc, DELETE_ROLE, id);
	}

	@Override
	public void list(LoomRoutingContext lrc) {
		list(lrc, READ_ROLE, () -> {
			return dao().loadPage(null, 0);
		}, modelBuilder::toRoleList);
	}

	@Override
	public void load(LoomRoutingContext lrc, UUID id) {
		load(lrc, READ_CLUSTER, () -> {
			return dao().load(id);
		}, modelBuilder::toResponse);
	}

	@Override
	public void create(LoomRoutingContext lrc) {
		create(lrc, CREATE_ROLE, () -> {
			String name = null;
			UUID userUuid = lrc.userUuid();
			return dao().createRole(name, userUuid);
		}, modelBuilder::toResponse);
	}

	@Override
	public void update(LoomRoutingContext lrc, UUID id) {
		update(lrc, UPDATE_ROLE, () -> {
			Role role = dao().load(id);
			// TOOD update
			return dao().update(role);
		}, modelBuilder::toResponse);
	}
}
