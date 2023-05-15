package io.metaloom.loom.rest.model.asset;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.asset.location.video.Embeddings;

public class VideoInfo {

	@JsonPropertyDescription("The duration of the media in milliseconds.")
	private Long duration;

	@JsonPropertyDescription("The video width in pixel of the asset.")
	private Integer width;

	@JsonPropertyDescription("The video height in pixel of the asset.")
	private Integer height;

	@JsonPropertyDescription("The digital fingerprint of the media.")
	private String fingerprint;

	private Embeddings embeddings;

	private Integer bitrate;

	private String encoding;

	public Long getDuration() {
		return duration;
	}

	public VideoInfo setDuration(Long duration) {
		this.duration = duration;
		return this;
	}

	public Integer getWidth() {
		return width;
	}

	public VideoInfo setWidth(Integer width) {
		this.width = width;
		return this;
	}

	public Integer getHeight() {
		return height;
	}

	public VideoInfo setHeight(Integer height) {
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

	public String getEncoding() {
		return encoding;
	}

	public VideoInfo setEncoding(String encoding) {
		this.encoding = encoding;
		return this;
	}

	public Integer getBitrate() {
		return bitrate;
	}

	public VideoInfo setBitrate(Integer bitrate) {
		this.bitrate = bitrate;
		return this;
	}

}
