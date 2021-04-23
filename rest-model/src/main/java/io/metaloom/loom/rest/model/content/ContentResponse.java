package io.metaloom.loom.rest.model.content;

import java.util.List;

import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;
import io.metaloom.loom.rest.model.model.ModelReference;
import io.metaloom.loom.rest.model.tag.TagReference;

public class ContentResponse extends AbstractCreatorEditorRestResponse {

	private String version;

	private ModelReference model;

	private ContentReference parent;

	private List<TagReference> tags;

	private List<ContentField> fields;

	public ContentResponse() {

	}

	public String getVersion() {
		return version;
	}

	public ContentResponse setVersion(String version) {
		this.version = version;
		return this;
	}

	public ModelReference getModel() {
		return model;
	}

	public ContentResponse setModel(ModelReference model) {
		this.model = model;
		return this;
	}

	public ContentReference getParent() {
		return parent;
	}

	public ContentResponse setParent(ContentReference parent) {
		this.parent = parent;
		return this;
	}

	public List<TagReference> getTags() {
		return tags;
	}

	public ContentResponse setTags(List<TagReference> tags) {
		this.tags = tags;
		return this;
	}

	public List<ContentField> getFields() {
		return fields;
	}

	public ContentResponse setFields(List<ContentField> fields) {
		this.fields = fields;
		return this;
	}

}
