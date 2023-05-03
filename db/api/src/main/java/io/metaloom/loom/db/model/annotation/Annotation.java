package io.metaloom.loom.db.model.annotation;

import java.util.UUID;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.Taggable;

public interface Annotation extends CUDElement<Annotation>, Taggable {

	String getTitle();

	Annotation setTitle(String title);

	AnnotationType getType();

	Annotation setType(AnnotationType type);

	UUID getAssetUuid();

	Annotation setAssetUuid(UUID assetUuid);

}
