package io.metaloom.loom.db.model.project;

import io.metaloom.loom.db.CUDElement;

public interface Project extends CUDElement<Project> {

	String getName();

	Project setName(String name);

}
