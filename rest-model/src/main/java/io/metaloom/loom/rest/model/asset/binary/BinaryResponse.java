package io.metaloom.loom.rest.model.asset.binary;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.asset.AssetHash;
import io.metaloom.loom.rest.model.asset.AssetResponse;
import io.metaloom.loom.rest.model.asset.AssetS3Meta;

public class BinaryResponse {

	@JsonPropertyDescription("A set of different computed hashes for the asset.")
	private AssetHash hashes;

	@JsonPropertyDescription("Information about the image component of the asset (if present)")
	private ImageInfo image;

	@JsonPropertyDescription("Information about the video component of the asset (if present)")
	private VideoInfo video;

	@JsonPropertyDescription("Information about the audio component of the asset (if present)")
	private AudioInfo audio;

	private String origin;

	@JsonProperty(required = true)
	@JsonPropertyDescription("ISO8601 formatted editing date string.")
	private String firstSeen;

	@JsonPropertyDescription("The size of the asset in bytes.")
	private long size;

	@JsonPropertyDescription("Custom meta properties for the binary.")
	private Map<String, String> meta;

	// @JsonPropertyDescription("S3 meta information on the asset. (only set when S3 is being utilized).")
	// private AssetS3Meta s3;

	public AssetHash getHashes() {
		return hashes;
	}

	public BinaryResponse setHashes(AssetHash hashes) {
		this.hashes = hashes;
		return this;
	}

	public AudioInfo getAudio() {
		return audio;
	}

	public BinaryResponse setAudio(AudioInfo audio) {
		this.audio = audio;
		return this;
	}

	public ImageInfo getImage() {
		return image;
	}

	public BinaryResponse setImage(ImageInfo image) {
		this.image = image;
		return this;
	}

	public VideoInfo getVideo() {
		return video;
	}

	public BinaryResponse setVideo(VideoInfo video) {
		this.video = video;
		return this;
	}

	public Map<String, String> getMeta() {
		return meta;
	}

	public BinaryResponse setMeta(Map<String, String> meta) {
		this.meta = meta;
		return this;
	}

	public long getSize() {
		return size;
	}

	public BinaryResponse setSize(long size) {
		this.size = size;
		return this;
	}

	public String getFirstSeen() {
		return firstSeen;
	}

	public BinaryResponse setFirstSeen(String firstSeen) {
		this.firstSeen = firstSeen;
		return this;
	}

	public String getOrigin() {
		return origin;
	}

	public BinaryResponse setOrigin(String origin) {
		this.origin = origin;
		return this;
	}
}
