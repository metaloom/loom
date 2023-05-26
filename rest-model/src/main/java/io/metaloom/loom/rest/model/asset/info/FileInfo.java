package io.metaloom.loom.rest.model.asset.info;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestModel;

public class FileInfo implements RestModel {

	private String mimeType;

	@JsonPropertyDescription("The filename for the asset.")
	private String filename;

	@JsonPropertyDescription("The size of the asset in bytes.")
	private long size;

	public String getMimeType() {
		return mimeType;
	}

	public FileInfo setMimeType(String mimeType) {
		this.mimeType = mimeType;
		return this;
	}

	public String getFilename() {
		return filename;
	}

	public FileInfo setFilename(String fileName) {
		this.filename = fileName;
		return this;
	}

	public long getSize() {
		return size;
	}

	public FileInfo setSize(long size) {
		this.size = size;
		return this;
	}
}
