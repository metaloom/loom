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
}
