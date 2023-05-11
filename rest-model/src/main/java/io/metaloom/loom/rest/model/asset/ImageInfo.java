package io.metaloom.loom.rest.model.asset;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.asset.location.LocationResponse;

public class ImageInfo {

	@JsonPropertyDescription("The image width in pixel of the asset.")
	private int width;

	@JsonPropertyDescription("The image height in pixel of the asset.")
	private int height;

	@JsonPropertyDescription("The dominant color for the asset.")
	private String dominantColor;

	public int getWidth() {
		return width;
	}

	public ImageInfo setWidth(int width) {
		this.width = width;
		return this;
	}

	public int getHeight() {
		return height;
	}

	public ImageInfo setHeight(int height) {
		this.height = height;
		return this;
	}

	public String getDominantColor() {
		return dominantColor;
	}

	public ImageInfo setDominantColor(String dominantColor) {
		this.dominantColor = dominantColor;
		return this;
	}

}
