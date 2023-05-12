package io.metaloom.loom.rest.model.asset;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.annotation.AnnotationResponse;
import io.metaloom.loom.rest.model.asset.location.HashInfo;
import io.metaloom.loom.rest.model.asset.location.LocationReference;
import io.metaloom.loom.rest.model.asset.location.license.LicenseInfo;
import io.metaloom.loom.rest.model.asset.location.social.SocialInfo;
import io.metaloom.loom.rest.model.collection.CollectionResponse;
import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;
import io.metaloom.loom.rest.model.tag.TagReference;

public class AssetResponse extends AbstractCreatorEditorRestResponse<AssetResponse> {

	@JsonPropertyDescription("The current processing status of the asset.")
	private AssetProcessStatus processStatus;

	@JsonPropertyDescription("The specific identified kind of asset.")
	private AssetKind kind;

	@JsonPropertyDescription("The mime type of the asset. (e.g. video/mp4)")
	private String mimeType;

	@JsonPropertyDescription("Times the asset has been viewed.")
	private long views;

	@JsonPropertyDescription("The GPS location of the asset.")
	private AssetGeoLocation geo;

	@JsonPropertyDescription("Licenses related to the asset.")
	private List<LicenseInfo> licenses = new ArrayList<>();

	@JsonPropertyDescription("Information about reactions and ratings of the asset")
	private SocialInfo social;

	@JsonPropertyDescription("A list of tags on the asset.")
	private List<TagReference> tags = new ArrayList<>();

	@JsonPropertyDescription("Annotations on areas of the asset.")
	private List<AnnotationResponse> annotations = new ArrayList<>();

	@JsonPropertyDescription("List of collections to which the asset has been added")
	private List<CollectionResponse> collections = new ArrayList<>();

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

	@JsonProperty(required = true)
	@JsonPropertyDescription("ISO8601 formatted editing date string.")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Instant firstSeen;

	@JsonPropertyDescription("The size of the asset in bytes.")
	private long size;

	// @JsonPropertyDescription("S3 meta information on the asset. (only set when S3 is being utilized).")
	// private AssetS3Meta s3;

	@JsonPropertyDescription("Information about the actual binary media that is represented by the asset.")
	private List<LocationReference> locations = new ArrayList<>();

	public AssetKind getKind() {
		return kind;
	}

	public AssetResponse setKind(AssetKind kind) {
		this.kind = kind;
		return this;
	}

	public AssetProcessStatus getProcessStatus() {
		return processStatus;
	}

	public AssetResponse setProcessStatus(AssetProcessStatus processStatus) {
		this.processStatus = processStatus;
		return this;
	}

	public List<AnnotationResponse> getAnnotations() {
		return annotations;
	}

	public AssetResponse setAnnotations(List<AnnotationResponse> annotations) {
		this.annotations = annotations;
		return this;
	}

	public String getMimeType() {
		return mimeType;
	}

	public AssetResponse setMimeType(String mimeType) {
		this.mimeType = mimeType;
		return this;
	}

	public AssetGeoLocation getGeo() {
		return geo;
	}

	public AssetResponse setGeo(AssetGeoLocation geo) {
		this.geo = geo;
		return this;
	}

	public List<TagReference> getTags() {
		return tags;
	}

	public AssetResponse setTags(List<TagReference> tags) {
		this.tags = tags;
		return this;
	}

	public List<LicenseInfo> getLicenses() {
		return licenses;
	}

	public void setLicenses(List<LicenseInfo> licenses) {
		this.licenses = licenses;
	}

	public List<CollectionResponse> getCollections() {
		return collections;
	}

	public AssetResponse setCollections(List<CollectionResponse> collections) {
		this.collections = collections;
		return this;
	}

	public HashInfo getHashes() {
		return hashes;
	}

	public AssetResponse setHashes(HashInfo hashes) {
		this.hashes = hashes;
		return this;
	}

	public AudioInfo getAudio() {
		return audio;
	}

	public AssetResponse setAudio(AudioInfo audio) {
		this.audio = audio;
		return this;
	}

	public ImageInfo getImage() {
		return image;
	}

	public AssetResponse setImage(ImageInfo image) {
		this.image = image;
		return this;
	}

	public VideoInfo getVideo() {
		return video;
	}

	public AssetResponse setVideo(VideoInfo video) {
		this.video = video;
		return this;
	}

	public DocumentInfo getDocument() {
		return document;
	}

	public AssetResponse setDocument(DocumentInfo document) {
		this.document = document;
		return this;
	}

	public long getSize() {
		return size;
	}

	public AssetResponse setSize(long size) {
		this.size = size;
		return this;
	}

	public Instant getFirstSeen() {
		return firstSeen;
	}

	public AssetResponse setFirstSeen(Instant firstSeen) {
		this.firstSeen = firstSeen;
		return this;
	}

	public String getOrigin() {
		return origin;
	}

	public AssetResponse setOrigin(String origin) {
		this.origin = origin;
		return this;
	}

	public List<LocationReference> getLocations() {
		return locations;
	}

	public AssetResponse setLocations(List<LocationReference> locations) {
		this.locations = locations;
		return this;
	}

	@Override
	public AssetResponse self() {
		return this;
	}

	public void addLocation(LocationReference location) {
		getLocations().add(location);
	}
}
