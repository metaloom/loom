package io.metaloom.loom.rest.builder;

import java.util.List;
import java.util.stream.Collectors;

import io.metaloom.loom.db.model.annotation.Annotation;
import io.metaloom.loom.db.model.task.Task;
import io.metaloom.loom.db.page.Page;
import io.metaloom.loom.rest.model.annotation.AnnotationListResponse;
import io.metaloom.loom.rest.model.annotation.AnnotationResponse;
import io.metaloom.loom.rest.model.annotation.Area;
import io.metaloom.loom.rest.model.task.TaskResponse;

public interface AnnotationModelBuilder extends ModelBuilder, UserModelBuilder, TaskModelBuilder {

	default AnnotationResponse toResponse(Annotation annotation) {
		AnnotationResponse response = new AnnotationResponse();
		response.setUuid(annotation.getUuid());
		response.setTitle(annotation.getTitle());
		response.setMeta(annotation.getMeta());
		response.setDescription(annotation.getDescription());
		response.setArea(annotationArea(annotation));

		List<Task> tasks = daos().taskDao().loadForAnnotation(annotation.getUuid());
		List<TaskResponse> restTasks = tasks.stream().map(this::toResponse).collect(Collectors.toList());
		response.setTasks(restTasks);

		setStatus(annotation, response);
		return response;
	}

	default Area annotationArea(Annotation annotation) {
		Area area = new Area();
		area.setFrom(0);
		area.setTo(0);
		area.setHeight(0);
		area.setWidth(0);
		area.setStartX(0);
		area.setStartY(0);
		return area;
	}

	default AnnotationListResponse toAnnotationList(Page<Annotation> page) {
		return setPage(new AnnotationListResponse(), page, annotation -> {
			return toResponse(annotation);
		});
	}

}
