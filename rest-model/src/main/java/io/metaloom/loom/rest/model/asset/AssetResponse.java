package io.metaloom.loom.rest.model.asset;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;
import io.metaloom.loom.rest.model.tag.TagReference;

public class AssetResponse extends AbstractCreatorEditorRestResponse {

	@JsonPropertyDescription("The current processing status of the asset.")
	private AssetStatus status;

	@JsonPropertyDescription("The specific identified kind of asset.")
	private AssetKind kind;

	@JsonPropertyDescription("A set of different computed hashes for the asset.")
	private AssetHash hashes;

	@JsonPropertyDescription("The filename for the asset.")
	private String filename;

	@JsonPropertyDescription("The image width in pixel of the asset.")
	private int width;

	@JsonPropertyDescription("The image height in pixel of the asset.")
	private int height;

	@JsonPropertyDescription("The size of the asset in bytes.")
	private long size;

	@JsonPropertyDescription("The mime type of the asset. (e.g. video/mp4)")
	private String mimeType;

	@JsonPropertyDescription("The dominant color for the asset.")
	private String dominantColor;

	@JsonPropertyDescription("Custom meta properties for the asset.")
	private Map<String, String> meta;

	@JsonPropertyDescription("The GPS location of the asset.")
	private AssetLocation location;

	@JsonPropertyDescription("A list of tags on the asset.")
	private List<TagReference> tags;

	@JsonPropertyDescription("The duration of the asset media in milliseconds.")
	private long duration;

	@JsonPropertyDescription("Timeline information on the asset.")
	private List<AssetTimelineEntry> timeline;

	@JsonPropertyDescription("S3 meta information on the asset. (only set when S3 is being utilized).")
	private AssetS3Meta s3;

	@JsonPropertyDescription("The local path of the asset. This will only be returned when the asset was created using a local path.")
	private String localPath;

	public AssetResponse() {
	}

	public AssetStatus getStatus() {
		return status;
	}

	public AssetResponse setStatus(AssetStatus status) {
		this.status = status;
		return this;
	}

	public AssetKind getKind() {
		return kind;
	}

	public AssetResponse setKind(AssetKind kind) {
		this.kind = kind;
		return this;
	}

	public long getSize() {
		return size;
	}

	public AssetResponse setSize(long size) {
		this.size = size;
		return this;
	}

	public int getHeight() {
		return height;
	}

	public AssetResponse setHeight(int height) {
		this.height = height;
		return this;
	}

	public int getWidth() {
		return width;
	}

	public AssetResponse setWidth(int width) {
		this.width = width;
		return this;
	}

	public AssetHash getHashes() {
		return hashes;
	}

	public AssetResponse setHashes(AssetHash hashes) {
		this.hashes = hashes;
		return this;
	}

	public AssetS3Meta getS3() {
		return s3;
	}

	public AssetResponse setS3(AssetS3Meta s3) {
		this.s3 = s3;
		return this;
	}

	public List<AssetTimelineEntry> getTimeline() {
		return timeline;
	}

	public AssetResponse setTimeline(List<AssetTimelineEntry> timeline) {
		this.timeline = timeline;
		return this;
	}

	public String getFilename() {
		return filename;
	}

	public AssetResponse setFilename(String fileName) {
		this.filename = fileName;
		return this;
	}

	public String getMimeType() {
		return mimeType;
	}

	public AssetResponse setMimeType(String mimeType) {
		this.mimeType = mimeType;
		return this;
	}

	public Map<String, String> getMeta() {
		return meta;
	}

	public AssetResponse setMeta(Map<String, String> meta) {
		this.meta = meta;
		return this;
	}

	public String getDominantColor() {
		return dominantColor;
	}

	public AssetResponse setDominantColor(String dominantColor) {
		this.dominantColor = dominantColor;
		return this;
	}

	public long getDuration() {
		return duration;
	}

	public AssetResponse setDuration(long duration) {
		this.duration = duration;
		return this;
	}

	public AssetLocation getLocation() {
		return location;
	}

	public AssetResponse setLocation(AssetLocation location) {
		this.location = location;
		return this;
	}

	public String getLocalPath() {
		return localPath;
	}

	public AssetResponse setLocalPath(String localPath) {
		this.localPath = localPath;
		return this;
	}

	public List<TagReference> getTags() {
		return tags;
	}

	public AssetResponse setTags(List<TagReference> tags) {
		this.tags = tags;
		return this;
	}

}
