package io.metaloom.loom.db.jooq.dao.project;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;
import org.jooq.Table;
import org.jooq.TableRecord;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.JooqLibrary;
import io.metaloom.loom.db.model.project.Project;
import io.metaloom.loom.db.model.project.ProjectDao;

@Singleton
public class ProjectDaoImpl extends AbstractJooqDao<Project> implements ProjectDao {

	@Inject
	public ProjectDaoImpl(DSLContext ctx) {
		super(ctx);
	}

	@Override
	protected Table<? extends TableRecord<?>> getTable() {
		return JooqLibrary.LIBRARY;
	}

	@Override
	protected Class<? extends Project> getPojoClass() {
		return ProjectImpl.class;
	}

	@Override
	public Project createProject(String name) {
		Project project = new ProjectImpl();
		project.setName(name);
		return project;
	}

}
