package io.metaloom.loom.rest.model.asset;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.metaloom.loom.rest.model.tag.TagReference;

public class AssetTimelineEntry {

	private long from;

	private long to;

	private String thumbail;

	private Map<String, String> meta;

	private List<TagReference> tags;

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
	public void setArea(long from, long to) {
		this.from = from;
		this.to = to;
	}

}
