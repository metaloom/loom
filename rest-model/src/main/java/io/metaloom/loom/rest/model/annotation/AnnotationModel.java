package io.metaloom.loom.rest.model.annotation;

import io.metaloom.loom.rest.model.MetaModel;
import io.metaloom.loom.rest.model.RestModel;

public interface AnnotationModel<T extends AnnotationModel<T>> extends RestModel, MetaModel<T> {

	AnnotationType getType();

	T setType(AnnotationType type);

	String getDescription();

	T setDescription(String description);

	String getTitle();

	T setTitle(String title);

	AreaInfo getArea();

	T setArea(AreaInfo area);

}
