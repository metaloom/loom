package io.metaloom.loom.db.asset;

import java.util.UUID;

import io.metaloom.loom.db.model.asset.AssetBinary;

public class FsAssetBinaryImpl implements AssetBinary {

	private UUID uuid;

	private String sha512;

	private String sha256;

	private String md5;

	private Integer width;

	private Integer height;

	private String fingerprint;

	private long size;

	@Override
	public UUID getUuid() {
		return uuid;
	}

	@Override
	public AssetBinary setUuid(UUID uuid) {
		this.uuid = uuid;
		return this;
	}

	@Override
	public String getSHA512() {
		return sha512;
	}

	@Override
	public AssetBinary setSHA512(String hashsum) {
		this.sha512 = hashsum;
		return this;
	}

	@Override
	public String getSHA256() {
		return sha256;
	}

	@Override
	public AssetBinary setSHA256(String hashsum) {
		this.sha256 = hashsum;
		return this;
	}

	@Override
	public String getMD5() {
		return md5;
	}

	@Override
	public AssetBinary setMD5(String hashsum) {
		this.md5 = hashsum;
		return this;
	}

	@Override
	public Integer getMediaWidth() {
		return width;
	}

	@Override
	public AssetBinary setMediaWidth(Integer width) {
		this.width = width;
		return this;
	}

	@Override
	public Integer getMediaHeight() {
		return height;
	}

	@Override
	public AssetBinary setMediaHeight(Integer height) {
		this.height = height;
		return this;
	}

	@Override
	public String getFingerprint() {
		return fingerprint;
	}

	@Override
	public AssetBinary setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
		return this;
	}

	@Override
	public long getSize() {
		return size;
	}

	@Override
	public AssetBinary setSize(long size) {
		this.size = size;
		return this;
	}

}
