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

	String getDescription();

	Annotation setDescription(String description);

	Integer getAreaStartY();

	Annotation setAreaStartY(Integer areaStartY);

	Integer getAreaStartX();

	Annotation setAreaStartX(Integer areaStartX);

	Integer getAreaWidth();

	Annotation setAreaWidth(Integer areaWidth);

	Integer getAreaHeight();

	Annotation setAreaHeight(Integer areaHeight);

	Integer getTimeTo();

	Annotation setTimeTo(Integer timeTo);

	Integer getTimeFrom();

	Annotation setTimeFrom(Integer timeFrom);

}
