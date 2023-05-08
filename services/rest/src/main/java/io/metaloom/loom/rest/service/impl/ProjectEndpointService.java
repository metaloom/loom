package io.metaloom.loom.rest.service.impl;

import javax.inject.Singleton;

import io.metaloom.loom.db.model.project.Project;
import io.metaloom.loom.db.model.project.ProjectDao;
import io.metaloom.loom.rest.builder.LoomModelBuilder;
import io.metaloom.loom.rest.service.AbstractCRUDEndpointService;

@Singleton
public class ProjectEndpointService extends AbstractCRUDEndpointService<ProjectDao, Project> {

	@Singleton
	public ProjectEndpointService(ProjectDao projectDao, LoomModelBuilder modelBuilder) {
		super(projectDao, modelBuilder);
	}

}
