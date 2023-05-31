package io.metaloom.loom.rest.model.asset;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.annotation.AnnotationResponse;
import io.metaloom.loom.rest.model.asset.info.AudioInfo;
import io.metaloom.loom.rest.model.asset.info.ConsistencyInfo;
import io.metaloom.loom.rest.model.asset.info.DocumentInfo;
import io.metaloom.loom.rest.model.asset.info.FileInfo;
import io.metaloom.loom.rest.model.asset.info.GeoLocationInfo;
import io.metaloom.loom.rest.model.asset.info.HashInfo;
import io.metaloom.loom.rest.model.asset.info.ImageInfo;
import io.metaloom.loom.rest.model.asset.info.MediaInfo;
import io.metaloom.loom.rest.model.asset.info.VideoInfo;
import io.metaloom.loom.rest.model.asset.location.AssetLocationReference;
import io.metaloom.loom.rest.model.asset.location.social.SocialInfo;
import io.metaloom.loom.rest.model.collection.CollectionResponse;
import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;
import io.metaloom.loom.rest.model.embedding.EmbeddingInfo;
import io.metaloom.loom.rest.model.tag.TagReference;

public class AssetResponse extends AbstractCreatorEditorRestResponse<AssetResponse> implements AssetModel<AssetResponse> {

	// @JsonPropertyDescription("The current processing status of the asset.")
	// private AssetProcessStatus processStatus;
	//
	// @JsonPropertyDescription("The specific identified kind of asset.")
	// private AssetKind kind;

	// @JsonPropertyDescription("Times the asset has been viewed.")
	// private long views;

	@JsonPropertyDescription("The GPS location of the asset.")
	private GeoLocationInfo geo;

	// @JsonPropertyDescription("Licenses related to the asset.")
	// private List<LicenseInfo> licenses = new ArrayList<>();

	@JsonPropertyDescription("Information about reactions and ratings of the asset")
	private SocialInfo social;

	@JsonPropertyDescription("A list of tags on the asset.")
	private List<TagReference> tags = new ArrayList<>();

	@JsonPropertyDescription("Annotations on areas of the asset.")
	private List<AnnotationResponse> annotations = new ArrayList<>();

	@JsonPropertyDescription("List of collections to which the asset has been added")
	private List<CollectionResponse> collections = new ArrayList<>();

	@JsonPropertyDescription
	private List<EmbeddingInfo> embeddings = new ArrayList<>();

	@JsonPropertyDescription("Information about the asset file.")
	private FileInfo file;

	@JsonPropertyDescription("Information about consistency checks on the the asset.")
	private ConsistencyInfo consistency;

	@JsonPropertyDescription("A set of different computed hashes for the asset.")
	private HashInfo hashes;

	@JsonPropertyDescription("Information about common media properties (e.g. duration, dimension)")
	private MediaInfo media;

	@JsonPropertyDescription("Information about the image component of the asset (if present)")
	private ImageInfo image;

	@JsonPropertyDescription("Information about the video component of the asset (if present)")
	private VideoInfo video;

	@JsonPropertyDescription("Information about the audio component of the asset (if present)")
	private AudioInfo audio;

	@JsonPropertyDescription("Information about the document (text) component of the asset (if present)")
	private DocumentInfo document;

	// @JsonPropertyDescription("S3 meta information on the asset. (only set when S3 is being utilized).")
	// private AssetS3Meta s3;

	@JsonPropertyDescription("Information about the actual binary media that is represented by the asset.")
	private List<AssetLocationReference> locations = new ArrayList<>();

	// public AssetKind getKind() {
	// return kind;
	// }
	//
	// public AssetResponse setKind(AssetKind kind) {
	// this.kind = kind;
	// return this;
	// }
	//
	// public AssetProcessStatus getProcessStatus() {
	// return processStatus;
	// }
	//
	// public AssetResponse setProcessStatus(AssetProcessStatus processStatus) {
	// this.processStatus = processStatus;
	// return this;
	// }

	public List<AnnotationResponse> getAnnotations() {
		return annotations;
	}

	public AssetResponse setAnnotations(List<AnnotationResponse> annotations) {
		this.annotations = annotations;
		return this;
	}

	@Override
	public GeoLocationInfo getGeo() {
		return geo;
	}

	@Override
	public AssetResponse setGeo(GeoLocationInfo geo) {
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

	// public List<LicenseInfo> getLicenses() {
	// return licenses;
	// }
	//
	// public void setLicenses(List<LicenseInfo> licenses) {
	// this.licenses = licenses;
	// }

	public List<CollectionResponse> getCollections() {
		return collections;
	}

	public AssetResponse setCollections(List<CollectionResponse> collections) {
		this.collections = collections;
		return this;
	}

	public List<EmbeddingInfo> getEmbeddings() {
		return embeddings;
	}

	public AssetResponse setEmbeddings(List<EmbeddingInfo> embeddings) {
		this.embeddings = embeddings;
		return this;
	}

	@Override
	public FileInfo getFile() {
		return file;
	}

	@Override
	public AssetResponse setFile(FileInfo file) {
		this.file = file;
		return this;
	}

	@Override
	public MediaInfo getMedia() {
		return media;
	}

	@Override
	public AssetResponse setMedia(MediaInfo media) {
		this.media = media;
		return this;
	}

	@Override
	public ConsistencyInfo getConsistency() {
		return consistency;
	}

	@Override
	public AssetResponse setConsistency(ConsistencyInfo consistency) {
		this.consistency = consistency;
		return this;
	}

	@Override
	public HashInfo getHashes() {
		return hashes;
	}

	@Override
	public AssetResponse setHashes(HashInfo hashes) {
		this.hashes = hashes;
		return this;
	}

	@Override
	public AudioInfo getAudio() {
		return audio;
	}

	@Override
	public AssetResponse setAudio(AudioInfo audio) {
		this.audio = audio;
		return this;
	}

	@Override
	public ImageInfo getImage() {
		return image;
	}

	@Override
	public AssetResponse setImage(ImageInfo image) {
		this.image = image;
		return this;
	}

	@Override
	public VideoInfo getVideo() {
		return video;
	}

	@Override
	public AssetResponse setVideo(VideoInfo video) {
		this.video = video;
		return this;
	}

	@Override
	public DocumentInfo getDocument() {
		return document;
	}

	@Override
	public AssetResponse setDocument(DocumentInfo document) {
		this.document = document;
		return this;
	}

	public List<AssetLocationReference> getLocations() {
		return locations;
	}

	public AssetResponse setLocations(List<AssetLocationReference> locations) {
		this.locations = locations;
		return this;
	}

	public void addLocation(AssetLocationReference location) {
		getLocations().add(location);
	}

	public SocialInfo getSocial() {
		return social;
	}

	public AssetResponse setSocial(SocialInfo social) {
		this.social = social;
		return this;
	}

	@Override
	public AssetResponse self() {
		return this;
	}
}
