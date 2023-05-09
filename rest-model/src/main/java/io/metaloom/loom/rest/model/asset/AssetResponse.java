package io.metaloom.loom.rest.model.asset;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.annotation.AnnotationResponse;
import io.metaloom.loom.rest.model.asset.license.LicenseInfo;
import io.metaloom.loom.rest.model.asset.social.SocialInfo;
import io.metaloom.loom.rest.model.binary.BinaryResponse;
import io.metaloom.loom.rest.model.collection.CollectionResponse;
import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;
import io.metaloom.loom.rest.model.tag.TagReference;

public class AssetResponse extends AbstractCreatorEditorRestResponse<AssetResponse> {

	@JsonPropertyDescription("The current processing status of the asset.")
	private AssetProcessStatus processStatus;

	@JsonPropertyDescription("The specific identified kind of asset.")
	private AssetKind kind;

	@JsonPropertyDescription("Information about the actual binary media that is represented by the asset.")
	private BinaryResponse binary = new BinaryResponse();

	@JsonPropertyDescription("The filename for the asset.")
	private String filename;

	@JsonPropertyDescription("The mime type of the asset. (e.g. video/mp4)")
	private String mimeType;

	@JsonPropertyDescription("Times the asset has been viewed.")
	private long views;

	@JsonPropertyDescription("Information about the location of the asset in the filesystem.")
	private AssetFilesystemLocation location;

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

	public AssetResponse() {
	}

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

	public BinaryResponse getBinary() {
		return binary;
	}

	public AssetResponse setBinary(BinaryResponse binary) {
		this.binary = binary;
		return this;
	}

	public AssetFilesystemLocation getLocation() {
		return location;
	}

	public AssetResponse setLocation(AssetFilesystemLocation location) {
		this.location = location;
		return this;
	}

	public List<LicenseInfo> getLicenses() {
		return licenses;
	}

	public void setLicenses(List<LicenseInfo> licenses) {
		this.licenses = licenses;
	}

	@Override
	public AssetResponse self() {
		return this;
	}

	public List<CollectionResponse> getCollections() {
		return collections;
	}

	public AssetResponse setCollections(List<CollectionResponse> collections) {
		this.collections = collections;
		return this;
	}

}
