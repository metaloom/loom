package io.metaloom.loom.rest.model.asset;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestModel;
import io.metaloom.loom.rest.model.tag.TagReference;

public class AssetTimelineEntry implements RestModel {

	@JsonPropertyDescription("Start time of the entry in milliseconds")
	private long from;

	@JsonPropertyDescription("End time of the entry in milliseconds")
	private long to;

	// TODO spec this
	@JsonPropertyDescription("Thumbnail reference information")
	private String thumbail;

	@JsonPropertyDescription("Additional custom meta properties.")
	private Map<String, String> meta;

	@JsonPropertyDescription("List of tags for the entry")
	private List<TagReference> tags;

	@JsonPropertyDescription("Description of the entry")
	private String description;

	public long getFrom() {
		return from;
	}

	public AssetTimelineEntry setFrom(long from) {
		this.from = from;
		return this;
	}

	public long getTo() {
		return to;
	}

	public AssetTimelineEntry setTo(long to) {
		this.to = to;
		return this;
	}

	public String getThumbail() {
		return thumbail;
	}

	public AssetTimelineEntry setThumbail(String thumbail) {
		this.thumbail = thumbail;
		return this;
	}

	public Map<String, String> getMeta() {
		return meta;
	}

	public AssetTimelineEntry setMeta(Map<String, String> meta) {
		this.meta = meta;
		return this;
	}

	public List<TagReference> getTags() {
		return tags;
	}

	public AssetTimelineEntry setTags(List<TagReference> tags) {
		this.tags = tags;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public AssetTimelineEntry setDescription(String description) {
		this.description = description;
		return this;
	}

	@JsonIgnore
	public AssetTimelineEntry setArea(long from, long to) {
		this.from = from;
		this.to = to;
		return this;
	}

}
