package io.metaloom.loom.rest.model.asset;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestRequestModel;
import io.metaloom.loom.rest.model.annotation.AnnotationResponse;
import io.metaloom.loom.rest.model.asset.location.AssetS3Meta;
import io.metaloom.loom.rest.model.asset.location.HashInfo;
import io.metaloom.loom.rest.model.tag.TagReference;
import io.vertx.core.json.JsonObject;

public class AssetUpdateRequest implements RestRequestModel {

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

	@JsonPropertyDescription("S3 meta information on the asset. (only set when S3 is being utilized).")
	private AssetS3Meta s3;

	@JsonPropertyDescription("The local path of the asset. This will only be returned when the asset was created using a local path.")
	private String localPath;

	@JsonPropertyDescription("A list of tags on the asset.")
	private List<TagReference> tags;

	@JsonPropertyDescription("A set of different computed hashes for the asset.")
	private HashInfo hashes;

	@JsonPropertyDescription("Information about the image component of the asset (if present)")
	private ImageInfo image;

	@JsonPropertyDescription("Information about the video component of the asset (if present)")
	private VideoInfo video;

	@JsonPropertyDescription("Information about the audio component of the asset (if present)")
	private AudioInfo audio;

	@JsonPropertyDescription("Information about the document (text) component of the asset (if present)")
	private DocumentInfo document;

	@JsonPropertyDescription("The spatial location of the asset.")
	private AssetGeoLocation geo;
	
	@JsonPropertyDescription("The size of the asset in bytes.")
	private long size;

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

	public AssetGeoLocation getLocation() {
		return location;
	}

	public AssetUpdateRequest setLocation(AssetGeoLocation location) {
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

	public JsonObject getMeta() {
		return meta;
	}

	public AssetUpdateRequest setMeta(JsonObject meta) {
		this.meta = meta;
		return this;
	}

	public List<AnnotationResponse> getTimeline() {
		return timeline;
	}

	public AssetUpdateRequest setTimeline(List<AnnotationResponse> timeline) {
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

	public HashInfo getHashes() {
		return hashes;
	}

	public AssetUpdateRequest setHashes(HashInfo hashes) {
		this.hashes = hashes;
		return this;
	}

	public AudioInfo getAudio() {
		return audio;
	}

	public AssetUpdateRequest setAudio(AudioInfo audio) {
		this.audio = audio;
		return this;
	}

	public ImageInfo getImage() {
		return image;
	}

	public AssetUpdateRequest setImage(ImageInfo image) {
		this.image = image;
		return this;
	}

	public VideoInfo getVideo() {
		return video;
	}

	public AssetUpdateRequest setVideo(VideoInfo video) {
		this.video = video;
		return this;
	}

	public DocumentInfo getDocument() {
		return document;
	}

	public AssetUpdateRequest setDocument(DocumentInfo document) {
		this.document = document;
		return this;
	}

	public AssetGeoLocation getGeo() {
		return geo;
	}

	public AssetUpdateRequest setGeo(AssetGeoLocation geo) {
		this.geo = geo;
		return this;
	}
	
	public long getSize() {
		return size;
	}

	public AssetUpdateRequest setSize(long size) {
		this.size = size;
		return this;
	}


}
