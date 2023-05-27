package io.metaloom.loom.rest.model.asset.info;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestModel;
import io.metaloom.loom.rest.model.asset.location.video.Embeddings;

public class VideoInfo implements RestModel {

	@JsonPropertyDescription("The digital fingerprint of the media.")
	private String fingerprint;

	private Embeddings embeddings;

	private Integer bitrate;

	private String encoding;

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
