package io.metaloom.loom.rest.model.asset.info;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestModel;

public class AudioInfo implements RestModel {

	private Integer channels;

	private String encoding;

	private Integer bitrate;

	private Integer samplingRate;

	private Integer bpm;

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

	public Integer getBitrate() {
		return bitrate;
	}

	public AudioInfo setBitrate(Integer bitrate) {
		this.bitrate = bitrate;
		return this;
	}

}
