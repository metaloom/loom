package io.metaloom.loom.db.model.annotation;

import java.util.UUID;

import io.metaloom.loom.db.CRUDDao;
import io.metaloom.loom.db.model.asset.Asset;
import io.metaloom.loom.db.model.user.User;

public interface AnnotationDao extends CRUDDao<Annotation> {

	default Annotation createAnnotation(User user, Asset asset, String title, AnnotationType type) {
		return createAnnotation(user.getUuid(), asset.getUuid(), title, type);
	}

	Annotation createAnnotation(UUID userUuid, UUID assetUuid, String title, AnnotationType type);

}
