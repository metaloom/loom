package io.metaloom.loom.rest.model.asset;

public class AssetS3Meta {

	private String bucket;

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
