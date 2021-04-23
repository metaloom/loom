package io.metaloom.loom.rest.model.asset;

import java.util.List;
import java.util.Map;

import io.metaloom.loom.rest.model.tag.TagReference;

public class AssetTimelineEntry {

	private long from;

	private long to;

	private String thumbail;

	private Map<String, String> meta;

	private List<TagReference> tags;

	private String description;
}
