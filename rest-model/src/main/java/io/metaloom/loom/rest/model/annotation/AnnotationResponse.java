package io.metaloom.loom.rest.model.annotation;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;
import io.metaloom.loom.rest.model.tag.TagReference;
import io.metaloom.loom.rest.model.task.TaskResponse;

public class AnnotationResponse extends AbstractCreatorEditorRestResponse<AnnotationResponse> {

	@JsonPropertyDescription("Title of the annotation")
	private String title;

	@JsonPropertyDescription("Spatial or temporal area the annotation references in the asset.")
	private Area area;

	@JsonPropertyDescription("Description of the annotation")
	private String description;

	@JsonPropertyDescription("Tasks assigned to the annotation")
	private List<TaskResponse> tasks = new ArrayList<>();

	@JsonPropertyDescription("Comments for the annotation")
	private List<Comment> comments = new ArrayList<>();

	// TODO spec this
	@JsonPropertyDescription("Thumbnail reference information")
	private String thumbnail;

	@JsonPropertyDescription("List of tags for the entry")
	private List<TagReference> tags = new ArrayList<>();

	public List<TagReference> getTags() {
		return tags;
	}

	public AnnotationResponse setTags(List<TagReference> tags) {
		this.tags = tags;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public AnnotationResponse setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public AnnotationResponse setTitle(String title) {
		this.title = title;
		return this;
	}

	public Area getArea() {
		return area;
	}

	public AnnotationResponse setArea(Area area) {
		this.area = area;
		return this;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public AnnotationResponse setComments(List<Comment> comments) {
		this.comments = comments;
		return this;
	}

	public List<TaskResponse> getTasks() {
		return tasks;
	}

	public AnnotationResponse setTasks(List<TaskResponse> tasks) {
		this.tasks = tasks;
		return this;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public AnnotationResponse setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
		return this;
	}

	@Override
	public AnnotationResponse self() {
		return this;
	}

}
