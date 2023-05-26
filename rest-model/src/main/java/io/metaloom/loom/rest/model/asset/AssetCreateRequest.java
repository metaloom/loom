package io.metaloom.loom.rest.model.asset;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestRequestModel;
import io.metaloom.loom.rest.model.annotation.AnnotationResponse;
import io.metaloom.loom.rest.model.asset.info.AudioInfo;
import io.metaloom.loom.rest.model.asset.info.DocumentInfo;
import io.metaloom.loom.rest.model.asset.info.FileInfo;
import io.metaloom.loom.rest.model.asset.info.GeoLocationInfo;
import io.metaloom.loom.rest.model.asset.info.HashInfo;
import io.metaloom.loom.rest.model.asset.info.ImageInfo;
import io.metaloom.loom.rest.model.asset.info.VideoInfo;
import io.metaloom.loom.rest.model.tag.TagReference;
import io.vertx.core.json.JsonObject;

public class AssetCreateRequest implements RestRequestModel, AssetModel<AssetCreateRequest> {

	@JsonPropertyDescription("The specific identified kind of asset.")
	private AssetKind kind;

	@JsonPropertyDescription("The mime type of the asset. (e.g. video/mp4)")
	private String mimeType;

	@JsonPropertyDescription("The dominant color for the asset.")
	private String dominantColor;

	@JsonPropertyDescription("Custom meta properties for the asset.")
	private JsonObject meta;

	@JsonPropertyDescription("The GPS location of the asset.")
	private GeoLocationInfo geo;

	@JsonPropertyDescription("Timeline information on the asset.")
	private List<AnnotationResponse> timeline;

	@JsonPropertyDescription("A list of tags on the asset.")
	private List<TagReference> tags;

	@JsonPropertyDescription("The local path of the asset. This will only be returned when the asset was created using a local path.")
	private String localPath;

	@JsonPropertyDescription("Information about the file of the asset")
	private FileInfo file;

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

	private String origin;

	public AssetCreateRequest() {
	}

	public AssetKind getKind() {
		return kind;
	}

	public AssetCreateRequest setKind(AssetKind kind) {
		this.kind = kind;
		return this;
	}

	@Override
	public GeoLocationInfo getGeo() {
		return geo;
	}

	@Override
	public AssetCreateRequest setGeo(GeoLocationInfo geo) {
		this.geo = geo;
		return this;
	}

	public String getDominantColor() {
		return dominantColor;
	}

	public AssetCreateRequest setDominantColor(String dominantColor) {
		this.dominantColor = dominantColor;
		return this;
	}

	@Override
	public JsonObject getMeta() {
		return meta;
	}

	@Override
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

	@Override
	public HashInfo getHashes() {
		return hashes;
	}

	@Override
	public AssetCreateRequest setHashes(HashInfo hashes) {
		this.hashes = hashes;
		return this;
	}

	@Override
	public AudioInfo getAudio() {
		return audio;
	}

	@Override
	public AssetCreateRequest setAudio(AudioInfo audio) {
		this.audio = audio;
		return this;
	}

	@Override
	public ImageInfo getImage() {
		return image;
	}

	@Override
	public AssetCreateRequest setImage(ImageInfo image) {
		this.image = image;
		return this;
	}

	@Override
	public VideoInfo getVideo() {
		return video;
	}

	@Override
	public AssetCreateRequest setVideo(VideoInfo video) {
		this.video = video;
		return this;
	}

	@Override
	public DocumentInfo getDocument() {
		return document;
	}

	@Override
	public AssetCreateRequest setDocument(DocumentInfo document) {
		this.document = document;
		return this;
	}

	public String getOrigin() {
		return origin;
	}

	public AssetCreateRequest setOrigin(String origin) {
		this.origin = origin;
		return this;
	}

	@Override
	public FileInfo getFile() {
		return file;
	}

	@Override
	public AssetCreateRequest setFile(FileInfo file) {
		this.file = file;
		return this;
	}

	@Override
	public AssetCreateRequest self() {
		return this;
	}
}
