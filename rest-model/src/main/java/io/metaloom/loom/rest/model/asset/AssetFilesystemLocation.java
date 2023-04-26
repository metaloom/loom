package io.metaloom.loom.rest.model.asset;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class AssetFilesystemLocation {

	@JsonPropertyDescription("Current path to the file")
	private String path;

	@JsonPropertyDescription("Linux filesystem key which identifies the file in the filesystem")
	private FileKey filekey;

	@JsonPropertyDescription("ISO8601 formatted date string when the asset was last seen online.")
	private String lastSeen;

	public String getPath() {
		return path;
	}

	public AssetFilesystemLocation setPath(String path) {
		this.path = path;
		return this;
	}

	public FileKey getFilekey() {
		return filekey;
	}

	public AssetFilesystemLocation setFilekey(FileKey filekey) {
		this.filekey = filekey;
		return this;
	}

	public String getLastSeen() {
		return lastSeen;
	}

	public AssetFilesystemLocation setLastSeen(String lastSeen) {
		this.lastSeen = lastSeen;
		return this;
	}
}
