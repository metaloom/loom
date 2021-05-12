package io.metaloom.loom.db.asset;

import java.util.UUID;

public class FsAssetBinaryImpl implements LoomAssetBinary {

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
	public LoomAssetBinary setUuid(UUID uuid) {
		this.uuid = uuid;
		return this;
	}

	@Override
	public String getSHA512() {
		return sha512;
	}

	@Override
	public LoomAssetBinary setSHA512(String hashsum) {
		this.sha512 = hashsum;
		return this;
	}

	@Override
	public String getSHA256() {
		return sha256;
	}

	@Override
	public LoomAssetBinary setSHA256(String hashsum) {
		this.sha256 = hashsum;
		return this;
	}

	@Override
	public String getMD5() {
		return md5;
	}

	@Override
	public LoomAssetBinary setMD5(String hashsum) {
		this.md5 = hashsum;
		return this;
	}

	@Override
	public Integer getMediaWidth() {
		return width;
	}

	@Override
	public LoomAssetBinary setMediaWidth(Integer width) {
		this.width = width;
		return this;
	}

	@Override
	public Integer getMediaHeight() {
		return height;
	}

	@Override
	public LoomAssetBinary setMediaHeight(Integer height) {
		this.height = height;
		return this;
	}

	@Override
	public String getFingerprint() {
		return fingerprint;
	}

	@Override
	public LoomAssetBinary setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
		return this;
	}

	@Override
	public long getSize() {
		return size;
	}

	@Override
	public LoomAssetBinary setSize(long size) {
		this.size = size;
		return this;
	}

}
