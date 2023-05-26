package io.metaloom.loom.rest.model.asset.info;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestModel;

public class AudioInfo implements RestModel {

	@JsonPropertyDescription("The duration of the media in milliseconds.")
	private Long duration;

	private Integer channels;

	private String encoding;

	private Integer bitrate;

	private Integer samplingRate;

	private Integer bpm;

	@JsonPropertyDescription("The digital fingerprint of the media.")
	private String fingerprint;

	public Long getDuration() {
		return duration;
	}

	public AudioInfo setDuration(Long duration) {
		this.duration = duration;
		return this;
	}

	public Integer getChannels() {
		return channels;
	}

	public AudioInfo setChannels(Integer channels) {
		this.channels = channels;
		return this;
	}

	public Integer getSamplingRate() {
		return samplingRate;
	}

	public AudioInfo setSamplingRate(Integer samplingRate) {
		this.samplingRate = samplingRate;
		return this;
	}

	public Integer getBpm() {
		return bpm;
	}

	public AudioInfo setBpm(Integer bpm) {
		this.bpm = bpm;
		return this;
	}

	public String getEncoding() {
		return encoding;
	}

	public AudioInfo setEncoding(String encoding) {
		this.encoding = encoding;
		return this;
	}

	public String getFingerprint() {
		return fingerprint;
	}

	public AudioInfo setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
		return this;
	}

	public Integer getBitrate() {
		return bitrate;
	}

	public AudioInfo setBitrate(Integer bitrate) {
		this.bitrate = bitrate;
		return this;
	}

}
