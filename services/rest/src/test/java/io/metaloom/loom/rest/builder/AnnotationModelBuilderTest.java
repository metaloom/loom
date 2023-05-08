package io.metaloom.loom.rest.builder;

import static org.mockito.Mockito.mock;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import io.metaloom.loom.db.model.annotation.Annotation;
import io.metaloom.loom.db.model.user.User;
import io.metaloom.loom.db.page.Page;
import io.metaloom.loom.rest.model.annotation.AnnotationListResponse;

public class AnnotationModelBuilderTest extends AbstractModelBuilderTest {

	@Test
	@Override
	void testResponseModel() throws IOException {
		Annotation annotation = mockAnnotation();
		User user = mockUser("joedoe");
		assertWithModel(builder().toResponse(annotation, user, user), "annotation.response");
	}

	@Test
	@Override
	void testListResponseModel() throws IOException {
		Annotation annotation = mockAnnotation();
		Page<Annotation> page = mockPage(annotation, annotation);
		AnnotationListResponse list = builder().toAnnotationList(page);
		assertWithModel(list, "annotation.list_response");
	}

	private Annotation mockAnnotation() {
		Annotation annotation = mock(Annotation.class);
		annotation.setTitle("the_title");
		return annotation;
	}
}
