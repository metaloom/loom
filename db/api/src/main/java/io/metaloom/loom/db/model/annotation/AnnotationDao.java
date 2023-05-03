package io.metaloom.loom.db.model.annotation;

import io.metaloom.loom.db.CRUDDao;

public interface AnnotationDao extends CRUDDao<Annotation> {

	Annotation createAnnotation(String title);

}
