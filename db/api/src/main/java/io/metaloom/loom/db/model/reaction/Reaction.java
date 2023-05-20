package io.metaloom.loom.db.model.reaction;

import java.util.UUID;

import io.metaloom.loom.db.CUDElement;
import io.metaloom.loom.db.MetaElement;

public interface Reaction extends CUDElement<Reaction>, MetaElement<Reaction> {

	String getType();

	Reaction setType(String type);

	Integer getRating();

	Reaction setRating(Integer rating);

	Reaction setAssetUuid(UUID assetUuid);

	UUID getAssetUuid();

	Reaction setCommentUuid(UUID commentUuid);

	UUID getCommentUuid();

	Reaction setAnnotationUuid(UUID annotationUuid);

	UUID getAnnotationUuid();

}
