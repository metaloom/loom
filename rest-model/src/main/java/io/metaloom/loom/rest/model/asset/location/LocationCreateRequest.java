package io.metaloom.loom.rest.model.asset.location;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestRequestModel;

public class LocationCreateRequest implements RestRequestModel {

	@JsonPropertyDescription("Information about the location of the asset in the filesystem.")
	private LocationFilesystemInfo filesystem;

	@JsonPropertyDescription("S3 meta information on the asset. (only set when S3 is being utilized).")
	private AssetS3Meta s3;

	public LocationFilesystemInfo getFilesystem() {
		return filesystem;
	}

	public LocationCreateRequest setFilesystem(LocationFilesystemInfo filesystem) {
		this.filesystem = filesystem;
		return this;
	}

	public AssetS3Meta getS3() {
		return s3;
	}

	public LocationCreateRequest setS3(AssetS3Meta s3) {
		this.s3 = s3;
		return this;
	}
}
