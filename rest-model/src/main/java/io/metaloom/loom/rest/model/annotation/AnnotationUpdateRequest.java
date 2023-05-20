package io.metaloom.loom.rest.model.annotation;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestRequestModel;
import io.metaloom.loom.rest.model.common.AbstractMetaModel;

public class AnnotationUpdateRequest extends AbstractMetaModel<AnnotationUpdateRequest> implements RestRequestModel {

	@JsonPropertyDescription("Title of the annotation")
	private String title;

	@JsonPropertyDescription("Spatial or temporal area the annotation references in the asset.")
	private AreaInfo area;

	@JsonPropertyDescription("Description of the annotation")
	private String description;

	public String getDescription() {
		return description;
	}

	public AnnotationUpdateRequest setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public AnnotationUpdateRequest setTitle(String title) {
		this.title = title;
		return this;
	}

	public AreaInfo getArea() {
		return area;
	}

	public AnnotationUpdateRequest setArea(AreaInfo area) {
		this.area = area;
		return this;
	}

	@Override
	public AnnotationUpdateRequest self() {
		return this;
	}

}
