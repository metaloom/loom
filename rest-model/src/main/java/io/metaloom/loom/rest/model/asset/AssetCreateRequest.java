package io.metaloom.loom.rest.model.asset;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestRequestModel;
import io.metaloom.loom.rest.model.annotation.AnnotationResponse;
import io.metaloom.loom.rest.model.asset.location.AssetS3Meta;
import io.metaloom.loom.rest.model.tag.TagReference;
import io.vertx.core.json.JsonObject;

public class AssetCreateRequest implements RestRequestModel {

	@JsonPropertyDescription("The specific identified kind of asset.")
	private AssetKind kind;

	@JsonPropertyDescription("The filename for the asset.")
	private String filename;

	@JsonPropertyDescription("The mime type of the asset. (e.g. video/mp4)")
	private String mimeType;

	@JsonPropertyDescription("The dominant color for the asset.")
	private String dominantColor;

	@JsonPropertyDescription("Custom meta properties for the asset.")
	private JsonObject meta;

	@JsonPropertyDescription("The GPS location of the asset.")
	private AssetGeoLocation location;

	@JsonPropertyDescription("Timeline information on the asset.")
	private List<AnnotationResponse> timeline;

	@JsonPropertyDescription("A list of tags on the asset.")
	private List<TagReference> tags;

	@JsonPropertyDescription("The local path of the asset. This will only be returned when the asset was created using a local path.")
	private String localPath;

	public AssetCreateRequest() {
	}

	public AssetKind getKind() {
		return kind;
	}

	public AssetCreateRequest setKind(AssetKind kind) {
		this.kind = kind;
		return this;
	}

	public String getFilename() {
		return filename;
	}

	public AssetCreateRequest setFilename(String fileName) {
		this.filename = fileName;
		return this;
	}

	public String getMimeType() {
		return mimeType;
	}

	public AssetCreateRequest setMimeType(String mimeType) {
		this.mimeType = mimeType;
		return this;
	}

	public AssetGeoLocation getLocation() {
		return location;
	}

	public AssetCreateRequest setLocation(AssetGeoLocation location) {
		this.location = location;
		return this;
	}

	public String getDominantColor() {
		return dominantColor;
	}

	public AssetCreateRequest setDominantColor(String dominantColor) {
		this.dominantColor = dominantColor;
		return this;
	}

	public JsonObject getMeta() {
		return meta;
	}

	public AssetCreateRequest setMeta(JsonObject meta) {
		this.meta = meta;
		return this;
	}

	public List<AnnotationResponse> getTimeline() {
		return timeline;
	}

	public AssetCreateRequest setTimeline(List<AnnotationResponse> timeline) {
		this.timeline = timeline;
		return this;
	}

	public String getLocalPath() {
		return localPath;
	}

	public AssetCreateRequest setLocalPath(String localPath) {
		this.localPath = localPath;
		return this;
	}

	public List<TagReference> getTags() {
		return tags;
	}

	public AssetCreateRequest setTags(List<TagReference> tags) {
		this.tags = tags;
		return this;
	}

}
