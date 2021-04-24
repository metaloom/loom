package io.metaloom.loom.rest.model.asset;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestModel;

public class AssetS3Meta implements RestModel {

	@JsonPropertyDescription("The id of the s3 bucket in which the asset is stored.")
	private String bucket;

	@JsonPropertyDescription("The key to the asset within the s3 bucket.")
	private String key;

	public AssetS3Meta() {
	}

	public String getBucket() {
		return bucket;
	}

	public AssetS3Meta setBucket(String bucket) {
		this.bucket = bucket;
		return this;
	}

	public String getKey() {
		return key;
	}

	public AssetS3Meta setKey(String key) {
		this.key = key;
		return this;
	}
}
