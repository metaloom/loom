package io.metaloom.loom.rest.builder;

import io.metaloom.loom.db.model.project.Project;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.rest.model.project.ProjectResponse;

public interface ProjectModelBuilder extends ModelBuilder, UserModelBuilder {
	
	default ProjectResponse toResponse(Project project, User creator, User editor) {
		ProjectResponse response = new ProjectResponse();
		response.setUuid(project.getUuid());
		setStatus(project, creator, editor, response);
		return response;
	}

}
