package io.metaloom.loom.rest.builder;

import io.metaloom.loom.db.model.annotation.Annotation;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.db.page.Page;
import io.metaloom.loom.rest.model.annotation.AnnotationListResponse;
import io.metaloom.loom.rest.model.annotation.AnnotationResponse;

public interface AnnotationModelBuilder extends ModelBuilder, UserModelBuilder {

	default AnnotationResponse toResponse(Annotation annotation, User creator, User editor) {
		AnnotationResponse response = new AnnotationResponse();
		response.setTitle(annotation.getTitle());
		setStatus(annotation, creator, editor, response);
		return response;
	}

	default AnnotationListResponse toAnnotationList(Page<Annotation> page) {
		AnnotationListResponse response = new AnnotationListResponse();
		for (Annotation annotation : page) {
			response.add(toResponse(annotation, null, null));
		}
		return response;
	}

}
