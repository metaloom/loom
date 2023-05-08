package io.metaloom.loom.rest.builder;

import io.metaloom.loom.db.model.annotation.Annotation;
import io.metaloom.loom.db.page.Page;
import io.metaloom.loom.rest.model.annotation.AnnotationListResponse;
import io.metaloom.loom.rest.model.annotation.AnnotationResponse;

public interface AnnotationModelBuilder extends ModelBuilder, UserModelBuilder {

	default AnnotationResponse toResponse(Annotation annotation) {
		AnnotationResponse response = new AnnotationResponse();
		response.setUuid(annotation.getUuid());
		response.setTitle(annotation.getTitle());
		setStatus(annotation, response);
		return response;
	}

	default AnnotationListResponse toAnnotationList(Page<Annotation> page) {
		return setPage(new AnnotationListResponse(), page, annotation -> {
			return toResponse(annotation);
		});
	}

}
