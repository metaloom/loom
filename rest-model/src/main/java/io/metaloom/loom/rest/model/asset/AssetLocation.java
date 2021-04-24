package io.metaloom.loom.rest.model.asset;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestModel;

/**
 * Longitude and latitude information of the asset. (e.g. extracted Photo GPS information)
 */
public class AssetLocation implements RestModel {

	@JsonPropertyDescription("The longitude in decimal degrees.")
	private double lon;

	@JsonPropertyDescription("The latitude in decimal degrees.")
	private double lat;

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}
}
