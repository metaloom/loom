package io.metaloom.loom.rest.model.asset.social;

import java.util.HashMap;
import java.util.Map;

public class SocialInfo {

	private Rating rating = new Rating();

	private Map<Reaction, Long> reactions = new HashMap<>();

	public Rating getRating() {
		return rating;
	}

	public SocialInfo setRating(Rating rating) {
		this.rating = rating;
		return this;
	}

	public Map<Reaction, Long> getReactions() {
		return reactions;
	}

	public void setReactions(Map<Reaction, Long> reactions) {
		this.reactions = reactions;
	}
}
