package io.metaloom.loom.db.model.asset.impl;

import io.metaloom.loom.db.model.AbstractLoomElement;
import io.metaloom.loom.db.model.asset.AssetBinary;

public class AssetBinaryImpl extends AbstractLoomElement implements AssetBinary {

	private String sha512sum;
	private String sha256sum;
	private String md5sum;
	private Integer mediaHeight;
	private Integer mediaWidth;
	private String fingerprint;
	private Long size;

	@Override
	public String getSHA512() {
		return sha512sum;
	}

	@Override
	public AssetBinary setSHA512(String hashsum) {
		this.sha512sum = hashsum;
		return this;
	}

	@Override
	public String getSHA256() {
		return sha256sum;
	}

	@Override
	public AssetBinary setSHA256(String hashsum) {
		this.sha256sum = hashsum;
		return this;
	}

	@Override
	public String getMD5() {
		return md5sum;
	}

	@Override
	public AssetBinary setMD5(String hashsum) {
		this.md5sum = hashsum;
		return this;
	}

	@Override
	public Integer getMediaWidth() {
		return mediaWidth;
	}

	@Override
	public AssetBinary setMediaWidth(Integer width) {
		this.mediaWidth = width;
		return this;
	}

	@Override
	public Integer getMediaHeight() {
		return mediaHeight;
	}

	@Override
	public AssetBinary setMediaHeight(Integer height) {
		this.mediaHeight = height;
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
