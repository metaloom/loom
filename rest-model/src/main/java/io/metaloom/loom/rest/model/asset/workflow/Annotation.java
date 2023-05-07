package io.metaloom.loom.rest.model.asset.workflow;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.MetaModel;
import io.metaloom.loom.rest.model.RestModel;
import io.metaloom.loom.rest.model.tag.TagReference;
import io.vertx.core.json.JsonObject;

public class Annotation implements RestModel, MetaModel<Annotation> {

	@JsonPropertyDescription("Title of the annotation")
	private String title;

	@JsonPropertyDescription("Spatial or temporal area the annotation references in the asset.")
	private Area area;

	@JsonPropertyDescription("Description of the annotation")
	private String description;

	@JsonPropertyDescription("Tasks assigned to the annotation")
	private List<Task> tasks = new ArrayList<>();

	@JsonPropertyDescription("Comments for the annotation")
	private List<Comment> comments = new ArrayList<>();

	// TODO spec this
	@JsonPropertyDescription("Thumbnail reference information")
	private String thumbnail;

	@JsonPropertyDescription("Additional custom meta properties.")
	private JsonObject meta;

	@JsonPropertyDescription("List of tags for the entry")
	private List<TagReference> tags = new ArrayList<>();

	@Override
	public JsonObject getMeta() {
		return meta;
	}

	@Override
	public Annotation setMeta(JsonObject meta) {
		this.meta = meta;
		return this;
	}

	public List<TagReference> getTags() {
		return tags;
	}

	public Annotation setTags(List<TagReference> tags) {
		this.tags = tags;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Annotation setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Annotation setTitle(String title) {
		this.title = title;
		return this;
	}

	public Area getArea() {
		return area;
	}

	public Annotation setArea(Area area) {
		this.area = area;
		return this;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public Annotation setComments(List<Comment> comments) {
		this.comments = comments;
		return this;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public Annotation setTasks(List<Task> tasks) {
		this.tasks = tasks;
		return this;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public Annotation setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
		return this;
	}

	@Override
	public Annotation self() {
		return this;
	}

}
