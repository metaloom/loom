package io.metaloom.loom.rest.model.asset.info;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestModel;

public class ImageInfo implements RestModel {

	@JsonPropertyDescription("The dominant color for the asset.")
	private String dominantColor;

	public String getDominantColor() {
		return dominantColor;
	}

	public ImageInfo setDominantColor(String dominantColor) {
		this.dominantColor = dominantColor;
		return this;
	}

}
