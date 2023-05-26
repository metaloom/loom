package io.metaloom.loom.rest.model.asset.location;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestRequestModel;
import io.metaloom.loom.rest.model.common.AbstractMetaModel;

public class AssetLocationCreateRequest extends AbstractMetaModel<AssetLocationCreateRequest> implements RestRequestModel {

	private UUID assetUuid;

	private UUID libraryUuid;

	@JsonPropertyDescription("Information about the location of the asset in the filesystem.")
	private AssetLocationFilesystemInfo filesystem;

	@JsonPropertyDescription("S3 meta information on the asset. (only set when S3 is being utilized).")
	private AssetS3Meta s3;

	public UUID getAssetUuid() {
		return assetUuid;
	}

	public AssetLocationCreateRequest setAssetUuid(UUID assetUuid) {
		this.assetUuid = assetUuid;
		return this;
	}

	public UUID getLibraryUuid() {
		return libraryUuid;
	}

	public AssetLocationCreateRequest setLibraryUuid(UUID libraryUuid) {
		this.libraryUuid = libraryUuid;
		return this;
	}

	public AssetLocationFilesystemInfo getFilesystem() {
		return filesystem;
	}

	public AssetLocationCreateRequest setFilesystem(AssetLocationFilesystemInfo filesystem) {
		this.filesystem = filesystem;
		return this;
	}

	public AssetS3Meta getS3() {
		return s3;
	}

	public AssetLocationCreateRequest setS3(AssetS3Meta s3) {
		this.s3 = s3;
		return this;
	}

	@Override
	public AssetLocationCreateRequest self() {
		return this;
	}
}
