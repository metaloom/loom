package io.metaloom.loom.rest.model.asset;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.metaloom.loom.rest.model.RestModel;

/**
 * Longitude and latitude information of the asset. (e.g. extracted Photo GPS information)
 */
public class AssetGeoLocation implements RestModel {

	@JsonPropertyDescription("The longitude in decimal degrees.")
	private Double lon;

	@JsonPropertyDescription("The latitude in decimal degrees.")
	private Double lat;

	@JsonPropertyDescription("Alias name for the location.")
	private String alias;

	public double getLon() {
		return lon;
	}

	public AssetGeoLocation setLon(Double lon) {
		this.lon = lon;
		return this;
	}

	public double getLat() {
		return lat;
	}

	public AssetGeoLocation setLat(Double lat) {
		this.lat = lat;
		return this;
	}

	public String getAlias() {
		return alias;
	}

	public AssetGeoLocation setAlias(String alias) {
		this.alias = alias;
		return this;
	}
}
