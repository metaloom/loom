package io.metaloom.loom.rest.model.asset.info;

import io.metaloom.loom.rest.model.RestModel;

public class VideoInfo implements RestModel {

	private Integer bitrate;

	private String encoding;

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
