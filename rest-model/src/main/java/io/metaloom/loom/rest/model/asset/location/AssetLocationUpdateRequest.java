package io.metaloom.loom.rest.model.asset.location;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.MetaModel;
import io.metaloom.loom.rest.model.RestRequestModel;
import io.vertx.core.json.JsonObject;

public class AssetLocationUpdateRequest implements RestRequestModel, MetaModel<AssetLocationUpdateRequest> {

	@JsonPropertyDescription("Information about the location of the asset in the filesystem.")
	private AssetLocationFilesystemInfo filesystem;

	@JsonPropertyDescription("S3 meta information on the asset. (only set when S3 is being utilized).")
	private AssetS3Meta s3;

	@JsonProperty(required = false)
	@JsonPropertyDescription("Additional custom meta properties for the element.")
	private JsonObject meta;

	@Override
	public JsonObject getMeta() {
		return meta;
	}

	@Override
	public AssetLocationUpdateRequest setMeta(JsonObject meta) {
		this.meta = meta;
		return this;
	}

	public AssetLocationFilesystemInfo getFilesystem() {
		return filesystem;
	}

	public AssetLocationUpdateRequest setFilesystem(AssetLocationFilesystemInfo filesystem) {
		this.filesystem = filesystem;
		return this;
	}

	public AssetS3Meta getS3() {
		return s3;
	}

	public AssetLocationUpdateRequest setS3(AssetS3Meta s3) {
		this.s3 = s3;
		return this;
	}

	@Override
	public AssetLocationUpdateRequest self() {
		return this;
	}

}
