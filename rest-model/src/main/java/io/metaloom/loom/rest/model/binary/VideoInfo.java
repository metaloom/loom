package io.metaloom.loom.rest.model.binary;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.asset.video.Embeddings;

public class VideoInfo {

	@JsonPropertyDescription("The duration of the media in milliseconds.")
	private long duration;

	@JsonPropertyDescription("The video width in pixel of the asset.")
	private int width;

	@JsonPropertyDescription("The video height in pixel of the asset.")
	private int height;

	@JsonPropertyDescription("The digital fingerprint of the media.")
	private String fingerprint;

	private Embeddings embeddings;

	public long getDuration() {
		return duration;
	}

	public VideoInfo setDuration(long duration) {
		this.duration = duration;
		return this;
	}

	public int getWidth() {
		return width;
	}

	public VideoInfo setWidth(int width) {
		this.width = width;
		return this;
	}

	public int getHeight() {
		return height;
	}

	public VideoInfo setHeight(int height) {
		this.height = height;
		return this;
	}

	public String getFingerprint() {
		return fingerprint;
	}

	public VideoInfo setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
		return this;
	}

	public Embeddings getEmbeddings() {
		return embeddings;
	}

	public VideoInfo setEmbeddings(Embeddings embeddings) {
		this.embeddings = embeddings;
		return this;
	}

}
