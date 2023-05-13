package io.metaloom.loom.db.jooq.dao.task;

import static io.metaloom.loom.db.jooq.tables.JooqAnnotationAsset.ANNOTATION_ASSET;
import static io.metaloom.loom.db.jooq.tables.JooqAnnotationTask.ANNOTATION_TASK;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;
import org.jooq.Table;
import org.jooq.TableRecord;

import io.metaloom.loom.db.jooq.AbstractJooqDao;
import io.metaloom.loom.db.jooq.tables.JooqAnnotation;
import io.metaloom.loom.db.jooq.tables.JooqTask;
import io.metaloom.loom.db.model.task.Task;
import io.metaloom.loom.db.model.task.TaskDao;

@Singleton
public class TaskDaoImpl extends AbstractJooqDao<Task,UUID> implements TaskDao {

	@Inject
	public TaskDaoImpl(DSLContext ctx) {
		super(ctx);
	}

	@Override
	protected Table<? extends TableRecord<?>> getTable() {
		return JooqTask.TASK;
	}

	@Override
	protected Class<? extends Task> getPojoClass() {
		return TaskImpl.class;
	}

	@Override
	public Task createTask(UUID userUuid, String title) {
		Task task = new TaskImpl();
		task.setTitle(title);
		setCreatorEditor(task, userUuid);
		return task;
	}
	
	@Override
	public List<Task> loadForAnnotation(UUID annotationUuid) {
		return ctx().select(getTable()).from(getTable())
			.join(ANNOTATION_TASK)
			.on(ANNOTATION_ASSET.ANNOTATION_UUID.eq(JooqAnnotation.ANNOTATION.UUID))
			.where(ANNOTATION_ASSET.ANNOTATION_UUID.eq(annotationUuid))
			.fetchInto(getPojoClass());
	}

}
