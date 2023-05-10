package io.metaloom.loom.db.jooq.dao.annotation;

import java.util.UUID;

import io.metaloom.loom.db.jooq.AbstractEditableElement;
import io.metaloom.loom.db.model.annotation.Annotation;
import io.metaloom.loom.db.model.annotation.AnnotationType;

public class AnnotationImpl extends AbstractEditableElement<Annotation> implements Annotation {

	private AnnotationType type;

	private String title;

	private UUID assetUuid;

	private String description;

	private Integer timeFrom;
	private Integer timeTo;
	private Integer areaStartX;
	private Integer areaStartY;
	private Integer areaWidth;
	private Integer areaHeight;

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public Annotation setTitle(String title) {
		this.title = title;
		return this;
	}

	@Override
	public AnnotationType getType() {
		return type;
	}

	@Override
	public Annotation setType(AnnotationType type) {
		this.type = type;
		return this;
	}

	@Override
	public UUID getAssetUuid() {
		return assetUuid;
	}

	@Override
	public Annotation setAssetUuid(UUID assetUuid) {
		this.assetUuid = assetUuid;
		return this;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public Annotation setDescription(String description) {
		this.description = description;
		return this;
	}

	@Override
	public Integer getTimeFrom() {
		return timeFrom;
	}

	@Override
	public Annotation setTimeFrom(Integer timeFrom) {
		this.timeFrom = timeFrom;
		return this;
	}

	@Override
	public Integer getTimeTo() {
		return timeTo;
	}

	@Override
	public Annotation setTimeTo(Integer timeTo) {
		this.timeTo = timeTo;
		return this;
	}

	@Override
	public Integer getAreaHeight() {
		return areaHeight;
	}

	@Override
	public Annotation setAreaHeight(Integer areaHeight) {
		this.areaHeight = areaHeight;
		return this;
	}

	@Override
	public Integer getAreaWidth() {
		return areaWidth;
	}

	@Override
	public Annotation setAreaWidth(Integer areaWidth) {
		this.areaWidth = areaWidth;
		return this;
	}

	@Override
	public Integer getAreaStartX() {
		return areaStartX;
	}

	@Override
	public Annotation setAreaStartX(Integer areaStartX) {
		this.areaStartX = areaStartX;
		return this;
	}

	@Override
	public Integer getAreaStartY() {
		return areaStartY;
	}

	@Override
	public Annotation setAreaStartY(Integer areaStartY) {
		this.areaStartY = areaStartY;
		return this;
	}
}
