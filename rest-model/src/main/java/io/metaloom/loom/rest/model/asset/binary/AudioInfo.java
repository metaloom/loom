package io.metaloom.loom.rest.model.asset.binary;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class AudioInfo {

	@JsonPropertyDescription("The duration of the media in milliseconds.")
	private long duration;

	private int channels;

	private String encoding;

	private long samplingRate;

	private int bpm;
	
	@JsonPropertyDescription("The digital fingerprint of the media.")
	private String fingerprint;

	public long getDuration() {
		return duration;
	}

	public AudioInfo setDuration(long duration) {
		this.duration = duration;
		return this;
	}

	public int getChannels() {
		return channels;
	}

	public AudioInfo setChannels(int channels) {
		this.channels = channels;
		return this;
	}

	public long getSamplingRate() {
		return samplingRate;
	}

	public AudioInfo setSamplingRate(long samplingRate) {
		this.samplingRate = samplingRate;
		return this;
	}

	public int getBpm() {
		return bpm;
	}

	public AudioInfo setBpm(int bpm) {
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

}
