package io.metaloom.loom.rest.model.asset;

/**
 * Longitude and latitude information of the asset. (e.g. extracted Photo GPS information)
 */
public class AssetLocation {

	private double lon;

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
