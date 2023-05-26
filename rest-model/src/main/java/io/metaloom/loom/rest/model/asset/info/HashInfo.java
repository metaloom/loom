package io.metaloom.loom.rest.model.asset.info;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestModel;

public class HashInfo implements RestModel {

	@JsonPropertyDescription("SHA512 checksum of the asset.")
	private String sha512;

	@JsonPropertyDescription("SHA256 checksum of the asset.")
	private String sha256;

	@JsonPropertyDescription("MD5 checksum of the asset.")
	private String md5;

	public HashInfo() {
	}

	public String getSha512() {
		return sha512;
	}

	public HashInfo setSha512(String sha512) {
		this.sha512 = sha512;
		return this;
	}

	public String getSha256() {
		return sha256;
	}

	public HashInfo setSha256(String sha256) {
		this.sha256 = sha256;
		return this;
	}

	public String getMD5() {
		return md5;
	}

	public HashInfo setMD5(String md5) {
		this.md5 = md5;
		return this;
	}

}
