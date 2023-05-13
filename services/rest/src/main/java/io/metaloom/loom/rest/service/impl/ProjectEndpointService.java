package io.metaloom.loom.rest.service.impl;

import static io.metaloom.loom.db.model.perm.Permission.CREATE_PROJECT;
import static io.metaloom.loom.db.model.perm.Permission.DELETE_PROJECT;
import static io.metaloom.loom.db.model.perm.Permission.READ_PROJECT;
import static io.metaloom.loom.db.model.perm.Permission.UPDATE_PROJECT;

import java.util.UUID;

import javax.inject.Singleton;

import io.metaloom.loom.db.dagger.DaoCollection;
import io.metaloom.loom.db.model.project.Project;
import io.metaloom.loom.db.model.project.ProjectDao;
import io.metaloom.loom.rest.LoomRoutingContext;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.service.AbstractCRUDEndpointService;

@Singleton
public class ProjectEndpointService extends AbstractCRUDEndpointService<ProjectDao, Project, UUID> {

	@Singleton
	public ProjectEndpointService(ProjectDao projectDao, DaoCollection daos, LoomModelBuilder modelBuilder) {
		super(projectDao, daos, modelBuilder);
	}

	@Override
	public void delete(LoomRoutingContext lrc, UUID id) {
		delete(lrc, DELETE_PROJECT, id);
	}

	@Override
	public void list(LoomRoutingContext lrc) {
		list(lrc, READ_PROJECT, () -> {
			return dao().loadPage(null, 0);
		}, modelBuilder::toProjectList);
	}

	@Override
	public void load(LoomRoutingContext lrc, UUID id) {
		load(lrc, READ_PROJECT, () -> {
			return dao().load(id);
		}, modelBuilder::toResponse);
	}

	@Override
	public void create(LoomRoutingContext lrc) {
		create(lrc, CREATE_PROJECT, () -> {
			UUID userUuid = lrc.userUuid();
			String name = null;
			return dao().createProject(userUuid, name);
		}, modelBuilder::toResponse);
	}

	@Override
	public void update(LoomRoutingContext lrc, UUID id) {
		update(lrc, UPDATE_PROJECT, () -> {
			Project project = dao().load(id);
			// TOOD update
			return dao().update(project);
		}, modelBuilder::toResponse);
	}

}
