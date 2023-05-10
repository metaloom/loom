package io.metaloom.loom.rest.model.annotation;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

/**
 * Spatial or temporal area used to annotate the asset.
 */
public class AreaInfo {

	@JsonPropertyDescription("Start time of the entry in milliseconds")
	private long from;

	@JsonPropertyDescription("End time of the entry in milliseconds")
	private long to;

	private int width;
	private int height;
	private int startX;
	private int startY;

	public int getWidth() {
		return width;
	}

	public AreaInfo setWidth(int width) {
		this.width = width;
		return this;
	}

	public int getHeight() {
		return height;
	}

	public AreaInfo setHeight(int height) {
		this.height = height;
		return this;
	}

	public int getStartX() {
		return startX;
	}

	public AreaInfo setStartX(int startX) {
		this.startX = startX;
		return this;
	}

	public int getStartY() {
		return startY;
	}

	public AreaInfo setStartY(int startY) {
		this.startY = startY;
		return this;
	}
	
	public long getFrom() {
		return from;
	}

	public AreaInfo setFrom(long from) {
		this.from = from;
		return this;
	}

	public long getTo() {
		return to;
	}

	public AreaInfo setTo(long to) {
		this.to = to;
		return this;
	}
}
