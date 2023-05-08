package io.metaloom.loom.rest.model.binary;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.asset.HashInfo;
import io.metaloom.loom.rest.model.common.AbstractCreatorEditorRestResponse;

public class BinaryResponse extends AbstractCreatorEditorRestResponse<BinaryResponse> {

	@JsonPropertyDescription("A set of different computed hashes for the asset.")
	private HashInfo hashes;

	@JsonPropertyDescription("Information about the image component of the asset (if present)")
	private ImageInfo image;

	@JsonPropertyDescription("Information about the video component of the asset (if present)")
	private VideoInfo video;

	@JsonPropertyDescription("Information about the audio component of the asset (if present)")
	private AudioInfo audio;

	private String origin;

	@JsonProperty(required = true)
	@JsonPropertyDescription("ISO8601 formatted editing date string.")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	private Date firstSeen;

	@JsonPropertyDescription("The size of the asset in bytes.")
	private long size;

	// @JsonPropertyDescription("S3 meta information on the asset. (only set when S3 is being utilized).")
	// private AssetS3Meta s3;

	public HashInfo getHashes() {
		return hashes;
	}

	public BinaryResponse setHashes(HashInfo hashes) {
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

	public long getSize() {
		return size;
	}

	public BinaryResponse setSize(long size) {
		this.size = size;
		return this;
	}

	public Date getFirstSeen() {
		return firstSeen;
	}

	public BinaryResponse setFirstSeen(Date firstSeen) {
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

	@Override
	public BinaryResponse self() {
		return this;
	}
}
