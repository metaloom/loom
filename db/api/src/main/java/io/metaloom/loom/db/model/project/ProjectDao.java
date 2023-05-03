package io.metaloom.loom.db.model.project;

import io.metaloom.loom.db.CRUDDao;

public interface ProjectDao extends CRUDDao<Project> {

	Project createProject(String name);

}
