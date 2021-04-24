package io.metaloom.loom.rest.model.asset;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestModel;
import io.metaloom.loom.rest.model.tag.TagReference;

public class AssetUpdateRequest implements RestModel {

	@JsonPropertyDescription("The specific identified kind of asset.")
	private AssetKind kind;

	@JsonPropertyDescription("The filename for the asset.")
	private String filename;

	@JsonPropertyDescription("The mime type of the asset. (e.g. video/mp4)")
	private String mimeType;

	@JsonPropertyDescription("The dominant color for the asset.")
	private String dominantColor;

	@JsonPropertyDescription("Custom meta properties for the asset.")
	private Map<String, String> meta;

	@JsonPropertyDescription("The GPS location of the asset.")
	private AssetLocation location;

	@JsonPropertyDescription("Timeline information on the asset.")
	private List<AssetTimelineEntry> timeline;

	@JsonPropertyDescription("S3 meta information on the asset. (only set when S3 is being utilized).")
	private AssetS3Meta s3;

	@JsonPropertyDescription("The local path of the asset. This will only be returned when the asset was created using a local path.")
	private String localPath;

	@JsonPropertyDescription("A list of tags on the asset.")
	private List<TagReference> tags;

	public AssetUpdateRequest() {
	}

	public AssetKind getKind() {
		return kind;
	}

	public AssetUpdateRequest setKind(AssetKind kind) {
		this.kind = kind;
		return this;
	}

	public AssetS3Meta getS3() {
		return s3;
	}

	public AssetUpdateRequest setS3(AssetS3Meta s3) {
		this.s3 = s3;
		return this;
	}

	public String getFilename() {
		return filename;
	}

	public AssetUpdateRequest setFilename(String filename) {
		this.filename = filename;
		return this;
	}

	public String getMimeType() {
		return mimeType;
	}

	public AssetUpdateRequest setMimeType(String mimeType) {
		this.mimeType = mimeType;
		return this;
	}

	public AssetLocation getLocation() {
		return location;
	}

	public AssetUpdateRequest setLocation(AssetLocation location) {
		this.location = location;
		return this;
	}

	public String getDominantColor() {
		return dominantColor;
	}

	public AssetUpdateRequest setDominantColor(String dominantColor) {
		this.dominantColor = dominantColor;
		return this;
	}

	public Map<String, String> getMeta() {
		return meta;
	}

	public AssetUpdateRequest setMeta(Map<String, String> meta) {
		this.meta = meta;
		return this;
	}

	public List<AssetTimelineEntry> getTimeline() {
		return timeline;
	}

	public AssetUpdateRequest setTimeline(List<AssetTimelineEntry> timeline) {
		this.timeline = timeline;
		return this;
	}

	public String getLocalPath() {
		return localPath;
	}

	public AssetUpdateRequest setLocalPath(String localPath) {
		this.localPath = localPath;
		return this;
	}

	public List<TagReference> getTags() {
		return tags;
	}

	public AssetUpdateRequest setTags(List<TagReference> tags) {
		this.tags = tags;
		return this;
	}

}
